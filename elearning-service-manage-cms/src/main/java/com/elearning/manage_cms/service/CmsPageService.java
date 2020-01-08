package com.elearning.manage_cms.service;

import com.elearning.framework.cms.CmsPage;
import com.elearning.framework.cms.CmsSite;
import com.elearning.framework.cms.CmsTemplate;
import com.elearning.framework.cms.response.CmsAdditionalData;
import com.elearning.framework.exception.MangoException;
import com.elearning.framework.page.PageResult;
import com.elearning.manage_cms.dao.CmsPageDao;
import com.elearning.manage_cms.dao.CmsSiteDao;
import com.elearning.manage_cms.dao.CmsTemplateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CmsPageService {
    @Autowired
    private CmsPageDao cmsPageDao;
    @Autowired
    private CmsSiteDao cmsSiteDao;
    @Autowired
    private CmsTemplateDao cmsTemplateDao;

    /**
     * 页面列表分页查询
     *
     * @param pageable 分页参数
     * @param aliase
     * @param type
     * @return
     */
    public PageResult findPage(Pageable pageable, String aliase, String type) {
        //条件处理
        Example<CmsPage> example = conditionProcessing(aliase, type);
        //分页查询
        Page<CmsPage> all = cmsPageDao.findAll(example, pageable);

        //查出页面表中的所有站点ID
        List<String> strings = new ArrayList<>();
        for (CmsPage cmsPage : all.getContent()) {
            strings.add(cmsPage.getSiteId());
        }
        List<CmsSite> cmsSites = cmsSiteDao.findAll();
        List<CmsAdditionalData> list = new ArrayList<>();
        for (CmsSite cmsSite : cmsSites) {
            CmsAdditionalData cmsAdditionalData = new CmsAdditionalData();
            List<CmsTemplate> cmsTemplates = cmsTemplateDao.findBySiteId(cmsSite.getSiteId());
            cmsAdditionalData.setSiteId(cmsSite.getSiteId());
            cmsAdditionalData.setSiteName(cmsSite.getSiteName());
            cmsAdditionalData.setCmsTemplates(cmsTemplates);
            list.add(cmsAdditionalData);
        }

        //返回数据处理
        return returnDataProcessing(all, list, pageable);
    }


    /**
     * 新增与编辑
     *
     * @param cmsPage
     */
    public void save(CmsPage cmsPage) {
        if (null == cmsPage.getPageId()) {
            //新增
            //校验页面是否存在，根据页面名称、站点Id、页面webpath查询
            CmsPage cmsPage1 = cmsPageDao.findByPageNameAndSiteIdAndPageWebPath(cmsPage.getPageName(), cmsPage.getSiteId(), cmsPage.getPageWebPath());
            if (cmsPage1 == null) {
                cmsPage.setPageId(null);
                cmsPage.setPageCreateTime(LocalDateTime.now());
                //添加页面主键由spring data 自动生成
                cmsPageDao.save(cmsPage);
            } else {
                throw new MangoException("不能创建相同的页面");
            }
        } else {
            //修改
            //根据id查询页面信息
            CmsPage one = this.getById(cmsPage.getPageId());
            if (one != null) {
                //更新所属站点
                one.setSiteId(cmsPage.getSiteId());
                // 更新页面别名
                one.setPageAliase(cmsPage.getPageAliase());
                // 更新页面名称
                one.setPageName(cmsPage.getPageName());
                // 更新访问路径
                one.setPageWebPath(cmsPage.getPageWebPath());
                // 更新物理路径
                one.setPagePhysicalPath(cmsPage.getPagePhysicalPath());
                // 执行更新
                cmsPageDao.save(one);
            } else {
                throw new MangoException("不存在该页面");
            }
        }
    }

    /**
     * 删除与批量删除
     *
     * @param records
     */
    public void batchDelete(List<CmsPage> records) {
        for (CmsPage record : records) {
            CmsPage one = this.getById(record.getPageId());
            if (one != null) {
                //删除页面
                cmsPageDao.deleteById(one.getPageId());
            }else {
                throw new MangoException("删除失败");
            }
        }
    }


    private PageResult returnDataProcessing(Page<CmsPage> all, List<CmsAdditionalData> list, Pageable pageable) {
        PageResult pageResult = new PageResult();
        pageResult.setContent(all.getContent());
        pageResult.setTotalSize(all.getTotalElements());
        pageResult.setPageNum(pageable.getPageNumber());
        pageResult.setPageSize(pageable.getPageSize());
        pageResult.setTotalPages(all.getTotalPages());
        pageResult.setAdditionalData(list);
        return pageResult;
    }

    private Example<CmsPage> conditionProcessing(String aliase, String type) {
        CmsPage cmsPage = new CmsPage();
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("_id")
                .withIgnorePaths("_class")
                .withIgnorePaths("siteId")
                .withIgnorePaths("pageName")
                .withIgnorePaths("pageWebPath")
                .withIgnorePaths("pagePhysicalPath")
                .withIgnorePaths("pageCreateTime")
                .withIgnorePaths("templateId")
                .withIgnorePaths("htmlFileId");
        if (aliase.length() > 0) {
            cmsPage.setPageAliase(aliase);
            matcher = matcher.withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains()); //全部模糊查询，即%{address}%
        } else {
            matcher = matcher.withIgnoreCase("pageAliase");
        }
        if (type.length() > 0) {
            cmsPage.setPageType(type);
            matcher = matcher.withMatcher("pageType", ExampleMatcher.GenericPropertyMatchers.contains()); //全部模糊查询，即%{address}%
        } else {
            matcher = matcher.withIgnoreCase("pageType");
        }
        matcher = matcher.withIgnoreNullValues();
        Example<CmsPage> example = Example.of(cmsPage, matcher);
        return example;
    }

    //根据id查询页面
    public CmsPage getById(String id) {
        Optional<CmsPage> optional = cmsPageDao.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        //返回空
        return null;
    }
}

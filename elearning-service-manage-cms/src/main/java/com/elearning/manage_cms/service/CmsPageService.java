package com.elearning.manage_cms.service;

import com.elearning.framework.cms.CmsPage;
import com.elearning.framework.cms.request.QueryPageRequest;
import com.elearning.framework.model.response.CommonCode;
import com.elearning.framework.model.response.QueryResponseResult;
import com.elearning.framework.model.response.QueryResult;
import com.elearning.manage_cms.dao.CmsPageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CmsPageService {
    @Autowired
    private CmsPageDao cmsPageDao;

    /**
     * 页面列表分页查询
     * @param pageable 分页参数
     * @return
     */
    public QueryResponseResult findList(Pageable pageable) {
        //分页查询
        Page<CmsPage> all=cmsPageDao.findAll(pageable);
        QueryResult<CmsPage> cmsPageQueryResult=new QueryResult<>();
        cmsPageQueryResult.setList(all.getContent());
        cmsPageQueryResult.setTotal(all.getTotalElements());

        //返回结果
        return new QueryResponseResult(CommonCode.SUCCESS,cmsPageQueryResult);
    }

}

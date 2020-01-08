package com.elearning.service.api;

import com.elearning.framework.cms.CmsPage;
import com.elearning.framework.http.response.HttpResult;

import java.util.List;

public interface CmsPageControllerApi {
    /**
     * 分页查找
     * @param page
     * @param size
     * @return
     */
    HttpResult findPage(Integer page, Integer size, String aliase,String type);

    /**
     * 新增与编辑
     * @param cmsPage
     * @return
     */
    HttpResult save(CmsPage cmsPage);

    /**
     * 删除与批量删除
     * @param records
     * @return
     */
    HttpResult batchDelete(List<CmsPage> records);
}

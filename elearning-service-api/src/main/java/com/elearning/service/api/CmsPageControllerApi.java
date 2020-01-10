package com.elearning.service.api;

import com.elearning.framework.cms.CmsPage;
import com.elearning.framework.http.response.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@Api(value = "cms页面管理接口", description = "cms页面管理接口，提供页面的管理、查询接口")
public interface CmsPageControllerApi {
    @ApiOperation("分页查找")
    HttpResult findPage(Integer page, Integer size, String aliase, String type);

    @ApiOperation("新增与编辑")
    HttpResult save(CmsPage cmsPage);

    @ApiOperation("删除与批量删除")
    HttpResult batchDelete(List<CmsPage> records);
}

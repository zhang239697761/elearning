package com.elearning.manage_cms.controller;

import com.elearning.framework.model.response.QueryResponseResult;
import com.elearning.manage_cms.service.CmsPageService;
import com.elearning.service.api.CmsPageControllerApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "页面管理")
public class CmsPageController implements CmsPageControllerApi {
    @Autowired
    private CmsPageService cmsPageService;

    @Override
    @GetMapping("/pages")
    @ApiOperation("页面列表分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",value = "当前页面",defaultValue = "1"),
            @ApiImplicitParam(name = "size",value = "当前页面显示数量",defaultValue = "10")
    })
    public QueryResponseResult findList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                        @RequestParam(value = "size", defaultValue = "10") Integer size) {
        //分页对象
        Pageable pageable = PageRequest.of(page, size);
        return cmsPageService.findList(pageable);
    }
}

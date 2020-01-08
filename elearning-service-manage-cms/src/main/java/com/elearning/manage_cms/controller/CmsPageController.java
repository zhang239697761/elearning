package com.elearning.manage_cms.controller;

import com.elearning.framework.cms.CmsPage;
import com.elearning.framework.http.response.HttpResult;
import com.elearning.manage_cms.service.CmsPageService;
import com.elearning.service.api.CmsPageControllerApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(description = "页面管理")
@RequestMapping("/page")
@CrossOrigin
public class CmsPageController implements CmsPageControllerApi {
    @Autowired
    private CmsPageService cmsPageService;

    @Override
    @GetMapping("/findPage")
    @ApiOperation("页面列表分页查询")
    public HttpResult findPage(@RequestParam(name = "page") Integer page,
                               @RequestParam(name = "size") Integer size,
                               @RequestParam(name = "aliase") String aliase,
                               @RequestParam(name = "type") String type) {
        //分页对象
        Pageable pageable= PageRequest.of(Math.max(page-1,0),size);
        return HttpResult.ok(cmsPageService.findPage(pageable,aliase,type));
    }

    @Override
    @PostMapping("/save")
    @ApiOperation("新增与编辑")
    public HttpResult save(@RequestBody CmsPage cmsPage) {
        try {
            cmsPageService.save(cmsPage);
            return HttpResult.ok();
        }catch (Exception e){
            return HttpResult.error(e.getMessage());
        }
    }

    @Override
    @DeleteMapping("/batchDelete")
    @ApiOperation("删除与批量删除")
    public HttpResult batchDelete(@RequestBody List<CmsPage> records) {
        try {
            cmsPageService.batchDelete(records);
            return HttpResult.ok();
        }catch (Exception e){
            return HttpResult.error(e.getMessage());
        }
    }
}

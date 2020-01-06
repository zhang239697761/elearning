package com.elearning.manage_cms.controller;

import com.elearning.framework.cms.CmsPage;
import com.elearning.framework.cms.request.QueryPageRequest;
import com.elearning.framework.model.response.CommonCode;
import com.elearning.framework.model.response.QueryResponseResult;
import com.elearning.framework.model.response.QueryResult;
import com.elearning.service.api.CmsPageControllerApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CmsPageController implements CmsPageControllerApi {
    @Override
    @GetMapping("list/{page}/size")
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest) {
        QueryResult queryResult=new QueryResult();
        queryResult.setTotal(2);
        List list=new ArrayList();
        CmsPage cmsPage=new CmsPage();
        cmsPage.setPageName("测试页面");
        list.add(cmsPage);
        queryResult.setList(list);
        QueryResponseResult queryResponseResult=new QueryResponseResult(CommonCode.SUCCESS,queryResult);
        return queryResponseResult;
    }
}

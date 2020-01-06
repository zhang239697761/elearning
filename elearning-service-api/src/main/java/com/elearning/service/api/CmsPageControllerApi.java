package com.elearning.service.api;

import com.elearning.framework.cms.request.QueryPageRequest;
import com.elearning.framework.model.response.QueryResponseResult;

public interface CmsPageControllerApi {
    QueryResponseResult findList(Integer page, Integer size) ;
}

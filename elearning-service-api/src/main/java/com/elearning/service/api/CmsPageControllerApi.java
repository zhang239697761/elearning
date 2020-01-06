package com.elearning.service.api;

import com.elearning.framework.cms.request.QueryPageRequest;
import com.elearning.framework.model.response.QueryResponseResult;

public interface CmsPageControllerApi {
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest) ;
}

package com.elearning.framework.cms.response;

import com.elearning.framework.cms.CmsPage;
import com.elearning.framework.model.response.ResponseResult;
import com.elearning.framework.model.response.ResultCode;
import lombok.Data;

@Data
public class CmsPageResult extends ResponseResult {
    CmsPage cmsPage;
    public CmsPageResult(ResultCode resultCode,CmsPage cmsPage) {
        super(resultCode);
        this.cmsPage = cmsPage;
    }
}

package com.elearning.framework.cms.response;

import com.elearning.framework.model.response.ResponseResult;
import com.elearning.framework.model.response.ResultCode;
import lombok.Data;


@Data
public class GenerateHtmlResult extends ResponseResult {
    String html;
    public GenerateHtmlResult(ResultCode resultCode, String html) {
        super(resultCode);
        this.html = html;
    }
}

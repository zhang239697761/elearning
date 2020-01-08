package com.elearning.framework.cms.response;

import com.elearning.framework.cms.CmsTemplate;
import lombok.Data;

import java.util.List;

@Data
public class CmsAdditionalData {
    private String siteId;
    private String siteName;
    private List<CmsTemplate> cmsTemplates;
}

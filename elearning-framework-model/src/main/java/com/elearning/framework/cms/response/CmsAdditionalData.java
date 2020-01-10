package com.elearning.framework.cms.response;

import com.elearning.framework.cms.CmsTemplate;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class CmsAdditionalData {
    private String siteId;
    private String siteName;
    private List<CmsTemplate> cmsTemplates;
}

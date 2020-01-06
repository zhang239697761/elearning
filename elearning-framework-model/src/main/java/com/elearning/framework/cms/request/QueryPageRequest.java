package com.elearning.framework.cms.request;

import com.elearning.framework.model.request.RequestData;
import lombok.Data;

@Data
public class QueryPageRequest extends RequestData {
    //站点id    
     private String siteId;
    // 页面ID    
     private String pageId;
    // 页面名称    
     private String pageName;
    // 别名    
     private String pageAliase;
    // 模版id    
     private String templateId;
}

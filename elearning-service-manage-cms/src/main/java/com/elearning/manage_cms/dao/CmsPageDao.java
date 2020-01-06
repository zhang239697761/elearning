package com.elearning.manage_cms.dao;

import com.elearning.framework.cms.CmsPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CmsPageDao extends MongoRepository<CmsPage,String> {
    //根据页面名称查询    
     CmsPage findByPageName(String pageName);
    // 根据页面名称和类型查询    
     CmsPage findByPageNameAndPageType(String pageName,String pageType);
    // 根据站点和页面类型查询记录数    
     int countBySiteIdAndPageType(String siteId,String pageType);
    // 根据站点和页面类型分页查询    
     Page<CmsPage> findBySiteIdAndPageType(String siteId, String pageType, Pageable pageable);
}

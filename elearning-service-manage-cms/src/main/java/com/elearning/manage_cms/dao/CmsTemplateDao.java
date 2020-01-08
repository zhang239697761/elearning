package com.elearning.manage_cms.dao;

import com.elearning.framework.cms.CmsTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CmsTemplateDao extends MongoRepository<CmsTemplate,String> {
   List<CmsTemplate> findBySiteId(String siteId);
}

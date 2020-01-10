package com.elearning.manage_cms.dao;

import com.elearning.framework.cms.CmsConfig;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CmsConfigDao extends MongoRepository<CmsConfig,String> {
}

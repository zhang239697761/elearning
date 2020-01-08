package com.elearning.manage_cms.dao;

import com.elearning.framework.cms.CmsSite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CmsSiteDao extends MongoRepository<CmsSite,String> {
}

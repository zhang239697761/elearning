package com.elearning.manage_cms.service;

import com.elearning.framework.cms.CmsConfig;
import com.elearning.manage_cms.dao.CmsConfigDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CmsConfigService {
    @Autowired
    private CmsConfigDao cmsConfigDao;

    //根据id查询配置管理信息
    public CmsConfig getConfigById(String id) {
        Optional<CmsConfig> optional = cmsConfigDao.findById(id);
        if (optional.isPresent()) {
            CmsConfig cmsConfig = optional.get();
            return cmsConfig;
        }
        return null;
    }
}

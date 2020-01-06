package com.elearning.manage_cms;

import com.elearning.framework.cms.CmsPage;
import com.elearning.manage_cms.dao.CmsPageDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {
    @Autowired
    private CmsPageDao cmsPageDao;

    /**
     * 分页测试
     */
    @Test
    public void testFindPage(){
        int page=0;
        int size=10;
        Pageable pageable= PageRequest.of(page,size);
        Page<CmsPage> all=cmsPageDao.findAll(pageable);
        System.out.println(all+"hhhhhhhhhhhhhh");
    }
}

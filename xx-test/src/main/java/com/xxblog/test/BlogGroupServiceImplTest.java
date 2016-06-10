package com.xxblog.test;

import com.xxbase.test.SpringBaseTest;
import com.xxblog.entity.BlogCategoryEntity;
import com.xxblog.services.BlogCategoryService;
import com.xxblog.services.BlogGroupService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by admin on 16/05/16.
 */
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class BlogGroupServiceImplTest extends SpringBaseTest {

    @Autowired
    private BlogGroupService blogGroupService;

    @Test
    public void testInit(){
        blogGroupService.clear();
        blogGroupService.initBlogGroup();
    }

    @Test
    public void testPersist() {
    }

    @Test
    public void testClear(){
        blogGroupService.clear();
    }

    @Test
    public void testFindById() {
        blogGroupService.findById(1L);
        blogGroupService.findById(1L);
    }
}


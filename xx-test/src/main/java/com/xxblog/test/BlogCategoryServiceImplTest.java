package com.xxblog.test;

import com.xxbase.common.Order;
import com.xxbase.common.Page;
import com.xxbase.common.Pageable;
import com.xxbase.test.SpringBaseTest;
import com.xxblog.entity.BlogCategoryEntity;
import com.xxblog.services.BlogCategoryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by admin on 16/05/16.
 */
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class BlogCategoryServiceImplTest extends SpringBaseTest {

    @Autowired
    private BlogCategoryService blogCategoryService;

    @Test
    public void testInit(){
        blogCategoryService.clear();
        blogCategoryService.initBlogCategory();
    }

    @Test
    public void testPersist() {
        BlogCategoryEntity blogCategoryEntity = new BlogCategoryEntity();
        blogCategoryEntity.setName("1");
        blogCategoryService.persist(blogCategoryEntity);
    }

    @Test
    public void testClear(){
        blogCategoryService.clear();
    }

    @Test
    public void testFindById() {
        blogCategoryService.findById(1L);
        blogCategoryService.findById(1L);
    }

    @Test
    public void testFindPage(){
        Pageable pageable = new Pageable();
        pageable.setPageSize(2);
        pageable.setOrder("id", Order.Direction.desc);
        Page<BlogCategoryEntity> blogCategoryEntityPage = blogCategoryService.findPage(pageable);
        logger.info("count : {}", blogCategoryEntityPage.getContent().size());
        logger.info("total : {}", blogCategoryEntityPage.getTotal());
        for(BlogCategoryEntity blogCategoryEntity : blogCategoryEntityPage.getContent()){
            logger.info("id={}, name={}", blogCategoryEntity.getId(), blogCategoryEntity.getName());
        }
    }
}


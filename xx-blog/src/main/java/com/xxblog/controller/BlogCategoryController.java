package com.xxblog.controller;

import com.xxblog.entity.BlogCategoryEntity;
import com.xxblog.services.BlogCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by admin on 16/05/16.
 */
@Controller
@RequestMapping(value = "/xxblog/blog/category")
public class BlogCategoryController {

    @Autowired
    private BlogCategoryService blogCategoryService;

    @RequestMapping(value = "/persist")
    public void persist(){
        BlogCategoryEntity blogCategoryEntity = new BlogCategoryEntity();
        blogCategoryEntity.setName("1");
        blogCategoryService.persist(blogCategoryEntity);
    }

}

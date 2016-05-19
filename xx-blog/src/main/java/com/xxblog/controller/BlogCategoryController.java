package com.xxblog.controller;

import com.xxbase.params.XXResponseBody;
import com.xxblog.entity.BlogCategoryEntity;
import com.xxblog.services.BlogCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by admin on 16/05/16.
 */
@Controller
@RequestMapping(value = "/xxblog/blog/category", headers = "Accept=*/*")
public class BlogCategoryController {

    @Autowired
    private BlogCategoryService blogCategoryService;

    @ResponseBody
    @RequestMapping(value = "/persist")
    public XXResponseBody persist(){
        BlogCategoryEntity blogCategoryEntity = new BlogCategoryEntity();
        blogCategoryEntity.setName("1");
        blogCategoryService.persist(blogCategoryEntity);
        return new XXResponseBody<>();
    }

}

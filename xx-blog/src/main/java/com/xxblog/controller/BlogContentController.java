package com.xxblog.controller;

import com.xxbase.params.XXResponseBody;
import com.xxblog.entity.BlogContentEntity;
import com.xxblog.services.BlogContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by admin on 16/05/16.
 */
@Controller
@RequestMapping(value = "/xxblog/blog/content")
public class BlogContentController {

    @Autowired
    private BlogContentService blogContentService;

    @ResponseBody
    @RequestMapping(value = "/save")
    public XXResponseBody save(@RequestBody BlogContentEntity blogContentEntity){
        blogContentService.persist(blogContentEntity);
        return new XXResponseBody();
    }


    @ResponseBody
    @RequestMapping(value = "/list")
    public XXResponseBody list(){
        List<BlogContentEntity> blogContentEntityList = blogContentService.findAll();
        return new XXResponseBody(blogContentEntityList);
    }
}

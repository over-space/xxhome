package com.xxblog.controller;

import com.xxbase.common.XXResponseBody;
import com.xxblog.entity.BlogGroupEntity;
import com.xxblog.services.BlogGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by admin on 16/05/16.
 */
@Controller
@RequestMapping(value = "/xxblog/blog/group")
public class BlogGroupController {

    @Autowired
    private BlogGroupService blogGroupService;


    @ResponseBody
    @RequestMapping(value = "/persist")
    public XXResponseBody persist() {
        return new XXResponseBody();
    }

    @ResponseBody
    @RequestMapping(value = "/list")
    public XXResponseBody list(){
        List<BlogGroupEntity> result = blogGroupService.findAll();
        return new XXResponseBody(result);
    }
}

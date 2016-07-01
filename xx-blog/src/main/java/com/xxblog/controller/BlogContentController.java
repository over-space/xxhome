package com.xxblog.controller;

import com.xxbase.common.Order;
import com.xxbase.common.Page;
import com.xxbase.common.Pageable;
import com.xxbase.common.XXResponseBody;
import com.xxbase.entity.BaseEntity;
import com.xxblog.entity.BlogCategoryEntity;
import com.xxblog.entity.BlogContentEntity;
import com.xxblog.services.BlogContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
    public XXResponseBody save(@RequestBody @Valid BlogContentEntity blogContentEntity){
        String content = blogContentEntity.getContent();
        String abstracts = StringUtils.substring(content, 0, 270);
        blogContentEntity.setAbstracts(abstracts);
        blogContentService.persist(blogContentEntity);
        return new XXResponseBody();
    }

    @ResponseBody
    @RequestMapping(value = "/get")
    public XXResponseBody get(long id){
        BlogContentEntity blogContentEntity = blogContentService.findById(id);
        return new XXResponseBody(blogContentEntity);
    }

    @ResponseBody
    @RequestMapping(value = "/list")
    public XXResponseBody list(Pageable pageable){
        pageable.setOrder("createDate", Order.Direction.desc);
        Page<BlogContentEntity> blogContentEntityList = blogContentService.findPage(pageable);
        return new XXResponseBody(blogContentEntityList.getContent());
    }
}

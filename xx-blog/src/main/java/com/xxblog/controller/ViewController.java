package com.xxblog.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 16/05/17.
 */
@Controller
@RequestMapping(value = "/xxblog/view")
public class ViewController {

    private static final String VIEW_INDEX = "/xx-blog/index";
    private static final String VIEW_ABOUT = "/xx-blog/about";
    private static final String VIEW_CONTACT = "/xx-blog/contact";
    private static final String VIEW_GALLERY = "/xx-blog/gallery";
    public static final String[] VIEWS = {VIEW_INDEX, VIEW_ABOUT, VIEW_CONTACT, VIEW_GALLERY};

    private static Map<String, String> mapView = new HashMap<>();

    static {
        for(String view : VIEWS){
            int lastIndex = StringUtils.lastIndexOf(view, "/") + 1;
            String suffix = StringUtils.substring(view, lastIndex);
            mapView.put(suffix, view);
        }
    }

    @RequestMapping(value = "/{page}")
    public ModelAndView index(@PathVariable String page){
        for(String view : VIEWS){
            if(StringUtils.endsWith(view, page)) return new ModelAndView(view);
        }
        return new ModelAndView(VIEW_INDEX);
    }


}

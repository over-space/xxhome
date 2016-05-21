package com.xxblog.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Hash;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 16/05/17.
 */
@Controller
@RequestMapping(value = "/xxblog/view")
public class ViewController {

    public static final String VIEW_INDEX = "/xx-blog/index";
    public static final String VIEW_ABOUT = "/xx-blog/about";
    public static final String VIEW_LOGIN = "/xx-blog/account/login";
    public static final String VIEW_SIGNUP = "/xx-blog/account/signup";
    public static final String VIEW_GALLERY = "/xx-blog/gallery";
    public static final String[] VIEWS = {VIEW_INDEX, VIEW_ABOUT,
            VIEW_LOGIN, VIEW_SIGNUP, VIEW_GALLERY};

    private static Map<String, String> mapView = new HashMap<>();

    static {
        for(String view : VIEWS){
            int lastIndex = StringUtils.lastIndexOf(view, "/") + 1;
            String suffix = StringUtils.substring(view, lastIndex);
            mapView.put(suffix, view);
        }
    }

    @RequestMapping(value = "/{page}")
    public ModelAndView index(@PathVariable String page, HttpServletRequest request){
        Map<String, String> variables = new HashMap<>();
        variables.put("sessionId", request.getSession().getId());

        if(mapView.containsKey(page)) return new ModelAndView(mapView.get(page), variables);

        return new ModelAndView(VIEW_INDEX, variables);
    }


}

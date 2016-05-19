package com.xxblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by admin on 16/05/17.
 */
@Controller
@RequestMapping(value = "/xxblog/view")
public class ViewController {

    private static final String VIEW_INDEX = "/xx-blog/index";


    @RequestMapping(value = "/index")
    public ModelAndView index(){
        return new ModelAndView(VIEW_INDEX);
    }


}

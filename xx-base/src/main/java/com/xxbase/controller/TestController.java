package com.xxbase.controller;

import com.xxbase.params.XXResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by admin on 16/05/22.
 */
@Controller
@RequestMapping("/xxbase")
public class TestController {


    @ResponseBody
    @RequestMapping(value = "/test")
    public XXResponseBody test() throws Exception {
        return new XXResponseBody();
    }


}

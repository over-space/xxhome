package com.xxblog.controller;

import com.alibaba.fastjson.JSONObject;
import com.xxbase.controller.BaseController;
import com.xxbase.params.XXResponseBody;
import com.xxbase.services.CaptchaService;
import com.xxbase.utils.CipherUtils;
import com.xxbase.utils.XXStringUtils;
import com.xxblog.entity.BlogAccountEntity;
import com.xxblog.services.BlogAccountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by admin on 16/05/17.
 */
@Controller
@RequestMapping(value = "/xxblog/account/")
public class BlogAccountController extends BaseController {

    @Autowired
    private BlogAccountService blogAccountService;
    @Autowired
    private CaptchaService captchaService;

    @ResponseBody
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public XXResponseBody signup(HttpServletRequest request) {
        JSONObject param = XXStringUtils.getJsonObject(request);

        if (param == null) {
            return new XXResponseBody(XXResponseBody.CODE_PARAM_ERROR, XXResponseBody.MESSAGE_PARAM_ERROR);
        }

        String email = param.getString("email");
        String username = param.getString("username");
        String password = param.getString("password");
        String captcha = param.getString("captcha");

        boolean isCaptchaValid = captchaService.isValid(request.getSession().getId(), captcha);
        if (!isCaptchaValid) {
            return new XXResponseBody(XXResponseBody.CODE_CAPTCHA_ERROR, XXResponseBody.MESSAGE_CAPTCHA_ERROR);
        }

        BlogAccountEntity blogAccountEntity = new BlogAccountEntity(username, CipherUtils.getTime64MD5(password), email, null);

        blogAccountService.persist(blogAccountEntity);
        return new XXResponseBody();
    }


    @ResponseBody
    @RequestMapping(value = "/check/{prop}", method = RequestMethod.POST)
    public XXResponseBody check(@PathVariable String prop, String value, HttpServletRequest request) {

        if(StringUtils.equals(prop, "email")) {

            if (StringUtils.isBlank(value)) return new XXResponseBody(XXResponseBody.CODE_PARAM_ERROR, "邮箱不允许为空!");

            BlogAccountEntity blogAccountEntity = blogAccountService.findByEmail(value);

            if (blogAccountEntity != null) return new XXResponseBody(XXResponseBody.CODE_PARAM_ERROR, "邮箱已经被注册!");
        }

        else if(StringUtils.equals(prop, "captcha")){
            if (StringUtils.isBlank(value)) return new XXResponseBody(XXResponseBody.CODE_PARAM_ERROR, "验证码不允许为空!");

            boolean isCaptchaValid = captchaService.isValid(request.getSession().getId(), value);

            if(!isCaptchaValid) return new XXResponseBody(XXResponseBody.CODE_PARAM_ERROR, "验证码输入错误!");
        }

        return new XXResponseBody();
    }

}

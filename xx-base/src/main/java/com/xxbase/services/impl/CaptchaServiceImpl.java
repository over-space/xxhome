package com.xxbase.services.impl;

import com.xxbase.services.CaptchaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.image.BufferedImage;

/**
 * Created by admin on 16/05/21.
 */
@Service
public class CaptchaServiceImpl implements CaptchaService {

    @Resource(name = "imageCaptchaService")
    private com.octo.captcha.service.CaptchaService imageCaptchaService;

    public BufferedImage buildImage(String captchaId) {
        return (BufferedImage) imageCaptchaService.getChallengeForID(captchaId);
    }

    public boolean isValid(CaptchaTypeEnum captchaType, String captchaId, String captcha) {
        if (captchaType == null) {
            if (StringUtils.isNotEmpty(captchaId) && StringUtils.isNotEmpty(captcha)) {
                try {
                    return imageCaptchaService.validateResponseForID(captchaId, captcha.toUpperCase());
                } catch (Exception e) {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

}

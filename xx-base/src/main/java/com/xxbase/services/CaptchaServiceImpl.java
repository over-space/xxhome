package com.xxbase.services;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.image.BufferedImage;

/**
 * Created by admin on 16/05/21.
 */
@Service
public class CaptchaServiceImpl implements CaptchaService {

    private Logger logger = LoggerFactory.getLogger(CaptchaServiceImpl.class);

    @Resource(name = "imageCaptchaService")
    private com.octo.captcha.service.CaptchaService imageCaptchaService;

    public BufferedImage buildImage(String captchaId) {
        return (BufferedImage) imageCaptchaService.getChallengeForID(captchaId);
    }

    public boolean isValid(String captchaId, String captcha) {
        if (StringUtils.isNotEmpty(captchaId) && StringUtils.isNotEmpty(captcha)) {
            try {
                return imageCaptchaService.validateResponseForID(captchaId, captcha.toUpperCase());
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return false;
            }
        } else {
            return false;
        }
    }

}

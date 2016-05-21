package com.xxbase.services;

import java.awt.image.BufferedImage;

/**
 * Created by admin on 16/05/21.
 */
public interface CaptchaService {

    BufferedImage buildImage(String captchaId);

    boolean isValid(CaptchaTypeEnum captchaType, String captchaId, String captcha);

}

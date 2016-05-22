package com.xxbase.method;

import com.octo.captcha.component.image.backgroundgenerator.BackgroundGenerator;
import com.octo.captcha.component.image.backgroundgenerator.FileReaderRandomBackgroundGenerator;
import com.octo.captcha.component.image.color.RandomListColorGenerator;
import com.octo.captcha.component.image.fontgenerator.FontGenerator;
import com.octo.captcha.component.image.fontgenerator.RandomFontGenerator;
import com.octo.captcha.component.image.textpaster.DecoratedRandomTextPaster;
import com.octo.captcha.component.image.textpaster.TextPaster;
import com.octo.captcha.component.image.textpaster.textdecorator.TextDecorator;
import com.octo.captcha.component.image.wordtoimage.ComposedWordToImage;
import com.octo.captcha.component.word.wordgenerator.RandomWordGenerator;
import com.octo.captcha.engine.image.ListImageCaptchaEngine;
import com.octo.captcha.image.gimpy.GimpyFactory;
import org.springframework.core.io.ClassPathResource;

import java.awt.*;

/**
 * Created by admin on 16/05/21.
 */
public class CaptchaEngine extends ListImageCaptchaEngine {

    private static final int IMAGE_WIDTH = 80;

    private static final int IMAGE_HEIGHT = 43;

    private static final int MIN_FONT_SIZE = 16;

    private static final int MAX_FONT_SIZE = 20;

    private static final int MIN_WORD_LENGTH = 4;

    private static final int MAX_WORD_LENGTH = 4;

    private static final String CHAR_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZSZHZOZPZXZXZ";

    private static final String BACKGROUND_IMAGE_PATH = "/captcha/";

    private static final Font[] FONTS = new Font[]{new Font("nyala", Font.BOLD, MAX_FONT_SIZE), new Font("Arial", Font.BOLD, MAX_FONT_SIZE),
            new Font("nyala", Font.BOLD, MAX_FONT_SIZE), new Font("Bell", Font.BOLD, MAX_FONT_SIZE),
            new Font("Bell MT", Font.BOLD, MAX_FONT_SIZE), new Font("Credit", Font.BOLD, MAX_FONT_SIZE),
            new Font("valley", Font.BOLD, MAX_FONT_SIZE), new Font("Impact", Font.BOLD, MAX_FONT_SIZE)};

    private static final Color[] COLORS = new Color[]{new Color(255, 255, 255), new Color(255, 220, 220),
            new Color(220, 255, 255), new Color(220, 220, 255),
            new Color(255, 255, 220), new Color(220, 255, 220)};

    @Override
    protected void buildInitialFactories() {
        FontGenerator fontGenerator = new RandomFontGenerator(MIN_FONT_SIZE, MAX_FONT_SIZE, FONTS);
        BackgroundGenerator backgroundGenerator = new FileReaderRandomBackgroundGenerator(IMAGE_WIDTH, IMAGE_HEIGHT, new ClassPathResource(BACKGROUND_IMAGE_PATH).getPath());
        TextPaster textPaster = new DecoratedRandomTextPaster(MIN_WORD_LENGTH, MAX_WORD_LENGTH, new RandomListColorGenerator(COLORS), new TextDecorator[]{});
        addFactory(new GimpyFactory(new RandomWordGenerator(CHAR_STRING), new ComposedWordToImage(fontGenerator, backgroundGenerator, textPaster)));
    }


}

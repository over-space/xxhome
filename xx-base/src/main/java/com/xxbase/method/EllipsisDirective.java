package com.xxbase.method;

import freemarker.core.Environment;
import freemarker.template.*;

import java.io.IOException;
import java.util.Map;

/**
 * 自定义freemarker标签,单文本过长,将文本省略一部分，用…代替
 * Created by li.fang on 16/05/29.
 */
public class EllipsisDirective implements TemplateDirectiveModel{

    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        String text = null;
        int length = 0;

        if(map.get("text") != null){
            text = ((SimpleScalar) map.get("text")).getAsString();
        }

        if(map.get("length") != null){
            length = Integer.valueOf(((SimpleScalar) map.get("length")).getAsString());
        }

        if(length < text.length()){
            text = text.substring(0, length) + "...";
        }

        environment.getOut().write(text);
    }

}

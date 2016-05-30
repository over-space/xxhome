package com.xxbase.method;

import freemarker.core.Environment;
import freemarker.template.*;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Map;

/**
 * Created by admin on 16/05/29.
 */
public class ResourcesDirective implements TemplateDirectiveModel {

    private final static String KEY_SRC = "src";
    private final static String KEY_TYPE = "type";

    /**
     * <@resources src="xxx/index.css"/>
     *
     * @param environment
     * @param map
     * @param templateModels
     * @param templateDirectiveBody
     * @throws TemplateException
     * @throws IOException
     */
    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {

        if(!map.containsKey(KEY_SRC)) return;

        String path = ((SimpleScalar) map.get(KEY_SRC)).getAsString();

        String type = null;
        if(map.containsKey(KEY_TYPE)) {
            type = ((SimpleScalar) map.get(KEY_TYPE)).getAsString();
        }

        if(StringUtils.isBlank(path)) return;

        if(StringUtils.equalsIgnoreCase(type, "css") || StringUtils.endsWithIgnoreCase(path, "css")){
            String link = String.format("<link type='text/css' rel='stylesheet' href='%s'/>\n", path);
            environment.getOut().write(link);
        }
        else if(StringUtils.equalsIgnoreCase(type, "js") || StringUtils.endsWithIgnoreCase(path, "js")){
            String script = String.format("<script type='text/javascript' src='%s'/>\n", path);
            environment.getOut().write(script);
        }
        else if(StringUtils.equalsIgnoreCase(type, "ico") || StringUtils.endsWithIgnoreCase(path, "ico")){
            String link = String.format("<link rel='shortcut icon' href='%s'/>", path);
            environment.getOut().write(link);
        }
    }
}

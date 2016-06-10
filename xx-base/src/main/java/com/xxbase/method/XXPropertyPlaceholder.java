package com.xxbase.method;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by admin on 16/06/08.
 */
public class XXPropertyPlaceholder extends PropertyPlaceholderConfigurer {

    private static Map<String, String> cacheMap = null;

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        if(cacheMap == null) cacheMap = new HashMap<>();
        for(Object objKey : props.keySet()){
            String key = objKey.toString();
            String value = props.getProperty(key);
            cacheMap.put(key, value);
        }
    }

    public static String getProperty(String key){
        return cacheMap.get(key);
    }
}

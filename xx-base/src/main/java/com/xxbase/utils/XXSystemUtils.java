package com.xxbase.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.io.ResourceUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * Created by admin on 16/05/21.
 */
public class XXSystemUtils {

    private static final String REQUEST_BODY = "REQUEST_BODY";
    private static Logger logger = LoggerFactory.getLogger(XXSystemUtils.class);


    /**
     * 从requst中获取json数据
     *
     * @param request
     * @return json格式数据
     * @throws java.io.IOException
     */
    public static String getJsonBody(HttpServletRequest request) {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } catch (IOException ex) {
            logger.warn("从request里读取数据流错误", ex.toString());
        } finally {
            try {
                if (bufferedReader != null) bufferedReader.close();
            } catch (IOException ex) {
                logger.warn("关闭request读取数据流错误", ex.toString());
            }
        }

        request.setAttribute(REQUEST_BODY, stringBuilder.toString());
        String str = filterOffUtf8Mb4(stringBuilder.toString());
        return str;
    }


    public static <T> T getJsonBody2Object(HttpServletRequest request, Class<T> clazz) {
        String jsonString = getJsonBody(request);
        return JSON.parseObject(jsonString, clazz);
    }


    public static JSONObject getJsonObject(HttpServletRequest request) {
        String jsonString = getJsonBody(request);
        return JSON.parseObject(jsonString);
    }

    public static <T> T jsonStringToObject(String jsonString, Class<T> tClass){
        if(isEmpty(jsonString)) return null;
        return JSONObject.parseObject(jsonString, tClass);
    }

    public static <T> Collection<T> jsonStringToArrObject(String jsonString, Class<T> tClass){
        if(isEmpty(jsonString)) return new ArrayList<>();
        return JSONObject.parseArray(jsonString, tClass);
    }

    public static boolean isEmpty(Object object){

        if(object == null) return true;

        if (object.getClass().isArray()) {
            Object[] arr = (Object[]) object;
            return arr.length == 0;
        }

        if (object instanceof Map && CollectionUtils.isEmpty((Map<?, ?>) object)) return true;

        if (object instanceof Collection && CollectionUtils.isEmpty((Collection<?>) object)) return true;

        if (object instanceof String && StringUtils.isBlank(object.toString())) return true;

        return false;
    }

    public static String getClasspath(){
        return XXSystemUtils.class.getClassLoader().getResource("").getPath();
    }

    public static String getClasspath(String fileName){
        return getClasspath() + fileName;
    }

    /**
     * 过滤掉超过3个字节的UTF8字符
     *
     * @param text
     * @return
     */
    public static String filterOffUtf8Mb4(String text) {
        try {
            if (text == null)
                return null;
            byte[] bytes = text.getBytes("utf-8");
            if (!hasOffUtf8Mb4(bytes))
                return text;

            ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
            int i = 0;
            while (i < bytes.length) {
                short b = bytes[i];
                if (b > 0) {
                    buffer.put(bytes[i++]);
                    continue;
                }

                b += 256; // 去掉符号位

                if (((b >> 5) ^ 0x6) == 0) {
                    buffer.put(bytes, i, 2);
                    i += 2;
                } else if (((b >> 4) ^ 0xE) == 0) {
                    buffer.put(bytes, i, 3);
                    i += 3;
                } else if (((b >> 3) ^ 0x1E) == 0) {
                    i += 4;
                } else if (((b >> 2) ^ 0x3E) == 0) {
                    i += 5;
                } else if (((b >> 1) ^ 0x7E) == 0) {
                    i += 6;
                } else {
                    buffer.put(bytes[i++]);
                }
            }
            buffer.flip();
            return new String(buffer.array(), 0, buffer.limit(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage(), e);
            return text;
        }
    }


    private static boolean hasOffUtf8Mb4(byte[] bytes) {
        int i = 0;
        while (i < bytes.length) {
            short b = bytes[i];
            if (b > 0) {
                i++;
                continue;
            }

            b += 256; // 去掉符号位

            if (((b >> 5) ^ 0x6) == 0) {
                i += 2;
            } else if (((b >> 4) ^ 0xE) == 0) {
                i += 3;
            } else if (((b >> 3) ^ 0x1E) == 0) {
                return true;
            } else if (((b >> 2) ^ 0x3E) == 0) {
                return true;
            } else if (((b >> 1) ^ 0x7E) == 0) {
                return true;
            } else {
                i++;
            }
        }
        return false;
    }
}

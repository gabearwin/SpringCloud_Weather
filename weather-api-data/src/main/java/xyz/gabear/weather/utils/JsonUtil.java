package xyz.gabear.weather.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 转换为json字符串
     */
    public static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * json转对象
     */
    public static <T> T toBean(String json, Class<T> classType) {
        try {
            return objectMapper.readValue(json, classType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * json转对象List
     */
    public static <T> List<T> toList(String json, TypeReference typeReference) {
        try {
            return objectMapper.readValue(json, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
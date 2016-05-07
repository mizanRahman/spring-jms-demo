package com.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by mac on 5/7/16.
 */
public class JsonConverter {

    private ObjectMapper objectMapper;

    public JsonConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("failed to convert to json", e);
        }
    }

    public <T> T fromJson(String json, Class<T> valueType) {

        T t = null;
        try {
            t = objectMapper.readValue(json, valueType);
        } catch (IOException e) {
            throw new RuntimeException("failed to convert from json", e);
        }
        return t;
    }
}

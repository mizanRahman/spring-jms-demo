package com.example;

import java.util.HashMap;

/**
 * Created by mac on 5/8/16.
 */
public class RequestMessageBuilder<T> {

    public static String REQUEST_HEADER_URL = "REQUEST_URL";

    private HashMap<String, String> headers = new HashMap<String, String>();
    private T payload;

    public static <T> RequestMessageBuilder<T> create() {
        return new RequestMessageBuilder<T>();
    }

    public RequestMessageBuilder<T> withHeaders(HashMap<String, String> headers) {
        this.headers = headers;
        return this;
    }

    public RequestMessageBuilder<T> withHeader(String key, String val) {
        this.headers.put(key,val);
        return this;
    }
    public RequestMessageBuilder<T> withUrlHeader(String url) {
        this.headers.put(REQUEST_HEADER_URL, url);
        return this;
    }

    public RequestMessageBuilder<T> withPayload(T Payload) {
        this.payload = Payload;
        return this;
    }

    public RequestMessage build() {
        return new RequestMessage(headers,payload);
    }
}

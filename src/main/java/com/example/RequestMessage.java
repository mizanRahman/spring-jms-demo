package com.example;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by mac on 5/7/16.
 */
public class RequestMessage<T> implements Serializable {

    HashMap<String,String> headers;
    T payload;

    public RequestMessage() {
    }

    public RequestMessage(HashMap<String, String> headers, T payload) {
        this.headers = headers;
        this.payload = payload;
    }

    public HashMap<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(HashMap<String, String> headers) {
        this.headers = headers;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}

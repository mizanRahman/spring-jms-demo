package com.example;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mac on 5/7/16.
 */
public class RequestQueueMapping {

    public static final String QUEUE_FOR_CARD_REQ = "card.request";

    // this can also be defined in bean definition
    // Design a new RequestMapping Bean

    public static final Map<Class, String> queueMap;

    static {
        HashMap<Class, String> tempMap = new HashMap<Class, String>();

        tempMap.put(Card.class, QUEUE_FOR_CARD_REQ);

        queueMap = Collections.unmodifiableMap(tempMap);
    }

    public static <T> String getQueue(Class<T> claz) {
        return queueMap.get(claz);
    }
}

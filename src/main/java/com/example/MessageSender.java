package com.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by mac on 5/7/16.
 */
@Component
public class MessageSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public <T> void submitMessage(RequestMessage<T> requestMessage) {
        System.out.println("Sending a new message.");

        String json = null;
        try {
            json = objectMapper.writeValueAsString(requestMessage);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("failed to convert to json", e);
        }

        jmsTemplate.convertAndSend(RequestQueueMapping.getQueue(
                requestMessage.getPayload().getClass()),
                json);
    }

}

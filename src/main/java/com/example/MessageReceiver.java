package com.example;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import java.io.IOException;

@Component
public class MessageReceiver {

    @Autowired
    ObjectMapper mapper;

    @Autowired
    TestService testService;

    @JmsListener(destination = RequestQueueMapping.QUEUE_FOR_CARD_REQ)
    public void receiveMessage(String message) throws JMSException, IOException {
        System.out.println("Received <" + message + ">");
        RequestMessage<Card> requestMessage =
                mapper.readValue(message, new TypeReference<RequestMessage<Card>>() {
                });
        testService.printReport(requestMessage.getPayload());
    }
}
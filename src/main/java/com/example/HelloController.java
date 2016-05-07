package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Created by mac on 3/25/16.
 */
@RestController
public class HelloController {

    @Autowired
    MessageSender messageSender;

    @RequestMapping("/greeting")
    public ResponseEntity<String> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        Card card = new Card();
        card.setPan("s132131");
        card.setPsn("232131231");

        RequestMessage<Card> cardRequestMessage = new RequestMessage<Card>();
        cardRequestMessage.setPayload(card);


        RequestMessage requestMessage = new RequestMessageBuilder<Card>()
                .withHeader("correlationId", "2312312")
                .withUrlHeader("/api/psm/downloadCard")
                .withPayload(card)
                .build();

        messageSender.submitMessage(requestMessage);
        return new ResponseEntity<String>("Hello World", HttpStatus.ACCEPTED);
    }


}

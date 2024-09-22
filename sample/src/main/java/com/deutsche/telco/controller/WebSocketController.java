package com.deutsche.telco.controller;

import org.springframework.web.bind.annotation.RestController;
import com.deutsche.telco.model.ParentCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class WebSocketController {
    @Autowired
    SimpMessagingTemplate template;

    @PostMapping("/send")
    public ResponseEntity<Void> sendMessage(@RequestBody ParentCart parentCart) {
        template.convertAndSend("/topic/message", parentCart);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @MessageMapping("/sendMessage")
    public void receiveMessage(@Payload ParentCart parentCart) {
        // receive message from client
    }


    @SendTo("/topic/message")
    public ParentCart broadcastMessage(@Payload ParentCart parentCart) {
        return parentCart;
    }
}

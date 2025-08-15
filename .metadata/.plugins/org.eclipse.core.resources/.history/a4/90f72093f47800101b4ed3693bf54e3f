package com.chatapp.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.chatapp.model.ChatMessage;

@Controller
public class ChatController {
    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public ChatMessage send(ChatMessage message) {
        message.setTimestamp(LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        return message;
    }
    
    

}

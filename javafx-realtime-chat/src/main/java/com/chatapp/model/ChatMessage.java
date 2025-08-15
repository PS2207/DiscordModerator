package com.chatapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data generates getters, setters, toString, hashCode, and equals automatically.
//@NoArgsConstructor and @AllArgsConstructor make it easy to create empty or fully populated objects.
//This fits perfectly with send() method in ChatController,
//and the JSON format sent from test.html.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessage {
    private String sender;
    private String content;
    private String timestamp;
}

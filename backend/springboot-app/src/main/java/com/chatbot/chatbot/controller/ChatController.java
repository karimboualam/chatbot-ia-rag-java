package com.chatbot.chatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.chatbot.chatbot.dto.ChatRequest;
import com.chatbot.chatbot.dto.ChatResponse;
import com.chatbot.chatbot.service.ChatService;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "http://localhost:4200") // autorise le frontend Angular
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request) {
        return chatService.processMessage(request);
    }
}

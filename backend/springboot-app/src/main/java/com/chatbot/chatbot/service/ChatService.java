package com.chatbot.chatbot.service;

import org.springframework.stereotype.Service;
import com.chatbot.chatbot.dto.ChatRequest;
import com.chatbot.chatbot.dto.ChatResponse;

@Service
public class ChatService {

    private final AiService aiService;

    public ChatService(AiService aiService) {
        this.aiService = aiService;
    }

    public ChatResponse processMessage(ChatRequest request) {
        String aiReply = aiService.getResponse(request.getMessage());
        return new ChatResponse(aiReply);
    }
}

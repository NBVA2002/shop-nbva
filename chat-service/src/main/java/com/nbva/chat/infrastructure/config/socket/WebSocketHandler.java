package com.nbva.chat.infrastructure.config.socket;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocketHandler extends TextWebSocketHandler {

    private final SessionRegistry registry;
    private final RedisTemplate<String, String> redisTemplate;

    public WebSocketHandler(SessionRegistry registry, RedisTemplate<String, String> redisTemplate) {
        this.registry = registry;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        registry.add(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        // ĐẨY message sang Redis
        redisTemplate.convertAndSend("chat-channel", message.getPayload());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        registry.remove(session);
    }
}

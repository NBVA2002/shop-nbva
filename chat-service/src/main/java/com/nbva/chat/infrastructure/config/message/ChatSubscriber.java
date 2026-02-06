package com.nbva.chat.infrastructure.config.message;

import com.nbva.chat.infrastructure.config.socket.SessionRegistry;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

@Component
public class ChatSubscriber implements MessageListener {

    private final SessionRegistry registry;

    public ChatSubscriber(SessionRegistry registry) {
        this.registry = registry;
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String payload = new String(message.getBody());

        for (WebSocketSession session : registry.all()) {
            try {
                if (session.isOpen()) {
                    session.sendMessage(new TextMessage(payload));
                }
            } catch (Exception ignored) {}
        }
    }
}

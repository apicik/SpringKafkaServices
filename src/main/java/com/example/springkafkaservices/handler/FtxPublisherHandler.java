package com.example.springkafkaservices.handler;

import com.example.springkafkaservices.publisher.Publisher;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
@Slf4j
@AllArgsConstructor
public class FtxPublisherHandler extends TextWebSocketHandler {

    private Publisher publisher;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        if (session.isOpen()) {
            String payload = message.getPayload();
            log.info(payload);

            publisher.publish("BTC", payload);
        }
    }
}

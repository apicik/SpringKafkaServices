package com.example.springkafkaservices.config;

import com.example.springkafkaservices.handler.FtxPublisherHandler;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

import javax.annotation.PostConstruct;
import java.net.URI;

import static com.example.springkafkaservices.Constants.FTX_COM_URI;

@Configuration
@Slf4j
@RequiredArgsConstructor
@Getter
public class FtxPublisherConfig {
    private WebSocketSession session;
    private WebSocketClient client;

    private final FtxPublisherHandler handler;

    @PostConstruct
    @SneakyThrows
    private void init() {
        client = new StandardWebSocketClient();
        session =
                client.doHandshake(
                        handler,
                        new WebSocketHttpHeaders(),
                        URI.create(FTX_COM_URI)
                ).get();
        log.info("Session is open = {}", session.isOpen());
        log.info("Remote address: {}", session.getRemoteAddress());

        session.sendMessage(
                new TextMessage(
                        "{\"op\": \"subscribe\", \"channel\": \"trades\", \"market\": \"BTC-PERP\"}"
                )
        );
    }
}

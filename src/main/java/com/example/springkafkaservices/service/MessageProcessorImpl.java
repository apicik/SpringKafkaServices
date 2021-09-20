package com.example.springkafkaservices.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageProcessorImpl implements MessageProcessor {
    @Override
    public void process(String message) {
        log.info(message);
    }
}

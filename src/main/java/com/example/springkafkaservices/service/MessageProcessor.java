package com.example.springkafkaservices.service;

public interface MessageProcessor {
    void process(String message);
}

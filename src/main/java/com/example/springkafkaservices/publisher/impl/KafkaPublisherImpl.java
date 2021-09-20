package com.example.springkafkaservices.publisher.impl;

import com.example.springkafkaservices.publisher.Publisher;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class KafkaPublisherImpl implements Publisher {

    private KafkaTemplate<String, String> kafkaTemplate;

    private KafkaTemplate<String, String> kafkaTemplate2;


    @Override
    public void publish(String name, String message) {
        kafkaTemplate.send(name, message);
    }

    public void publish2(String name, String message) {
        kafkaTemplate.send(name, message);
    }

}

package com.example.springkafkaservices.consumer;

import com.example.springkafkaservices.service.MessageProcessor;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class FtxKafkaConsumer {

    private final MessageProcessor messageProcessor;

    @KafkaListener(topics = "BTC")
    public void consume(ConsumerRecord<String, String> consumerRecord) {
        log.info("Получен ключ: {}", consumerRecord.key());
        messageProcessor.process(consumerRecord.value());
    }

}

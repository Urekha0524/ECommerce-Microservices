package com.example.email_service.kafka;

import com.example.base_domain.dto.OrderEvent;
import org.slf4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {
    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(OrderConsumer.class);
    // This class will handle the consumption of order events from Kafka

    @KafkaListener (topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent orderEvent) {
        // Log the received order event
        LOGGER.info(String.format("Order event received in email service-> %s", orderEvent.toString()));
        System.out.println("Message has been triggered to the customer's email address");

    }
}

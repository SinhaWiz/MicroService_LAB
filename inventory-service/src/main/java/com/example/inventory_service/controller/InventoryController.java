package com.example.inventory_service.controller;

import com.example.inventory_service.Constants;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.util.Map;
@Component
public class InventoryController {
    @RabbitListener(queues = Constants.QUEUE)
    public void consumeMessageFromQueue(Map<String, Object> orderEvent) {
        System.out.println("Message Received from queue: " + orderEvent);
    }
}
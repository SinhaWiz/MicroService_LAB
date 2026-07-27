package org.sda.orderservice.controller;

import org.sda.orderservice.Constants;
import org.sda.orderservice.entity.Order;
import org.sda.orderservice.service.OrderService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    public OrderService orderService;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @PostMapping("/")
    public Order saveOrder(@RequestBody Order order) {
        Order savedOrder = orderService.saveOrder(order);

        Map<String, Object> orderEvent = new HashMap<>();
        orderEvent.put("orderId", savedOrder.getId());
        orderEvent.put("productId", savedOrder.getProductId());
        orderEvent.put("quantity", savedOrder.getQuantity());
        rabbitTemplate.convertAndSend(Constants.EXCHANGE, Constants.ROUTING_KEY, orderEvent);

        return savedOrder;
    }

    @GetMapping("/{id}")
    public Order findOrderById(@PathVariable("id") String orderId) {
        return orderService.findOrderById(orderId);
    }
}
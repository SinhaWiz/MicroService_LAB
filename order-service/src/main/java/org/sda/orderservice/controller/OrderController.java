package org.sda.orderservice.controller;

import org.sda.orderservice.entity.Order;
import org.sda.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    public OrderService orderService;

    @PostMapping("/")
    public Order saveOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @GetMapping("/{id}")
    public Order findOrderById(@PathVariable("id") String orderId) {
        return orderService.findOrderById(orderId);
    }
}
package org.sda.orderservice.service;

import org.sda.orderservice.entity.Order;
import org.sda.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order findOrderById(String orderId) {
        return orderRepository.findOrderById(orderId);
    }
}
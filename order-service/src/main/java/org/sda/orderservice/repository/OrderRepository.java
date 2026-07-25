package org.sda.orderservice.repository;

import org.sda.orderservice.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
    Order findOrderById(String orderId);
}
package org.sda.productservice.repository;

import org.sda.productservice.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
    Product findProductById(String productId);
}
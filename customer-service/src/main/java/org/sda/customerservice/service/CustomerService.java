package org.sda.customerservice.service;

import org.sda.customerservice.entity.Customer;
import org.sda.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findCustomerById(String customerId) {
        return customerRepository.findCustomerById(customerId);
    }
}
package org.sda.employeeservice.repository;

import org.sda.employeeservice.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Employee findEmployeeById(String employeeId);
}
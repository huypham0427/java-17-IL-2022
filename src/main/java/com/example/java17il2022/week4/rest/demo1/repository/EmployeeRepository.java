package com.example.java17il2022.week4.rest.demo1.repository;

import com.example.java17il2022.week4.rest.demo1.domain.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface EmployeeRepository {
    Employee getById(String id);
    Collection<Employee> getAll();
    String save(Employee employee);
}

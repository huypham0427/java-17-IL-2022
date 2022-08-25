package com.example.java17il2022.week4.rest.demo.service;

import com.example.java17il2022.week4.rest.demo.domain.dto.EmployeeResponseDTO;
import com.example.java17il2022.week4.rest.demo.domain.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface EmployeeService {
    EmployeeResponseDTO getById(String id);
    Collection<EmployeeResponseDTO> getAllEmp();
    String save(Employee emp);
}

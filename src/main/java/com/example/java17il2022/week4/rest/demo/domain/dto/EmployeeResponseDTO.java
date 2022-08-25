package com.example.java17il2022.week4.rest.demo.domain.dto;

import com.example.java17il2022.week4.rest.demo.domain.entity.Employee;

public class EmployeeResponseDTO {
    private String id;
    private String name;

    public EmployeeResponseDTO(Employee employee) {
        this.id = employee.getId();
        this.name = "[" + employee.getName() + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

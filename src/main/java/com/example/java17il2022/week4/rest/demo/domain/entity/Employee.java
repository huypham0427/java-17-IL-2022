package com.example.java17il2022.week4.rest.demo.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class Employee {
    private String name;
    private String id;
    private boolean active;

    public Employee(String id, String name) {
        this.name = name;
        this.id = id;
        this.active = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

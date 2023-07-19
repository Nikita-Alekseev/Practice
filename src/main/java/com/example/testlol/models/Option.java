package com.example.testlol.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
public class Option extends Base{
    private String name;

    protected Option() {};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

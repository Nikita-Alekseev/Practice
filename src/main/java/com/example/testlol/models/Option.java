package com.example.testlol.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
public class Option extends Base{

    @OneToMany(mappedBy = "option", cascade = CascadeType.REMOVE)
    private List<CarOption> carOptions;
    private String name;

    protected Option() {};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

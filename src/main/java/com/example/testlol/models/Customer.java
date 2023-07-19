package com.example.testlol.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer extends Base{
    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    private List<Sale> sales;
    private String name;
    private String address;
    private String phone;

    protected Customer() {};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

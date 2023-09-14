package com.example.practice.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer extends Base{
    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    private List<Order> order;

    private String fullNameOfTheCustomer;
    private String mail;
    private String phone;
    private String address;

    protected Customer() {};

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public String getFullNameOfTheCustomer() {
        return fullNameOfTheCustomer;
    }

    public void setFullNameOfTheCustomer(String fullNameOfTheCustomer) {
        this.fullNameOfTheCustomer = fullNameOfTheCustomer;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

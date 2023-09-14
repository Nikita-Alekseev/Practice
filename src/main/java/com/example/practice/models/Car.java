package com.example.practice.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Car extends Base {
    @OneToMany(mappedBy = "car", cascade = CascadeType.REMOVE)
    private List<Order> order;

    @OneToMany(mappedBy = "car", cascade = CascadeType.REMOVE)
    private List<Services> services;

    private String stateRegistrationPlate;
    private String brand;
    private String model;
    private String carType;
    private String fuelType;

    protected Car() {};

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public List<Services> getServices() {
        return services;
    }

    public void setServices(List<Services> services) {
        this.services = services;
    }

    public String getStateRegistrationPlate() {
        return stateRegistrationPlate;
    }

    public void setStateRegistrationPlate(String stateRegistrationPlate) {
        this.stateRegistrationPlate = stateRegistrationPlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
}
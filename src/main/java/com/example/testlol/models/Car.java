package com.example.testlol.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Car extends Base{
    @OneToMany(mappedBy = "car", cascade = CascadeType.REMOVE)
    private List<Sale> sales;

    @OneToMany(mappedBy = "car", cascade = CascadeType.REMOVE)
    private List<CarOption> carOptions;

    private String brand;
    private String model;
    private int year;
    private int price;

    protected Car() {};

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}


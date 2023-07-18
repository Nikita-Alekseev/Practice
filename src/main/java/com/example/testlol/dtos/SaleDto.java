package com.example.testlol.dtos;

import java.sql.Date;
import com.example.testlol.dtos.CarDto;
import com.example.testlol.dtos.CustomerDto;
import com.example.testlol.models.Car;
import com.example.testlol.models.Customer;

public class SaleDto {
    private Long id;
    private CarDto car;
    private CustomerDto customer;
    private int date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarDto getCar() {
        return car;
    }

    public void setCar(CarDto car) {
        this.car = car;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SaleDto{" +
                "id=" + id +
                ", car=" + car +
                ", customer=" + customer +
                ", date=" + date +
                '}';
    }

    public SaleDto(Long id, CarDto car, CustomerDto customer, int date) {
        this.id = id;
        this.car = car;
        this.customer = customer;
        this.date = date;
    }
    public SaleDto() {};
}

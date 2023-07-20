package com.example.testlol.dtos;

public class SaleDto {
    private Long id;
    private CarDto car;
    private CustomerDto customer;
    private String date;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    protected SaleDto() {};

    @Override
    public String toString() {
        return "SaleDto{" +
                "id=" + id +
                ", car=" + car +
                ", customer=" + customer +
                ", date=" + date +
                '}';
    }

    public SaleDto(Long id, CarDto car, CustomerDto customer, String date) {
        this.id = id;
        this.car = car;
        this.customer = customer;
        this.date = date;
    }
}

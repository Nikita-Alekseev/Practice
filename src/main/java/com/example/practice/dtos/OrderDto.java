package com.example.practice.dtos;

public class OrderDto {
    private Long id;
    private CarDto stateRegistrationPlate;
    private CustomerDto customerID;
    private String orderDate;
    private String orderStatus;

    public OrderDto(Long id, CarDto stateRegistrationPlate , CustomerDto customerID, String orderDate, String orderStatus) {
        this.id = id;
        this.stateRegistrationPlate = stateRegistrationPlate;
        this.customerID = customerID;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }
    public OrderDto() {};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarDto getStateRegistrationPlate() {
        return stateRegistrationPlate;
    }

    public void setStateRegistrationPlate(CarDto stateRegistrationPlate) {
        this.stateRegistrationPlate = stateRegistrationPlate;
    }

    public CustomerDto getCustomerID() {
        return customerID;
    }

    public void setCustomerID(CustomerDto customerID) {
        this.customerID = customerID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "CarOptionDto{" +
                "id=" + id +
                ", stateRegistrationPlate=" + stateRegistrationPlate +
                ", customerID=" + customerID +
                ", orderDate=" + orderDate +
                ", orderStatus=" + orderStatus +
                '}';
    }
}

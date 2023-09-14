package com.example.practice.dtos;

public class CarDto {
    private Long id;
    private String stateRegistrationPlate;
    private String brand;
    private String model;
    private String carType;
    private String fuelType;

    public CarDto(Long id, String stateRegistrationPlate, String brand, String model, String carType, String fuelType) {
        this.id = id;
        this.stateRegistrationPlate = stateRegistrationPlate;
        this.brand = brand;
        this.model = model;
        this.carType = carType;
        this.fuelType = fuelType;
    }
    protected CarDto() {};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "CarDto{" +
                "id=" + id +
                ", stateRegistrationPlate='" + stateRegistrationPlate + '\'' +
                ", brand='" + brand + '\'' +
                ", model=" + model +
                ", carType=" + carType +
                ", fuelType=" + fuelType +
                '}';
    }
}

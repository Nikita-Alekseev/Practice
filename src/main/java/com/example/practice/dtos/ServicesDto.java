package com.example.practice.dtos;

public class ServicesDto {
    private Long id;
    private WorkerDto workerID;
    private CarDto stateRegistrationPlate;
    private String typeOfServiceWork;
    private String date;
    private Integer price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WorkerDto getWorkerID() {
        return workerID;
    }

    public void setWorkerID(WorkerDto workerID) {
        this.workerID = workerID;
    }

    public CarDto getStateRegistrationPlate() {
        return stateRegistrationPlate;
    }

    public void setStateRegistrationPlate(CarDto stateRegistrationPlate) {
        this.stateRegistrationPlate = stateRegistrationPlate;
    }

    public String getTypeOfServiceWork() {
        return typeOfServiceWork;
    }

    public void setTypeOfServiceWork(String typeOfServiceWork) {
        this.typeOfServiceWork = typeOfServiceWork;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OptionDto{" +
                "id=" + id +
                ", workerID='" + workerID + '\'' +
                ", stateRegistrationPlate='" + stateRegistrationPlate + '\'' +
                ", typeOfServiceWork='" + typeOfServiceWork + '\'' +
                ", date='" + date + '\'' +
                ", price=" + price +
                '}';
    }

    public ServicesDto(Long id, WorkerDto workerID, CarDto stateRegistrationPlate ,String typeOfServiceWork, String date, Integer price) {
        this.id = id;
        this.workerID = workerID;
        this.stateRegistrationPlate = stateRegistrationPlate;
        this.typeOfServiceWork = typeOfServiceWork;
        this.date = date;
        this.price = price;
    }
    public ServicesDto() {};
}

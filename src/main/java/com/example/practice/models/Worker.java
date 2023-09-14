package com.example.practice.models;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Entity
public class Worker extends Base{

    @OneToMany(mappedBy = "worker", cascade = CascadeType.REMOVE)
    private List<Services> services;

    @OneToMany (mappedBy = "worker", cascade = CascadeType.REMOVE)
    private List<Customer> customer;

    @OneToMany (mappedBy = "worker", cascade = CascadeType.REMOVE)
    private List<Car> car;

    private String fullNameOfTheWorker;
    private String jobTitle;
    private String dateOfEmployment;
    private Integer wage;

    protected Worker() {};

    public List<Services> getServices() {
        return services;
    }

    public void setServices(List<Services> services) {
        this.services = services;
    }

    public List<Car> getCar() {
        return car;
    }

    public void setCar(List<Car> car) {
        this.car = car;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }

    public String getFullNameOfTheWorker() {
        return fullNameOfTheWorker;
    }

    public void setFullNameOfTheWorker(String fullNameOfTheWorker) {
        this.fullNameOfTheWorker = fullNameOfTheWorker;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(String dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public Integer getWage() {
        return wage;
    }

    public void setWage(Integer wage) {
        this.wage = wage;
    }
}

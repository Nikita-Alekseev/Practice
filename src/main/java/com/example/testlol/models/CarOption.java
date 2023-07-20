package com.example.testlol.models;

import jakarta.persistence.*;

@Entity
@Table(name = "CarOption")
public class CarOption extends Base{
    @ManyToOne
    @JoinColumn(name = "option_id")
    private Option option;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    public CarOption(Option option, Car car) {
        this.option = option;
        this.car = car;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    protected CarOption() {};
}

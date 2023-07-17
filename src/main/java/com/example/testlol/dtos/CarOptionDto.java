package com.example.testlol.dtos;

import com.example.testlol.models.Option;

public class CarOptionDto {
    private Long id;
    private CarDto car;
    private OptionDto option;

    public CarOptionDto(Long id, CarDto car, OptionDto option) {
        this.id = id;
        this.car = car;
        this.option = option;
    }

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

    public OptionDto getOption() {
        return option;
    }

    public void setOption(OptionDto option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return "CarOptionDto{" +
                "id=" + id +
                ", car=" + car +
                ", option=" + option +
                '}';
    }
}

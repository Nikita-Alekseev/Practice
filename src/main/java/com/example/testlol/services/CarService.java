package com.example.testlol.services;

import com.example.testlol.dtos.CarDto;
import com.example.testlol.models.Car;

import java.util.List;
import java.util.Optional;

public interface CarService<ID> {

    CarDto register(CarDto car);

    List<CarDto> getAll();

    Optional<CarDto> get(Long id);

    void delete(Long id);

    CarDto update(CarDto car);

}


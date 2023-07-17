package com.example.testlol.services;

import com.example.testlol.models.Car;

import java.util.List;
import java.util.Optional;

public interface CarService<ID> {

    Car saveCar(Car car);
    Car getCarById(Long id);
    List<Car> getAllCars();

}


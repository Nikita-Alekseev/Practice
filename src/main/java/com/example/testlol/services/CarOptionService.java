package com.example.testlol.services;

import com.example.testlol.dtos.CarOptionDto;

import java.util.List;
import java.util.Optional;

public interface CarOptionService {

    CarOptionDto register(CarOptionDto car);

    List<CarOptionDto> getAll();

    Optional<CarOptionDto> get(Long id);

    void delete(Long id);

    CarOptionDto update(CarOptionDto carOption);

}


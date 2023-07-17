package com.example.testlol.services.impl;

import com.example.testlol.controllers.exception.CarConflictException;
import com.example.testlol.controllers.exception.CarNotFoundException;
import com.example.testlol.dtos.CarDto;
import com.example.testlol.models.Car;
import com.example.testlol.repositories.CarRepository;
import com.example.testlol.repositories.OptionRepository;
import com.example.testlol.services.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    CarRepository carRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public CarDto register(CarDto car) {
        Car b = modelMapper.map(car, Car.class);
        if (b.getId() == null || b.getId() == 0 || get(b.getId()).isEmpty()) {
            return modelMapper.map(carRepository.save(b), CarDto.class);
        } else {
            throw new CarConflictException("A car with this id already exists");
        }
    }

    @Override
    public List<CarDto> getAll() {
        return carRepository.findAll().stream().map((s) -> modelMapper.map(s, CarDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<CarDto> get(Long id) {
        return Optional.ofNullable(modelMapper.map(carRepository.findById(id), CarDto.class));
    }

    @Override
    public void delete(Long id) {
        if (carRepository.findById(id).isPresent()) {
            carRepository.deleteById(id);
        } else {
            throw new CarNotFoundException(id);
        }
    }

    @Override
    public CarDto update(CarDto car) {
        if (carRepository.findById(car.getId()).isPresent()) {
            return modelMapper.map(carRepository.save(modelMapper.map(car, Car.class)), CarDto.class);
        } else {
            throw new CarNotFoundException(car.getId());
        }
    }
    @Override
    public List<CarDto> findCarByModel(String model) {
        return carRepository.findAllByModel(model).stream().map((s) -> modelMapper.map(s, CarDto.class)).collect(Collectors.toList());
    }
}

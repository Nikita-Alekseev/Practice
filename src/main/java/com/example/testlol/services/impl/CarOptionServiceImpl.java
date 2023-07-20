package com.example.testlol.services.impl;

import com.example.testlol.controllers.exception.CarConflictException;
import com.example.testlol.controllers.exception.CarNotFoundException;

import com.example.testlol.dtos.CarOptionDto;
import com.example.testlol.models.CarOption;
import com.example.testlol.repositories.CarOptionRepository;
import com.example.testlol.services.CarOptionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarOptionServiceImpl implements CarOptionService {
    @Autowired
    CarOptionRepository carOptionRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CarOptionServiceImpl(CarOptionRepository carOptionRepository) {
        this.carOptionRepository = carOptionRepository;
    }

    @Override
    public CarOptionDto register(CarOptionDto carOption) {
        CarOption b = modelMapper.map(carOption, CarOption.class);
        if (b.getId() == null || b.getId() == 0 || get(b.getId()).isEmpty()) {
            return modelMapper.map(carOptionRepository.save(b), CarOptionDto.class);
        } else {
            throw new CarConflictException("A car with this id already exists");
        }
    }

    @Override
    public List<CarOptionDto> getAll() {
        return carOptionRepository.findAll().stream().map((s) -> modelMapper.map(s, CarOptionDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<CarOptionDto> get(Long id) {
        return Optional.ofNullable(modelMapper.map(carOptionRepository.findById(id), CarOptionDto.class));
    }

    @Override
    public void delete(Long id) {
        if (carOptionRepository.findById(id).isPresent()) {
            carOptionRepository.deleteById(id);
        } else {
            throw new CarNotFoundException(id);
        }
    }

    @Override
    public CarOptionDto update(CarOptionDto carOption) {
        if (carOptionRepository.findById(carOption.getId()).isPresent()) {
            return modelMapper.map(carOptionRepository.save(modelMapper.map(carOption, CarOption.class)), CarOptionDto.class);
        } else {
            throw new CarNotFoundException(carOption.getId());
        }
    }
}
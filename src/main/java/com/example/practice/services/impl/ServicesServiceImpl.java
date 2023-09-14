package com.example.practice.services.impl;

import com.example.practice.controllers.exception.ServicesConflictException;
import com.example.practice.controllers.exception.ServicesNotFoundException;
import com.example.practice.dtos.ServicesDto;
import com.example.practice.models.Services;
import com.example.practice.repositories.ServicesRepository;
import com.example.practice.services.ServicesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicesServiceImpl implements ServicesService {
    @Autowired
    ServicesRepository servicesRepository;
    @Autowired
    private ModelMapper modelMapper;


    public ServicesServiceImpl(ServicesRepository servicesRepository) {
        this.servicesRepository = servicesRepository;
    }

    @Override
    public ServicesDto register(ServicesDto services) {
        Services o = modelMapper.map(services, Services.class);
        if (o.getId() == null || o.getId() == 0 || getServicesById(o.getId()).isEmpty()) {
            return modelMapper.map(servicesRepository.save(o), ServicesDto.class);
        } else {
            throw new ServicesConflictException("A services with this id already exists");
        }
    }
    @Override
    public ServicesDto update(ServicesDto services) {
        if (servicesRepository.findById(services.getId()).isPresent()) {
            return modelMapper.map(servicesRepository.save(modelMapper.map(services, Services.class)), ServicesDto.class);
        } else {
            throw new ServicesNotFoundException(services.getId());
        }
    }

    @Override
    public Optional<ServicesDto> getServicesById(Long id) {
        return Optional.ofNullable(modelMapper.map(servicesRepository.findById(id),ServicesDto.class));
    }

    @Override
    public List<ServicesDto> getAllServices() {
        return servicesRepository.findAll().stream().map((s) -> modelMapper.map(s, ServicesDto.class)).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (servicesRepository.findById(id).isPresent()) {
            servicesRepository.deleteById(id);
        } else {
            throw new ServicesNotFoundException(id);
        }
    }
}
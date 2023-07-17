package com.example.testlol.services.impl;

import com.example.testlol.controllers.exception.CarConflictException;
import com.example.testlol.controllers.exception.CarNotFoundException;
import com.example.testlol.dtos.CustomerDto;
import com.example.testlol.dtos.OptionDto;
import com.example.testlol.models.Customer;
import com.example.testlol.models.Option;
import com.example.testlol.repositories.OptionRepository;
import com.example.testlol.services.OptionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OptionServiceImpl implements OptionService {
    @Autowired
    OptionRepository optionRepository;
    @Autowired
    private ModelMapper modelMapper;


    public OptionServiceImpl(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    @Override
    public OptionDto register(OptionDto option) {
        Option o = modelMapper.map(option, Option.class);
        if (o.getId() == null || o.getId() == 0 || getOptionById(o.getId()).isEmpty()) {
            return modelMapper.map(optionRepository.save(o), OptionDto.class);
        } else {
            throw new CarConflictException("A option with this id already exists");
        }
    }
    @Override
    public OptionDto update(OptionDto option) {
        if (optionRepository.findById(option.getId()).isPresent()) {
            return modelMapper.map(optionRepository.save(modelMapper.map(option, Option.class)), OptionDto.class);
        } else {
            throw new CarNotFoundException(option.getId());
        }
    }

    @Override
    public Optional<OptionDto> getOptionById(Long id) {
        return Optional.ofNullable(modelMapper.map(optionRepository.findById(id),OptionDto.class));
    }

    @Override
    public List<OptionDto> getAllOptions() {
        return optionRepository.findAll().stream().map((s) -> modelMapper.map(s, OptionDto.class)).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (optionRepository.findById(id).isPresent()) {
            optionRepository.deleteById(id);
        } else {
            throw new CarNotFoundException(id);
        }
    }
}
package com.example.testlol.services.impl;

import com.example.testlol.models.Option;
import com.example.testlol.repositories.OptionRepository;
import com.example.testlol.services.OptionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionServiceImpl implements OptionService {
    private final OptionRepository optionRepository;

    public OptionServiceImpl(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    @Override
    public Option saveOption(Option option) {
        return optionRepository.save(option);
    }

    @Override
    public Option getOptionById(Long id) {
        return optionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Option> getAllOptions() {
        return optionRepository.findAll();
    }
}
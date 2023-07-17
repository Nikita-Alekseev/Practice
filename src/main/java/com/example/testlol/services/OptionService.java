package com.example.testlol.services;
import com.example.testlol.models.Option;

import java.util.List;

public interface OptionService {
    Option saveOption(Option option);
    Option getOptionById(Long id);
    List<Option> getAllOptions();
}

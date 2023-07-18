package com.example.testlol.services;
import com.example.testlol.dtos.OptionDto;

import java.util.List;
import java.util.Optional;

public interface OptionService {
    OptionDto register(OptionDto option);
    Optional<OptionDto> getOptionById(Long id);
    List<OptionDto> getAllOptions();
    void delete (Long id);
    OptionDto update (OptionDto option);
}

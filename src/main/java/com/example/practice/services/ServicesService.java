package com.example.practice.services;
import com.example.practice.dtos.ServicesDto;

import java.util.List;
import java.util.Optional;

public interface ServicesService {
    ServicesDto register(ServicesDto services);
    Optional<ServicesDto> getServicesById(Long id);
    List<ServicesDto> getAllServices();
    void delete (Long id);
    ServicesDto update (ServicesDto services);
}

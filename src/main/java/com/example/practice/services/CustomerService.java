package com.example.practice.services;

import com.example.practice.dtos.CustomerDto;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    CustomerDto register(CustomerDto customer);
    Optional<CustomerDto> getCustomerById(Long id);
    List<CustomerDto> getAllCustomers();
    void delete(Long id);
    CustomerDto update(CustomerDto customer);
}

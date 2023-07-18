package com.example.testlol.services;

import com.example.testlol.dtos.CarDto;
import com.example.testlol.dtos.CustomerDto;
import com.example.testlol.models.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    CustomerDto register(CustomerDto customer);
    Optional<CustomerDto> getCustomerById(Long id);
    List<CustomerDto> getAllCustomers();
    void delete(Long id);
    CustomerDto update(CustomerDto customer);
}

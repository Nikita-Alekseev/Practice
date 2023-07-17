package com.example.testlol.services.impl;

import com.example.testlol.controllers.exception.CarConflictException;
import com.example.testlol.controllers.exception.CarNotFoundException;
import com.example.testlol.dtos.CustomerDto;
import com.example.testlol.models.Customer;
import com.example.testlol.repositories.CustomerRepository;
import com.example.testlol.services.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CustomerDto register(CustomerDto customer) {
        Customer c = modelMapper.map(customer, Customer.class);
        if (c.getId() == null || c.getId() == 0 || getCustomerById(c.getId()).isEmpty()) {
            return modelMapper.map(customerRepository.save(c), CustomerDto.class);
        } else {
            throw new CarConflictException("A customer with this id already exists");
        }
    }
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto update(CustomerDto customer) {
        if (customerRepository.findById(customer.getId()).isPresent()) {
            return modelMapper.map(customerRepository.save(modelMapper.map(customer, Customer.class)), CustomerDto.class);
        } else {
            throw new CarNotFoundException(customer.getId());
        }
    }

    @Override
    public Optional<CustomerDto> getCustomerById(Long id) {
        return Optional.ofNullable(modelMapper.map(customerRepository.findById(id),CustomerDto.class));
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll().stream().map((s) -> modelMapper.map(s, CustomerDto.class)).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (customerRepository.findById(id).isPresent()) {
            customerRepository.deleteById(id);
        } else {
            throw new CarNotFoundException(id);
        }
    }
}

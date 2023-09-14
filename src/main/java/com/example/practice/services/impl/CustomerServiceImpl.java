package com.example.practice.services.impl;

import com.example.practice.controllers.exception.CustomerConflictException;
import com.example.practice.controllers.exception.CustomerNotFoundException;
import com.example.practice.dtos.CustomerDto;
import com.example.practice.models.Customer;
import com.example.practice.repositories.CustomerRepository;
import com.example.practice.services.CustomerService;
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
            throw new CustomerConflictException("A customer with this id already exists");
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
            throw new CustomerNotFoundException(customer.getId());
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
            throw new CustomerNotFoundException(id);
        }
    }
}

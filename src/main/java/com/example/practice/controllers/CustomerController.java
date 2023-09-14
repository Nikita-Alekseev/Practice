package com.example.practice.controllers;

import com.example.practice.controllers.exception.CustomerNotFoundException;
import com.example.practice.dtos.CustomerDto;
import com.example.practice.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping()
    Iterable<CustomerDto> all(){ return customerService.getAllCustomers();}
    @GetMapping("/{id}")
    CustomerDto get(@PathVariable Long id){
        return customerService.getCustomerById(id).orElseThrow(() -> new CustomerNotFoundException(id));
    }
    @PostMapping()
    CustomerDto createCustomer(@RequestBody CustomerDto customer){
        return customerService.register(customer);
    }

    @DeleteMapping("/{id}")
    void deleteCustomer(@PathVariable Long id){
        customerService.delete(id);
    }

    @PutMapping()
    CustomerDto update(@RequestBody CustomerDto customer){
        return customerService.update(customer);
    }
}

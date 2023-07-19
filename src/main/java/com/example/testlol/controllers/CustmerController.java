package com.example.testlol.controllers;

import com.example.testlol.controllers.exception.CustomerNotFoundException;
import com.example.testlol.dtos.CustomerDto;
import com.example.testlol.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustmerController {
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

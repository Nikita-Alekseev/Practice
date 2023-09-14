package com.example.practice.controllers;

import com.example.practice.controllers.exception.ServicesNotFoundException;
import com.example.practice.controllers.exception.ServicesNotFoundException;
import com.example.practice.dtos.ServicesDto;
import com.example.practice.services.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/services")
public class ServicesController {
    @Autowired
    private ServicesService servicesService;
    @GetMapping()
    Iterable<ServicesDto> all(){return servicesService.getAllServices();}
    @GetMapping("/{id}")
    ServicesDto get(@PathVariable Long id){
        return servicesService.getServicesById(id).orElseThrow(() -> new ServicesNotFoundException(id));
    }
    @PostMapping()
    ServicesDto createServices(@RequestBody ServicesDto services){
        return servicesService.register(services);
    }
    @DeleteMapping("/{id}")
    void deleteServices(@PathVariable Long id){servicesService.delete(id);}
    @PutMapping()
    ServicesDto update(ServicesDto services){
        return servicesService.update(services);
    }
}

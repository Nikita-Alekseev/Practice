package com.example.testlol.controllers;

import com.example.testlol.controllers.exception.CarNotFoundException;
import com.example.testlol.dtos.CarOptionDto;
import com.example.testlol.services.CarOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/caroptions")
public class CarOptionController {
    @Autowired
    private CarOptionService carOptionService;
    @GetMapping()
    Iterable<CarOptionDto> all(){
        return carOptionService.getAll();
    }
    @GetMapping("/{id}")
    CarOptionDto get(@PathVariable Long id){
        return carOptionService.get(id).orElseThrow(() -> new CarNotFoundException(id));
    }
    @PostMapping
    CarOptionDto createCarOption(@RequestBody CarOptionDto carOption){
        return carOptionService.register(carOption);
    }
    @DeleteMapping("/{id}")
    void deleteCarOption(@PathVariable Long id){
        carOptionService.delete(id);
    }
    @PutMapping()
    CarOptionDto update(@RequestBody CarOptionDto carOption){
        return carOptionService.update(carOption);
    }
}

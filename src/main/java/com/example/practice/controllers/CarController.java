package com.example.practice.controllers;

import com.example.practice.controllers.exception.CarNotFoundException;
import com.example.practice.dtos.CarDto;
import com.example.practice.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;
    @GetMapping()
    Iterable<CarDto> all(){
        return carService.getAll();
    }
    @GetMapping("/{id}")
    CarDto get(@PathVariable Long id){
        return carService.get(id).orElseThrow(() -> new CarNotFoundException(id));
    }
    @PostMapping
    CarDto createCar(@RequestBody CarDto car){
        return carService.register(car);
    }
    @DeleteMapping("/{id}")
    void deleteCar(@PathVariable Long id){
        carService.delete(id);
    }
    @PutMapping()
    CarDto update(@RequestBody CarDto car){
        return carService.update(car);
    }
}

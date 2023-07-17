package com.example.testlol.init;

import com.example.testlol.dtos.CarDto;
import com.example.testlol.dtos.CustomerDto;
import com.example.testlol.services.CarService;
import com.example.testlol.services.CustomerService;
import com.example.testlol.services.OptionService;
import com.example.testlol.services.SaleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class Main implements CommandLineRunner {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CarService carService;
    @Autowired
    private SaleService saleService;
    @Autowired
    private OptionService optionService;
    @Autowired
    private CustomerService customerService;

    @Override
    public void run(String... args){
        seedData();
    }

    private void seedData() {
        CarDto car = new CarDto(null, "Andrey", "Ivanov", 2020, 2020);
        CustomerDto customer= new CustomerDto(null, "mobile", "jgefgeufgufg", "8349300484");
        car = carService.register(car);
    }
}

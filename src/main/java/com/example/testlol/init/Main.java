package com.example.testlol.init;

import com.example.testlol.dtos.CarDto;
import com.example.testlol.models.Car;
import com.example.testlol.models.Customer;
import com.example.testlol.models.Option;
import com.example.testlol.models.Sale;
import com.example.testlol.services.CarService;
import com.example.testlol.services.CustomerService;
import com.example.testlol.services.OptionService;
import com.example.testlol.services.SaleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class Main implements CommandLineRunner {

    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;
    private final OptionService optionService;

    public Main(CarService carService, CustomerService customerService, SaleService saleService, OptionService optionService) {
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
        this.optionService = optionService;
    }


    @Override
    public void run(String... args) {

        // Вывод всех автомобилей
        System.out.println("Список всех автомобилей:");
        List<Car> cars = carService.getAllCars();
        for (Car car : cars) {
            System.out.println(car.getId() + ": " + car.getBrand() + " " + car.getModel());
        }
        System.out.println();

        // Вывод всех клиентов
        System.out.println("Список всех клиентов:");
        List<Customer> customers = customerService.getAllCustomers();
        for (Customer customer : customers) {
            System.out.println(customer.getId() + ": " + customer.getName());
        }
        System.out.println();

        // Вывод всех продаж
        System.out.println("Список всех продаж:");
        List<Sale> sales = saleService.getAllSales();
        for (Sale sale : sales) {
            System.out.println("ID продажи: " + sale.getId());
            System.out.println("Автомобиль: " + sale.getCar().getBrand() + " " + sale.getCar().getModel());
            System.out.println("Клиент: " + sale.getCustomer().getName());
            System.out.println("Дата: " + sale.getDate());
            System.out.println();
        }

        // Вывод всех опций
        System.out.println("Список всех опций:");
        List<Option> options = optionService.getAllOptions();
        for (Option option : options) {
            System.out.println(option.getId() + ": " + option.getName());
        }
        System.out.println();
    }
}

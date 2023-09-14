package com.example.practice.init;

import com.example.practice.dtos.*;
import com.example.practice.services.CarService;
import com.example.practice.services.CustomerService;
import com.example.practice.services.OrderService;
import com.example.practice.services.WorkerService;
import com.example.practice.services.ServicesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Main implements CommandLineRunner {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CarService carService;
    @Autowired
    private WorkerService workerService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ServicesService servicesService;

    @Override
    public void run(String... args){
        seedData();
    }
    private void printAllCarsByModel(String model) {
        carService
                .findCarByModel(model)
                .forEach(System.out::println);
    }
    private void printAllWorkerByCarId(long id) {
        workerService
                .findWorkerByCarId(id)
                .forEach(System.out::println);
    }
    private void printAllWorkerByCustomerId(long id) {
        workerService
                .findWorkerByCustomerId(id)
                .forEach(System.out::println);
    }
    private void printWorkersByCarBrandAndModel(String brand, String model) {
        workerService
                .findWorkersByCarBrandAndModel(brand, model)
                .forEach(System.out::println);
    }

    private void seedData() {
        CarDto car1 = new CarDto(null, "А123ВК77", "Audi", "A8 Long 55 TFCI IV", "Седан", "Бензин");
        CarDto car2 = new CarDto(null, "У456ПТ99", "Hyundai", "Palisade I", "Внедорожник 5 дв.", "Дизель");
        CarDto car3 = new CarDto(null, "А777МТ99", "Mercedes-Benz", "V-class XL 250 d экстра длинный II", "Минивэн", "Дизель");
        CarDto car4 = new CarDto(null, "А777ТО77", "Great", "Wall Safe", "Внедорожник 5 дв.", "Бензин");
        CustomerDto customer1 = new CustomerDto(null, "Иванова Елена Сергеевна", "MailExpress@mail.ru", "+7(968)816-59-49");
        CustomerDto customer2 = new CustomerDto(null, "Антонова Надежда Валерьевна", "AutoEnthusiastMail@mail.ru", "+7(977)254-47-11");
        CustomerDto customer3 = new CustomerDto(null, "Иванов Валентин Сергеевич", "AutoMailHub@mail.ru", "+7(960)445-93-34");
        CustomerDto customer4 = new CustomerDto(null, "Смирнова Татьяна Андреевна", "DriveMailPro@mail.ru", "+7(984)633-55-94");
        car1 = carService.register(car1);
        car2 = carService.register(car2);
        car3 = carService.register(car3);
        car4 = carService.register(car4);
        customer1 = customerService.register(customer1);
        customer2 = customerService.register(customer2);
        customer3 = customerService.register(customer3);
        customer4 = customerService.register(customer4);
        WorkerDto worker1 = new WorkerDto(null, "Иванова Екатерина Павловна", "Мастер по ремонту двигателей", "07.07.2020", 55000);
        WorkerDto worker2 = new WorkerDto(null, "Петров Андрей Игоревич", "Автомеханик по диагностике", "15.03.2019", 75000);
        WorkerDto worker3 = new WorkerDto(null, "Семенова Александра Игоревна", "Диагност по электронике и электрике", "10.04.2020", 48500);
        WorkerDto worker4 = new WorkerDto(null, "Козлов Максим Андреевич", "Мастер по кузовному ремонту", "22.11.2019", 42800);
        worker1 = workerService.register(worker1);
        worker2 = workerService.register(worker2);
        worker3 = workerService.register(worker3);
        worker4 = workerService.register(worker4);
        OrderDto order1 = new OrderDto(null, car1, customer1, "25.03.2018", "В ожидании обработки");
        OrderDto order2 = new OrderDto(null, car2, customer2, "15.03.2022", "В обработке");
        OrderDto order3 = new OrderDto(null, car3, customer3, "02.08.2021", "Готов к отправке");
        OrderDto order4 = new OrderDto(null, car4, customer4, "18.05.2019", "Доставлен");
        order1 = orderService.register(order1);
        order2 = orderService.register(order2);
        order3 = orderService.register(order3);
        order4 = orderService.register(order4);
        ServicesDto se1 = new ServicesDto(null, worker1, car1, "Замена масла и фильтра воздушного", "07.12.2020", 2350 );
        ServicesDto se2 = new ServicesDto(null, worker2, car2, "Диагностика и регулировка топливной системы", "25.09.2021", 8750);
        ServicesDto se3 = new ServicesDto(null, worker3, car3, "Замена тормозных колодок и дисков", "14.07.2021", 12350);
        ServicesDto se4 = new ServicesDto(null, worker4, car4, "Диагностика и ремонт трансмиссии", "03.03.2020", 16900);
        se1 = servicesService.register(se1);
        se2 = servicesService.register(se2);
        se3 = servicesService.register(se3);
        se4 = servicesService.register(se4);

        //printAllCarsByModel("A8 Long 55 TFCI IV");
        //printAllCarsByModel("Palisade I");
        //printAllWorkerByCustomerId(1);
        //printAllWorkerByCarID(1);
        printWorkersByCarBrandAndModel("Audi", "A8 Long 55 TFCI IV");
    }
}

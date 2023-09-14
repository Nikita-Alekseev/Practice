package com.example.practice.controllers;

import com.example.practice.controllers.exception.OrderNotFoundException;
import com.example.practice.dtos.OrderDto;
import com.example.practice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping()
    Iterable<OrderDto> all(){
        return orderService.getAll();
    }
    @GetMapping("/{id}")
    OrderDto get(@PathVariable Long id){
        return orderService.get(id).orElseThrow(() -> new OrderNotFoundException(id));
    }
    @PostMapping
        OrderDto createOrder(@RequestBody OrderDto order){
        return orderService.register(order);
    }
    @DeleteMapping("/{id}")
    void deleteOrder(@PathVariable Long id){
        orderService.delete(id);
    }
    @PutMapping()
    OrderDto update(@RequestBody OrderDto order){
        return orderService.update(order);
    }
}

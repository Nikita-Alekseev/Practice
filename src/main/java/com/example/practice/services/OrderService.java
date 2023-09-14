package com.example.practice.services;

import com.example.practice.dtos.OrderDto;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    OrderDto register(OrderDto order);

    List<OrderDto> getAll();

    Optional<OrderDto> get(Long id);

    void delete(Long id);

    OrderDto update(OrderDto order);

}


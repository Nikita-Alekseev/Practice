package com.example.practice.services.impl;

import com.example.practice.controllers.exception.OrderConflictException;
import com.example.practice.controllers.exception.OrderNotFoundException;

import com.example.practice.dtos.OrderDto;
import com.example.practice.models.Order;
import com.example.practice.repositories.OrderRepository;
import com.example.practice.services.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDto register(OrderDto order) {
        Order b = modelMapper.map(order, Order.class);
        if (b.getId() == null || b.getId() == 0 || get(b.getId()).isEmpty()) {
            return modelMapper.map(orderRepository.save(b), OrderDto.class);
        } else {
            throw new OrderConflictException("A order with this id already exists");
        }
    }

    @Override
    public List<OrderDto> getAll() {
        return orderRepository.findAll().stream().map((s) -> modelMapper.map(s, OrderDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<OrderDto> get(Long id) {
        return Optional.ofNullable(modelMapper.map(orderRepository.findById(id), OrderDto.class));
    }

    @Override
    public void delete(Long id) {
        if (orderRepository.findById(id).isPresent()) {
            orderRepository.deleteById(id);
        } else {
            throw new OrderNotFoundException(id);
        }
    }

    @Override
    public OrderDto update(OrderDto order) {
        if (orderRepository.findById(order.getId()).isPresent()) {
            return modelMapper.map(orderRepository.save(modelMapper.map(order, Order.class)), OrderDto.class);
        } else {
            throw new OrderNotFoundException(order.getId());
        }
    }
}
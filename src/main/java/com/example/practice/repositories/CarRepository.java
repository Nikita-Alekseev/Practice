package com.example.practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.practice.models.Car;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByModel(String model);
}

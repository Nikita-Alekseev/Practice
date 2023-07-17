package com.example.testlol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.testlol.models.Car;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByModel(String model);
}

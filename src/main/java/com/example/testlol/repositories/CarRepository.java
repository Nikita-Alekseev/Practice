package com.example.testlol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.testlol.models.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}

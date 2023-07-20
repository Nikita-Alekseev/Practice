package com.example.testlol.repositories;

import com.example.testlol.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarOptionRepository extends JpaRepository<Car, Long> {
}

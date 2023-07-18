package com.example.testlol.repositories;

import com.example.testlol.models.Car;
import com.example.testlol.models.Option;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OptionRepository extends JpaRepository<Option, Long> {

}

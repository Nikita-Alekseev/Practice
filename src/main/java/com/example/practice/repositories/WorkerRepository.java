package com.example.practice.repositories;

import com.example.practice.models.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
    //List<Worker> findAllByCustomerId(Long id);
    @Query("SELECT s FROM Worker s WHERE s.customer = :customerId")
   List<Worker> findAllByCustomerId(@Param("customerId") Long id);
    List<Worker> findAllByCarId(Long id);
    @Query("SELECT s FROM Worker s JOIN s.car c WHERE c.brand = :brand AND c.model = :model")
    List<Worker> findWorkersByCarBrandAndModel(@Param("brand") String brand, @Param("model") String model);
}

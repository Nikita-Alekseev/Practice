package com.example.practice.services;
import com.example.practice.dtos.WorkerDto;

import java.util.List;
import java.util.Optional;

public interface WorkerService {
    WorkerDto register(WorkerDto worker);
    Optional<WorkerDto> getWorkerById(Long id);
    List<WorkerDto> getAllWorkers();
    void delete(Long id);
    WorkerDto update(WorkerDto worker);
    List<WorkerDto> findWorkerByCarId(Long id);
    List<WorkerDto> findWorkerByCustomerId(Long id);
    List<WorkerDto> findWorkersByCarBrandAndModel(String brand, String model);
}

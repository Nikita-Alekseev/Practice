package com.example.practice.services.impl;

import com.example.practice.controllers.exception.WorkerConflictException;
import com.example.practice.controllers.exception.WorkerNotFoundException;
import com.example.practice.dtos.WorkerDto;
import com.example.practice.models.Worker;
import com.example.practice.repositories.WorkerRepository;
import com.example.practice.services.WorkerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    private ModelMapper modelMapper;

    public WorkerServiceImpl(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public WorkerDto register(WorkerDto worker) {
        Worker s = modelMapper.map(worker, Worker.class);
        if (s.getId() == null || s.getId() == 0 || getWorkerById(s.getId()).isEmpty()) {
            return modelMapper.map(workerRepository.save(s), WorkerDto.class);
        } else {
            throw new WorkerConflictException("A worker with this id already exists");
        }
    }

    @Override
    public WorkerDto update(WorkerDto worker) {
        if (workerRepository.findById(worker.getId()).isPresent()) {
            return modelMapper.map(workerRepository.save(modelMapper.map(worker, Worker.class)), WorkerDto.class);
        } else {
            throw new WorkerNotFoundException(worker.getId());
        }
    }
    @Override
    public Optional<WorkerDto> getWorkerById(Long id) {
        return Optional.ofNullable(modelMapper.map(workerRepository.findById(id), WorkerDto.class));
    }

    @Override
    public List<WorkerDto> getAllWorkers() {
        return workerRepository.findAll().stream().map((s) -> modelMapper.map(s, WorkerDto.class)).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (workerRepository.findById(id).isPresent()) {
            workerRepository.deleteById(id);
        } else {
            throw new WorkerNotFoundException(id);
        }
    }
    @Override
    public List<WorkerDto> findWorkerByCarId(Long id) {
        return workerRepository.findAllByCarId(id).stream().map((s) -> modelMapper.map(s, WorkerDto.class)).collect(Collectors.toList());
    }
    @Override
    public List<WorkerDto> findWorkerByCustomerId(Long id) {
        return workerRepository.findAllByCustomerId(id).stream().map((s) -> modelMapper.map(s, WorkerDto.class)).collect(Collectors.toList());
    }
    @Override
    public List<WorkerDto> findWorkersByCarBrandAndModel(String brand, String model) {
        return workerRepository.findWorkersByCarBrandAndModel(brand, model).stream().map((s) -> modelMapper.map(s, WorkerDto.class)).collect(Collectors.toList());
    }
}

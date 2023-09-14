package com.example.practice.controllers;

import com.example.practice.controllers.exception.WorkerNotFoundException;
import com.example.practice.dtos.WorkerDto;
import com.example.practice.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/worker")
public class WorkerController {
    @Autowired
    private WorkerService workerService;
    @GetMapping()
    Iterable<WorkerDto> all(){
        return workerService.getAllWorkers();
    }
    @GetMapping("/{id}")
    WorkerDto get(@PathVariable Long id) {
        return workerService.getWorkerById(id).orElseThrow(() -> new WorkerNotFoundException(id));
    }
    @PostMapping()
    WorkerDto createWorker(@RequestBody WorkerDto worker){
        return workerService.register(worker);
    }
    @DeleteMapping("/{id}")
    void deleteWorker(@PathVariable Long id){
        workerService.delete(id);
    }
    @PutMapping()
    WorkerDto update(WorkerDto worker){
        return workerService.update(worker);
    }
}


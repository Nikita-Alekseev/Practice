package com.example.testlol.controllers;

import com.example.testlol.controllers.exception.OptionNotFoundException;
import com.example.testlol.dtos.OptionDto;
import com.example.testlol.services.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/option")
public class OptionController {
    @Autowired
    private OptionService optionService;
    @GetMapping()
    Iterable<OptionDto> all(){return optionService.getAllOptions();}
    @GetMapping("/{id}")
    OptionDto get(Long id){
        return optionService.getOptionById(id).orElseThrow(() -> new OptionNotFoundException(id));
    }
    @PostMapping()
    OptionDto createOption(@RequestBody OptionDto option){
        return optionService.register(option);
    }
    @DeleteMapping("/{id}")
    void deleteOption(@PathVariable Long id){optionService.delete(id);}
    @PutMapping()
    OptionDto update(OptionDto option){
        return optionService.update(option);
    }
}

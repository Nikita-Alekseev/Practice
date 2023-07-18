package com.example.testlol.controllers;

import com.example.testlol.controllers.exception.SaleNotFoundException;
import com.example.testlol.dtos.SaleDto;
import com.example.testlol.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    private SaleService saleService;
    @GetMapping()
    Iterable<SaleDto> all(){
        return saleService.getAllSales();
    }
    @GetMapping("/{id}")
    SaleDto get(@PathVariable Long id) {
        return saleService.getSaleById(id).orElseThrow(() -> new SaleNotFoundException(id));
    }
    @PostMapping()
    SaleDto createSale(SaleDto sale){
        return saleService.register(sale);
    }
    @DeleteMapping("/{id}")
    void deleteSale(@PathVariable Long id){
        saleService.delete(id);
    }
    @PutMapping()
    SaleDto update(SaleDto sale){
        return saleService.update(sale);
    }
}


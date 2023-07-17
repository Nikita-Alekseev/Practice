package com.example.testlol.services.impl;

import com.example.testlol.controllers.exception.CarConflictException;
import com.example.testlol.controllers.exception.CarNotFoundException;
import com.example.testlol.dtos.CustomerDto;
import com.example.testlol.dtos.SaleDto;
import com.example.testlol.models.Customer;
import com.example.testlol.models.Sale;
import com.example.testlol.repositories.SaleRepository;
import com.example.testlol.services.SaleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    SaleRepository saleRepository;
    @Autowired
    private ModelMapper modelMapper;

    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public SaleDto register(SaleDto sale) {
        Sale s = modelMapper.map(sale, Sale.class);
        if (s.getId() == null || s.getId() == 0 || getSaleById(s.getId()).isEmpty()) {
            return modelMapper.map(saleRepository.save(s), SaleDto.class);
        } else {
            throw new CarConflictException("A sale with this id already exists");
        }
    }

    @Override
    public SaleDto update(SaleDto sale) {
        if (saleRepository.findById(sale.getId()).isPresent()) {
            return modelMapper.map(saleRepository.save(modelMapper.map(sale, Sale.class)), SaleDto.class);
        } else {
            throw new CarNotFoundException(sale.getId());
        }
    }
    @Override
    public Optional<SaleDto> getSaleById(Long id) {
        return Optional.ofNullable(modelMapper.map(saleRepository.findById(id), SaleDto.class));
    }

    @Override
    public List<SaleDto> getAllSales() {
        return saleRepository.findAll().stream().map((s) -> modelMapper.map(s, SaleDto.class)).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (saleRepository.findById(id).isPresent()) {
            saleRepository.deleteById(id);
        } else {
            throw new CarNotFoundException(id);
        }
    }
}

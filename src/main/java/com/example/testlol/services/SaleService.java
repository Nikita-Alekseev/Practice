package com.example.testlol.services;
import com.example.testlol.models.Sale;

import java.util.List;

public interface SaleService {
    Sale saveSale(Sale sale);
    Sale getSaleById(Long id);
    List<Sale> getAllSales();
}

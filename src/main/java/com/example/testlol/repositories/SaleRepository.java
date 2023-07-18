package com.example.testlol.repositories;

import com.example.testlol.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    //List<Sale> findAllByCustomerId(Long id);
    @Query("SELECT s FROM Sale s WHERE s.customer.id = :customerId")
    List<Sale> findAllByCustomerId(@Param("customerId") Long id);
    List<Sale> findAllByCarId(Long id);
    @Query("SELECT s FROM Sale s JOIN s.car c WHERE c.brand = :brand AND c.year = :year")
    List<Sale> findSalesByCarBrandAndYear(@Param("brand") String brand, @Param("year") String year);

}

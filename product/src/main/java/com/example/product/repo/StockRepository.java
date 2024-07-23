package com.example.product.repo;

import com.example.product.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, String> {
    Stock findStockByZone(String zone);
}
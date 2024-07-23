package com.example.product.service;

import com.example.shared.StockDTO;
import com.example.product.entity.Stock;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "stock-service", url = "http://localhost:9999/api/stock")
public interface StockClient {
    @GetMapping("/{id}")
    StockDTO getStockById(@PathVariable("id") String id);
}

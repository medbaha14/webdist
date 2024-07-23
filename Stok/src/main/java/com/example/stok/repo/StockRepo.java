package com.example.stok.repo;

import com.example.stok.entity.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepo extends MongoRepository<Stock, String> {
}


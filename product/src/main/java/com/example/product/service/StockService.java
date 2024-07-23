package com.example.product.service;

import com.example.shared.StockDTO;
import com.example.product.entity.Stock;
import com.example.product.repo.StockRepository;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    private final Gson gson = new Gson();

    @KafkaListener(topics = "stockTopic", groupId = "myGroup")
    public void upDateStock(String message) {
        StockDTO stockDto = gson.fromJson(message, StockDTO.class); // Deserialize JSON to StockDto object
        log.info(stockDto.toString());

        Stock stock = stockRepository.findStockByZone(stockDto.getZone());

        if (stock != null) {
            boolean updated = false;

            if (!Objects.equals(stock.getZone(), stockDto.getZone())) {
                stock.setZone(stockDto.getZone());
                updated = true;
            }

            if (updated) {
                stockRepository.save(stock);
                log.info("Stock updated: {}", stock);
            } else {
                log.info("Stock already up-to-date, no changes made");
            }

        } else {
            stock = new Stock();
            stock.generateId();
            stock.setZone(stockDto.getZone());

            stockRepository.save(stock);
            log.info("New stock created: {}", stock);
        }
    }
    public String generateId() {
       return UUID.randomUUID().toString(); // Example for generating a unique ID
    }
}

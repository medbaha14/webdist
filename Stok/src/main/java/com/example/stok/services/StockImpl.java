package com.example.stok.services;

import com.example.stok.StockDTO.StockDTO;
import com.example.stok.entity.Stock;
import com.example.stok.mapper.MapToDto;
import com.example.stok.repo.StockRepo;
import com.example.stok.services.Iservice.IstockService;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
public class StockImpl implements IstockService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    StockRepo stockRepository;
    @Autowired
    MapToDto mapToDto;

    @Override
    public StockDTO getStockById(String id) {
        return mapToDto.maptoStockDTO(stockRepository.findById(id).get());
    }
    @Override
    public StockDTO saveStock(Stock stock) {
        StockDTO stockDTO= mapToDto.maptoStockDTO(stockRepository.save(stock));
        log.info(stockDTO.toString());
        StockDTO stockDto = StockDTO.builder()
                .zone(stock.getZone())
                .build();
        Gson gson = new Gson(); // Create Gson instance
        String json = gson.toJson(stockDto); // Serialize Stock to JSON
        kafkaTemplate.send("stockTopic", json);
        return stockDTO;
    }

}

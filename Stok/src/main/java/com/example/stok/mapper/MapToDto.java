package com.example.stok.mapper;



import com.example.stok.StockDTO.StockDTO;
import com.example.stok.entity.Stock;
import org.springframework.stereotype.Component;

@Component
public class MapToDto {

    public StockDTO maptoStockDTO(Stock stock){

        StockDTO stockDTO=new StockDTO();
        stockDTO.setId(stock.getId());
        stockDTO.setZone(stock.getZone());

    return stockDTO;
    }
}

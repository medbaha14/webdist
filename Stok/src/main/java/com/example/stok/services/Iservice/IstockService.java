package com.example.stok.services.Iservice;

import com.example.stok.StockDTO.StockDTO;
import com.example.stok.entity.Stock;

public interface IstockService {
    public StockDTO getStockById( String id);
    public StockDTO saveStock(Stock stock);
}

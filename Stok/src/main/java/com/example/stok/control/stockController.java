package com.example.stok.control;

import com.example.stok.StockDTO.StockDTO;
import com.example.stok.entity.Stock;
import com.example.stok.services.Iservice.IstockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
public class stockController {
    @Autowired
    IstockService stockS;

    @GetMapping("/{id}")
    public StockDTO getStockById(@PathVariable String id) {
        return stockS.getStockById(id);
    }

    @PostMapping
    public StockDTO createStock(@RequestBody Stock stock) {
        return stockS.saveStock(stock);
    }
}

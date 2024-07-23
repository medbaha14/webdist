package com.example.product.service;

import com.example.product.ProductDTO.ProductDTO;
import com.example.shared.StockDTO;
import com.example.product.entity.Product;
import com.example.product.mapper.MapToDto;
import com.example.product.repo.ProductRepository;
import com.example.product.service.Iservice.IproductService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProductServiceImpl implements IproductService {
    @Autowired
    ProductRepository productRepo;
    @Autowired
    MapToDto mapToDto;
    @Autowired
    private StockClient stockClient;
    @Autowired
    private RestTemplate restTemplate;

    private static final String STOCK_SERVICE_URL = "http://localhost:9999/api/stock";


    @Override
    public ProductDTO getProductById(Long id) {
        Product product=productRepo.findById(id).get();
        StockDTO stock=stockClient.getStockById(product.getStockId());
        ProductDTO dto =mapToDto.maptoProductDTO(stock,product);
        return dto;
    }

//    @Override
//    public ProductDTO saveProduct(Product product) {
//
//        Product prod=productRepo.save(product);
//        Stock stock=stockClient.getStockById(product.getStockId());
//        ProductDTO dto =mapToDto.maptoProductDTO(stock,prod);
//        return dto;
//    }
    public StockDTO getStockById(String stockId) {
        return restTemplate.getForObject(STOCK_SERVICE_URL + "/" + stockId, StockDTO.class);
    }

    public ProductDTO saveProduct( Product product) {
        StockDTO stock = getStockById(product.getStockId());
        Product prod=productRepo.save(product);
        ProductDTO dto =mapToDto.maptoProductDTO(stock,prod);
        return dto;
    }

}

package com.example.product.mapper;


import com.example.product.ProductDTO.ProductDTO;
import com.example.shared.StockDTO;
import com.example.product.entity.Product;
import com.example.product.entity.Stock;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class MapToDto {

    public ProductDTO maptoProductDTO(StockDTO stock, Product product){

        ProductDTO productDTO=new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setStockZone(stock.getZone());
    return productDTO;
    }
}

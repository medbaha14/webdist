package com.example.product.service.Iservice;

import com.example.product.ProductDTO.ProductDTO;
import com.example.product.entity.Product;

public interface IproductService {
    public ProductDTO getProductById(Long id);
    public ProductDTO saveProduct(Product product);
}

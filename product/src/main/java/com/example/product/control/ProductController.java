package com.example.product.control;

import com.example.product.ProductDTO.ProductDTO;
import com.example.product.entity.Product;
import com.example.product.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;
    @GetMapping("/{id}")
    public ProductDTO getProductWithStock(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }
}

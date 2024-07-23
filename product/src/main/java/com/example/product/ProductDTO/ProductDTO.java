package com.example.product.ProductDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private Long id;
    private String name;
    private int quantity;
    private String stockZone;
}

package com.example.shared;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data

@Getter
@Setter
public class ProductDTO {
    private Long id;
    private String name;
    private int quantity;
    private String stockZone;
}

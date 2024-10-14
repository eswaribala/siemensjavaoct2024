package com.siemens.webstore.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private long productId;
    private String name;
    private String description;
    private int cost;


}

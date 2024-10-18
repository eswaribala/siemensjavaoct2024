package com.siemens.webstore.webstoreapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse {

    private long categoryId;
    private String categoryName;
    private String catalogName;
}

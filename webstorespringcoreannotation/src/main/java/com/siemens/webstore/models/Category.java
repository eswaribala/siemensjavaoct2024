package com.siemens.webstore.models;

import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Category {
    private int categoryId;
    private String categoryName;
    private String subCategoryName;
    @PreDestroy
    public void beforeDestroy(){
        System.out.println("Pre destroy invoked....");
    }
}

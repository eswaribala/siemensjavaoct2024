package com.siemens.webstore.models;

import com.siemens.webstore.exceptions.ProductCostException;

/*import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data*/
public class Product {
    private long productId;
    private String name;
    private String description;
    private int cost;

    public Product(long productId, String name, String description, int cost) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public Product() {
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }
}

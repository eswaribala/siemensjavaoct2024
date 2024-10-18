package com.siemens.webstore.webstoreapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Product")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Product {
    @Id
    @GeneratedValue(generator = "product-id")
    @GenericGenerator(name = "product-id", strategy = "com.siemens.webstore.webstoreapi.models.CustomIdGenerator") // Adjust package name
    @Column(name="Product_Id")
    protected String productId;
    @Column(name="Cost")
    protected long cost;
    @Column(name="Rating")
    protected byte rating;
    @Enumerated(EnumType.STRING)
    @Column(name="Product_Type")
    protected ProductType productType;


}

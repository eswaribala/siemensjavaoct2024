package com.siemens.webstore.webstoreapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name="Product")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Product_Id")
    protected long productId;
    @Column(name="Cost")
    protected long cost;
    @Column(name="Rating")
    protected byte rating;
    @Enumerated(EnumType.STRING)
    @Column(name="Product_Type")
    protected ProductType productType;


}

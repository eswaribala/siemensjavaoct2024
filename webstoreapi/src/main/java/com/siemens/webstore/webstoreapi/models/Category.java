package com.siemens.webstore.webstoreapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Category_Id")
    private long categoryId;
    @Column(name="Category_Name",nullable = false,length = 100)
    private String categoryName;
    @Column(name="SubCategory_Name",nullable = false,length = 100)
    private String subCategoryName;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name = "Catalog_Id"),
            name = "Catalog_Id_FK")
    private Catalog catalog;
}

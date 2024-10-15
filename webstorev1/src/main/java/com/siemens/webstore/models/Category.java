package com.siemens.webstore.models;

import java.io.Serializable;

public class Category implements Serializable {
    private int categoryId;
    private String categoryName;
    private String subCategoryName;

    private transient String secretKey;



    public Category(int categoryId, String categoryName, String subCategoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.subCategoryName = subCategoryName;

    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", subCategoryName='" + subCategoryName + '\'' +
                ", secretKey='" + secretKey + '\'' +
                '}';
    }
}

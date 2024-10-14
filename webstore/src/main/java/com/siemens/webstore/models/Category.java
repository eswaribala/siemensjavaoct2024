package com.siemens.webstore.models;

public class Category {
    private int categoryId;
    private String categoryName;
    private String subCategoryName;

    private Product[] products;

    public Category(int categoryId, String categoryName, String subCategoryName, Product[] products) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.subCategoryName = subCategoryName;
        this.products = products;
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

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
}

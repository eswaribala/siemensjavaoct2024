package com.siemens.webstore.dao;

import com.siemens.webstore.models.Product;

import java.io.IOException;

public interface ProductDao {

    boolean addProduct(Product product) throws IOException;

    Product[] getProducts() throws IOException;
}

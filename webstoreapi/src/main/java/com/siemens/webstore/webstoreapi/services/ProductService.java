package com.siemens.webstore.webstoreapi.services;

import com.siemens.webstore.webstoreapi.models.Product;


import java.util.List;

public interface ProductService {
    Product addProduct(Product product);
    List<Product> findAllProducts();
    Product findProductById(String productId);

    default Product updateProduct(String productId, byte rating){
        return null;
    }

    boolean deleteProduct(String productId);
    
}

package com.siemens.webstore.webstoreapi.services;

import com.siemens.webstore.webstoreapi.models.Product;
import com.siemens.webstore.webstoreapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product addProduct(Product product) {
        if(product.getCost()>0)
            return this.productRepository.save(product);
        else
            return  null;
    }

    @Override
    public List<Product> findAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product findProductById(String productId) {
        return this.productRepository.findById(productId).orElse(null);
    }

    @Override
    public Product updateProduct(String productId, byte rating) {
        //step1
        Product product=findProductById(productId);
        if(product!=null){
            product.setRating(rating);
            return this.productRepository.save(product);
        }else
            return null;
    }

    @Override
    public boolean deleteProduct(String productId) {
        boolean status=false;
        Product Product=findProductById(productId);
        if(Product!=null){
            this.productRepository.deleteById(productId);
            status=true;
        }
        return status;
    }
}

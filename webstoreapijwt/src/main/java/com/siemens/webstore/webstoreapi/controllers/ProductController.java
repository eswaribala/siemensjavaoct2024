package com.siemens.webstore.webstoreapi.controllers;

import com.siemens.webstore.webstoreapi.dtos.ResponseWrapper;
import com.siemens.webstore.webstoreapi.models.Product;
import com.siemens.webstore.webstoreapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {


    @Autowired
    private ProductService productService;

    @PostMapping("/v1.0")
    public ResponseEntity<ResponseWrapper> saveProduct(@RequestBody Product product){

        Product productInstance=this.productService.addProduct(product);
        if(productInstance!=null)
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ResponseWrapper(productInstance));
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseWrapper("Product Instance not created"));


    }

    @GetMapping("/v1.0")
    public List<Product> getAllProducts(){
        return this.productService.findAllProducts();
    }


    @GetMapping("/v1.0/{productId}")
    public ResponseEntity<ResponseWrapper> findProductById(@PathVariable("productId") String productId){

        Product productInstance=this.productService.findProductById(productId);
        if(productInstance!=null)
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseWrapper(productInstance));
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseWrapper("Product Instance not available"));


    }



    @PutMapping("/v1.0")
    public ResponseEntity<ResponseWrapper> updateProductById(@RequestParam("productId") String productId,
                                                             @RequestParam("rating") byte rating){

        Product productInstance=this.productService.updateProduct(productId,rating);
        if(productInstance!=null)
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseWrapper(productInstance));
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseWrapper("Product Instance Could not be updated because of invalid Product id"));


    }

    @DeleteMapping("/v1.0")
    public ResponseEntity<ResponseWrapper> deleteProductById(@RequestParam("productId") String productId){


        if(this.productService.deleteProduct(productId))
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseWrapper("Product Id="+productId+"deleted successfully"));
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseWrapper("Product Id="+productId+"Could not be found"));


    }

}

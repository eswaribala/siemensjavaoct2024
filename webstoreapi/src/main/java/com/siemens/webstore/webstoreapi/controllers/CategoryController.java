package com.siemens.webstore.webstoreapi.controllers;

import com.siemens.webstore.webstoreapi.dtos.ResponseWrapper;
import com.siemens.webstore.webstoreapi.models.Catalog;
import com.siemens.webstore.webstoreapi.models.Category;
import com.siemens.webstore.webstoreapi.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping("/v1.0")
    public ResponseEntity<ResponseWrapper> saveCategory(@RequestBody Category Category){

        Category CategoryInstance=this.categoryService.addCategory(Category);
        if(CategoryInstance!=null)
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ResponseWrapper(CategoryInstance));
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseWrapper("Category Instance not created"));


    }

    @GetMapping("/v1.0")
    public List<Category> getAllCategories(){
        return this.categoryService.findAllCategories();
    }

    @GetMapping("/v1.0/{catalogId}")
    public ResponseEntity<ResponseWrapper> getCategoriesBYCatalogId(@PathVariable("catalogId") long catalogId){
        List<String> categories =this.categoryService.findCategoriesByCatalogId(catalogId);
        if(categories.size()>0)
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseWrapper(categories));
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseWrapper("Category Not found"));
    }
}

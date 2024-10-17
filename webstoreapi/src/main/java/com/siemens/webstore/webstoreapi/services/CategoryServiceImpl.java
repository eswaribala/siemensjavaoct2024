package com.siemens.webstore.webstoreapi.services;

import com.siemens.webstore.webstoreapi.models.Catalog;
import com.siemens.webstore.webstoreapi.models.Category;
import com.siemens.webstore.webstoreapi.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CatalogService catalogService;
    @Override
    public Category addCategory(Category category) {
      Catalog catalog= catalogService.findCatalogById(category.getCatalog().getCatalogId());
       if(catalog!=null){
           category.setCatalog(catalog);
           return this.categoryRepository.save(category);
       }else
         return null;
    }

    @Override
    public List<Category> findAllCategories() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category findCategoryById(long categoryId) {
        return this.categoryRepository.findById(categoryId).orElse(null);
    }

    @Override
    public List<Category> findCategoryByName(String categoryName) {
        return this.categoryRepository.findByCategoryName(categoryName);
    }

    @Override
    public Category updateCategory(long categoryId, String categoryName) {
//step1
        Category category=findCategoryById(categoryId);
        if(category!=null){
            category.setCategoryName(categoryName);
            return this.categoryRepository.save(category);
        }else
            return null;

       }

    @Override
    public boolean deleteCategory(long categoryId) {
        boolean status=false;
        Category category=findCategoryById(categoryId);
        if(category!=null){
            this.categoryRepository.deleteById(categoryId);
            status=true;
        }
        return status;
    }
}

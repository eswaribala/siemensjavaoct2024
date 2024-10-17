package com.siemens.webstore.webstoreapi.services;

import com.siemens.webstore.webstoreapi.models.Catalog;
import com.siemens.webstore.webstoreapi.models.Category;

import java.util.List;

public interface CategoryService {

    Category addCategory(Category category);
    List<Category> findAllCategories();
    Category findCategoryById(long categoryId);
    List<Category> findCategoryByName(String categoryName);
    default Category updateCategory(long categoryId, String categoryName){
        return null;
    }

    boolean deleteCategory(long categoryId);
}

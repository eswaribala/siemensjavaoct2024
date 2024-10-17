package com.siemens.webstore.webstoreapi.repositories;

import com.siemens.webstore.webstoreapi.models.Catalog;
import com.siemens.webstore.webstoreapi.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("FROM Category c WHERE c.categoryName = :categoryName")
    List<Category> findByCategoryName(@Param("categoryName") String categoryName);
}

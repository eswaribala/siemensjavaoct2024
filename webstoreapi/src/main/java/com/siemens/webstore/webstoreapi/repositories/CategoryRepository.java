package com.siemens.webstore.webstoreapi.repositories;

import com.siemens.webstore.webstoreapi.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

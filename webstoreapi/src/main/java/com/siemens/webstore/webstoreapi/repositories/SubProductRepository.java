package com.siemens.webstore.webstoreapi.repositories;

import com.siemens.webstore.webstoreapi.models.SubProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubProductRepository extends JpaRepository<SubProduct,String> {
}

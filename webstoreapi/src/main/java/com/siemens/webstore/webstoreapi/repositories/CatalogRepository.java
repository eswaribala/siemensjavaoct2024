package com.siemens.webstore.webstoreapi.repositories;

import com.siemens.webstore.webstoreapi.models.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CatalogRepository extends JpaRepository<Catalog,Long> {

}

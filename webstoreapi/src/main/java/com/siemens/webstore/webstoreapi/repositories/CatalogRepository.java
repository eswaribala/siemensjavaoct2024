package com.siemens.webstore.webstoreapi.repositories;

import com.siemens.webstore.webstoreapi.models.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public interface CatalogRepository extends JpaRepository<Catalog,Long> {

}

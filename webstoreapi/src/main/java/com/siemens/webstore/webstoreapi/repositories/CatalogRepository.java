package com.siemens.webstore.webstoreapi.repositories;

import com.siemens.webstore.webstoreapi.models.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CatalogRepository extends JpaRepository<Catalog,Long> {

    @Query("FROM Catalog c WHERE c.catalogName = :catalogName")
    List<Catalog> findByCatalogName(@Param("catalogName") String catalogName);


}

package com.siemens.webstore.webstoreapi.services;

import com.siemens.webstore.webstoreapi.dtos.CatalogRequest;
import com.siemens.webstore.webstoreapi.models.Catalog;

import java.util.List;

public interface CatalogService {

    Catalog addCatalog(CatalogRequest catalogRequest);
    List<Catalog> findAllCatalogs();
    Catalog findCatalogById(long catalogId);
    List<Catalog> findCatalogByName(String catalogName);
    default Catalog updateCatalog(long catalogId, String catalogName){
        return null;
    }

    boolean deleteCatalog(long catalogId);


}

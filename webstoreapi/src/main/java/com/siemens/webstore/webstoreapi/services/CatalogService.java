package com.siemens.webstore.webstoreapi.services;

import com.siemens.webstore.webstoreapi.models.Catalog;

import java.util.List;

public interface CatalogService {

    Catalog addCatalog(Catalog catalog);
    List<Catalog> findAllCatalogs();
    Catalog findCatalogById(long catalogId);

    default Catalog updateCatalog(long catalogId, String catalogName){
        return null;
    }

    boolean deleteCatalog(long catalogId);


}

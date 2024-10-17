package com.siemens.webstore.webstoreapi.services;

import com.siemens.webstore.webstoreapi.models.Catalog;
import com.siemens.webstore.webstoreapi.repositories.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private CatalogRepository catalogRepository;

    @Override
    public Catalog addCatalog(Catalog catalog) {
        if(catalog.getCatalogId()>0)
            return this.catalogRepository.save(catalog);
        else
          return  null;
    }

    @Override
    public List<Catalog> findAllCatalogs() {
        return this.catalogRepository.findAll();
    }

    @Override
    public Catalog findCatalogById(long catalogId) {
        return this.catalogRepository.findById(catalogId).orElse(null);
    }

    @Override
    public Catalog updateCatalog(long catalogId, String catalogName) {
      //step1
        Catalog catalog=findCatalogById(catalogId);
        if(catalog!=null){
            catalog.setCatalogName(catalogName);
            return this.catalogRepository.save(catalog);
        }else
            return null;


    }

    @Override
    public boolean deleteCatalog(long catalogId) {

        boolean status=false;
        Catalog catalog=findCatalogById(catalogId);
        if(catalog!=null){
           this.catalogRepository.deleteById(catalogId);
           status=true;
        }
        return status;
    }
}

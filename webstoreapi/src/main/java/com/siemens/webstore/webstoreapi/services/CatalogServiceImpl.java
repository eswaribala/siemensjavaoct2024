package com.siemens.webstore.webstoreapi.services;

import com.siemens.webstore.webstoreapi.models.Catalog;
import com.siemens.webstore.webstoreapi.repositories.CatalogRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private CatalogRepository catalogRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    public Catalog addCatalog(Catalog catalog) {
        if(catalog.getCatalogName().length()>0)
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
    public List<Catalog> findCatalogByName(String catalogName) {

      /*  CriteriaBuilder cb=entityManager.getCriteriaBuilder();
        CriteriaQuery<Catalog> criteriaQuery=cb.createQuery(Catalog.class);
        Root<Catalog> root=criteriaQuery.from(Catalog.class);
        Predicate predicate= cb.equal(root.get("catalogName"),catalogName);
        criteriaQuery.where(predicate);
        return entityManager.createQuery(criteriaQuery).getResultList();*/

          return this.catalogRepository.findByCatalogName(catalogName);
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

package com.siemens.webstore.webstoreapi.controllers;

import com.siemens.webstore.webstoreapi.dtos.ResponseWrapper;
import com.siemens.webstore.webstoreapi.models.Catalog;
import com.siemens.webstore.webstoreapi.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("catalogs")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @PostMapping("/v1.0")
    public ResponseEntity<ResponseWrapper> saveCatalog(@RequestBody Catalog catalog){

        Catalog catalogInstance=this.catalogService.addCatalog(catalog);
        if(catalogInstance!=null)
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ResponseWrapper(catalogInstance));
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseWrapper("Catalog Instance not created"));


    }

    @GetMapping("/v1.0")
    public List<Catalog> getAllCatalogs(){
        return this.catalogService.findAllCatalogs();
    }



}

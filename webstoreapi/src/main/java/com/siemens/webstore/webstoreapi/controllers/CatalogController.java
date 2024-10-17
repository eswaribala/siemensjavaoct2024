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


    @GetMapping("/v1.0/{catalogId}")
    public ResponseEntity<ResponseWrapper> findCatalogById(@PathVariable("catalogId") long catalogId){

        Catalog catalogInstance=this.catalogService.findCatalogById(catalogId);
        if(catalogInstance!=null)
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseWrapper(catalogInstance));
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseWrapper("Catalog Instance not available"));


    }

    @PutMapping("/v1.0")
    public ResponseEntity<ResponseWrapper> updateCatalogById(@RequestParam("catalogId") long catalogId,
                                                             @RequestParam("catalogName") String catalogName){

        Catalog catalogInstance=this.catalogService.updateCatalog(catalogId,catalogName);
        if(catalogInstance!=null)
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseWrapper(catalogInstance));
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseWrapper("Catalog Instance Could not be updated because of invalid catalog id"));


    }

    @DeleteMapping("/v1.0")
    public ResponseEntity<ResponseWrapper> deleteCatalogById(@RequestParam("catalogId") long catalogId){


        if(this.catalogService.deleteCatalog(catalogId))
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseWrapper("Catalog Id="+catalogId+"deleted successfully"));
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseWrapper("Catalog Id="+catalogId+"Could not be found"));


    }

}

package com.siemens.webstore.webstoreapi.controllers;

import com.siemens.webstore.webstoreapi.dtos.ResponseWrapper;
import com.siemens.webstore.webstoreapi.models.SubProduct;
import com.siemens.webstore.webstoreapi.services.SubProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subproducts")
public class SubProductController {

    @Autowired
    private SubProductService subProductService;

    @PostMapping("/v1.0")
    public ResponseEntity<ResponseWrapper> saveSubProduct(@RequestBody SubProduct subProduct){

        SubProduct subProductInstance=this.subProductService.addSubProduct(subProduct);
        if(subProductInstance!=null)
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ResponseWrapper(subProductInstance));
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseWrapper("SubProduct Instance not created"));


    }

    @GetMapping("/v1.0")
    public List<SubProduct> getAllSubProducts(){
        return this.subProductService.findAllSubProducts();
    }


    @GetMapping("/v1.0/{subProductId}")
    public ResponseEntity<ResponseWrapper> findSubProductById(@PathVariable("subProductId") String subProductId){

        SubProduct subProductInstance=this.subProductService.findSubProductById(subProductId);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseWrapper(subProductInstance));



    }



    @PutMapping("/v1.0")
    public ResponseEntity<ResponseWrapper> updateSubProductById(@RequestParam("subProductId") String subProductId,
                                                             @RequestParam("ingredients") String ingredients){

        SubProduct subProductInstance=this.subProductService.updateSubProduct(subProductId,ingredients);
        if(subProductInstance!=null)
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseWrapper(subProductInstance));
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseWrapper("SubProduct Instance Could not be updated because of invalid SubProduct id"));


    }

    @DeleteMapping("/v1.0")
    public ResponseEntity<ResponseWrapper> deleteSubProductById(@RequestParam("subProductId") String subProductId){


        if(this.subProductService.deleteSubProduct(subProductId))
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseWrapper("SubProduct Id="+subProductId+"deleted successfully"));
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseWrapper("SubProduct Id="+subProductId+"Could not be found"));


    }
}

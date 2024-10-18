package com.siemens.webstore.webstoreapi.services;

import com.siemens.webstore.webstoreapi.exceptions.SubProductNotFoundException;
import com.siemens.webstore.webstoreapi.models.SubProduct;

import com.siemens.webstore.webstoreapi.repositories.SubProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SubProductServiceImpl implements SubProductService{
    @Autowired
    private SubProductRepository subProductRepository;
    @Override
    public SubProduct addSubProduct(SubProduct subProduct) {
        if(subProduct.getExpiryDate().isAfter(LocalDate.now()))
            return this.subProductRepository.save(subProduct);
        else
            return  null;
    }

    @Override
    public List<SubProduct> findAllSubProducts() {
        return this.subProductRepository.findAll();
    }

    @Override
    public SubProduct findSubProductById(String subProductId) {
        return this.subProductRepository.findById(subProductId).orElseThrow(()->new
                SubProductNotFoundException("Sub Product Not Found because the given Product Id Not Existing"));
    }

    @Override
    public SubProduct updateSubProduct(String subProductId, String ingredients) {
        //step1
        SubProduct subProduct=findSubProductById(subProductId);
        if(subProduct!=null){
            subProduct.setIngredients(ingredients);
            return this.subProductRepository.save(subProduct);
        }else
            return null;
    }

    @Override
    public boolean deleteSubProduct(String subProductId) {
        boolean status=false;
        SubProduct SubProduct=findSubProductById(subProductId);
        if(SubProduct!=null){
            this.subProductRepository.deleteById(subProductId);
            status=true;
        }
        return status;
    }
}

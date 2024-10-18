package com.siemens.webstore.webstoreapi.services;

import com.siemens.webstore.webstoreapi.models.SubProduct;

import java.util.List;

public interface SubProductService {
    SubProduct addSubProduct(SubProduct subProduct);
    List<SubProduct> findAllSubProducts();
    SubProduct findSubProductById(String subProductId);

    default SubProduct updateSubProduct(String productId, String ingredients){
        return null;
    }

    boolean deleteSubProduct(String subProductId);
}

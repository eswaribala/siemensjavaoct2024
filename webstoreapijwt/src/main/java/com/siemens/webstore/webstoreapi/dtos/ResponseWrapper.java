package com.siemens.webstore.webstoreapi.dtos;

import lombok.Data;
import lombok.Getter;

@Getter
public class ResponseWrapper<T> {

    private T object;
    private String message;

    public ResponseWrapper(T object) {
        this.object = object;
    }

    public ResponseWrapper(String message) {
        this.message = message;
    }
}

package com.siemens.webstore.webstoreapi.exceptions;

public class SubProductNotFoundException extends RuntimeException{
    public SubProductNotFoundException(String message) {
        super(message);
    }
}

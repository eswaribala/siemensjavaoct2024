package com.siemens.webstore.facades;

@FunctionalInterface
public interface GenerateOTP {

    int getOTP(int min,int max);

}

package com.siemens.webstore.services;

public class DbService {
    public static int count;

    private DbService(){
        count++;
    }

    public static DbService getInstance(){
        if(count<1)
            return new DbService();
        else
            throw new RuntimeException("More than One Db service not possible");
    }

}

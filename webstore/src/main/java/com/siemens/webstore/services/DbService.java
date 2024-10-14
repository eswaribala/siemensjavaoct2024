package com.siemens.webstore.services;

import com.siemens.webstore.exceptions.DbServiceSingletonException;

public class DbService {
    public static int count;

    private DbService(){
        count++;
    }

    public static DbService getInstance() throws DbServiceSingletonException {
        if(count<1)
            return new DbService();
        else
            throw new DbServiceSingletonException("More than One Db service not possible");
    }

}

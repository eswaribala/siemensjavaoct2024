package com.siemens.webstore.webstoreapi;

import com.siemens.webstore.webstoreapi.models.Catalog;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CatalogTest {

    private static Catalog catalog;

    @BeforeAll
    public static void initializer(){
        catalog=new Catalog();
    }

    @Test
    public void catalogInstanceNotNull(){

        assertNotNull(catalog);
    }
}

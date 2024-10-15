package com.siemens.webstore.dao;

import com.siemens.webstore.models.Catalog;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface CatalogDao {

    boolean addCatalog(Catalog catalog) throws IOException;
    Catalog[] getCatalogs() throws IOException, ClassNotFoundException;

    void close() throws IOException;

}

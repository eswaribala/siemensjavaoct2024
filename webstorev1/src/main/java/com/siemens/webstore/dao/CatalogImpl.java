package com.siemens.webstore.dao;

import com.siemens.webstore.models.Catalog;

import java.io.*;
import java.io.EOFException;

public class CatalogImpl implements CatalogDao{

    private File file;
    private FileOutputStream fileOutputStream;
    private ObjectOutputStream objectOutputStream;

    public CatalogImpl(String dirName,String fileName) throws IOException {
        file=new File(dirName);
        if(!file.exists())
            file.mkdir();
        else
            System.out.println("Directory already exists");

        file=new File(dirName,fileName);
        if(!file.exists())
            file.createNewFile();
        else
            System.out.println("File already exists");

        fileOutputStream=new FileOutputStream(file,true);
        objectOutputStream=new ObjectOutputStream(fileOutputStream);

    }

    @Override
    public boolean addCatalog(Catalog catalog) throws IOException {
        boolean status=false;
        objectOutputStream.writeObject(catalog);
        status=true;
        return status;

    }

    @Override
    public Catalog[] getCatalogs() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream=new FileInputStream(file);
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
        Catalog[] catalogs=new Catalog[100];
        int i=0;
        Object object=null;
        try{

            while((object=objectInputStream.readObject())!=null){
                catalogs[i]=(Catalog) object;
                i++;
            }


        }catch (EOFException exception){

        }finally {
            fileInputStream.close();
            objectInputStream.close();
        }


        return catalogs;

    }
}

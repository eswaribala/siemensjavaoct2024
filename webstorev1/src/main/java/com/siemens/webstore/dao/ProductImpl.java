package com.siemens.webstore.dao;
import java.io.*;

import com.siemens.webstore.models.Product;

public class ProductImpl  implements ProductDao{

    private File file;
  public  ProductImpl(String dirName, String fileName) throws IOException {

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

    }

    @Override
    public boolean addProduct(Product product) throws IOException {

      boolean status=false;
      try(FileWriter fileWriter=new FileWriter(file,true);
          BufferedWriter bufferedWriter=new BufferedWriter(fileWriter)
        ){

          bufferedWriter.write(String.valueOf(product.getProductId()));
          bufferedWriter.write(",");
          bufferedWriter.write(product.getName());
          bufferedWriter.write(",");
          bufferedWriter.write(product.getDescription());
          bufferedWriter.write(",");
          bufferedWriter.write(String.valueOf(product.getCost()));
          bufferedWriter.write("\n");
          status=true;

      }

      return status;
    }

    @Override
    public Product[] getProducts() throws IOException {

      Product[] products=new Product[countLines()];
      String line=null;
      String[] fields=null;
      int i=0;
        try(FileReader fileReader=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader)){

            while((line=bufferedReader.readLine())!=null){
                fields=line.split(",");
                Product product=new Product(Integer.parseInt(fields[0]),
                        fields[1],fields[2],Integer.parseInt(fields[3]));
                products[i]=product;
                i++;

            }

        }

        return products;


    }

    public int countLines() throws IOException {
      int count=0;
      try(FileReader fileReader=new FileReader(file);
      BufferedReader bufferedReader=new BufferedReader(fileReader)){

          while(bufferedReader.readLine()!=null){
             count++;
          }

      }
      return count;
    }

}

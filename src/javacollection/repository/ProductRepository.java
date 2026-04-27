package javacollection.repository;


import javacollection.compare.compareProductID;
import javacollection.compare.compareProductPrice;
import javacollection.entity.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ProductRepository {


    public ArrayList<Product> getProductList(){
        ArrayList<Product> productList = new ArrayList<>();
        try(FileReader fileReader = new FileReader("src/javacollection/data/ProductData.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader)){
            String line;
            String[] data;
            Product product;
            while ((line =bufferedReader.readLine())!=null){
                if(line.trim().isEmpty()){
                    continue;
                }
             data=line.split(",");
             product = new Product(data[0],data[1],Double.parseDouble(data[2]) );
             productList.add(product);
            }
        }catch (FileNotFoundException e){
            System.out.println("Lỗi không tìm thấy file.");
        }catch (IOException e){
            System.out.println("Lỗi đọc file.");
        }
        return productList;
    }


    public boolean addProduct(Product product){
        try(FileWriter fileWriter= new FileWriter("src/javacollection/data/ProductData.csv",true);
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter)){
        bufferedWriter.write(converterProductToString(product));
        bufferedWriter.newLine();
        }catch (IOException e){
            System.out.println("Lỗi ghi file.");
        }
        return true;
    }

    public boolean saveProductList(ArrayList<Product> productList){
        try(FileWriter fileWriter= new FileWriter("src/javacollection/data/ProductData.csv",false);
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter)){
            for(Product product : productList){
                bufferedWriter.write(converterProductToString(product));
                bufferedWriter.newLine();

            }
            return true;
        }catch (IOException e){
            System.out.println("Lỗi ghi file.");
            return false;
        }
    }

    public String converterProductToString(Product product){
        return product.getProductID()+","+product.getProductName()+","+product.getPrice();
    }



    public boolean deleteProduct(String productID){
        ArrayList<Product> productList=getProductList();
       productList.removeIf(product -> product.getProductID().equals(productID));
        return saveProductList(productList);
    }


    public boolean updateProduct(String id,Product product){
        ArrayList<Product> productList=getProductList();
            for(Product p : productList){
                if(p.getProductID().equals(id)){
                    p.setProductName(product.getProductName());
                    p.setPrice(product.getPrice());
                    p.setProductID(product.getProductID());
                }
            }
            return saveProductList(productList);
    }


    public List<Product> searchProduct(String name){
        ArrayList<Product> productList=getProductList();
        List<Product> result = new ArrayList<>();
        for(Product p : productList){
            if(p.getProductName().toLowerCase().contains(name.toLowerCase())){
                result.add(p);
            }
        }
        return result;
    }

    public boolean sortPriceAsc(){

        ArrayList<Product> productList=getProductList();
        productList.sort(new compareProductPrice());
        return saveProductList(productList);
    }
    public boolean sortPriceDesc(){

        ArrayList<Product> productList=getProductList();
        productList.sort(new compareProductPrice().reversed());
        return saveProductList(productList);
    }

    public boolean sortProductID(){
        ArrayList<Product> productList=getProductList();
        productList.sort(new compareProductID());
        return saveProductList(productList);
    }

}

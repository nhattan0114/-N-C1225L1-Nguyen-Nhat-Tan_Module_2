package javacollection.repository;

import javacollection.entity.Product;

import java.util.ArrayList;


public class ProductRepository {
    ArrayList<Product> productList = new ArrayList<>();


    public ArrayList<Product> getProductList(){
        return new ArrayList<>(productList);
    }


    public boolean addProduct(Product product){
        productList.add(product);
        return true;
    }



    public boolean deleteProduct(String productID){
       productList.removeIf(product -> product.getProductID().equals(productID));
        return true;
    }


    public boolean updateProduct(String id,Product product){
            for(Product p : productList){
                if(p.getProductID().equals(id)){
                    p.setProductName(product.getProductName());
                    p.setPrice(product.getPrice());
                    p.setProductID(product.getProductID());
                }
            }
            return true;
    }


    public void searchProduct(){}

    public Product findByID(String productID){
        return null;
    }

}

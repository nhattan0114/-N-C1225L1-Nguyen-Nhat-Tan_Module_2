package javacollection.repository;

import CleanCode.compare.compareProductID;
import CleanCode.compare.compareProductPrice;
import javacollection.entity.Product;

import java.util.ArrayList;
import java.util.List;


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


    public List<Product> searchProduct(String name){
        List<Product> result = new ArrayList<>();
        for(Product p : productList){
            if(p.getProductName().toLowerCase().contains(name.toLowerCase())){
                result.add(p);
            }
        }
        return result;
    }

    public void sortPriceAsc(){
        productList.sort(new compareProductPrice());
    }
    public void sortPriceDesc(){
        productList.sort(new compareProductPrice().reversed());
    }

    public void sortProductID(){
        productList.sort(new compareProductID());
    }

}

package javacollection.controller;

import javacollection.entity.Product;
import javacollection.service.impl.ProductService;

import java.util.List;

public class ProductController {
    ProductService productService = new ProductService();


    public boolean addProduct(Product product){
        return productService.addProduct(product);
    }


    public List<Product> getProductList(){
        return productService.getProductList();
    }


    public boolean deleteProduct(String id){
        return productService.deleteProduct(id);
    }


    public boolean updateProduct(String id,Product product){
        return productService.updateProduct(id,product);
    }


    public List<Product> searchProduct(String name){
       return productService.searchProduct(name);
    }


    public void sortProductPriceAsc(){
        productService.sortProductPriceAsc();

    }
    public void sortProductPriceDesc(){
        productService.sortProductPriceDesc();
    }
    public void sortProductID(){
        productService.sortProductID();
    }

}

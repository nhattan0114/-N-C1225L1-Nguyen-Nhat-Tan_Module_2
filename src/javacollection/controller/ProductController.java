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


    public void searchProduct(){
        productService.searchProduct();
    }


    public void sortProduct(){
        productService.sortProduct();
    }

    public Product getID(String id){
        return productService.findByID(id);
    }
}

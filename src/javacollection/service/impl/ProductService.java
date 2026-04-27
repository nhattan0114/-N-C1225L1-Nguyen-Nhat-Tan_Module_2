package javacollection.service.impl;

import javacollection.entity.Product;
import javacollection.repository.ProductRepository;
import javacollection.service.IProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    ProductRepository productRepository = new ProductRepository();


    @Override
    public boolean addProduct(Product product) {
        if(product==null){
            return false;
        }
        ArrayList<Product> products = productRepository.getProductList();
        if(product.getProductName()==null||product.getProductName().trim().isEmpty()){
            return false;
        }
        if(product.getProductID()==null||product.getProductID().trim().isEmpty()){
            return false;
        }
        if(product.getPrice()<=0){
            return false;
        }
        for(Product p : products){
            if(p.getProductID().equalsIgnoreCase(product.getProductID())){
                return false;
            }
        }

        return productRepository.addProduct(product);
    }

    @Override
    public List<Product> getProductList() {
        return productRepository.getProductList();
    }



    @Override
    public boolean deleteProduct(String productID) {

        if (productID == null || productID.trim().isEmpty()) {
            return false;
        }

        return productRepository.deleteProduct(productID);
    }

    @Override
    public boolean updateProduct(String id,Product product) {


        if (id == null || id.trim().isEmpty() || product == null) {
            return false;
        }
        return productRepository.updateProduct(id,product);
    }

    @Override
    public List<Product> searchProduct(String name) {

        if(name==null|| name.trim().isEmpty()){
            return new ArrayList<>();
        }
        return productRepository.searchProduct(name);
    }

    @Override
    public boolean sortProductPriceAsc() {
        return productRepository.sortPriceAsc();
    }

    @Override
    public boolean sortProductPriceDesc() {
       return productRepository.sortPriceDesc();
    }

    @Override
    public boolean sortProductID(){
      return   productRepository.sortProductID();
    }

}

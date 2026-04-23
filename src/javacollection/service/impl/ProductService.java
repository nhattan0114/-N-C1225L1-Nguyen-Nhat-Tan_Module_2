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
        ArrayList<Product> products = productRepository.getProductList();

        if(product==null){
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
        ArrayList<Product> products = productRepository.getProductList();

        if (productID == null || productID.trim().isEmpty()) {
            return false;
        }

        for (Product p : products){
            if(p.getProductID().equalsIgnoreCase(productID)){
                return productRepository.deleteProduct(productID);

            }
        }
        return false;
    }

    @Override
    public boolean updateProduct(String id,Product product) {
        ArrayList<Product> products = productRepository.getProductList();

        if (id == null || id.trim().isEmpty() || product == null) {
            return false;
        }
        for(Product p : products){
            if(id.equalsIgnoreCase(p.getProductID())){
                return productRepository.updateProduct(id,product);
            }
        }
        return false;
    }

    @Override
    public void searchProduct() {

    }

    @Override
    public void sortProduct() {

    }

    @Override
    public Product findByID(String productID) {
        return null;
    }
}

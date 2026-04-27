package javacollection.entity;

public class Product {
    private String productName;
    private String productID;
    private double price;

    public Product(){

    }
    public Product(double price, String productID, String productName) {
        this.price = price;
        this.productID = productID;
        this.productName = productName;
    }

    public Product(String productID, String productName, double price) {
        this.price = price;
        this.productID = productID;
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return String.format("| %-2s | %-20s | %-10s |",
                this.getProductID(), this.getProductName(), this.getPrice());
    }
}

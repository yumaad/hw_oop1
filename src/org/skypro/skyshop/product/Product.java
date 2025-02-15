package org.skypro.skyshop.product;

public class Product {
    private final String productName;
    private final int price;

    public Product(String productName, int cost) {
        this.productName = productName;
        this.price = cost;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }
}

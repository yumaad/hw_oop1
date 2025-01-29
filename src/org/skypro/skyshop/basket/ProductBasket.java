package org.skypro.skyshop.basket;

import java.util.Arrays;

public class ProductBasket {
    private final org.skypro.skyshop.product.Product[] products = new org.skypro.skyshop.product.Product[5];
    private int size = 0;

    public void addProduct(org.skypro.skyshop.product.Product product) {
        if (size == products.length) {
            System.out.println("Product can't be added\n");
            return;
        }
        products[size++] = product;
    }

    public int getTotalPrice() {
        if (size == 0) {
            return -1; // Или любое другое значение, обозначающее пустую корзину
        }
        int totalPrice = 0;
        for (int i = 0; i < size; i++) {
            totalPrice += products[i].getPrice();
        }
        return totalPrice;
    }

    public void printBasket() {
        if (size == 0) {
            System.out.println("Basket is empty");
            System.out.println("Total: 0 rubles\n");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(products[i].getProductName() + ": " + products[i].getPrice());
        }
        System.out.println("Total: " + getTotalPrice() + " rubles\n");
    }

    public boolean containsProduct(String productName) {
        for (int i = 0; i < size; i++) {
            if (products[i].getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        Arrays.fill(products, null);
        size = 0;
    }
}

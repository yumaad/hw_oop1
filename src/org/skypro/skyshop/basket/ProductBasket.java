package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> productsMap = new HashMap<>();

    public void addProduct(Product product) {
        productsMap.computeIfAbsent(product.getProductName(), k -> new ArrayList<>()).add(product);
    }

    public void printBasket() {
        if (productsMap.isEmpty()) {
            System.out.println("Basket is empty");
            System.out.println("Total: 0 rubles\n");
            return;
        }
        int totalPrice = 0;
        int specialCount = 0;
        for (List<Product> productList : productsMap.values()) {
            for (Product product : productList) {
                System.out.println(product);
                totalPrice += product.getPrice();
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }
        System.out.println("Total: " + totalPrice + " rubles\n");
        System.out.println("Special products: " + specialCount + "\n");
    }

    public List<Product> removeProductByName(String productName) {
        List<Product> removedProducts = productsMap.remove(productName);
        return removedProducts != null ? removedProducts : Collections.emptyList();
    }


    public void clearBasket() {
        productsMap.clear();

    }
}

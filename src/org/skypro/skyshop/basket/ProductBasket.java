package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("Basket is empty");
            System.out.println("Total: 0 rubles\n");
            return;
        }
        int totalPrice = 0;
        int specialCount = 0;
        for (Product product : products) {
            System.out.println(products);
            totalPrice += product.getPrice();
            if (product.isSpecial()) {
                specialCount++;
            }
        }
        System.out.println("Total: " + totalPrice + " rubles\n");
        System.out.println("Special products: " + specialCount + "\n");
    }

    public List<Product> removeProductByName(String productName) {
        List<Product> removedProducts = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getProductName().equals(productName)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }
        return removedProducts;
    }

    public void clearBasket() {
        products.clear();

    }
}

package org.skypro.skyshop;

public class App {
    public static void main(String[] args) {
        org.skypro.skyshop.basket.ProductBasket basket = new org.skypro.skyshop.basket.ProductBasket();
        org.skypro.skyshop.product.Product product1 = new org.skypro.skyshop.product.Product("Ice-cream", 50);
        org.skypro.skyshop.product.Product product2 = new org.skypro.skyshop.product.Product("Cake", 30);
        org.skypro.skyshop.product.Product product3 = new org.skypro.skyshop.product.Product("Chocolate", 100);

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(new org.skypro.skyshop.product.Product("Protein cake", 70));
        basket.addProduct(new org.skypro.skyshop.product.Product("Napoleon", 80));

        basket.addProduct(new org.skypro.skyshop.product.Product("Yogurt", 60)); // Не добавится

        basket.printBasket();

        System.out.println("Contains Cake: " + basket.containsProduct("Cake") + "\n");
        System.out.println("Contains Yogurt: " + basket.containsProduct("Yogurt") + "\n");

        basket.clearBasket();
        basket.printBasket();
        System.out.println("Contains Cake: " + basket.containsProduct("Cake") + "\n");
    }
}
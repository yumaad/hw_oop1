package org.skypro.skyshop;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        Product product1 = new SimpleProduct("Ice-cream", 50);
        Product product2 = new DiscountedProduct("Cake", 100, 30); // Скидка 30%
        Product product3 = new FixPriceProduct("Chocolate");

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(new DiscountedProduct("Protein cake", 200, 50)); // Скидка 50%
        basket.addProduct(new FixPriceProduct("Napoleon"));

        basket.printBasket();

        System.out.println("Contains Cake: " + basket.containsProduct("Cake") + "\n");
        System.out.println("Contains Yogurt: " + basket.containsProduct("Yogurt") + "\n");

        basket.clearBasket();
        basket.printBasket();
        System.out.println("Contains Cake: " + basket.containsProduct("Cake") + "\n");
    }
}
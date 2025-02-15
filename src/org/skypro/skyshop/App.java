package org.skypro.skyshop;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        Product product1 = new Product("Ice-cream", 50);
        Product product2 = new Product("Cake", 30);
        Product product3 = new Product("Chocolate", 100);

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(new Product("Protein cake", 70));
        basket.addProduct(new Product("Napoleon", 80));

        basket.addProduct(new Product("Yogurt", 60)); // Не добавится

        basket.printBasket();

        System.out.println("Contains Cake: " + basket.containsProduct("Cake") + "\n");
        System.out.println("Contains Yogurt: " + basket.containsProduct("Yogurt") + "\n");

        basket.clearBasket();
        basket.printBasket();
        System.out.println("Contains Cake: " + basket.containsProduct("Cake") + "\n");
    }
}
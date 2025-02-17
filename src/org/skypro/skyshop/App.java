package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

import java.util.Arrays;

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

        Article article1 = new Article("How to choose ice-cream", "Ice-cream is a delicious dessert...");
        Article article2 = new Article("History of chocolate", "Chocolate has a rich history...");

        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(article1);
        searchEngine.add(article2);

        // Демонстрация поиска
        System.out.println("Search results for 'cake':");
        Searchable[] results = searchEngine.search("cake");
        System.out.println(Arrays.toString(results));

        System.out.println("Search results for 'chocolate':");
        results = searchEngine.search("chocolate");
        System.out.println(Arrays.toString(results));
    }
}
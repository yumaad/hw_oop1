package org.skypro.skyshop;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        try {
            Product invalidProduct = new SimpleProduct("", 50); // Пустое название
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Product invalidProduct = new SimpleProduct("Ice-cream", -10); // Отрицательная цена
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Product invalidProduct = new DiscountedProduct("Cake", 100, 150); // Недопустимый процент скидки
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Демонстрация поиска
        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.add(new SimpleProduct("Ice-cream", 50));
        searchEngine.add(new DiscountedProduct("Cake", 100, 30));
        searchEngine.add(new FixPriceProduct("Chocolate"));

        try {
            Searchable bestMatch = searchEngine.findBestMatch("cake");
            System.out.println("Best match: " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Searchable bestMatch = searchEngine.findBestMatch("yogurt"); // Несуществующий продукт
            System.out.println("Best match: " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        basket.addProduct(new SimpleProduct("Ice-cream", 50));
        basket.addProduct(new DiscountedProduct("Cake", 100, 30));
        basket.addProduct(new FixPriceProduct("Chocolate"));
        basket.addProduct(new SimpleProduct("Ice-cream", 50));

        System.out.println("Initial basket:");
        basket.printBasket();

        // Удаляем продукт по имени
        List<Product> removedProducts = basket.removeProductByName("Ice-cream");
        System.out.println("Removed products:");
        for (Product product : removedProducts) {
            System.out.println(product);
        }

        System.out.println("Basket after removal:");
        basket.printBasket();

        // Пытаемся удалить несуществующий продукт
        List<Product> emptyList = basket.removeProductByName("Yogurt");
        if (emptyList.isEmpty()) {
            System.out.println("Список пуст");
        }

        System.out.println("Basket after trying to remove non-existent product:");
        basket.printBasket();

        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.add(new SimpleProduct("Ice-cream", 50));
        searchEngine.add(new DiscountedProduct("Cake", 100, 30));
        searchEngine.add(new FixPriceProduct("Chocolate"));

        // Поиск по запросу "cake" с использованием метода search
        List<Searchable> searchResults = searchEngine.search("cake");
        System.out.println("Search results for 'cake':");
        for (Searchable result : searchResults) {
            System.out.println(result.getStringRepresentation());
        }

        // Поиск по запросу "ice" с использованием метода search
        List<Searchable> iceResults = searchEngine.search("ice");
        System.out.println("Search results for 'ice':");
        for (Searchable result : iceResults) {
            System.out.println(result.getStringRepresentation());
        }
    }
}
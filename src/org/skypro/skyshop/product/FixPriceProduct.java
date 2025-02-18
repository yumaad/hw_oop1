package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int FIXED_PRICE = 200; // Пример фиксированной цены

    public FixPriceProduct(String productName) {
        super(productName);
    }

    @Override
    public int getPrice() {
        return FIXED_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getProductName() + ": Fixed price " + FIXED_PRICE + " rubles";
    }
}

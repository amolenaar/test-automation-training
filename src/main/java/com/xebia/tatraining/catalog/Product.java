package com.xebia.tatraining.catalog;

/**
 * A Product represent one single product sold by our web shop.
 */
public class Product {

    private final String name;
    private final Price price;
    private final Category category;

    public Product(String name, Price price, final Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }
}

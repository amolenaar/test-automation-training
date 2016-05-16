package com.xebia.tatraining.catalog;

import java.util.*;

/**
 * A Catalog represents the collection of products sold via the web shop.
 */
public class Catalog {

    private final List<Product> products;

    public Catalog(Product... products) {
        this.products = Arrays.asList(products);
    }

    public Catalog(Collection<Product> products) {
        this.products = new ArrayList<>(products);
    }

    public Collection<Product> getProducts() {
        return Collections.unmodifiableCollection(products);
    }
}

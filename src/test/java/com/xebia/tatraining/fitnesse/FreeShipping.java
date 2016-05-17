package com.xebia.tatraining.fitnesse;

import com.xebia.tatraining.basket.Basket;
import com.xebia.tatraining.catalog.Category;
import com.xebia.tatraining.catalog.Price;
import com.xebia.tatraining.catalog.Product;

public class FreeShipping {

    private Basket basket;

    public void reset() {
        basket = new Basket();
    }
    public void setAmount(final double amount) {
        Product product = new Product("dummy", Price.of(amount), Category.BOOKS);
        basket.addToBasket(product, 1);
    }

    public String freeShipping() {
        return basket.hasFreeShipping() ? "yes" : "no";
    }
}

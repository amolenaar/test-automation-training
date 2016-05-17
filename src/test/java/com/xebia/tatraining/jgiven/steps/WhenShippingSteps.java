package com.xebia.tatraining.jgiven.steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.annotation.ScenarioState;
import com.xebia.tatraining.basket.Basket;
import com.xebia.tatraining.catalog.Category;
import com.xebia.tatraining.catalog.Price;
import com.xebia.tatraining.catalog.Product;

public class WhenShippingSteps extends Stage<WhenShippingSteps> {

    @ScenarioState
    double amount;

    @ScenarioState
    Basket basket;

    @As("the order is made")
    public void the_order_is_made() {
        basket = new Basket();
        Product product = new Product("dummy", Price.of(amount), Category.BOOKS);
        basket.addToBasket(product, 1);
    }
}

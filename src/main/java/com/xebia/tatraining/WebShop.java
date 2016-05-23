package com.xebia.tatraining;

import java.util.HashMap;
import java.util.Map;
import com.xebia.tatraining.basket.Basket;
import com.xebia.tatraining.catalog.Catalog;
import com.xebia.tatraining.catalog.Category;
import com.xebia.tatraining.catalog.Price;
import com.xebia.tatraining.catalog.Product;

public class WebShop {
    private static final WebShop WEB_SHOP = new WebShop();

    private final Catalog catalog;
    private final Map<String, Basket> baskets;

    private WebShop() {
        catalog = new Catalog(
            new Product("Twenty Thousand Leagues Under the Sea", Price.of(9), Category.BOOKS),
            new Product("Harry Potter and the Order of the Phoenix", Price.of(19), Category.BOOKS),
            new Product("Pack of batteries", Price.of(5), Category.ELECTRONICS),
            new Product("Fridge", Price.of(159), Category.HOME_APPLIANCES)
        );
        baskets = new HashMap<>();
    }

    public static WebShop getInstance() {
        return WEB_SHOP;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public Basket getBasketForUser(String userId) {
        if (baskets.containsKey(userId)) {
            return baskets.get(userId);
        }
        Basket newBasket = new Basket();
        baskets.put(userId, newBasket);
        return newBasket;
    }
}

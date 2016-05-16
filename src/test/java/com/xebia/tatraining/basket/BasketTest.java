package com.xebia.tatraining.basket;

import java.math.BigDecimal;
import org.junit.Test;

import com.xebia.tatraining.catalog.Category;
import com.xebia.tatraining.catalog.Price;
import com.xebia.tatraining.catalog.Product;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BasketTest {

    @Test
    public void shouldProvideTotalPriceWithShippingFreeIfBelowThreshold() {
        Product book = new Product("Twenty Thousand Leagues Under the Sea", Price.of(9), Category.BOOKS);
        Product batteries = new Product("Pack of batteries", Price.of(4), Category.ELECTRONICS);

        Basket basket = new Basket().addToBasket(book, 1).addToBasket(batteries, 1);

        assertThat(basket.getTotalPrice(), is(book.getPrice().add(batteries.getPrice()).add(Basket.DEFAULT_SHIPPING_FEE)));
    }

    @Test
    public void shouldProvideTotalPriceWithFreeShippingIfAboveThreshold() {
        Product product = new Product("Dummy product", Basket.FREE_SHIPPING_THRESHOLD.add(Price.of(1)), Category.BOOKS);

        Basket basket = new Basket().addToBasket(product, 1);

        assertThat(basket.getTotalPrice(), is(product.getPrice()));
    }

}
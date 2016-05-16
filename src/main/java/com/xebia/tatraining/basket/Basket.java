package com.xebia.tatraining.basket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import com.xebia.tatraining.catalog.Price;
import com.xebia.tatraining.catalog.Product;

public class Basket {
    public static Price DEFAULT_SHIPPING_FEE = Price.of(2);
    public static Price FREE_SHIPPING_THRESHOLD = Price.of(25);

    private List<Entry> basketEntries = new ArrayList<>();

    public Basket addToBasket(Product product, int quantity) {
        basketEntries.add(new Entry(product, quantity));
        return this;
    }

    public Collection getBasketEntries() {
        return Collections.unmodifiableCollection(basketEntries);
    }

    public boolean hasFreeShipping() {
        Price price = priceOfEntries();
        return hasFreeShipping(price);
    }

    public Price getTotalPrice() {
        Price total = priceOfEntries();
        return hasFreeShipping(total) ? total : total.add(DEFAULT_SHIPPING_FEE);
    }

    private Price priceOfEntries() {
        Price total = Price.ZERO;
        for (Entry entry : basketEntries) {
            total = total.add(entry.getProduct().getPrice());
        }
        return total;
    }

    private boolean hasFreeShipping(final Price price) {
        return price.isMoreThanOrEqual(FREE_SHIPPING_THRESHOLD);
    }

    public static class Entry {
        private final Product product;
        private final int quantity;

        public Entry(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }

        public Product getProduct() {
            return product;
        }

        public int getQuantity() {
            return quantity;
        }
    }
}

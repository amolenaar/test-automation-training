package com.xebia.tatraining.catalog;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * The Price of a Product.
 */
public class Price {
    private static final Currency DEFAULT_CURRENCY = Currency.getInstance("EUR");
    public static final Price ZERO = new Price(BigDecimal.ZERO);

    private final BigDecimal amount;
    private final Currency currency;

    public static Price of(double amount) {
        return new Price(BigDecimal.valueOf(amount));
    }

    public Price(BigDecimal amount) {
        this(amount, DEFAULT_CURRENCY);
    }

    public Price(BigDecimal amount, Currency currency) {
        this.amount = amount.setScale(currency.getDefaultFractionDigits(), BigDecimal.ROUND_HALF_UP);
        this.currency = currency;
    }

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String toString() {
        return currency.getSymbol() + " " + amount;
    }

    public Price add(final Price other) {
        if (!currency.equals(other.currency)) throw new IllegalStateException("Prices should have the same currency");
        return new Price(amount.add(other.amount), currency);
    }

    public boolean isMoreThanOrEqual(final Price other) {
        return amount.compareTo(other.amount) >= 0;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Price price = (Price) o;

        return amount.equals(price.amount) && currency.equals(price.currency);

    }

    @Override
    public int hashCode() {
        int result = amount.hashCode();
        result = 31 * result + currency.hashCode();
        return result;
    }
}

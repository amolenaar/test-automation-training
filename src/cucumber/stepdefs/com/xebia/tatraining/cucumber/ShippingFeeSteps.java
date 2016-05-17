package com.xebia.tatraining.cucumber;

import com.xebia.tatraining.basket.Basket;
import com.xebia.tatraining.catalog.Category;
import com.xebia.tatraining.catalog.Price;
import com.xebia.tatraining.catalog.Product;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ShippingFeeSteps {

    private double amount;
    private Basket basket;

    @Given("^a customer has an order with value EUR (\\d+\\.\\d+)$")
    public void a_customer_has_an_order_with_value_EUR(double amount) throws Throwable {
        this.amount = amount;
        basket = new Basket();
    }

    @When("^the order is made$")
    public void the_order_is_made() throws Throwable {
        basket.addToBasket(new Product("dummy", Price.of(amount), Category.BOOKS), 1);
    }

    @Then("^the shipping costs are added to the total sum$")
    public void the_shipping_costs_are_added_to_the_total_sum() throws Throwable {
        assertFalse("Free shipping should not apply", basket.hasFreeShipping());
    }

    @Then("^the shipping costs are not calculated$")
    public void the_shipping_costs_are_not_calculated() throws Throwable {
        assertTrue("Free shipping should apply", basket.hasFreeShipping());
    }

}

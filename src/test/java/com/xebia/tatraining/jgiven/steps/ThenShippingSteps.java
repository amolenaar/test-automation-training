package com.xebia.tatraining.jgiven.steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ScenarioState;
import com.xebia.tatraining.basket.Basket;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ThenShippingSteps extends Stage<ThenShippingSteps> {

    @ScenarioState
    Basket basket;

    public void the_shipping_costs_are_added_to_the_total_sum() {
        assertFalse(basket.hasFreeShipping());
    }

    public void the_shipping_costs_are_not_added_to_the_total_sum() {
        assertTrue(basket.hasFreeShipping());
    }

}

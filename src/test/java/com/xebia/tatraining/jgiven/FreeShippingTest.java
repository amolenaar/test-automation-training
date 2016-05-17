package com.xebia.tatraining.jgiven;

import org.junit.Test;
import com.tngtech.jgiven.junit.ScenarioTest;
import com.xebia.tatraining.jgiven.steps.GivenShippingSteps;
import com.xebia.tatraining.jgiven.steps.ThenShippingSteps;
import com.xebia.tatraining.jgiven.steps.WhenShippingSteps;

/**
 * JGiven exercise.
 */
public class FreeShippingTest extends
        ScenarioTest<GivenShippingSteps, WhenShippingSteps, ThenShippingSteps> {

    @Test
    public void shipping_fee_is_calculated() {
        given().a_customer_has_an_order_with_value_EUR_$(20.00);
        when().the_order_is_made();
        then().the_shipping_costs_are_added_to_the_total_sum();
    }

    @Test
    public void shipping_fee_is_not_calculated() {
        given().a_customer_has_an_order_with_value_EUR_$(30.00);
        when().the_order_is_made();
        then().the_shipping_costs_are_not_added_to_the_total_sum();
    }

}


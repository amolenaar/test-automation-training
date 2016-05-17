package com.xebia.tatraining.jgiven.steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ScenarioState;

public class GivenShippingSteps extends Stage<GivenShippingSteps> {

    @ScenarioState
    double amount;

    public void a_customer_has_an_order_with_value_EUR_$(double amount) {
        this.amount = amount;
    }
}

# Created by arjan at 17/05/16
Feature: Free shipping for orders above 25 Euro.
  This feature describes ...
  For orders < 25.00 EUR, a shipping fee of 2.00 EUR is added.

  Scenario: Shipping fee is calculated
    Given a customer has an order with value EUR 20.00
    When the order is made
    Then the shipping costs are added to the total sum

  Scenario: Shipping fee is not calculated
    Given a customer has an order with value EUR 30.00
    When the order is made
    Then the shipping costs are not calculated


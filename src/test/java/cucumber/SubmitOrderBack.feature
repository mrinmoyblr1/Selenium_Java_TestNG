Feature: Purchase Order from E-commerce Website


  Background:
    Given I landed on Ecommerce Page


  Scenario Outline: Positive Test of Submitting the order
    Given Logged in with username "<name>" and password "<password>"
    When I add product "<productName>" to Cart
    And Checkout "<productName>" and Submit the order

    Examples:
      | name                  | password  | productName |
      | mrinmoy.blr@gmail.com | Anjali@12 | ZARA COAT 3 |



Feature: promotion campaign

  Scenario: discount on all products
    Given Login "adminPage" with "account" and "passWord"
    And Go to "cartPriceRule"
    When Create a "percent" discount rule
    And Go to "itemDetail"
    And Click on "selectSizeButton" then select "selectSize"
    And Click on "addToCart"
    And Go to "theCart"
    Then The discount is "discountAmount"
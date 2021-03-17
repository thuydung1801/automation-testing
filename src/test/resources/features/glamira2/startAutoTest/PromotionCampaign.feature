Feature: promotion campaign

  Scenario: discount on all products
    Given Login "adminPage" with "account" and "password"
    And Go to "cartPriceRule" url
    When Create a "percent" discount rule
    And Go to "itemDetail" url
    And Click on "selectSizeButton" then select "selectSize"
    And Click on "addToCart"
    And Go to "theCart" url
    Then The discount is "discountAmount"
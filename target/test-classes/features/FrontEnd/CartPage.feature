Feature: The cart page

  Background: An item is added into the cart
    Given Go to "itemDetail"
    When Click on "selectSizeButton" then select "selectSize"
    And Click on "addToCart"

  Scenario: Add two similar products into the cart
    Given Go to "itemDetail"
    When Click on "selectSizeButton" then select "selectSize"
    And Click on "addToCart"
    And Click on "viewCart"
    Then The site will redirect to "theCart" url
    And The current quantity is "2"

  Scenario: Change the quantity in the cart
    Given Go to "theCart"
    When input "newQuantity"
    Then The subTotalPrice is "changedPrice"

  Scenario: Add another item into the cart
    Given  Go to "anotherItemDetail"
    When Click on "selectSizeButton" then select "selectSize"
    And Click on "addToCart"
    And Click on "viewCart"
    Then The totalPrice is "newTotalPrice"

  Scenario: Remove an item from the cart
    Given Go to "theCart"
    When Click on removedBtn
    Then The shoping bag is empty

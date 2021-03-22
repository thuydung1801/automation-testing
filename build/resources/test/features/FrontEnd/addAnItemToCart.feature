Feature: As a user, i want to add some item to cart.

  @test01
  Scenario: add a ring into cart successfully
    Given Go to "diamondRingPage" url
    When I click item has name: GLAMIRA Ring Gratia
    And Chose ring size: 14,6
    And I add this item to cart
    And Wait about 5 seconds
    Then Show Messages : You added GLAMIRA Ring Gratia to your shopping cart.
#    the price of item is incorrect so i cant check the number of item after add item to cart

  @test02
#  Scenario: Check whether the product design added in the cart is the same as the old one

  @test03
  Scenario: dont chose the ring size
    Given Go to "diamondRingPage" url
    And Wait until display button has text GLAMIRA Ring Gratia
    And Wait about 9 seconds
    When I click item has name: GLAMIRA Ring Gratia
    And Wait until display button has text Add to shopping bag
    And Wait about 5 seconds
    And I add this item to cart
    And Wait about 5 seconds
    Then Show message for ring size: This is a required field.
  @test04
  Scenario:

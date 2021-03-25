Feature: As a user, I want to check out with Tax

  Background: Log in before checkout
    Given Go to "signInPage" url
    And Insert thanh.opentechiz@gmail.com into box have id: emailLogIn
    And Insert !test123! into box have id: passLogIn
    And I click button has text Sign In
    And Click button Sign In
    Given Go to "diamondRingPage" url
    When I click item has name: GLAMIRA Ring Gratia
    And Chose ring size: 14,6
    And I add this item to cart
    And Wait about 5 seconds

  @test01
  Scenario: go to check out
    When Go to Cart
    And Wait about 5 seconds
    When Show Tax
    When I click country: Fiji
    And Wait about 6 seconds
    Then Show Bill





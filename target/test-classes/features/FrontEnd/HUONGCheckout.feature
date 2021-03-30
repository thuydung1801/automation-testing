@tag
Feature: Check out with login

  Background:
    Given Go to the "glamiraUrl" url
    When I login with valid username and password
    Then I should be on user profile page

  @tag_01
  Scenario: payment method Bank: transfer
    When Mouse Hover and click
    And I click in  detail item
    And Choose RingSize
    And Click in Add To Shopping Bag button
#    And Click to view  ShoppingBag
    And Click in Proceed to Checkout button
    And Select shipping methods
    And Select Payment method
    And Click in Place Order
    Then I should be on the "viewsuccess"

#  @tag_02
#  Scenario: payment method: paypal
#    When Mouse Hover and click
#    And I click in  detail item
#    And Choose RingSize
#    And Click in Add To Shopping Bag button
#   #   And Click and navigate to the cart page
#    And Click to view  ShoppingBag
#    And Click in Proceed to Checkout button
#    And Select shipping methods
#    And Select Payment method paypal
#    And Click in Place Order
##     Then I should be on Successful newspaper page
#    Then I should be on the "viewsuccess"
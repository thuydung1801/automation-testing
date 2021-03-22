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

#Feature: Checkout without login
  @test02
  Scenario: Check out without login
    Given Go to "itemDetail" url
    When Click on "selectSizeButton" then select "selectSize"
    And Click on "addToCart"
#    And Move on "viewCart" then click on "proceedToCheckout"
    Then Go to "checkoutPage" url
    And input "firstName", "lastName", "email", "streetAddress", "country", "city", "zipCode", "phoneNumber"
    And Click on freeStandardDelivery then click nextBtn
    Then The site will redirect to "paymentMethodPage" url
    And Choose Bank Transfer
    And Agree Temrs-conditions and click Place order
    Then The order place successfully
#    And Choose credit card and input "cardNumber" "expiryDate" "CVC" "cardHolderName" then click on pla order button
#    And input "telephone" into "telephoneField"
#    And input "address" into "addressField"
#    And input "postcode" into "postcodeField"
#    And input "city" into "cityField"
#    And Scroll and click on "toPaymentBtn"
#    And Click on "creditCard"
#    And input "cardNumber" into "creditCardNumberField"
#    And input "holderName" into "holderNameField"
#    And Click on "selectMonth" then select "expireMonth"
#    And Click on "selectYear" then select "expireYear"
#    And input "CVC" into "CVCfield"
#    And Click on "agreeTerm"
#    And Click on "save&nextBtn"
#    Then The site will redirect to "reviewOrder" url
#    And The "productPrice" is "expectedPrice"






Feature: Checkout without login
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



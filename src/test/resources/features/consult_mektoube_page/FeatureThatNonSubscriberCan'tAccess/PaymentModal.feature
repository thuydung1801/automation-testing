Feature: Payment modal

Background:
  Given Go to "ResponsiveIntroduction.url" url


  @TEST_QRA-244
  Scenario: Function in payment modal - leave all fields empty

    When Login with account "lannt.man98@gmail.com" and password "Mektoubi2017"
    When Click on message unread
    When Should see payment page
    Then Leave all fields in payment page empty

  @TEST_QRA-245
  Scenario: Function in payment modal - Fill invalid card number (card number doesn't exist)

    When Login with account "lannt.man98@gmail.com" and password "Mektoubi2017"
    When Click on message unread
    When Should see payment page
    And Fill invalid number on payment page

  @TEST_QRA-300
  Scenario: Function in payment modal - fill invalid number (incorrect number form)

    When Login with account "lannt.man98@gmail.com" and password "Mektoubi2017"
    When Click on message unread
    When Should see payment page
    When Insert "411111111111" into Field "cardNumberField"
    When Insert "102" into Field "ExpDateOfCardField"
    When Insert "12" into Field "CVVField"
    When Click "SubmitBtn"
    Then Should see message popup in line "Le numéro de la carte est invalide"
    And Should see message popup in line "La date de la carte est invalide"
    And Should see message popup in line "Le CVV au moins 3 chiffres"

  @TEST_QRA-246
  Scenario: Function in payment modal - Fill alphabet/ special characters

    When Login with account "lannt.man98@gmail.com" and password "Mektoubi2017"
    When Click on message unread
    When Should see payment page
    Then Fill alphabet om payment page
    And Fill special characters on payment page

  @TEST_QRA-283
  Scenario: Function in payment modal - check that the "Pass 6 mois" is pre-selected

    When Login with account "lannt.man98@gmail.com" and password "Mektoubi2017"
    When Click on message unread
    When Should see payment page
    Then check that the six month option is pre-selected

  @TEST_QRA-284
  Scenario: Function in payment modal - only one payment option is selected

    When Login with account "lannt.man98@gmail.com" and password "Mektoubi2017"
    When Click on message unread
    When Should see payment page
    When Click "secondPaymentOption"
    When Click "thirdPaymentOption"
    Then Only one radio button is clicked

  @TEST_QRA-500
  Scenario: Function in payment modal - pay express

    When Login with account "pad9" and password "mektoube**"
    When Wait until element "subscriptionsTexLink" is visible
    When Click "subscriptionsTexLink"
    When Redirect to link "https://www.mektoube.fr/main/subscriptions"
    When Scroll to "GotoPremiumPayment" and click
    Then Should see pay express in payment modal
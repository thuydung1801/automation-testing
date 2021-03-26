Feature: As a user, I want to register account in Glamira.
  Before run test, go to the link
  "https://test.glamira2.just4demo.biz/admin/admin/system_config/edit/section/recaptcha_frontend/" And
  Witch Enable for Create New Customer Account to No to turn off Capcha

  Background: Log in before checkout
    Given Go to "signInPage" url

  @test01
  Scenario: Register Account successfully.
    And  Click accept cookie
    When Insert firstnameReturn into box have name: firstname
    And Insert lastNameReturn into box have name: lastname
    And Insert emailRegisterSuccessfully into box have id: email_address
    And Insert emailRegisterSuccessfully into box have name: emailconfirm
    And Insert password into box have name: password
    And Insert password into box have name: password_confirmation
    And Click accept button
    And Click Submit button
    And  Wait about 10 seconds
    Then Successfully into myAccountPage front site

  @test02
  Scenario: Registered accounts with email already exists
    And  Click accept cookie
    When Insert firstnameReturn into box have name: firstname
    And Insert lastNameReturn into box have name: lastname
    And Insert emailRegisterSuccessfully into box have id: email_address
    And Insert emailRegisterSuccessfully into box have name: emailconfirm
    And Insert password into box have name: password
    And Insert password into box have name: password_confirmation
    And Click accept button
    And Click Submit button
    And  Wait about 1 seconds
    Then Show Error Messages :There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.

  @Test03
  Scenario: Leave all blank
    And  Click accept cookie

    When Insert  into box have name: firstname
    And Insert  into box have name: lastname
    And Insert  into box have id: email_address
    And Insert  into box have name: emailconfirm
    And Insert  into box have name: password
    And Insert  into box have name: password_confirmation
    And Click accept button
    And Click Submit button
    And  Wait about 1 seconds
    Then Show Error Messages under blank :This is a required field.

  @Test04
  Scenario: Don't click accept button
    And  Click accept cookie

    When Insert firstnameReturn into box have name: firstname
    And Insert lastNameReturn into box have name: lastname
    And Insert emailRegisterSuccessfully into box have id: email_address
    And Insert emailRegisterSuccessfully into box have name: emailconfirm
    And Insert password into box have name: password
    And Insert password into box have name: password_confirmation
#   When Click accept button
    And Click Submit button
    And  Wait about 1 seconds
    Then Show Error Messages under button :This is a required field.


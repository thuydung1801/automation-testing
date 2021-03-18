Feature: As a user, I want to register account in Glamira.
  Before run test, go to the link
  "https://test.glamira2.just4demo.biz/admin/admin/system_config/edit/section/recaptcha_frontend/" And
  Witch Enable for Create New Customer Account to No to turn off Capcha

  Background: Log in before checkout
    Given Go to signInPage url

  @test01
  Scenario: Register Account successfully.
    When Insert Thanh into box have name: firstNameInp
    And Insert Opentechiz into box have name: lastNameInp
    And Insert thanh.tester@gmail.com into box have id: emailInp
    And Insert thanh.tester@gmail.com into box have name: emailConfirmInp
    And Insert !test123! into box have name: passwordInp
    And Insert !test123! into box have name: passwordConfirmationInp
    And Click accept button
    And Click Submit button
    And  Wait about 1 seconds
    Then Successfully into  MyAccountPage  front site

  @test02
  Scenario: Registered accounts with email already exists
    When Insert Thanh into box have name: firstNameInp
    And Insert Opentechiz into box have name: lastNameInp
    And Insert thanh.opentechiz1@gmail.com into box have id: emailInp
    And Insert thanh.opentechiz1@gmail.com into box have name: emailConfirmInp
    And Insert !test123! into box have name: passwordInp
    And Insert !test123! into box have name: passwordConfirmationInp
    And Click accept button
    And Click Submit button
    And  Wait about 1 seconds
    Then Show Error Messages :  There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account. 

  @Test03
  Scenario: Leave all blank
    When Insert  into box have name: firstNameInp
    And Insert  into box have name: lastNameInp
    And Insert  into box have id: emailInp
    And Insert  into box have name: emailConfirmInp
    And Insert  into box have name: passwordInp
    And Insert  into box have name: passwordConfirmationInp
    And Click accept button
    And Click Submit button
    And  Wait about 1 seconds
    Then Show Error Messages under blank :  This is a required field.

  @Test04
  Scenario: Don't click accept button
    When Insert Thanh into box have name: firstNameInp
    And Insert Opentechiz into box have name: lastNameInp
    And Insert thanh.opentechiz1@gmail.com into box have id: emailInp
    And Insert thanh.opentechiz@gmail.com into box have name: emailConfirmInp
    And Insert !test123! into box have name: passwordInp
    And Insert !test123! into box have name: passwordConfirmationInp
#   When Click accept button
    And Click Submit button
    And  Wait about 1 seconds
    Then Show Error Messages under button :  This is a required field. 


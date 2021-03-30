Feature: As a user, i forgot my password, i want to reset my password
  Before run test, go to the link
  "https://test.glamira2.just4demo.biz/admin/admin/system_config/edit/section/recaptcha_frontend/" And
  Witch Enable for Forgot Password to No to turn off Capcha

  @test01
  Scenario: Visit the Forgot Password page
    Given Go to "signInPage" url
    When Click forgot Password button
    Then Successfully into forgotPassPage front site

  @test02
  Scenario: Get email to reset Password
    Given Go to "forgotPassPage" url
    And Insert emailForgot into box have name: email
    When Click Reset My Password button
    And Wait about 1 seconds
    Then Successfully into signInPage front site

  @test03
  Scenario: Click Reset Password many times
    Given Go to "forgotPassPage" url
    And Insert emailForgot into box have name: email
    When Click Reset My Password button
    And Wait about 1 seconds
    Then Show Error Messages :We received too many requests for password resets. Please wait and try again later or contact service@glamira.co.uk.

  @test04
  Scenario: leave email blank
    Given Go to "forgotPassPage" url
    When Click Reset My Password button
    And Wait about 1 seconds
    Then Show Error Messages :Please enter your email.

  @test05
  Scenario: Cancel reset password
    Given Go to "forgotPassPage" url
    And Insert emailForgot into box have name: email
    When Click Go Back button
    And Wait about 1 seconds
    Then Successfully into signInPage front site

Feature: As a user, i forgot my password, i want to reset my password
  Before run test, go to the link
  "https://test.glamira2.just4demo.biz/admin/admin/system_config/edit/section/recaptcha_frontend/" And
  Witch Enable for Forgot Password to No to turn off Capcha

  @test01
  Scenario: Visit the Forgot Password page
    Given Go to 'https://test.glamira2.just4demo.biz/glgb/customer/account/login/' url
    When Click forgot Password button
    Then Successfully into 'https://test.glamira2.just4demo.biz/glgb/customer/account/forgotpassword/' front site
  @test02
  Scenario: Get email to reset Password
    Given Go to 'https://test.glamira2.just4demo.biz/glgb/customer/account/forgotpassword/' url
    When Insert email: 'thanh.opentechiz1@gmail.com'
    When Click Reset My Password button
    Then Successfully into 'https://test.glamira2.just4demo.biz/glgb/customer/account/login/' front site
#    And Show messages: 'If there is an account associated with thanh.opentechiz@gmail.com you will receive an email with a link to reset your password.'
#    Then Show messages: 'If there is an account associated with thanh.opentechiz@gmail.com you will receive an email with a link to reset your password.'
  @test03
  Scenario: Click Reset Password many times
    Given Go to 'https://test.glamira2.just4demo.biz/glgb/custmer/account/forgotpassword/' url
    When Insert email: 'thanh.opentechiz1@gmail.com'
    When Click Reset My Password button
    Then Show Error Messages : 'We received too many requests for password resets. Please wait and try again later or contact service@glamira.co.uk.'

  @test04
  Scenario: leave email blank
    Given Go to 'https://test.glamira2.just4demo.biz/glgb/customer/account/forgotpassword/' url
    When Click Reset My Password button
    Then Show Error Messages : 'Please enter your email.'
  @test05
  Scenario: Cancel reset password
    Given Go to 'https://test.glamira2.just4demo.biz/glgb/customer/account/forgotpassword/' url
    When Insert email: 'thanh.opentechiz1@gmail.com'
    When Click Go Back button
    Then Successfully into 'https://test.glamira2.just4demo.biz/glgb/customer/account/login/' front site

Feature: As a user, I want to register account in Glamira.
  Before run test, go to the link
  "https://test.glamira2.just4demo.biz/admin/admin/system_config/edit/section/recaptcha_frontend/" And Witch Enable for Create New Customer Account to No to turn off Capcha

  @test01
  Scenario: go to sign in/ sign up page
    Given Go to 'https://test.glamira2.just4demo.biz/glgb' url
    When Click Sign In/ Sign Up button
    Then Successfully into 'https://test.glamira2.just4demo.biz/glgb/customer/account/login/' front site

  @test02
  Scenario: Register Account successfully.
    Given Go to 'https://test.glamira2.just4demo.biz/glgb/customer/account/login/' url
    When Insert first name: 'Thanh'
    When Insert last name: 'Opentechiz'
    When Insert email: 'thanh.tester@gmail.com'
    When Insert Confirm E-mail Address: 'thanh.tester@gmail.com'
    When Insert password: '!test123!'
    When Insert Confirm Password: '!test123!'
    When Click accept button
    When Click Submit button
    Then Successfully into 'https://test.glamira2.just4demo.biz/glgb/customer/account/' front site

  @test03
  Scenario: Registered accounts with email already exists
    Given Go to 'https://test.glamira2.just4demo.biz/glgb/customer/account/login/' url
    When Insert first name: 'Thanh'
    When Insert last name: 'Opentechiz'
    When Insert email: 'thanh.opentechiz@gmail.com'
    When Insert Confirm E-mail Address: 'thanh.opentechiz@gmail.com'
    When Insert password: '!test123!'
    When Insert Confirm Password: '!test123!'
    When Click accept button
    When Click Submit button
    Then Show Error Messages : 'There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.'

  @Test04
  Scenario: Leave all blank
    Given Go to 'https://test.glamira2.just4demo.biz/glgb/customer/account/login/' url
#    When Insert first name: 'Thanh'
#    When Insert last name: 'Opentechiz'
#    When Insert email: 'thanh.opentechiz@gmail.com'
#    When Insert Confirm E-mail Address: 'thanh.opentechiz@gmail.com'
#    When Insert password: '!test123!'
#    When Insert Confirm Password: '!test123!'
    When Click accept button
    When Click Submit button
    Then Show Error Messages under blank : 'This is a required field.'
  @Test05
#    // fail
  Scenario: Don't click accept button
    Given Go to 'https://www.glamira.co.uk/customer/account/login/' url
    When Insert first name: 'Thanh'
    When Insert last name: 'Opentechiz'
    When Insert email: 'thanh.tester@gmail.com'
    When Insert Confirm E-mail Address: 'thanh.tester@gmail.com'
    When Insert password: '!test123!'
    When Insert Confirm Password: '!test123!'
#   When Click accept button
    When Click Submit button
    Then Show Error Messages under button : 'This is a required field.'


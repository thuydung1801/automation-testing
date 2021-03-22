
Feature: Login
  @Huong-test01
  Scenario: Verify Login success with valid username and password
    Given Go to "glgbHomePage" url
    When I login with valid username and password
    Then I should be on user profile page
    And After I click in Sign out button
  @lan-test02
  Scenario: Login with incorrect account
    Given Go to "glamiraUrl" url
    When Click on Sigin
    And input "lanWrongEmail" and "lanWrongPassword"
    And Click on Sigin
    Then The "Mật khẩu hoặc tài khoản không hợp lệ." is shown
  @lan-test03
  Scenario: Login sucessfully
    Given Go to "glamiraUrl" url
    When Click on Sigin
    And input "correctEmail" and "correctPassword"
    And Click on Sigin
    Then The site will redirect to "customerAccountPage"
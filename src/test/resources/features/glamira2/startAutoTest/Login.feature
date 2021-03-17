Feature: Login

  Scenario: Login with incorrect account
    Given Go to "glamiraUrl" url
    When Click on Sigin
    And input "wrongEmail" and "wrongPassword"
    And Click on Sigin button
    Then The "Mật khẩu hoặc tài khoản không hợp lệ." is shown

  Scenario: Login sucessfully
    Given Go to "glamiraUrl" url
    When Click on Sigin
    And input "correctEmail" and "correctPassword"
    And Click on Sigin button
    Then The site will redirect to "customerAccountPage"

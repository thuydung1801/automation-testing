Feature: Login

  Scenario: Login with incorrect account
    Given Go to "url" url
    When Click on "Signin"
    And input "wrongEmail" into "Email_field"
    And input "wrongPassword" into "Password_field"
    And Click on "SigninBtn"
    Then The "error_message" "Mật khẩu hoặc tài khoản không hợp lệ." is shown

  Scenario: Login sucessfully
    Given Go to "url" url
    When Click on "Signin"
    And input "Email" into "Email_field"
    And input "Password" into "Password_field"
    And Click on "SigninBtn"
    Then The site will redirect to "customerAccount" url

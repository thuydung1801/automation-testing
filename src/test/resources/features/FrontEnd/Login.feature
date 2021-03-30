@login
Feature: Login

  @login-01
  Scenario: Verify Login fail with invalid username and password
    Given Go to the "glamiraUrl" url
    When I login with invalid username and password
    Then I should not be on user profile page

  @login-02
  Scenario: Verify Login success with valid username and password
    Given Go to the "glamiraUrl" url
    When I login with valid username and password
    Then I should be on user profile page
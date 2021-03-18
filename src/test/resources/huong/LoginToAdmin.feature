@login
Feature: Login to Backend
  @login-01
  Scenario: Login failed
    Given go to the admin "adminPage"
   When I login to admin with invalid username and password
    Then I should not be on Admin Porfile pages
@login-02
Scenario: Login success
  Given go to the admin "adminPage"
  When I login to admin with valid username and password
  Then I should  be on Admin Porfile pages
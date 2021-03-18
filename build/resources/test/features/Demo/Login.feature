Feature: Login function

  Background: Open the Home Page
    Given I am on the home page
    #And Change environment to"kddjdgj"
    And Wait until display button has text "SE CONNECTER"
    And I click button has text "SE CONNECTER"

    @TEST_QRA-01
    Scenario: Login success and allow location permission
      Given I am on the login page
      When I fill "Montassir93" as login
      And I fill "Mektoubi2017" as password
      And Wait until display button has text "ME CONNECTER"
      And Click login button
      And Wait about 3 seconds
      Then I am on the discovery page
      And Wait until display button has text "ACTIVER LA GÉOLOCALISATION"
      And I click button has text "ACTIVER LA GÉOLOCALISATION"
      And Wait about 2 seconds
      And I click button has text "While using the app"
      And Wait until display element by xpath "searchBtn"
      And Wait until display element by xpath "rencontreLabel"



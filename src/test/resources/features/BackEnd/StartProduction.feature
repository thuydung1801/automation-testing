Feature: start a production

  Background: login to admin page
    Given Login "adminPage" with "account" and "passWord"

  Scenario: start a production in Manage production requests grid suceessfully
    Given Go to "manageProductionRequest"
    And Filter items match pre-condition for starting pProduction
    And Choose an item
    And Take action "startProduction"
    Then The "startProductionSuccessfully" Message is shown
#    And Click on "resetFilter"
  Scenario: start a production in Manage production requests to stock grid suceessfully
    Given Go to "manageProductionRequestToStock"
    And Filter items match pre-condition for starting pProduction
    And Choose an item
    And Take action Start production
    Then The "startProductionSuccessfully" Message is shown
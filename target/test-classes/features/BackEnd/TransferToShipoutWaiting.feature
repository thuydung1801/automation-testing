Feature: Transfer to ship out waiting

  Background: login to admin page
    Given Login "adminPage" with "account" and "passWord"

  Scenario: transfer an item to shipout waiting
    Given Go to "manageProductionRequest"
    When Enter "needTransferToShipoutWaitingBarcode" to scan barcode box
    And Take action "transferToShipoutWaiting"
    Then The "transferItemSuccessfully" Message is shown
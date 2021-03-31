Feature: Create a request to stock

  @createRequest
  Scenario: Create a request to stock successfully
    Given Login "adminPage" with "account" and "passWord"
    When Go to "manageProductionRequest"
    And Click on Create for in stock items button
    And Input information "itemQty" "newItemSKU" "itemName" "itemPrice" then click Save
    Then The "createSuccessfully" Message is shown
#    no match SKU
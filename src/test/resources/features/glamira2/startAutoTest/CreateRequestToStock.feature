Feature: Create a request to stock

  @createRequest
  Scenario: Create a request to stock successfully
    Given Login "adminPage" with "account" and "password"
    When Go to "manageProductionRequest" url
    And Click on Create for in stock items button
    And Input information "itemQty" "newItemSKU" "itemName" "itemPrice" then click Save
    Then The "createSuccessfully" Message is shown
#    no match SKU
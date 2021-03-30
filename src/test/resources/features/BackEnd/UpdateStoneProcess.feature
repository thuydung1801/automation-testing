Feature: InvoiceOrder
  Background:
    Given go to the admin "adminPage"
    When I login to admin with valid username and password
    Then I should  be on Admin Porfile pages

    Scenario: Update stone process
      Given  When I click Productions menu
      When  I click in Update Stone Process grid
      And I enter "barcode" in barcode box
      And get id for stone has status = ordered
      And Open another tab for stone management
      And I filter stone with var name "order1"
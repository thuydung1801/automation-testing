@tag
Feature: InvoiceOrder
  Background:
    Given go to the admin "adminPage"
    When I login to admin with valid username and password
    Then I should  be on Admin Porfile pages
  @Test
  @tag-01
  Scenario: create new invoice
    Given I click in Sales menu
    When I click in Order grid
#    And I enter order in the search box
    And I enter "orderid" in the search box
    And Click in 'view' item
    And Click in Invoice Order button
    And Click in Submit Invoice
    And the success message screen appears "createneworder"
    And I click in Sales menu
    And I click in Order item grid
    And I search "orderid" in the order box
    And column Is Requested To Process of record must have the status yes
    And I Click in Check box of order
    And Choose action Request To Process
    And Click submit button
    Then After click submit button The screen display shows the message "success"



#  @tag-02
#  Scenario: request to process in Order item grid - Pass
#      Given I click in Sales menu
#      When I click in Order item grid
#    And I search "orderid" in the order box
#    And I Click in Check box of order
#   And Choose action Request To Process
#    And if column Is Requested To Process of record has a state NO
#    Then After click submit button The screen display shows the message "success"



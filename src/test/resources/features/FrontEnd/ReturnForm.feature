Feature: As a user, I write a demo script

  Background:
    Given Go to "returnForm" url
  @test01
  Scenario: fill all blank in form
    And  Wait about 6 seconds
    And  Click accept cookie
    And  Wait about 6 seconds
    And  Click button Submit return form
    And  Wait about 1 seconds
    Then Show error message for id order_number-error blank: This is a required field.
    And Show error message for email blank: This is a required field.
    And Show error message for id lastname-error blank: This is a required field.
    And Show error message for id phone_number-error blank: This is a required field.
    And Show error message for id term_condition-error blank: This is a required field.
    And Show error message for id change_ringsize_condition-error blank: This is a required field.
    And Show error message for id permission_reproduction-error blank: This is a required field.
    And Show error message for id permission_resizing-error blank: This is a required field.

  @test02
#    skip, i still haven't any order
  Scenario: return successfully
    When Insert barcodeReturn into box have name: order_number
    And Insert EmailReturn into box have name: email_address
    And Insert firstnameReturn into box have name: firstname
    And Click button by class item-checkbox
    And Insert lastNameReturn into box have name: lastname
    And Insert PhoneReturn into box have name: phone
    And  Wait about 6 seconds
    And  Click accept cookie
    And I click button has id term_condition
    And I click button has id term_condition_ringsize
    And I click button has id permission_reproduction
    And I click button has id permission_resizing
    And  Wait about 2 seconds
    And  Click button Submit return form
    Then Show error message for class message-error blank: Your request sent is success.
  @test03
  Scenario: insert text into order number and insert wrong email
    When Insert textOrder into box have name: order_number
    When Insert InvalidEmailReturn into box have name: email_address
    And  Click accept cookie
    And  Wait about 2 seconds
    And  Click button Submit return form
    And  Wait about 2 seconds
    And Show error message for id error_message_validate_order blank: Order number is not valid. Please enter the correct order number.
    And Show error message for email blank: Please enter a valid email address (Ex: johndoe@domain.com).
  @test04
  Scenario: insert text into order number
    When Insert textOrder into box have name: order_number
    And  Click accept cookie
    And  Wait about 2 seconds
    And  Click button Submit return form
    And  Wait about 2 seconds
    Then Show error message for id error_message_validate_order blank: Please enter both order number and email address for return.
  @test05
  Scenario: order and email of customer are not match and leave other blank
    And Insert firstnameReturn into box have name: firstname
    And Insert lastNameReturn into box have name: lastname
    And Insert PhoneReturn into box have name: phone
    And  Wait about 6 seconds
    And  Click accept cookie
    And  Wait about 6 seconds
    And  Click button Submit return form
    Then Show error message for id error_message_validate_order blank: Please enter both order number and email address for return.
  @test06
  Scenario: order and email of customer are not match and leave other isn't blank
    When Insert barcodeReturn into box have name: order_number
    And Insert firstnameReturn into box have name: firstname
    And Insert lastNameReturn into box have name: lastname
    And Insert wrongEmailReturn into box have name: email_address
    And Insert PhoneReturn into box have name: phone
    And  Wait about 2 seconds
    And  Click accept cookie
    And I click button has id term_condition
    And I click button has id term_condition_ringsize
    And I click button has id permission_reproduction
    And I click button has id permission_resizing
    And  Wait about 2 seconds
    And  Click button Submit return form
    And  Wait about 2 seconds
    Then Show error message for class message-error blank: No item to return in your order!

  @test07
  Scenario: Order is unable ( You don't have the right to return the item for > 60 days after delivery.)
#    skip, don't have any order > 60 days after delivery
    When Insert barcodeReturn into box have name: order_number
    And Insert sophie_hutchinson@hotmail.com into box have name: email_address
    And Insert firstnameReturn into box have name: firstname
    And Click button by class item-checkbox
    And Insert lastNameReturn into box have name: lastname
    And Insert PhoneReturn into box have name: phone
    And  Wait about 6 seconds
    And  Click accept cookie
    And I click button has id term_condition
    And I click button has id term_condition_ringsize
    And I click button has id permission_reproduction
    And I click button has id permission_resizing
    And  Wait about 2 seconds
    And  Click button Submit return form
    And  Wait about 10 seconds
    Then Show error message for class message-error blank: msg

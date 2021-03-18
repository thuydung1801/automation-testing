Feature: As a user, I write a demo script

  Background:
    Given Go to returnForm url
  @test01
  Scenario: fill all blank in form
    And  Wait about 6 seconds
    And  Click accept cookie
    And  Wait about 6 seconds
    And  Click button Submit return form
    And  Wait about 1 seconds
#    Then show message for al blank This is a required field.
    Then Show error message for id orderNumberError blank: This is a required field.
    And Show error message for email blank: This is a required field.
    And Show error message for id lastnameError blank: This is a required field.
    And Show error message for id phoneNumberError blank: This is a required field.
    And Show error message for id termConditionError blank: This is a required field.
    And Show error message for id changeRingsizeConditionError blank: This is a required field.
    And Show error message for id permissionReproductionError blank: This is a required field.
    And Show error message for id permissionResizingError blank: This is a required field.

  @test02
#    skip, i still haven't any order
  Scenario: return successfully
    When Insert 1250109007 into box have name: orderNumber
    And Insert sophie.fabre37@gmail.com into box have name: emailInp
    And Insert Thanh into box have name: firstNameInp
    And Click button by class item-checkbox
    And Insert Opentechiz into box have name: lastNameInp
    And Insert 123456789 into box have name: phoneNumber
    And  Wait about 6 seconds
    And  Click accept cookie
    And I click button has id checkBoxTerm
    And I click button has id checkboxRingSz
    And I click button has id checkboxPer
    And I click button has id checkboxRes
    And  Wait about 2 seconds
    And  Click button Submit return form
    And  Wait about 10 seconds
    Then Show error message for class sucMsg blank: Your request sent is success.
  @test03
  Scenario: insert text into order number and insert
    When Insert thanhtest into box have name: orderNumber
    When Insert thanh.tester.gmail into box have name: emailInp
    And  Click accept cookie
    And  Wait about 2 seconds
    And  Click button Submit return form
    And  Wait about 2 seconds
    And Show error message for id errorMessageValidateOrder blank: Order number is not valid. Please enter the correct order number.
    And Show error message for email blank: Please enter a valid email address (Ex: johndoe@domain.com).
  @test04
  Scenario: insert text into order number
    When Insert thanhtest into box have name: orderNumber
    And  Click accept cookie
    And  Wait about 2 seconds
    And  Click button Submit return form
    And  Wait about 2 seconds
    Then Show error message for id errorMessageValidateOrder blank: Please enter both order number and email address for return.
  @test05
  Scenario: order and email of customer are not match and leave other blank
    When Insert Thanh into box have name: firstNameInp
    And Insert Opentechiz into box have name: lastNameInp
    And Insert 123456789 into box have name: phoneNumber
    And  Wait about 6 seconds
    And  Click accept cookie
    And  Wait about 6 seconds
    And  Click button Submit return form
    And  Wait about 110 seconds
    Then Show error message for id errorMessageValidateOrder blank: Please enter both order number and email address for return.
  @test06
  Scenario: order and email of customer are not match and leave other isn't blank
    When Insert 721568469 into box have name: orderNumber
    When Insert Thanh into box have name: firstNameInp
    And Insert Opentechiz into box have name: lastNameInp
    And Insert thanh.tester@gmail.com into box have name: emailInp
    And Insert 123456789 into box have name: phoneNumber
    And  Wait about 6 seconds
    And  Click accept cookie
    And I click button has id checkBoxTerm
    And I click button has id checkboxRingSz
    And I click button has id checkboxPer
    And I click button has id checkboxRes
    And  Wait about 2 seconds
    And  Click button Submit return form
    And  Wait about 10 seconds
    Then Show error message for class sucMsg blank: No item to return in your order!

  @test06
  Scenario: Order is unable ( You don't have the right to return the item for > 60 days after delivery.)
#    skip, don't have any order > 60 days after delivery
    When Insert 729271667 into box have name: orderNumber
    And Insert sophie_hutchinson@hotmail.com into box have name: emailInp
    When Insert Thanh into box have name: firstNameInp
    And Click button by class item-checkbox

    And Insert Opentechiz into box have name: lastNameInp
    And Insert 123456789 into box have name: phoneNumber
    And  Wait about 6 seconds
    And  Click accept cookie
    And I click button has id checkBoxTerm
    And I click button has id checkboxRingSz
    And I click button has id checkboxPer
    And I click button has id checkboxRes
    And  Wait about 2 seconds
    And  Click button Submit return form
    And  Wait about 10 seconds
    Then Show error message for class sucMsg blank: msg

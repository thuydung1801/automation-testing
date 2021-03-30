Feature: Create Ship and generate label
  Background:
    Given Go to "adminPage" url
    When Insert adminM2 into box have id: username
    And Insert admin123 into box have id: login
    And Click button by class action-primary
      # click sign in btn
    Then Successfully into DashboardPage front site


    Given Go to "PackageReadyShipping" url
#    viết môi trường lọc


  @Test01
  Scenario: create ship successfully
    And Wait about 2 seconds
    When Choose item have row in Package Ready Shipping Page :2
    And Wait about 2 seconds
    When Choose item have row in Package Ready Shipping Page :4
    And Wait about 2 seconds
    And I click button has text Create Ship and generate label
    And Wait about 2 seconds
    And Click button to create ship
    And Wait about 2 seconds
    Then The system show success message
  @Test02
  Scenario: create ship when don't choose item
    And Wait about 2 seconds
    And I click button has text Create Ship and generate label
    And Wait about 2 seconds
    And Click button to create ship
    And Wait about 2 seconds
    Then The system show success message
  @Test02
  Scenario: click cancel
    And Wait about 2 seconds
    When Choose item have row in Package Ready Shipping Page :2
    And Wait about 2 seconds
    When Choose item have row in Package Ready Shipping Page :4
    And Wait about 2 seconds
    And I click button has text Create Ship and generate label
    And Wait about 2 seconds
    And Click button to cancel ship
    And Wait about 2 seconds
    Then The system show success message
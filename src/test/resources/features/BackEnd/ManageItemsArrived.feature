Feature:
  Background:
    Given Go to "adminPage" url
    When Insert adminM2 into box have id: emailAdmin
    And Insert admin123 into box have id: passAdmin
#    wait Lan's login admin
    And Click button by class signInBtn
    Then Successfully into DashboardPage front site
    Given Go to "ManageItemsArrivedStep" url
  #    viết môi trường lọc
  @Test01
  Scenario: create ship fail: The selected items are not the same dispacth location. Please select again!
    And Wait about 2 seconds
    When Choose item have row in Manage Items Arrived Page : 2
    When Choose item have row in Manage Items Arrived Page : 4
    And I click button has text Create Ship and generate label
    And Click button to ship out
    And Click button : Ok
    Then The system show success message
    Then Show Messages in Manage Items Arrived: The selected items are not the same dispacth location. Please select again!
  @Test02
  Scenario: create ship successfully
    And Wait about 2 seconds
    When Choose item have row in Manage Items Arrived Page : 2
    And Wait about 2 seconds
    And I click button has text Create Ship and generate label
    And Wait about 2 seconds
    And Click button to ship out
    And Wait about 2 seconds
    And Click button : Ok
    Then The system show success message
    Then Show Messages in Manage Items Arrived: afasfasdgsafg


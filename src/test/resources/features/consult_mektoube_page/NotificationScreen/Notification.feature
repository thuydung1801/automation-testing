Feature: Notification

  #ok
  # QA-804
  @TEST_QRA-492
  Scenario:the green point of the notifications are displayed
    Given Go to "Mektoube.fr" url
    When Wait about 1 second

    When Login with account "shainez29" and password "mektoube"
    When Scroll to view "AdvancedCriteria"
    When Wait about 2 second
                #scroll and click
    When Scroll to view "PseudoLabel"
    When Wait about 1 second
    When Insert "yassine_yes" into "nicknameTextfield" Field (upd)
    When Click "checkPopup"
    When Click "validateButton"
    When Wait about 1 second
    When Click on the person have above name "yassine_yes"
    When Click "discussBtn"
    When Click "MonCompteButton"
    When Click "Reglages"
    When Scroll All page "filterItemInSetting"
  #click on sign out,womanSignOut
    When Click on the element is "//h5[text()='Se déconnecter']" by xpath
    When Wait about 1 second
    # login again with Yassine_yes
    When Login with account "Yassine_yes" and password "Mektoubi2017"
    When Wait about 2 second
    Then the green point of the notifications are displayed

  #QA-806
  @TEST_QRA-493
  Scenario: receive a refused photo notification
    Given Go to "Mektoube.fr" url
    When Wait about 1 second

    When Login with account "testWoman" and password "mektoube"
    When Click "notification"
    When Scroll All page "notiItem"
    Then The page recevied a refused photo notification

  #QA-798
  @TEST_QRA-494
  Scenario: click on a notification of smile
    Given Go to "Mektoube.fr" url
    When Wait about 1 second

    When Login with account "testWoman" and password "mektoube"
    When Click "notification"
    When Scroll All page "notiItem"
    #save name
    When Clicking on a notification of smile
    Then The page redirect to page of profile
    And Name of notification must equal with name in profile

  #QA-799
  @TEST_QRA-495
  Scenario: click on a notification of visit
    Given Go to "Mektoube.fr" url
    When Wait about 1 second

    When Login with account "testWoman" and password "mektoube"
    When Click "notification"
    When Scroll All page "notiItem"
    When Clicking on a notification of visit
    Then The page redirect to page of profile
    And Name of notification must equal with name in profile

  #QA-800
  @TEST_QRA-496
  Scenario: Notifications - click on "smiles"
    Given Go to "Mektoube.fr" url
    When Wait about 1 second

    When Login with account "testWoman" and password "mektoube"
    When Click "notification"
    When Scroll All page "notiItem"
    When Click "roundBtnNotification"
    When Click "smileSelect"
    When Scroll All page "notiItem"
    Then The page show all notifications that are smile noti

  #QA-801
  @TEST_QRA-497
  Scenario: Notifications - click on "visit"
    Given Go to "Mektoube.fr" url
    When Wait about 1 second

    When Login with account "testWoman" and password "mektoube"
    When Click "notification"
    When Scroll All page "notiItem"
    When Click "roundBtnNotification"
    When Click "visitSelect"
    When Scroll All page "notiItem"
    Then The page show all notifications that are visit noti

  #QA-803
  @TEST_QRA-498
  Scenario: Notifications - click on "tout"
    Given Go to "Mektoube.fr" url
    When Wait about 1 second

    When Login with account "testWoman" and password "mektoube"
    When Click "notification"
    When Scroll All page "notiItem"
    When Click "roundBtnNotification"
    When Click "showAllSelect"
    When Scroll All page "notiItem"
    Then The page show all notifications that are all notis

#  #QA-807
#  Scenario: click on a notification of visit in real time
#     Given Go to "Mektoube.fr" url
    When Wait about 1 second
#
#    When Login with account "testWoman" and password "mektoube"
#    When Click "notification"
#    When Scroll All page "notiItem"
#    #save name
#    When Click on a notification of visit in real time
#    Then The page redirect to page of profile
#    And The profile must have green point
#    And Name of notification must equal with name in profile
#
#  #QA-808=>ok
#  Scenario: click on a notification of smile in real time
#     Given Go to "Mektoube.fr" url
    When Wait about 1 second
#
#    When Login with account "testWoman" and password "mektoube"
#    When Click "notification"
#    When Scroll All page "notiItem"
#    #save name
#    When Click on a notification of smile in real time
#    Then The page redirect to page of profile
#    And The profile must have green point
#    And Name of notification must equal with name in profile

     #QA-805=>OK
  @TEST_QRA-499
  Scenario: receive an accepted photo notification
    Given Go to "Mektoube.fr" url
    When Wait about 1 second

    When Login with account "testWoman" and password "mektoube"
    When Click "notification"
    When Scroll All page "notiItem"
    Then The page recevied a accept photo notification

  #QA-809
  #?? click on online
  #??
#  Scenario: click on a notification of "Il souhaite croiser / elle a accepté de croiser votre destin" in real time
#     Given Go to "Mektoube.fr" url
    When Wait about 1 second
#
#    When Login with account "testWoman" and password "mektoube"
#    When Click "CroisezVosDestins"
#    When Scroll to view "onlineRequestContact"
##    When Scroll All page "requestContactItem"
##    When Click on the first online person in request contact list
#    Then The page redirect to page of profile

  #QA-794
  #not check, not real time, not need run auto
#  Scenario: activate only "a person visit my profile" - online
#     Given Go to "Mektoube.fr" url
    When Wait about 1 second
#
#    When Login with account "testWoman" and password "mektoube"
#    When Click "MonCompteButton"
#    When Click "Reglages"
#    When Click "NotificationLabel"
#    When Click on the element is "APersonVisitMyProfile" if not yet checked
#    #scroll and click on save button
#    When Scroll to view "SaveBtn"
#    Then The page show green notification is "Vos préférences ont été mises à jour" at "greenMessLocation"
#    And Click "womanSignOut"
#    When Login with account "yassine_yes" and password "Mektoubi2017"
#    When Scroll to view "AdvancedCriteria"
#    When Wait about 1 second
#                #scroll and click
#    When Scroll to view "PseudoLabel"
#    When Wait about 1 second
#    When Insert "testwoman4" into "nicknameTextfield" Field (upd)
#    When Click "checkButton"
#    When Click "validateButton"
#    When Click on the person have above name "testwoman4"
#    When Click "MonCompteButton"
#    When Click "Reglages"
#    And Click "manSignOut"
#    When Login with account "testwoman4" and password "mektoube"
#    When Click "notification"
#    Then The page shows first visit notification is "yassine_yes"














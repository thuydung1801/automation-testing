#  QRA-892 TEST SET

@QRA-80
Feature: BlackList

  #ok ok
  @TEST_QRA-73
  #QA-520
  Scenario: See her blacklist
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Click "MonCompte"
    #When Scroll page
    When Click "Reglages"
    When Wait about 1 second
    When Click on the element is "//h5[text()='Blackliste']" by xpath
    When Wait about 1 second
    #When Scroll page
    #user all is men
    Then Display BlackList

    #ok ok,ok10/11
  @TEST_QRA-74
  #QA-514
  Scenario: Add someone to blacklist from the conversation
    Given Go to "ResponsivePreprod" url

    When Wait about 1 second
    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Click "Messages"
    When Wait about 3 second
    When Click to one conversation
    When Wait about 3 second
    When Click "materialIconMess"
    When Wait about 1 second
    When Click "blockInConversation"
    When Wait about 4 second
    Then Check blocked result
    When Click "more_vert"
    When Click "firstRemoveInBlackList"
    Then Check unblocked result

    #ok ok
  @TEST_QRA-75
    #QA-515
  Scenario: Add someone to blacklist from the profile
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Click first person in discovery
    When Click "metarialinprofile"
    When Click "blockInProfile"
    Then The page show notification The block is confirmed
    And Wait about 5 second
    And Click "MonCompte"
    And Click "Reglages"
    When Click "womanBlackListLabel"
    And Scroll All page "blockListItem"
    Then The block list have to store above profile
    When Click "more_vert"
    When Click "firstRemoveInBlackList"
    Then Check unblocked result

    #ok ok-> fixed=>ok
  @TEST_QRA-76
  #QA-516
  Scenario: Remove a profile of the blackliste
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Click "MonCompte"
    When Click "Reglages"
    When Click "BlackList"
    When Click "more_vert"
    When Click "firstRemoveInBlackList"
    Then Check unblocked result

    #just fix=>ok,ok
  #need to fix because must not send to person other test person
  @TEST_QRA-77
  #QA-517
  Scenario: Sent a message to a person who is in the blacklist
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 2 second
    When Click "MonCompteButton"
    When Click "Reglages"
    When Disable age filter
    When Click "discoveryScreenBt"
    When Scroll to "AdvancedCriteria" and click
    When Scroll to "nickname" and click
    #When Click "nickname"
    When Insert "yassine_yes2" into "nicknameTextfield" Field (upd)
    When Click "checkButton"
    When Click "validateButton"
    #When Scroll All page
    When Wait about 1 second
    When Click on the element is "//h5[text()='yassine_yes2']" by xpath
    When Wait about 1 second
    When Click "discussBtn"
#    When Insert "hello yassine2" into "fieldChat" Field (upd)
    When Insert "hello yassine2" into "fieldChat" Field (upd)
    When Wait about 1 second
    When Click "sendMessageButton"
    When Wait about 2 second
    And Click "SignOutIcon"
    And Click "SeConnecter"
    When Insert "yassine_yes2" into "usernameBtn" Field (upd)
    When Insert "Mektoubi2017" into "passwordBtn" Field (upd)
    When Click "loginBtn"
    When Click "MonCompteButton"
    When Click "Reglages"
    When Disable age filter
    When Click "Messages"
    When Wait about 2 second
    When Click on the element is "//h5[text()='alian98']" by xpath
    When Insert "hello alian98" into "fieldChat" Field (upd)
    When Wait about 1 second
    When Click "sendMessageButton"
    When Wait about 3 second
    And Click "SignOutIcon"
    And Click "SeConnecter"
    When Insert "thuyyylinhhh89@gmail.com" into "usernameBtn" Field (upd)
    When Insert "mektoube**" into "passwordBtn" Field (upd)
    When Click "loginBtn"
    When Click "Messages"
    When Wait about 1 second
    When Click on the element is "//h5[text()='yassine_yes2']" by xpath
    When Wait about 1 second
    When Click "materialIconMess"
    When Click "blockInConversation"
    When Wait about 3 second
    When Refresh page
    When Wait about 2 second
#    When Insert "blocked yassine2" into "fieldChat" Field (upd)
#    When Click "sendMessageButton"
    When Click "gifIcon"
    When Wait about 2 second
    Then The page show error message is "Vous avez bloqué cette personne"
#    When Click "sendMessageButton"
#    When Click "MonCompteButton"
#    When Click "Reglages"
#    When Click "//h5[text()='Se déconnecter']" by xpath
#    When Click to link Se connecter
#    When Insert "yassine_yes2" into "username" Field (upd)
#    When Insert "Mektoubi2017" into "password" Field (upd)
#    When Click Login button
#    When Click "Messages"
#    When Click "//h5[text()='thuyyylinhhh89@gmail.com']" by xpath
#    When Click "fieldChat"
#    When Wait about 1 second 1000
#    Then The page show error message is "Vous ne pouvez pas écrire à thuyyylinhhh89@gmail.com"
    #unblock yassine_yes2
    And Wait about 4 second
    When Click "MonCompteButton"
    When Click "Reglages"
#    When Click "//h5[text()='Se déconnecter']" by xpath
#    When Click to link Se connecter
#    When Insert "thuyyylinhhh89@gmail.com" into "username" Field (upd)
#    When Insert "mektoube**" into "password" Field (upd)
#    When Click Login button
#    When Click "MonCompteButton"
#    When Click "Reglages"
    When Click on the element is "//h5[text()='Blackliste']" by xpath
    When Wait about 1 second
    When Click "more_vert"
    When Click "unBlockOption"

#
#      #not yet same above task=>okok, not yet=>ok=>ok 10_11
#  27/2/2020
  @TEST_QRA-78
  #QA-518
  Scenario: Sent a smile to a person who is in the blacklist
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Click "MonCompteButton"
    When Click "Reglages"
    When Disable age filter
    When Click "discoveryScreenBt"
    When Scroll to "AdvancedCriteria" and click
    When Insert "yassine_yes2" into "nicknameTextfield" Field (upd)
    When Click "checkButton"
    When Click "validateButton"
    When Wait about 1 second
    When Click on the element is "//h5[text()='yassine_yes2']" by xpath
    When Click "metarialInProfile"
    When Click "blockInProfile"
    Then The page show notification The block is confirmed
    When Wait about 3 second
    Then The page dont have "smileButton"
    When Click "metarialInProfile"
    When Click "unblockInProfile"
    Then The page show green notification is "Personne débloquée" at "greenNotiInTopHeader"
    When Wait about 3 second


#     Given Go to "ResponsivePreprod" url
#
#    When Click to link Se connecter
#    When Insert "thuyyylinhhh89@gmail.com" into "username" Field (upd)
#    When Insert "mektoube**" into "password" Field (upd)
#    When Click Login button
#    When Wait about 1 second
#    When Click "MonCompteButton"
#    When Click "Reglages"
#    When Click "womanBlackListLabel"
#    When Click "more_vert" (Upd)
#    When Click on Supprimer
#    When Wait about 1 second
#    When Click "closeBlackList"
#    When Wait about 1 second 2000
#    #??
#    When Click "discoveryScreenBt"
#    #Scroll to view and click
#    When Scroll to "AdvancedCriteria" and click
#    When Scroll to "AdvancedCriteria" and click
#    #When Wait about 1 second
#    When Insert unblock name into "nicknameTextfield" Field
#    When Click "checkButton"
#    When Click "validateButton"
#    #When Scroll All page
#    When Wait about 1 second
#    When Click on the person have above name
#    Then Click "smileButton"

#no, error:  http://prntscr.com/p70x8m =>ok, local storage
  #not check in case have pre mess block
#  27/2/2020
  @TEST_QRA-79
  #QA-519
  Scenario: Sent a message / smile to a person who is blocking us
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    #find Yassine_yes to block
    #When Click "discoveryScreenBt"
    #Scroll to view and click
    When Wait about 1 second
    When Scroll to "AdvancedCriteria" and click
    #When Click "nickname"
    When Insert "yassine_yes2" into "nicknameTextfield" Field (upd)
    When Click "checkButton"
    When Click "validateButton"
    #When Scroll All page
    When Wait about 3 second
    When Click on the element is "//h5[text()='yassine_yes2']" by xpath
    When Wait about 1 second
    When Click "discussBtn"
    When Insert "hello, this test message from Linh" into "fieldChat" Field (upd)
    When Click "sendMessageButton"
    When Wait about 1 second
    When Click "metarialInConversation"
    When Click "blockInConversation"
    Then The page show notification The block is confirmed
    When Wait about 4 second
  #click on sign out
    And Click "SignOutIcon"
    # login again with Yassine_yes
    And Click "SeConnecter"
    When Insert "Yassine_yes2" into "usernameBtn" Field (upd)
    When Insert "Mektoubi2017" into "passwordBtn" Field (upd)
    When Click "loginBtn"
    When Wait about 2 second
#     #Scroll to view and click
#    When Scroll to "AdvancedCriteria" and click
#    When Scroll to "AdvancedCriteria" and click
#    When Insert "thuyyylinhhh89@gmail.com" into "nicknameTextfield" Field (upd)
#    When Click "checkButton"
#    When Click "validateButton"
#    When Wait about 1 second
#    Then The page dont show a person who is blocking us
    When Click "Messages"
    When Click on the element is "//h5[text()='alian98']" by xpath
#    neu khong duoc thi dung move mouse or click sendbutton
    Then Can not send message
#    When Insert "hello, this test message from Linh" into "fieldChat" Field (upd)
#    red notification is ok
    When Wait about 1 second
    And Click "SignOutIcon"
    And Click "SeConnecter"
    When Insert "thuyyylinhhh89@gmail.com" into "usernameBtn" Field (upd)
    When Insert "mektoube**" into "passwordBtn" Field (upd)
    When Click "loginBtn"
    When Click "MonCompte"
    When Click "Reglages"
    When Click on the element is "//h5[text()='Blackliste']" by xpath
    When Wait about 1 second
    When Click "more_vert"
    When Click "unBlockOption"





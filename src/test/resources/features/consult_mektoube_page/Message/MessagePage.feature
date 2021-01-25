#just have 2 issue in mobile
#  QRA-893 TEST SET
@QRA-82
Feature: Message

  #okok
  @TEST_QRA-83
   #QA-621
  Scenario: a user know when a message is not read
    Given Go to "ResponsivePreprod" url

    When Login with account "wpo19333@bcaoo.com" and password "mektoube"
    When Click "Messages"
    When Scroll special element "messageItem"
    Then The messages have unread-dot are not read

    #okok
  @TEST_QRA-84
   #QA-631
  Scenario: read a message
    Given Go to "ResponsivePreprod" url

    When Login with account "wpo19333@bcaoo.com" and password "mektoube"
    When Click "Messages"
    When Wait about 1 second
    Then Showing conversation

    #okok
  #need check again=> ok but dont coverage with previous years, ???
#  @TEST_QRA-85
#  #QA-622
#  Scenario: discussions are sorted from the most recent to the oldest
#    Given Go to "ResponsivePreprod" url
#
#    When Login with account "wpo19333@bcaoo.com3" and password "mektoube"
#    When Click "Messages"
#    When Wait about 1 second
#    #not yet check again
#    When Scroll special element "messageItem"
#    Then The page show discussions that are sorted from the most recent to the oldest

    #no=>ok,29_11
  @TEST_QRA-86
   #QA-625
  Scenario: click on the thumbnail to visit the profile
    Given Go to "ResponsivePreprod" url

    When Login with account "wpo19333@bcaoo.com" and password "mektoube"
    When Wait about 1 second
    When Click "Messages"
    When Wait about 1 second
    When Click "firstConversation"
    When Wait about 1 second
    When Click on last thumbnail in conversation
    When Wait about 1 second
    When Visiting one profile

    #okok
  @TEST_QRA-87
   #QA-626
  Scenario: not possible to send an empty message
    Given Go to "ResponsivePreprod" url

    When Login with account "wpo19333@bcaoo.com" and password "mektoube"
    When Click "Messages"
    When Click "firstConversation"
    When Insert "  " into "fieldChat" Field (upd)
    #29_11
    Then The page dont allow send an empty message

    #okok
  @TEST_QRA-88
   #QA-629
  Scenario: message counter displays +10 if more than 10 messages
    Given Go to "ResponsivePreprod" url

    When Login with account "wpo19333@bcaoo.com" and password "mektoube"
    When Wait about 1 second
    Then The page shows +ten if more than ten messges
    And Click "Messages"
    When Click "filter_list_mess"
    When Click "unreadMessage"
    When Scroll special element "messageItem"
    Then The page check this account have more than ten not read messages

#okok
  @TEST_QRA-93
   #QA-627
  Scenario: send a gif
    Given Go to "ResponsivePreprod" url

    When Login with account "wpo19333@bcaoo.com" and password "mektoube"
    When Click "MonCompteButton"
    When Click "Reglages"
    When Disable age filter
    When Click "discoveryScreenBt"
    #
    When Scroll to "AdvancedCriteria" and click
    When Scroll to "nickname" and click
    #When Click "nickname"
    When Insert "testman" into "nicknameTextfield" Field (upd)
    When Click "checkButton"
    When Click "validateButton"
    #When Scroll All page
    When Wait about 2 second
    When Click on the element is "//h5[text()='testman']" by xpath
    When Wait about 1 second
    When Click "discussBtn"
    When Click "gifIcon"
    When Click on first gif is "firstGif"
    When Click "sendMessButton"
    When Wait about 2 second
    Then The last message must be gif
    #??count number of row message
    #Then Checking send a gif successful

    #okok
  @TEST_QRA-94
   #QA-691
  Scenario: send a gif - cancel
    Given Go to "ResponsivePreprod" url

    When Login with account "wpo19333@bcaoo.com" and password "mektoube"
    When Click "MonCompteButton"
    When Click "Reglages"
    When Disable age filter
    When Click "discoveryScreenBt"
    #
    When Scroll to "AdvancedCriteria" and click
    When Scroll to "nickname" and click
    #When Click "nickname"
    When Insert "testman" into "nicknameTextfield" Field (upd)
    When Click "checkButton"
    When Click "validateButton"
    #When Scroll All page
    When Wait about 1 second
    When Click on the element is "//h5[text()='testman']" by xpath
    When Wait about 1 second
    When Click "discussBtn"
    When Click "gifIcon"
    When Click "firstGif"
    When Click "cancelGif"
    And Wait about 3 second
    #Then The page dont show gif images

    #okok
  @TEST_QRA-95
   #QA-692
  Scenario: send a gif without select
    Given Go to "ResponsivePreprod" url

    When Login with account "wpo19333@bcaoo.com" and password "mektoube"
    When Click "MonCompteButton"
    When Click "Reglages"
    When Disable age filter
    When Click "discoveryScreenBt"
    #
    When Scroll to "AdvancedCriteria" and click
    When Scroll to "nickname" and click
    #When Click "nickname"
    When Insert "testman" into "nicknameTextfield" Field (upd)
    When Click "checkButton"
    When Click "validateButton"
    #When Scroll All page
    When Wait about 1 second
    When Click on the element is "//h5[text()='testman']" by xpath
    When Wait about 1 second
    When Click "discussBtn"
    When Click "gifIcon"
    Then The send button is disable
   # Then The page dont allow send a gif without select

     #okok
  @TEST_QRA-96
   #QA-628
  Scenario: do a gif search
    Given Go to "ResponsivePreprod" url

    When Login with account "wpo19333@bcaoo.com" and password "mektoube"
    When Click "MonCompteButton"
    When Click "Reglages"
    When Disable age filter
    When Click "discoveryScreenBt"
    #
    When Scroll to "AdvancedCriteria" and click
    When Scroll to "nickname" and click
    #When Click "nickname"
    When Insert "testman" into "nicknameTextfield" Field (upd)
    When Click "checkButton"
    When Click "validateButton"
    #When Scroll All page
    When Wait about 1 second
    When Click on the element is "//h5[text()='testman']" by xpath
    When Wait about 1 second
    When Click "discussBtn"
    When Click "gifIcon"
    When Insert "hello" into "fieldChat" Field (upd)
    Then The search gif textfield show text is hello

     #okok
  @TEST_QRA-97
   #QA-632
  Scenario: write and send a message
    Given Go to "ResponsivePreprod" url

    When Login with account "wpo19333@bcaoo.com" and password "mektoube"
    When Click "MonCompteButton"
    When Click "Reglages"
    When Disable age filter
    When Click "discoveryScreenBt"
    #
    When Scroll to "AdvancedCriteria" and click
    When Scroll to "nickname" and click
    #When Click "nickname"
    When Insert "testman" into "nicknameTextfield" Field (upd)
    When Click "checkButton"
    When Click "validateButton"
    #When Scroll All page
    When Wait about 1 second
    When Click on the element is "//h5[text()='testman']" by xpath
    When Wait about 1 second
    When Click "discussBtn"
    When Insert "hello" into "fieldChat" Field (upd)
    When Click "sendMessButton"
    When Wait about 5 second
    Then The conversation have last row is hello

#no=>ok
  @TEST_QRA-98
  #QA-633
  Scenario: click on "message non lus " (unread message)
    Given Go to "ResponsivePreprod" url

    When Login with account "wpo19333@bcaoo.com" and password "mektoube"
    When Click "Messages"
    When Click "filter_list_mess"
    When Click "unreadMessage"
    When Wait about 1 second
    When Scroll special element "messageItem"
    Then Checking unread message list

    #no=>ok
  @TEST_QRA-99
  #QA-634
  Scenario: click on "tous les messages"(all messages)
    Given Go to "ResponsivePreprod" url

    When Login with account "wpo19333@bcaoo.com" and password "mektoube"
    When Click "Messages"
    When Click "filter_list_mess"
    When Click "all-messages"
    When Scroll special element "messageItem"
    Then The page show all messages

    #okok
  @TEST_QRA-102
  #QA-630
  Scenario: msg counter displays the correct number of msg not read when there are less 10 msg
    Given Go to "ResponsivePreprod" url

    When Login with account "wpo19333@bcaoo.com" and password "mektoube"
    When Click "Messages"
    Then Number of unread messages have to correct

    #just fix, error > 2 times: http://prntscr.com/p71gzl=>okok
  @TEST_QRA-103
  #QA-802
  Scenario: Woman - send a message to a non subscriber man
    Given Go to "ResponsivePreprod" url

    When Login with account "wpo19333@bcaoo.com" and password "mektoube"
    When Scroll to "AdvancedCriteria" and click
    When Scroll to "nickname" and click
    When Insert "testman2" into "nicknameTextfield" Field (upd)
    When Click "checkButton"
    When Click "validateButton"
    When Wait about 1 second
    #lam lai
    When Click on the element is "//h5[text()='testman2']" by xpath
    When Click "disscussProfile"
    When Insert "hello" into "fieldChat" Field (upd)
    When Click "sendMessageButton"
    When Click "SignOutIcon"
    When Click "SeConnecter"
    When Insert "testman2" into "usernameBtn" Field (upd)
    When Insert "mektoube" into "passwordBtn" Field (upd)
    When Click "loginBtn"
    When Wait about 1 second
    When Click "Messages"
    When Click on the element is "//h5[text()='wpo19333@bcaoo.com']" by xpath
    Then The page show pop up request pay the fee

  #not yet fix bug
#  @MyTest
#  #QA-623
#  Scenario: delete a discussion and continue the discussion
#     Given Go to "ResponsivePreprod" url
#
#    When Click to link Se connecter
#    When Insert "wpo19333@bcaoo.com" into "username" Field (upd)
#    When Insert "mektoube" into "password" Field (upd)
#    When Click Login button
#    When Click "Messages"

  @TEST_QRA-89
  Scenario: delete conversations from the left button
    Given Go to "ResponsivePreprod" url

    When Login with account "wpo19333@bcaoo.com" and password "mektoube"
    When Click "Messages"
    When Wait about 1 second
    When Click "RoundButton"
    When Click "Remove"
    Then The page the red button supprimer appears to the right of each discusses
    When Click on first delete in conversation is "firstDeleteInConversation"
    Then The page show green notification
    And Wait about 1 second
    And This discustion dont show in message

#    27/2/2020
  @TEST_QRA-90
  Scenario: delete a discussion and continue the discussion
    Given Go to "ResponsivePreprod" url

    When Login with account "wpo19333@bcaoo.com" and password "mektoube"
    And Wait about 1 second
    When Scroll to "AdvancedCriteria" and click
    When Wait about 1 second
                #scroll and click
    When Scroll to "PseudoLabel" and click
    When Wait about 1 second
    When Insert "yassine_yes" into "nicknameTextfield" Field (upd)
    When Click "checkButton"
    When Click "validateButton"
    When Wait about 1 second
    When Click on the element is "//h5[text()='yassine_yes']" by xpath
    And Click "discussBtn"
    When Insert "hello, test from Linh" into "fieldChat" Field (upd)
    When Wait about 1 second
    When Click "sendMessButton"
    #starting delete
    When Click "RoundButton"
    When Click "Remove"
    When Click on first delete in conversation is "firstDeleteInConversation"
    Then The page show green notification
    And Wait about 4 second
    #??,
    #And Scroll message item
    And This discustion dont show in message
    When Click "RoundButton"
    When Click "Cancelmess"
    When Click "discoveryScreenBt"
    When Click on the element is "//h5[text()='yassine_yes']" by xpath
    And Click "discussBtn"
    When Insert "hello, test from Linh after delete and continue discuss" into "fieldChat" Field (upd)
    When Wait about 1 second
    When Click "sendMessButton"
    When Wait about 1 second
    Then The page show message with last content is "hello, test from Linh after delete and continue discuss" with "yassine_yes"
#    When Click "Messages"
#    When Wait about 1 second
#    When Click "RoundButton"
#    When Click "Remove"
#    When Click on first delete in conversation is "firstDeleteInConversation"
#    Then The page show green notification
#    And Wait about 1 second
#    #??
#    #And Scroll message item
#    And This discustion dont show in message
#    And Wait about 1 second
#    #find this person by name and click on the discuss then dont have any discussion
#    And Click "discoveryScreenBt"
#    When Scroll to "AdvancedCriteria" and click
#    When Wait about 1 second
#                #scroll and click
#    When Scroll to "PseudoLabel" and click
#    When Wait about 1 second
#    When Insert above deleted name into "nicknameTextfield" Field (upd)
#    When Click "checkPopup"
#    When Click "validateButton"
#    When Wait about 1 second
#    And Click on the profile that deleted discussion
#    And Click "discussBtn"
#    #first time have one profile =>pass
#    And This discussion dont have any discuss line

#29_11
  @TEST_QRA-91
  Scenario: delete a discussion - the discussion is always present in the other person
    Given Go to "ResponsivePreprod" url

    When Login with account "wpo19333@bcaoo.com" and password "mektoube"
    #create discussion with Yassine_yes
    When Scroll to "AdvancedCriteria" and click
    When Wait about 1 second
                #scroll and click
    When Scroll to "PseudoLabel" and click
    When Wait about 1 second
    When Insert "yassine_yes" into "nicknameTextfield" Field (upd)
    When Click "checkButton"
    When Click "validateButton"
    When Wait about 1 second
    When Click on the element is "//h5[text()='yassine_yes']" by xpath
    And Click "discussBtn"
    When Insert "hello, test from Linh" into "fieldChat" Field (upd)
    When Wait about 1 second
    When Click "sendMessButton"
    #starting delete
    When Click "RoundButton"
    When Click "Remove"
    When Click on first delete in conversation is "firstDeleteInConversation"
    Then The page show green notification
    And Wait about 1 second
    #??,
    #And Scroll message item
    And This discustion dont show in message
    When Click "RoundButton"
    When Click "Cancelmess"
    #Then The page the red button supprimer deappears
    #logout wpo19333@bcaoo.com and login yassine_yes
    When Click "SignOutIcon"

    When Click "SeConnecter"
    When Insert "yassine_yes" into "usernameBtn" Field (upd)
    When Insert "Mektoubi2017" into "passwordBtn" Field (upd)
    When Click "loginBtn"

    When Wait about 1 second
    When Click "Messages"
    When Wait about 1 second
    #??, may be not need scroll because Yassine_yes always show at first discussions
    #And Scroll message item
    Then The page still show discussion of Yassine_yes with "wpo19333@bcaoo.com"

  @TEST_QRA-92
  Scenario: delete a discussion - the other person continue the discuss
    Given Go to "ResponsivePreprod" url

    When Login with account "wpo19333@bcaoo.com" and password "mektoube"
    #create discussion with Yassine_yes
    When Scroll to "AdvancedCriteria" and click
    When Wait about 1 second
                #scroll and click
    When Scroll to "PseudoLabel" and click
    When Wait about 1 second
    When Insert "yassine_yes" into "nicknameTextfield" Field (upd)
    When Click "checkButton"
    When Click "validateButton"
    When Wait about 1 second
    When Click on the element is "//h5[text()='yassine_yes']" by xpath
    And Click "discussBtn"
    When Insert "hello" into "fieldChat" Field (upd)
    When Wait about 1 second
    When Click "sendMessButton"
    #starting delete
    When Click "RoundButton"
    When Click "Remove"
    When Click on first delete in conversation is "firstDeleteInConversation"
    Then The page show green notification
    And Wait about 1 second
    #??,
    #And Scroll message item
    And This discustion dont show in message
    When Click "RoundButton"
    When Click "Cancelmess"
    #Then The page the red button supprimer deappears
    #logout wpo19333@bcaoo.com and login Yassine_yes
    When Click "SignOutIcon"
    When Click "SeConnecter"
    When Insert "yassine_yes" into "usernameBtn" Field (upd)
    When Insert "Mektoubi2017" into "passwordBtn" Field (upd)
    When Click "loginBtn"
    When Wait about 1 second

    When Click "Messages"
    When Click on the message with "wpo19333@bcaoo.com"
    When Wait about 2 second
    When Insert "hello22" into "fieldChat" Field (upd)
    When Wait about 1 second
    When Click "sendMessButton"
    When Click "SignOutIcon"

    When Click "SeConnecter"
    When Insert "wpo19333@bcaoo.com" into "usernameBtn" Field (upd)
    When Insert "mektoube" into "passwordBtn" Field (upd)
    When Click "loginBtn"
    When Wait about 1 second

    When Click "Messages"
    Then The page show message with last content is "hello22" with "yassine_yes"

#
#  @TEST_QRA-100
#  Scenario: send a single emoji and send several emoji
#
#  @TEST_QRA-101
#  Scenario: to make line breaks on IOS / android

  @TEST_QRA-1009
  Scenario Outline: Check number of unread message with counter new message
    Given Go to "https://www.mektoube.fr" url
    When Login with account "<email>" and password "<password>"
    When Wait until element "a[href='/main/messages']" is visible
    When Click "a[href='/main/messages']"
    When Click see unread message and check number of message with blue counter
    When Logout current female account
    Examples:
      | email | password |
      | lantiu@gmail.com | mektoube** |
      | shainez29 | mektoube** |
      | yassine_yes2 | Mektoubi2017 |

















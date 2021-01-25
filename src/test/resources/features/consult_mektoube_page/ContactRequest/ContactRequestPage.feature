@QRA-58
Feature: Contact Request Page_ woman account

  @TEST_QRA-40
  #QA-230
  Scenario: Click on "en savoir plus"(Learn more)
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Click "CroisezVosDestins"
    When Click "LearnMore"
    Then The page shows popup


  @TEST_QRA-41
  #QA-231
  Scenario: Test that there is no duplicate invitations of "croisez mon destin"
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Click "CroisezVosDestins"
    When Scroll All page
    When Wait about 1 second
    Then The page dont show duplicate invitations


  @TEST_QRA-42
  #QA-232
  Scenario: See a green accept button and a white refuse button in each invitations to "croisez mon destin"
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Click "CroisezVosDestins"
    Then The page shows a green accept button and a white refuse button in each invitations


  @TEST_QRA-43
  #QA-233
  Scenario: Accept and answer now - page "Croisez mon destin"
    Given Go to "ResponsivePreprod" url

    When Create a woman account with email "mektoubitest@gmail.com" and username "samiracute"
    When Logout current account after created successful
    When Login with account "brandon92500" and password "Mektoubi2017"
    When Search woman account "samiracute" and send inspirational text
    When Should see message popup at top "C'est bien parti !"
    When Wait about 4 second
    When Log out current male account and login with woman account
    When Accept contact request of "brandon92500"
    When Should see message with "brandon92500" first except commercial message
    Then Should see message with same content of sent message


  #Chi wrote relate to this ticket
#  @TEST_QRA-44
#  #QA-234
#  Scenario: Accept and respond later - page "Croisez mon destin"
#    Given Go to "ResponsivePreprod" url
#
#    #??not yet clean session=>ok
#    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
#    When Wait about 1 second
#    When Click "CroisezVosDestins"
#    When Click "AcceptButton"
#    When Click on special element is "LaterAnswer"
#    Then Browser should redirect to url contain "/main/contact-requests"
#    And Scroll All page "reqContactUser"
#    #??=>ok
#    And The request-contact page dont show this person
#    And Click "Messages"
#    And Refresh page
#    And Scroll All page "messageItem"
#    #??=>ok
#    Then The message page have this person

  @TEST_QRA-324
  Scenario: Write contact request to woman - acceptation of woman - answer message later in "Croisez vos destins" screen

    When Create a woman account with email "mektoubitest@gmail.com" and username "samira_cute"
    When Logout current account after created successful
    When Login with account "brandon92500" and password "Mektoubi2017"
    When Search woman account "samira_cute" and contact request
    When Should see message popup at top "C'est bien parti !"
    When Wait about 4 second
    When Log out current male account and login with woman account
    When Accept contact request of "brandon92500" to answer later
    Then Should see unread message of "brandon92500" on Message screen
    When Click on user profile link and should see discuss and smile button
    When Do not see name of "brandon92500" on contact request list

    When Logout current female account

    When Login with account "brandon92500" and password "Mektoubi2017"
    When Should see woman name "samira_cute" on Cross Your Destinies screen
    When Wait until element "div[class='messages']" is visible
    And Browser should redirect to url contain "https://www.mektoube**.fr/main/messages/"
    When Should see woman name "samira_cute" on Message screen
    When Click on user profile link and should see discuss and smile button


  @TEST_QRA-45
  #QA-235
  Scenario: Accept and cancel - page "Croisez mon destin"
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Click "CroisezVosDestins"
    When Click "AcceptButton"
    When Click on special element is "CancelInLast5Refuse"
    Then Browser should redirect to url contain "/main/contact-requests"
    Then The request-contact page still shows this person


  @TEST_QRA-46
  #QA-236
  Scenario: Refuse - page "Croisez mon destin"
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Click "CroisezVosDestins"
    When Click on special element is "RefuseButton"
    Then Browser should redirect to url contain "/main/contact-requests"
    And Scroll All page "reqContactUser"
    And The request-contact page dont show this person
    And Click "Messages"
    And Refresh page
    And Scroll All page "messageItem"
    Then The message page dont have this person


  @TEST_QRA-47
    #QA-237
  Scenario: See the last 5 refusals - page "Croisez mon destin"
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Click "CroisezVosDestins"
    When Click on the element is "//span[text()='Refuser']" by xpath
    When Click on the element is "//span[text()='Refuser']" by xpath
    When Click "Last5Refusals"
    Then The page shows five last refusals profile


  @TEST_QRA-48
#      #QA-239
#  Scenario: Enter in the profile and accept and respond later
#    Given Go to "ResponsivePreprod" url
#
#       #??not yet clean session=>ok
#    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
#    When Wait about 1 second
#    When Click "CroisezVosDestins"
#    When Click on special element is "firstRequestName"
#    When Click "AcceptInProfile"
#         #maybe error if this person not yet input money or this person have description much long then cant find accept button
#    When Click "ResponLaterInProfile"
#        #????=>ok
#    Then The request-contact page dont show this person
#    And Click "Messages"
#    And The message page have this person
  @TEST_QRA-324
  Scenario: Write contact request to woman - acceptation of woman - answer message later in "Croisez vos destins" screen

    When Create a woman account with email "mektoubitest@gmail.com" and username "samiracute"
    When Logout current account after created successful
    When Login with account "brandon92500" and password "Mektoubi2017"
    When Search woman account "samiracute" and contact request
    When Should see message popup at top "C'est bien parti !"
    When Wait about 4 second
    When Log out current male account and login with woman account
    When Accept contact request of "brandon92500" to answer later
    Then Should see unread message of "brandon92500" on Message screen
    When Click on user profile link and should see discuss and smile button
    When Do not see name of "brandon92500" on contact request list

    When Logout current female account

    When Login with account "brandon92500" and password "Mektoubi2017"
    When Should see woman name "samiracute" on Cross Your Destinies screen
    When Wait until element "div[class='messages']" is visible
    And Browser should redirect to url contain "https://www.mektoube.fr/main/messages/"
    When Should see woman name "samira_cute" on Message screen
    When Click on user profile link and should see discuss and smile button


  @TEST_QRA-49
      #QA-240
  Scenario: Enter in the profile and accept and cancel
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Click "CroisezVosDestins"
    When Click on special element is "firstRequestName"
    When Click "AcceptInProfile"
    When Click "CancelInProfile"
    When Click "CroisezVosDestins"
    Then The request-contact page still shows this person

  @TEST_QRA-50
      #QA-247
#  Scenario: Enter in the profile and accept and answer now
#    Given Go to "ResponsivePreprod" url
#
#    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
#    When Wait about 1 second
#    When Click "CroisezVosDestins"
#    When Click "firstRequestName"
#    When Click "AcceptInProfile"
#    When Click "AnswerNowInProfile"
#    Then Browser should redirect to url contain "/main/messages/"

  @TEST_QRA-320
  Scenario: Write contact request to woman - acceptation of woman - click to see profile first and answer message right away

    When Create a woman account with email "mektoubitest@gmail.com" and username "samiracute"
    When Logout current account after created successful
    When Login with account "brandon92500" and password "Mektoubi2017"
    When Search woman account "samiracute" and contact request
    When Should see message popup at top "C'est bien parti !"
    When Wait about 4 second
    When Log out current male account and login with woman account
    When Click to see profile of the man who send contact request
    When Should see request contact message "hi, this is test greeting" below profile avatar
    When Click "AcceptRequest"
    When Click "AnswerRightAway"
    When Should see message with "brandon92500" first except commercial message
    When Click on user profile link and should see discuss and smile button
    When Do not see name of "brandon92500" on contact request list
    When Logout current female account
    When Login with account "brandon92500" and password "Mektoubi2017"
    When Should see woman name "samiracute" on Cross Your Destinies screen
    When Wait until element "div[class='messages']" is visible
    And Browser should redirect to url contain "https://www.mektoube**.fr/main/messages/"
    When Should see woman name "samira_cute" on Message screen
    When Click on user profile link and should see discuss and smile button


  @TEST_QRA-51
      #QA-241
  Scenario: Enter in the profile and refuse
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Click "CroisezVosDestins"
    When Click "firstRequestName"
    When Click on special element is "RefuseInProfile"
    Then The request-contact page dont show this person
    And Click "Messages"
    And Refresh page
    And Scroll All page "messageItem"
    Then The message page dont have this person

    #DONE
  @TEST_QRA-52
      #QA-242
  Scenario: Accept from the last 5 refusals and answer now
    Given Go to "ResponsivePreprod" url

    When Create a woman account with email "mektoubitest@gmail.com" and username "samiracute"
    When Logout current account after created successful
    When Login with account "brandon92500" and password "Mektoubi2017"
    When Search woman account "samiracute" and send inspirational text
    When Should see message popup at top "C'est bien parti !"
    When Wait about 4 second
    When Log out current male account and login with woman account
    When Refuse contact request of "brandon92500"
    When Refresh page
    When Accept contact request now of "brandon92500" in Refuse list
    When Should see message with "brandon92500" first except commercial message
    Then Should see message with same content of sent message


#??=>ok, ok_29_11
  @TEST_QRA-53
      #QA-243
  Scenario: Accept from the last 5 refusals and answer later
    Given Go to "ResponsivePreprod" url

    When Create a woman account with email "mektoubitest@gmail.com" and username "samiracute"
    When Logout current account after created successful
    When Login with account "brandon92500" and password "Mektoubi2017"
    When Search woman account "samiracute" and send inspirational text
    When Should see message popup at top "C'est bien parti !"
    When Wait about 4 second
    When Log out current male account and login with woman account
    When Refuse contact request of "brandon92500"
    When Refresh page
    When Accept contact request later of "brandon92500" in Refuse list
    When Click "closeRefuseList"
    When Click "message"
    When Should see message with "brandon92500" first except commercial message
    Then Should see message with same content of sent message



    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Click "CroisezVosDestins"
    When Click on the element is "//span[text()='Refuser']" by xpath
    When Click on the element is "//span[text()='Refuser']" by xpath
    #When Scroll All page
    When Click "Last5Refusals"
    When Click on special element is "AcceptInLast5Refusals"
    When Click "LaterAnswer"
    When Click "closeLast5Refuse"
     #???=>ok
    Then The last refusals list dont show this person
    And Click "Messages"
    #not yet=>ok scroll by robot framework
    And Scroll special element "message"
    And The message page have this person

#??=>ok,ok_29_11
  @TEST_QRA-54
      #QA-244
  Scenario: Accept from the last 5 refusals and cancel
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Click "CroisezVosDestins"
    When Click on the element is "//span[text()='Refuser']" by xpath
    When Click on the element is "//span[text()='Refuser']" by xpath
    When Wait about 1 second
    #When Scroll All page
    When Click "Last5Refusals"
    When Wait about 1 second
    When Click on special element is "AcceptInLast5Refusals"
    When Click "CancelInLast5Refuse"
    When Wait about 1 second
     ##???=>ok
    Then The last refusals list still show this person

    #okok
  @TEST_QRA-57
      #QA-859
  Scenario: Check that all invitations of "croisez son destin" are present
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Click "CroisezVosDestins"
    When Scroll All page "reqContactUser"
    #name is showed
    Then The page shows all invitations are present

  @TEST_QRA-55
  #QA-245
  Scenario: Pink dot in "Croisez vos destins" tab if there are requests
    Given Go to "ResponsivePreprod" url

#    When Click to link Se connecter
#    When Insert "Yassine_yes" into "username" Field (upd)
#    When Insert "Mektoubi2017" into "password" Field (upd)
#    When Click Login button
#    When Scroll All page "filterLeft"
#    When Click "RefineMySearch"
#    When Scroll All page "filterItem"
#    When Click "nickname"
#    When Insert "thuyyylinhhh89@gmail.com" into "nicknameTextfield" Field (upd)
#    When Click "checkButton"
#    When Scroll All page "profileItemDiscover"
#    When Click on the person have above name "thuyyylinhhh89@gmail.com"
#    When Click "disscussProfile"
#    When Insert "hello" into "fieldChat" Field (upd)
#    When Click "sendMessageButton"
#    When Click "MonCompteButton"
#    When Click "Reglages"
#    When Scroll All page "filter__item"
#    When Click "SignOut"
    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 3 second
    Then The Request Contact text have pink dot

  #test manual is oke but when auto then faild  ->ok
#  @TEST_QRA-56
#  #QA-246
#    # Precondition is QA-245 then continue check QA-246
#  Scenario: No pink dot in "Croisez vos destins" tab if there are not requests
#    Given Go to "ResponsivePreprod" url
#
#    When Login with account "Yassine_yes" and password "Mektoubi2017"
#    When Click "CroisezVosDestins"
#    When Wait about 1 second
#    When Click "discoveryScreenBt"
#    Then The Request Contact text dont have pink dot




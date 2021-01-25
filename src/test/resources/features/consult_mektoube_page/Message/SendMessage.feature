Feature: Send message

  Background:
    Given Go to "ResponsiveIntroduction.url" url

  @TEST_QRA-243
  Scenario: Send message - click on "Discussion"
    When Login with account "montassir93" and password "Mektoubi2017"
    When Search account "nesrine_by"
    When Select the profile has name "nesrine_by" that we are searching
    When Wait until element "Discuss" is visible
    When Click "Discuss"
    When Wait until element "div[class='messages']" is visible
    Then Browser should redirect to url contain "https://www.mektoube.fr/main/messages/"
    And Should see "nesrine_by" appear in log chat


  @TEST_QRA-329
  Scenario: Send message - Man subscriber, woman - OK

    When Create a woman account with email "mektoubitest@gmail.com" and username "samiracute"
    When Logout current account after created successful

    When Login with account "Yassine_yes2" and password "Mektoubi2017"
    When Search woman account "samiracute" and contact request
    When Should see message popup at top "C'est bien parti !"
    When Wait about 4 second
    When Log out current male account and login with woman account

    When Accept contact request of "yassine_yes2"
    When Should see message with "yassine_yes2" first except commercial message
    When Insert "hi, my name is Samira, this is test message" into Field "chatField"
    And Click "sendMessage"
    Then Should see message "hi, my name is Samira, this is test message" sent
    When Click on user profile link and should see discuss and smile button
    When Do not see name of "yassine_yes2" on contact request list
    When Logout current female account

    When Login with account "Yassine_yes2" and password "Mektoubi2017"
    When Should see woman name "samiracute" on Cross Your Destinies screen
    And Browser should redirect to url contain "https://www.mektoube.fr/main/messages/"
    When Should see woman name "samiracute" on Message screen
    When Insert "hi, my name is Yassine2, this is test message =)))" into Field "chatField"
    And Click "sendMessage"
    Then Should see message "hi, my name is Yassine2, this is test message =)))" sent
    When Click on user profile link and should see discuss and smile button
    When Click "Discuss"
    And Browser should redirect to url contain "https://www.mektoube.fr/main/messages/"
    When Insert "hi, my name is Yassine2, this is test message second time =)))" into Field "chatField"
    And Click "sendMessage"
    Then Should see message "hi, my name is Yassine2, this is test message second time =)))" sent


  @TEST_QRA-360
  Scenario: Send message - woman choose and send inspirational text

    When Create a woman account with email "mektoubitest@gmail.com" and username "samiracute"
    When Skip all questions in every registration form
    When Search account "yassine_yes2"
    When Select the profile has name "yassine_yes2" that we are searching
    When Check if inspirational text in Chat field can change when choose another one
    When Send inspirational text in Chat field and should see message is sent
    And There is no duplicate log chat
    When Logout current female account
    When Login with account "yassine_yes2" and password "Mektoubi2017"
    When Should see message contain insipration text of Woman
    When Insert "hi, my name is Yassine yes two, this is test message second time=)))" into Field "chatField"
    And  Click "sendMessage"
    Then Should see message "hi, my name is Yassine yes two, this is test message second time=)))" sent




  @TEST_QRA-960
  Scenario: Click on avatar in message screen - Should direct to Profile
    When Login with account "montassir93" and password "Mektoubi2017"
    When Search account "nesrine_by"
    When Select the profile has name "nesrine_by" that we are searching
    When Wait until element "Discuss" is visible
    When Click "Discuss"
    When Wait until element "div[class='messages']" is visible
    Then Browser should redirect to url contain "https://www.mektoube.fr/main/messages/"
    When Click on avatar on chat header
    Then Browser should redirect to url contain "https://www.mektoube.fr/main/profil/"
    When Wait until element "div[class='user__header'] i.material-icons" is visible
    When Click "div[class='user__header'] i.material-icons"
    When Click on avatar next to each chat message
    Then Browser should redirect to url contain "https://www.mektoube.fr/main/profil/"

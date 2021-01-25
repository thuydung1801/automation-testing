Feature: Contact Request Of Subscriber Man

  Background:
    Given Go to "ResponsiveIntroduction.url" url

  @TEST_QRA-355
  Scenario: See the explanation in the "write contact request modal" and click close

    When Login with account "montassir93" and password "Mektoubi2017"
    When Choose profile contain contact request button
    When Click "destinyBtn"
    Then Should see explanation in the message field
    When Wait until element "CancelDestinyMessage" is visible
    When Click "CancelDestinyMessage"
    Then The modal for write message is closing


  @TEST_QRA-241
  Scenario: write contact request modal: leave the field blank and click send

    When Login with account "montassir93" and password "Mektoubi2017"
    When Choose profile contain contact request button
    When Click "destinyBtn"
    When Wait until element "WriteContactRequestModal" is visible
    When Click "button[type='submit']"
    Then Should see message popup in line "Le contenu du message est requis."

  @TEST_QRA-247
  Scenario: Contact Request screen - click text link Learn more

    When Login with account "montassir93" and password "Mektoubi2017"
    When Wait until element "CrossYourDestiniesTextLink" is visible
    When Click "CrossYourDestiniesTextLink"
    When Wait until element "learnMore" is visible
    When Click "learnMore"
    Then Should see see there pages of explanation of the feature on the point of view of a man

  @TEST_QRA-352
  Scenario: Write contact request to woman - choose and send inspirational text

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

  @TEST_QRA-239
  Scenario: Write contact request to woman - send request message the first time and try to resend one another request

    When Create a woman account with email "mektoubitest@gmail.com" and username "samiracute"
    When Logout current account after created successful
    When Login with account "brandon92500" and password "Mektoubi2017"
    When Search woman account "samiracute" and contact request
    Then Should see message popup at top "C'est bien parti !"
    When Wait about 4 second
    Then Should see text on button change to "VOUS AVEZ SOUHAITÉ CROISER SON DESTIN"
    And Should see contact request is blocked


  @TEST_QRA-248
  Scenario: Write contact request to woman - acceptation of woman - answer message right away in "Croisez vos destins" screen

    When Create a woman account with email "mektoubitest@gmail.com" and username "samiracute"
    When Logout current account after created successful
    When Login with account "brandon92500" and password "Mektoubi2017"
    When Search woman account "samiracute" and contact request
    When Should see message popup at top "C'est bien parti !"
    When Wait about 4 second
    When Log out current male account and login with woman account
    When Accept contact request of "brandon92500"
    When Should see message with "brandon92500" first except commercial message
    When Click on user profile link and should see discuss and smile button
    When Do not see name of "brandon92500" on contact request list
    When Logout current female account

    When Login with account "brandon92500" and password "Mektoubi2017"
    When Should see woman name "samiracute" on Cross Your Destinies screen
    When Wait until element "div[class='messages']" is visible
    And Browser should redirect to url contain "https://www.mektoube.fr/main/messages/"
    When Should see woman name "samiracute" on Message screen
    When Click on user profile link and should see discuss and smile button


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
    And Browser should redirect to url contain "https://www.mektoube.fr/main/messages/"
    When Should see woman name "samiracute" on Message screen
    When Click on user profile link and should see discuss and smile button


  @TEST_QRA-321
  Scenario: Write contact request to woman - acceptation of woman - click profile on discoveries Screen first and answer message right away

    When Create a woman account with email "mektoubitest@gmail.com" and username "samiracute"
    When Logout current account after created successful
    When Login with account "brandon92500" and password "Mektoubi2017"
    When Search woman account "samiracute" and contact request
    When Should see message popup at top "C'est bien parti !"
    When Wait about 4 second
    When Log out current male account and login with woman account
    When Search account "brandon92500"
    When Select the profile has name "brandon92500" that we are searching
    When Wait until element "HeWantsToCrossYourDestiny" is visible
    When Click "HeWantsToCrossYourDestiny"
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
    And Browser should redirect to url contain "https://www.mektoube.fr/main/messages/"
    When Should see woman name "samiracute" on Message screen
    When Click on user profile link and should see discuss and smile button


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
    When Should see woman name "samiracute" on Message screen
    When Click on user profile link and should see discuss and smile button


  @TEST_QRA-325
  Scenario: Write contact request to woman - acceptation of woman - click to see profile first and answer message later

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
    When Click "AnswerLater"
    When Redirect to link "https://www.mektoube.fr/main/contact-requests"
    When Do not see name of "brandon92500" on contact request list
    Then Should see unread message of "brandon92500" on Message screen
    When Click on user profile link and should see discuss and smile button
    When Do not see name of "brandon92500" on contact request list

    When Logout current female account
    When Login with account "brandon92500" and password "Mektoubi2017"
    When Should see woman name "samiracute" on Cross Your Destinies screen
    When Wait until element "div[class='messages']" is visible
    And Browser should redirect to url contain "https://www.mektoube.fr/main/messages/"
    When Should see woman name "samiracute" on Message screen
    When Click on user profile link and should see discuss and smile button


  @TEST_QRA-326
  Scenario: Write contact request to woman - acceptation of woman - click profile on discoveries Screen first and answer message later

    When Create a woman account with email "mektoubitest@gmail.com" and username "samiracute"
    When Logout current account after created successful

    When Login with account "brandon92500" and password "Mektoubi2017"
    When Search woman account "samiracute" and contact request
    When Should see message popup at top "C'est bien parti !"
    When Wait about 4 second
    When Log out current male account and login with woman account

    When Search account "brandon92500"
    When Select the profile has name "brandon92500" that we are searching
    When Wait until element "HeWantsToCrossYourDestiny" is visible
    When Click "HeWantsToCrossYourDestiny"
    When Should see request contact message "hi, this is test greeting" below profile avatar
    When Click "AcceptRequest"
    When Click "AnswerLater"
    When Wait about 1 second
    When Redirect to link "https://www.mektoube.fr/main/discoveries"
    When Do not see name of "brandon92500" on contact request list
    Then Should see unread message of "brandon92500" on Message screen
    When Click on user profile link and should see discuss and smile button
    When Do not see name of "brandon92500" on contact request list

    When Logout current female account

    When Login with account "brandon92500" and password "Mektoubi2017"
    When Should see woman name "samiracute" on Cross Your Destinies screen
    When Wait until element "div[class='messages']" is visible
    And Browser should redirect to url contain "https://www.mektoube.fr/main/messages/"
    When Should see woman name "samiracute" on Message screen
    When Click on user profile link and should see discuss and smile button


  @TEST_QRA-351
  Scenario: Write contact request to woman - if woman already smile with man

    When Create a woman account with email "mektoubitest@gmail.com" and username "samiracute"
    When Logout current account after created successful
    When Login with account "brandon92500" and password "Mektoubi2017"
    When Deactive age filter and log out
    When Login with account "mektoubitest@gmail.com" and password "Mektoubi2017"
    When Smile with "brandon92500"
    When Logout current female account
    When Login with account "brandon92500" and password "Mektoubi2017"
    When Search account "samiracute"
    When Select the profile has name "samiracute" that we are searching
    When Click "Discuss"
    When Wait until element "div[class='messages']" is visible
    When Browser should redirect to url contain "https://www.mektoube.fr/main/messages/"
    When Should see woman name "samiracute" on Message screen
    When Insert "hi, my name is Brandon, this is test message =)))" into Field "chatField"
    And Click "sendMessage"
    When Should see message "hi, my name is Brandon, this is test message =)))" sent
    When Log out current male account and login with woman account
    Then Should see unread message of "brandon92500" on Message screen
    When Click on user profile link and should see discuss and smile button
    When Click "Discuss"
    When Browser should redirect to url contain "https://www.mektoube.fr/main/messages/"
    When Should see message with "brandon92500" first except commercial message


  @TEST_QRA-328
  Scenario: Write contact request to woman - refuse of woman in "Croisez vos destins" screen

    When Create a woman account with email "mektoubitest@gmail.com" and username "samiracute"
    When Logout current account after created successful
    When Login with account "brandon92500" and password "Mektoubi2017"
    When Search woman account "samiracute" and contact request
    When Should see message popup at top "C'est bien parti !"
    When Wait about 4 second
    When Log out current male account and login with woman account
    When Refuse contact request of "brandon92500"
    Then Do not see name of "brandon92500" on contact request list
    Then Do not see name of "brandon92500" on Message screen
    When Click "DiscoveriesScreenBtn"
    When Search account "brandon92500"
    When Select the profile has name "brandon92500" that we are searching
    When Should see discuss and smile button
    When Click "Discuss"
    When Wait until element "div[class='messages']" is visible
    When  Browser should redirect to url contain "https://www.mektoube.fr/main/messages/"
    When Should see message with "brandon92500" first except commercial message
    When Logout current female account
    When Login with account "brandon92500" and password "Mektoubi2017"
    When Search account "samiracute"
    When Select the profile has name "samiracute" that we are searching
    When Wait until element "button[class='mdc-button mdc-button--unelevated mdc-btn--pink']" is visible
    Then Should see text on button change to "VOUS AVEZ SOUHAITÉ CROISER SON DESTIN"
    And Should see contact request is blocked
    And Should not see woman name "samiracute" on Cross Your Destinies screen



    









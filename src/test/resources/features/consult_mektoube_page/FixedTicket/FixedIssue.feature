Feature: Fixed issue

  Background:
    Given Go to "https://www.mektoube.fr/" url

  @TEST_QRA-323
  Scenario: male account delete message with female account (after man send request contact and woman accept), click discuss on Croisez vos destins screen
    When Login with account "Yassine_yes" and password "Mektoubi2017"
    When Wait until element "CrossYourDestiniesTextLink" is visible
    When Click "CrossYourDestiniesTextLink"
    When Wait until element "div[class='request'] h5" is visible
    When Get profile mane on "theFirstWomanNameInContactRequestScreen"
    When Wait until element "DiscussInContactRequestScreenOfFirstWoman" is visible
    When Click "DiscussInContactRequestScreenOfFirstWoman"
    And Insert "hi, this is test message" into Field "chatField"
    And Click "sendMessage"
    And Insert "hi, this is test message" into Field "chatField"
    And Click "sendMessage"
    When Wait about 4 second
    When Click "DropDownOption"
    When Wait until element "DeleteConversation" is visible
    When Click "DeleteConversation"
    When Wait until element "ConfirmDelete" is visible
    When Click "ConfirmDelete"
    When Should see message popup at top "La conversation a été supprimée"
    When Wait about 4 second
    When Click "CrossYourDestiniesTextLink"
    When Click Discuss again with Woman that already delete message
    When Wait until element "div[class='messages']" is visible
    And Browser should redirect to url contain "https://www.mektoube.fr/main/messages/"
    When Wait until element "h1[class='name'] span" is visible
    Then Should see woman name that deleted message on Message screen

    #RES-925

  @TEST_QRA-631
  Scenario: Conversation already exist but Request Contact button doen't change to Discuss button (in case Woman refuse Contact request)
    When Create a woman account with email "mektoubitest@gmail.com" and username "samiracute"
    When Logout current account after created successful
    When Login with account "Yassine_yes" and password "Mektoubi2017"
    When Search woman account "samiracute" and contact request
    When Should see message popup at top "C'est bien parti !"
    When Wait about 4 second
    When Log out current male account and login with woman account
    When Refuse contact request of "yassine_yes"
    Then Do not see name of "yassine_yes" on contact request list
    Then Do not see name of "yassine_yes" on Message screen
    When Click "DiscoveriesScreenBtn"
    When Search account "yassine_yes"
    When Select the profile has name "yassine_yes" that we are searching
    When Should see discuss and smile button
    When Click "Discuss"
    When Wait until element "div[class='messages']" is visible
    When  Browser should redirect to url contain "https://www.mektoube.fr/main/messages/"
    When Should see message with "yassine_yes" first except commercial message
    And Insert "hi, this is test message" into Field "chatField"
    And Click "sendMessage"
    And Insert "hi, this is test message" into Field "chatField"
    And Click "sendMessage"
    When Wait about 4 second
    When Logout current female account
    When Login with account "Yassine_yes" and password "Mektoubi2017"
    When Search account "samiracute"
    When Select the profile has name "samiracute" that we are searching
    When Should see discuss and smile button
    When Should see woman name "samiracute" on Cross Your Destinies screen
    And Browser should redirect to url contain "https://www.mektoube.fr/main/messages/"
    When Should see woman name "samiracute" on Message screen

  @TEST_QRA-267
  Scenario: Start new conversation with account that already delete message

    When Login with account "lannt.woman@gmail.com" and password "mektoube**"
    When Wait until element "Messages" is visible
    When Click "Messages"
    When Delete message of "montassir93"
    When Should see message popup at top "La discussion a été supprimée"
    When Wait about 4 second
    When Click "DiscoveriesScreenBtn"
    When Search account "montassir93"
    When Select the profile has name "montassir93" that we are searching
    When Wait until element "Discuss" is visible
    When Click "Discuss"
    Then Should see message with "montassir93" first except commercial message
    And Insert "hi, this is test message" into Field "chatField"
    And Click "sendMessage"
    When Should see message "hi, this is test message" sent
    And Insert "hi, this is second test message" into Field "chatField"
    And Click "sendMessage"
    When Should see message "hi, this is second test message" sent

  @TEST_QRA-333
  Scenario: Don't close popup avatar, click go back, can scroll page like normal and click to profile => Avatar isn't already popup

    When Login with account "nesrine_by@yopmail.com" and password "Mektoubi2017"
    When Wait until element "ProfileContainAva" is visible
    When Click on "ProfileContainAva" which index is "0"
    When Wait until element "avaInProfileBtn" is visible
    When Click "avaInProfileBtn"
    When Wait until element "div[class='pictures-gallery modal is--opened']" is visible
    When go back
    When Wait about 4 second
    When Scroll to "ProfileContainAva" which index is "1" and click
    When Check if popup avatar is closed
    When Click "avaInProfileBtn"
    When Wait until element "div[class='pictures-gallery modal is--opened']" is visible


  @TEST_QRA-364
  Scenario: Search Filter - can save duplicate name

    When Login with account "Yassine_yes" and password "Mektoubi2017"
    When Wait until element "div[class='filter__item']" is visible
    When Scroll to element that has text "EnLigne" and click
    When Scroll to element that has text "//div[@class='filter__item']//*[contains(text(),'Profils récents')]" and click
    When Click "submitSearch"
    When Click "SaveSearchBtn"
    When Wait until element "div[class='save-filter modal is--opened']" is visible
    When Insert "automation saved search" into Field "SaveNameField"
    When Click "submitSearchName"
    When Should see message popup at top "Filtre ajouté"
    When Wait about 4 second
    When Click "SaveSearchBtn"
    When Wait until element "div[class='save-filter modal is--opened']" is visible
    When Clear text from field "SaveNameField"
    When Insert "automation saved search" into Field "SaveNameField"
    When Click "submitSearchName"
    When Should see message popup at top "Ce nom est déjà utilisé"
    When Wait about 4 second
    When Click "a.link-reset"
    When Click "div[class='list-toggle-wrap toggle-criteria-advance']"
#    When Click "RefineMySearch"
    When Click "AvecPhotoOption"
    When Click "OrigineOption"
    When Click "AlgerienneOption"
    When Click "ValidateBtn"
    When Click "FinishEditing"
    When Click "SaveSearchBtn"
    When Clear text from field "SaveNameField"
    When Insert "automation saved search" into Field "SaveNameField"
    When Click "submitSearchName"
    When Should see message popup at top "Ce nom est déjà utilisé"
    When Wait about 4 second
    When Click "RegisteredSearch"
    When Wait until element "div[class='list-toggle-wrap active toggle-list-search'] .filter__item" is visible
    Then Should see unique saved search name
    When Should see unique saved search name is "automation saved search"


  @TEST_QRA-362
  Scenario: Search Filter - Can not rename/ edit a Search

    When Login with account "Yassine_yes" and password "Mektoubi2017"
    When Wait until element "RegisteredSearch" is visible
    When Click "RegisteredSearch"
    When Edit saved search has name "automation saved search"
    Then Should see message popup at top "Filtre édité"
    When Wait about 4 second
    When Edit name of saved search has name "automation saved search" to "update name automation saved name"
    When Should see message popup at top "Filtre édité"
    When Wait about 4 second
    When Should see unique saved search name
    When Should see unique saved search name is "update name automation saved name"
    When Delete the search has name is "update name automation saved name"
    Then Should see message popup at top "Filtre supprimé"


  @TEST_QRA-632
  Scenario: Can't send message first time if click to next log chat and click back
    When Create a woman account with email "mektoubitest@gmail.com" and username "samiracute"
    When Skip all questions in every registration form
    When Send message to "brandon92500"
    When Click "DiscoveriesScreenBtn"
    When Search account "montassir93"
    When Select the profile has name "montassir93" that we are searching
    When Wait until element "Discuss" is visible
    When Click "Discuss"
    When CLick to next log chat and click back to log chat I was going to text
    When Insert "hi, my name is Yassine yes two, this is test message=)))" into Field "chatField"
    And  Click "sendMessage"
    Then Should see message "hi, my name is Yassine yes two, this is test message=)))" sent
    When Insert "hi, my name is Yassine yes two, this is test message second time=)))" into Field "chatField"
    And  Click "sendMessage"
    Then Should see message "hi, my name is Yassine yes two, this is test message second time=)))" sent

  @TEST_QRA-781
  Scenario: Message >>> Don't display enough message of non - subscriber man
    When Login with account "montassir931" and password "Mektoubi2017"
    When Wait until element "Messages" is visible
    When Click "Messages"
    Then Should see enough unread message

  @TEST_QRA-824
  Scenario: Contact Request >>> Wrong displaying of "Red mark" for new contact requests
    When Login with account "shainez29" and password "mektoube"
    Then Check if indicator display right for new contact request

  @TEST_QRA-957
  Scenario: Fix wrong content in meta tag
    When Login with account "montassir931" and password "Mektoubi2017"
    Then Should see meta tag "Mektoube.fr – Site N°1 de la rencontre Musulmane et Maghrébine"

  @TEST_QRA-964
  Scenario: Can auto login when click deeplink
    When Login with account "brandon92500" and password "Mektoubi2017"
    When Go to "https://www.google.com/" url
    When Wait about 2 second
    When Go to "https://www.mektoube.fr/deeplink/d4afaa3ad2274b7ac8616cb0c22b7acf/76ed5f7e349e00479f5ed900b7388bb8/list/2" url
    When Browser should redirect to "https://www.mektoube.fr/main/notifications"
    When Should see profile of account "Phuong_chi97"
    When Should see all notifications and messages of account PhuongChi

Feature: Voice message

  @TEST_QRA-988
  Scenario: Click voice button when the page has not been granted microphone access
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "lantiu@gmail.com" and password "Lantiu4998@"
    When Search account "criskhoa"
    When Select the profile has name "criskhoa" that we are searching
    When Click "Discuss"
    When Wait until element "a.btn-send-text-wrapper" is visible
    When Click "a.btn-send-text-wrapper"
    When Click "a.btn-send-text-wrapper"
    Then Warning box with content "Vous avez bloquer le micro. Pour pouvoir utiliser les messages vocaux merci d’autoriser l’utilisation du micro dans les paramètres de votre navigateur." is displayed

  @TEST_QRA-989
  Scenario: Don't send a voice message with length is 00:00
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "lantiu@gmail.com" and password "Lantiu4998@"
    When Allowing location access
    When Search account "criskhoa"
    When Select the profile has name "criskhoa" that we are searching
    When Click "Discuss"
    When Wait until element "a.btn-send-text-wrapper" is visible
    When Click "a.btn-send-text-wrapper"
    When Wait about 2 second
    When Allowing micro access
    When Wait until element "button.btn-send-text-wrapper" is visible
    When Click "button.btn-send-text-wrapper"
    Then Wait until element "div.voice-warning-box" is visible
    Then Warning box with content "Les messages vocaux de moins d’une seconde ne sont pas envoyés" is displayed

  @TEST_QRA-990
  Scenario: Man doesn't have any photo - send a voice message to woman who turn on photo filter
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "lantiu@gmail.com" and password "Lantiu4998@"
    When Wait until element "MyProfileBtn" is visible
    When Click "MyProfileBtn"
    When Wait until element "settingBtn" is visible
    When Click "settingBtn"
    When Wait until element ".list-settings" is visible
    When Active photo filter button
    When Make sure Blacklist do not contain account "yassine_yes2" we will going to be searching
    When Logout current female account
    When Login with account "yassine_yes2" and password "Mektoubi2017"
    When Search account "Lantiu"
    When Select the profile has name "Lantiu" that we are searching
    When Click "Discuss"
    When Wait until element "a.btn-send-text-wrapper" is visible
    When Click "a.btn-send-text-wrapper"
    Then The page show pop up request post at least a picture

  @TEST_QRA-992
  Scenario: Cancel/Send a voice message
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "lantiu@gmail.com" and password "Lantiu4998@"
    When Allowing location access
    When Search account "criskhoa"
    When Select the profile has name "criskhoa" that we are searching
    When Click "Discuss"
    When Wait until element "a.btn-send-text-wrapper" is visible
    When Click "a.btn-send-text-wrapper"
    When Wait about 3 second
    When Allowing micro access
    When Choose cancel record
    Then Wait until element "a.btn-send-text-wrapper" is visible
    When Click "a.btn-send-text-wrapper"
    When Record random seconds
    Then Check time in counter and sent voice message length
    And Sending time and realtime

  @TEST_QRA-993
  Scenario: Display last sent voice message in thread chat list
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "lantiu@gmail.com" and password "Lantiu4998@"
    When Allowing location access
    When Make sure Blacklist do not contain account "montassir931" we will going to be searching
    When Search account "montassir931"
    When Select the profile has name "montassir931" that we are searching
    When Click "Discuss"
    When Wait until element "a.btn-send-text-wrapper" is visible
    When Click "a.btn-send-text-wrapper"
    When Wait about 2 second
    When Allowing micro access
    When Record random seconds
    When Wait until element "button.btn-send-text-wrapper" is visible
    When Click "button.btn-send-text-wrapper"
    Then Check voice message display in thread chat list
    When Logout current female account
    When Login with account "Montassir931" and password "Mektoubi2017"
    When Wait until element "a[href='/main/messages']" is visible
    When Click "a[href='/main/messages']"
    When Wait about 2 second
    When Click "div[style='position: relative;']>div:nth-child(1)"
    Then Check voice message display in thread chat list

  @TEST_QRA-994
  Scenario: Check popup messages when report a voice message
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "Yassine_yes" and password "Mektoubi2017"
    When Make sure Blacklist do not contain account "Lantiu" we will going to be searching
    When Search account "Lantiu"
    When Select the profile has name "Lantiu" that we are searching
    When Click "Discuss"
    When Wait until element "a.btn-send-text-wrapper" is visible
    When Click "a.btn-send-text-wrapper"
    When Wait about 3 second
    When Allowing micro access
    When Record random seconds
    When Click "button.btn-send-text-wrapper"
    Then Sending time and realtime
    When Logout current female account
    When Login with account "Lantiu@gmail.com" and password "Lantiu4998@"
    When Wait until element "a[href='/main/messages']" is visible
    When Click "a[href='/main/messages']"
    When Wait about 2 second
    When Click "div[style='position: relative;']>div:nth-child(1)"
    When Report a voice message should see popup message

  @TEST_QRA-995
  Scenario: Cancel record when go to other thread, open new tab, run in background
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "lantiu@gmail.com" and password "Lantiu4998@"
    When Wait about 2 second
    When Allowing location access
    When Make sure Blacklist do not contain account "yassine_yes" we will going to be searching
    When Search account "yassine_yes" and go to thread chat detail
    When Wait until element "a.btn-send-text-wrapper" is visible
    When Click "a.btn-send-text-wrapper"
    When Wait about 2 second
    When Allowing micro access
    Then Check record end when go to other thread and comeback
    Then Check record end when open new browser tab
    Then Check record end when run in background

  @TEST_QRA-998
  Scenario: Request confirm mail before send voice message
    Given Go to "ResponsiveIntroduction.url" url
    When Create a woman account with email "mektoubitest@gmail.com" and username "samiracute"
    When Logout current account after created successful
    When Login with account "montassir931" and password "Mektoubi2017"
    When Wait about 2 second
    When Search woman account "samiracute" and contact request
    When Should see message popup at top "C'est bien parti !"
    When Wait about 4 second
    When Logout current female account
    When Login with account "mektoubitest@gmail.com" and password "Mektoubi2017"
    When Accept contact request of "montassir931"
    When Should see message with "montassir931" first except commercial message
    When Wait until element "a.btn-send-text-wrapper" is visible
    When Click "a.btn-send-text-wrapper"
    Then Wait until element "div.email-validation-popup:nth-child(2)" is visible
    When Click "a.closer.right-side"
    When Click "a.btn-send-text-wrapper"
    When Click "a.btn-send-text-wrapper"
    Then Wait until element "div.voice-warning-box" is visible

  @TEST_QRA-999
  Scenario: Voice button is disable when block user (both sender and receive)
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "lantiu@gmail.com" and password "Lantiu4998@"
    When Make sure Blacklist do not contain account "yassine_yes" we will going to be searching
    When Search account "yassine_yes"
    When Select the profile has name "yassine_yes" that we are searching
    When Click "Discuss"
    When Wait until element "a.btn-send-text-wrapper" is visible
    When Click "a.btn-send-text-wrapper"
    When Wait about 3 second
    When Allowing micro access
    When Record random seconds
    When Click "button.btn-send-text-wrapper"
    Then Sending time and realtime
    When Click "metarialInConversation"
    When Click "blockInConversation"
    When Wait about 2 second
    When Click "a.btn-send-text-wrapper"
    Then Warning box with content "Vous ne pouvez plus utiliser cette fonctionnalité" is displayed
    And Should see message popup "Vous avez bloqué cette personne"
    When Logout current female account
    When Login with account "yassine_yes" and password "Mektoubi2017"
    When Make sure Blacklist do not contain account "lantiu" we will going to be searching
    When Wait until element "a[href='/main/messages']" is visible
    When Click "a[href='/main/messages']"
    When Wait about 2 second
    When Click "div[style='position: relative;']>div:nth-child(1)"
    When Wait until element "a.btn-send-text-wrapper" is visible
    When Click "a.btn-send-text-wrapper"
    Then Should see message popup "Vous ne pouvez pas écrire à Lantiu"

  @TEST_QRA-1000
  Scenario: Disable send voice button for both Man and Woman when try to send first message
    Given Go to "ResponsiveIntroduction.url" url
    When Create a woman account with email "mektoubitest@gmail.com" and username "samiracute"
    When Skip all questions in every registration form
    When Search account "yassine_yes"
    When Select the profile has name "yassine_yes" that we are searching
    When Click "smileBtn"
    Then The page show green notification is "Smile envoyé" at "topHeaderMessage"
    When Click "Discuss"
    When Wait until element "a.disabled.btn-send-text-wrapper" is visible
    When Click "a.btn-send-text-wrapper"
    Then Warning box with content "Vous ne pouvez plus utiliser cette fonctionnalité" is displayed
    When Wait about 3 second
    When Logout current female account
    When Login with account "Yassine_yes" and password "Mektoubi2017"
    When Wait until element "NotificationTextLink" is visible
    When Click "NotificationTextLink"
    When Click message button in first notification in noti page
    When Wait about 3 second
    When Wait until element "a.disabled.btn-send-text-wrapper" is visible
    When Click "a.btn-send-text-wrapper"
    Then Warning box with content "Vous ne pouvez plus utiliser cette fonctionnalité" is displayed

  @TEST_QRA-986
  Scenario: When someone reports a voice msg >> give the possibility to block the user
    Given Go to "ResponsiveIntroduction.url" url

    When Login with account "linhlinhttt98@gmail.com" and password "mektoube"
    When Search account "yassine_yes2"
    When Select the profile has name "yassine_yes2" that we are searching
    When Wait until element "Discuss" is visible
    When Click "Discuss"
    When Wait until element "div[class='messages']" is visible
    When Wait about 5 second
    When Click "voiceIcon"
    When Wait about 3 second
    When Allow to use microphone
    When Wait about 8 second
    When Click "sendMessage"
    When Wait about 5 second
    When Click "SignOutIcon"
    When Click "SeConnecter"
    When Insert "yassine_yes2" into "usernameBtn" Field (upd)
    When Insert "Mektoubi2017" into "passwordBtn" Field (upd)
    When Click "loginBtn"
    When Wait about 2 second
    When Search account "linh"
    When Select the profile has name "linh" that we are searching
    When Wait until element "Discuss" is visible
    When Click "Discuss"
    When Wait until element "div[class='messages']" is visible
    When Click "lastMessageOption"
    When Wait about 1 second
    When Click "reportOption"
    When Wait about 2 second
    Then The page show pop up voice report confirm
    And Click "validateReportVoiceButton"
    #red notification
    Then The page show green notification is "Votre signalement sur le message vocal a bien été pris en compte" at "topHeaderMessage"


  @TEST_QRA-987
  Scenario: When someone reports and block person in voice message
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "linhlinhttt98@gmail.com" and password "mektoube"
    When Search account "yassine_yes2"
    When Select the profile has name "yassine_yes2" that we are searching
    When Wait until element "Discuss" is visible
    When Click "Discuss"
    When Wait until element "div[class='messages']" is visible
    When Wait about 5 second
    When Click "voiceIcon"
    When Wait about 3 second
    When Allow to use microphone
    When Wait about 8 second
    When Click "sendMessage"
    When Wait about 2 second
    When Click "SignOutIcon"
    When Click "SeConnecter"
    When Insert "yassine_yes2" into "usernameBtn" Field (upd)
    When Insert "Mektoubi2017" into "passwordBtn" Field (upd)
    When Click "loginBtn"
    When Wait about 2 second
    When Search account "linh"
    When Select the profile has name "linh" that we are searching
    When Wait until element "Discuss" is visible
    When Click "Discuss"
    When Wait until element "div[class='messages']" is visible
    When Click "lastMessageOption"
    When Wait about 1 second
    When Click "reportOption"
    Then The page show pop up voice report confirm
    And Click "blockCheckbox"
    And Click "validateReportVoiceButton"
    #red notification
    Then The page show green notification is "Votre signalement a été pris en compte et la personne a été bloquée" at "topHeaderMessage"

  @TEST_QRA-
    #click on playing voice message => slider running


    #RES-1599,??
#  @TEST_QRA-
#  Scenario: Dont allow more 1 voice message playing togerther
#    Given Go to "ResponsivePreprod" url
#
#    When Login with account "linhlinhttt98@gmail.com" and password "mektoube"
#    When Search account "yassine_yes2"
#    When Select the profile has name "yassine_yes2" that we are searching
#    When Wait until element "Discuss" is visible
#    When Click "Discuss"
#    When Wait until element "div[class='messages']" is visible
#    When Wait about 5 second
#    When Click "voiceIcon"
#    When Wait about 3 second
#    When Allow to use microphone
#    When Wait about 8 second
#    When Click "sendMessage"
#    When Click "voiceIcon"
#    When Wait about 8 second
#    When Click "sendMessage"
#    When Wait about 3 second
#    When Click "playingLastVoiceMessage"
#    #solution: none yet
#    When Click on last message -1
#    Then The last message -1 is being playing and last message is stopped


#RES-1599
  @TEST_QRA-991
  Scenario: should end voice message that playing when click voice icon
    Given Go to "ResponsiveIntroduction.url" url

    When Login with account "linhlinhttt98@gmail.com" and password "mektoube"
    When Search account "yassine_yes2"
    When Select the profile has name "yassine_yes2" that we are searching
    When Wait until element "Discuss" is visible
    When Click "Discuss"
    When Wait until element "voiceIcon" is visible
    When Wait about 5 second
    When Click "voiceIcon"
    When Wait about 3 second
    When Allow to use microphone
    When Wait about 10 second
    When Click "sendMessage"
    #case1:
    When Click "voiceIcon"
    When Click "playingLastVoiceMessage"
    Then The last voice message is not allowed playing
    And The voice message still recording
    #case2:
    When Refresh page
    When Click "playingLastVoiceMessage"
    When Click "voiceIcon"
    Then The last voice message is not allowed playing
    And The voice message still recording
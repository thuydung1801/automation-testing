@QRA-39
Feature: Action when visit a profile

  Background:
    Given Go to "ResponsiveIntroduction.url" url

  @TEST_QRA-30
  Scenario: Smile with a female user (who don't active filter)

    When Login with account "qa+noor97@mektoube.fr" and password "mektoube**"
    When Deactive age filter and log out
    When Login with account "brandon92500" and password "Mektoubi2017"
    When Make sure Blacklist do not contain account "noor97" we will going to be searching
    When Search account "noor97"
    When Select the profile has name "noor97" that we are searching
    When Wait until element "smileBtn" is visible
    When Click "smileBtn"
    Then Should see message popup at top "Smile envoyé"
    When Wait about 4 second
    When Click "smileBtn"
    Then Should see message popup at top "Personne déjà smilée"

  @TEST_QRA-419
  Scenario: Smile with a female user (who active filter)

    When Login with account "qa+noor97@mektoube.fr" and password "mektoube**"
    When Active age filter from "18" to "20" and log out
    When Wait about 3 second
    When Login with account "brandon92500" and password "Mektoubi2017"
    When Make sure Blacklist do not contain account "noor97" we will going to be searching
    When Search account "noor97"
    When Select the profile has name "noor97" that we are searching
    When Wait until element "smileBtn" is visible
    When Click "smileBtn"
    Then Should see message popup at top "Smile envoyé"
    When Wait about 4 second
    When Click "smileBtn"
    Then Should see message popup at top "Smile envoyé"
    When Wait about 4 second
    When Click "smileBtn"
    Then Should see message popup at top "Smile envoyé"
    When Wait about 4 second
    When Click "smileBtn"
    Then Should see message popup at top "Smile envoyé"


  @TEST_QRA-104
  Scenario: Smile with a male user (who don't active filter)

    When Login with account "montassir93" and password "Mektoubi2017"
    When Deactive age filter and log out
    When Login with account "qa+noor97@mektoube.fr" and password "mektoube**"
    When Make sure Blacklist do not contain account "noor97" we will going to be searching
    When Search account "montassir93"
    When Select the profile has name "montassir93" that we are searching
    When Wait until element "smileBtn" is visible
    When Click "smileBtn"
    Then Should see message popup at top "Smile envoyé"
    When Wait about 4 second
    When Click "smileBtn"
    Then Should see message popup at top "Personne déjà smilée"


  @TEST_QRA-420
  Scenario: Smile with a male user (who active filter)

    When Login with account "montassir93" and password "Mektoubi2017"
    When Active age filter from "18" to "21" and log out
    When Login with account "qa+noor97@mektoube.fr" and password "mektoube**"
    When Make sure Blacklist do not contain account "noor97" we will going to be searching
    When Search account "montassir93"
    When Select the profile has name "montassir93" that we are searching
    When Wait until element "smileBtn" is visible
    When Click "smileBtn"
    Then Should see message popup at top "Smile envoyé"
    When Wait about 4 second
    When Click "smileBtn"
    Then Should see message popup at top "Smile envoyé"
    When Wait about 4 second
    When Click "smileBtn"
    Then Should see message popup at top "Smile envoyé"
    When Wait about 4 second
    When Click "smileBtn"
    Then Should see message popup at top "Smile envoyé"

  @TEST_QRA-34
  Scenario: click on a female profile in profile similar and view complete profile

    When Login with account "montassir93" and password "Mektoubi2017"
    When Wait until element "Profile" is visible
    When Click on "Profile" which index is "0"
    When Choose a similar profile
    Then Should see complete profile


  @TEST_QRA-107
  Scenario: click on a male profile in profile similar and view complete profile

    When Login with account "shainez29" and password "mektoube**"
    When Wait until element "Profile" is visible
    When Click on "Profile" which index is "0"
    When Choose a similar profile
    Then Should see complete profile

  @TEST_QRA-35

  Scenario: see photo of a female profile similar

    When Login with account "montassir931" and password "Mektoubi2017"
    When Wait until element "ProfileContainAva" is visible
    When Click on "ProfileContainAva" which index is "0"
    When Wait about 2 second
    When choose a profile similar that contain avatar
    When Wait until element "AvatarInProfile" is visible
    When Click "AvatarInProfile"
    Then Avatar picture is popup
    When Click "closePopUpAva"
    When Check if popup avatar is closed

  @TEST_QRA-108
  Scenario: see photo of a male profile similar

    When Login with account "shainez29" and password "mektoube**"
    When Wait until element "ProfileContainAva" is visible
    When Click on "ProfileContainAva" which index is "0"
    When Wait about 2 second
    When choose a profile similar that contain avatar
    When Wait until element "AvatarInProfile" is visible
    When Click "AvatarInProfile"
    When Avatar picture is popup
    When Click "closePopUpAva"
    When Check if popup avatar is closed

  @TEST_QRA-36

  Scenario: Close the popup of a profile's photos

    When Login with account "montassir931" and password "Mektoubi2017"
    When Wait until element "ProfileContainAva" is visible
    When Click on "ProfileContainAva" which index is "0"
    When Click "AvatarInProfile"
    When Avatar picture is popup
    When Wait until element "closePopUpAva" is visible
    Then Click "closePopUpAva"
    When Check if popup avatar is closed

  @TEST_QRA-227
  Scenario: report a profile - "Block this person" must be checked by default

    When Login with account "brandon92500" and password "Mektoubi2017"
    When Wait until element "Profile" is visible
    When Click on "Profile" which index is "0"
    When Select report abuse button
    Then Check if block button is checked by default


  @TEST_QRA-37

  Scenario: report a profile - validate without select

    When Login with account "montassir93" and password "Mektoubi2017"
    When Make sure Blacklist do not contain account "noor97" we will going to be searching
    When Search account "noor97"
    When Select the profile has name "noor97" that we are searching
    When Select report abuse button
    When Click "button[class='mdc-button mdc-button--unelevated full-wrap-width']"
    Then Wait until element "div[class='radio-group-field checkbox-space-between border-style error']" is visible

  @TEST_QRA-38
  Scenario: add a female profile to his favorites

    When Login with account "brandon92500" and password "Mektoubi2017"
    When Make sure Blacklist do not contain account "Emna98" we will going to be searching
    When Search account "Emna98"
    Then Add a woman to favorite and should see that woman account display in favorite
    When Delete "Emna98" from favorites list


  @TEST_QRA-109
  Scenario: see the connection status / last connection
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "montassir931" and password "Mektoubi2017"
    When Wait until element "Profile" is visible
    When Click on "Profile" which index is "0"
    Then Check the connection status


  @TEST_QRA-112
  Scenario: report a profile - choose 1 report reason and block the profile - should see green message, account blocked in Blacklist (premium man account)

    When Login with account "brandon92500" and password "Mektoubi2017"
    When Make sure Blacklist do not contain account "noor97" we will going to be searching
    When Search account "noor97"
    When Select the profile has name "noor97" that we are searching
    When Get profile name
    When Report and block a profile
    Then Should see message popup at top "L'abus a été signalé"
    When Wait about 4 second
    Then Should see blocked account in Blacklist and remove it
    When Should see message popup at top "Personne débloquée"


  @TEST_QRA-115
  Scenario: report a profile without block

    When Login with account "brandon92500" and password "Mektoubi2017"
    When Make sure Blacklist do not contain account "Emna98" we will going to be searching
    When Search account "Emna98"
    When Select the profile has name "Emna98" that we are searching
    When Select report abuse button
    When Click Block button to remove select
    When Click on radio button that has text "Injure"
    When Click "button[class='mdc-button mdc-button--unelevated full-wrap-width']"
    When Insert "this is test report message" into Field "textarea[placeholder='Merci de donner des précisions sur le signalement']"
    When Click "button[class='mdc-button mdc-button--unelevated full-wrap-width']"
    Then Should see message popup at top "L'abus a été signalé"
    When Wait about 4 second
    And Should not see account "Emna98" in blacklist


  @TEST_QRA-116

  Scenario: block a profile - buttons "smile"/"discuss"/"croiser son destin" disappear

    When Login with account "brandon92500" and password "Mektoubi2017"
    When Make sure Blacklist do not contain account "Emna98" we will going to be searching
    When Search account "Emna98"
    When Select the profile has name "Emna98" that we are searching
    When Select block this person
    When Should see message popup at top "Le blocage est confirmé"
    When Wait about 4 second
    Then Cannot see letter button
    And Cannot see smile button
    And Cannot see discuss button
    And Cannot see advice to discuss button
    When Click "MyProfileBtn"
    When Wait until element "settingBtn" is visible
    When Click "settingBtn"
    When Click on BlackList
    When Remove account from black list
    When Should see message popup at top "Personne débloquée"


  @TEST_QRA-117

  Scenario: block a profile - see that account in blackList

    When Login with account "brandon92500" and password "Mektoubi2017"
    When Wait until element "Profile" is visible
    When Click on "Profile" which index is "0"
    When Get profile name
    When Select block this person
    When Should see message popup at top "Le blocage est confirmé"
    When Wait about 4 second
    When Click "MyProfileBtn"
    When Wait until element "settingBtn" is visible
    When Click "settingBtn"
    When Click on BlackList
    Then Should see Block account
    When Remove account from black list
    When Should see message popup at top "Personne débloquée"

  @TEST_QRA-119

  Scenario: block a profile - cannot search by name (girl block man)

    When Login with account "shainez29" and password "mektoube**"
    When Make sure Blacklist do not contain account "montassir93" we will going to be searching
    When Search account "montassir93"
    When Select the profile has name "montassir93" that we are searching
    When Select block this person
    When Should see message popup at top "Le blocage est confirmé"
    When Wait about 4 second
    When Click "DiscoveriesScreenBtn"
    When Refresh curent page
    When CLick filter by username
    When Clear text from field "SearchUserNameField"
    When Insert "montassir93" into Field "SearchUserNameField"
    When Get profile name from "SearchUserNameField"
    When Click "ValidateBtn"
    When Wait until element "submitFilter" is visible
    When Click "submitFilter"
    When Wait about 4 second
    Then Should not show this blocked account
    When Delete blocked account from blacklist
    When Should see message popup at top "Personne débloquée"

  @TEST_QRA-121
  Scenario: Unblock a female profile - should see button discuss, smile, destiny again (man unblock woman)

    When Login with account "brandon92500" and password "Mektoubi2017"
    When Make sure Blacklist do not contain account "Emna98" we will going to be searching
    When Search account "Emna98"
    When Select the profile has name "Emna98" that we are searching
    When Select block this person
    When Should see message popup at top "Le blocage est confirmé"
    When Wait about 4 second
    When Delete blocked account from blacklist
    When Should see message popup at top "Personne débloquée"
    When Wait about 4 second
    When Click "closeBlackList"
    When Wait until element "DiscoveriesScreenBtn" is visible
    When Click "DiscoveriesScreenBtn"
    When Search account "Emna98"
    When Select the profile has name "Emna98" that we are searching
    Then should see button smile, discuss or destiny again

  @TEST_QRA-122
  Scenario: Unblock a male profile - should see button discuss, smile, destiny again (woman unblock man)

    When Login with account "shainez29" and password "mektoube**"
    When Make sure Blacklist do not contain account "brandon92500" we will going to be searching
    When Search account "brandon92500"
    When Select the profile has name "brandon92500" that we are searching
    When Select block this person
    When Should see message popup at top "Le blocage est confirmé"
    When Wait about 4 second
    When Delete blocked account from blacklist
    When Should see message popup at top "Personne débloquée"
    When Wait about 4 second
    When Click "closeBlackList"
    When Wait until element "DiscoveriesScreenBtn" is visible
    When Click "DiscoveriesScreenBtn"
    When Search account "brandon92500"
    When Select the profile has name "brandon92500" that we are searching
    Then should see button smile, discuss or destiny again in male profile

#  @TEST_QRA-421
#  Scenario: visited a profile - click on the return arrow on the top left
#
#    When Login with account "montassir931" and password "Mektoubi2017"
#    When Wait until element "Profile" is visible
#    When Click on "Profile" which index is "0"
#    When Click "returnArrowInProfile"
#    Then Browser should redirect to "https://www.mektoube.fr/main/discoveries"
#
#
#  @TEST_QRA-275
#  Scenario: Click narrow to see next and previous profile : profile names is sorted correctly
#
#    When Login with account "shainez29" and password "mektoube"
#    When Wait until element "Profile" is visible
#    When Click on "Profile" which index is "0"
#    Then View twenty profile and profile names is sorted correctly
#
#  @TEST_QRA-282
#  Scenario: Click narrow to see next and previous profile : see complete profile
#
#    When Login with account "shainez29" and password "mektoube"
#    When Wait until element "Profile" is visible
#    When Click on "Profile" which index is "0"
#    Then Can view twenty complete profile



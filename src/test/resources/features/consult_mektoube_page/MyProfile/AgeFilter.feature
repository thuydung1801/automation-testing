Feature: Age filter

  Background:
    Given Go to "https://www.mektoube.fr/" url
  @TEST_QRA-423
  Scenario: Men send contact request to woman - Woman active age filter then deactive it
   # Step 1: create new woman account

    When Make sure age filter of man account "montassir93" still remain turn off
    When Create a woman account with email "mektoubitest@gmail.com" and username "samiracute"
    # Step 2: Check number of visit, smile notification before active age filter
    When Skip all questions in every registration form
    When Check number of visit, smile notification
   # Step 3 : Active age filter
    When Active age filter from "18" to "21"
    When Wait about 4 second
    When Click "DiscoveriesScreenBtn"
    When Search account "montassir93"
    When Select the profile has name "montassir93" that we are searching
    When Check if content of alert text about age filter is correct
    When Logout current female account
#  Step 4: login by man account, send contact request
    When Login with account "montassir93" and password "Mektoubi2017"
    When Send smile and contact request to "samiracute" when age filter is active
    When Log out current male account and login with woman account
# Step 5: log in by woman account, and check notification
    Then Should not see smile, visit notification of "montassir93"
    And Should not see contact request notification of "montassir93"
    When Wait about 2 second
# Step 6: deactive age filter
    When Deactive age filter
    When Wait about 4 second
    When Click "DiscoveriesScreenBtn"
    When Search account "montassir93"
    When Select the profile has name "montassir93" that we are searching
    When Check if content of alert text about age filter is already disapear
    When Logout current female account
# Step 7: login by man account and send contact request again
    When Login with account "montassir93" and password "Mektoubi2017"
    When Send smile and contact request to "samiracute" when age filter is deactive
    When Log out current male account and login with woman account
# Step 8: login woman account and accept contact request
    When Should see smile, visit notification of "montassir93"
    When Accept contact request of "montassir93"
    When Should see message with "montassir93" first except commercial message
    When Click on user profile link and should see discuss and smile button
    When Do not see name of "montassir93" on contact request list
    When Logout current female account
#Step 9: Log in by man account and check process after woman accept contact request
    When Login with account "montassir93" and password "Mektoubi2017"
    When Should see woman name "samiracute" on Cross Your Destinies screen
    When Wait about 2 second
    And Browser should redirect to url contain "https://www.mektoube.fr/main/messages/"
    When Wait about 2 second
    When Should see woman name "samiracute" on Message screen
    When Click on user profile link and should see discuss and smile button


  @TEST_QRA-424

  Scenario: Woman send message to man - Men active age filter then deactive it

    When Create a woman account with email "mektoubitest@gmail.com" and username "samiracute"
    When Logout current account after created successful
#login man account
    When Login with account "montassir93" and password "Mektoubi2017"
#    check number of notification
    When Check number of visit, smile notification
    When Check number of messages
#    active age filter
    When Active age filter from "35" to "40"
    When Wait about 4 second
#    check text of age filter alarm on woman profile
    When Click "DiscoveriesScreenBtn"
    When Search account "samiracute"
    When Select the profile has name "samiracute" that we are searching
    When Check if content of alert text about age filter is correct
    # login woman accout
    When Log out current male account and login with woman account
    When Send message and smile to "montassir93" when age filter is active
    When Refresh curent page
    When Should see message with "montassir93"
    When Logout current female account
# Login by men account
    When Login with account "montassir93" and password "Mektoubi2017"
    Then Should not see smile, visit notification of "samiracute"
    And Should not see message of "samiracute"
# Step 6: deactive age filter
    When Deactive age filter
    When Wait about 4 second
    When Click "DiscoveriesScreenBtn"
    When Search account "samiracute"
    When Select the profile has name "samiracute" that we are searching
    When Check if content of alert text about age filter is already disapear
#    Login woman account
    When Log out current male account and login with woman account
    When Send smile and message to "montassir93" when age filter is deactive
    When Logout current female account
#
    When Login with account "montassir93" and password "Mektoubi2017"
    When Should see smile, visit notification of "samiracute"
    When Should see message with "samiracute"


  @TEST_QRA-425
  Scenario: Men send message to woman - Woman active age filter then deactive it
#    Step 1: Create new woman account

    When Make sure age filter of man account "montassir93" still remain turn off
    When Create a woman account with email "mektoubitest@gmail.com" and username "samiracute"
    When Skip all questions in every registration form
   # Step 2: check number of notification smile, visit, message
    When Check number of visit, smile notification
    When Check number of messages
   #  Step 3: smile with montassir93
    When Click "DiscoveriesScreenBtn"
    When Smile with "montassir93"
#    active age filter
    When Active age filter from "18" to "21"
    When Wait about 4 second
    When Click "DiscoveriesScreenBtn"
    When Search account "montassir93"
    When Select the profile has name "montassir93" that we are searching
    When Check if content of alert text about age filter is correct
    When Logout current female account

# login by man account, send message
    When Login with account "montassir93" and password "Mektoubi2017"
    When Send message and smile to "samiracute" when age filter is active
    When Refresh curent page
    When Should see woman name "samiracute" on Message screen
    When Logout current male account
# Login by woman account
    When Login with account "mektoubitest@gmail.com" and password "Mektoubi2017"
    Then Should not see smile, visit notification of "montassir93"
    And Should not see message of "montassir93"
# Step 6: deactive age filter
    When Deactive age filter
    When Wait about 4 second
    When Click "DiscoveriesScreenBtn"
    When Search account "montassir93"
    When Select the profile has name "montassir93" that we are searching
    When Check if content of alert text about age filter is already disapear
    When Logout current female account
    When Login with account "montassir93" and password "Mektoubi2017"
    When Send smile and message to "samiracute" when age filter is deactive
    When Logout current male account
    When Login with account "mektoubitest@gmail.com" and password "Mektoubi2017"
    When Should see smile, visit notification of "montassir93"
    When Should see message with "montassir93"

  @TEST_QRA-426
  Scenario: Active Age filter - but already has conversation before active age filter => Alarm about Age filter is no exist, have notification
  #    Step 1: Create new woman account

    When Create a woman account with email "mektoubitest@gmail.com" and username "samiracute"
    When Skip all questions in every registration form
   # Step 2: check number of notification smile, visit, message
    When Check number of visit, smile notification
    When Check number of messages
   #  Step 3: smile with montassir93
    When Click "DiscoveriesScreenBtn"
    When Discuss with "montassir93"
    When Active age filter from "18" to "21"
    When Wait about 4 second
    When Click "DiscoveriesScreenBtn"
    When Search account "montassir93"
    When Select the profile has name "montassir93" that we are searching
    When Check if content of alert text about age filter is already disapear
    When Logout current female account
    When Login with account "montassir93" and password "Mektoubi2017"
    When Send message and smile to "samiracute" when age filter is active
    When Logout current male account
    When Login with account "mektoubitest@gmail.com" and password "Mektoubi2017"
    Then Should not see smile, visit notification of "montassir93"
    When Should see message with "montassir93"


  @TEST_QRA-
  Scenario: Active Age filter - woman send message after active age filter => Alarm about Age filter is no exist, have notification
  #    Step 1: Create new woman account

    When Create a woman account with email "mektoubitest@gmail.com" and username "samiracute"
    When Skip all questions in every registration form
   # Step 2: check number of notification smile, visit, message
    When Check number of visit, smile notification
    When Check number of messages
   #  Step 3: smile with montassir93
    When Active age filter from "18" to "21"
    When Wait about 4 second
    When Click "DiscoveriesScreenBtn"
    When Discuss with "montassir93"
    When Click "DiscoveriesScreenBtn"
    When Search account "montassir93"
    When Select the profile has name "montassir93" that we are searching
    When Check if content of alert text about age filter is already disapear
    When Logout current female account
    When Login with account "montassir93" and password "Mektoubi2017"
    When Send message and smile to "samiracute" when age filter is active
    When Logout current male account
    When Login with account "mektoubitest@gmail.com" and password "Mektoubi2017"
    Then Should not see smile, visit notification of "montassir93"
    When Should see message with "montassir93"

  @TEST_QRA-368
    #ok
  Scenario: disable age filter

    When Login with account "testwoman4" and password "mektoube"
    When Click "MonCompteButton"
    When Click "Reglages"
    When Disable age filter
    When Wait about 1 second
    When Click "discoveryScreenBt"
    #When Scroll All page
    Then All profile dont show notification box

  @TEST_QRA-369
#ok
  Scenario: click enable age filter

    When Login with account "testwoman4" and password "mektoube"
    When Click "MonCompteButton"
    When Click "Reglages"
    When Enable age filter
    Then The page show green alert
#ok
#  27/2/2020
  @TEST_QRA-370
  Scenario: click on "modifer" in age filter label

    When Login with account "testwoman4" and password "mektoube"
    When Wait about 1 second
    When Click "MonCompteButton"
    When Wait about 1 second
    When Click "Reglages"
    When Wait about 1 second
    When Enable age filter
    When Wait about 1 second
    When Click "modifierLink"
    When Wait about 4 second
    Then The page show pop up to choose age range
#    #ok
#  @TEST_QRA-371
#  Scenario: choose range age in "modifier" and validate
#     Given Go to "responsiveIntroduction.url" url (upd)
#
#    When Click to link Se connecter
#    When Insert "testwoman4" into "username" Field (upd)
#    When Insert "mektoube" into "password" Field (upd)
#    When Click Login button
#    When Click on the element is "MonCompteButton"
#    When Click on the element is "Reglages"
#    When Enable age filter
#    When Click on the element is "modifierLink"
#    #18->61
#    When Set up age range
#    When Click on the element is "EnvoyerBtn"
#    When Wait about 5 second
#    When Wait about 5 second
#    When Click on the element is "discoveryScreenBt"
#    When Wait about 5 second
#    Then Profiles show notification box if out of range age
#  3/3/2020
  @TEST_QRA-372
  Scenario: choose range age and click exit

    When Login with account "testwoman4" and password "mektoube"
    When Click "MonCompteButton"
    When Click "Reglages"
    When Enable age filter
    When Click "modifierLink"
    When Click "exitAgeFilter"
    Then Age filter info do not change
#
#  @TEST_QRA-375
#    #ok
#    #testwoman4(out of age range of yassine_yes2)->simle->yassine_yes2=> y2 dont receive
#  Scenario: smile to profile that out of age filter of them, dont have notification of receiver
#     Given Go to "responsiveIntroduction.url" url (upd)
#
#    When Click to link Se connecter
#    When Insert "yassine_yes2" into "username" Field (upd)
#    When Insert "Mektoubi2017" into "password" Field (upd)
#    When Click Login button
#    When Click on the element is "MonCompteButton"
#    When Click on the element is "Reglages"
#    #enable and save age range in to txt file
#    When Wait about 5 second
#    When Enable age filter
#    When Wait about 5 second 4000
#    #logout, login testwoman4
#    When Click on the element is "manSignOut"
#    When Click to link Se connecter
#    When Insert "testwoman4" into "username" Field (upd)
#    When Insert "mektoube" into "password" Field (upd)
#    When Click Login button
#    When Wait about 5 second
#    When Click on the element is "MonCompteButton"
#    When Click on the element is "Reglages"
#    When Disable age filter
#    When Wait about 5 second 4000
#    When Click on the element is "editMyProfile"
#    When Click on the element is "editAgeLabel"
#    When Wait about 5 second 1000
#    When Set up birthday that have age more than max age of other profile is one
#    When Wait about 5 second 3000
#    When Click on the element is "checkButton"
#    When Click on the element is "returnLink"
#    When Click on the element is "discoveryScreenBt"
#    When scroll to view "RefineMySearch"
#    When scroll to view "nickname"
#    #When Click on the element is "nickname"
#    When Insert "yassine_yes2" into "nicknameTextfield" Field (upd)
#    When Click on the element is "checkButton"
#    When Click on the element is "validateButton"
#    #When Scroll All page
#    When Wait about 5 second
#    When Click on the person have above name "yassine_yes2"
#    When Wait about 5 second
#    When Click on the element is "smileBtn" and save current time
#    When Wait about 5 second
#    When Wait about 5 second
#    #logout and check at yasssine_yes2, expected: dont have noti smile from testwoman4
#    When Click on the element is "MonCompteButton"
#    When Click on the element is "Reglages"
#    When Click on the element is "womanSignOut"
#    When Click to link Se connecter
#    When Insert "yassine_yes2" into "username" Field (upd)
#    When Insert "Mektoubi2017" into "password" Field (upd)
#    When Click Login button
#    When Click on the element is "notification"
#    When Wait about 5 second
#    #check smile notification
#    Then This profile was not received smile from "testwoman4"
#
#  @TEST_QRA-376
#    #ok
#    #just run one time on day (cause: just smile one time on day)
#    #yassine_yes2(have age filter)->smile->testwoman4(dont set age filter, out of age of yassine2)=>done testwoman4 receive
#  Scenario: smile to profile that out of age filter of mine => smile done, have smile notification of receiver
#     Given Go to "responsivePreprod" url
#
#    When Click to link Se connecter
#    When Insert "yassine_yes" into "username" Field (upd)
#    When Insert "Mektoubi2017" into "password" Field (upd)
#    When Click Login button
#    When Click on the element is "MonCompteButton"
#    When Click on the element is "Reglages"
#    #enable and save age range in to txt file
#    When Wait about 5 second 1000
#    When Enable age filter
#    When Wait about 5 second 4000
#    When Click on the element is "manSignOut"
#    When Click to link Se connecter
#    When Insert "testwoman4" into "username" Field (upd)
#    When Insert "mektoube" into "password" Field (upd)
#    When Click Login button
#    When Wait about 5 second
#    When Click on the element is "MonCompteButton"
#    When Click on the element is "Reglages"
#    When Disable age filter
#    When Click on the element is "editMyProfile"
#    When Click on the element is "editAgeLabel"
#    When Wait about 5 second 1000
#    When Set up birthday that have age more than max age of other profile is one
#    When Click on the element is "checkButton"
#    When Click on the element is "returnLink"
#    When Click on the element is "womanSignOut"
#    When Click to link Se connecter
#    When Insert "yassine_yes" into "username" Field (upd)
#    When Insert "Mektoubi2017" into "password" Field (upd)
#    When Click Login button
#    When scroll to view "RefineMySearch"
#    When scroll to view "nickname"
#    #When Click on the element is "nickname"
#    When Insert "testwoman4" into "nicknameTextfield" Field (upd)
#    When Click on the element is "checkButton"
#    When Click on the element is "validateButton"
#    #When Scroll All page
#    When Wait about 5 second 1000
#    When Click on the person have above name "testwoman4"
#    When Wait about 5 second 1000
#    When Click on the element is "smileBtn" and save current time
#    When Wait about 5 second 5000
#    When Click on the element is "MonCompteButton"
#    When Click on the element is "Reglages"
#    When Click on the element is "manSignOut"
#    When Click to link Se connecter
#    When Insert "testwoman4" into "username" Field (upd)
#    When Insert "mektoube" into "password" Field (upd)
#    When Click Login button
#    When Click on the element is "notification"
#    When Wait about 5 second
#    #check smile notification??
#    Then This profile received smile from "yassine_yes"
#
##    #maybe bug
##    #NOT check=>upd,=>not pass
##  Scenario: visit to profile that out of age filter of them, dont have notification of receiver
##     Given Go to "responsivePreprod" url
##
##    When Click to link Se connecter
##    When Insert "yassine_yes2" into "username" Field (upd)
##    When Insert "Mektoubi2017" into "password" Field (upd)
##    When Click Login button
##    When Click on the element is "MonCompteButton"
##    When Click on the element is "Reglages"
##    #enable and save age range in to txt file
##    When Wait about 5 second
##    When Enable age filter
##    When Wait about 5 second 4000
##    #logout, login testwoman4
##    When Click on the element is "manSignOut"
##    When Click to link Se connecter
##    When Insert "testwoman4" into "username" Field (upd)
##    When Insert "mektoube" into "password" Field (upd)
##    When Click Login button
##    When Wait about 5 second
##    When Click on the element is "MonCompteButton"
##    When Click on the element is "Reglages"
##    When Disable age filter
##    When Wait about 5 second 4000
##    When Click on the element is "editMyProfile"
##    When Click on the element is "editAgeLabel"
##    When Wait about 5 second 1000
##    When Set up birthday that have age more than max age of other profile is one
##    When Wait about 5 second 3000
##    When Click on the element is "checkButton"
##    When Click on the element is "returnLink"
##    When Click on the element is "discoveryScreenBt"
##    When scroll to view "RefineMySearch"
##    When scroll to view "nickname"
##    #When Click on the element is "nickname"
##    When Insert "yassine_yes2" into "nicknameTextfield" Field (upd)
##    When Click on the element is "checkButton"
##    When Click on the element is "validateButton"
##    #When Scroll All page
##    When Wait about 5 second
##    When Click on the person have above name "yassine_yes2" and save current time
##    When Wait about 5 second
##    #logout and check at yasssine_yes2, expected: dont have noti smile from testwoman4
##    When Click on the element is "MonCompteButton"
##    When Click on the element is "Reglages"
##    When Click on the element is "womanSignOut"
##    When Click to link Se connecter
##    When Insert "yassine_yes2" into "username" Field (upd)
##    When Insert "Mektoubi2017" into "password" Field (upd)
##    When Click Login button
##    When Click on the element is "notification"
##    When Wait about 5 second
##    #check visit notification?=>upd
##    Then This profile was not received visit noti from "testwoman4"
##
##    #maybe bug
##    Scenario: visit to profile that out of age filter of mine => visit done, have notification of receiver
##      Given Go to "responsivePreprod" url
##
##      When Click to link Se connecter
##      When Insert "yassine_yes" into "username" Field (upd)
##      When Insert "Mektoubi2017" into "password" Field (upd)
##      When Click Login button
##      When Click on the element is "MonCompteButton"
##      When Click on the element is "Reglages"
##    #enable and save age range in to txt file
##      When Wait about 5 second 1000
##      When Enable age filter
##      When Wait about 5 second 4000
##      When Click on the element is "manSignOut"
##      When Click to link Se connecter
##      When Insert "testwoman4" into "username" Field (upd)
##      When Insert "mektoube" into "password" Field (upd)
##      When Click Login button
##      When Wait about 5 second
##      When Click on the element is "MonCompteButton"
##      When Click on the element is "Reglages"
##      When Disable age filter
##      When Click on the element is "editMyProfile"
##      When Click on the element is "editAgeLabel"
##      When Wait about 5 second 1000
##      When Set up birthday that have age more than max age of other profile is one
##      When Click on the element is "checkButton"
##      When Click on the element is "returnLink"
##      When Click on the element is "womanSignOut"
##      When Click to link Se connecter
##      When Insert "yassine_yes" into "username" Field (upd)
##      When Insert "Mektoubi2017" into "password" Field (upd)
##      When Click Login button
##      When scroll to view "RefineMySearch"
##      When scroll to view "nickname"
##    #When Click on the element is "nickname"
##      When Insert "testwoman4" into "nicknameTextfield" Field (upd)
##      When Click on the element is "checkButton"
##      When Click on the element is "validateButton"
##    #When Scroll All page
##      When Wait about 5 second 1000
##      When Click on the person have above name "testwoman4" and save current time
##      When Wait about 5 second 2000
##      When Click on the element is "MonCompteButton"
##      When Click on the element is "Reglages"
##      When Click on the element is "manSignOut"
##      When Click to link Se connecter
##      When Insert "testwoman4" into "username" Field (upd)
##      When Insert "mektoube" into "password" Field (upd)
##      When Click Login button
##      When Click on the element is "notification"
##      When Wait about 5 second
##    #??=> ??
##      Then This profile received visit notification from "yassine_yes"
#  3/3/2020
  @TEST_QRA-377
  Scenario: visit a man profile (who is out of my filter) and whose birthday is

    When Login with account "testwoman4" and password "mektoube"
    When Click "MonCompteButton"
    When Click "Reglages"
    #enable and save age range in to txt file
    When Enable age filter
    When Click "modifierLink"
    When Set up age range from 20 to 21
    When Click "submitInAgeFilter"
    When Wait about 5 second
    When Click "discoveryScreenBt"
    When Wait about 1 second
    When Click "haveBirthdayToday"
    When Click "validateButton"
    When Wait about 1 second
    When Visit a man profile (who is out of my filter) and whose birthday is

    ##  3/3/2020
  @TEST_QRA-378
  Scenario: click on profile that out of age filter of mine => show noti box

    When Login with account "testwoman4" and password "mektoube"
    When Click "MonCompteButton"
    When Click "Reglages"
    #enable and save age range in to txt file
    When Enable age filter
    When Click "modifierLink"
    When Set up age range from 20 to 21
    When Click "submitInAgeFilter"
    When Wait about 5 second
    When Click "discoveryScreenBt"
    When Wait about 1 second
    When Click a man profile who is out of my filter






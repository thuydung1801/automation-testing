@QRA-456
Feature: issue is tickets


#   Scenario: when logout, i am at the top of the homepage
#    Given Go to "ResponsivePreprod" url
#
#    When Click to link Se connecter
#    When Insert "wpo19333@bcaoo.com" into "username" Field (upd)
#    When Insert "mektoube" into "password" Field (upd)
#    When Click Login button
#    When Click "MonCompte"
#    When Click "Reglages"
#    Then The page is at the top of the homepage

  @TEST_QRA-316
  Scenario: non premium man cannot block or add to favorite
    Given Go to "ResponsivePreprod" url

    # wpo19333@bcaoo.com block Yassine_yes
    When Login with account "testman2" and password "mektoube"
    When Wait about 1 second
    When Click first person in discovery
    When Click "metarialInProfile"
    When Click "fv.add"
    Then The page show pop up request pay the fee
    And Click "closeFeePopUp"
    When Click "metarialInProfile"
    And Click "blackList.add"
    When Wait about 1 second
    Then The page show pop up request pay the fee

  @TEST_QRA-317
  Scenario: non premium user must not be able to save search
    Given Go to "ResponsivePreprod" url

    When Login with account "testman2" and password "mektoube"
    When Wait about 1 second
    When Click "onlineRadio"
    When Click "validateButton"
    When Wait about 1 second
    When Click "saveSearch"
    Then The page show pop up request pay the fee

  @TEST_QRA-319
  Scenario: criteria number in discovery have to 0 by default
    Given Go to "ResponsivePreprod" url

    When Login with account "testman2" and password "mektoube"
    Then The page have criteria number in discovery have to zero by default

  @TEST_QRA-331
  Scenario:  The search state stays the same when selecting and deselecting an object
    Given Go to "ResponsivePreprod" url

    When Login with account "Yassine_yes" and password "Mektoubi2017"
    When Scroll to "AdvancedCriteria" and click
    When Click "CountryLabel"
    When Wait about 1 second
    When Click "firstRadio"
    When Click "checkPopup"
    When Wait about 1 second
    When Click "RegionLabel"
    When Wait about 1 second
    When Click "firstRadio"
    When Click "checkPopup"
    When Click "validateButton"
    When Wait about 1 second
    When Save data to check again that are "CountryText" and "RegionText"
    When Click on first profile in discovery non save name
    When Wait about 1 second
    When Click "discoveryScreenBt"
    When Scroll to "AdvancedCriteria" and click
    When Wait about 1 second
    Then The Pays and Region label still display the selected selection

 # ti mo comment

#  @TEST_QRA-332
#  Scenario: After changing Pays, the Pays must be map with Region
#    Given Go to "ResponsivePreprod" url
#    When Click to link Se connecter
#    When Insert "Yassine_yes" into "username" Field (upd)
#    When Insert "Mektoubi2017" into "password" Field (upd)
#    When Click Login button
#    When Scroll to "RefineMySearch" and click
#    When Click "CountryLabel"
#    When Wait about 1 second
#    When Click "secondRadio"
#    When Click "checkPopup"
#    When Click "validateButton"
#    When Wait about 1 second
#    #When Scroll All page
#    When Get all locations of profiles
#    When Wait about 1 second
#    #?? error
#    When Click "CountryLabel"
#    When Click "firstRadio"
#    When Click "checkPopup"
#    When Click "RegionLabel"
#    When Wait about 1 second
#    When Click "firstRadio"
#    When Click "checkPopup"
#    When Click "CountryLabel"
#    When Click "secondRadio"
#    When Click "checkPopup"
#    When Click "validateButton"
#    When Wait about 1 second
#    Then The page show all locations with above radio

  #notyet????
  #

#  Scenario: Pop up in request contact is not cut off
#    Given Go to "ResponsivePreprod" url
#    When Click to link Se connecter
#    When Insert "Yassine_yes" into "username" Field (upd)
#    When Insert "Mektoubi2017" into "password" Field (upd)
#    When Click Login button
#    When Scroll to "RefineMySearch" and click
#    When Wait about 1 second
#                #scroll and click
#    When Scroll to "PseudoLabel" and click
#    When Wait about 1 second
#    When Insert "testWoman" into "nicknameTextfield" Field (upd)
#    When Click "checkPopup"
#    When Click "validateButton"
#    When Wait about 1 second
#    When Click on the person have above name "testWoman"
#    When Click "discussBtn"

#  RES-907
#  Copy the link to this issue
#
#  some change in payment modal desktop

#  RES-778
# http://ltservices.atlassian.net/secure/RapidBoard.jspa?rapidView=31&projectKey=RES&modal=detail&selectedIssue=RES-778
  @TEST_QRA-344
  Scenario: profile show previous profile and next profile
    Given Go to "ResponsivePreprod" url

    When Login with account "wpo19333@bcaoo.com" and password "mektoube"
    When Scroll to "AdvancedCriteria" and click
    When Wait about 1 second
                #scroll and click
    When Scroll to "PseudoLabel" and click
    When Wait about 1 second
    When Insert "yassine_" into "nicknameTextfield" Field (upd)
    When Click "checkPopup"
    When Click "validateButton"
    When Wait about 1 second
    When Click on first profile in discovery
    Then The page redirect to page of profile
    Then Profile just shows next profile icon
    And Click "discoveryScreenBt"
    And Wait about 1 second
    And Scroll All page
    And Click on last profile in discovery
    Then The page redirect to page of profile
    Then Profile just shows previous profile icon
    And Click "previousProfileIcon"
    Then The page redirect to page of profile
    Then Profile show previous profile and next profile

  @TEST_QRA-345
  Scenario: Non subscriber click on notification
    Given Go to "ResponsivePreprod" url

    When Login with account "testman2" and password "mektoube"
    When Click "notification"
   # When Clicking on a notification of smile
    #When Scroll to "firstVisitIcon" and click

    #When Wait about 1 second
   # Then The page show pop up request pay the fee
   # And Refresh page
   # When Clicking on a notification of visit
    When Wait about 1 second
    When Click "firstVisitIcon"
    Then The page show pop up request pay the fee

  #need test manual to avoid multiple test
#  @TEST_QRA-365
#  Scenario: The last message must be displayed even when it is first sent
#    Given Go to "ResponsivePreprod" url
#
#    When Login with account "wpo19333@bcaoo.com" and password "mektoube"
#    When Click "CroisezVosDestins"
#    When Click "AcceptButton"
#    When Click "AnswerNowInProfile"
#    When Wait about 1 second
#    Then The quote message and last message must be corresponding

  @TEST_QRA-439
  Scenario: continue send gif after canceled search gif
    Given Go to "ResponsivePreprod" url

    When Login with account "wpo19333@bcaoo.com" and password "mektoube"
    When Click "Messages"
    When Wait until element "firstConversation" is visible
    When Click "firstConversation"
    When Click "gifIcon"
    When Wait about 1 second
    When Insert "hello" into "fieldChat" Field (upd)
    When Wait about 1 second
    When Click "cancelGif"
    When Wait about 1 second
    Then The cancel gif is enable

  @TEST_QRA-440
  Scenario: blocked person in conversation then cant continue send message
    Given Go to "ResponsivePreprod" url

    When Login with account "wpo19333@bcaoo.com" and password "mektoube"
    When Click "MonCompteButton"
    When Click "Reglages"
    When Disable age filter
    When Click "Messages"
    When Click "firstConversation"
    When Click "materialIconMess"
    When Click "blockInConversation"
    When Wait about 3 second
    When Click "fieldChat"
    Then The page show error message is "Vous avez bloqué cette personne"
    And Wait about 4 second
    When Click "MonCompteButton"
    When Click "Reglages"
    When Click on the element is "//h5[text()='Blackliste']" by xpath
    When Wait about 1 second
    When Click "more_vert"
    When Click "unBlockOption"


  @TEST_QRA-480
  Scenario: Scroll on top in message
    Given Go to "ResponsivePreprod" url

    When Login with account "Yassine_yes" and password "Mektoubi2017"
    When Wait about 1 second
    When Click "Messages"
    When Wait about 1 second
  #if have time, need to scroll to view and click on nesrine_byMessage
    When Click "FirstMessageInMessageThread"
    When Wait about 1 second
    When Sroll on top 85000 by robot
    When Wait about 5 second
    Then The last message must be not display
#ok
#  @TEST_QRA-807
#  Scenario: Add "Remove from my favorites" & "Unblock this person" from the profile
#    Given Go to "ResponsivePreprod" url
#
#    When Login with account "yassine_yes" and password "Mektoubi2017"
#    When Wait about 2 second
#    When Click on first profile in discovery
##  check block
#    When Click "metarialinprofile"
#    When Click "blockInProfile"
#    Then The page show notification The block is confirmed
#    And The page dont show Smile and Discuss buttons
#    And Wait about 5 second
#    When Click "metarialinprofile"
#    Then The selection list contains "Débloquer cette personne" in line 2
#    When Click "unblockInProfile"
#    Then The page show green notification is "Personne débloquée" at "greenNotiInTopHeader"
#    And Wait about 5 second
#    And The page show Smile and Discuss buttons
##  check Favorite
#    When Click "metarialinprofile"
#    When Click "fv.add"
#    Then The page show green notification is "Ajouté aux favoris" at "greenNotiInTopHeader"
#    And Wait about 5 second
#    When Click "metarialinprofile"
#    Then The selection list contains "Supprimer de mes favoris" in line 1
#    When Click "fv.remove"
#    Then The page show green notification is "Supprimé des favoris" at "greenNotiInTopHeader"
#
##ti mo comment

# RES-1235
  #maybe test manual this case because have afew case +1 message that isnot received new message
#  @TEST_QRA-848
#  Scenario: Read correct non read message number in each of message items
#    Given Go to "ResponsivePreprod" url
#
#    When Login with account "testwoman" and password "mektoube"
#    When Click "MonCompteButton"
#    When Click "Reglages"
#    When Disable age filter
#    When Click "discoveryScreenBt"
#    When Scroll to "AdvancedCriteria" and click
#    When Scroll to "nickname" and click
#    #When Click "nickname"
#    When Insert "yassine_yes" into "nicknameTextfield" Field (upd)
#    When Click "checkButton"
#    When Click "validateButton"
#    #When Scroll All page
#    When Wait about 3 second
#    When Click on the element is "//h5[text()='yassine_yes']" by xpath
#    When Wait about 1 second
#    When Click "discussBtn"
#    When Insert "hello, this test message from Linh" into "fieldChat" Field (upd)
#    When Click "sendMessageButton"
#    When Wait about 1 second
#    When Click "SignOutIcon"
#    When Click "SeConnecter"
#    When Insert "yassine_yes" into "usernameBtn" Field (upd)
#    When Insert "Mektoubi2017" into "passwordBtn" Field (upd)
#    When Click "loginBtn"
#    When Wait about 1 second
#    When Click "Messages"
#    When Wait about 2 second
#    When Click on the element is "//h5[text()='testwoman']" by xpath
#    When Insert "hello, this test message from Linh  1" into "fieldChat" Field (upd)
#    When Click "sendMessageButton"
#    When Insert "hello, this test message from Linh  2" into "fieldChat" Field (upd)
#    When Click "sendMessageButton"
#    When Wait about 1 second
#    When Click "SignOutIcon"
#    When Click "SeConnecter"
#    When Insert "wpo19333@bcaoo.com" into "usernameBtn" Field (upd)
#    When Insert "mektoube" into "passwordBtn" Field (upd)
#    When Click "loginBtn"
#    When Wait about 1 second
#    When Click "Messages"
#    When Wait about 2 second
##      check in message item from yassine_yes must count equals 2
#    Then The message nunber from "yassine_yes" are 2

##  res-1035 ??
## now idea: block-> "Ajouter à mes favoris" =>ok done
#  @TEST_QRA-850
#  Scenario: If profile choose block (favorited), profile will be unfavorite
#    Given Go to "ResponsivePreprod" url
#
#    When Login with account "wpo19333@bcaoo.com" and password "mektoube"
#    When Wait about 2 second
#    When Click on first profile in discovery
#    When Click "metarialInProfile"
#    When Click "fv.add"
#    When Wait about 3 second
#    When Click "metarialInProfile"
#    When Click "blockInProfile"
#    When Wait about 3 second
#    When Click "metarialInProfile"
#    Then The selection list contains "Ajouter à mes favoris" in line 1
  ##ti mo comment

# res 1207,done
  @TEST_QRA-849
  Scenario: ephemeral report modal
    Given Go to "ResponsivePreprod" url

    When Login with account "wpo19333@bcaoo.com" and password "mektoube"
    When Wait until element "MonCompteButton" is visible
    When Click "MonCompteButton"
    When Click "Reglages"
    When Disable age filter
    When Click "discoveryScreenBt"
    When Scroll to "AdvancedCriteria" and click
    When Scroll to "nickname" and click
    #When Click "nickname"
    When Insert "brandon92500" into "nicknameTextfield" Field (upd)
    When Click "checkButton"
    When Click "validateButton"
    #When Scroll All page
    When Wait about 3 second
    When Click on the element is "//h5[text()='brandon92500']" by xpath
    When Wait about 1 second
    When Click "discussBtn"
    When Wait about 2 second
    When Upload ephemeral picture
    When Click "SignOutIcon"
    When Click "SeConnecter"
    When Insert "brandon92500" into "usernameBtn" Field (upd)
    When Insert "Mektoubi2017" into "passwordBtn" Field (upd)
    When Click "loginBtn"
    When Wait about 3 second
#    When Click "Messages"
#    When Wait about 3 second
    #When Click on the element is "//h5[text()='wpo19333@bcaoo.com']" by xpath
    When Scroll to "AdvancedCriteria" and click
    When Scroll to "nickname" and click
    #When Click "nickname"
    When Insert "pharsa" into "nicknameTextfield" Field (upd)
    When Click "checkButton"
    When Click "validateButton"
    #When Scroll All page
    When Wait about 3 second
    When Click on the element is "//h5[text()='pharsa']" by xpath
    When Wait about 1 second
    When Click "discussBtn"
    When Click "LastEphemeralPicture"
    When Wait about 30 second
    When Click "MessageOptions"
    When Click "ReportPictureFlag"
    When Wait about 3 second
    Then Check ephemeral report modal

  @TEST_QRA-864
  Scenario: Have to display correct time of last message in conversation
    Given Go to "ResponsivePreprod" url
    When Wait about 5 second

    When Login with account "wpo19333@bcaoo.com" and password "mektoube"
    When Wait about 1 second
    When Scroll to "AdvancedCriteria" and click
    When Scroll to "nickname" and click
    When Wait about 1 second
    When Insert "yassine_yes" into "nicknameTextfield" Field (upd)
    When Click "checkButton"
    When Click "validateButton"
    When Wait about 3 second
    When Click on the element is "//h5[text()='yassine_yes']" by xpath
    When Wait about 1 second
    When Click "discussBtn"
    When Wait about 2 second
    When Insert "check time of last message" into "fieldChat" Field (upd)
    When Click "sendMessButton"
    When Wait about 2 second
    Then Time of quote message, last message and real time have same

#    for res 1287, but not done, need check again, ?
  @TEST_QRA-958
  Scenario: Profile status must match in discovery, profile and message
    Given Go to "ResponsivePreprod" url

    When Login with account "wpo19333@bcaoo.com" and password "mektoube"
    When Wait about 2 second
    When Click "onlineRadio"
    When Click "validateButton"
    When Wait about 2 second
    When Profile status must match in discovery, profile and message

  @TEST_QRA-965
  Scenario: Payment page, Show message when click over 3 time validate button
    Given Go to "ResponsivePreprod" url

    When Login with account "testman" and password "mektoube"
    When Wait about 2 second
    When Click "firstProfileInDiscovery"
    When Click "CroiserSonDestinButton"
    When Insert "4111111111111111" into Field "cardNumberField"
    When Insert "12/27" into Field "ExpDateOfCardField"
    When Insert "676" into Field "CVVField"
    When Click "SubmitBtn"
    When Wait about 4 second
    When Click "SubmitBtn"
    When Wait about 4 second
    When Click "SubmitBtn"
    When Wait about 4 second
    When Click "SubmitBtn"
    Then The page show error message is "Trop de tentatives de paiement en échec. Vous pourrez réessayer dans 15 min"


  @TEST_QRA-966
  Scenario: Upload photo that changed extension
    Given Go to "ResponsivePreprod" url

    When Login with account "yassine_yes" and password "Mektoubi2017"
    When Upload picture "changedExtensionImage.jpg" to under approval process
    When Wait about 2 second
    Then The page show error message is "Le téléchargement de la photo a échoué. Veuillez réessayer"

  @TEST_QRA-967
  Scenario: Add the testimonials block
    Given Go to "ResponsivePreprod" url

    When Scroll to view "section[class='section section--testimonials']"
    Then The testimonials contain all it's parts

    #check lại link khi lên preprod
  @TEST_QRA-985
  Scenario: Message when a user tries to create an account with a blocked email (disposable email)
    Given Go to "ResponsivePreprod" url

    When Create a man account with email "ztb80255@eoopy.com"
    Then The page show message "Vous ne pouvez pas créer de compte avec un email provenant de ce nom de domaine." at "p.error"
    And It should redirect to "https://responsive-preprod.mektoube.fr/inscription/signup"

  @TEST_QRA-996
  Scenario: send image that not valid => show error message and can not send image
    Given Go to "ResponsivePreprod" url

    When Login with account "linhlinhttt98@gmail.com" and password "mektoube"
    When Search account "yassine_yes2"
    When Select the profile has name "yassine_yes2" that we are searching
    When Wait until element "Discuss" is visible
    When Click "Discuss"
    When Wait until element "div[class='messages']" is visible
    When Wait until element "selectImageIcon" is visible
    #must send before 1 photo then send photo that changed extension => appear bug
    When Upload ephemeral picture
    When Upload ephemeral picture is "changedExtensionImage.jpg"
    #When Wait until element "div.top-message-overlay > div.top-message-text > div" is visible
    #?? can not catch element top message
    #Then The page show error message is "La photo n'est pas valide"
    And Dont show sent image that changed extension

  @TEST_QRA-1001
  Scenario: Boost profil on discovery dont miss after refresh
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Counting number of boost profile on discovery
    When Refresh page
    Then The boost profiles like when not refreshed


#  @TEST_QRA-
#  Scenario: Block person and person that was blocked >> hide Discuss and Smile button
#    Given Go to "ResponsivePreprod" url
#
#    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
#    When Scroll to "AdvancedCriteria" and click
#    When Scroll to "nickname" and click
#    #When Click "nickname"
#    When Insert "brandon92500" into "nicknameTextfield" Field (upd)
#    When Click "checkButton"
#    When Click "validateButton"
#    #When Scroll All page
#    When Wait about 2 second
#    When Click on the element is "//h5[text()='brandon92500']" by xpath
#    When Click "metarialinprofile"
#    When Click "blockInProfile"
#    Then The page show notification The block is confirmed
#    And The disscuss and smile button are hided
#    When Click "logout"
#    When Login with account "brandon92500" and password "Mektoubi2017"


  @TEST_QRA-1005
  Scenario: Disable voice icon after blocking user
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Scroll to "AdvancedCriteria" and click
    When Scroll to "nickname" and click
    When Wait about 1 second
    When Insert "brandon92500" into "nicknameTextfield" Field (upd)
    When Click "checkButton"
    When Click "validateButton"
    When Wait about 3 second
    When Click on the element is "//h5[text()='brandon92500']" by xpath
    When Wait about 1 second
    When Click "discussBtn"
    When Wait about 2 second
    When Insert "Disable voice icon after blocking user" into "fieldChat" Field (upd)
    When Click "sendMessButton"
    When Wait about 2 second
    When Click "materialIconMess"
    When Click "blockInConversation"
    When Wait until element "greenNotiOnTopHeader" is visible
    Then The page show message "Le blocage est confirmé" at "greenNotiOnTopHeader"
    Then Wait about 2 second
    And The button is disabled that is "disabledVoiceIcon"
    And Click "voiceIcon"
    When Wait until element "redNotiInTopHeader" is visible
    Then The page show message "Vous avez bloqué cette personne" at "redNotiInTopHeader"
    And Click "messageDetailName"
    And Click "metarialInProfile"
    And Click "unblockInProfile"
    Then The page show Smile and Discuss buttons

  @TEST_QRA-1006
  Scenario: Disable voice icon after clicking gif icon (advoid still recording )
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Scroll to "AdvancedCriteria" and click
    When Scroll to "nickname" and click
    When Wait about 1 second
    When Insert "brandon92500" into "nicknameTextfield" Field (upd)
    When Click "checkButton"
    When Click "validateButton"
    When Wait about 3 second
    When Click on the element is "//h5[text()='brandon92500']" by xpath
    When Wait about 1 second
    When Click "discussBtn"
    When Wait about 2 second
    When Click "gifIcon"
    And The button is disabled that is "disabledVoiceIcon"

  @TEST_QRA-1010
  Scenario: Change parttern name in Setting My profile
    Given Go to "ResponsivePreprod" url

    When Login with account "qa+lily1@mektoube.fr" and password "mektoube"
    When Wait until element "MonCompteButton" is visible
    When Click "MonCompteButton"
    When Wait until element ".edit-name-btn span" is visible

    When Click ".edit-name-btn span"
    When Clear text from field "input[name='firstname']"
    When Insert "techizinc" into "input[name='firstname']" Field (upd)
    When Click "div[class='form--actions text-center'] button"
    When Wait until element "redNotiInTopHeader" is visible
    Then The page show error message is "Ce prénom n’est pas accepté, veuillez en choisir un autre"
    And Wait about 4 second

    When Click ".edit-name-btn span"
    When Clear text from field "input[name='firstname']"
    When Insert "techizinca" into "input[name='firstname']" Field (upd)
    When Click "div[class='form--actions text-center'] button"
    When Wait until element "redNotiInTopHeader" is visible
    Then The page show error message is "Ce prénom n’est pas accepté, veuillez en choisir un autre"
    And Wait about 4 second

    When Click ".edit-name-btn span"
    When Clear text from field "input[name='firstname']"
    When Insert "atechizinc" into "input[name='firstname']" Field (upd)
    When Click "div[class='form--actions text-center'] button"
    When Wait until element "redNotiInTopHeader" is visible
    Then The page show error message is "Ce prénom n’est pas accepté, veuillez en choisir un autre"
    And Wait about 4 second

    When Click ".edit-name-btn span"
    When Clear text from field "input[name='firstname']"
    When Insert "atechizinca" into "input[name='firstname']" Field (upd)
    When Click "div[class='form--actions text-center'] button"
    When Wait until element "redNotiInTopHeader" is visible
    Then The page show error message is "Ce prénom n’est pas accepté, veuillez en choisir un autre"
    And Wait about 4 second

    When Click ".edit-name-btn span"
    When Clear text from field "input[name='firstname']"
    When Insert "techizexact" into "input[name='firstname']" Field (upd)
    When Click "div[class='form--actions text-center'] button"
    When Wait until element "redNotiInTopHeader" is visible
    Then The page show error message is "Ce prénom n’est pas accepté, veuillez en choisir un autre"
    And Wait about 4 second

    When Click ".edit-name-btn span"
    When Clear text from field "input[name='firstname']"
    When Insert "techizstart" into "input[name='firstname']" Field (upd)
    When Click "div[class='form--actions text-center'] button"
    When Wait until element "redNotiInTopHeader" is visible
    Then The page show error message is "Ce prénom n’est pas accepté, veuillez en choisir un autre"
    And Wait about 4 second

    When Click ".edit-name-btn span"
    When Clear text from field "input[name='firstname']"
    When Insert "techizstarta" into "input[name='firstname']" Field (upd)
    When Click "div[class='form--actions text-center'] button"
    When Wait until element "redNotiInTopHeader" is visible
    Then The page show error message is "Ce prénom n’est pas accepté, veuillez en choisir un autre"
    And Wait about 4 second

    When Click ".edit-name-btn span"
    When Clear text from field "input[name='firstname']"
    When Insert "techizend" into "input[name='firstname']" Field (upd)
    When Click "div[class='form--actions text-center'] button"
    When Wait until element "redNotiInTopHeader" is visible
    Then The page show error message is "Ce prénom n’est pas accepté, veuillez en choisir un autre"
    And Wait about 4 second

    When Click ".edit-name-btn span"
    When Clear text from field "input[name='firstname']"
    When Insert "atechizend" into "input[name='firstname']" Field (upd)
    When Click "div[class='form--actions text-center'] button"
    When Wait until element "redNotiInTopHeader" is visible
    Then The page show error message is "Ce prénom n’est pas accepté, veuillez en choisir un autre"


  @TEST_QRA-1012
  Scenario: Dont allow to upload gif to profile
    Given Go to "https://responsive-staging.ltservices2.ovh/" url

    When Login with account "maiia" and password "mektoube"
    When Upload picture "gifAvar.gif" to under approval process
    When Wait about 2 second
    Then The page show error message is "Fichier invalide, choisir un fichier jpg, jpeg, bmp ou png"


    



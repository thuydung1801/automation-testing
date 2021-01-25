Feature: Setting List

#  @TEST_QRA-285
#  Scenario: Setting List - register a new email - fill the fields correctly
#    Given Go to "ResponsiveIntroduction.url" url
#
#    When Click to link Se connecter
#    When Insert "Phuong3110" into Field "usernameField"
#    When Insert "Mektoubi2019" into Field "passwordField"
#    When Click button "loginBtn"
#    When Wait about 5 second
#    When Click button "settingBtn"
#    When Scroll to element that has text "Email" and click
#    When Insert "<string>" into Field "<string>"
#    When Insert "<string>" into Field "<string>"
#    When Click button "Enregistrer"
##    cần vào confirm email


  @TEST_QRA-286
  Scenario: Setting List - register a new email - leave the fields empty
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "shainez29" and password "mektoube**"
    When Wait until element "MyProfileBtn" is visible
    When Click "MyProfileBtn"
    When Wait until element "settingBtn" is visible
    When Click "settingBtn"
    When Wait until element ".list-settings" is visible
    When Scroll to element that has text "Email" and click
    When Click "Enregistrer"
    Then Should see red border in password and new email fields


  @TEST_QRA-288
  Scenario: Setting List - register a new email - do a mistake on the password

    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "shainez29" and password "mektoube**"
    When Wait until element "MyProfileBtn" is visible
    When Click "MyProfileBtn"
    When Wait until element "settingBtn" is visible
    When Click "settingBtn"
    When Wait until element ".list-settings" is visible
    When Scroll to element that has text "Email" and click
    When Insert "Mektoubi2018" into Field "input[name='current_password']"
    When Insert "chi@gmail.com" into Field "input[name='new_email']"
    When Click "Enregistrer"
    Then Should see message popup at top "Votre mot de passe actuel est incorrect"

  @TEST_QRA-289
  Scenario: Setting List - register a new email - fill invalid email
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "shainez29" and password "mektoube**"
    When Wait until element "MyProfileBtn" is visible
    When Click "MyProfileBtn"
    When Wait until element "settingBtn" is visible
    When Click "settingBtn"
    When Wait until element ".list-settings" is visible
    When Scroll to element that has text "Email" and click
    When Insert "mektoube**" into Field "input[name='current_password']"
    When Insert "chi@" into Field "input[name='new_email']"
    When Click "Enregistrer"
    Then Wait until element "redBorder" is visible
    And Clear text from field "input[name='new_email']"
    And Insert "lannt.woman@gmail.com" into Field "input[name='new_email']"
    When Click "Enregistrer"
    Then Should see message popup at top "L'Email n'est pas valide"

  @TEST_QRA-290
  Scenario: Setting List - register a new email - click on password visible button
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "shainez29" and password "mektoube**"
    When Wait until element "MyProfileBtn" is visible
    When Click "MyProfileBtn"
    When Wait until element "settingBtn" is visible
    When Click "settingBtn"
    When Wait until element ".list-settings" is visible
    When Scroll to element that has text "Email" and click
    When Insert "Mektoubi20188" into Field "input[name='current_password']"
    When Click "button[aria-label='Toggle password visibility']"
    Then Button password visible should work
    When Click "a[class='closer right-side'] i[class='material-icons']"
#    Then Setting modal is closed
    Then Setting "newEmailModal" is closed

  @TEST_QRA-291
  Scenario: Setting List - register a new email - click on exit
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "shainez29" and password "mektoube**"
    When Wait until element "MyProfileBtn" is visible
    When Click "MyProfileBtn"
    When Wait until element "settingBtn" is visible
    When Click "settingBtn"
    When Wait until element ".list-settings" is visible
    When Scroll to element that has text "Email" and click
    When Insert "Mektoubi2017" into Field "input[name='current_password']"
    When Insert "chi@" into Field "input[name='new_email']"
    When Click "a[class='closer right-side'] i[class='material-icons']"
    Then Setting "newEmailModal" is closed

  @TEST_QRA-292
  Scenario: Setting List - change password - fill the fields correctly
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "lannt.woman@gmail.com" and password "mektoube**"
    When Change passwword from "mektoube**" to "Mektoubi2018" and logout
    When Login with old passwword "mektoube**"
    Then Display warning "Identifiant ou mot de passe incorrect"
    When Wait about 4 second
    Then Can login with new password "Mektoubi2018"
    When Change passwword from "Mektoubi2018" to "mektoube**" and logout

  @TEST_QRA-293
  Scenario: Setting List - change password - leave the fields empty
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "lannt.woman@gmail.com" and password "mektoube**"
    When Wait until element "MyProfileBtn" is visible
    When Click "MyProfileBtn"
    When Wait until element "settingBtn" is visible
    When Click "settingBtn"
    When Wait until element ".list-settings" is visible
    When Scroll to element that has text "ChangerVotreMotDePasse" and click
    When Click "form[class='form form--change-password'] button[class='mdc-button mdc-button--unelevated']"
    Then Wait until element "redBorder" is visible

  @TEST_QRA-294
  Scenario: Setting List - change password - do a mistake on the password
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "lannt.woman@gmail.com" and password "mektoube**"
    When Wait until element "MyProfileBtn" is visible
    When Click button "MyProfileBtn"
    When Wait until element "settingBtn" is visible
    When Click button "settingBtn"
    When Wait until element ".list-settings" is visible
    When Scroll to element that has text "ChangerVotreMotDePasse" and click
    When Insert "Mektoube2018" into Field "input[name='passwd']"
    When Insert "Mektoubi2019" into Field "input[name='new_data']"
    When Click "form[class='form form--change-password'] button[class='mdc-button mdc-button--unelevated']"
    Then Should see message popup at top "Votre mot de passe actuel est incorrect"

  @TEST_QRA-295
  Scenario: Setting List - change password - click on password visible button
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "lannt.woman@gmail.com" and password "mektoube**"
    When Wait until element "MyProfileBtn" is visible
    When Click button "MyProfileBtn"
    When Wait until element "settingBtn" is visible
    When Click button "settingBtn"
    When Wait until element ".list-settings" is visible
    When Scroll to element that has text "ChangerVotreMotDePasse" and click
    When Insert "Mektoubi2018" into Field "input[name='passwd']"
    When Insert "Mektoubi2019" into Field "input[name='new_data']"
    When Click ".input-field-container.black-skin:nth-child(1) button[aria-label='Toggle password visibility']"
    When Click ".input-field-container.black-skin:nth-child(2) button[aria-label='Toggle password visibility']"
    Then Both two button password visible should work
    When Click "CloseBtn"
    Then Setting "changeNewPasswordModal" is closed


  @TEST_QRA-297
  Scenario: Setting List - woman - explanation of the photo filter
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "shainez29" and password "mektoube**"
    When Wait until element "MyProfileBtn" is visible
    When Click "MyProfileBtn"
    When Wait until element "settingBtn" is visible
    When Click "settingBtn"
    When Wait until element ".list-settings" is visible
    When Click "photoFilterInfor"
    When Wait until element "div[class='photo-info--modal modal is--opened']" is visible
    Then Should see modal explanation of the photo filter
    And Click "a[class='closer'] i[class='material-icons']"
    Then Setting "PhotoFilterExplanation" is closed


  @TEST_QRA-298
  Scenario: Setting List - woman - try to activate the photo filter whereas there are no photos in the profile
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "lannt.woman@gmail.com" and password "mektoube**"
    When Wait until element "MyProfileBtn" is visible
    When Click "MyProfileBtn"
    When Wait until element "settingBtn" is visible
    When Click "settingBtn"
    When Wait until element ".list-settings" is visible
    When Click "turnOnPhotoFilter"
    Then Should see message popup at top "Veuillez mettre au moins une photo"
    When Wait about 4 second
    And Button filter photo remain turn off

  @TEST_QRA-299
  Scenario: Setting List - click on "aide"
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "shainez29" and password "mektoube**"
    When Wait until element "MyProfileBtn" is visible
    When Click "MyProfileBtn"
    When Wait until element "settingBtn" is visible
    When Click "settingBtn"
    When Wait until element ".list-settings" is visible
    When Scroll to element that has text "Aide" and click
    When Wait about 2 second
    Then Redirect to link "https://aide.mektoube.fr/"

  @TEST_QRA-304
  Scenario: Setting List - Service client - leave the field empty
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "shainez29" and password "mektoube**"
    When Wait until element "MyProfileBtn" is visible
    When Click "MyProfileBtn"
    When Wait until element "settingBtn" is visible
    When Click "settingBtn"
    When Wait until element ".list-settings" is visible
    When Scroll to element that has text "ServiceClient" and click
    When Click "submitForm"
    Then Should see red border in Message field

  @TEST_QRA-305
  Scenario: Setting List - Service client - fill the field correctly
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "shainez29" and password "mektoube**"
    When Wait until element "MyProfileBtn" is visible
    When Click "MyProfileBtn"
    When Wait until element "settingBtn" is visible
    When Click "settingBtn"
    When Wait until element ".list-settings" is visible
    When Scroll to element that has text "ServiceClient" and click
    When Click ".input-field-container"
    When Click "li[data-value='127']"
    When Wait about 2 second
    When Insert "hi, this is just a test message" into Field "textarea[aria-invalid='false']"
    When Click "submitForm"
    Then Should see message popup at top "Message envoyé au service client"

  @TEST_QRA-306
  Scenario: Setting List - Service client - click on "annuler"
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "shainez29" and password "mektoube**"
    When Wait until element "MyProfileBtn" is visible
    When Click "MyProfileBtn"
    When Wait until element "settingBtn" is visible
    When Click "settingBtn"
    When Wait until element ".list-settings" is visible
    When Scroll to element that has text "ServiceClient" and click
    When Click ".input-field-container"
    When Click "li[data-value='127']"
    When Insert "hi, this is just a test message" into Field "textarea[aria-invalid='false']"
    When Click "div[class='form--actions text-center'] button[class='mdc-button mdc-btn-gray mdc-button--unelevated']"
    Then Setting "ServicesClient" is closed

  @TEST_QRA-308
  Scenario: Setting List - Remove my account - see message popup
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "lannt.woman@gmail.com" and password "mektoube**"
    When Wait until element "MyProfileBtn" is visible
    When Click "MyProfileBtn"
    When Wait until element "settingBtn" is visible
    When Click button "settingBtn"
    When Wait until element ".list-settings" is visible
    When Scroll to element that has text "MonCompteInSettingList" and click
    When Wait about 2 second
    When Scroll to element that has text "SupprimerMonCompte" and click
    When Wait about 2 second
    When Click "confirmRemoveMyAccount"
    When Should see message popup in line "Le mot de passe ne peut pas être vide"
    When Insert "mektoube**" into Field "input[name='password']"
    When Click "confirmRemoveMyAccount"
    When Should see message popup at top "Un email de confirmation vous a été envoyé"
    #cannot test email confirm

  @TEST_QRA-309
  Scenario: Setting List - non subscriber man - click on "mon abonnement"
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "montassir931" and password "Mektoubi2017"
    When Wait until element "MyProfileBtn" is visible
    When Click "MyProfileBtn"
    When Wait until element "settingBtn" is visible
    When Click "settingBtn"
    When Wait until element ".list-settings" is visible
    When Scroll to element that has text "MonCompteInSettingList" and click
    When Click "MySubscription"
    Then Wait until element "div.setting--modal.unsubscription-modal.is--opened" is visible

  @TEST_QRA-310
  Scenario: Setting List - click on CGU
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "shainez29" and password "mektoube**"
    When Wait until element "MyProfileBtn" is visible
    When Click "MyProfileBtn"
    When Wait until element "settingBtn" is visible
    When Click "settingBtn"
    When Wait until element ".list-settings" is visible
    When Scroll to element that has text "CGUInSettingList" and click
    Then Redirect to link "https://responsive-preprod.mektoube.fr/cgu"

  @TEST_QRA-311
  Scenario: Setting List - click on "vie privé"
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "shainez29" and password "mektoube**"
    When Wait until element "MyProfileBtn" is visible
    When Click "MyProfileBtn"
    When Wait until element "settingBtn" is visible
    When Click button "settingBtn"
    When Wait until element ".list-settings" is visible
    When Scroll to element that has text "//div[@class='list-settings']//*[contains(text(),'Vie privée')]" and click
    Then Redirect to link "https://responsive-preprod.mektoube.fr/charte-vie-privee"

  @TEST_QRA-312
  Scenario: Setting List - click on "mentions légals"
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "shainez29" and password "mektoube**"
    When Wait until element "MyProfileBtn" is visible
    When Click "MyProfileBtn"
    When Wait until element "settingBtn" is visible
    When Click button "settingBtn"
    When Wait until element ".list-settings" is visible
    When Scroll to element that has text "//div[@class='list-settings']//*[contains(text(),'Mentions légales')]" and click
    Then Redirect to link "https://responsive-preprod.mektoube.fr/mentions-legales"

  @TEST_QRA-313
  Scenario: Setting List - Log out account
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "shainez29" and password "mektoube**"
    When Wait until element "MyProfileBtn" is visible
    When Click "MyProfileBtn"
    When Wait until element "settingBtn" is visible
    When Click "settingBtn"
    When Wait until element ".list-settings" is visible
    When Scroll to element that has text "//div[@class='list-settings']//*[contains(text(),'Se déconnecter')]" and click
    Then Redirect to link "ResponsiveIntroduction.url"

  @TEST_QRA-314
  Scenario: Setting List - woman - activate the photo filter
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "lantiu@gmail.com" and password "mektoube**"
    When Wait until element "MyProfileBtn" is visible
    When Click "MyProfileBtn"
    When Wait until element "settingBtn" is visible
    When Click button "settingBtn"
    When Wait until element ".list-settings" is visible
    When Active photo filter button
    When Scroll to element that has text "//div[@class='list-settings']//*[contains(text(),'Se déconnecter')]" and click
    When Login with account "Yassine_yes2" and password "Mektoubi2017"
    When Search account "Emna98"
    When Select the profile has name "Emna98" that we are searching
    When Wait until element "Discuss" is visible
    When Click "Discuss"
    When Wait until element "chatField" is visible
    When Insert "hi, this is test message" into Field "chatField"
    And Click "sendMessage"
    Then Should see Modal explain about need to add photo

  @TEST_QRA-315
  Scenario: Setting List - woman - deactivate the photo filter
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "shainez29" and password "mektoube**"
    When Wait until element "MyProfileBtn" is visible
    When Click "MyProfileBtn"
    When Wait until element "settingBtn" is visible
    When Click "settingBtn"
    When Wait until element ".list-settings" is visible
    When Deactive photo filter button
    When Scroll to element that has text "//div[@class='list-settings']//*[contains(text(),'Se déconnecter')]" and click
    When Login with account "Yassine_yes2" and password "Mektoubi2017"
    When Search account "shainez29"
    When Select the profile has name "shainez29" that we are searching
    When Wait until element "Discuss" is visible
    When Click "Discuss"
    When Wait until element "chatField" is visible
    When Insert "hi, my name is Yasine, this is test message from Chi =)))" into Field "chatField"
    And Click "sendMessage"
    Then Should see message "hi, my name is Yasine, this is test message from Chi =)))" sent
    When Insert "hi, this is test message bla bla 2" into Field "chatField"
    And Click "sendMessage"


  @TEST_QRA-485
  Scenario: Quick logout button
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "montassir93" and password "Mektoubi2017"
    When Wait until element "div.flex-row a[title]" is visible
    When Click "div.flex-row a[title]"
    When Wait until element "div.home-intro" is visible
    Then Browser should redirect to "https://responsive-preprod.mektoube.fr/"


  @TEST_QRA-961
  Scenario: update notification preference form (submit button is no longer exist)
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "shainez29" and password "mektoube**"
    When Change setting of notification
    Then Should see message popup at top "Vos préférences ont été mises à jour"

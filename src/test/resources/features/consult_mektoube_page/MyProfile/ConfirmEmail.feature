Feature: Confirm email
  Background:
    Given Go to "ResponsiveIntroduction.url" url

  @TEST_QRA-482
  Scenario: Warning confirm email - click on "Renvoyer un email de validation"

    When Login with account "testman2" and password "mektoube"
    When Wait until element "a.warning-info" is visible
    When Click "a.warning-info"
    When Wait until element "div.modal-content" is visible
    When Scroll to element that has text "RenvoyerUnEmailDeValidation" and click
    Then Should see message popup at top "L'email de vérification a bien été envoyé"


  @TEST_QRA-483
  Scenario: Warning confirm email - click on "Modifier votre email"

    When Login with account "testman2" and password "mektoube"
    When Wait until element "a.warning-info" is visible
    When Click "a.warning-info"
    When Wait until element "div.modal-content" is visible
    When Scroll to element that has text "ModifierVotreEmail" and click
    When Wait until element "div.list-settings" is visible
    Then Browser should redirect to "https://www.mektoube.fr/main/my-account/parameters"


  @TEST_QRA-484
  Scenario: Click on Edit Prenom - Should see modal confirm email

    When Login with account "testman2" and password "mektoube"
    When Wait until element "MyProfileBtn" is visible
    When Click "MyProfileBtn"
    When Wait until element "button.edit-name-btn" is visible
    When Click "button.edit-name-btn"
    When Wait until element "ValidateEmailToChangeName" is visible
    When Click "ValidateEmailToChangeName"
    Then Should see message popup at top "L'email de vérification a bien été envoyé"
    When Wait about 4 second
    When Click "CloseModal"
    When Setting modal is closed

  @TEST_QRA-861
  Scenario: Verify link confirm email

    When Create a woman account with email "mektoubitest@gmail.com" and username "samiracute"
    When Skip all questions in every registration form
    When Wait until element "a.warning-info" is visible
    When Click "a.warning-info"
    When Wait until element "div.modal-content" is visible
    When Scroll to element that has text "RenvoyerUnEmailDeValidation" and click
    Then Should see message popup at top "L'email de vérification a bien été envoyé"
    When Verify confirm Email link
    When Switch tab
    When Wait until element "div[class='header__inner']" is visible
#    không đc thay đổi URL này
    Then Browser should redirect to "https://mektoube.fr/main/discoveries"
    When Wait about 4 second
    When Wait until element "MyProfileBtn" is visible
    When Click "MyProfileBtn"
    When Click "NotificationTextLink"
    Then Check if Warning confirm email exist
    When Switch tab
    When Click "deleteMektoubeEmail"
    When Wait about 1 second

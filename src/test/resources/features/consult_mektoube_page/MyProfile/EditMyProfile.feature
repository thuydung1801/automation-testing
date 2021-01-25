Feature: Edit My profile and My criteria

  Background:
    Given Go to "https://www.mektoube.fr/" url
  @TEST_QRA-106
  Scenario: upload picture to under approval process (to reject after that)

    When Login with account "montassir931" and password "Mektoubi2017"
    When Upload picture "testPicture6.jpg" to under approval process
    Then Should see message popup at top "Photo en cours d'approbation"

  @TEST_QRA-60
  Scenario: When a user completely erases his "myIntroduction" and valid, should display warning alert

    When Login with account "dangtapta" and password "Mektoubi2017"
    When Insert and completely erases My Introduction in profile
    When Click "ValidateBtn"
    Then Should see message popup in line "Le champ est vide"

  @TEST_QRA-268
  Scenario: profile statistic

    When Login with account "shainez29" and password "mektoube"
    When Wait until element "MyProfileBtn" is visible
    When Click "MyProfileBtn"
    When Scroll to "Statistic" and click
    Then Statistic should be correct

  @TEST_QRA-347
  Scenario: Edit My profile and My criteria (If Don't fill information in registration step)

    When Create a man account with email "mektoubitest@gmail.com" and username "Kamel_vip"
    When Skip all questions in every registration form
    When Wait until element "MyProfileBtn" is visible
    When Click "MyProfileBtn"
    When Wait until element "EditMyProfie" is visible
    When Click "EditMyProfie"
    When Leave all edit profile fields empty and click validate
    When Fill all my profile empty fields
    When Wait about 2 second
    When Should see text area is disable
    When Wait about 1 second
    When Check if information we selected is displayed correctly in Profile
    When Edit my profile again
    And Check if information we selected is displayed correctly in Profile
    When Scroll to "Return" and click
    When Click "EditMyCriteria"
    When Wait about 2 second
    When Leave all edit criteria fields empty and click validate
    And Fill all my criteria empty fields
    And Check if information about My criteria we selected is displayed correctly in Profile
    And Edit my criteria again
    And Check if information about My criteria we selected is displayed correctly in Profile
    When Scroll to "Return" and click


  @TEST_QRA-407
  Scenario: Edit My profile and My criteria (Already fill information in registration step)

    When Create a man account with email "mektoubitest@gmail.com" and username "Kamel_vip"
    When Upload avatar from computer
    When Check if upload avatar successful
    Then Answer all question in Registration form
    When Wait about 4 second
    When Wait until element "MyProfileBtn" is visible
    When Click "MyProfileBtn"
    When Wait until element "EditMyProfie" is visible
    When Click "EditMyProfie"
    When Leave all edit profile fields empty and click validate
    When Fill all my profile empty fields
    When Should see text area is disable
    When Wait about 2 second
    When Check if information we selected is displayed correctly in Profile
    When Edit my profile again
    And Check if information we selected is displayed correctly in Profile
    When Scroll to "Return" and click
    When Click "EditMyCriteria"
    When Leave all edit criteria fields empty and click validate
    And Fill all my criteria empty fields
    And Check if information about My criteria we selected is displayed correctly in Profile
    And Edit my criteria again
    And Check if information about My criteria we selected is displayed correctly in Profile
    When Scroll to "Return" and click


  @TEST_QRA-110
  Scenario: Link "Last photo refused!" works

    When Login with account "montassir931" and password "Mektoubi2017"
    When Wait until element "MyProfileBtn" is visible
    When Click "MyProfileBtn"
    When Wait until element "photoRejectLink" is visible
    When Click "photoRejectLink"
    When Should see warning-message about Photo refuse
    When Turn off library window
    When Click "turnOffPhotoRefuse"
    When Click "photoRejectLink"
    When Upload picture again
    When Should see message popup at top "Photo en cours d'approbation" or "La photo n'est pas valide"

  @TEST_QRA-111
  Scenario: see stop icon on the rejected photo

    When Login with account "montassir931" and password "Mektoubi2017"
    When Wait until element "MyProfileBtn" is visible
    When Click "MyProfileBtn"
    When Should see stop icon on rejected photo

  @TEST_QRA-962
  Scenario: Change nickname for new account
    When Create a woman account with email "mektoubitest@gmail.com" and username "samiracute"
    When Skip all questions in every registration form
    When Wait until element "MonCompte" is visible
    When Click "MonCompte"
    When Wait about 2 second
    When Click "button.edit-name-btn"
    Then Wait until element "form.form--change-firstname" is visible
    When Click "button.mdc-btn--blue"
    When Should see message popup "L'email de vérification a bien été envoyé"
    When Verify confirm Email link
    When Switch tab
    When Wait until element "div[class='header__inner']" is visible
#    không đc thay đổi URL này
    Then Browser should redirect to "https://mektoube.fr/main/discoveries"
    When Wait about 4 second
    When Wait until element "MonCompte" is visible
    When Click "MonCompte"
    When Wait about 2 second
    When Click "button.edit-name-btn"
    Then Edit nickname and check new nickname
Feature: Contact Request Of Non Subscriber Man

  Background:
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "lannt.man98@gmail.com" and password "Mektoubi2017"

  @TEST_QRA-356
  Scenario: Click on "Découvrir des profils" on Contact Request screen

    When Click Découvrir des profils on Croisez vos destins screen
    Then Wait until element "ul[class='list-profiles']" is visible
    And Wait until element "discoveriesLabel" is visible

  @TEST_QRA-32
  Scenario: Click Contact request in profile (Male account without subscribe)

    When Choose profile contain contact request button
    When Click "destinyBtn"
    Then Should see payment page

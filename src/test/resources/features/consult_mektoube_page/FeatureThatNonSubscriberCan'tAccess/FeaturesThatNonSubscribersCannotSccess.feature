Feature: Features that non subscribers cannot access

  Background:
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "lannt.man98@gmail.com" and password "Mektoubi2017"

  @TEST_QRA-71
  Scenario: click on a notification (not real time) redirects to the payment page (Male account without subscribe)
    When Wait until element "Messages" is visible
    When Click button "Messages"
    When Click on message unread
    Then Should see payment page

#  @TEST_QRA-69 FOR NOW NON-PRE USER CAN'T CLICK SEARCH ADVANCE >> SHOW MODAL QRA-968
#  Scenario: search by username redirects to the payment page (Male account without subscribe)
#
#    When Wait until element "SearchForm" is visible
#    When CLick filter by username
#    When Insert "sonya" into Field "SearchUserNameField"
#    When Click "ValidateBtn"
#    When Click "submitFilter"
#    Then Should see message popup at top "Vous devez souscrire à une offre pour accéder à cette fonctionnalité."
#    When Wait about 4 second
#    And Should see payment page

  @TEST_QRA-70
  Scenario: Read a message redirects to the payment page (Male account without subscribe)

    When Wait until element "Messages" is visible
    When Click "Messages"
    When Browser should redirect to "messages.url"
    When Click on message unread
    Then Should see payment page

  @TEST_QRA-358
  Scenario:  Avatar in message page is blur

    When Wait until element "Messages" is visible
    When Click "Messages"
    When Browser should redirect to "messages.url"
    Then Should see blur message

  @TEST_QRA-318
  Scenario: Add new "Prenez un Premium Pass" page

    When Wait until element "subscriptionsTexLink" is visible
    When Click "subscriptionsTexLink"
    When Redirect to link "https://www.mektoube.fr/main/subscriptions"
    When Scroll to "GotoPremiumPayment" and click
    Then Should see payment page

  @TEST_QRA-359
  Scenario: A non subscriber man can read service messages

    When Wait until element "Messages" is visible
    When Click "Messages"
    When Browser should redirect to "messages.url"
    Then Can read service messages


  @TEST_QRA-32
  Scenario: Click discussion in profile (Male account without subscribe)

    When Wait until element "Profile" is visible
    When Click on "Profile" which index is "0"
    When Click contact request or discuss button
    Then Should see payment page


  @TEST_QRA-354
  Scenario: Banner to be premuim in Notification page

    When Wait until element "NotificationTextLink" is visible
    When Click "NotificationTextLink"
    When Wait until element "ToBePremiumBanner" is visible
    When Click "ToBePremiumBanner"
    Then Should see payment page


  @TEST_QRA-968
  Scenario: Restrictions to non-premium members >>> Use the Advanced Search
    When I try to click "TheAdvancedSearch"
    Then Should see modal popup with message "Pour pouvoir utiliser la recherche avancée, prenez un Pass Mektoube."
    And Click "JYVAIS"
    Then Should see payment page

  @TEST_QRA-980
  Scenario: Restrictions to non-premium members >> Displaying other members picture full page
    When I try to see other members picture full page
    Then Should see modal popup with message "Pour pouvoir voir la galerie de photos, prenez un Pass Mektoube."
    And Click "JYVAIS"
    Then Should see payment page

  @TEST_QRA-981
  Scenario: Restrictions to non-premium members >>> Can't Visit more than 30 profiles per day and Smiler more than 10 profiles per day
    When I try to smile more than 10 profile
    Then Should see modal popup with message "Pour pouvoir smiler plus de profils, prenez un Pass Mektoube."
    And Click "JYVAIS"
    Then Should see payment page


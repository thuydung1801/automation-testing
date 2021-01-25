#  QRA-891 TEST SET

@QRA-137
Feature: Favorites page

  @TEST_QRA-129
  #QA-497

  Scenario: Click on favorites to see them
    Given Go to "ResponsivePreprod" url

    When Login with account "yassine_yes" and password "Mektoubi2017"
    When Wait about 1 second
    When Click "MonCompteButton"
    When Click "Favoris"
    Then Browser should redirect to "https://www.mektoube**.fr/main/my-account/favorite"
       #responsive-preprod
    #Then Browser should redirect to "https://responsive-preprod.ResponsivePreprod/main/my-account/favorite"

  @TEST_QRA-144
    #QA-492
  Scenario: add a profil in the favorites
    Given Go to "ResponsivePreprod" url

    When Login with account "yassine_yes" and password "Mektoubi2017"
    When Wait about 1 second
    When Click on first profile in discovery
    When Click "metarialInProfile"
    When Click "fv.add"
    When Wait about 3 second
    When Click "MonCompteButton"
    When Click "Favoris"
    When Scroll All page "profileItemFavorite"
    Then Checking above profile have to in favorite list

    #responsive-dev
    #Then Browser should redirect to "http://responsive-dev.ltservices.ovh/main/my-account/favorite"
  @TEST_QRA-130
  #QA-498
  Scenario: See his favorites online - the case existing profiles online
    Given Go to "ResponsivePreprod" url

    When Login with account "yassine_yes" and password "Mektoubi2017"
    When Wait about 1 second
    When Click "MonCompteButton"
    When Click "Favoris"
    When Scroll All page
    Then See his favorites online - the case existing profiles online
  @TEST_QRA-131
  #QA-499
  Scenario: See his favorites online - the case no profile online
    Given Go to "ResponsivePreprod" url

    When Login with account "yassine_yes" and password "Mektoubi2017"
    When Wait about 1 second
    When Click "MonCompteButton"
    When Click "Favoris"
    When Scroll All page
    Then See his favorites online - the case no profile online
  @TEST_QRA-132
  #QA-450
  Scenario: Visit a profile from the favorites page
    Given Go to "ResponsivePreprod" url

    When Login with account "yassine_yes" and password "Mektoubi2017"
    When Wait about 1 second
    When Click "MonCompteButton"
    When Click "Favoris"
    Then Visiting a profile from the favorites page
    #okok
  @TEST_QRA-133
  #QA-494
  Scenario: Add someone who is already in the favorites
    Given Go to "ResponsivePreprod" url

    When Login with account "yassine_yes" and password "Mektoubi2017"
    When Wait about 1 second
    When Click "MonCompteButton"
    When Click "Favoris"
    When Visiting a profile from the favorites page
    When Click "metarialinprofile"
#    old feature
#    When Click "fv.add"
#    Then Showing error message this profile already in your favorites
#    new feature
    Then The selection list contains "Supprimer de mes favoris" in line 1

    #ok
  @TEST_QRA-134
  #QA-493
  Scenario: Remove a profile in the favorites
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Click "MonCompteButton"
    When Click "Favoris"
    When Remove first profile from favoris list
    Then The favoris list do not show above profile
    #okok
  @TEST_QRA-135
  #QA-496
  Scenario: Blocked a person and try to add her in his favorites
    Given Go to "ResponsivePreprod" url

    When Login with account "yassine_yes" and password "Mektoubi2017"
    When Wait about 1 second
    When Click "MonCompteButton"
    When Click "Reglages"
    When Click on the element is "//h5[text()='Blackliste']" by xpath
    When Wait about 1 second
    When Click "firstProfileInBlackList"
    When Click "metarialinprofile"
    When Click "fv.add"
    Then The page shows "errorMessFP" error message

      #??, error db: http://prntscr.com/p73i4i=>ok
  @TEST_QRA-145
    #QA-495
  Scenario: add someone in his favorites whereas the person has blocked us
    Given Go to "ResponsivePreprod" url

    # shainez29 block Yassine_yes
    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 2 second
    When Scroll to view "AdvancedCriteria"
    When Scroll to view "nickname"
    When Insert "yassine_yes" into "nicknameTextfield" Field (upd)
    When Click "checkButton"
    When Click "validateButton"
    When Wait about 3 second
    When Click on the element is "//h5[text()='yassine_yes']" by xpath
    When Click "metarialinprofile"
    When Click "blockInProfile"
    When Wait about 3 second
    When Click "SignOutIcon"
#
    When Click "SeConnecter"
    When Insert "yassine_yes" into "usernameBtn" Field (upd)
    When Insert "Mektoubi2017" into "passwordBtn" Field (upd)
    When Click "loginBtn"
    When Wait about 2 second
    When Scroll to "AdvancedCriteria" and click
    When Scroll to "nickname" and click
    When Insert "alian98" into "nicknameTextfield" Field (upd)
    When Click "checkButton"
    When Click "validateButton"
    When Scroll All page "profileItemDiscover"
    Then The discovery page dont show "alian98"
    #un block yassine_yes
    And Click "SignOutIcon"
    And Click "SeConnecter"
    When Insert "shainez29" into "usernameBtn" Field (upd)
    When Insert "mektoube**" into "passwordBtn" Field (upd)
    When Click "loginBtn"
    When Click "MonCompte"
    When Click "Reglages"
    When Click on the element is "//h5[text()='Blackliste']" by xpath
    When Wait about 1 second
    When Click "more_vert"
    When Click "unBlockOption"
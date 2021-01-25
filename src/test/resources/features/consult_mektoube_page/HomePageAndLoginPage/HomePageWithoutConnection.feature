#QRA-895 test set
Feature: Homepage without connection

#  run again=>ok
  @TEST_QRA-125
  Scenario: Testing when click on text links NEW TAB 1
    Given Go to "ResponsivePreprod" url

    When Scroll Any Page "5000"
    When Click "Tribune"
    Then Browser should redirect to "http://mektoube-tribune.fr/" (new tab)
#    Examples:
#      |STT  | textLink | targetUrl |
#      | 1| Tribune     | http://mektoube-tribune.fr/ |
#      | 2| Presse      | http://mektoube-presse.fr/ |
#      | 3| AideTextLink             | https://aide.mektoube.fr/ |
#      | 4| Blog             | https://blog.mektoube.fr/ |
    #Tribune, Presse, Aide, Blog  :new tab
  @TEST_QRA-125
  Scenario: Testing when click on text links NEW TAB 2
    Given Go to "ResponsivePreprod" url

    When Scroll Any Page "5000"
    When Click "Presse"
    Then Browser should redirect to "http://mektoube-presse.fr/" (new tab)

  @TEST_QRA-125
  Scenario: Testing when click on text links NEW TAB 3
    Given Go to "ResponsivePreprod" url

    When Scroll Any Page "5000"
    When Click "AideTextLink"
    Then Browser should redirect to "https://aide.mektoube.fr/" (new tab)

  @TEST_QRA-125
  Scenario: Testing when click on text links NEW TAB 4
    Given Go to "ResponsivePreprod" url

    When Scroll Any Page "5000"
    When Click "Blog"
    Then Browser should redirect to "https://blog.mektoube.fr/" (new tab)

  @TEST_QRA-124
  #QA-649,650,651,652,653,654,655,656,657
  Scenario Outline: Testing when click on text links
    Given Go to "ResponsivePreprod" url

    When scroll to view "footerLogo" that dont click
    When Wait about 2 second
    When Click "<textLink>"
    Then Browser should redirect to "<targetUrl>"
    Examples:
      | textLink | targetUrl |
#      | Temoignages | https://www.ResponsivePreprod/temoignages |
#      | Contact     | http://www.ResponsivePreprod/contact |
#      | MentionsLegales | http://www.ResponsivePreprod/mentions-legales |
#      | Vieprivee       | http://www.ResponsivePreprod/charte-vie-privee |
#      | CGU              | http://www.ResponsivePreprod/cgu |

#      #preprod
      | Temoignages | https://www.mektoube.fr/temoignages |
      | Contact     | https://www.mektoube.fr/contact |
      | Mentionslegales | https://www.mektoube.fr/mentions-legales |
      | Vieprivee       | https://www.mektoube.fr/charte-vie-privee |
      | CGU              | https://www.mektoube.fr/cgu |
    #responsive
#      | Temoignages | http://responsive-dev.ltservices.ovh/temoignages |
#      | Contact     | http://responsive-dev.ltservices.ovh/contact |
#      | MentionsLegales | http://responsive-dev.ltservices.ovh/mentions-legales |
#      | Vieprivee       | http://responsive-dev.ltservices.ovh/charte-vie-privee |
#      | CGU              | http://responsive-dev.ltservices.ovh/cgu |
#

    #okok 11_10
#preprod dont have Discover All THe Stỏies
  @TEST_QRA-126
  #QA-658
  Scenario: Testing when click on découvrir toutes les histoires
    Given Go to "ResponsivePreprod" url
    When Scroll Any Page "2500"
    When Click "DiscoverAllTheStories"
    Then Browser should redirect to "https://www.mektoube.fr/temoignages"
#    Then Browser should redirect to "http://responsive-dev.ltservices.ovh/temoignages"
    #???
  @TEST_QRA-127
  #QA-659
  Scenario: Download links of the app
    Given Go to "ResponsivePreprod" url

    When scroll
    When Click "AppStore"
    Then Browser should redirect to "https://apps.apple.com/fr/app/mektoube-rencontre-musulmane/id465630898" (new tab)
#    Examples:
#      |STT| button | targetUrl |
#      |1| AppStore | https://apps.apple.com/fr/app/mektoube-rencontre-musulmane/id465630898 |
  @TEST_QRA-127
  Scenario: Download links of the app 2
    Given Go to "ResponsivePreprod" url

    When scroll
    When Click "GooglePlay"
    Then Browser should redirect to "https://play.google.com/store/apps/details?id=com.ltservices.mektoube&hl=fr" (new tab)
#    Examples:
#      |STT| button | targetUrl |
#      |1 | GooglePlay | https://play.google.com/store/apps/details?id=com.ltservices.mektoube&hl=fr |
  @TEST_QRA-128
  #QA-660,661
  Scenario: Testing when click on thumbnails
    Given Go to "ResponsivePreprod" url

    When Scroll Any Page "5000"
    When Click "Twitter"
    Then Browser should redirect to "https://twitter.com/mektoube?lang=fr" (new tab)
#    Examples:
#      |STT| thumbnail | targetUrl |
#      |1| Twitter | https://twitter.com/mektoube?lang=fr |
  @TEST_QRA-128
  Scenario: Testing when click on thumbnails
    Given Go to "ResponsivePreprod" url

    When Scroll Any Page "5000"
    When Click "Facebook"
    Then Browser should redirect to "https://fr-fr.facebook.com/MEKTOUBE/" (new tab)
#      |2| Facebook | https://fr-fr.facebook.com/MEKTOUBE/ |

  @TEST_QRA-348
  #QA-662
  Scenario: check that a user can scroll the testimonials without bug in the home page
    Given Go to "http://responsive-preprod.mektoube.fr/temoignages" url

    When Scroll the testimonials
    Then The page show number of testimonials

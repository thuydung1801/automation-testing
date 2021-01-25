@QRA-179
Feature: Discovery Page
#458

   #QA-477
  @TEST_QRA-178
  Scenario: Check that there is no duplicates profiles on the discovery
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
		    #When Scroll All page
    Then Checking that there is no duplicates profiles on the discovery
     #new 13_2_2020
#  @TEST_QRA-177
#  Scenario: Check a profile without connection point
#    Given Go to "ResponsivePreprod" url
#
#    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
#    When Wait about 3 second
#    Then Checking a profile without connection point
    #QA-476
  #new 13_2_2020
#  @TEST_QRA-176
#  Scenario: Check a profile with the orange connection point
#    Given Go to "ResponsivePreprod" url
#
#    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
#    When Wait about 1 second
#    Then Checking a profile with the orange connection point
#  #QA-475
#  #new 13_2_2020, maybe bug because relate search online (online search bug)
#  @TEST_QRA-175
#  Scenario: Check a profile with the green connection point
#    Given Go to "ResponsivePreprod" url
#
#    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
#    When Wait about 1 second
#    When Click "onlineRadio"
#    When Click "validateButton"
#    When Wait about 3 second
#    Then Checking a profile with the green connection point

    #QA-474
    #image have size different between get and see, vd: 68~101, 137~160
  @TEST_QRA-174
  Scenario: Check the size of profiles thumbnails
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
		    #When Scroll All page
    Then The picture have to correct size
  #QA-473
  @TEST_QRA-173
  Scenario: Check that profiles without photos are present in the discovery
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
   # When Scroll All page
    Then The number of profile that have not picture profile
      #QA-472
#  not yet 13_2_2020
#  @TEST_QRA-172
#  Scenario: See the good flag on profiles without photo
#    Given Go to "ResponsivePreprod" url
#
#    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
#    When Wait about 1 second
##    When Scroll All page
#    Then See the good flag

    #more thinking,??=>chi have this tc
    #QA-469
  @TEST_QRA-171
  Scenario: Login as a woman - scroll the discovery to see man profiles
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Click on first profile in discovery
    When Wait about 1 second
    Then The discovery page show all man profile

      #QA-471
  @TEST_QRA-170
  Scenario: Click on a profile
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Save id of profile is "firstProfileInDiscovery"
    When Click "firstProfileInDiscovery"
    Then Browser should redirect to this person
      #QA-470
  #same 171=>have solution
  @TEST_QRA-169
  Scenario: Login as a man - scroll the discovery to see woman profiles
    Given Go to "ResponsivePreprod" url

    When Login with account "yassine_yes2" and password "Mektoubi2017"
    When Wait about 1 second
    When Click on first profile in discovery
    When Wait about 2 second
    Then The discovery page show all woman profile

#    #done
#  Scenario: demo properties
#     Given Go to "ResponsivePreprod" url
#    When Wait about 1 second
#    When Click on the element "demo"
#    When Insert into "username" field with value "abc"

#  @TEST_QRA-367
#  Scenario: boosted profile in discovery
#    Given Go to "ResponsivePreprod" url
#
#    When Login with account "montassir931" and password "mektoube**"
#    When Wait about 1 second
#    When Check if content in Advertisement
#    When Click "AdvertisementBoostProfile"
#    When Wait about 2 second
#    When Check if content in modal show full
#    When Click confirm without input code
#    Then Should see red alert "Code d’accès est requis."
#    When Insert "45XHFFF" into Field ".simple-input input[type='text']"
#    When Click button ".form--actions.text-center button[class='mdc-button mdc-button--unelevated']"
#    Then Should see message popup at top "Code invalide"
#    When Click button ".form--actions.text-center button.mdc-button.mdc-button--outline.mdc-button--unelevated"
#    Then Allo pass modal is closed


@QRA-228
Feature: Research and Filters

  #ok
  #QA-579
  @TEST_QRA-191
  Scenario: save a search - click on annuler
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 3 second
    #When Click "onlineRadio"
    When Click "onlineRadio"
    When Wait about 2 second
    When Click "validateButton"
    When Wait about 2 second
    When Click "saveSearch"
    When Wait about 2 second
    When Click "cancelSaveSearch"

    #Then The page dont have any update

#  ##bug in responsive
#  @MyTest587
#  #QA-577_1
#  Scenario: save a search - leave the field space
#     Given Go to "ResponsivePreprod" url
#
#    When Click to link Se connecter
#    When Insert "thuyyylinhhh89@gmail.com" into "username" Field (upd)
#    When Insert "mektoube**" into "password" Field (upd)
#    When Click Login button
#    When Click "onlineRadio"
#    When Click "validateButton"
#    When Wait about 1 second
#    When Click "saveSearchResult"
#    When Insert " " into "nameOfSearch" Field (upd)
#    When Click "okButton"
#    Then The popup show error message line

  #ok=>faild because not yet check space
  @TEST_QRA-192
  #QA-577
  Scenario: save a search - leave the field blank
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 3 second
    When Click "onlineRadio"
    When Click "validateButton"
    When Wait about 2 second
    When Click "saveSearch"
    When Click "okButton"
    Then The popup show error message line
    When Insert " " into "nameOfSearch" Field (upd)
    When Click "okButton"
    Then The popup show error message line
#ok=>oko10_11
  @TEST_QRA-193
  #QA-523
    #search online save with name= onlineList=> click onlineList=>delete onlineList
  Scenario: see and click on a saved search
    Given Go to "ResponsivePreprod" url

    When Login with account "linhlinhttt98@gmail.com" and password "mektoube**"
    When Click "onlineRadio"
    When Click "validateButton"
    When Wait about 1 second
    When Click "saveSearch"
    When Insert "online profile list" into "nameOfSearch" Field (upd)
    When Wait about 1 second
    When Click "okButton"
    When Click "opensearchResultSaveList"
    When Click on the element is "//h5[text()='online profile list']" by xpath
    #When Scroll All page
    When Wait about 2 second
    Then The page show users that have online
    And Click "firstOptionsInSavedSearch"
    And Wait about 1 second
    And Click "removeOption"

    #not yet=>ok, 28_11
  @TEST_QRA-205
  #QA-525
  Scenario: the button reset works
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Click "resetFilter"
    #cant click on Refine my search ??
    Then The filter is reseted
    Then The age label dont show age range
    Then The "Pseudo" label dont show "PseudoText"
    Then The "LevelOfStudy" label dont show "LevelOfStudyText"
    Then The "Smoking" label dont show "SmokingChoiceText"
    Then The "Children" label dont show "ChildrenText"
    Then The "FamilySituation" label dont show "FamilySituationText"
    Then The "silhouette" label dont show "silhouetteText"
    Then The size label dont show size
    #####need check again
    Then The country label dont show country
    Then The origin label dont show origin
    #con 1 cai nua: Region
    Then The "Region" label dont show "RegionText"

#ok
  @TEST_QRA-194
  #QA-524
  Scenario: remove a search
    Given Go to "ResponsivePreprod" url
    When Wait about 2 second

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Click "onlineRadio"
    When Click "validateButton"
    When Wait about 2 second
    When Click "saveSearch"
    When Insert "online profile list" into "nameOfSearch" Field (upd)
    When Wait about 1 second
    When Click "okButton"
    When Click "opensearchResultSaveList"
#    When Click on the material icon of element is "//h5[text()='online profile list']" by xpath
    When Click on special element is "firstMoreVert"
    When Wait about 4 second
    When Click "removeASearch"
    Then The page show notification and dont show in this search result

  #DONE 11_9_2020
  @TEST_QRA-195
  #QA-526
  Scenario: edit a search
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    #When Wait until element "onlineRadio" is visible
    When Click "onlineRadio"
    When Click "validateButton"
    When Wait about 1 second
    When Click "saveSearch"
    When Insert "online profile list" into "nameOfSearch" Field (upd)
    When Wait about 2 second
    When Click "okButton"
    When Wait about 7 second
    When Click "opensearchResultSaveList"
    When Click on special element is "firstMoreVert"
    When Wait about 1 second
    When Click "editASearch"
    When Click "closesearchResultSaveList"
    When Click "onlineRadio" if it is disable
    When Click "FinishEditing"
    When Wait about 2 second
    Then The page show notification Edited filter
    And Click "opensearchResultSaveList"
    When Click "firstResultSearch"
    When Wait about 1 second
    Then The page show users that have online
    When Click on special element is "firstMoreVert"
    When Wait about 2 second
    When Click "removeASearch"


  #DONE
  @TEST_QRA-229
  #QA-527
  Scenario: rename a search
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Click "opensearchResultSaveList"
    When Click "firstMoreVert"
    When Wait about 1 second
    When Click "renameASearch"
    When Clear text from field "nameOfSearch"
    When Insert "updateName" into "nameOfSearch" Field (upd)
    When Click "okButton"
    When Wait about 2 second
    Then The page show notification Edited filter
    And Checking in save list have edited name "updateName"


  #DONE
  @TEST_QRA-230
  #QA-528
  Scenario: search "En ligne"
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Click "onlineRadio"
    When Click "validateButton"
    When Wait about 2 second
    When Scroll All page
    Then The page show users that have online


  #DONE
  @TEST_QRA-231
  #QA-531
  Scenario: search "c'est leur anniversaire aujourd'hui"
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Scroll to view "haveBirthdayToday"
    When Click "haveBirthdayToday"
    When Click "validateButton"
    Then The page show all profile have birthday today


   #DONE
  @TEST_QRA-232
    #QA-532
  Scenario: search by age - select a choice and validate
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Scroll to "advancedCriteria" and click
    When Click "ageLabel"
    When Wait about 1 second
    When Set up age range from 18 to 18
    When Click "validateAge"
    When Click "validateButton"
    When Wait about 1 second
    When Scroll All page
    When The page show all profile that have age range from 18 to 18


  #DONE
  @TEST_QRA-233
    # QA-533
  Scenario: search by age - select a choice and click on exit
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Scroll to "advancedCriteria" and click
    When Click "ageLabel"
    When Wait about 1 second
    When Set up age range from 19 to 98
    When Click "closeAge"
    Then The age label dont show age range


  #BUG
  @TEST_QRA-234
    #  QA-534
  Scenario: search by "avec photo"
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Scroll to "advancedCriteria" and click
    When Click "withPicture"
    When Click "validateButton"
    When Wait about 2 second
    When Scroll All page
    Then The page show all profiles that have picture profile


  #DONE
  @TEST_QRA-235
    #QA-535
  Scenario: search by origin - select a choice and validate
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Scroll to "advancedCriteria" and click
    When Click "OriginLabel"
    When Wait about 1 second
    When Click "firstRadioOrigin"
    When Click "checkOrigin"
    When Click "validateButton"
    When Wait about 1 second
    Then The page show all profile that have above origin


  @TEST_QRA-236
  #QA-536
  Scenario: search by origin - select a choice and click on exit
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Scroll to "advancedCriteria" and click
    When Click "OriginLabel"
    When Wait about 1 second
    When Click "firstRadioOrigin"
    When Click "closeOrigin"
    Then The origin label dont show origin


  @TEST_QRA-237
  #QA-537
  Scenario: search by origin - click on exit
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Wait about 2 second
    When Scroll to "advancedCriteria" and click
    When Click "OriginLabel"
    When Click "closeOrigin"
    Then The origin label dont show origin


  @TEST_QRA-238
  #QA-538
  Scenario: search by origin - only one choice can be selected
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Scroll to "advancedCriteria" and click
    When Click "OriginLabel"
    When Wait about 1 second
    When Click "firstRadioOrigin"
    When Click "secondRadioOrigin"
    Then The page only one choice can be selected


  @TEST_QRA-250
    #QA-540
  Scenario: search by country - only one choice can be selected
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Wait about 2 second
    When Scroll to "advancedCriteria" and click
    When Click "CountryLabel"
    When Wait about 1 second
    When Click "firstRadioCountry"
    When Click "secondRadioCountry"
    Then The page only one choice can be selected


  @TEST_QRA-251
  #QA-541
  Scenario: search by country - select a choice and click on exit
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Scroll to "advancedCriteria" and click
    When Click "CountryLabel"
    When Wait about 1 second
    When Click "firstRadioCountry"
    When Click "closeCountry"
    Then The country label dont show country


  @TEST_QRA-252
    #QA-542
  Scenario: search by country - click on exit
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Scroll to "advancedCriteria" and click
    When Click "CountryLabel"
    When Click "closeCountry"
    Then The country label dont show country
    #    //waiting for bug 1248 res done after check again=> maybe done, but find a bug with thuyyylinhhh89@gmail.com account

  #DONE
  @TEST_QRA-253
    #QA-547
  Scenario: search by size - select a choice and validate
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Scroll to "advancedCriteria" and click
    When Click "SizeLabel"
    When Set up size from 170 cm to 170 cm
    When Wait about 2 second
    When Click "checkPopup"
    When Click "validateButton"
    When Wait about 3 second
    When Click on first profile in discovery
    When Wait about 1 second
    Then The page show all profile that have size from 170 cm to 170 cm


  @TEST_QRA-254
  #  QA-548
  Scenario: search by size - click on exit
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Scroll to "advancedCriteria" and click
    When Click "SizeLabel"
    When Click "closePopup"
    Then The size label dont show size


  #BUG
  @TEST_QRA-255
  #QA-549
  Scenario: search by "silhouette" - select a choice and validate
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 2 second
    When Scroll to "advancedCriteria" and click
    When Wait about 1 second
    When Scroll to "SilhouetteLabel" and click
    When Wait about 1 second
    When Click "thirdRadio"
    When Click "checkPopup"
    When Click "validateButton"
    When Wait about 1 second
    Then The page show all profile that have above silhouette


  @TEST_QRA-256
    #QA-550
  Scenario: search by "silhouette" - select a choice and click on exit
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Scroll to "advancedCriteria" and click
    When Wait about 1 second
    When Scroll to "SilhouetteLabel" and click
    When Wait about 1 second
    When Click "firstRadio"
    When Click "closePopup"
    Then The size label dont show size


  @TEST_QRA-257
  #QA-551
  Scenario: search by "silhouette" - only one choice can be selected
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Scroll to "advancedCriteria" and click
    When Wait about 1 second
    When Scroll to "SilhouetteLabel" and click
    When Wait about 1 second
    When Click "firstRadio"
    When Click "secondRadio"
    Then The page only one choice can be selected


  @TEST_QRA-258
  #QA-552
  Scenario: search by "silhouette" - click on exit
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 2 second
    When Scroll to "advancedCriteria" and click
    When Wait about 1 second
    When Scroll to "SilhouetteLabel" and click
    When Wait about 1 second
    When Click "closePopup"
    Then The "silhouette" label dont show "silhouetteText"


  @TEST_QRA-259
  #QA-553
  Scenario: search by familial situation - click on exit
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Scroll to "advancedCriteria" and click
    When Wait about 1 second
    When Scroll to "FamilySituationLabel" and click
    When Wait about 1 second
    When Click "closePopup"
    Then The "FamilySituation" label dont show "FamilySituationText"


  @TEST_QRA-260
  #QA-554
  Scenario: search by familial situation - only one choice can be selected
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Wait about 2 second
    When Scroll to "advancedCriteria" and click
    When Wait about 1 second
    When Scroll to "FamilySituationLabel" and click
    When Wait about 1 second
    When Click "firstRadio"
    When Click "secondRadio"
    Then The page only one choice can be selected


  @TEST_QRA-261
  #QA-555
  Scenario: search by familial situation - select a choice and click on exit
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Scroll to "advancedCriteria" and click
    When Wait about 1 second
    When Scroll to "FamilySituationLabel" and click
    When Wait about 1 second
    When Click "firstRadio"
    When Click "closePopup"
    Then The "FamilySituation" label dont show "FamilySituationText"


  @TEST_QRA-262
  #QA-557
  Scenario: search by "enfants" - only one choice can be selected
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Scroll to "advancedCriteria" and click
    When Wait about 1 second
    When Scroll to "ChildrenLabel" and click
    When Wait about 1 second
    When Click "firstRadio"
    When Click "secondRadio"
    Then The page only one choice can be selected

  #DONE
  @TEST_QRA-263
  #QA-558
  Scenario: search by "enfants"- select a choice and validate
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Scroll to "advancedCriteria" and click
    When Wait about 1 second
    When Scroll to "ChildrenLabel" and click
    When Wait about 1 second
    When Click "firstRadio"
    When Click "checkPopup"
    When Click "validateButton"
    When Wait about 1 second
    Then The page show all profile that have above choiced children


  @TEST_QRA-264
  #QA-559
  Scenario: search by "enfants"- select a choice and click on exit
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    #scroll and click
    When Scroll to "advancedCriteria" and click
    When Wait about 1 second
      #scroll and click
    When Scroll to "ChildrenLabel" and click
    When Wait about 1 second
    When Click "firstRadio"
    When Click "closePopup"
    Then The "Children" label dont show "ChildrenText"


  @TEST_QRA-265
    #QA-560
  Scenario: search by "enfants" - click on exit
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
      #scroll and click
    When Scroll to "advancedCriteria" and click
    When Wait about 1 second
        #scroll and click
    When Scroll to "ChildrenLabel" and click
    When Wait about 1 second
    When Click "closePopup"
    Then The "Children" label dont show "ChildrenText"

  #DONE
  @TEST_QRA-266
    #QA-561
  Scenario: search by "pratiquant" - select a choice and validate
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Scroll to "advancedCriteria" and click
    When Wait about 1 second
    When Scroll to "PratiquantLabel" and click
    When Wait about 1 second
    When Click "fourRadio"
    When Click "checkPopup"
    When Click "validateButton"
    When Wait about 1 second
    Then The page show all profile that have above pratiquant


  @TEST_QRA-269
  #QA-562
  Scenario: search by "pratiquant" - select a choice and click on exit
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 2 second
    When Scroll to "advancedCriteria" and click
    When Wait about 1 second
    When Scroll to "PratiquantLabel" and click
    When Wait about 1 second
    When Click "thirdRadio"
    When Click "closePopup"
    Then The "Children" label dont show "ChildrenText"


  @TEST_QRA-270
  #QA-563
  Scenario: search by "pratiquant" - click on exit
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 2 second
    When Scroll to "advancedCriteria" and click
    When Wait about 1 second
    When Scroll to "PratiquantLabel" and click
    When Wait about 1 second
    When Click "closePopup"
    Then The "Children" label dont show "ChildrenText"


  @TEST_QRA-271
  #QA-564
  Scenario: search by "pratiquant" - only one field can be selected
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 2 second
    When Scroll to "advancedCriteria" and click
    When Wait about 1 second
    When Scroll to "PratiquantLabel" and click
    When Wait about 1 second
    When Click "firstRadio"
    When Click "secondRadio"
    Then The page only one choice can be selected


  @TEST_QRA-272
    #QA-565
  Scenario: search by "fume" - only one field can be selected
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Scroll to "advancedCriteria" and click
    When Wait about 1 second
    When Scroll to "SmokingLabel" and click
    When Wait about 1 second
    When Click "firstRadio"
    When Click "secondRadio"
    Then The page only one choice can be selected


  @TEST_QRA-273
  #QA-566
  Scenario: search by "fume" - select a choice and validate
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Scroll to "advancedCriteria" and click
    When Wait about 1 second
    When Scroll to "SmokingLabel" and click
    When Wait about 1 second
    When Click "firstRadio"
    When Click "checkPopup"
    When Click "validateButton"
    When Wait about 3 second
    Then The page show all profiles that have above smoking choice


  @TEST_QRA-274
  #QA-568
  Scenario: search by "fume" - click on exit
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Scroll to "advancedCriteria" and click
    When Wait about 1 second
    When Scroll to "SmokingLabel" and click
    When Wait about 1 second
    When Click "closePopup"
    Then The "Smoking" label dont show "SmokingChoiceText"


  @TEST_QRA-276
    #QA-569 level of studies
  Scenario: search by "niveau d'études " - only one field can be selected
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Scroll to "advancedCriteria" and click
    When Wait about 1 second
    When Scroll to "LevelOfStudyLabel" and click
    When Wait about 1 second
    When Click "firstRadio"
    When Click "secondRadio"
    Then The page only one choice can be selected


  @TEST_QRA-277
  #QA-570
  Scenario: search by "niveau d'études " - select a choice and validate
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Wait about 2 second
    When Scroll to "advancedCriteria" and click
    When Wait about 1 second
    When Scroll to "LevelOfStudyLabel" and click
    When Wait about 1 second
    When Click "fourRadio"
    When Click "checkPopup"
    When Click "validateButton"
    When Wait about 3 second
    Then The page show all profiles that have above level of study


  @TEST_QRA-278
  #QA-571
  Scenario: search by "niveau d'études " - select a choice and click on exit
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Scroll to "advancedCriteria" and click
    When Wait about 1 second
    When Scroll to "LevelOfStudyLabel" and click
    When Wait about 1 second
    When Click "fourRadio"
    When Wait about 1 second
    When Click "closePopup"
    When Wait about 1 second
    Then The "LevelOfStudy" label dont show "LevelOfStudyText"


  @TEST_QRA-279
  #QA-572
  Scenario: search by "niveau d'études " - click on exit
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Scroll to "advancedCriteria" and click
    When Wait about 1 second
    When Scroll to "LevelOfStudyLabel" and click
    When Wait about 1 second
    When Click "closePopup"
    Then The "LevelOfStudy" label dont show "LevelOfStudyText"


  @TEST_QRA-280
  #QA-573
  Scenario: search by pseudo - click on exit
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
            #scroll and click
    When Scroll to "advancedCriteria" and click
    When Wait about 1 second
              #scroll and click
    When Scroll to "PseudoLabel" and click
    When Wait about 1 second
    When Click "closePopup"
    Then The "Pseudo" label dont show "PseudoText"


  #QA-575
  @TEST_QRA-281
  Scenario: search by "pseudo" with an exiting pseudo
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Scroll to "advancedCriteria" and click
    When Wait about 1 second
    When Scroll to "PseudoLabel" and click
    When Wait about 1 second
    When Insert "linda" into "nicknameTextfield" Field (upd)
    When Click "checkPopup"
    When Click "validateButton"
    When Wait about 1 second
    Then The page show all profile that have above entered name


  #QA-574
  @TEST_QRA-380
  Scenario: search by pseudo - validate without fill the field
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait until element "advancedCriteria" is visible
    When Scroll to "advancedCriteria" and click
    When Wait about 1 second
    When Scroll to "PseudoLabel" and click
    When Wait about 1 second
    When Click "checkPopup"
    Then The popup shows red error message


  #QA-544
  @TEST_QRA-301
  Scenario: search by "region" - select a choice and click on exit
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Scroll to "advancedCriteria" and click
    When Click "CountryLabel"
    When Wait about 1 second
    #Italy
    When Click "thirdRadio"
    When Click "checkPopup"
    When Wait about 1 second
    When Click "RegionLabel"
    When Wait about 1 second
    When Click "firstRadio"
    When Click "closePopup"
    Then The "Region" label dont show "RegionText"
    And The Coutry label show Country Text

  #QA-545
  @TEST_QRA-302
  Scenario: search by "region" - click on exit
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Scroll to "advancedCriteria" and click
    When Click "CountryLabel"
    When Wait about 1 second
    #Italy
    When Click "thirdRadio"
    When Click "checkPopup"
    When Wait about 1 second
    When Click "RegionLabel"
    When Wait about 1 second
    When Click "closePopup"
    Then The "Region" label dont show "RegionText"
    And The Coutry label show Country Text

  #QA-546
  @TEST_QRA-303
  Scenario: search by "region" - only one choice can be selected
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Scroll to "advancedCriteria" and click
    When Click "CountryLabel"
    When Wait about 1 second
    #Italy
    When Click "thirdRadio"
    When Click "checkPopup"
    When Wait about 1 second
    When Click "RegionLabel"
    When Wait about 1 second
    When Click "firstRadio"
    When Click "secondRadio"
    Then The page only one choice can be selected

  #QA-556
  #faild because bug system RES-808,1366==>ok done 21/4,ok 1/6/2020
  #disvoice and no children
  #DONE
  @TEST_QRA-332
  Scenario: search by familial situation - select a choice and validate
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Scroll to "advancedCriteria" and click
    When Scroll to "familySituationLabel" and click
    When Wait about 2 second
    When Click "thirdRadio"
    When Click "checkPopup"
    When Scroll to "ChildrenLabel" and click
    When Wait about 1 second
    When Click "firstRadio"
    When Click "checkPopup"
    When Click "validateButton"
    When Wait about 2 second
    Then The page show all profile that have above family situation


  #QA-522
  #DONE
  @TEST_QRA-349
  Scenario: save a search and disconnect/reconnect
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 2 second
    When Click "onlineRadio"
    When Click "validateButton"
    When Wait about 2 second
    When Click "saveSearch"
    When Insert "updName" into "nameOfSearch" Field (upd)
    When Click "okButton"
    When Wait about 5 second
    When Click "SignOutIcon"
    When Click "SeConnecter"
    When Insert "thuyyylinhhh89@gmail.com" into "usernameBtn" Field (upd)
    When Insert "mektoube**" into "passwordBtn" Field (upd)
    When Click "loginBtn"
    When Wait about 2 second
    When Click "searchResultSaveList"
    Then The page show name in search list is "updName"
    When Click on special element is "firstMoreVert"
    When Wait about 2 second
    When Click "removeASearch"

  ####bug with Italy, have some city not match
    # #not yet=>ok
    #wait to update ticket
  #check citys of country
  #city in web not match with real data=>okok
#  @TEST_QRA-366
#  #QA-539
#  Scenario: search by country - select a choice and validate with Italy
#    Given Go to "ResponsivePreprod" url
#
#    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
 #   When Wait about 1 second
#    When Scroll to "advancedCriteria" and click
#    When Click "CountryLabel"
#    When Wait about 1 second
#    #Italy
#    When Click "thirdRadio"
#    When Click "checkPopup"
#    When Wait about 1 second
#    When Click "validateButton"
#    When Wait about 1 second
#    #When Scroll All page
#    Then The page show all profile that have above country

    #not yet, dont have data, wait raj
#check France, man account
  #QA-539

#  Scenario: search by country - select a choice and validate with France
#     Given Go to "ResponsivePreprod" url
#
#    When Click to link Se connecter
#    When Insert "thuyyylinhhh89@gmail.com" into "username" Field (upd)
#    When Insert "mektoube**" into "password" Field (upd)
#    When Click Login button
#    When Scroll to "advancedCriteria" and click
#    When Click "CountryLabel"
#    When Wait about 1 second
#    #Italy
#    When Click "firstRadio"
#    When Click "checkPopup"
#    When Wait about 1 second
#    When Click "validateButton"
#    When Wait about 1 second
#    When Scroll All page
#    Then The page show all profile that have above country is France

  @TEST_QRA-441
  Scenario: Enter space/empty in search by name
    Given Go to "ResponsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Wait about 1 second
    When Scroll to "advancedCriteria" and click
    When Wait about 1 second
    When Scroll to "PseudoLabel" and click
    When Wait about 1 second
    When Click "checkPopup"
    Then The search name pop up show error message "Le Pseudo ne peut pas être vide"
    And Refresh page
    When Scroll to "advancedCriteria" and click
    When Wait about 1 second
    When Scroll to "PseudoLabel" and click
    When Wait about 1 second
    When Insert " " into "nicknameTextfield" Field (upd)
    Then The search name pop up show error message "Le Pseudo ne peut pas être vide"


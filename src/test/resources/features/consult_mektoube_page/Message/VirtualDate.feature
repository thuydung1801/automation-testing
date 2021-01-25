Feature: Virtual Date

  Background:
    Given Go to "ResponsiveIntroduction.url" url


  @TEST_QRA-969
    Scenario: profile that online, click conversation >> have cup icon

      When Login with account "yassine_yes2" and password "Mektoubi2017"
      When Wait about 2 second
      When Click "SignOutIcon"
      When Login with account "linh@gmail.com" and password "mektoube"
      When Search account "yassine_yes2"
      When Select the profile has name "yassine_yes2" that we are searching
      When Wait until element "Discuss" is visible
      When Click "Discuss"
      When Wait about 2 second
      Then Should show cup icon in conversation


  @TEST_QRA-970
    Scenario: click "En savoir plus" near cup icon >> show pop up

      When Login with account "yassine_yes2" and password "Mektoubi2017"
      When Wait about 2 second
      When Click "SignOutIcon"
      When Login with account "linh@gmail.com" and password "mektoube"
      When Search account "yassine_yes2"
      When Select the profile has name "yassine_yes2" that we are searching
      When Wait until element "Discuss" is visible
      When Click "Discuss"
      When Wait about 2 second
      When Click "cupIcon"
      When Click on the element is "//a[text()='En savoir plus']" by xpath
      Then The page show virtual date information pop up


  @TEST_QRA-971
  Scenario: click "Je propose un rendez-vous virtuel" and "Annuler l'invitation"

    When Login with account "yassine_yes2" and password "Mektoubi2017"
    When Wait about 2 second
    When Click "SignOutIcon"
    When Login with account "linh@gmail.com" and password "mektoube"
    When Search account "yassine_yes2"
    When Select the profile has name "yassine_yes2" that we are searching
    When Wait until element "Discuss" is visible
    When Click "Discuss"
    When Wait about 2 second
    When Click "cupIcon"
    When Click "div.virtualdate-submit button"
    Then The page show green notification is "Votre invitation de rendez-vous virtuel est envoyée" at "div.top-message-text div"
    When Click "cupIcon"
    When Click "div.virtualdate-submit button"
    Then The page show green notification is "L’invitation a bien été annulée" at "div.top-message-text div"


  @TEST_QRA-972
  Scenario: send a virtual date >> receiver show accept/refuse popup And click "En savoir plus" at accept/refuse pop up

    When Login with account "yassine_yes2" and password "Mektoubi2017"
    When Wait about 2 second
    When Click "SignOutIcon"
    When Login with account "linh@gmail.com" and password "mektoube"
    When Search account "yassine_yes2"
    When Select the profile has name "yassine_yes2" that we are searching
    When Wait until element "Discuss" is visible
    When Click "Discuss"
    When Wait about 2 second
    When Click "cupIcon"
    When Click "div.virtualdate-submit button"
    When Wait about 4 second
    When Click "SignOutIcon"
    When Login with account "yassine_yes" and password "Mektoubi2017"
    When Search account "thuylinh"
    When Select the profile has name "thuylinh" that we are searching
    When Wait until element "Discuss" is visible
    When Click "Discuss"
    Then The page show accept/refuse popup
    And Click "a.read-more"
    Then The page show virtual date information pop up
    And Click "div[class='photo-info--modal virtualdate-info--modal modal is--opened'] i.material-icons"
    And Click "SignOutIcon"
    When Login with account "linh@gmail.com" and password "mektoube"
    When Search account "yassine_yes"
    When Select the profile has name "yassine_yes" that we are searching
    When Wait until element "Discuss" is visible
    When Click "Discuss"
    When Wait about 2 second
    When Click "cupIcon"
    And Click "div.virtualdate-submit button"


  @TEST_QRA-973
  Scenario: send a virtual date >> receiver show object "Invitation rendez-vous v..."

    When Login with account "linhlinhttt98@gmail.com" and password "mektoube"
    When Wait about 2 second
    When Click "SignOutIcon"
    When Login with account "yassine_yes" and password "Mektoubi2017"
    When Search account "linh"
    When Select the profile has name "linh" that we are searching
    When Wait until element "Discuss" is visible
    When Click "Discuss"
    When Wait about 2 second
    When Click "cupIcon"
    When Click "div.virtualdate-submit button"
    When Wait about 4 second
    When Click "SignOutIcon"
    When Login with account "linhlinhttt98@gmail.com" and password "mektoube"
    When Wait until element "Messages" is visible
    When Click "Messages"
    #note change id for first message before run code
    Then The message page show object at first thread "☕ Invitation rendez-vous vi..."
#    And Click "SignOutIcon"
#    When Login with account "linh@gmail.com" and password "mektoube"
#    When Search account "yassine_yes2"
#    When Select the profile has name "yassine_yes2" that we are searching
#    When Wait until element "Discuss" is visible
#    When Click "Discuss"
#    When Wait until element "cupIcon" is visible
#    When Click "cupIcon"
#    And Click "div.virtualdate-submit button"


  #this test case depends on the test case above
  @TEST_QRA-974
  Scenario: accept virtual date >> clock chat thread and show count down

    When Login with account "linhlinhttt98@gmail.com" and password "mektoube"
    When Search account "yassine_yes"
    When Select the profile has name "yassine_yes" that we are searching
    When Wait until element "Discuss" is visible
    When Click "Discuss"
#    When Wait until element "AcceptVirtualDateButton" is visible
#    When Click "AcceptVirtualDateButton"
    Then The page change to virtual date mode "yassine_yes", "Mektoubi2017"
    And The page change to virtual date mode "linhlinhttt98@gmail.com", "mektoube"


    #this test case depends on the test case above
  @TEST_QRA-975
  Scenario: click discuss button in Contact Request (man account) >> redirect to message with partner virtual date

    When Login with account "yassine_yes" and password "Mektoubi2017"
    When Click "CroisezVosDestins"
    When Click "firstDiscussButton"
    When The page redirect to conversation with account name "linh"


    #this test case depends on the test case above
  @TEST_QRA-976
  Scenario: end virtual date, click Annuler

    When Login with account "linhlinhttt98@gmail.com" and password "mektoube"
    When Click "Messages"
    When Click "FirstMessageInMessageThread"
    When Click "EndVirtualDate"
    When Click "CancelEndVirtualDate"
    Then The page change to virtual date mode "yassine_yes", "Mektoubi2017"
    And The page change to virtual date mode "linhlinhttt98@gmail.com", "mektoube"


    #this test case depends on the test case above
  @TEST_QRA-977
  Scenario:  end virtual date, click Confirm

    When Login with account "linhlinhttt98@gmail.com" and password "mektoube"
    When Click "Messages"
    When Click "FirstMessageInMessageThread"
    #When Click "EndVirtualDate"
    #When Click "ConfirmEndVirtualDate"
    Then Show noti in conversation "Vous avez mis fin au rendez-vous virtuel, vous pourrez renvoyer une invitation dans 24h."
    #And The page show green notification is "<string>" at "div.top-message-text div"
    When Wait about 4 second
    When Click "SignOutIcon"
    When Login with account "yassine_yes" and password "Mektoubi2017"
    When Click "Messages"
    When Click "FirstMessageInMessageThread"
    Then Show noti in conversation "a mis fin à votre rendez-vous virtuel, rassurez-vous : vous pouvez continuer à discuter. Mais il faudra attendre 24h avant de demander un autre rendez-vous virtuel 😉"


    #this test case depends on the test case above
  @TEST_QRA-978
  Scenario: continue send virtual date to person that just end virtual date

    When Login with account "linhlinhttt98@gmail.com" and password "mektoube"
    When Search account "yassine_yes"
    When Select the profile has name "yassine_yes" that we are searching
    When Wait until element "Discuss" is visible
    When Click "Discuss"
    When Click "cupIcon"
    Then Show noti in alert that contains "a mis fin à votre rendez-vous virtuel, vous pourrez lui renvoyer une invitation dans 24h."

    #chua chay thu
  @TEST_QRA-979
  Scenario: refuse virtual date

    When Login with account "brandon92500" and password "Mektoubi2017"
    When Wait about 2 second
    When Click "SignOutIcon"
    When Login with account "shainez29" and password "mektoube"
    When Search account "brandon92500"
    When Select the profile has name "brandon92500" that we are searching
    When Wait until element "Discuss" is visible
    When Click "Discuss"
    When Wait about 2 second
    When Click "cupIcon"
    When Click "div.virtualdate-submit button"
    When Wait about 4 second
    When Click "SignOutIcon"
    When Login with account "brandon92500" and password "Mektoubi2017"
    When Search account "shainez29"
    When Select the profile has name "shainez29" that we are searching
    When Wait until element "Discuss" is visible
    When Click "Discuss"
    When Wait about 2 second
    When Click "RefuseVirtualDateButton"
   # Then The page show green notification is "<string>" at "<string>"
    Then Show noti in conversation "Vous avez refusé la proposition de rendez-vous virtual"
    When Wait about 4 second
    When Click "SignOutIcon"
    When Login with account "shainez29" and password "mektoube"
    When Search account "brandon92500"
    When Select the profile has name "brandon92500" that we are searching
    When Wait until element "Discuss" is visible
    When Click "Discuss"
    Then Show noti in conversation "a décliné votre proposition pour le moment, renvoyez lui une invitation plus tard"





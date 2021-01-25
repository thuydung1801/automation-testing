Feature: Ephemeral Picture

  Background:
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "brandon92500" and password "Mektoubi2017"
    When Search account "Emna98"
    When Select the profile has name "Emna98" that we are searching
    When Wait until element "Discuss" is visible
    When Click "Discuss"

  @TEST_QRA-373
  Scenario: report a ephemeral picture
    When Upload ephemeral picture
    When Logout current male account
    When Wait about 3 second
    When Login with account "lantiu@gmail.com" and password "mektoube**"
    When Search account "brandon92500"
    When Select the profile has name "brandon92500" that we are searching
    When Wait until element "Discuss" is visible
    When Click "Discuss"
    When Wait about 3 second
    When Wait until element "LastEphemeralPicture" is visible
    When Click "LastEphemeralPicture"
    Then Should see the second ephemeral picture
    When Wait about 12 second
    When Click "MessageOptions"
    When Click "ReportPictureFlag"
    When Click "CancelReportModal"
    Then Should see report a ephemeral picture modal close
    When Click "MessageOptions"
    When Click "ReportPictureFlag"
    When Click "ValidateReport"
    Then Should see message popup at top "Votre signalement a été pris en compte"

  @TEST_QRA-374
  Scenario: ephemeral picture: Send double pictures >> if receiver click "X" in first picture, the second one will loading endless

    When Upload ephemeral picture
    When Upload ephemeral picture
    When Logout current male account
    When Wait about 3 second
    When Login with account "lantiu@gmail.com" and password "mektoube**"
    When Search account "brandon92500"
    When Select the profile has name "brandon92500" that we are searching
    When Wait until element "Discuss" is visible
    When Click "Discuss"
    When See the first ephemeral picture and click close
    When Click "LastEphemeralPicture"
    Then Should see the second ephemeral picture

  @TEST_QRA-513
  Scenario: ephemeral picture: Check status read/ unread
    When Upload ephemeral picture
    When Logout current male account
    When Wait about 3 second
    When Login with account "lantiu@gmail.com" and password "mektoube**"
    When Search account "brandon92500"
    When Select the profile has name "brandon92500" that we are searching
    When Wait until element "Discuss" is visible
    When Click "Discuss"
    When Wait until element "LastEphemeralPicture" is visible
    When Click "LastEphemeralPicture"
    Then Should see the second ephemeral picture
    When Wait about 10 second
    When Logout current female account
    When Wait about 3 second
    When Login with account "brandon92500" and password "Mektoubi2017"
    When Search account "Emna98"
    When Select the profile has name "Emna98" that we are searching
    When Wait until element "Discuss" is visible
    When Click "Discuss"
    Then Check if status of read message picture is right



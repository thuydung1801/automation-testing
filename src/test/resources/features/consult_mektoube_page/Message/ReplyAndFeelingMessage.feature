Feature: Reply / Feeling message

  @TEST_QRA-
  Scenario: Reply last gif message by a gif,text,photo,voice\
    Given Go to "https://mektoube.fr/" url
    When  Login with account "lantiu@gmail.com" and password "mektoube**"
    When Search account "yassine_yes2" and go to thread chat detail
    When Wait until element "span.btn-send-gif.active" is visible
    When Click "span.btn-send-gif.active"
    When Click "div.gifs-slider label:first-of-type"
    When Click "button.btn-send-text-wrapper"
    When Sending time and realtime
    When Logout current female account
    When Login with account "yassine_yes2" and password "Mektoubi2017"
    When Wait until element "a[href='/main/messages']" is visible
    When Click "a[href='/main/messages']"
    When Wait about 2 second
    When Click "div[style='position: relative;']>div:nth-child(1)"
    Then Reply last gif message and check send success

  @TEST_QRA-
  Scenario: Reply last voice message by a gif,text,photo,voice
    Given Go to "https://mektoube.fr/" url
    When Login with account "lantiu@gmail.com" and password "mektoube**"
#      When Wait about 2 second
#      When Allowing location access
    When Search account "yassine_yes2" and go to thread chat detail
    When Wait until element "a.btn-send-text-wrapper" is visible
    When Wait about 2 second
    When Click "a.btn-send-text-wrapper"
    When Wait about 2 second
      #When Allowing micro access
    When Allowing micro access after close location perrmisson
    When Record random seconds
    When Click "button.btn-send-text-wrapper"
    When Sending time and realtime
    When Logout current female account
    When Login with account "yassine_yes2" and password "Mektoubi2017"
    When Wait until element "a[href='/main/messages']" is visible
    When Click "a[href='/main/messages']"
    When Wait about 2 second
    When Click "div[style='position: relative;']>div:nth-child(1)"
    Then Reply last voice message and check send success

      #DONE
  @TEST_QRA-1002
  Scenario: Reply text message by text || Reply text message by gif || Reply text message by voice || Reply text message by photo
    Given Go to "responsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Click "MonCompteButton"
    When Click "Reglages"
    When Disable age filter
    When Click "discoveryScreenBt"
    #
    When Scroll to "AdvancedCriteria" and click
    When Scroll to "nickname" and click
    #When Click "nickname"
    When Insert "brandon92500" into "nicknameTextfield" Field (upd)
    When Click "checkButton"
    When Click "validateButton"
    #When Scroll All page
    When Wait about 2 second
    When Click on the element is "//h5[text()='brandon92500']" by xpath
    When Wait about 1 second
    When Click "discussBtn"
    When Insert "test Reply text message by text" into "fieldChat" Field (upd)
    When Click "sendMessButton"
    When Wait until element ".chat__row:last-child .mes-body-text" is visible
    And The last message is "test Reply text message by text"

    When Click "SignOutIcon"
    When Login with account "brandon92500" and password "Mektoubi2017"
    When Click "MonCompteButton"
    When Click "Reglages"
    When Disable age filter
    When Click "discoveryScreenBt"
    #
    When Scroll to "AdvancedCriteria" and click
    When Scroll to "nickname" and click
    #When Click "nickname"
    When Insert "alian98" into "nicknameTextfield" Field (upd)
    When Click "checkButton"
    When Click "validateButton"
    #When Scroll All page
    When Wait about 2 second
    When Click on the element is "//h5[text()='alian98']" by xpath
    When Wait about 1 second
    When Click "discussBtn"
    When Wait about 1 second

    When Click "lastMessageOption"
    When Click "replyIconOfLastMess"
    And The text and the time that has been replied must be correct

    #Reply text message by text
    When Insert "Reply by text" into "fieldChat" Field (upd)
    When Click "sendMessButton"
    When The message is replied that is text
    Then The text reply message is sent

    #Reply text message by gif
    When Click on received message
    When Click "gifIcon"
    When Click "firstGif"
    When Click "sendMessButton"
    When The message is replied that is text
    Then The reply gif message is sent

    #Reply text message by photo
    When Click on received message
    When Upload ephemeral picture
    When The message is replied that is text
    Then The reply photo message is sent

    #Reply text message by voice
    When Click on received message
    When Click "voiceIcon"
    When Allow to use microphone
    When Wait about 10 second
    When Click "sendMessButton"
    When Wait until element ".chat__row:last-child div.audio-message" is visible
    When The message is replied that is text
    Then The reply voice message is sent



  #DONE
  @TEST_QRA-1003
  Scenario: Reply photo message by text || Reply photo message by gif || Reply photo message by voice || Reply photo message by photo
    Given Go to "responsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Click "MonCompteButton"
    When Click "Reglages"
    When Disable age filter
    When Click "discoveryScreenBt"
    #
    When Scroll to "AdvancedCriteria" and click
    When Scroll to "nickname" and click
    #When Click "nickname"
    When Insert "brandon92500" into "nicknameTextfield" Field (upd)
    When Click "checkButton"
    When Click "validateButton"
    #When Scroll All page
    When Wait about 2 second
    When Click on the element is "//h5[text()='brandon92500']" by xpath
    When Wait about 1 second
    When Click "discussBtn"
    When Upload ephemeral picture
    When Wait until element ".chat__row:last-child div[class='ephemeral-placeholder ephemeral-placeholder--blue'] i" is visible
    When The last message just sent is image

    When Click "SignOutIcon"
    When Login with account "brandon92500" and password "Mektoubi2017"
    When Click "MonCompteButton"
    When Click "Reglages"
    When Disable age filter
    When Click "discoveryScreenBt"
    #
    When Scroll to "AdvancedCriteria" and click
    When Scroll to "nickname" and click
    #When Click "nickname"
    When Insert "alian98" into "nicknameTextfield" Field (upd)
    When Click "checkButton"
    When Click "validateButton"
    #When Scroll All page
    When Wait about 2 second
    When Click on the element is "//h5[text()='alian98']" by xpath
    When Wait about 1 second
    When Click "discussBtn"
    When Wait about 1 second

    When Click "LastEphemeralPicture"
    When Wait about 20 second
    #When Wait until element ".chat__row:last-child i.material-icons" is visible
    When Click "lastMessageOption"
    When Click "replyIconOfLastMess"
    When The image and the time that has been replied must be correct

    #Reply photo message by text
    When Click on received message
    When Insert "Reply by text" into "fieldChat" Field (upd)
    When Click "sendMessButton"
    When The message is replied that is image
    Then The text reply message is sent

    #Reply photo message by gif
    When Click on received message
    When Click "gifIcon"
    When Click "firstGif"
    When Click "sendMessButton"
    When The message is replied that is image
    Then The reply gif message is sent

    #Reply photo message by photo
    When Click on received message
    When Upload ephemeral picture
    When The message is replied that is image
    Then The reply photo message is sent

    #Reply photo message by voice
    When Click on received message
    When Click "voiceIcon"
    When Allow to use microphone
    When Wait about 10 second
    When Click "sendMessButton"
    When Wait until element ".chat__row:last-child div.audio-message" is visible
    When The message is replied that is image
    Then The reply voice message is sent


  #DONE
  @TEST_QRA-1004
  Scenario: Reply by icon || Reply by icon then cancel || Reply by icon 2 time || Recording -> reply icon is hide
    Given Go to "responsivePreprod" url

    When Login with account "thuyyylinhhh89@gmail.com" and password "mektoube**"
    When Click "MonCompteButton"
    When Click "Reglages"
    When Disable age filter
    When Click "discoveryScreenBt"
    #
    When Scroll to "AdvancedCriteria" and click
    When Scroll to "nickname" and click
    #When Click "nickname"
    When Insert "brandon92500" into "nicknameTextfield" Field (upd)
    When Click "checkButton"
    When Click "validateButton"
    #When Scroll All page
    When Wait about 2 second
    When Click on the element is "//h5[text()='brandon92500']" by xpath
    When Wait about 1 second
    When Click "discussBtn"
    When Insert "hello test feeling" into "fieldChat" Field (upd)
    When Click "sendMessButton"
    When Wait until element ".chat__row:last-child .mes-body-text" is visible
    And The last message is "hello test feeling"

    When Click "SignOutIcon"
    When Login with account "brandon92500" and password "Mektoubi2017"
    When Click "MonCompteButton"
    When Click "Reglages"
    When Disable age filter
    When Click "discoveryScreenBt"
    #
    When Scroll to "AdvancedCriteria" and click
    When Scroll to "nickname" and click
    #When Click "nickname"
    When Insert "alian98" into "nicknameTextfield" Field (upd)
    When Click "checkButton"
    When Click "validateButton"
    #When Scroll All page
    When Wait about 2 second
    When Click on the element is "//h5[text()='alian98']" by xpath
    When Wait about 1 second
    When Click "discussBtn"
    When Wait about 1 second

    #Reply by icon 2 time
    When Click "lastMessageOption"
    When Click "lastMessageOption"
    Then This message dont have feeling icon

    #Reply by icon
    When Click "lastMessageOption"
    When Click "firstFeelingIconOfLastMess"
    Then This message have feeling icon

    #Reply by icon then cancel
    When Click "lastMessageOption"
    When Click "firstFeelingIconOfLastMess"
    Then This message dont have feeling icon

    #Recording -> reply icon is hide
    When Click "voiceIcon"
    When Wait about 3 second
    When Allow to use microphone
    When Click "lastMessageOption"
    Then The reply icon is hide
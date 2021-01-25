Feature: Test activities in Login page

  @TEST_QRA-1
  Scenario Outline: Login fail with invalid data
    Given Go to "ResponsiveIntroduction.url" url
    When Click to link Se connecter
    When Leave both username and password fields empty
    When Leave password field empty and click submit
    When Leave username field empty and click submit
    When Insert "<username>" into Field "usernameField"
    When Insert "<password>" into Field "passwordField"
    When Always see notice "Veuillez vous connecter avec votre email"
    When Click "loginBtn"
    Then Display warning "<message>"
    Examples:

      | username                  | password     | message                               |
      | shainez29a                | Mektoubi2017 | Identifiant ou mot de passe incorrect |
      | shainez29                 | mektoube1    | Identifiant ou mot de passe incorrect |
      | lannt.woman@gmail.com | Mektoubi2016 | Identifiant ou mot de passe incorrect |

  @TEST_QRA-7
  Scenario Outline: Click on text link in Login Screen
    Given Go to "Login.url" url
    When Click on "<textLink>"
    When Wait about 2 second
    Then It should redirect to "<targetUrl>"

    Examples:
      | textLink              | targetUrl          |
      | Pas de compte ?       | entityForm.url     |
      | Mot de passe oublié ? | forgotPassword.url |
      | Nous contacter        | contact.url        |
      | Aide                  | assistant.url      |


  @TEST_QRA-8
  Scenario: Connect with right account - username / password
    Given Go to "Login.url" url
    When Insert "montassir931" into Field "usernameField"
    When Insert "Mektoubi2017" into Field "passwordField"
    When Should see message popup in line "Veuillez vous connecter avec votre email"
    When Click "loginBtn"
    When Wait until element "section[class='section section--discover']" is visible
    Then Browser should redirect to "discoveries.url"


  @TEST_QRA-9
  Scenario: Connect with right account - email / password
    Given Go to "Login.url" url
    When Insert "lannt.woman@gmail.com" into Field "usernameField"
    When Insert "Mektoubi2017" into Field "passwordField"
    When Should not see message pop up "Veuillez vous connecter avec votre email"
    When Click "loginBtn"
    When Wait until element "section[class='section section--discover']" is visible
    Then Browser should redirect to "discoveries.url"


  @TEST_QRA-10

  Scenario: Click on the eye in the connect page
    Given Go to "ResponsiveIntroduction.url" url
    When Click to link Se connecter
    When Insert "Nesrine_by" into Field "usernameField"
    When Insert "Mektoubi2017" into Field "passwordField"
    When Click "passwordVisibility"
    Then Check if eye button working


  @TEST_QRA-165
  Scenario: password forgotten page - leave the field blank and validate
    Given Go to "ResponsiveIntroduction.url" url
    When Click to link Se connecter
    When Click "forgotPasswordBtn"
    When Leave the field blank and click on réinitialiser mon mot de passe button
    Then Should see message popup in line "L'email ne peut pas être vide"


  @TEST_QRA-166
  Scenario: password forgotten page - click on "already an account"
    Given Go to "ResponsiveIntroduction.url" url
    When Click to link Se connecter
    When Click "forgotPasswordBtn"
    When Click "AlreadyHasAccountBtn"
    Then Browser should redirect to "Login.url"

  @TEST_QRA-167
  Scenario: password forgotten page - enter a valid email and check the procedure to reset the password
    Given Go to "ResponsiveIntroduction.url" url
    When Click to link Se connecter
    When Click "forgotPasswordBtn"
    When enter a valid email of an existing account and click on réinitialiser mon mot de passe button
    When Should see message popup at top "Si vous êtes membre, vous recevrez immédiatement par email les informations pour choisir un nouveau mot de passe."
    When Login gmail and click link to reset password
    When Wait about 4 second
    When Switch tab
    When Insert "Mektoubi2017" into Field "input[name='password']"
    When Insert "Mektoubi2018" into Field "input[name='confirm_password']"
    When Click "button[type='submit']"
    Then Should see message popup in line "Mot de passe & confirmation doivent etre identique"
    When Clear text from field "input[name='confirm_password']"
    When Insert "Mektoubi2017" into Field "input[name='confirm_password']"
    When Check if password visible button is working
    When Click "button[type='submit']"
    When Wait until element "img[src='/images/temp/intro-home.jpg']" is visible
#    When Should see message popup at top "Mot de passe modifié avec succées"
    When Redirect to link "https://mektoube.fr/"
    When Switch tab
    When Wait about 2 second
    When Click "deleteMektoubeEmail"
    When Wait about 1 second


  @TEST_QRA-168
  Scenario: password forgotten page - enter an invalid email
    Given Go to "ResponsiveIntroduction.url" url
    When Click to link Se connecter
    When Click "a[href='/forgot-password']"
    When Insert "edhghgd" into Field "input[name='email']"
    When Click "span[class='mdc-button__label']"
    Then  Should see message popup in line "L'Email n'est pas valide"

  @TEST_QRA-67
  Scenario: Should see female accounts on whole Discoveries screen
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "montassir931" and password "Mektoubi2017"
    When Wait until element ".list-profiles" is visible
    When Check some accounts to check if there are female account


  @TEST_QRA-68
  Scenario: Should see male accounts on whole Discoveries screen
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "lannt.woman@gmail.com" and password "mektoube**"
    When Wait until element ".list-profiles" is visible
    When Check some accounts to check if there are male account



















Feature: Sensitive feature

  @TEST_QRA-167
      #FORGOT PASSWORD
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
    #When Should see message popup at top "Mot de passe modifié avec succées"
    When Redirect to link "https://mektoube.fr/"
    #When Switch tab
    #When Wait about 4 second
    #When Click "deleteMektoubeEmail"
    #When Wait about 1 second

  @TEST_QRA-965
    #PAYMENT
  Scenario: Payment page, Show message when click over 3 time validate button
    Given Go to "ResponsiveIntroduction.url" url
    When Login with account "criskhoa@gmail.com" and password "mektoube"
    When Wait about 2 second
    When Click "firstProfileInDiscovery"
    When Click "CroiserSonDestinButton"
    When Insert "4111111111111111" into Field "cardNumberField"
    When Insert "12/27" into Field "ExpDateOfCardField"
    When Insert "676" into Field "CVVField"
    When Click "SubmitBtn"
    When Wait about 4 second
    When Click "SubmitBtn"
    When Wait about 4 second
    When Click "SubmitBtn"
    When Wait about 6 second
    When Click "SubmitBtn"
    Then The page show error message is "Trop de tentatives de paiement en échec. Vous pourrez réessayer dans 15 min"

  @TEST_QRA-861
    #CREATE AN ACCOUNT - VALIDATE EMAIL
  Scenario: Create a woman account - Verify link confirm email
    Given Go to "ResponsiveIntroduction.url" url
    When Create a woman account with email "mektoubitest@gmail.com" and username "samiracute"
    When Skip all questions in every registration form
    When Wait until element "a.warning-info" is visible
    When Click "a.warning-info"
    When Wait until element "div.modal-content" is visible
    When Scroll to element that has text "RenvoyerUnEmailDeValidation" and click
    Then Should see message popup at top "L'email de vérification a bien été envoyé"
    When Verify confirm Email link
    When Switch tab
    When Wait until element "div[class='header__inner']" is visible
#    không đc thay đổi URL này
    Then Browser should redirect to "https://mektoube.fr/main/discoveries"
    When Wait about 4 second
    When Wait until element "MyProfileBtn" is visible
    When Click "MyProfileBtn"
    When Click "NotificationTextLink"
    Then Check if Warning confirm email exist
    When Switch tab
    When Click "deleteMektoubeEmail"
    When Wait about 1 second

  @TEST_QRA-997
  Scenario: Enter wrong password => will receive email
    Given Go to "ResponsiveIntroduction.url" url
    When Click to link Se connecter
    When Wait about 2 second
    When Insert "mektoubitest@gmail.com" into Field "usernameField"
    When Insert "wrongpassword" into Field "passwordField"
    When Click "admin.loginBtn"
    Then Display warning "Identifiant ou mot de passe incorrect"
    When Login gmail and click link to RETURN TO MEKTOUBE
    When Wait about 4 second
    When Switch tab
    Then Browser should redirect to url contain "/main/discoveries"
    And Click "MonCompteButton"
    Then The account name is "Samiracute"

  @TEST_QRA-985
  Scenario Outline: Message when a user tries to create an account with a disposable/blacklist/(+) email)
    Given Go to "ResponsiveIntroduction.url" url
    When Create a man account with email "<email>"
    Then The page show error message is "Vous ne pouvez pas créer de compte avec un email provenant de ce nom de domaine."
    And It should redirect to "https://www.mektoube.fr/inscription/signup"
    Examples:
      | email |
      | lannt@gmail.com |
      | lannt98@0-aa.com |
      | lannt+98@mektoube.ft |

  @TEST_QRA-1008
  Scenario: Don't allow change email to a disposable/blacklist/(+) email in Settings page

    Given Go to "https://www.mektoube.fr" url
    When Login with account "lantiu@gmail.com" and password "mektoube**"
    When Click "MonCompte"
    When Wait about 2 second
    When Click "Reglages"
    When Wait until element "div.filter div.filter__item:nth-child(1)" is visible
    When Click "div.filter div.filter__item:nth-child(1)"
    When Insert "mektoube**" into Field "input[type='password']"
    When Insert "lannt@gmail.com" into Field "input[type='email']"
    When Click "div.form--actions.d-block button"
    Then The page show error message is "Vous ne pouvez pas créer de compte avec un email provenant de ce nom de domaine."
    When Wait about 3 second

    When Click "div.filter div.filter__item:nth-child(1)"
    When Clear text from field "input[type='email']"
    When Insert "lannt01@0-aa.com" into Field "input[type='email']"
    When Click "div.form--actions.d-block button"
    Then The page show error message is "Vous ne pouvez pas créer de compte avec un email provenant de ce nom de domaine."
    When Wait about 3 second

    When Click "div.filter div.filter__item:nth-child(1)"
    When Clear text from field "input[type='email']"
    When Insert "lannt+01@mektoube.ft" into Field "input[type='email']"
    When Click "div.form--actions.d-block button"
    Then The page show error message is "L'Email n'est pas valide"

  @TEST_QRA-1011
  Scenario: Don't allow create an account with a anti psedou partterns
    When Go to "ResponsiveIntroduction.url" url
    When Create a woman account with email anti username "techizexact"
    When Wait about 2 second
    Then The page show error message is "Ce prénom n’est pas accepté, veuillez en choisir un autre"

    When Insert anti username "techizinc" and click "CreateAccountBtn"
    Then The page show error message is "Ce prénom n’est pas accepté, veuillez en choisir un autre"

    When Insert anti username "techizincabc" and click "CreateAccountBtn"
    Then The page show error message is "Ce prénom n’est pas accepté, veuillez en choisir un autre"

    When Insert anti username "abctechizinc" and click "CreateAccountBtn"
    Then The page show error message is "Ce prénom n’est pas accepté, veuillez en choisir un autre"

    When Insert anti username "abctechizincdef" and click "CreateAccountBtn"
    Then The page show error message is "Ce prénom n’est pas accepté, veuillez en choisir un autre"

    When Insert anti username "techizstart" and click "CreateAccountBtn"
    Then The page show error message is "Ce prénom n’est pas accepté, veuillez en choisir un autre"

    When Insert anti username "techizstartabc" and click "CreateAccountBtn"
    Then The page show error message is "Ce prénom n’est pas accepté, veuillez en choisir un autre"

    When Insert anti username "techizend" and click "CreateAccountBtn"
    Then The page show error message is "Ce prénom n’est pas accepté, veuillez en choisir un autre"

    When Insert anti username "abctechizend" and click "CreateAccountBtn"
    Then The page show error message is "Ce prénom n’est pas accepté, veuillez en choisir un autre"

  @TEST_QRA-1013
  Scenario: Check list anti psedou in setting page (rule include)
    When Go to "https://mektoube.fr/" url
    When Login with account "yassine_yes" and password "Mektoubi2017"
    When Click "MonCompte"
    When Wait about 2 second
    When Click "button.edit-name-btn"
    When Clear text from field "input[type='text']"
    When Insert "groscu" into Field "input[type='text']"
    When Click "button.mdc-button.mdc-button--unelevated.mobile-fixed-bottom-btn"
    Then The page show error message is "Ce prénom n’est pas accepté, veuillez en choisir un autre"
    When Insert anti username from list and click validate

  @TEST_QRA-1014
      #wait deloy preprod >> test
  Scenario: Check list anti psedou in sign up screen (rule include)
    When Go to "https://mektoube.fr/" url
    When Create a woman account with email anti username "techizexact"
    When Wait about 2 second
    Then The page show error message is "Ce prénom n’est pas accepté, veuillez en choisir un autre"
    When Insert anti username from list and click create account button
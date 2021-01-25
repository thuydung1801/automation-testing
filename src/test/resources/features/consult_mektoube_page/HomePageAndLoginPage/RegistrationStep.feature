Feature: Registration Step

  Background:
    Given Go to "ResponsiveIntroduction.url" url

  @TEST_QRA-159
  Scenario Outline: Registration step - Enter gender
    When Click "<Gender>"
    When Click "FreeRegistration"
    Then Browser should redirect to "<targetUrl>"
    Examples:
      | Gender    | targetUrl        |
      | iAmAWoman | birthdayForm.url |
      | iAmAMan   | birthdayForm.url |

  @TEST_QRA-27
  Scenario: Registration step - Birthday screen
    When Click "iAmAMan"
    When Click "FreeRegistration"
    When Wait about 3 second
    When Leave the age field empty and validate
    Then Should see message popup in line "Le champ est vide"
    When Enter a date of birth of user under eighteen
    Then Should see message popup in line "Vous devez avoir 18 ans minimum"
    When Enter a positive date of birth "-31-10-1997"
    Then Should see positive value "31" and "10" and "1997"
    When I enter only alphabel "ab"
    Then The field remains empty
    When Enter a invalid date to birthday field
    Then Should see message popup in line "Vous devez mettre une date valide"
    When Enter a valid date of birth and validate
    When Wait until element "div[class='list--radio']" is visible
    Then Browser should redirect to "originForm.url"


  @TEST_QRA-196
  Scenario: Registration step - Geolocation step - Don't check a city in the "What is your city" page / Selection of a city

    When Click "iAmAMan"
    When Click "FreeRegistration"
    When Enter a valid date of birth and validate
    When Browser should redirect to "originForm.url"
    When Click on radio button that has text "//div[@class='list--radio']//*[contains(text(),'Algérienne')]"
    When Click "confirmBtn"
    When Wait until element "MyGeolocation" is visible
    When Browser should redirect to "FromForm.url"
    When Click "MyGeolocation"
    When Browser should redirect to url contain "https://www.mektoube.fr/inscription/country/:country/latitude/"
    When View 5 city
    When Click "confirmBtn"
    Then Should see message popup in line "Le champ est vide"
    When Click on radio button that has text "//div[@class='list--radio']//*[contains(text(),'Médine')]"
    When Click "confirmBtn"
    When Wait until element "form[class='form form--register-block']" is visible
    Then Browser should redirect to "signUp.url"



  @TEST_QRA-160
  Scenario: Registration step - Don't check an origin / Check one option of the "Origin" field
    When Click "iAmAMan"
    When Click "FreeRegistration"
    When Enter a valid date of birth and validate
    When Browser should redirect to "originForm.url"
    When Don't select anything and click validate
    Then Should see message popup in line "Le champ est vide"
    When Click on radio button that has text "//div[@class='list--radio']//*[contains(text(),'Algérienne')]"
    When Click on radio button that has text "//div[@class='list--radio']//*[contains(text(),'Marocaine')]"
    When Click on radio button that has text "//div[@class='list--radio']//*[contains(text(),'Tunisienne')]"
    Then Only one radio button is clicked
    When Click "confirmBtn"
    Then Browser should redirect to "FromForm.url"


  @TEST_QRA-149
  Scenario: Registration step - location screen: don't select country / select country without a postal code

    When Click "iAmAMan"
    When Click "FreeRegistration"
    When Enter a valid date of birth and validate
    When Browser should redirect to "originForm.url"
    When Click on radio button that has text "//div[@class='list--radio']//*[contains(text(),'Algérienne')]"
    When Click "confirmBtn"
    When Click "MaLocalisationField"
    When Wait until element "CountriesList" is visible
    When Browser should redirect to "https://www.mektoube.fr/inscription/countryForm"
    When Click "confirmBtn"
    Then Should see message popup in line "Le champ est vide"
    When Click on radio button that has text "//div[@class='list--radio']//*[contains(text(),'Algérie')]"
    When Click "confirmBtn"
    When Browser should redirect to "https://www.mektoube.fr/inscription/country/DZ/regions"
    When Click on radio button that has text "Tlemcen"
    When Click "confirmBtn"
    When Browser should redirect to "https://www.mektoube.fr/inscription/country/DZ/region/15"
    When Click on radio button that has text "Deglene"
    When Click "confirmBtn"
    When Wait until element "form[class='form form--register-block']" is visible
    Then Browser should redirect to "signUp.url"


  @TEST_QRA-151
  Scenario: Registration step - location screen: select country without a postal code

    When Click "iAmAMan"
    When Click "FreeRegistration"
    When Browser should redirect to "birthdayForm.url"
    When Enter a valid date of birth and validate
    When Browser should redirect to "originForm.url"
    When Click on radio button that has text "//div[@class='list--radio']//*[contains(text(),'Algérienne')]"
    When Click "confirmBtn"
    When Click "MaLocalisationField"
    When Wait until element "CountriesList" is visible
    When Click on radio button that has text "//div[@class='list--radio']//*[contains(text(),'Algérie')]"
    When Click "confirmBtn"
    When Browser should redirect to "https://www.mektoube.fr/inscription/country/DZ/regions"
    When Click on radio button that has text "Tlemcen"
    When Click "confirmBtn"
    When Browser should redirect to "https://www.mektoube.fr/inscription/country/DZ/region/15"
    When Click on radio button that has text "Deglene"
    When Click "confirmBtn"
    When Wait until element "form[class='form form--register-block']" is visible
    Then Browser should redirect to "signUp.url"

  @TEST_QRA-147
  Scenario: Registration step - location screen: select country has zipcode

    When Click "iAmAMan"
    When Click "FreeRegistration"
    When Browser should redirect to "birthdayForm.url"
    When Enter a valid date of birth and validate
    When Browser should redirect to "originForm.url"
    When Click on radio button that has text "//div[@class='list--radio']//*[contains(text(),'Algérienne')]"
    When Click "confirmBtn"
    When Click "MaLocalisationField"
    When Wait until element "CountriesList" is visible
    When Click on radio button that has text "Luxembourg"
    When Click on radio button that has text "Qatar"
    When Click on radio button that has text "France"
    Then Only one radio button is clicked
    When Click "confirmBtn"
    When Wait until element "div[class='input-field-container field--text-input']" is visible
    When Browser should redirect to "zipCode.url"


  @TEST_QRA-152
  Scenario: Registration step - zipcode screen: Leave the postal code field empty /Enter alphabetics, special characters in the postal code field / Enter a invalid postal code

    When Click "iAmAMan"
    When Click "FreeRegistration"
    When Browser should redirect to "birthdayForm.url"
    When Enter a valid date of birth and validate
    When Browser should redirect to "originForm.url"
    When Click on radio button that has text "//div[@class='list--radio']//*[contains(text(),'Algérienne')]"
    When Click "confirmBtn"
    When Click "MaLocalisationField"
    When Wait until element "CountriesList" is visible
    When Click on radio button that has text "France"
    When Click "confirmBtn"
    When Wait until element "div[class='input-field-container field--text-input']" is visible
    When Browser should redirect to "zipCode.url"
    When Click "confirmBtn"
    Then Should see message popup in line "Le champ est vide"
    When Insert "abdgfhdg))((***" into Field "input[type='number']"
    Then Postal code field remain empty
    When Insert "++++-----" into Field "input[type='number']"
    When Click "confirmBtn"
    Then Tooltip zipcode is appear
    When Wait about 2 second
    And Broswer remain at url "zipCode.url"
    When Clear text from field "ZipcodeField"
    When Insert "53454" into Field "ZipcodeField"
    When Click "confirmBtn"
    Then Should see message popup at top "Ce code postal n'existe pas"



  @TEST_QRA-215
  Scenario: Registration step - zipcode screen: validate a single digit in the postal code field

    When Click "iAmAMan"
    When Click "FreeRegistration"
    When Browser should redirect to "birthdayForm.url"
    When Enter a valid date of birth and validate
    When Browser should redirect to "originForm.url"
    When Click on radio button that has text "//div[@class='list--radio']//*[contains(text(),'Algérienne')]"
    When Click "confirmBtn"
    When Click "MaLocalisationField"
    When Wait until element "CountriesList" is visible
    When Click on radio button that has text "France"
    When Click "confirmBtn"
    When Wait until element "div[class='input-field-container field--text-input']" is visible
    When Browser should redirect to "zipCode.url"
    When Insert "5" into Field "ZipcodeField"
    When Click "confirmBtn"
    Then Check if duplicate option of city
    When Click on radio button that has text "Yvrac"
    When Click "confirmBtn"
    When Wait until element "form[class='form form--register-block']" is visible
    Then Browser should redirect to "signUp.url"


  @TEST_QRA-155
  Scenario: Registration step - zipcode screen: Enter a valid postal code

    When Click "iAmAMan"
    When Click "FreeRegistration"
    When Browser should redirect to "birthdayForm.url"
    When Enter a valid date of birth and validate
    When Browser should redirect to "originForm.url"
    When Click on radio button that has text "//div[@class='list--radio']//*[contains(text(),'Algérienne')]"
    When Click "confirmBtn"
    When Click "MaLocalisationField"
    When Wait until element "CountriesList" is visible
    When Click on radio button that has text "France"
    When Click "confirmBtn"
    When Wait until element "div[class='input-field-container field--text-input']" is visible
    When Browser should redirect to "zipCode.url"
    When Insert "75001" into Field "ZipcodeField"
    When Click "confirmBtn"
    When Wait until element ".list--radio" is visible
    Then Browser should redirect to "CityOfZipCode75001.url"


  @TEST_QRA-157
  Scenario: Registration step - Localisation step - Don't check a city in the "What is your city" page / Select the unique city in the "What is your city" page

    When Click "iAmAMan"
    When Click "FreeRegistration"
    When Browser should redirect to "birthdayForm.url"
    When Enter a valid date of birth and validate
    When Browser should redirect to "originForm.url"
    When Click on radio button that has text "//div[@class='list--radio']//*[contains(text(),'Algérienne')]"
    When Click "confirmBtn"
    When Click "MaLocalisationField"
    When Wait until element "CountriesList" is visible
    When Click on radio button that has text "France"
    When Click "confirmBtn"
    When Wait until element "div[class='input-field-container field--text-input']" is visible
    When Browser should redirect to "zipCode.url"
    When Insert "75001" into Field "ZipcodeField"
    When Click button "confirmBtn"
    When Wait until element ".list--radio" is visible
    Then Browser should redirect to "CityOfZipCode75001.url"
    When View 1 city
    When Click "confirmBtn"
    Then Should see message popup in line "Le champ est vide"
    When Click "Paris1erCity"
    When Click "confirmBtn"
    When Wait until element "form[class='form form--register-block']" is visible
    Then Browser should redirect to "signUp.url"


  @TEST_QRA-62
  Scenario: Registration step - fill profile after sign up successful - verify only 1 button is clicked in each questions and click Skip question

    When Do the steps to the sign up screen
    When Click "skipQuestion"
    When Browser should redirect to "jobForm.url"
    When Chose several options of question in each registration form
    When Only one radio button is clicked
    When Click "skipQuestion"
    When Browser should redirect to "maritalForm.url"
    When Chose several options of question in each registration form
    When Only one radio button is clicked
    When Click "skipQuestion"
    When Browser should redirect to "religiousForm.url"
    When Chose several options of question in each registration form
    When Only one radio button is clicked
    When Click "skipQuestion"
    When Browser should redirect to "silhouetteForm.url"
    When Chose several options of question in each registration form
    When Only one radio button is clicked
    When Click "skipQuestion"
    When Browser should redirect to "tallForm.url"
    When Move tall slider to choose how to tall
    When Click "skipQuestion"
    When Browser should redirect to "enfantsForm.url"
    When Chose several options of question in each registration form
    When Only one radio button is clicked
    When Click "skipQuestion"
    When Browser should redirect to "degreeForm.url"
    When Chose several options of question in each registration form
    When Only one radio button is clicked
    When Click "skipQuestion"
    When Browser should redirect to "discoveries.url"
    When Check some accounts to check if there are male account

  @TEST_QRA-198
  Scenario: Registration step - fill profile after sign up successful - Do not select answer and Skip all questions

    When Do the steps to the sign up screen
    When Skip all questions in every registration form
    When Check some accounts to check if there are male account


  @TEST_QRA-199
  Scenario: Registration step - fill profile after sign up successful - Answer all questions in Registration form

    When Do the steps to the sign up screen
    When Upload avatar "testPicture.jpg" from computer to rejected
    When Should see message popup at top "Le téléchargement de la photo a échoué. Veuillez réessayer"
    When Wait about 4 second
    And Broswer remain at url "CreateAccountSuccess.url"
    When Click "skipQuestion"
    When Wait until element ".list--radio" is visible
    When Browser should redirect to "https://www.mektoube.fr/inscription/jobForm"
    Then Answer all question in Registration form
    When Check some accounts to check if there are male account


  @TEST_QRA-226
  Scenario: Registration step - male Registration - Should see female account in Discoveries screen

    When Create a man account with email "Mektoubitest@gmail.com" and username "Kamel_Clown"
    When Upload avatar from computer
    When Check if upload avatar successful
    Then Answer all question in Registration form
    When Check some accounts to check if there are female account


  @TEST_QRA-212
  Scenario: Registration step - sign up screen - Leave the fields empty

    When Click "iAmAMan"
    When Click "FreeRegistration"
    When Browser should redirect to "birthdayForm.url"
    When Enter a valid date of birth and validate
    When Browser should redirect to "originForm.url"
    When Click on radio button that has text "//div[@class='list--radio']//*[contains(text(),'Algérienne')]"
    When Click "confirmBtn"
    When Click "MaLocalisationField"
    When Wait until element "CountriesList" is visible
    When Click on radio button that has text "France"
    When Click "confirmBtn"
    When Wait until element "div[class='input-field-container field--text-input']" is visible
    When Browser should redirect to "zipCode.url"
    When Insert "75001" into Field "ZipcodeField"
    When Click "confirmBtn"
    When Wait until element ".list--radio" is visible
    When Browser should redirect to "CityOfZipCode75001.url"
    When View 1 city
    When Click "Paris1erCity"
    When Click "confirmBtn"
    When Wait until element "form[class='form form--register-block']" is visible
    Then Browser should redirect to "signUp.url"
    When Insert "" into Field "input[name='signUpEmail']"
    When Insert "" into Field "input[name='signUpLogin']"
    When Insert "" into Field "input[name='signUpPassword']"
    When Click "createAccount"
    Then Should see message popup in line "L'Email n'est pas valide"
    And Should see message popup in line "Le Prénom ne peut pas être vide"
    And Should see message popup in line "Le mot de passe ne peut pas être vide"

  @TEST_QRA-213
  Scenario: Registration step - sign up screen - Enter an username has more than 2 number

    When Click "iAmAMan"
    When Click "FreeRegistration"
    When Browser should redirect to "birthdayForm.url"
    When Enter a valid date of birth and validate
    When Browser should redirect to "originForm.url"
    When Click on radio button that has text "//div[@class='list--radio']//*[contains(text(),'Algérienne')]"
    When Click "confirmBtn"
    When Click "MaLocalisationField"
    When Wait until element "CountriesList" is visible
    When Click on radio button that has text "France"
    When Click "confirmBtn"
    When Wait until element "div[class='input-field-container field--text-input']" is visible
    When Browser should redirect to "zipCode.url"
    When Insert "75001" into Field "ZipcodeField"
    When Click "confirmBtn"
    When Browser should redirect to "CityOfZipCode75001.url"
    When View 1 city
    When Click "Paris1erCity"
    When Click "confirmBtn"
    When Wait until element "form[class='form form--register-block']" is visible
    Then Browser should redirect to "signUp.url"
    When Insert "omaz04@gmail.com" into Field "input[name='signUpEmail']"
    When Insert "chi123" into Field "input[name='signUpLogin']"
    When Insert "Mektoubi2017" into Field "input[name='signUpPassword']"
    When Click "TermsOfUse1"
    When Click "TermsOfUse2"
    When Click "createAccount"
    Then Should see message popup at top "Merci de choisir un prénom avec 2 chiffres maximum"

  @TEST_QRA-216
  Scenario: Registration step - sign up screen - Enter an existing email - verify link login

    When Click "iAmAMan"
    When Click "FreeRegistration"
    When Browser should redirect to "birthdayForm.url"
    When Enter a valid date of birth and validate
    When Browser should redirect to "originForm.url"
    When Click on radio button that has text "//div[@class='list--radio']//*[contains(text(),'Algérienne')]"
    When Click "confirmBtn"
    When Click "MaLocalisationField"
    When Wait until element "CountriesList" is visible
    When Click on radio button that has text "France"
    When Click "confirmBtn"
    When Wait until element "div[class='input-field-container field--text-input']" is visible
    When Browser should redirect to "zipCode.url"
    When Insert "75001" into Field "ZipcodeField"
    When Click "confirmBtn"
    When Wait until element ".list--radio" is visible
    Then Browser should redirect to "CityOfZipCode75001.url"
    When View 1 city
    When Click "Paris1erCity"
    When Click "confirmBtn"
    When Wait until element "form[class='form form--register-block']" is visible
    Then Browser should redirect to "signUp.url"
    When Insert "lannt.woman@gmail.com" into Field "input[name='signUpEmail']"
    When Insert "blablatoo" into Field "input[name='signUpLogin']"
    When Insert "Mektoubi2017" into Field "input[name='signUpPassword']"
    When Click "TermsOfUse1"
    When Click "TermsOfUse2"
    When Click "createAccount"
    Then Should see message popup at top "Catte adresse email est déjà prise. Voulez-vous vous connecter ou récupérer votre mot de passe ?"
    When Click "div.top-message-text a[href='/login']"
    Then Browser should redirect to "https://www.mektoube.fr/login"


  @TEST_QRA-217
  Scenario: Registration step - sign up screen - Enter an existing email - verify link forgot password

    When Click "iAmAMan"
    When Click "FreeRegistration"
    When Browser should redirect to "birthdayForm.url"
    When Enter a valid date of birth and validate
    When Browser should redirect to "originForm.url"
    When Click on radio button that has text "//div[@class='list--radio']//*[contains(text(),'Algérienne')]"
    When Click "confirmBtn"
    When Click "MaLocalisationField"
    When Wait until element "CountriesList" is visible
    When Click on radio button that has text "France"
    When Click "confirmBtn"
    When Wait until element "div[class='input-field-container field--text-input']" is visible
    When Browser should redirect to "zipCode.url"
    When Insert "75001" into Field "ZipcodeField"
    When Click "confirmBtn"
    When Wait until element ".list--radio" is visible
    Then Browser should redirect to "CityOfZipCode75001.url"
    When View 1 city
    When Click "Paris1erCity"
    When Click "confirmBtn"
    When Wait until element "form[class='form form--register-block']" is visible
    Then Browser should redirect to "signUp.url"
    When Insert "lannt.woman@gmail.com" into Field "input[name='signUpEmail']"
    When Insert "blablatoo" into Field "input[name='signUpLogin']"
    When Insert "Mektoubi2017" into Field "input[name='signUpPassword']"
    When Click "TermsOfUse1"
    When Click "TermsOfUse2"
    When Click "createAccount"
    Then Should see message popup at top "Catte adresse email est déjà prise. Voulez-vous vous connecter ou récupérer votre mot de passe ?"
    When Click "forgotPasswordBtn"
    Then Browser should redirect to "forgotPassword.url"


  @TEST_QRA-218
  Scenario: Registration step - sign up screen - Enter an invalid email (filed only number or alphabet)

    When Click "iAmAMan"
    When Click "FreeRegistration"
    When Browser should redirect to "birthdayForm.url"
    When Enter a valid date of birth and validate
    When Browser should redirect to "originForm.url"
    When Click on radio button that has text "//div[@class='list--radio']//*[contains(text(),'Algérienne')]"
    When Click "confirmBtn"
    When Click "MaLocalisationField"
    When Wait until element "CountriesList" is visible
    When Click on radio button that has text "France"
    When Click "confirmBtn"
    When Wait until element "div[class='input-field-container field--text-input']" is visible
    When Browser should redirect to "zipCode.url"
    When Insert "75001" into Field "ZipcodeField"
    When Click "confirmBtn"
    When Wait until element ".list--radio" is visible
    Then Browser should redirect to "CityOfZipCode75001.url"
    When View 1 city
    When Click "Paris1erCity"
    When Click "confirmBtn"
    When Wait until element "form[class='form form--register-block']" is visible
    Then Browser should redirect to "signUp.url"
    When Insert "chipn" into Field "input[name='signUpEmail']"
    When Insert "blablatoo" into Field "input[name='signUpLogin']"
    When Insert "Mektoubi2017" into Field "input[name='signUpPassword']"
    When Click "TermsOfUse1"
    When Click "TermsOfUse2"
    When Click "createAccount"
    Then Should see message popup in line "L'Email n'est pas valide"
    When Clear text from field "input[name='signUpEmail']"
    When Insert "3110" into Field "input[name='signUpEmail']"
    When Click "createAccount"
    Then Should see message popup in line "L'Email n'est pas valide"

  @TEST_QRA-219
  Scenario: Registration step - sign up screen - Enter too short username/password

    When Click "iAmAMan"
    When Click "FreeRegistration"
    When Browser should redirect to "birthdayForm.url"
    When Enter a valid date of birth and validate
    When Browser should redirect to "originForm.url"
    When Click on radio button that has text "//div[@class='list--radio']//*[contains(text(),'Algérienne')]"
    When Click "confirmBtn"
    When Click "MaLocalisationField"
    When Wait until element "CountriesList" is visible
    When Click on radio button that has text "France"
    When Click "confirmBtn"
    When Wait until element "div[class='input-field-container field--text-input']" is visible
    When Browser should redirect to "zipCode.url"
    When Insert "75001" into Field "ZipcodeField"
    When Click "confirmBtn"
    When Wait until element ".list--radio" is visible
    Then Browser should redirect to "CityOfZipCode75001.url"
    When View 1 city
    When Click "Paris1erCity"
    When Click "confirmBtn"
    When Wait until element "form[class='form form--register-block']" is visible
    Then Browser should redirect to "signUp.url"
    When Insert "pchi.nguyen01@gmail.com" into Field "input[name='signUpEmail']"
    When Insert "chi" into Field "input[name='signUpLogin']"
    When Insert "Mektoubi2017" into Field "input[name='signUpPassword']"
    When Click "TermsOfUse1"
    When Click "TermsOfUse2"
    When Click "createAccount"
    Then Should see message popup at top "Merci de choisir un prénom de 4 à 15 caractères"
    When Wait about 4 second
    When Clear text from field "input[name='signUpLogin']"
    When Insert "nguyenphuongchi_" into Field "input[name='signUpLogin']"
    When Click "createAccount"
    Then Should see message popup at top "Merci de choisir un prénom de 4 à 15 caractères"
    When Wait about 4 second
    When Clear text from field "input[name='signUpLogin']"
    When Insert "chi01" into Field "input[name='signUpLogin']"
    When Clear text from field "input[name='signUpPassword']"
    When Insert "Mektoub" into Field "input[name='signUpPassword']"
    Then Should see message popup "Votre nouveau mot de passe doit faire au moins 8 caractères"

  @TEST_QRA-220
  Scenario: Registration step - sign up screen - Check if eye button working

    When Click "iAmAMan"
    When Click "FreeRegistration"
    When Browser should redirect to "birthdayForm.url"
    When Enter a valid date of birth and validate
    When Browser should redirect to "originForm.url"
    When Click on radio button that has text "//div[@class='list--radio']//*[contains(text(),'Algérienne')]"
    When Click "confirmBtn"
    When Click "MaLocalisationField"
    When Wait until element "CountriesList" is visible
    When Click on radio button that has text "France"
    When Click "confirmBtn"
    When Wait until element "div[class='input-field-container field--text-input']" is visible
    When Browser should redirect to "zipCode.url"
    When Insert "75001" into Field "ZipcodeField"
    When Click "confirmBtn"
    When Wait until element ".list--radio" is visible
    Then Browser should redirect to "CityOfZipCode75001.url"
    When View 1 city
    When Click "Paris1erCity"
    When Click "confirmBtn"
    When Wait until element "form[class='form form--register-block']" is visible
    Then Browser should redirect to "signUp.url"
    When Insert "pchi.nguyen02@gmail.com" into Field "input[name='signUpEmail']"
    When Insert "chi" into Field "input[name='signUpLogin']"
    When Insert "Mektoubi2017" into Field "input[type='password']"
    When Click "EyeBtnInSingUpScreen"
    Then Check if eye button working in signup page

  @TEST_QRA-221
  Scenario: Registration step - sign up screen - don't check validation

    When Click "iAmAMan"
    When Click "FreeRegistration"
    When Browser should redirect to "birthdayForm.url"
    When Enter a valid date of birth and validate
    When Browser should redirect to "originForm.url"
    When Click on radio button that has text "//div[@class='list--radio']//*[contains(text(),'Algérienne')]"
    When Click "confirmBtn"
    When Click "MaLocalisationField"
    When Wait until element "CountriesList" is visible
    When Click on radio button that has text "France"
    When Click "confirmBtn"
    When Wait until element "div[class='input-field-container field--text-input']" is visible
    When Browser should redirect to "zipCode.url"
    When Insert "75001" into Field "ZipcodeField"
    When Click "confirmBtn"
    When Wait until element ".list--radio" is visible
    Then Browser should redirect to "CityOfZipCode75001.url"
    When View 1 city
    When Click "Paris1erCity"
    When Click "confirmBtn"
    When Wait until element "form[class='form form--register-block']" is visible
    Then Browser should redirect to "signUp.url"
    When Insert "pchi.nguyen02@gmail.com" into Field "input[name='signUpEmail']"
    When Insert "pchi02" into Field "input[name='signUpLogin']"
    When Insert "Mektoubi2017" into Field "input[name='signUpPassword']"
    When Click "createAccount"
    Then Should see message popup in line "Vous devez accepter les CGU"
    When Click "TermsOfUse1"
    When Click "createAccount"
    Then Should see message popup in line "Vous devez accepter la charte de vie privée"

  @TEST_QRA-222
  Scenario: Registration step - sign up screen - check if CGU/Private Charter link working

    When Click "iAmAMan"
    When Click "FreeRegistration"
    When Browser should redirect to "birthdayForm.url"
    When Enter a valid date of birth and validate
    When Browser should redirect to "originForm.url"
    When Click on radio button that has text "//div[@class='list--radio']//*[contains(text(),'Algérienne')]"
    When Click "confirmBtn"
    When Click "MaLocalisationField"
    When Wait until element "CountriesList" is visible
    When Click on radio button that has text "France"
    When Click "confirmBtn"
    When Wait until element "div[class='input-field-container field--text-input']" is visible
    When Browser should redirect to "zipCode.url"
    When Insert "75001" into Field "ZipcodeField"
    When Click button "confirmBtn"
    When Wait until element ".list--radio" is visible
    Then Browser should redirect to "CityOfZipCode75001.url"
    When View 1 city
    When Click "Paris1erCity"
    When Click "confirmBtn"
    When Wait until element "form[class='form form--register-block']" is visible
    Then Browser should redirect to "signUp.url"
    Then Check if CGU/Private Charter link working

  @TEST_QRA-223
  Scenario: Registration step - sign up screen - Check if "Already an account" link working

    When Click "iAmAMan"
    When Click "FreeRegistration"
    When Browser should redirect to "birthdayForm.url"
    When Enter a valid date of birth and validate
    When Browser should redirect to "originForm.url"
    When Click on radio button that has text "//div[@class='list--radio']//*[contains(text(),'Algérienne')]"
    When Click "confirmBtn"
    When Click "MaLocalisationField"
    When Wait until element "CountriesList" is visible
    When Click on radio button that has text "France"
    When Click "confirmBtn"
    When Wait until element "div[class='input-field-container field--text-input']" is visible
    When Browser should redirect to "zipCode.url"
    When Insert "75001" into Field "ZipcodeField"
    When Click "confirmBtn"
    When Wait until element ".list--radio" is visible
    Then Browser should redirect to "CityOfZipCode75001.url"
    When View 1 city
    When Click "Paris1erCity"
    When Click "confirmBtn"
    When Wait until element "form[class='form form--register-block']" is visible
    When Browser should redirect to "signUp.url"
    When Click "SeConnecter"
    Then Browser should redirect to "Login.url"

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

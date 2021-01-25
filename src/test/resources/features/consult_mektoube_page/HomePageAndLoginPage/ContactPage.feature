@QRA-190
Feature: As an user i want to contact with Contact page

  @TEST_QRA-187
  #QA45_ok
  Scenario: let fields blank on contact page
    Given Go to "ResponsivePreprod" url

    When Click to link Se connecter
    When Click "contactLink"
    And Click "sendContact"
    #result
    Then The page show error include "Le nom est requis.L'email est requis.Le contenu du message est requis.Veuillez valider le Captcha"

#  @TEST_QRA-188
#  #QA46_not yet cause stuck capcha=> test manual
#  Scenario: fill in the fields of the contact page correctly
#    Given Go to "ResponsivePreprod" url
#
#    When Click to link Se connecter
#    When Click "contactLink"
#    #input Nom / Prénom field, eg: test
#    And Enter into Nom / Prénom field with value "test"
#    #input Email field, eg:tathuylinh1124@gmail.com
#    And Enter into Email field with value "abc@gmail.com"
#    #select one value in droplist, eg: select default value
#    #input Votre message...field, eg: aaa
#    And Enter into Votre message field with value "aaa"
#    #click on Im not robot checkbox and wait this checkbox loads ???
#    #And click on the element "<string>"
#    And Wait for page load
#    #click on Envoyer button
#    And Click on Envoyer button
#    And Wait for page load
#    #result
#    Then show message "Message envoyé au service client"

  @TEST_QRA-189
  #QA48
  Scenario: Type numbers on field name/firstname in the contact page
    Given Go to "ResponsivePreprod" url

    When Click to link Se connecter
    When Click "contactLink"
    #input number in Nom / Prénom field, eg: 123
    And Enter into Nom / Prénom field with value "111"
    #click on Envoyer button
    And Click "sendContact"
    #result: if all error message is displayed then this is correctly, because name/firstname field
      # is entered but still show error message=>> dont accept number for this field
    Then The page show error include "Le nom est requis."
  #Le nom est requis.L'email est requis.Le contenu du message est requis.Veuillez valider le Captcha"

#    @MyTest
#    Scenario Outline: fill in the fields of the contact page incorrectly
#      Given Go to "https://www.mektoube**.fr/contact" url
#
#      And Enter into Nom / Prénom field with value "<username>"
#      And Enter into Email field with value "<email>"
#      And Enter into Votre message field with value "aaa"
#      And Wait for page load
#      And Click on Envoyer button
#      And Wait for page load
#      Then Display "<message1>" and/or "<message2>"
#      Examples:
#        | username | email | message1 | message2 |
#        |          |       | Le nom est requis. | L'email est requis. |
#        |          | abc@gmail.com | Le nom est requis. |             |
#        | aaa      |               |                    | L'email est requis. |

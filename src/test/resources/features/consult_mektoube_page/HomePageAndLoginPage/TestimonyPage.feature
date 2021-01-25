@QRA-182
Feature: Testimony page

  @TEST_QRA-183
  #QA-734, 735
  Scenario Outline: Testing when click on text Links
    Given Go to "ResponsivePreprod" url

    When Scroll to "TestimonialsLink" and click
    When Click "<textLink>"
    Then Browser should redirect to "<targetUrl>"
    Examples:
      | textLink | targetUrl |
      | Jen'aipasdecompte | https://www.mektoube.fr/inscription/entityForm |
      | J'aiuncompte | https://www.mektoube.fr/login |
#      | Jen'aipasdecompte | http://responsive-preprod.ResponsivePreprod/inscription/entityForm |
#     | J'aiuncompte | http://responsive-preprod.ResponsivePreprod/login |
#      | Jen'aipasdecompte | https://www.mektoube.fr/inscription/entityForm |
#      | J'aiuncompte | https://www.mektoube.fr/login |

    #not yet-> just 20=>ok
    # fine but when run test have scroll relative robot, must dont move mouse
  @TEST_QRA-184
  #QA-736
  Scenario: Testing when scroll the testimonials
    Given Go to "ResponsivePreprod" url

    When Scroll to "TestimonialsLink" and click
    When Scroll the testimonials
    Then The page show number of testimonials

  @TEST_QRA-185
  #QA-737
  Scenario: Page "Racontez nous votre destin" - leave the fields blank and click on "OK"
    Given Go to "ResponsivePreprod" url

    When Scroll to "TestimonialsLink" and click
    When Click "Racontez-nousvotredestin"
    When Click "OkButton"
    Then Display all error at Racontez-nous votre destin

  @TEST_QRA-186
  #QA-738
  Scenario: Page "Racontez nous votre destin" - click on "Annuler"
    Given Go to "ResponsivePreprod" url

    When Scroll to "TestimonialsLink" and click
    When Scroll top page
    When Click "Racontez-nousvotredestin"
    When Wait about 3 second
    When Click "AnnulerButton"
    Then The form is closed




Feature: view category

  Scenario: view category on main-menu
    Given Go to "glamiraUrl" url
    When Move mouse over jewelry then click on gemRing
    Then The site will redirect to "gemRingUrl" url

  Scenario: view category on mobile-menu
    Given Go to "glamiraUrl" url
    When Click on Jewelry
    Then The site will redirect to "jewelryPage" url
    And Move mouse over ring then click on gemRingJew
    And The site will redirect to "diamondRingUrl" url
# not in my list
Feature: Manage Metal

  Background: Login to admin page
    Given Login "adminPage" with "account" and "passWord"

  Scenario Outline: Add a new metal with a raw material
    Given Go to "mangageMetal"
    When Click on Add new metal button
    And Choose the "<manufacturer>"
    And Select "<goldType>" and "<goldColor>"
    And Input "metalWeight" "qty" "<rawMaterialNo>"
    And Click on New metal checkbox and click Save button
    Then The "successfulSaveMetal" Message is shown
    Examples:
      | goldType | goldColor | rawMaterialNo | manufacturer |
      | 750      | Red       | AB13          | diamondRing  |
      | 585      | Yellow    | AB13          | weddingRing  |
      | 925 S    | White     |               | diamondRing  |
    # currently, still can add wrong raw material No (expected, can not add wrong raw material)

  Scenario Outline: Add a new metal with two raw materials
    Given Go to "mangageMetal"
    When Click on Add new metal button
    And Choose the "<manufacturer>"
    And Select "<goldType>" and "<goldColor>"
    And Input "metalWeight" "qty" "<rawMaterialNo>"
    And Input second raw material "<secondRawMaterialNo>", "secondRawMaterialWeight"
    And Click on New metal checkbox and click Save button
    Then The "successfulSaveMetal" Message is shown
    Examples:
      | goldType | goldColor | rawMaterialNo       | secondRawMaterialNo | manufacturer |
      | 750      | Red       | rawMaterialserialNo1| rawMaterialserialNo2| diamondRing  |
      | 585      | Yellow    | rawMaterialserialNo1| rawMaterialserialNo1| weddingRing  |


  Scenario: log usage when update degree code for items
    Given Go to "updateDegreeCode"
    When Enter "haveToUpdateDegreeCodeBarcode" to the barcode box
    And Enter "degreeCode" and "goldWeight"
    And Go to "mangageMetal"
    And View detail of the metal has "degreeCode"
    And View the metal log usage
    Then The weight usage logged is "goldWeight"

  Scenario: log usage when batch update from casting to Sliver manufacturing
    Given Go to "updateProductionProcess"
    And Click on Multiple Update
    And Input "barcode1" "barcode2" "barcode3" to the barcode box
    And Input "degreeCode" "totalWeight" and "leftOverWeight"
    And Click on To Silver Manufacturer button
    And Go to "mangageMetal"
    And View detail of the metal has "degreeCode"
    Then The leftover weight is "leftOverWeight"
    And View the metal log usage
    Then The weight usages of three items is "weightUsage"

  Scenario: Edit a metal in Glamira Wedding
    Given Go to "mangageMetal"
    When View detail of the metal has "weddingDegreeCode"
    And Input "pipeWeight"
    And Click on Save
    Then The "successfulUpdateMetal" Message is shown

  Scenario: Close a metal
    Given Go to "mangageMetal"
    When View detail of the metal has "wantToCloseDegreeCode"
    And Click on Close then confirm
    Then The "successfulCloseMetal" Message is shown
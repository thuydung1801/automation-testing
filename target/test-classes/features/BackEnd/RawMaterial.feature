Feature: Manage Raw Material

  Background: Login in admin page
    Given Login "adminPage" with "account" and "passWord"

  Scenario Outline: Add a new raw material
    Given Go to "rawMaterialPage"
    When Click on Add New Raw Material
    And Input information "<serialNo>" "materialWeight" "brand" "instockDate" Select "<materialAlloy>" "<fineMaterial>" "<isNewRaw>"
    And Click on Save
    Then The "successfulSaveRawMaterial" Message is shown
    Examples:
      | materialAlloy | fineMaterial | isNewRaw | serialNo             |
      | 99            | Gold         | Yes      | rawMaterialserialNo1 |
      | 95            | Silver       | No       | rawMaterialserialNo2 |

  Scenario Outline: Edit a raw material
    Given Go to "rawMaterialPage"
    When View detail of the material has "<serialNo>"
    And Input information "<serialNo>" "materialWeight" "brand" "instockDate" Select "<materialAlloy>" "<fineMaterial>" "<isNewRaw>"
    And Click on Save
    Then The "successfulSaveRawMaterial" Message is shown
    Examples:
      | materialAlloy | fineMaterial | isNewRaw | serialNo             |
      | 95            | Silver       | No       | rawMaterialserialNo1 |
      | 99            | Gold         | Yes      | rawMaterialserialNo2 |

  Scenario: Log usage when creating a metal uses this raw material
    Given Go to "mangageMetal"
    When Click on Add new metal button
    And Input "metalCode" to metal code box
    And Input "metalWeight" "qty" "rawMaterialserialNo1"
    And Click on New metal checkbox and click Save button
    And Go to "rawMaterialPage"
    And View detail of the material has "rawMaterialserialNo1"
    And View the History
    Then The weight usage for the "metalCode" is "rawMaterialweightUsage"

  Scenario: Log usage when creating a chain uses this raw material
    Given Go to "manageChain"
    When Click on New Semi Product/Chain button
    And Input chain information "newChainCode" "chainType" "chainAlloy" "chainColor" "weightOfChain" "rawMaterialserialNo1" "chainQty"
    And Click on Save
    And Go to "rawMaterialPage"
    And View detail of the material has "rawMaterialserialNo1"
    And View the History
    Then The weight usage for the "newChainCode" is "rawMaterialweightUsage"
    # currently, weight usage still equal weight of chain (it must be = weigh of chain * gold alloy/1000)
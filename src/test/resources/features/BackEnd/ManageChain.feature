Feature: Manage Chain

  Background: login in admin page
    Given Login "adminPage" with "account" and "passWord"

  Scenario Outline: Add new chain
    Given Go to "manageChain"
    When Click on New Semi Product/Chain button
    And Input chain information "<stockID>" "<chain type>" "<chain alloy>" "<chain color>" "weightOfChain" "<rawMaterialserialNo>" "chainQty"
    And Click on Save
    Then The "<successfulSaveChain>" Message is shown
    Examples:
      | chain type        | chain alloy    | chain color | stockID  | rawMaterialserialNo  | successfulSaveChain |
      | Forzentina        | 375 Gold - 9K  | Rose        | stockID1 | rawMaterialserialNo1 | successfulSaveChain |
      | Diamond Cut Spiga | 585 Gold - 14K | Yellow      | stockID2 | rawMaterialserialNo1 | successfulSaveChain |
      | Curb  With Bar    | 750 Gold - 18K | Yellow      | stockID3 | rawMaterialserialNo1 | successfulSaveChain |
      | Twist Chain       | 925 Silver     | White       | stockID4 | abcde                | errorSaveChain      |

  Scenario Outline: Edit a chain (add plus chain weight)
    Given Go to "manageChain"
    When View detail of the chain has "stockID1"
    And Input plus weight "plusChainWeight" "<proleFee>" "<extra>"
    And Click on Save
    Then The "<successfulSaveChain>" Message is shown
    Examples:
      | proleFee | extra | successfulSaveChain |
      | 0.01     | 0.01  | successfulSaveChain |
      |          |       | errorSaveChain      |
    # currently, still add successfully without prole fee and extra (on M1, they are required)

  Scenario: Log usage when update chain code for an item
    Given Go to "updateProductionProcess"
    When Input "needAddChainCodeBarcode" to the barcode box
    And Input "chainCode" and "chainWeight"
    And Click on Take in button
    And Go to "manageChain"
    And View detail of the chain has "chainCode"
    And View the chain's history usage
    Then The weight usage logged is "chainWeight"


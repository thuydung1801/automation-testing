Feature: Update production process

  Background: login to admin page
    Given Login "adminPage" with "account" and "passWord"
#  ------------------- Glamira Weddings---------------------------------
  @GlamiraWeddings
  @updateFromCasting
  Scenario: Update process from Casting
    Given Go to "updateProductionProcess"
    When Input "barcode" to the barcode box
    And Click on Take in button
    Then The "successfulSave" Message is shown
    And Input "barcode" to the barcode box
    And Input "castingWeight" to the weight box
    And Select the "staff"
    And Click on Take off button
    Then The "successfulTakeoff" Message is shown

  @updateFromLathe
  Scenario: Update process from Lathe to CNC machine
    Given Go to "updateProductionProcess"
    When Input "barcode" to the barcode box
    And Input "latheWeight" to the weight box
    And Click on To CNC Machine button
    Then The "successfulSave" Message is shown

  @updateFromCNCMachineToWeddingManufacturer
  Scenario: Update process from CNC machine to wedding manufacturer
    Given Go to "updateProductionProcess"
    When Input "barcode" to the barcode box
    And Input "CNCMachineWeight" to the weight box
    And Input "steelWeight" to the steel weight box
    And Select the "staff"
    And Click on To Wedding Manufacturer button
    Then The "successfulSave" Message is shown

  @updateFromWeddingManufacturerToQualifyControl
  Scenario: Update process from wedding manufacturer to qualify control
    Given Go to "updateProductionProcess"
    When Input "barcode" to the barcode box
    And Input "weight" to the weight box
    And Input "stoneWeight" to the stone weight box
#    And Input "semiWeight" to the semi weight box
    And Input "stoneQty" to the stone quantity box
    And Select "settingMethod"
    And Select the polishing "staff", levelling "staff", stone setting "staff"
    And Click on To Next Step button
    Then The "successfulTakeoff" Message is shown
#
  @updateFromCNCMachineToPolishing
  Scenario: Update process from CNC machine to polishing
    Given Go to "updateProductionProcess"
    When Input "barcode" to the barcode box
    And Input "CNCMachineWeight" to the weight box
    And Input "steelWeight" to the steel weight box
    And Select the "staff"
    And Click on To Polishing button
    Then The "successfulTakeoff" Message is shown

  @updateFromPolishing
  Scenario: Update process from polishing to polishing finished
    Given Go to "updateProductionProcess"
    When Input "barcode" to the barcode box
    And Input "polishingWeight" to the weight box
#    And Input "semiWeight" to the semi weight box
    And Select the "staff"
    And Click on To Polishing Finished button
    Then The "successfulTakeoff" Message is shown


  @updateFromPolishingFinished
  Scenario: Update process from polishing finished
    Given Go to "updateProductionProcess"
    When Input "barcode" to the barcode box
    And Input "weight" to the weight box
#    And Input "semiWeight" to the semi weight box
    And Select the "staff"
    And Click on To Next Step button
    Then The "successfulTakeoff" Message is shown

  @updateFromEngraving
  Scenario: Update process from engraving
    Given Go to "updateProductionProcess"
    When Input "barcode" to the barcode box
    And Input "weight" to the weight box
#    And Input "semiWeight" to the semi weight box
    And Select the "staff"
    And Click on To Next Step button
    Then The "successfulTakeoff" Message is shown

  @updateFromQualityControlToFinished
  Scenario: Update process from quality control to finished
    Given Go to "updateProductionProcess"
    When Input "barcode" to the barcode box
    And Input "weight" to the weight box
#    And Input "semiWeight" to the semi weight box
    And Select the "staff"
    And Click on To Finished button
    Then The "successfulFinished" Message is shown

#--------------------GlamiraDiamonds-------------------------------------
  @GlamiraDiamonds
  @UpdateFromWPM
  Scenario: Update process from waxing per machine to casting
    Given Go to "updateProductionProcess"
    When Input "diamond'sItemBarcode" to the barcode box
    And Click on Take in button
    Then The "successfulSave" Message is shown
    And Input "diamond'sItemBarcode" to the barcode box
    And Select the "staff"
    And Click on Take off button
    Then The "successfulTakeoff" Message is shown

  @UpdateFromCasting
  Scenario: Update process from Casting
    Given Go to "updateProductionProcess"
    When Input "diamond'sItemBarcode" to the barcode box
    And Click on Take in button
    Then The "successfulSave" Message is shown
    And Input "diamond'sItemBarcode" to the barcode box
    And Input "castingWeight" to the weight box
    And Select the "staff"
    And Click on Take off button
    Then The "successfulTakeoff" Message is shown

  @UpdateFromSmoothing
  Scenario: Update process from Smoothing to levelling
    Given Go to "updateProductionProcess"
    When Input "diamond'sItemBarcode" to the barcode box
    And Input "weight" to the weight box
    And Click on Take in button
    Then The "successfulSave" Message is shown
    And Input "diamond'sItemBarcode" to the barcode box
    And Input "weight" to the weight box
    And Select the "staff"
    And Click on To Next Step button
    Then The "successfulTakeoff" Message is shown

  @UpdateFromLevelling
  Scenario: Update process from levelling
    Given Go to "updateProductionProcess"
    When Input "diamond'sItemBarcode" to the barcode box
    And Input "weight" to the weight box
    And Select the "staff"
    And Click on To Next Step button
    Then The "successfulTakeoff" Message is shown

  @UpdateFromPolishingToWaitingStone
  Scenario: Update process from polishing to waiting stone
    Given Go to "updateProductionProcess"
    When Input "diamond'sItemBarcode" to the barcode box
    And Input "weight" to the weight box
    And Select the "staff"
    And Click on To Waiting Stone button
    Then The "successfulSave" Message is shown

  @UpdateFromWaitingStone
  Scenario: Update process from waiting stone to stone setting
    Given Go to "updateProductionProcess"
    When Input "diamond'sItemBarcode" to the barcode box
    And Input "weight" to the weight box
    And Select the "staff"
    And Click on To Next Step button
    Then The "successfulTakeoff" Message is shown

  @UpdateFromStoneSetting
  Scenario: Update process from stone setting to polishing finished without updating stone process
    Given Go to "updateProductionProcess"
    When Input "diamond'sItemBarcode" to the barcode box
    And Input "weight" to the weight box
    And Input "stoneWeight" to the stone weight box
#    And Input "semiWeight" to the semi weight box
    And Input "stoneQty" to the stone quantity box
    And Select "settingMethod"
    And Select the "staff"
    And Click on To Polishing Finished button
    Then The "stoneNotReady" Message is shown

  Scenario: Update process from stone setting to polishing finished successfully
    Given Go to "updateProductionProcess"
    When Input "diamond'sItemBarcode" to the barcode box
    And Input "weight" to the weight box
    And Input "stoneWeight" to the stone weight box
#    And Input "semiWeight" to the semi weight box
    And Input "stoneQty" to the stone quantity box
    And Select "settingMethod"
    And Select the "staff"
    And Click on To Polishing Finished button
    Then The "successfulTakeoff" Message is shown

  @UpdateFromPolishingFinished
  Scenario: Update process from polishing finished
    Given Go to "updateProductionProcess"
    When Input "diamond'sItemBarcode" to the barcode box
    And Input "weight" to the weight box
#    And Input "semiWeight" to the semi weight box
    And Select the "staff"
    And Click on To Next Step button
    Then The "successfulTakeoff" Message is shown

  @UpdateFromEngraving
  Scenario: Update process from engraving
    Given Go to "updateProductionProcess"
    When Input "diamond'sItemBarcode" to the barcode box
    And Input "weight" to the weight box
#    And Input "semiWeight" to the semi weight box
    And Select the "staff"
    And Click on To Next Step button
    Then The "successfulTakeoff" Message is shown

  @UpdateFromQualityControlToFinished
  Scenario: Update process from quality control to finished
    Given Go to "updateProductionProcess"
    When Input "diamond'sItemBarcode" to the barcode box
    And Input "weight" to the weight box
#    And Input "semiWeight" to the semi weight box
    And Select the "staff"
    And Click on To Finished button
    Then The "successfulFinished" Message is shown

#--------------------Has chain items-------------------------------------
  @HasChainItem
  @UpdateFromWPM
  Scenario: Update process from waxing per machine to casting
    Given Go to "updateProductionProcess"
    When Input "hasChainItemBarcode" to the barcode box
    And Click on Take in button
    Then The "successfulSave" Message is shown
    And Input "hasChainItemBarcode" to the barcode box
    And Select the "staff"
    And Click on Take off button
    Then The "successfulTakeoff" Message is shown

  @UpdateFromCasting
  Scenario: Update process from Casting
    Given Go to "updateProductionProcess"
    When Input "hasChainItemBarcode" to the barcode box
    And Input "chainCode" and "chainWeight"
    And Click on Take in button
    Then The "successfulSave" Message is shown
    And Input "hasChainItemBarcode" to the barcode box
    And Input "castingWeight" to the weight box
    And Select the "staff"
    And Click on Take off button
    Then The "successfulTakeoff" Message is shown

#--------------------- multiple update for Weddings-----------------------

  @MultipleUpdateForWeddings
  Scenario: Update process to casting
    Given Go to "updateProductionProcess"
    When Click on Multiple Update
    And Input "weddingBarcode1" "weddingBarcode2" "weddingBarcode3" to the barcode box
    And Click on Update button
    Then The "multipleUpdateSuccessful" Message is shown

  @CanNotMultipleUpdateFromCasting
  Scenario: Can not multiple update from casting to other steps
    Given Go to "updateProductionProcess"
    When Click on Multiple Update
    And Input "weddingBarcode1" "weddingBarcode2" "weddingBarcode3" to the barcode box
    And Click on Update button
    Then The "errorUpdated" Message is shown

#--------------------- multiple update for Diamonds-----------------------
  @MultipleUpdateToWPM
  Scenario: Update process to waxing per machine
    Given Go to "updateProductionProcess"
    When Click on Multiple Update
    And Input "barcode1" "barcode2" "barcode3" to the barcode box
    And Click on Update button
    Then The "multipleUpdateSuccessful" Message is shown

  @MultipleUpdateFromWPMToCasting
  Scenario: Update process from waxing per machine to casting successfully
    Given Go to "updateProductionProcess"
    When Click on Multiple Update
    And Input "barcode1" "barcode2" "barcode3" to the barcode box
    And Click on Update button
    Then The "multipleUpdateSuccessful" Message is shown

  @MultipleUpdateFromCastingToSilverManufacturer
  Scenario: Update process from casting successfully
    Given Go to "updateProductionProcess"
    When Click on Multiple Update
    And Input "barcode1" "barcode2" "barcode3" to the barcode box
    And Input "degreeCode" "totalWeight" and "leftOverWeight"
    And Click on To Silver Manufacturer button
    Then The "multipleUpdateSuccessful" Message is shown
    And Go to "mangageMetal"
    And View detail of the metal has "degreeCode"
    And View the metal log usage
    Then The weight usages of three items is "weightUsage"

  @CanNotMultipleUpdateFromSilverManufacturer
  Scenario: Can not multiple update at SilverManufacturer
    Given Go to "updateProductionProcess"
    When Click on Multiple Update
    And Input "barcode1" "barcode2" "barcode3" to the barcode box
    And Click on Update button
    Then The "errorUpdated" Message is shown

# ---------------- can not multiple update-------------------------
  @CannotMultipleUpdate
  Scenario: Can not multiple update for items had degree code
    Given Go to "updateProductionProcess"
    When Click on Multiple Update
    And Input "degreeCodeBarcode1" "degreeCodeBarcode2" "degreeCodeBarcode3" to the barcode box
    And Input "degreeCode" "totalWeight" and "leftOverWeight"
    And Click on To Silver Manufacturer button
    Then The "hadDegreeCodeMsg" Message is shown

  @CannotMultipleUpdate
  Scenario: Can not multiple update for items have different steps
    Given Go to "updateProductionProcess"
    When Click on Multiple Update
    And Input "aWPMBarcode" "atCastingBarcode" "atCastingBarcode2" to the barcode box
    And Click on Update button
    Then The "notTheSameStepsMsg" Message is shown
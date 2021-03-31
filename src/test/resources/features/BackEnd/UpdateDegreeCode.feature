Feature: Update degree code

  Background: Login in backend
    Given Login "adminPage" with "account" and "passWord"

  @updateSuccessfully
  Scenario: Update degree code successfully
    Given Go to "updateDegreeCode"
    When Enter "haveToUpdateDegreeCodeBarcode" to the barcode box
    And Enter "degreeCode" and "goldWeight"
    Then The "successfulUpdateDegreeCode" Message is shown

  Scenario: Update too degree code successfully
    Given Go to "updateDegreeCode"
    When Enter "haveToUpdateDegreeCodeBarcode" to the barcode box
    And Enter "degreeCode" and "goldWeight"
    And Click on Add More button
    And Enter "degreeCode2" and "goldWeight2" to the second row
    Then The "successfulUpdateDegreeCode" Message is shown

  @canNotUpdate
  Scenario: Can not update when the gold types are not the same
    Given Go to "updateDegreeCode"
    When Enter "notSameGoldTypeBarcode" to the barcode box
    And Enter "degreeCode" and "goldWeight"
    Then The "notSameGoldTypeMsg" Message is shown

#------------------ multiple update------------------------------\
  @multipleUpdateSuccessfully
  Scenario: Update three degree code for three barcodes successfully
    Given Go to "updateDegreeCode"
    When Input "degreeCode" to degree code box and click on Add to list
    And Input "degreeCode2" to degree code box and click on Add to list
    And Input "degreeCode3" to degree code box and click on Add to list
    And Input "degreeCodeBarcode1" to barcode box and click on Add to list
    And Input "degreeCodeBarcode2" to barcode box and click on Add to list
    And Input "degreeCodeBarcode3" to barcode box and click on Add to list
    And Click on checkboxes
    And Click on Save button
    Then The "successfulMultipleUpdateDegreeCode" Message is shown

  @canNotUpdate
  Scenario: Can not update added degree codes
    Given Go to "updateDegreeCode"
    When Input "degreeCode" to degree code box and click on Add to list
    And Input "degreeCode2" to degree code box and click on Add to list
    And Input "degreeCode3" to degree code box and click on Add to list
    And Input "degreeCodeBarcode1" to barcode box and click on Add to list
    And Input "degreeCodeBarcode2" to barcode box and click on Add to list
    And Input "degreeCodeBarcode3" to barcode box and click on Add to list
    And Click on checkboxes
    And Click on Save button
    Then The "degreeCodeExistedMsg" Message is shown
Feature: order an item
  Scenario: view an item
    Given Go to "category" url
    When Click on "item"
    Then The site will redirect to "itemDetail" url

  Scenario: add item to cart without selecting ringsize
    Given Go to "itemDetail" url
    When Click on "AddToCart"
    Then The "errorMessage" "Phải nhập thông tin." is shown

  Scenario: add item to cart sucessfully
    Given Go to "itemDetail" url
    When Click on "SelectSizeButton" then select "selectSize"
    And Click on "AddToCart"
    And Click on "ViewCart"
#    Then The "itemSKU" is "NopeShape3SKU"
    Then The "ringSize" is "selectedSize"
    And The "ringWidth" is "selectedWidth"
    And The "metal" is "selectedMetal"
    And The "stoneType" is "selectedStoneType"
    And The "profile" is "selectedProfile"
    And The "finish" is "selectedFinish"
    And The "thickness" is "selectedThickness"


Feature:
  Background:
    Given Go to "adminPage" url
    When Insert adminM2 into box have id: emailAdmin
    And Insert admin123 into box have id: passAdmin
    And Click button by class signInBtn
    Then Successfully into DashboardPage front site
    Given Go to "ManageInstockRequest" url
#    viết môi trường lọc


  @Test01
  Scenario: Tranfer 1 item
    And Wait about 5 seconds
    When Insert barcode: 1350075027-336996 into barcode box and click Enter
    And Wait about 5 seconds
    And Click select this order
    And I click button has text Transfer to Shippout Waiting
    Then Show Messages in back end: A total of 1 Item(s) transferred to shipout waiting.
#    And Item state update: Ship out waiting
  @Test02
  Scenario: Tranfer 5 items
    Given Go to "ManageInstockRequest" url
    And Wait about 2 seconds
    When Insert barcode: 7029261493-572439 into barcode box and click Enter
    And Wait about 2 seconds
    And Click select this order
    When Insert barcode: 7029261617-635996 into barcode box and click Enter
    And Wait about 2 seconds
    And Click select this order
    When Insert barcode: 620315367-525792 into barcode box and click Enter
    And Wait about 2 seconds
    And Click select this order
    When Insert barcode: 729261276-239641 into barcode box and click Enter
    And Wait about 2 seconds
    And Click select this order
    When Insert barcode: 620315291-238360 into barcode box and click Enter
    And Wait about 2 seconds
    And Click select this order
    And I click button has text Transfer to Shippout Waiting
    Then Show Messages in back end: A total of 5 Item(s) transferred to shipout waiting.
  @Test03
  Scenario: filter item state = In stock Order Hold On và process status = Finished and choose 1 item by row
    When Choose filter item state = instockOrderHoldOn và process status = Finished
    And Wait about 2 seconds
    When Choose item have row :2
    And Wait about 2 seconds
    And I click button has text Transfer to Shippout Waiting
    Then Show Messages in back end: A total of 1 Item(s) transferred to shipout waiting.
  @Test04
  Scenario: filter item state = In stock Order Hold On và process status = Finished and choose 2 item by row
    When Choose filter item state = instockOrderHoldOn và process status = Finished
    And Wait about 2 seconds
#    When Choose item have row :2
#    And Wait about 2 seconds
    When Choose item have row :4
    And Wait about 2 seconds
    And I click button has text Transfer to Shippout Waiting
    Then Show Messages in back end: A total of 2 Item(s) transferred to shipout waiting.

    







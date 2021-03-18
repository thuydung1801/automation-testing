package autoframework.steps;

import autoframework.pages.InstockItemPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class InstockItemStep{
    InstockItemPage nia = new InstockItemPage();

    @When("Insert barcode: (.*) into barcode box and click Enter")
        public void getTable(String barcode){
            nia.insertBarcode(barcode);
        }

    @And("^Click select this order$")
    public void clickSelectThisOrder() {
        nia.selectOrder();
    }
    @Then("Show Messages in back end: (.*)")
    public void getMsgItem(String expectMsg){
        System.out.println("show Messages: " + expectMsg );
        nia.getMsgTranfer(expectMsg);
    }
    @And("Item state update: (.*)")
    public void sucTranfer(String expectItem){
        nia.sucTranfer(expectItem);
    }
    @When("Choose filter item state = (.*) và process status = (.*)")
    public void getFilter(String itemState, String processStatus){
        nia.getFilter(itemState, processStatus);
    }

    @When("Choose item have row :(.*)")
    public void chooseRow(int numberOfRow){
        nia.chooseRow(numberOfRow);
    }
}



package autoframework.steps.backEnd;

import autoframework.pages.backEnd.ManageItemsArrivedPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ManageItemsArrivedStep {
    ManageItemsArrivedPage nia = new ManageItemsArrivedPage();
    @When ("Choose item have row in Manage Items Arrived Page : (.*)")
    public void chooseRowManageItemsArrivedPage(int row){
        nia.chooseRowManageItemsArrivedPage(row);
    }

    @And("^Click button to ship out$")
    public void clickButtonToShipOut() {
        nia.clickButtonToShipOut();
    }

    @And("^Click button : Ok$")
    public void clickButtonOk() {
        nia.clickButtonOk();
    }
    @Then("Show Messages in Manage Items Arrived: (.*)")
    public void getMsgItem(String expectMsg){
        System.out.println("show Messages: " + expectMsg );
        nia.getMsgTranferInManageItemsArrivedPage(expectMsg);
    }
}

package autoframework.steps;

import autoframework.pages.ManageItemsArrivedPage;
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
}

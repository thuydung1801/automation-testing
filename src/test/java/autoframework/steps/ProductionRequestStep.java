package autoframework.steps;

import autoframework.pages.ProductionRequestPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ProductionRequestStep {
    @Steps
    ProductionRequestPage nia;
    @And("^Filter items match pre-condition for starting pProduction$")
    public void filterItemsMatchPreConditionForStartingPProduction() {
        nia.filterItemsMatchPreConditionForStartingPProduction();
    }
    @And("^Take action Start production$")
    public void takeActionStartProduction() {
        nia.takeActionStartProduction();

    }
//    @Then("^The \"([^\"]*)\" Message is shown$")
//    public void theMessageIsShown(String message) throws Throwable {
//        nia.theMessageIsShown(message);
//    }

    @And("^Click on Create for in stock items button$")
    public void clickOnCreateForInStockItemsButton() {
        nia.clickOnCreateForInStockItemsButton();

    }



    @And("^Input information \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" then click Save$")
    public void inputInformationThenClickSave(String itemQty, String itemSKU, String itemName, String price) throws Throwable {
        nia.inputInformationThenClickSave(itemQty, itemSKU, itemName, price);
    }

    @When("^Enter \"([^\"]*)\" to scan barcode box$")
    public void enterToScanBarcodeBox(String barcode) throws Throwable {
        nia.enterToScanBarcodeBox(barcode);
    }

    @And("^Choose the item$")
    public void chooseTheItem() {
        nia.chooseTheItem();
    }

    @And("^Take action \"([^\"]*)\"$")
    public void takeAction(String action) throws Throwable {
        nia.takeAction(action);
    }
}

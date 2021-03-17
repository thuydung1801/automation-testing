package autoTest.steps;

import autoTest.steps.serenity.ProductionRequestEndUserSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ProductionRequestStepdefs {
    @Steps
    ProductionRequestEndUserSteps productionRequestEndUserSteps;
    @And("^Filter items match pre-condition for starting pProduction$")
    public void filterItemsMatchPreConditionForStartingPProduction() {
        productionRequestEndUserSteps.filterItemsMatchPreConditionForStartingPProduction();
    }
    @And("^Take action Start production$")
    public void takeActionStartProduction() {
        productionRequestEndUserSteps.takeActionStartProduction();

    }
//    @Then("^The \"([^\"]*)\" Message is shown$")
//    public void theMessageIsShown(String message) throws Throwable {
//        productionRequestEndUserSteps.theMessageIsShown(message);
//    }

    @And("^Click on Create for in stock items button$")
    public void clickOnCreateForInStockItemsButton() {
        productionRequestEndUserSteps.clickOnCreateForInStockItemsButton();

    }



    @And("^Input information \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" then click Save$")
    public void inputInformationThenClickSave(String itemQty, String itemSKU, String itemName, String price) throws Throwable {
        productionRequestEndUserSteps.inputInformationThenClickSave(itemQty, itemSKU, itemName, price);
    }

    @When("^Enter \"([^\"]*)\" to scan barcode box$")
    public void enterToScanBarcodeBox(String barcode) throws Throwable {
        productionRequestEndUserSteps.enterToScanBarcodeBox(barcode);
    }

    @And("^Choose the item$")
    public void chooseTheItem() {
        productionRequestEndUserSteps.chooseTheItem();
    }

    @And("^Take action \"([^\"]*)\"$")
    public void takeAction(String action) throws Throwable {
        productionRequestEndUserSteps.takeAction(action);
    }
}

package autoframework.steps.backEnd;

import autoframework.pages.backEnd.UpdateStoneProcessPages;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.awt.*;

public class UpdateStoneProcessStep {
    @Steps
    UpdateStoneProcessPages updatestoneprocessPages;

    @Given("^When I click Productions menu$")
    public void whenIClickProductionsMenu() {
        updatestoneprocessPages.ProductionsMenu();
    }

    @When("^I click in Update Stone Process grid$")
    public void iClickInUpdateStoneProcessGrid() {
        updatestoneprocessPages.UpdateStoneProcessGrid();
    }

    @And("^I enter \"([^\"]*)\" in barcode box$")
    public void iEnterInBarcodeBox(String barcode){
        updatestoneprocessPages.searchitemwithbarcode(barcode);
    }

    @And("^Open another tab for stone management$")
    public void openAnotherTabForStoneManagement()throws AWTException {
        updatestoneprocessPages.openManageStone();

    }

    @And("^get id for stone has status = ordered$")
    public void getIdForStoneHasStatusOrder() {
        updatestoneprocessPages.GetInfoOfStoneOrder();
    }
}
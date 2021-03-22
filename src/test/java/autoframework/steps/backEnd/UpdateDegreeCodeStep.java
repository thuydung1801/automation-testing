package autoframework.steps.backEnd;

import autoframework.pages.backEnd.UpdateDegreeCodePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class UpdateDegreeCodeStep {
    @Steps
    UpdateDegreeCodePage nia;
    @And("^Enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void enterGoldCode(String degreeCode, String  goldWeight) throws Throwable {
        nia.enterGoldCode(degreeCode, goldWeight);
    }

    @When("^Enter \"([^\"]*)\" to the barcode box$")
    public void enterBarcode(String barcode) throws Throwable {
        nia.enterBarcode(barcode);
    }

    @And("^Click on Add More button$")
    public void clickOnAddMoreButton() {
        nia.clickOnAddMoreButton();
    }

    @And("^Enter \"([^\"]*)\" and \"([^\"]*)\" to the second row$")
    public void enterGoldCodeToTheSecondRow(String goldCode, String goldWeight) throws Throwable {
        nia.enterGoldCodeToTheSecondRow(goldCode, goldWeight);
    }

    @When("^Input \"([^\"]*)\" to degree code box and click on Add to list$")
    public void inputToDegreeCodeBoxAndClickOnAddToList(String degreeCode) throws Throwable {
        nia.inputToDegreeCodeBoxAndClickOnAddToList(degreeCode);
    }

    @And("^Input \"([^\"]*)\" to barcode box and click on Add to list$")
    public void inputToBarcodeBoxAndClickOnAddToList(String barcode) throws Throwable {
        nia.inputToBarcodeBox(barcode);
    }

    @And("^Click on Save button$")
    public void clickOnSaveButton() {
        nia.clickOnSaveButton();
    }

    @And("^Click on checkboxes$")
    public void clickOnCheckboxes() {
        nia.clickOnCheckboxes();
    }
}

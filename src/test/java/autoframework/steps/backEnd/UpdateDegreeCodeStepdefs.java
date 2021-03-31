package autoframework.steps.backEnd;

import autoframework.pages.backEnd.UpdateDegreeCodePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class UpdateDegreeCodeStepdefs {
    @Steps
    UpdateDegreeCodePage updateDegreeCodePage;
    @And("^Enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void enterGoldCode(String degreeCode, String  goldWeight) throws Throwable {
        updateDegreeCodePage.enterGoldCode(degreeCode, goldWeight);
    }

    @When("^Enter \"([^\"]*)\" to the barcode box$")
    public void enterBarcode(String barcode) throws Throwable {
        updateDegreeCodePage.enterBarcode(barcode);
    }

    @And("^Click on Add More button$")
    public void clickOnAddMoreButton() {
        updateDegreeCodePage.clickOnAddMoreButton();
    }

    @And("^Enter \"([^\"]*)\" and \"([^\"]*)\" to the second row$")
    public void enterGoldCodeToTheSecondRow(String goldCode, String goldWeight) throws Throwable {
        updateDegreeCodePage.enterGoldCodeToTheSecondRow(goldCode, goldWeight);
    }

    @When("^Input \"([^\"]*)\" to degree code box and click on Add to list$")
    public void inputToDegreeCodeBoxAndClickOnAddToList(String degreeCode) throws Throwable {
        updateDegreeCodePage.inputToDegreeCodeBoxAndClickOnAddToList(degreeCode);
    }

    @And("^Input \"([^\"]*)\" to barcode box and click on Add to list$")
    public void inputToBarcodeBoxAndClickOnAddToList(String barcode) throws Throwable {
        updateDegreeCodePage.inputToBarcodeBox(barcode);
    }

    @And("^Click on Save button$")
    public void clickOnSaveButton() {
        updateDegreeCodePage.clickOnSaveButton();
    }

    @And("^Click on checkboxes$")
    public void clickOnCheckboxes() {
        updateDegreeCodePage.clickOnCheckboxes();
    }
}

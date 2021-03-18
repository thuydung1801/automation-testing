package autoTest.steps;

import autoTest.steps.serenity.UpdateDegreeCodeEndUserSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class UpdateDegreeCodeStepdefs {
    @Steps
    UpdateDegreeCodeEndUserSteps updateDegreeCodeEndUserSteps;
    @And("^Enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void enterGoldCode(String degreeCode, String  goldWeight) throws Throwable {
        updateDegreeCodeEndUserSteps.enterGoldCode(degreeCode, goldWeight);
    }

    @When("^Enter \"([^\"]*)\" to the barcode box$")
    public void enterBarcode(String barcode) throws Throwable {
        updateDegreeCodeEndUserSteps.enterBarcode(barcode);
    }

    @And("^Click on Add More button$")
    public void clickOnAddMoreButton() {
        updateDegreeCodeEndUserSteps.clickOnAddMoreButton();
    }

    @And("^Enter \"([^\"]*)\" and \"([^\"]*)\" to the second row$")
    public void enterGoldCodeToTheSecondRow(String goldCode, String goldWeight) throws Throwable {
        updateDegreeCodeEndUserSteps.enterGoldCodeToTheSecondRow(goldCode, goldWeight);
    }

    @When("^Input \"([^\"]*)\" to degree code box and click on Add to list$")
    public void inputToDegreeCodeBoxAndClickOnAddToList(String degreeCode) throws Throwable {
        updateDegreeCodeEndUserSteps.inputToDegreeCodeBoxAndClickOnAddToList(degreeCode);
    }

    @And("^Input \"([^\"]*)\" to barcode box and click on Add to list$")
    public void inputToBarcodeBoxAndClickOnAddToList(String barcode) throws Throwable {
        updateDegreeCodeEndUserSteps.inputToBarcodeBox(barcode);
    }

    @And("^Click on Save button$")
    public void clickOnSaveButton() {
        updateDegreeCodeEndUserSteps.clickOnSaveButton();
    }

    @And("^Click on checkboxes$")
    public void clickOnCheckboxes() {
        updateDegreeCodeEndUserSteps.clickOnCheckboxes();
    }
}

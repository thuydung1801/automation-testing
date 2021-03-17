package autoTest.steps;

import autoTest.steps.serenity.MetalEndUserSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ManageMetalStepdefs {
    @Steps
    MetalEndUserSteps metalEndUserSteps;



    @And("^View detail of the metal has \"([^\"]*)\"$")
    public void viewDetailOfTheMetalHas(String degreeCode) throws Throwable {
        metalEndUserSteps.viewDetailMetal(degreeCode);;
    }

    @And("^View the metal log usage$")
    public void viewTheMetalLogUsage() {
        metalEndUserSteps.viewTheMetalLogUsage();
    }

    @Then("^The weight usages of three items is \"([^\"]*)\"$")
    public void theWeightUsagesOfThreeItemsIs(String weightUsage) throws Throwable {
        metalEndUserSteps.theWeightUsagesOfThreeItemsIs(weightUsage);
    }

    @When("^Click on Add new metal button$")
    public void clickOnAddNewMetalButton() {
        metalEndUserSteps.clickOnAddNewMetalButton();
    }


    @And("^Select \"([^\"]*)\" and \"([^\"]*)\"$")
    public void selectGoldType$GoldColor(String goldType, String goldColor) throws Throwable {
        metalEndUserSteps.selectGoldType$GoldColor(goldType, goldColor);
    }


    @And("^Input \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void inputMetalWeight$RawMaterialNo(String metalWeight, String qty, String rawMaterialNo) throws Throwable {
        metalEndUserSteps.inputMetalWeight$RawMaterialNo(metalWeight, qty, rawMaterialNo);
    }

    @And("^Click on New metal checkbox$")
    public void clickOnNewMetalCheckbox() {
        metalEndUserSteps.clickOnNewMetalCheckbox();
    }

    @And("^Click on New metal checkbox and click Save button$")
    public void clickOnNewMetalCheckboxAndClickSaveButton() {
        metalEndUserSteps.clickOnNewMetalCheckboxAndClickSaveButton();
    }

    @And("^Input second raw material \"([^\"]*)\", \"([^\"]*)\"$")
    public void inputSecondRawMaterial(String secondRawMaterialNo, String secondRawMaterialWeight) throws Throwable {
        metalEndUserSteps.inputSecondRawMaterial(secondRawMaterialNo, secondRawMaterialWeight);
    }

    @And("^Choose the \"([^\"]*)\"$")
    public void chooseManufacturer(String manufacturer) throws Throwable {
        metalEndUserSteps.chooseManufacturer(manufacturer);
    }

    @And("^Input \"([^\"]*)\"$")
    public void inputPipeWeight(String pipeWeight) throws Throwable {
        metalEndUserSteps.inputPipeWeight(pipeWeight);
    }

    @And("^Click on Save$")
    public void clickOnSave() {
        metalEndUserSteps.clickOnSave();
    }

    @And("^Click on Close then confirm$")
    public void clickOnClose() {
        metalEndUserSteps.clickOnClose();
    }

    @Then("^The weight usage logged is \"([^\"]*)\"$")
    public void theWeightUsageLoggedIs(String weightUsage) throws Throwable {
        metalEndUserSteps.theWeightUsageLoggedIs(weightUsage);
    }

    @Then("^The leftover weight is \"([^\"]*)\"$")
    public void theLeftoverWeightIs(String leftOverWeight) throws Throwable {
        metalEndUserSteps.theLeftoverWeightIs(leftOverWeight);
    }

    @And("^Input \"([^\"]*)\" to metal code box$")
    public void inputToMetalCodeBox(String metalCode) throws Throwable {
        metalEndUserSteps.inputToMetalCodeBox(metalCode);
    }
}

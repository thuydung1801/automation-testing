package autoframework.steps.backEnd;

import autoframework.pages.backEnd.ManageMetalPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ManageMetalStepdefs {
    @Steps
    ManageMetalPage manageMetalPage;



    @And("^View detail of the metal has \"([^\"]*)\"$")
    public void viewDetailOfTheMetalHas(String degreeCode) throws Throwable {
        manageMetalPage.viewDetailMetal(degreeCode);;
    }

    @And("^View the metal log usage$")
    public void viewTheMetalLogUsage() {
        manageMetalPage.viewTheMetalLogUsage();
    }

    @Then("^The weight usages of three items is \"([^\"]*)\"$")
    public void theWeightUsagesOfThreeItemsIs(String weightUsage) throws Throwable {
        manageMetalPage.theWeightUsagesOfThreeItemsIs(weightUsage);
    }

    @When("^Click on Add new metal button$")
    public void clickOnAddNewMetalButton() {
        manageMetalPage.clickOnAddNewMetalButton();
    }


    @And("^Select \"([^\"]*)\" and \"([^\"]*)\"$")
    public void selectGoldType$GoldColor(String goldType, String goldColor) throws Throwable {
        manageMetalPage.selectGoldType$GoldColor(goldType, goldColor);
    }


    @And("^Input \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void inputMetalWeight$RawMaterialNo(String metalWeight, String qty, String rawMaterialNo) throws Throwable {
        manageMetalPage.inputMetalWeight$RawMaterialNo(metalWeight, qty, rawMaterialNo);
    }

    @And("^Click on New metal checkbox$")
    public void clickOnNewMetalCheckbox() {
        manageMetalPage.clickOnNewMetalCheckbox();
    }

    @And("^Click on New metal checkbox and click Save button$")
    public void clickOnNewMetalCheckboxAndClickSaveButton() {
        manageMetalPage.clickOnNewMetalCheckboxAndClickSaveButton();
    }

    @And("^Input second raw material \"([^\"]*)\", \"([^\"]*)\"$")
    public void inputSecondRawMaterial(String secondRawMaterialNo, String secondRawMaterialWeight) throws Throwable {
        manageMetalPage.inputSecondRawMaterial(secondRawMaterialNo, secondRawMaterialWeight);
    }

    @And("^Choose the \"([^\"]*)\"$")
    public void chooseManufacturer(String manufacturer) throws Throwable {
        manageMetalPage.chooseManufacturer(manufacturer);
    }

    @And("^Input \"([^\"]*)\"$")
    public void inputPipeWeight(String pipeWeight) throws Throwable {
        manageMetalPage.inputPipeWeight(pipeWeight);
    }

    @And("^Click on Save$")
    public void clickOnSave() {
        manageMetalPage.clickOnSave();
    }

    @And("^Click on Close then confirm$")
    public void clickOnClose() {
        manageMetalPage.clickOnClose();
    }

    @Then("^The weight usage logged is \"([^\"]*)\"$")
    public void theWeightUsageLoggedIs(String weightUsage) throws Throwable {
        manageMetalPage.theWeightUsageLoggedIs(weightUsage);
    }

    @Then("^The leftover weight is \"([^\"]*)\"$")
    public void theLeftoverWeightIs(String leftOverWeight) throws Throwable {
        manageMetalPage.theLeftoverWeightIs(leftOverWeight);
    }

    @And("^Input \"([^\"]*)\" to metal code box$")
    public void inputToMetalCodeBox(String metalCode) throws Throwable {
        manageMetalPage.inputToMetalCodeBox(metalCode);
    }
}

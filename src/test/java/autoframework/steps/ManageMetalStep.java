package autoframework.steps;

import autoframework.pages.ManageMetalPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ManageMetalStep {
    @Steps
    ManageMetalPage nia;



    @And("^View detail of the metal has \"([^\"]*)\"$")
    public void viewDetailOfTheMetalHas(String degreeCode) throws Throwable {
        nia.viewDetailMetal(degreeCode);;
    }

    @And("^View the metal log usage$")
    public void viewTheMetalLogUsage() {
        nia.viewTheMetalLogUsage();
    }

    @Then("^The weight usages of three items is \"([^\"]*)\"$")
    public void theWeightUsagesOfThreeItemsIs(String weightUsage) throws Throwable {
        nia.theWeightUsagesOfThreeItemsIs(weightUsage);
    }

    @When("^Click on Add new metal button$")
    public void clickOnAddNewMetalButton() {
        nia.clickOnAddNewMetalButton();
    }


    @And("^Select \"([^\"]*)\" and \"([^\"]*)\"$")
    public void selectGoldType$GoldColor(String goldType, String goldColor) throws Throwable {
        nia.selectGoldType$GoldColor(goldType, goldColor);
    }


    @And("^Input \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void inputMetalWeight$RawMaterialNo(String metalWeight, String qty, String rawMaterialNo) throws Throwable {
        nia.inputMetalWeight$RawMaterialNo(metalWeight, qty, rawMaterialNo);
    }

    @And("^Click on New metal checkbox$")
    public void clickOnNewMetalCheckbox() {
        nia.clickOnNewMetalCheckbox();
    }

    @And("^Click on New metal checkbox and click Save button$")
    public void clickOnNewMetalCheckboxAndClickSaveButton() {
        nia.clickOnNewMetalCheckboxAndClickSaveButton();
    }

    @And("^Input second raw material \"([^\"]*)\", \"([^\"]*)\"$")
    public void inputSecondRawMaterial(String secondRawMaterialNo, String secondRawMaterialWeight) throws Throwable {
        nia.inputSecondRawMaterial(secondRawMaterialNo, secondRawMaterialWeight);
    }

    @And("^Choose the \"([^\"]*)\"$")
    public void chooseManufacturer(String manufacturer) throws Throwable {
        nia.chooseManufacturer(manufacturer);
    }

    @And("^Input \"([^\"]*)\"$")
    public void inputPipeWeight(String pipeWeight) throws Throwable {
        nia.inputPipeWeight(pipeWeight);
    }

    @And("^Click on Save$")
    public void clickOnSave() {
        nia.clickOnSave();
    }

    @And("^Click on Close then confirm$")
    public void clickOnClose() {
        nia.clickOnClose();
    }

    @Then("^The weight usage logged is \"([^\"]*)\"$")
    public void theWeightUsageLoggedIs(String weightUsage) throws Throwable {
        nia.theWeightUsageLoggedIs(weightUsage);
    }

    @Then("^The leftover weight is \"([^\"]*)\"$")
    public void theLeftoverWeightIs(String leftOverWeight) throws Throwable {
        nia.theLeftoverWeightIs(leftOverWeight);
    }

    @And("^Input \"([^\"]*)\" to metal code box$")
    public void inputToMetalCodeBox(String metalCode) throws Throwable {
        nia.inputToMetalCodeBox(metalCode);
    }
}

package autoTest.steps.serenity;

import autoTest.pages.ManageMetalPage;

public class MetalEndUserSteps {
    ManageMetalPage manageMetalPage;

    public void viewDetailMetal(String degreeCode) {
        manageMetalPage.viewDetailMetal(degreeCode);

    }

    public void viewTheMetalLogUsage() {
        manageMetalPage.viewTheMetalLogUsage();
    }

    public void theWeightUsagesOfThreeItemsIs(String weightUsage) {
        manageMetalPage.theWeightUsagesOfThreeItemsIs(weightUsage);
    }

    public void clickOnAddNewMetalButton() {
        manageMetalPage.clickOnAddNewMetalButton();
    }

    public void selectGoldType$GoldColor(String goldType, String goldColor) {
        manageMetalPage.selectGoldType$GoldColor(goldType, goldColor);
    }

    public void inputMetalWeight$RawMaterialNo(String metalWeight, String qty, String rawMaterialNo) {
        manageMetalPage.inputMetalWeight$RawMaterialNo(metalWeight, qty, rawMaterialNo);
    }

    public void clickOnNewMetalCheckbox() {
        manageMetalPage.clickOnNewMetalCheckbox();
    }

    public void clickOnNewMetalCheckboxAndClickSaveButton() {
        manageMetalPage.clickOnNewMetalCheckboxAndClickSaveButton();
    }

    public void inputSecondRawMaterial(String secondRawMaterialNo, String secondRawMaterialWeight) {
        manageMetalPage.inputSecondRawMaterial(secondRawMaterialNo, secondRawMaterialWeight);
    }

    public void chooseManufacturer(String manufacturer) {
        manageMetalPage.chooseManufacturer(manufacturer);
    }

    public void inputPipeWeight(String pipeWeight) {
        manageMetalPage.inputPipeWeight(pipeWeight);
    }

    public void clickOnSave() {
        manageMetalPage.clickOnSave();
    }

    public void clickOnClose() {
        manageMetalPage.clickOnClose();

    }

    public void theWeightUsageLoggedIs(String weightUsage) {
        manageMetalPage.theWeightUsageLoggedIs(weightUsage);
    }

    public void theLeftoverWeightIs(String leftOverWeight) {
        manageMetalPage.theLeftoverWeightIs(leftOverWeight);
    }

    public void inputToMetalCodeBox(String metalCode) {
        manageMetalPage.inputToMetalCodeBox(metalCode);
    }
}

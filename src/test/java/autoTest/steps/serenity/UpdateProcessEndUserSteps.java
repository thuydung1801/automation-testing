package autoTest.steps.serenity;

import autoTest.pages.UpdateProcessPage;

public class UpdateProcessEndUserSteps {
    UpdateProcessPage updateProcessPage;

    public void inputToTheBarcodeBox(String barcode) {
        updateProcessPage.enterBarcode(barcode);

    }

    public void clickOnSaveButton() {
        updateProcessPage.clickOnTakeInButton();
    }



    public void inputToTheWeightBox(String weight) {
        updateProcessPage.inputToTheWeightBox(weight);
    }

    public void selectTheStaff(String staff) {
        updateProcessPage.selectTheStaff(staff);
    }

    public void clickOnToCNCMachineButton() {
        updateProcessPage.clickOnToCNCMachineButton();
    }

    public void inputToTheSteelWeightBox(String steelWeight) {
        updateProcessPage.inputToTheSteelWeightBox(steelWeight);
    }

    public void clickOnToPolishingButton() {
        updateProcessPage.clickOnToPolishingButton();
    }

    public void inputToTheSemiWeightBox(String semiWeight) {
        updateProcessPage.inputToTheSemiWeightBox(semiWeight);
    }

    public void inputToTheStoneQuantityBox(String stoneQty) {
        updateProcessPage.inputToTheStoneQuantityBox(stoneQty);
    }

    public void selectSettingMethod(String settingMethod) {
        updateProcessPage.selectSettingMethod(settingMethod);
    }

    public void inputToTheStoneWeightBox(String stoneWeight) {
        updateProcessPage.inputToTheStoneWeightBox(stoneWeight);
    }

    public void clickOnToNextStepButton() {
        updateProcessPage.clickOnToNextStepButton();
    }

    public void clickOnToFinishedButton() {
        updateProcessPage.clickOnToFinishedButton();
    }

    public void clickOnToWaitingStoneButton() {
        updateProcessPage.clickOnToWaitingStoneButton();
    }

    public void inputChainCode(String chainCode, String chainWeight) {
        updateProcessPage.inputChainCode(chainCode, chainWeight);
    }

    public void clickOnToWeddingManufacturerButton() {
        updateProcessPage.clickOnToWeddingManufacturerButton();
    }

    public void selectThePolishingLevellingStoneSettingStaff(String polishingStaff, String levellingStaff, String stoneSettingStaff) {
        updateProcessPage.selectThePolishingLevellingStoneSettingStaff(polishingStaff, levellingStaff, stoneSettingStaff);

    }

    public void clickOnMultipleUpdate() {
        updateProcessPage.clickOnMultipleUpdate();
    }

//    public void inputToTheSecondBox(String barcode2) {
//        updateProcessPage.inputToTheSecondBox(barcode2);
//    }
//
//    public void inputToTheThirdBox(String barcode3) {
//        updateProcessPage.inputToTheThirdBox(barcode3);
//    }

    public void clickOnUpdateButton() {
        updateProcessPage.clickOnUpdateButton();
    }

    public void inputMetalInfo(String degreeCode, String totalWeight, String leftOverWeight) {
        updateProcessPage.inputMetalInfo(degreeCode, totalWeight, leftOverWeight );
    }

    public void clickOnToSilverManufacturerButton() {
        updateProcessPage.clickOnToSilverManufacturerButton();
    }

    public void inputMultipleBarcode(String barcode1, String barcode2, String barcode3) {
        updateProcessPage.inputMultipleBarcode(barcode1, barcode2, barcode3);
    }
}

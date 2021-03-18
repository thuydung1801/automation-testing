package autoTest.steps.serenity;

import autoTest.pages.UpdateDegreeCodePage;

public class UpdateDegreeCodeEndUserSteps {
    UpdateDegreeCodePage updateDegreeCodePage;

    public void enterGoldCode(String degreeCode, String goldWeight) {
        updateDegreeCodePage.enterGoldCode(degreeCode,goldWeight);
    }

    public void enterBarcode(String barcode) {
        updateDegreeCodePage.enterBarcode(barcode);
    }

    public void clickOnAddMoreButton() {
        updateDegreeCodePage.clickOnAddMoreButton();
    }

    public void enterGoldCodeToTheSecondRow(String goldCode, String goldWeight) {
        updateDegreeCodePage.enterGoldCodeToTheSecondRow(goldCode, goldWeight);
    }

    public void inputToDegreeCodeBoxAndClickOnAddToList(String degreeCode) {
        updateDegreeCodePage.inputToDegreeCodeBoxAndClickOnAddToList(degreeCode);
    }

    public void inputToBarcodeBox(String barcode) {
        updateDegreeCodePage.inputToBarcodeBox(barcode);
    }

    public void clickOnSaveButton() {
        updateDegreeCodePage.clickOnSaveButton();
    }

    public void clickOnCheckboxes() {
        updateDegreeCodePage.clickOnCheckboxes();
    }
}

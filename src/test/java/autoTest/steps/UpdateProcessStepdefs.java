package autoTest.steps;

import autoTest.steps.serenity.UpdateProcessEndUserSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;

public class UpdateProcessStepdefs {
    @Steps
    UpdateProcessEndUserSteps updateProcessEndUserSteps;
    @And("^Input \"([^\"]*)\" to the barcode box$")
    public void inputToTheBarcodeBox(String barcode) {
        updateProcessEndUserSteps.inputToTheBarcodeBox(barcode);
    }

    @And("^Click on Take in button$")
    public void clickOnTakeInButton() {
        updateProcessEndUserSteps.clickOnSaveButton();
    }

    @And("^Input \"([^\"]*)\" to the weight box$")
    public void inputToTheWeightBox(String weight) throws Throwable {
        updateProcessEndUserSteps.inputToTheWeightBox(weight);
    }

    @And("^Select the \"([^\"]*)\"$")
    public void selectTheStaff(String staff) throws Throwable {
        updateProcessEndUserSteps.selectTheStaff(staff);
    }

    @And("^Click on Take off button$")
    public void clickOnTakeOffButton() {
        updateProcessEndUserSteps.clickOnSaveButton();
    }

    @And("^Click on To CNC Machine button$")
    public void clickOnToCNCMachineButton() {
        updateProcessEndUserSteps.clickOnToCNCMachineButton();
    }

    @And("^Input \"([^\"]*)\" to the steel weight box$")
    public void inputToTheSteelWeightBox(String steelWeight) throws Throwable {
        updateProcessEndUserSteps.inputToTheSteelWeightBox(steelWeight);
    }



    @And("^Click on To Polishing button$")
    public void clickOnToPolishingButton() {
        updateProcessEndUserSteps.clickOnToPolishingButton();
    }

    @And("^Input \"([^\"]*)\" to the semi weight box$")
    public void inputToTheSemiWeightBox(String semiWeight) throws Throwable {
        updateProcessEndUserSteps.inputToTheSemiWeightBox(semiWeight);
    }

    @And("^Click on To Polishing Finished button$")
    public void clickOnToPolishingFinishedButton() {
        updateProcessEndUserSteps.clickOnToPolishingButton();
    }

    @And("^Input \"([^\"]*)\" to the stone quantity box$")
    public void inputToTheStoneQuantityBox(String stoneQty) throws Throwable {
        updateProcessEndUserSteps.inputToTheStoneQuantityBox(stoneQty);
    }

    @And("^Select \"([^\"]*)\"$")
    public void selectSettingMethod(String settingMethod) throws Throwable {
        updateProcessEndUserSteps.selectSettingMethod(settingMethod);
    }

    @And("^Input \"([^\"]*)\" to the stone weight box$")
    public void inputToTheStoneWeightBox(String stoneWeight) throws Throwable {
        updateProcessEndUserSteps.inputToTheStoneWeightBox(stoneWeight);
    }

    @And("^Click on To Next Step button$")
    public void clickOnToNextStepButton() {
        updateProcessEndUserSteps.clickOnToNextStepButton();
    }

    @And("^Click on To Finished button$")
    public void clickOnToFinishedButton() {
        updateProcessEndUserSteps.clickOnToFinishedButton();
    }

    @And("^Click on To Waiting Stone button$")
    public void clickOnToWaitingStoneButton() {
        updateProcessEndUserSteps.clickOnToWaitingStoneButton();

    }

    @And("^Input \"([^\"]*)\" and \"([^\"]*)\"$")
    public void inputChainCode(String chainCode, String chainWeight) throws Throwable {
        updateProcessEndUserSteps.inputChainCode(chainCode, chainWeight);
    }

    @And("^Click on To Wedding Manufacturer button$")
    public void clickOnToWeddingManufacturerButton() {
        updateProcessEndUserSteps.clickOnToWeddingManufacturerButton();
    }

    @And("^Select the polishing \"([^\"]*)\", levelling \"([^\"]*)\", stone setting \"([^\"]*)\"$")
    public void selectThePolishingLevellingStoneSettingStaff(String polishingStaff, String levellingStaff, String stoneSettingStaff) throws Throwable {
        updateProcessEndUserSteps.selectThePolishingLevellingStoneSettingStaff(polishingStaff, levellingStaff, stoneSettingStaff);
    }

    @And("^Click on Multiple Update$")
    public void clickOnMultipleUpdate() {
        updateProcessEndUserSteps.clickOnMultipleUpdate();
    }

//    @And("^Input \"([^\"]*)\" to the second box$")
//    public void inputToTheSecondBox(String barcode2) throws Throwable {
//        updateProcessEndUserSteps.inputToTheSecondBox(barcode2);
//    }
//
//    @And("^Input \"([^\"]*)\" to the third box$")
//    public void inputToTheThirdBox(String barcode3) throws Throwable {
//        updateProcessEndUserSteps.inputToTheThirdBox(barcode3);
//    }

    @And("^Click on Update button$")
    public void clickOnUpdateButton() {
        updateProcessEndUserSteps.clickOnUpdateButton();
    }

    @And("^Click on To Silver Manufacturer button$")
    public void clickOnToSilverManufacturerButton() {
        updateProcessEndUserSteps.clickOnToSilverManufacturerButton();
    }

    @And("^Input \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\"$")
    public void inputMetalInfo(String degreeCode, String totalWeight, String leftOverWeight) throws Throwable {
        updateProcessEndUserSteps.inputMetalInfo(degreeCode, totalWeight, leftOverWeight );
    }

    @And("^Input \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" to the barcode box$")
    public void inputMultipleBarcode(String barcode1, String barcode2, String barcode3) throws Throwable {
        updateProcessEndUserSteps.inputMultipleBarcode(barcode1, barcode2, barcode3);

    }
}

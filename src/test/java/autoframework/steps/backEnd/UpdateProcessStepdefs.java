package autoframework.steps.backEnd;

import autoframework.pages.backEnd.UpdateProcessPage;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;

public class UpdateProcessStepdefs {
    @Steps
    UpdateProcessPage updateProcessPage;
    @And("^Input \"([^\"]*)\" to the barcode box$")
    public void inputToTheBarcodeBox(String barcode) {
        updateProcessPage.enterBarcode(barcode);
    }

    @And("^Click on Take in button$")
    public void clickOnTakeInButton() {
        updateProcessPage.clickOnTakeInButton();
    }

    @And("^Input \"([^\"]*)\" to the weight box$")
    public void inputToTheWeightBox(String weight) throws Throwable {
        updateProcessPage.inputToTheWeightBox(weight);
    }

    @And("^Select the \"([^\"]*)\"$")
    public void selectTheStaff(String staff) throws Throwable {
        updateProcessPage.selectTheStaff(staff);
    }

    @And("^Click on Take off button$")
    public void clickOnTakeOffButton() {
        updateProcessPage.clickOnTakeInButton();
    }

    @And("^Click on To CNC Machine button$")
    public void clickOnToCNCMachineButton() {
        updateProcessPage.clickOnToCNCMachineButton();
    }

    @And("^Input \"([^\"]*)\" to the steel weight box$")
    public void inputToTheSteelWeightBox(String steelWeight) throws Throwable {
        updateProcessPage.inputToTheSteelWeightBox(steelWeight);
    }



    @And("^Click on To Polishing button$")
    public void clickOnToPolishingButton() {
        updateProcessPage.clickOnToPolishingButton();
    }

    @And("^Input \"([^\"]*)\" to the semi weight box$")
    public void inputToTheSemiWeightBox(String semiWeight) throws Throwable {
        updateProcessPage.inputToTheSemiWeightBox(semiWeight);
    }

    @And("^Click on To Polishing Finished button$")
    public void clickOnToPolishingFinishedButton() {
        updateProcessPage.clickOnToPolishingButton();
    }

    @And("^Input \"([^\"]*)\" to the stone quantity box$")
    public void inputToTheStoneQuantityBox(String stoneQty) throws Throwable {
        updateProcessPage.inputToTheStoneQuantityBox(stoneQty);
    }

    @And("^Select \"([^\"]*)\"$")
    public void selectSettingMethod(String settingMethod) throws Throwable {
        updateProcessPage.selectSettingMethod(settingMethod);
    }

    @And("^Input \"([^\"]*)\" to the stone weight box$")
    public void inputToTheStoneWeightBox(String stoneWeight) throws Throwable {
        updateProcessPage.inputToTheStoneWeightBox(stoneWeight);
    }

    @And("^Click on To Next Step button$")
    public void clickOnToNextStepButton() {
        updateProcessPage.clickOnToNextStepButton();
    }

    @And("^Click on To Finished button$")
    public void clickOnToFinishedButton() {
        updateProcessPage.clickOnToFinishedButton();
    }

    @And("^Click on To Waiting Stone button$")
    public void clickOnToWaitingStoneButton() {
        updateProcessPage.clickOnToWaitingStoneButton();

    }

    @And("^Input \"([^\"]*)\" and \"([^\"]*)\"$")
    public void inputChainCode(String chainCode, String chainWeight) throws Throwable {
        updateProcessPage.inputChainCode(chainCode, chainWeight);
    }

    @And("^Click on To Wedding Manufacturer button$")
    public void clickOnToWeddingManufacturerButton() {
        updateProcessPage.clickOnToWeddingManufacturerButton();
    }

    @And("^Select the polishing \"([^\"]*)\", levelling \"([^\"]*)\", stone setting \"([^\"]*)\"$")
    public void selectThePolishingLevellingStoneSettingStaff(String polishingStaff, String levellingStaff, String stoneSettingStaff) throws Throwable {
        updateProcessPage.selectThePolishingLevellingStoneSettingStaff(polishingStaff, levellingStaff, stoneSettingStaff);
    }

    @And("^Click on Multiple Update$")
    public void clickOnMultipleUpdate() {
        updateProcessPage.clickOnMultipleUpdate();
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
        updateProcessPage.clickOnUpdateButton();
    }

    @And("^Click on To Silver Manufacturer button$")
    public void clickOnToSilverManufacturerButton() {
        updateProcessPage.clickOnToSilverManufacturerButton();
    }

    @And("^Input \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\"$")
    public void inputMetalInfo(String degreeCode, String totalWeight, String leftOverWeight) throws Throwable {
        updateProcessPage.inputMetalInfo(degreeCode, totalWeight, leftOverWeight );
    }

    @And("^Input \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" to the barcode box$")
    public void inputMultipleBarcode(String barcode1, String barcode2, String barcode3) throws Throwable {
        updateProcessPage.inputMultipleBarcode(barcode1, barcode2, barcode3);

    }
}

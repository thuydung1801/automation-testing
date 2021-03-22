package autoframework.steps.backEnd;

import autoframework.pages.backEnd.UpdateProcessPage;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;

public class UpdateProcessStep {
    @Steps
    UpdateProcessPage nia;
    @And("^Input \"([^\"]*)\" to the barcode box$")
    public void inputToTheBarcodeBox(String barcode) {
        nia.enterBarcode(barcode);
    }

    @And("^Click on Take in button$")
    public void clickOnTakeInButton() {
        nia.clickOnTakeInButton();
    }

    @And("^Input \"([^\"]*)\" to the weight box$")
    public void inputToTheWeightBox(String weight) throws Throwable {
        nia.inputToTheWeightBox(weight);
    }

    @And("^Select the \"([^\"]*)\"$")
    public void selectTheStaff(String staff) throws Throwable {
        nia.selectTheStaff(staff);
    }

    @And("^Click on Take off button$")
    public void clickOnTakeOffButton() {
        nia.clickOnTakeInButton();
    }

    @And("^Click on To CNC Machine button$")
    public void clickOnToCNCMachineButton() {
        nia.clickOnToCNCMachineButton();
    }

    @And("^Input \"([^\"]*)\" to the steel weight box$")
    public void inputToTheSteelWeightBox(String steelWeight) throws Throwable {
        nia.inputToTheSteelWeightBox(steelWeight);
    }



    @And("^Click on To Polishing button$")
    public void clickOnToPolishingButton() {
        nia.clickOnToPolishingButton();
    }

    @And("^Input \"([^\"]*)\" to the semi weight box$")
    public void inputToTheSemiWeightBox(String semiWeight) throws Throwable {
        nia.inputToTheSemiWeightBox(semiWeight);
    }

    @And("^Click on To Polishing Finished button$")
    public void clickOnToPolishingFinishedButton() {
        nia.clickOnToPolishingButton();
    }

    @And("^Input \"([^\"]*)\" to the stone quantity box$")
    public void inputToTheStoneQuantityBox(String stoneQty) throws Throwable {
        nia.inputToTheStoneQuantityBox(stoneQty);
    }

    @And("^Select \"([^\"]*)\"$")
    public void selectSettingMethod(String settingMethod) throws Throwable {
        nia.selectSettingMethod(settingMethod);
    }

    @And("^Input \"([^\"]*)\" to the stone weight box$")
    public void inputToTheStoneWeightBox(String stoneWeight) throws Throwable {
        nia.inputToTheStoneWeightBox(stoneWeight);
    }

    @And("^Click on To Next Step button$")
    public void clickOnToNextStepButton() {
        nia.clickOnToNextStepButton();
    }

    @And("^Click on To Finished button$")
    public void clickOnToFinishedButton() {
        nia.clickOnToFinishedButton();
    }

    @And("^Click on To Waiting Stone button$")
    public void clickOnToWaitingStoneButton() {
        nia.clickOnToWaitingStoneButton();

    }

    @And("^Input \"([^\"]*)\" and \"([^\"]*)\"$")
    public void inputChainCode(String chainCode, String chainWeight) throws Throwable {
        nia.inputChainCode(chainCode, chainWeight);
    }

    @And("^Click on To Wedding Manufacturer button$")
    public void clickOnToWeddingManufacturerButton() {
        nia.clickOnToWeddingManufacturerButton();
    }

    @And("^Select the polishing \"([^\"]*)\", levelling \"([^\"]*)\", stone setting \"([^\"]*)\"$")
    public void selectThePolishingLevellingStoneSettingStaff(String polishingStaff, String levellingStaff, String stoneSettingStaff) throws Throwable {
        nia.selectThePolishingLevellingStoneSettingStaff(polishingStaff, levellingStaff, stoneSettingStaff);
    }

    @And("^Click on Multiple Update$")
    public void clickOnMultipleUpdate() {
        nia.clickOnMultipleUpdate();
    }

//    @And("^Input \"([^\"]*)\" to the second box$")
//    public void inputToTheSecondBox(String barcode2) throws Throwable {
//        nia.inputToTheSecondBox(barcode2);
//    }
//
//    @And("^Input \"([^\"]*)\" to the third box$")
//    public void inputToTheThirdBox(String barcode3) throws Throwable {
//        nia.inputToTheThirdBox(barcode3);
//    }

    @And("^Click on Update button$")
    public void clickOnUpdateButton() {
        nia.clickOnUpdateButton();
    }

    @And("^Click on To Silver Manufacturer button$")
    public void clickOnToSilverManufacturerButton() {
        nia.clickOnToSilverManufacturerButton();
    }

    @And("^Input \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\"$")
    public void inputMetalInfo(String degreeCode, String totalWeight, String leftOverWeight) throws Throwable {
        nia.inputMetalInfo(degreeCode, totalWeight, leftOverWeight );
    }

    @And("^Input \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" to the barcode box$")
    public void inputMultipleBarcode(String barcode1, String barcode2, String barcode3) throws Throwable {
        nia.inputMultipleBarcode(barcode1, barcode2, barcode3);

    }
}

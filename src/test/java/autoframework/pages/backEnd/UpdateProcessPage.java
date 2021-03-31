package autoframework.pages.backEnd;

import autoframework.pages.CommonPageL;

public class UpdateProcessPage extends CommonPageL {
    String barcodeLocator = "input#barcode-scan";
    String takeinBtnLocator = "button#save";
    String weightLocator = "input[name=\"item_weight\"]";
    String selectStaffLocator = "select#staff_id";
    String toCNCMachineBtnLocator = "button#to_silver_manufacturer";
    String steelWeightLocator = "input[name=\"steel_weight\"]";
    String toPolishingBtnLocator = "button#next_step";
    String semiWeightLocator = "input[name=\"semi_weight\"]";
    String stoneQtyLocator = "input[name=\"stone_qty\"]";
    String settingMethodLocator = "#stone_setting_method";
    String stoneWeightLocator = "input[name=\"stone_weight\"]";
    String toNextStepBtnLocator = "button#next_step";
    String toFinishedBtnLocator = "button#to_finished";
    String toWaitingStoneBtnLocator = "button#to_waiting_stone";
    String chainCodeLocator = "input#chain_code";
    String chainWeightLocator = "input[name=\"chain_weight\"]";
    String toWeddingManufacturerBtnLocator = "button#to_wedding_manufacturer";
    String polishingStaffLocator = "select#staff_polishing";
    String levellingStaffLocator = "select#staff_levelling";
    String multiUpdateLocator = "button#multiple_update";
    String barcode2Locator = "input#barcode2";
    String barcode3Locator = "input#barcode3";
    String degreeCodeLocator = "input[name=\"degree_code\"]";
    String totalWeightLocator = "input[name=\"total_weight\"]";
    String leftOverWeighLocator = "input[name=\"leftover_weight\"]";
    String toSilverManufacturerBtnLocator = "button#to_silver_manufacturer";


    public void enterBarcode(String barcode) {

        enterTextIntoField(barcode, barcodeLocator);
        waitAboutSecond(3);
    }

    public void clickOnTakeInButton() {
        click(takeinBtnLocator);

    }

    public void inputToTheWeightBox(String weight) {
        insertIntoField(weight, weightLocator);
    }

    public void selectTheStaff(String staff) {

        selectOtionByText(selectStaffLocator, staff);
    }

    public void clickOnToCNCMachineButton() {
        click(toCNCMachineBtnLocator);
    }

    public void inputToTheSteelWeightBox(String steelWeight) {
        insertIntoField(steelWeight, steelWeightLocator);
    }

    public void clickOnToPolishingButton() {
        click(toPolishingBtnLocator);
    }

    public void inputToTheSemiWeightBox(String semiWeight) {
        insertIntoField(semiWeight,semiWeightLocator);
    }

    public void inputToTheStoneQuantityBox(String stoneQty) {
        insertIntoField(stoneQty,stoneQtyLocator);

    }

    public void selectSettingMethod(String settingMethod) {
        selectOtionByText(settingMethodLocator, settingMethod);
    }

    public void inputToTheStoneWeightBox(String stoneWeight) {
        insertIntoField(stoneWeight, stoneWeightLocator);
    }

    public void clickOnToNextStepButton() {
        click(toNextStepBtnLocator);
    }

    public void clickOnToFinishedButton() {
        click(toFinishedBtnLocator);
    }

    public void clickOnToWaitingStoneButton() {
        click(toWaitingStoneBtnLocator);
    }

    public void inputChainCode(String chainCode, String chainWeight) {
        insertIntoField(chainCode, chainCodeLocator);
        insertIntoField(chainWeight, chainWeightLocator);
    }

    public void clickOnToWeddingManufacturerButton() {
        click(toWeddingManufacturerBtnLocator);

    }

    public void selectThePolishingLevellingStoneSettingStaff(String polishingStaff, String levellingStaff, String stoneSettingStaff) {
        selectOtionByText(polishingStaffLocator, polishingStaff);
        selectOtionByText(levellingStaffLocator, levellingStaff);
        selectOtionByText(selectStaffLocator, stoneSettingStaff);

    }

    public void clickOnMultipleUpdate() {
        click(multiUpdateLocator);

    }

//    public void inputToTheSecondBox(String barcode2) {
//        enterTextIntoField(barcode2, barcode2Locator);
//        waitAboutSecond(3);
//
//    }
//
//    public void inputToTheThirdBox(String barcode3) {
//        enterTextIntoField(barcode3, barcode3Locator);
//        waitAboutSecond(3);
//    }

    public void clickOnUpdateButton() {
        click(takeinBtnLocator);
    }

    public void inputMetalInfo(String degreeCode, String totalWeight, String leftOverWeight) {
        insertIntoField(degreeCode, degreeCodeLocator);
        insertIntoField(totalWeight, totalWeightLocator);
        insertIntoField(leftOverWeight, leftOverWeighLocator);

    }

    public void clickOnToSilverManufacturerButton() {
        click(toSilverManufacturerBtnLocator);
    }

    public void inputMultipleBarcode(String barcode1, String barcode2, String barcode3) {
        enterTextIntoField(barcode1, barcodeLocator);
        waitAboutSecond(1);
        enterTextIntoField(barcode2, barcode2Locator);
        waitAboutSecond(1);
        enterTextIntoField(barcode3, barcode3Locator);
        waitAboutSecond(1);



    }
}

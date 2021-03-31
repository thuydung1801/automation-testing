package autoframework.pages.backEnd;

import autoframework.pages.CommonPageL;

public class ManageMetalPage extends CommonPageL {
    String filterMetalCodeLocator = "input#material_manage_metal_grid_filter_metal_code";
    String theFirstItemLocator = "table.data-grid tbody tr:nth-of-type(1)";
    String logUsageTabLocator = "li#manage_metal_edit_log_usage";
    String firstRowWeightUsageLocator = "table.data-grid tbody tr:nth-of-type(1) td.col-weight_usage";
    String secondRowWeightUsageLocator = "table.data-grid tbody tr:nth-of-type(2) td.col-weight_usage";
    String thirdRowWeightUsageLocator = "table.data-grid tbody tr:nth-of-type(3) td.col-weight_usage";
    String addNewMetalBtnLocator = "button#add";
    String goldTypeSltLocator = "select#alloy";
    String goldColorSltLocator = "select#colour";
    String metalWeightLocator = "#weight";
    String qtyLocator = "#qty";
    String rawMaterialLocator = "#rawmaterial_serial_no";
    String newMetalLocator = "#metal_new";
    String saveBtnLocator = "#save";
    String secondRawMaterialNoLocator = "#second_rawmaterial_serial_no";
    String secondRawMaterialWeightLocator = "#second_rawmaterial_weight";
    String diamondRingLocator = "#ring_type1";
    String weddingRingLocator = "#ring_type2";
    String pipeWeightLocator = "#pipe_weight";
    String closeBtnLocator = "#close";
    String confirmBtnLocator = "button.action-accept";
    String leftOverWeightLocator = "#leftover_weight";
    String metalCodeLocator = "#metal_code";



    public void viewDetailMetal(String degreeCode) {
        enterTextIntoField(degreeCode, filterMetalCodeLocator);
        waitAboutSecond(3);
        click(theFirstItemLocator);


    }

    public void viewTheMetalLogUsage() {
        click(logUsageTabLocator);
    }

    public void theWeightUsagesOfThreeItemsIs(String weightUsage) {
        validateInformation(firstRowWeightUsageLocator, weightUsage);
        validateInformation(secondRowWeightUsageLocator, weightUsage);
        validateInformation(thirdRowWeightUsageLocator, weightUsage);
    }

    public void clickOnAddNewMetalButton() {
        click(addNewMetalBtnLocator);


    }

    public void selectGoldType$GoldColor(String goldType, String goldColor) {
        selectOtionByText(goldTypeSltLocator, goldType);
        selectOtionByText(goldColorSltLocator, goldColor);
    }

    public void inputMetalWeight$RawMaterialNo(String metalWeight, String qty, String rawMaterialNo) {
        insertIntoField(metalWeight, metalWeightLocator);
        insertIntoField(qty, qtyLocator);
        insertIntoField(rawMaterialNo, rawMaterialLocator);


    }

    public void clickOnNewMetalCheckbox() {
        click(newMetalLocator);
    }

    public void clickOnNewMetalCheckboxAndClickSaveButton() {
        click(newMetalLocator);
        click(saveBtnLocator);
    }

    public void inputSecondRawMaterial(String secondRawMaterialNo, String secondRawMaterialWeight) {
        insertIntoField(secondRawMaterialNo, secondRawMaterialNoLocator);
        insertIntoField(secondRawMaterialWeight, secondRawMaterialWeightLocator);

    }

    public void chooseManufacturer(String manufacturer) {
        click(manufacturer);
//        if (manufacturer=="Diamond Ring"){
//            click(diamondRingLocator);
//        } else click(weddingRingLocator);
    }

    public void inputPipeWeight(String pipeWeight) {
        insertIntoField(pipeWeight, pipeWeightLocator);
    }

    public void clickOnSave() {
        click(saveBtnLocator);
    }

    public void clickOnClose() {
        click(closeBtnLocator);
        click(confirmBtnLocator);

    }

    public void theWeightUsageLoggedIs(String weightUsage) {
        validateInformation(firstRowWeightUsageLocator, weightUsage);

    }

    public void theLeftoverWeightIs(String leftOverWeight) {
        validateInformation(leftOverWeightLocator, leftOverWeight);
    }

    public void inputToMetalCodeBox(String metalCode) {
        enterTextIntoField(metalCode,metalCodeLocator);

    }
}

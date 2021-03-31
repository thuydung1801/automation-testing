package autoframework.pages.backEnd;

import autoframework.pages.CommonPageL;

public class UpdateDegreeCodePage extends CommonPageL {
    String barcodeLocator = "input#barcode";
    String goldCodeLocator = "div#wraper_input tr:nth-of-type(3) td.gold_code input[type=\"text\"]";
    String goldWeightLocator = "div#wraper_input tr:nth-of-type(3) input.material_weight";
    String saveBtnLocator = "button#save";
    String addMoreBtnLocator= "button#new_degree";
    String secondGoldCodeLocator = "div#wraper_input tr:nth-of-type(4) td.gold_code input[type=\"text\"]";
    String secondGoldWeightLocator = "div#wraper_input tr:nth-of-type(4) input[name=\"weight_casting[1]\"]";
    String degreeCodeLocator = "input#degree_code";
    String addDegreeCodeBtnLocator = "button#add_new_degree_code";
    String inputBarcodeLocator = "input#input_barcode";
    String addBarcodeBtnLocator = "button#add_new_barcode";
    String saveListBtnLocator = "button#submit_add_degree";
    String checkbox12locator = "tbody.list_barcode tr:nth-of-type(2) td.item2 input";
    String checkbox22locator = "tbody.list_barcode tr:nth-of-type(3) td.item2 input";
    String checkbox32locator = "tbody.list_barcode tr:nth-of-type(4) td.item2 input";
    String checkbox13locator = "tbody.list_barcode tr:nth-of-type(2) td.item3 input";
    String checkbox23locator = "tbody.list_barcode tr:nth-of-type(3) td.item3 input";
    String checkbox33locator = "tbody.list_barcode tr:nth-of-type(4) td.item3 input";
    public void enterBarcode(String barcode) {
        enterTextIntoField(barcode,barcodeLocator);

    }
    public void enterGoldCode(String degreeCode, String goldWeight) {
        insertIntoField(degreeCode, goldCodeLocator);
        insertIntoField(goldWeight, goldWeightLocator);
        click(saveBtnLocator);

    }


    public void clickOnAddMoreButton() {
        click(addMoreBtnLocator);
    }

    public void enterGoldCodeToTheSecondRow(String goldCode, String goldWeight) {
        insertIntoField(goldCode, secondGoldCodeLocator);
        insertIntoField(goldWeight, secondGoldWeightLocator);
        click(saveBtnLocator);
    }

    public void inputToDegreeCodeBoxAndClickOnAddToList(String degreeCode) {
        insertIntoField(degreeCode, degreeCodeLocator);
        click(addDegreeCodeBtnLocator);

    }

    public void inputToBarcodeBox(String barcode) {
        insertIntoField(barcode, inputBarcodeLocator);
        click(addBarcodeBtnLocator);

    }

    public void clickOnSaveButton() {
        click(saveListBtnLocator);
    }

    public void clickOnCheckboxes() {
        click(checkbox12locator);
        click(checkbox22locator);
        click(checkbox32locator);
        click(checkbox13locator);
        click(checkbox23locator);
        click(checkbox33locator);
    }
}

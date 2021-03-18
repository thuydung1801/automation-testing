package autoTest.steps.serenity;

import autoTest.pages.RawMaterialPage;

public class RawMaterialEndUserSteps {
    RawMaterialPage rawMaterialPage;

    public void clickOnAddNewRawMaterial() {
        rawMaterialPage.clickOnAddNewRawMaterial();
    }

    public void inputRawInformation(String serialNo, String weight, String brand, String date, String materialAlloy, String fineMaterial, String isNewRaw) {
        rawMaterialPage.inputRawInformation(serialNo,weight,brand,date,materialAlloy,fineMaterial,isNewRaw);
    }

    public void clickOnSaveToSaveNewRaw() {
        rawMaterialPage.clickOnSaveToSaveNewRaw();
    }

    public void viewDetailOfTheMaterialHas(String serialNo) {
        rawMaterialPage.viewDetailOfTheMaterialHas(serialNo);
    }


    public void viewTheHistory() {
        rawMaterialPage.viewTheHistory();
    }

    public void theWeightUsageIs(String metalCode, String weightUsage) {
        rawMaterialPage.theWeightUsageIs(metalCode, weightUsage);
    }
}

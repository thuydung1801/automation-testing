package autoframework.pages.backEnd;

import autoframework.pages.CommonPageL;

public class RawMaterialPage extends CommonPageL {
    String addNewRawMaterialBtnLocator = "#add";
    String serialNoLocator = "#serial_no";
    String materialAlloyLocator = "#material_alloy";
    String weightLocator = "#material_weight";
    String brandLocator = "#material_brand";
    String fineMaterialLocator = "#material_fine";
    String instockDateLocator = "#material_instock_date";
    String datePickerLocator ="#material_instock_date+button.ui-datepicker-trigger.v-middle";
    String isNewRawLocator = "#new_raw_material";
    String serialSearchBoxLocator = "#material_manage_raw_material_grid_filter_serial_no";
    String theFirstItemLocator = "table.data-grid tbody tr:nth-of-type(1)";
    String goTodayBtnLocator = "button[data-handler=\"today\"]";
    String historyTabLocator = "a#manage_raw_material_edit_raw_material_log";
    String filterMetalLocator = "#material_manage_raw_material_log_filter_metal_code";
    String theFirstRowMaterialUsedChangee = "table.data-grid tbody tr:nth-of-type(1) td.col-used_weight_changed";

    public void clickOnAddNewRawMaterial() {
        click(addNewRawMaterialBtnLocator);
    }

    public void inputRawInformation(String serialNo, String weight, String brand, String date, String materialAlloy, String fineMaterial, String isNewRaw) {
        insertIntoField(serialNo,serialNoLocator);
        insertIntoField(weight, weightLocator);
        insertIntoField(brand,brandLocator);
//        insertIntoField(date,instockDateLocator);
        click(datePickerLocator);
        click(goTodayBtnLocator);
        selectOtionByText(materialAlloyLocator,materialAlloy);
        selectOtionByText(fineMaterialLocator, fineMaterial);
        selectOtionByText(isNewRawLocator, isNewRaw);
    }

    public void clickOnSaveToSaveNewRaw() {

    }

    public void viewDetailOfTheMaterialHas(String serialNo) {
        enterTextIntoField(serialNo,serialSearchBoxLocator);
        waitAboutSecond(3);
        click(theFirstItemLocator);


    }


    public void viewTheHistory() {
        click(historyTabLocator);

    }

    public void theWeightUsageIs(String metalCode, String weightUsage) {
        enterTextIntoField(metalCode, filterMetalLocator);
        validateInformation(theFirstRowMaterialUsedChangee,weightUsage);



    }
}

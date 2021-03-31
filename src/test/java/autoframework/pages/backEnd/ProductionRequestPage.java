package autoframework.pages.backEnd;


import autoframework.pages.CommonPageL;

public class ProductionRequestPage extends CommonPageL {

    String itemStateFilterLocator = "table.data-grid td select[name=\"state\"]";
    String productionProcessStatusLocator = "table.data-grid td select[name=\"processing_status\"]";
    String searchBtnLocator = "div.admin__filter-actions button[title=\"Search\"]";
    String actionLocator = "div.admin__grid-massaction-form select";
    String submitBtnLocator = "button[title=\"Submit\"]";
//    String messageLocator = "div.messages div div";
    String createRequestBtnLocator = "button#create_for_instock";
    String datePickerLocator = "button.ui-datepicker-trigger";
    String todayLocator = "button.ui-datepicker-current";
    String itemQtyLocator = "#item_qty";
    String itemSkuLocator = "#item_sku";
    String itemNameLocator = "#item_name";
    String priceLocator = "#product_price";
    String saveBtnLocator = "#save";
    String manufaturerLocator = "#manufacturer";
    String goldTypeLocator = "#gold_type";
    String scanBarcodeLocator = "input[name=\"barcode_filter\"]";
    String loadingMaskLocator = "div.loading-mask";








    public void filterItemsMatchPreConditionForStartingPProduction() {
        selectOtionByText(itemStateFilterLocator, "In production");
        selectOtionByText(productionProcessStatusLocator, "Not Ordered");
        click(searchBtnLocator);

    }

    public void takeActionStartProduction() {
        selectOption(actionLocator,"start_production");
        click(submitBtnLocator);
        actionConfirmation();
    }

//    public void theMessageIsShown(String message) {
//        validateInformation(messageLocator,message);
//
//    }

    public void clickOnCreateForInStockItemsButton() {
        click(createRequestBtnLocator);
    }

    public void inputInformationThenClickSave(String itemQty, String itemSKU, String itemName, String price) {
        click(datePickerLocator);
        click(todayLocator);
        insertIntoField(itemQty, itemQtyLocator);
        insertIntoField(itemSKU, itemSkuLocator);
        insertIntoField(itemName, itemNameLocator);
        selectOtionByText(manufaturerLocator, "Glamira Wedding");
        insertIntoField(price, priceLocator);
        selectOtionByText(goldTypeLocator,"585 Gold - 14K");
        click(saveBtnLocator);
    }

    public void enterToScanBarcodeBox(String barcode) {
        enterTextIntoField(barcode, scanBarcodeLocator);

    }

    public void chooseTheItem() {
    }

    public void takeAction(String action) {
        waitUntilElementDisapear(loadingMaskLocator);
        selectOtionByText(actionLocator,action);
        click(submitBtnLocator);
        actionConfirmation();

    }
}

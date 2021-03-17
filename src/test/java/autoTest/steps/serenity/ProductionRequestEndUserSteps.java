package autoTest.steps.serenity;

import autoTest.pages.ProductionRequestPage;

public class ProductionRequestEndUserSteps {
    ProductionRequestPage productionRequestPage;

    public void filterItemsMatchPreConditionForStartingPProduction() {
        productionRequestPage.filterItemsMatchPreConditionForStartingPProduction();
    }

    public void takeActionStartProduction() {
        productionRequestPage.takeActionStartProduction();
    }

//    public void theMessageIsShown(String message) {
//        productionRequestPage.theMessageIsShown(message);
//    }

    public void clickOnCreateForInStockItemsButton() {
        productionRequestPage.clickOnCreateForInStockItemsButton();
    }

    public void inputInformationThenClickSave(String itemQty, String itemSKU, String itemName, String price) {
        productionRequestPage.inputInformationThenClickSave(itemQty, itemSKU, itemName, price);
    }

    public void enterToScanBarcodeBox(String barcode) {
        productionRequestPage.enterToScanBarcodeBox(barcode);
    }

    public void chooseTheItem() {
        productionRequestPage.chooseTheItem();
    }

    public void takeAction(String action) {
        productionRequestPage.takeAction(action);
    }
}

package autoframework.pages.backEnd;

import autoframework.pages.CommonPageL;

public class ManageChainPage extends CommonPageL {
    String addNewBtnLocator = "#add";
    String stockIDLocator = "#warehouse_stock_id";
    String chainTypeLocator = "#chain_type";
    String chainAlloyLocator = "#chain_alloy";
    String chainColorLocator = "#chain_colour";
    String chainWeightLocator = "#chain_weight";
    String rawMateriaSerialNoLocator = "#raw_material_serial_no";
    String chainQtyLocator = "#chain_qty";
    String filterStockIDLocator = "#manage_chain_grid_filter_warehouse_stock_id";
    String theFirstItemLocator = "table#manage_chain_grid_table tbody tr:nth-of-type(1)";
    String plusChainWeightLocator = "#new_weight";
    String proleFeeLocator = "#prole_fee";
    String extraLocator = "#extra";
    String historyUsageTabLocator = "a#manage_chain_edit_history_usage";



    public void clickOnNewSemiProductChainButton() {
        click(addNewBtnLocator);
    }

    public void inputChainInformation(String stockID, String chainType, String chainAlloy, String chainColor, String chainWeight, String rawMaterialNo, String chainQty) {
        insertIntoField(stockID, stockIDLocator);
        selectOtionByText(chainTypeLocator, chainType);
        selectOtionByText(chainAlloyLocator, chainAlloy);
        selectOtionByText(chainColorLocator, chainColor);
        insertIntoField(chainWeight, chainWeightLocator);
        insertIntoField(rawMaterialNo, rawMateriaSerialNoLocator);
        insertIntoField(chainQty, chainQtyLocator);
        waitAboutSecond(8);
    }

    public void viewDetailOfTheChainHas(String stockID) {
        enterTextIntoField(stockID,filterStockIDLocator);
        click(theFirstItemLocator);

    }

    public void inputPlusWeight(String plusWeight, String proleFee, String extra) {
        insertIntoField(plusWeight, plusChainWeightLocator);
        insertIntoField(proleFee, proleFeeLocator);
        insertIntoField(extra, extraLocator);

    }

    public void viewTheChainSHistoryUsage() {
        click(historyUsageTabLocator);
    }
}

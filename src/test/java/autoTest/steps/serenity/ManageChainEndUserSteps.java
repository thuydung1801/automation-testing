package autoTest.steps.serenity;

import autoTest.pages.ManageChainPage;

public class ManageChainEndUserSteps {
    ManageChainPage manageChainPage;

    public void clickOnNewSemiProductChainButton() {
        manageChainPage.clickOnNewSemiProductChainButton();
    }

    public void inputChainInformation(String stockID, String chainType, String chainAlloy, String chainColor, String chainWeight, String rawMaterialNo, String chainQty) {
        manageChainPage.inputChainInformation(stockID, chainType, chainAlloy, chainColor, chainWeight, rawMaterialNo, chainQty);
    }

    public void viewDetailOfTheChainHas(String stockID) {
        manageChainPage.viewDetailOfTheChainHas(stockID);
    }

    public void inputPlusWeight(String plusWeight, String proleFee, String extra) {
        manageChainPage.inputPlusWeight(plusWeight, proleFee, extra);
    }

    public void viewTheChainSHistoryUsage() {
        manageChainPage.viewTheChainSHistoryUsage();
    }
}

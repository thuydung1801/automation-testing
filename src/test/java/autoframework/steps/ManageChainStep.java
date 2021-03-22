package autoframework.steps;

import autoframework.pages.ManageChainPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ManageChainStep {
    @Steps
    ManageChainPage nia;
    @When("^Click on New Semi Product/Chain button$")
    public void clickOnNewSemiProductChainButton() {
        nia.clickOnNewSemiProductChainButton();
    }

    @And("^Input chain information \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void inputChainInformation(String stockID, String chainType, String chainAlloy, String chainColor, String chainWeight, String rawMaterialNo, String chainQty) throws Throwable {
        nia.inputChainInformation(stockID, chainType, chainAlloy, chainColor, chainWeight, rawMaterialNo, chainQty);
    }


    @When("^View detail of the chain has \"([^\"]*)\"$")
    public void viewDetailOfTheChainHas(String stockID) throws Throwable {
        nia.viewDetailOfTheChainHas(stockID);
    }

    @And("^Input plus weight \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void inputPlusWeight(String plusWeight, String proleFee, String extra) throws Throwable {
        nia.inputPlusWeight(plusWeight, proleFee, extra);
    }

    @And("^View the chain's history usage$")
    public void viewTheChainSHistoryUsage() {
        nia.viewTheChainSHistoryUsage();
    }

}

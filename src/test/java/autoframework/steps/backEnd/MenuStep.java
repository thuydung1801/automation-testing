package autoframework.steps.backEnd;

import autoframework.pages.frontEnd.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MenuStep {
    @Steps
    HomePage nia;

    @When("^Move mouse over jewelry then click on gemRing$")
    public void moveMouseOverJewelryThenClickOnGemRing() {
        nia.hoverOnJewelryThenClickOnGemRing();
    }

    @When("^Click on Jewelry$")
    public void clickOnJewelry() {
        nia.clickOnJewelry();
    }

    @And("^Move mouse over ring then click on gemRingJew$")
    public void moveMouseOverRingThenClickOnGemRingJew() {
        nia.hoverRingAndClickGemRing();
    }
}

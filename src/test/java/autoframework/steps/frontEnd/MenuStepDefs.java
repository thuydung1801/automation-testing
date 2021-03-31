package autoframework.steps.frontEnd;

import autoframework.pages.frontEnd.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MenuStepDefs {
    @Steps
    HomePage homePage;

    @When("^Move mouse over jewelry then click on gemRing$")
    public void moveMouseOverJewelryThenClickOnGemRing() {
        homePage.hoverOnJewelryThenClickOnGemRing();
    }

    @When("^Click on Jewelry$")
    public void clickOnJewelry() {
        homePage.clickOnJewelry();
    }

    @And("^Move mouse over ring then click on gemRingJew$")
    public void moveMouseOverRingThenClickOnGemRingJew() {
        homePage.hoverRingAndClickGemRing();
    }
}

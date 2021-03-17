package autoTest.steps;

import autoTest.steps.serenity.MenuEndUserSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MenuStepDefs {
    @Steps
    MenuEndUserSteps menuEndUserSteps;

    @When("^Move mouse over jewelry then click on gemRing$")
    public void moveMouseOverJewelryThenClickOnGemRing() {
        menuEndUserSteps.hoverAndClick();
    }

    @When("^Click on Jewelry$")
    public void clickOnJewelry() {
        menuEndUserSteps.clickOnJewelry();
    }

    @And("^Move mouse over ring then click on gemRingJew$")
    public void moveMouseOverRingThenClickOnGemRingJew() {
        menuEndUserSteps.hoverRingAndClickGemRing();
    }
}

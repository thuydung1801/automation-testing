package autoTest.steps.serenity;

import autoTest.pages.HomePage;

public class MenuEndUserSteps {
    HomePage homePage;
    public void hoverAndClick() {
        homePage.hoverOnJewelryThenClickOnGemRing();

    }

    public void clickOnJewelry() {
        homePage.clickOnJewelry();
    }

    public void hoverRingAndClickGemRing() {
        homePage.hoverRingAndClickGemRing();

    }
}

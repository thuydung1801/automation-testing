package autoTest.steps;

import autoTest.steps.serenity.MobileEndUserSteps;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;

public class MobileStepdefs {
    @Steps
    MobileEndUserSteps mobileEndUserSteps;
    @Given("^Go to glamira page$")
    public void goToGlamiraPage() {
        mobileEndUserSteps.goToGlamiraPage();
    }
}

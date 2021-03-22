package autoframework.steps;

import autoframework.pages.CartPriceRulePage;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class DiscountStep {
    @Steps
    CartPriceRulePage nia;
    @When("^Create a \"([^\"]*)\" discount rule$")
    public void createADiscountRule(String arg0) throws Throwable {
        nia.createADiscountRule(arg0);
    }

}

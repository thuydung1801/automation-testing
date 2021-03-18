package autoTest.steps;

import autoTest.steps.serenity.CartPriceRuleEndUserSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class DiscountStepdefs {
    @Steps
    CartPriceRuleEndUserSteps cartPriceRuleEndUserSteps;
    @When("^Create a \"([^\"]*)\" discount rule$")
    public void createADiscountRule(String arg0) throws Throwable {
        cartPriceRuleEndUserSteps.createADiscountRule(arg0);
    }

}

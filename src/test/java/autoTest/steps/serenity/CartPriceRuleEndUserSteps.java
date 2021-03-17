package autoTest.steps.serenity;

import autoTest.pages.CartPriceRulePage;

public class CartPriceRuleEndUserSteps {
    CartPriceRulePage cartPriceRulePage;

    public void createADiscountRule(String arg0) {
        cartPriceRulePage.createADiscountRule(arg0);
    }
}

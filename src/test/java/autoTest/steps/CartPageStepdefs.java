package autoTest.steps;

import autoTest.steps.serenity.CartPageEndUserSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CartPageStepdefs {

    @Steps
    CartPageEndUserSteps cartPageEndUserSteps;


    @When("^Click on select size button then select \"([^\"]*)\"$")
    public void clickOnSelectSizeButtonThenSelect(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        cartPageEndUserSteps.clickOnSelecSizeButtonThenSelect(arg0);
    }

    @And("^Click on AddToCart$")
    public void clickOnAddToCart() {
        cartPageEndUserSteps.clickOnAddToCart();
    }

    @And("^Wait until cartSidebar disappear then click on AddToCart$")
    public void waitUntilCartSidebarDisappearThenClickOnAddToCart() {
        cartPageEndUserSteps.waitUntilCartSidebarDisappearThenClickOnAddToCart();
    }

    @And("^The current quantity is \"([^\"]*)\"$")
    public void theCurrentQuantityIs(String expectedQty) throws Throwable {
        cartPageEndUserSteps.theCurrentQuantityIs(expectedQty);
    }

    @And("^input \"([^\"]*)\"$")
    public void input(String arg0) throws Throwable {
        cartPageEndUserSteps.input(arg0);
    }

    @Then("^The subTotalPrice is \"([^\"]*)\"$")
    public void theSubTotalPriceIs(String subTotalPrice) throws Throwable {
        cartPageEndUserSteps.theSubTotalPriceIs(subTotalPrice);
    }

    @Then("^The totalPrice is \"([^\"]*)\"$")
    public void theTotalPriceIs(String totalPrice) throws Throwable {
        cartPageEndUserSteps.theTotalPriceIs(totalPrice);
    }

    @And("^Click on removedBtn$")
    public void clickOnRemovedBtn() {
        cartPageEndUserSteps.clickOnRemovedBtn();

    }


    @And("^Move on \"([^\"]*)\" then click on \"([^\"]*)\"$")
    public void moveOnThenClickOn(String viewCart, String proceedToCheckout) throws Throwable {
        cartPageEndUserSteps.moveOnThenClickOn(viewCart, proceedToCheckout);
    }


    @Then("^The discount is \"([^\"]*)\"$")
    public void theDiscountIs(String discountPercent) throws Throwable {
        cartPageEndUserSteps.theDiscountIs(discountPercent);
    }
}

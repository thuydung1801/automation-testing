package autoframework.steps;

import autoframework.pages.CartPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CartPageStep {

    @Steps
    CartPage nia;


    @When("^Click on select size button then select \"([^\"]*)\"$")
    public void clickOnSelectSizeButtonThenSelect(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        nia.clickOnSelecSizeButtonThenSelect(arg0);
    }

    @And("^Click on AddToCart$")
    public void clickOnAddToCart() {
        nia.clickOnAddToCart();
    }

    @And("^Wait until cartSidebar disappear then click on AddToCart$")
    public void waitUntilCartSidebarDisappearThenClickOnAddToCart() {
        nia.waitUntilCartSidebarDisappearThenClickOnAddToCart();
    }

    @And("^The current quantity is \"([^\"]*)\"$")
    public void theCurrentQuantityIs(String expectedQty) throws Throwable {
        nia.theCurrentQuantityIs(expectedQty);
    }

    @And("^input \"([^\"]*)\"$")
    public void input(String arg0) throws Throwable {
        nia.input(arg0);
    }

    @Then("^The subTotalPrice is \"([^\"]*)\"$")
    public void theSubTotalPriceIs(String subTotalPrice) throws Throwable {
        nia.theSubTotalPriceIs(subTotalPrice);
    }

    @Then("^The totalPrice is \"([^\"]*)\"$")
    public void theTotalPriceIs(String totalPrice) throws Throwable {
        nia.theTotalPriceIs(totalPrice);
    }

    @And("^Click on removedBtn$")
    public void clickOnRemovedBtn() {
        nia.clickOnRemovedBtn();

    }


    @And("^Move on \"([^\"]*)\" then click on \"([^\"]*)\"$")
    public void moveOnThenClickOn(String viewCart, String proceedToCheckout) throws Throwable {
        nia.hoverThenClickOn(viewCart, proceedToCheckout);
    }


    @Then("^The discount is \"([^\"]*)\"$")
    public void theDiscountIs(String discountPercent) throws Throwable {
        nia.theDiscountIs(discountPercent);
    }
}

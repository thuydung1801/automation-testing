package autoframework.steps.frontEnd;

//import autoTest.steps.serenity.CartPage;

import autoframework.pages.frontEnd.CartPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CartPageStepdefs {

    @Steps
    CartPage cartPage;

    @When("^Click on select size button then select \"([^\"]*)\"$")
    public void clickOnSelectSizeButtonThenSelect(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        cartPage.clickOnSelecSizeButtonThenSelect(arg0);
    }

    @And("^Click on AddToCart$")
    public void clickOnAddToCart() {
        cartPage.clickOnAddToCart();
    }

    @And("^Wait until cartSidebar disappear then click on AddToCart$")
    public void waitUntilCartSidebarDisappearThenClickOnAddToCart() {
        cartPage.waitUntilCartSidebarDisappearThenClickOnAddToCart();
    }

    @And("^The current quantity is \"([^\"]*)\"$")
    public void theCurrentQuantityIs(String expectedQty) throws Throwable {
        cartPage.theCurrentQuantityIs(expectedQty);
    }

    @And("^input \"([^\"]*)\"$")
    public void input(String arg0) throws Throwable {
        cartPage.input(arg0);
    }

    @Then("^The subTotalPrice is \"([^\"]*)\"$")
    public void theSubTotalPriceIs(String subTotalPrice) throws Throwable {
        cartPage.theSubTotalPriceIs(subTotalPrice);
    }

    @Then("^The totalPrice is \"([^\"]*)\"$")
    public void theTotalPriceIs(String totalPrice) throws Throwable {
        cartPage.theTotalPriceIs(totalPrice);
    }

    @And("^Click on removedBtn$")
    public void clickOnRemovedBtn() {
        cartPage.clickOnRemovedBtn();

    }


    @And("^Move on \"([^\"]*)\" then click on \"([^\"]*)\"$")
    public void moveOnThenClickOn(String viewCart, String proceedToCheckout) throws Throwable {
        cartPage.hoverThenClickOn(viewCart, proceedToCheckout);
    }


    @Then("^The discount is \"([^\"]*)\"$")
    public void theDiscountIs(String discountPercent) throws Throwable {
        cartPage.theDiscountIs(discountPercent);
    }

    @Then("^The shoping bag is empty$")
    public void theShopingBagIsEmpty() {
        cartPage.theShopingBagIsEmpty();
    }
}

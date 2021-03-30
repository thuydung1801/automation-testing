package autoframework.steps.frontEnd;

import autoframework.pages.frontEnd.HUONGCheckoutPages;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class H_CheckoutStepDefs {
    HUONGCheckoutPages checkoutPages;

    @When("^Mouse Hover and click$")
    public void mouseHoverAndClick() {

        checkoutPages.mouseHoverAndClick();
    }

    @And("^I click in  detail item$")
    public void iClickInDetailItem() {
        checkoutPages.iClickInDetailItem();
    }

    @And("^Choose RingSize$")
    public void chooseRingSize() {
        checkoutPages.chooseRingSize();

    }

    @And("^Click in Add To Shopping Bag button$")
    public void clickInAddToShoppingBagButton() {
//        System.out.println("is ringsize: " + checkoutPages.AddToCart());
//        if(ringsize == null){
//            Assert.assertFalse(checkoutPages.AddToCart());
//        }else{
//            Assert.assertTrue(checkoutPages.AddToCart());
//        }
        checkoutPages.AddToCart();
    }

//    @And("^Click and navigate to the cart page$")
//    public void clickAndNavigateToTheCartPage() {
//        checkoutPages.ClickShoppingBag();
//        System.out.println("is ringsize: " + checkoutPages.CartPage());
//        if(ringsize == null){
//            Assert.assertFalse(checkoutPages.CartPage());
//        }else{
//            Assert.assertTrue(checkoutPages.CartPage());
//        }
//      //  checkoutPages.CartPage();
//    }

    @And("^Click to view  ShoppingBag$")
    public void clickToViewShoppingBag() {
        checkoutPages.ClickShoppingBag();
    }

    @And("^Click in Proceed to Checkout button$")
    public void clickInProceedToCheckoutButton() {
        checkoutPages.CheckoutButton();
    }

    @And("^Select shipping methods$")
    public void selectShippingMethods() {
        checkoutPages.ShippingMethod();
        checkoutPages.NextButton();
    }

    @And("^Select Payment method$")
    public void selectPaymentEthod() {
        checkoutPages.paymentmethod();
        checkoutPages.acceptterms();
    }

    @And("^Click in Place Order$")
    public void clickInPlaceOrder() {

        checkoutPages.clickInPlaceOrder();
    }

    @Then("^I should be on the \"([^\"]*)\"$")
    public void iShouldBeOnThe(String  myorder)  {
        Assert.assertTrue(checkoutPages.viewssucess(myorder));


    }

    @And("^Select Payment method paypal$")
    public void selectPaymentMethodPaypal() {
        checkoutPages.paymentmethodPaypal();
        checkoutPages.acceptterms();
    }


}

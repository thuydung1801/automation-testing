package autoTest.steps.serenity;

import autoTest.pages.CartPage;

public class CartPageEndUserSteps {
    CartPage cartPage;


    public void clickOnSelecSizeButtonThenSelect(String arg0) {
        cartPage.clickOnSelecSizeButtonThenSelect(arg0);
    }

    public void clickOnAddToCart() {
        cartPage.clickOnAddToCart();
    }

    public void waitUntilCartSidebarDisappearThenClickOnAddToCart() {
        cartPage.waitUntilCartSidebarDisappearThenClickOnAddToCart();
    }

    public void theCurrentQuantityIs(String expectedQty) {
        cartPage.theCurrentQuantityIs(expectedQty);
    }

    public void input(String arg0) {
        cartPage.input(arg0);
    }

    public void theSubTotalPriceIs(String subTotalPrice) {
        cartPage.theSubTotalPriceIs(subTotalPrice);
    }

    public void theTotalPriceIs(String totalPrice) {
        cartPage.theTotalPriceIs(totalPrice);
    }

    public void clickOnRemovedBtn() {
        cartPage.clickOnRemovedBtn();
    }


    public void moveOnThenClickOn(String viewCart, String proceedToCheckout) {
        cartPage.hoverThenClickOn(viewCart,proceedToCheckout);
    }

    public void theDiscountIs(String discountPercent) {
        cartPage.theDiscountIs(discountPercent);
    }
}


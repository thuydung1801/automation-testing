package autoframework.pages.frontEnd;

import autoframework.pages.CommonPageL;
import org.openqa.selenium.By;

public class CartPage extends CommonPageL {
    String sizeBtnLocator = "div.ringsize-select select";
    String addToCartBtnLocator = "#product-addtocart-button";
    String cartSideBarLocator = "div.product-item-details a";
    String quantityLocator = "td.item div.qty label input";
    String subTotalPriceLocator = "tr.item-info td.subtotal span.price";
    String totalPriceLocator = "tr.totals.grand td.amount span";
    String removeBtnLocator = "tbody.cart:nth-child(3) div.delete";
    String checkoutBtnLocator = "div.cart-summary button.checkout";
    String discountAmountLocator = "table.totals>tbody tr:nth-of-type(2) td span span";
    String updateShopingBagBtnLocator = "button[value=\"update_qty\"]";
    String pageTitleLocator = "div.page-title h1";


    public void clickOnSelecSizeButtonThenSelect(String arg0) {
        selectOption(sizeBtnLocator, arg0);

    }

    public void clickOnAddToCart() {

        click(addToCartBtnLocator);
    }

    public void waitUntilCartSidebarDisappearThenClickOnAddToCart() {
//        waitUntilElementIsVisible(cartSideBarLocator);
//        waitUntilElementDisapear(cartSideBarLocator);
        scrollToAndClick(addToCartBtnLocator);

    }

    public void theCurrentQuantityIs(String expectedQty) {
        validateNumber(quantityLocator, expectedQty);

    }

    public void input(String arg0) {
        getDriver().findElement(By.cssSelector(quantityLocator)).clear();
        insertIntoField(arg0,quantityLocator);
        click(updateShopingBagBtnLocator);
//
        waitAboutSecond(20);

    }

    public void theSubTotalPriceIs(String subTotalPrice) {
//        waitAboutSecond(12);
        waitUntilElementIsVisible(subTotalPriceLocator);
        validatePrice(subTotalPriceLocator, subTotalPrice);
    }

    public void theTotalPriceIs(String totalPrice) {
        validatePrice(totalPriceLocator, totalPrice);
    }

    public void clickOnRemovedBtn() {
        click(removeBtnLocator);
    }


    public void theDiscountIs(String discountPercent) {
        validatePrice(discountAmountLocator, discountPercent);
    }

    public void theShopingBagIsEmpty() {
        validateInformation(pageTitleLocator, "Shopping Bag is Empty");

    }
}

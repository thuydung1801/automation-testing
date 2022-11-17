package page;

import core.*;

public class ListingPage extends BasePage {
    public ListingPage(KeywordWeb key) {
        super(key);
    }

    public void acceptAllCookies() {
        keyword.webDriverWaitForElementPresent("BTN_COOKIES", 50);
        keyword.click("BTN_COOKIES");
    }

    // check filter section with selected information (shared operation group)
    public void checkFilterStonesAndVerify(String selectElement, String clickElementVerify, String verifyDisplay, String statusElement) throws InterruptedException {
        keyword.scrollDownToElement(selectElement);
        keyword.click(selectElement);
        Thread.sleep(2000);
        keyword.webDriverWaitForElementPresent(clickElementVerify, 20);
        keyword.click(clickElementVerify);
        keyword.webDriverWaitForElementPresent(verifyDisplay, 20);
        keyword.CheckIsDisplayElement(statusElement);
    }

    //go to AllProduct of listingPage section
    public void goToAllProduct(String allBtn, String btnSwitch) throws InterruptedException {
        keyword.navigateToUrl("BASE_URL_LISTINGPAGE");
        keyword.webDriverWaitForElementPresent("BTN_COOKIES", 30);
        keyword.click("BTN_COOKIES");
        Thread.sleep(1000);
        keyword.scrollToPosition();
        keyword.webDriverWaitForElementPresent(btnSwitch, 50);
        keyword.click(btnSwitch);
        keyword.webDriverWaitForElementPresent("LTP_TEXT_PAGE", 50);
        keyword.hoverAndClick("LTP_TEXT_MOVE");
        keyword.webDriverWaitForElementPresent("LTP_CLICK_PRODUCT", 10);
        keyword.imWait(3);
        keyword.click("LTP_CLICK_PRODUCT");
        keyword.imWait(3);
        keyword.scrollDownToElement(allBtn);
        keyword.click(allBtn);
    }

    // delete function filter
    public void deleteFilters() {
        keyword.click("LTP_BTN_DELETEALL");
    }

    //Check sort button
    public void sortProduct() throws InterruptedException {
        keyword.webDriverWaitForElementPresent("LTP_SHORT", 30);
        Thread.sleep(1000);
        keyword.click("LTP_SHORT");
        Thread.sleep(1000);
        keyword.webDriverWaitForElementPresent("LTP_BOOK_SHORT", 30);
        keyword.click("LTP_RELAVANCE");
    }

    //Check view button (status display state of product )
    public void viewBTN() throws InterruptedException {
        keyword.scrollDownToElement("LTP_TOOLlBAR");
        Thread.sleep(1000);
        keyword.clickByCss("LTP_BTN_VIEW2");
        Thread.sleep(1000);
        keyword.clickByCss("LTP_BTN_VIEW3");
        keyword.clickByCss(PropertiesFile.getPropValue("LTP_BTN_VIEW2"));
        Thread.sleep(1000);
        keyword.clickByCss(PropertiesFile.getPropValue("LTP_BTN_VIEW3"));
    }

    //Check click popup message when clicking on the caption
    public void popupMessage() throws InterruptedException {
        keyword.imWait(3);
        keyword.scrollDownToElement("LTP_SCR_TOP");
        keyword.click("LTP_BTN_INFO_MESSAGE");
        keyword.webDriverWaitForElementPresent("LTP_POPUP_DETAIL", 50);
        Thread.sleep(1000);
        keyword.click("LTP_ICON_CLOSE_PP");
    }

    //Check save product
    public void likeProduct(String btnViewDetail) throws InterruptedException {
        keyword.webDriverWaitForElementPresent("LTP_BOOKLIKE", 50);
        Thread.sleep(1000);
        keyword.click("LTP_BTN_LIKE");
        Thread.sleep(1000);
        keyword.webDriverWaitForElementPresent(btnViewDetail, 10);
        keyword.click(btnViewDetail);
        keyword.back();
    }

    public void subLikeProduct(String saveItem) {
        keyword.imWait(2);
        keyword.scrollDownToElement(saveItem);
        keyword.imWait(2);
        keyword.click(saveItem);
        keyword.imWait(2);
        keyword.clickByCss("LTP_MODAL_OVERLAY");
        keyword.clickByCss("LTP_MODAL_OVERLAY");
    }
}


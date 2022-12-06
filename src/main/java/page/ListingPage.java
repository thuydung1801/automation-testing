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

    public void choseFilter(String scrollElement, String clickElement, String verifyElement) throws InterruptedException {
        keyword.untilJqueryIsDone(10L);
        keyword.scrollDownToElement(scrollElement);
        keyword.click(clickElement);
        keyword.untilJqueryIsDone(20L);
        keyword.checkStatusIsDisplay(verifyElement);
    }

    //go to AllProduct of listingPage section
    public void goToAllProduct() throws InterruptedException {
        keyword.untilJqueryIsDone(30L);
        keyword.webDriverWaitForElementPresent("LTP_TEXT_PAGE", 50);
        keyword.hoverAndClick("LTP_TEXT_MOVE");
        keyword.webDriverWaitForElementPresent("LTP_CLICK_PRODUCT", 10);
        keyword.untilJqueryIsDone(30L);
        keyword.click("LTP_CLICK_PRODUCT");
        keyword.untilJqueryIsDone(30L);
        keyword.scrollDownToElement("ALL_RING_BTN");
        keyword.click("ALL_RING_BTN");
        keyword.scrollToPosition();
        keyword.verifyElementVisible("LTP_LEFT_FILTER");
    }

    //    Check position of Sticker on left filter when applying filter option + scrolling
    public void checkPositionOfSticker() throws InterruptedException {
        choseFilter("LTP_ITEM_CHECK_STICKER_FILTER", "LTP_ITEM_CHECK_STICKER_FILTER", "LTP_POSITION_TICKER");
    }

    //
    public void checkPositionOfStickerWhenUpLoadMore() throws InterruptedException {
        choseFilter("LTP_ITEM_CHECK_STICKER_FILTER_UPLOAD", "LTP_ITEM_CHECK_STICKER_FILTER_UPLOAD", "LTP_CHECK_STICKER_UPLOAD_MORE");
    }

    // Using ajax instead of reloading page when click on filter left
    public void usingAjaxPageNotLoadAgain() throws InterruptedException {
        choseFilter("LTP_CHOSE_STONE_CHECK_AJAX", "LTP_CHOSE_STONE_CHECK_AJAX", "LTP_AJAX_LOADING_ICON");
    }

    //    Filter price displayed when the option has been applied
    public void filterPrice() throws InterruptedException {
        choseFilter("LTP_ITEM_FILTER_CHOSE", "LTP_CLEAR_ALL", "LTP_PRICE_STATUS_DISABLE");
        keyword.untilJqueryIsDone(20L);
        choseFilter("LTP_CHOSE_STONE_CHECK_AJAX", "LTP_CHOSE_STONE_CHECK_AJAX", "LTP_PRICE_ACTIVE");
    }
    //
    public void filterItem() throws InterruptedException {
        keyword.scrollDownToElement("LTP_FILTER_STONES");
        keyword.untilJqueryIsDone(50L);
        keyword.click("LTP_FILTER_STONES");
        keyword.untilJqueryIsDone(20L);
        keyword.assertEqualsAfterCutting("LTP_FILTER_DIAMOND", "LTP_VERIFY_FILTER_STONES");
    }

    public void removeItemsFilter() throws InterruptedException {
        keyword.untilJqueryIsDone(20L);
        keyword.checkStatusIsDisplay("LTP_CLOSE_ITEMS_FILTER");
        keyword.untilJqueryIsDone(20L);
        choseFilter("LTP_CLOSE_ITEMS_FILTER", "LTP_CLOSE_ITEMS_FILTER", "LTP_AJAX_LOADING_ICON");
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
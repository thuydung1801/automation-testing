package page;

import core.*;
import io.cucumber.java.sl.In;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;
import page.signinSignup.SignUpPage;

public class ListingPage extends BasePage {
    public ListingPage(KeywordWeb key) {
        super(key);
    }

    private SignInPage objSigin;
    private SignUpPage objSignUp;

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
        keyword.assertEqualsAfterCutting("LTP_FILTER_DIAMOND", "LTP_VERIFY_FILTER_STONES", 17, 31);
        keyword.untilJqueryIsDone(20L);
        keyword.checkStatusIsDisplay("LTP_VERIFY_IMG");
    }

    //
    public void enterDataFilter(String dataMin, String dataMax, String expected, String actual) throws InterruptedException {
        objSignUp = new SignUpPage(this.keyword);
        keyword.scrollDownToElement("LTP_PRICE");
        objSignUp.clearTextAndSendKey("LTP_INPUT_MIN", "LTP_INPUT_MIN", dataMin);
        objSignUp.clearTextAndSendKey("LTP_INPUT_MAX", "LTP_INPUT_MAX", dataMax);
        keyword.click("LTP_BTN_SUBMIT_PRICE");
        keyword.untilJqueryIsDone(50L);
//        keyword.reLoadPage();
        keyword.untilJqueryIsDone(50L);
        keyword.assertEquals(expected, actual);
    }

    //    Input data of Min > Max price
    public void enterPrice() throws InterruptedException {
        enterDataFilter("LTP_DATA_MIN", "LTP_MAX", "LTP_MESSAGE_NOTIFY", "LTP_ACTUAL");
    }

    //
    public void checkUploadPage() throws InterruptedException {
        keyword.scrollDownToElement("LTP_PRODUCT_VIEW");
        keyword.untilJqueryIsDone(70L);
        keyword.checkStatusIsDisplay("LTP_CHECK_VIEW_PERCENT");
        keyword.untilJqueryIsDone(50L);
        keyword.checkStatusIsDisplay("LTP_BTN_LOADING_MORE");
        keyword.untilJqueryIsDone(50L);
        keyword.scrollDownToElement("LTP_BTN_LOADING_MORE");
        keyword.click("LTP_BTN_LOADING_MORE");
        keyword.checkStatusIsDisplay("LTP_LOADING_MORE_ITEM");
    }

    //    check add  more 30 item
    public void checkUploadMore30Item() throws InterruptedException {
        keyword.click("LTP_BTN_LOADING_MORE");
        keyword.untilJqueryIsDone(30L);
        keyword.scrollDownToElement("LTP_SCROLL_TO_FOOTER");
        keyword.untilJqueryIsDone(50L);
        keyword.assertEqualsAfterCutting("LTP_DATA_VIEWED_PRODUCT_ITEM", "LYP_VIEW_LABEL_TEXT", 14, 17);
    }

    //TLoading page endless with "Upload more" button - do not display this text when not a product load
    public void notShowButtonUploadMore() throws InterruptedException {
        keyword.scrollDownToElement("LTP_PRICE");
        objSignUp.clearTextAndSendKey("LTP_INPUT_MIN", "LTP_INPUT_MIN", "LTP_DATA_MIN1");
        objSignUp.clearTextAndSendKey("LTP_INPUT_MAX", "LTP_INPUT_MAX", "LTP_MAX1");
        keyword.click("LTP_BTN_SUBMIT_PRICE");
        keyword.untilJqueryIsDone(50L);
        keyword.reLoadPage();
        keyword.untilJqueryIsDone(50L);
        if (!checkDisplay()) {
            keyword.assertEquals("LTP_MESSAGE_NOT_FILTER_PRODUCT", "LTP_XPATH_MESSAGE_NOT_FILTER_PRODUCT");
        } else {
            System.out.println("NOOOOO");
        }
    }

    //    Check show button : Upload more (Number products of listing page < 30 products
    public void notShowButtonUploadMoreWhenProductOfPageLessThan30() throws InterruptedException {
        enterDataFilter("LTP_DATA_MIN2", "LTP_DATA_MAX2", "LTP_MESSAGE_EXPECT", "LYP_VIEW_LABEL_TEXT");
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

    public boolean checkDisplay() throws InterruptedException {
        return keyword.verifyElementPresent("LTP_BTN_LOADING_MORE");
    }
}
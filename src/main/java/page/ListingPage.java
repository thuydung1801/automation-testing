package page;

import core.*;
import io.cucumber.java.sl.In;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.testng.Assert;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;
import page.signinSignup.SignUpPage;

public class ListingPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    public ListingPage(KeywordWeb key) {
        super(key);
    }

    private ListingPage objListingPage;
    private RegisterPage objRegist = new RegisterPage(this.keyword);
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

    public void choseFilterAndVerify(String scrollElement, String clickElement, String verifyElement) throws InterruptedException {
        keyword.untilJqueryIsDone(10L);
        keyword.scrollDownToElement(scrollElement);
        keyword.click(clickElement);
        keyword.untilJqueryIsDone(20L);
        keyword.checkStatusIsDisplay(verifyElement);
    }

    //
    public void enterDataFilterAndVerify(String dataMin, String dataMax, String expected, String actual) throws InterruptedException {
        objSignUp = new SignUpPage(this.keyword);
        keyword.scrollDownToElement("LTP_PRICE");
        objSignUp.clearTextAndSendKey("LTP_INPUT_MIN", "LTP_INPUT_MIN", dataMin);
        objSignUp.clearTextAndSendKey("LTP_INPUT_MAX", "LTP_INPUT_MAX", dataMax);
        keyword.click("LTP_BTN_SUBMIT_PRICE");
        keyword.untilJqueryIsDone(50L);
        keyword.untilJqueryIsDone(50L);
        keyword.assertEquals(expected, actual);
    }

    public void scrollAndClick(String scrollToElement, String clickElent) throws InterruptedException {
        keyword.scrollDownToElement(scrollToElement);
        keyword.untilJqueryIsDone(50L);
        keyword.click(clickElent);
    }

    //go to AllProduct of listingPage section
    public void goToAllProduct() throws InterruptedException {
        keyword.untilJqueryIsDone(30L);
        keyword.webDriverWaitForElementPresent("LTP_TEXT_PAGE", 50);
        keyword.click("LISTING_BTN_JEWELRY");
        keyword.webDriverWaitForElementPresent("LISTING_BTN_MENU_RING", 10);
        keyword.untilJqueryIsDone(30L);
        keyword.rightClick("LISTING_BTN_MENU_RING","LISTING_BTN_MENU_DIAMOND_RING");
        keyword.untilJqueryIsDone(30L);
        keyword.scrollToPosition();
        keyword.verifyElementVisible("LTP_LEFT_FILTER");
    }

    //    Filter price displayed when the option has been applied
    public void filterPrice() throws InterruptedException {
        choseFilterAndVerify("LTP_CHOSE_STONE_CHECK_AJAX", "LTP_CHOSE_STONE_CHECK_AJAX", "LTP_PRICE_ACTIVE");
    }


    //
    public void filterItem() throws InterruptedException {
        scrollAndClick("LTP_FILTER_STONES", "LTP_FILTER_STONES");
        keyword.untilJqueryIsDone(20L);
        keyword.assertEqualsAfterCutting("LTP_FILTER_DIAMOND", "LTP_VERIFY_FILTER_STONES", 17, 31);
        keyword.untilJqueryIsDone(20L);
        keyword.checkStatusIsDisplay("LTP_VERIFY_IMG");
    }

    //    Input data of Min > Max price
    public void enterPrice() throws InterruptedException {
        enterDataFilterAndVerify("LTP_DATA_MIN", "LTP_MAX", "LTP_MESSAGE_NOTIFY", "LTP_ACTUAL");
    }

    //check upload page when click load more
    public void checkUploadPage() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.scrollToTheBottomPage();
        Thread.sleep(10000);
        keyword.verifyElementVisible("LTP_BTN_LOADING_MORE");
        keyword.verifyElementVisible("LTP_PRODUCT_VIEW");
        keyword.verifyElementVisible("LTP_CHECK_VIEW_PERCENT");
    }
    public void checkUploadMore() throws InterruptedException {
       // checkUploadPage();
        // get number page url
        String titleURL= keyword.getCurrentPageUrl();
        int page= Integer.parseInt(titleURL.substring(titleURL.length() - 1));
        // get number product view and total product on listing
        String getText= keyword.getText("LISTING_COUNT_VIEW_PRODUCT");
        int numberProduct= Integer.parseInt(getText.substring(14,getText.length()-17));
        System.out.println(numberProduct);
        int totalProduct= Integer.parseInt(getText.substring(21,getText.length()-9));
        System.out.println(totalProduct);
        keyword.click("LTP_BTN_LOADING_MORE");
        keyword.untilJqueryIsDone(50L);
        Thread.sleep(10000);
        keyword.verifyElementVisible("LTP_LOADING_MORE_ITEM");
        //get url after click load more
        String titleURL2 = keyword.getCurrentPageUrl();
        int page2= Integer.parseInt(titleURL2.substring(titleURL2.length() - 1));
        //get number product view and total product on listing after click load more
        String getText2= keyword.getText("LISTING_COUNT_VIEW_PRODUCT");
        int numberProduct2= Integer.parseInt(getText2.substring(14,getText.length()-17));
        int totalProduct2= Integer.parseInt(getText2.substring(21,getText.length()-9));
        logger.info("compare number product view before and after click loading more");
        Assert.assertEquals(numberProduct +60 ,numberProduct2);
        logger.info("compare number total product view before and after click loading more");
        Assert.assertEquals(totalProduct,totalProduct2);
        logger.info("compare number page before and after click loading more");
        Assert.assertEquals(page +1,page2);
    }
    //    check add  more 30 item
    public void checkUploadMore30Item() throws InterruptedException {
        scrollAndClick("LTP_BOX_CARAT", "LTP_SELECT_CARAT");
        keyword.untilJqueryIsDone(100L);
        keyword.scrollToPosition();
        keyword.scrollToTheBottomPage();
        keyword.scrollToTheBottomPage();
        keyword.scrollToTheBottomPage();
        keyword.scrollToTheBottomPage();
        keyword.scrollDownToElement("LTP_BTN_LOADING_MORE");
        keyword.assertEqualsAfterCutting("LTP_VIEW_PRODUCT_OF_6PAGE", "LYP_VIEW_LABEL_TEXT", 14, 17);
//        keyword.click("LTP_BTN_LOADING_MORE");
//        keyword.untilJqueryIsDone(30L);
//        keyword.scrollDownToElement("LTP_SCROLL_TO_FOOTER");
//        keyword.untilJqueryIsDone(50L);
//        keyword.assertEqualsAfterCutting("LTP_DATA_VIEWED_PRODUCT_ITEM_ADD_30PRODUCT", "LYP_VIEW_LABEL_TEXT", 14, 17);
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
        keyword.verifyElementVisible("LTP_BTN_DISPLAY_NONE");
        keyword.assertEquals("LTP_MESSAGE_NOT_FILTER_PRODUCT", "LTP_XPATH_MESSAGE_NOT_FILTER_PRODUCT");
    }

    //    Check show button : Upload more (Number products of listing page < 30 products
    public void notShowButtonUploadMoreWhenProductOfPageLessThan30() throws InterruptedException {
        enterDataFilterAndVerify("LTP_DATA_MIN2", "LTP_DATA_MAX2", "LTP_MESSAGE_EXPECT", "LYP_VIEW_LABEL_TEXT");
    }

    //    Check show button: Upload more when all the products on the page have been loaded  then go back to top and scrolling again
    public void checkButtonUploadMoreWhenShowFullProduct() throws InterruptedException {
        keyword.scrollToTheBottomPage();
        Thread.sleep(1000);
        keyword.click("LTP_TOP_LINK");
        keyword.scrollDownToElement("LTP_VIEW_FULL_PRODUCT");
        keyword.untilJqueryIsDone(20L);
        keyword.compareTheValueOfStrings("LTP_VALUE_FULL_PRODUCT", "LTP_VIEW_FULL_OPTION", 7, 11);
        keyword.verifyElementVisible("LTP_BTN_DISPLAY_NONE");
        keyword.assertEquals("LTP_MESSAGE_SHOW_FULL_PRODUCT", "LYP_VIEW_LABEL_TEXT");
    }
    public void checkPopupProductRelate() throws InterruptedException {
        keyword.scrollToPositionByScript("window.scrollBy(0,500)");
        keyword.untilJqueryIsDone(50L);
        keyword.verifyElementVisible("LISTING_TITLE_PRODUCT1");
        //Check different icon for each related product
        keyword.click("LISTING_TXT_ATTRIBUTE_DIAMONDS");
        String icon1=keyword.getAttribute("LISTING_IMAGE_ATTRIBUTE_DIAMONDS1","alt");
        String icon2=keyword.getAttribute("LISTING_IMAGE_ATTRIBUTE_DIAMONDS2","alt");
        boolean check =(icon1.equalsIgnoreCase(icon2)) ? false:true;
        Assert.assertTrue(check);
        //click this icon => open the popup
        //Show all related products include price/option/name product/ Product image..
        keyword.click("LISTING_IMAGE_ATTRIBUTE_DIAMONDS1");
        keyword.untilJqueryIsDone(50L);
        Thread.sleep(5000);
        keyword.verifyElementPresent("LISTING_IMG_PRODUCT");
        keyword.verifyElementPresent("LISTING_TXT_PRODUCT_NAME");
        keyword.verifyElementPresent("LISTING_TXT_PRODUCT_PRICE");
        keyword.verifyElementPresent("LISTING_TXT_PRODUCT_STONE");
        //Click and go to other product in this popup
        keyword.click("LISTING_IMAGE_ATTRIBUTE_DIAMONDS2");
        keyword.untilJqueryIsDone(50L);
        Thread.sleep(5000);
        keyword.verifyElementPresent("LISTING_IMG_PRODUCT2");
        keyword.verifyElementPresent("LISTING_TXT_PRODUCT_NAME2");
        keyword.verifyElementPresent("LISTING_TXT_PRODUCT_PRICE2");
        keyword.verifyElementPresent("LISTING_TXT_PRODUCT_STONE2");
        //Can close this popup
        keyword.click("LISTING_TXT_ATTRIBUTE_DIAMONDS");
    }
    public void checkFunctionSavedItem() throws InterruptedException {
        //Click to icon ♡
        keyword.randomElement("LISTING_ICON_FAVORITES");
        keyword.untilJqueryIsDone(50L);
        keyword.verifyElementPresent("LISTING_TXT_VIEW_WISHLIST");
    }


    //Auto loading product with 6 pages
    public void removeItemsFilter() throws InterruptedException {
        keyword.untilJqueryIsDone(20L);
        keyword.checkStatusIsDisplay("LTP_CLOSE_ITEMS_FILTER");
        keyword.untilJqueryIsDone(20L);
        choseFilterAndVerify("LTP_CLOSE_ITEMS_FILTER", "LTP_CLOSE_ITEMS_FILTER", "LTP_AJAX_LOADING_ICON");
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
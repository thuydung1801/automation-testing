package page;

import core.*;
import org.slf4j.Logger;

public class ListingPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();

    public ListingPage() {
        super();
    }

    public ListingPage(KeywordWeb key) {
        super(key);
    }

    public void acceptAllCookies() {
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("BTN_COOKIES"), 50);
        keyword.click(PropertiesFile.getPropValue("BTN_COOKIES"));
    }

    public void goToAllProduct() throws InterruptedException {
        keyword.navigateToUrl(PropertiesFile.getPropValue("BASE_URL_LISTINGPAGE"));
        Thread.sleep(2000);
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("BTN_COOKIES"), 1000);
        keyword.click(PropertiesFile.getPropValue("BTN_COOKIES"));
        Thread.sleep(1000);
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("LTP_TEXT_PAGE"), 50);
        Thread.sleep(1000);
        keyword.hoverAndClick(PropertiesFile.getPropValue("LTP_TEXT_MOVE"));
        Thread.sleep(1000);
        keyword.click(PropertiesFile.getPropValue("LTP_CLICK_PRODUCT"));
        Thread.sleep(3000);
        keyword.scrollToPosition();
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("SWITCH_BTN"), 500);
        Thread.sleep(2000);
        keyword.click(PropertiesFile.getPropValue("SWITCH_BTN"));
        Thread.sleep(2000);
        keyword.scrollDownToElement(PropertiesFile.getPropValue("ALL_RING_BTN"));
        Thread.sleep(2000);
        keyword.click(PropertiesFile.getPropValue("ALL_RING_BTN"));
    }

    public void filTerStone() throws InterruptedException {
        keyword.getCurrentPageUrl();
        Thread.sleep(1000);
        keyword.click(PropertiesFile.getPropValue("SELECT_DIAMON_STONES"));
        Thread.sleep(5000);
        keyword.getCurrentPageUrl();
        Thread.sleep(5000);
        keyword.scrollDownToElement(PropertiesFile.getPropValue("LTP_SELECT_CARAT"));
        Thread.sleep(5000);
        keyword.click(PropertiesFile.getPropValue("LTP_SELECT_CARAT"));
        Thread.sleep(5000);
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("LTP_BOOK_CARAT"), 20);
        Thread.sleep(5000);
        keyword.scrollDownToElement(PropertiesFile.getPropValue("LTP_SELECT_STONE_SHAPE"));
        Thread.sleep(5000);
        keyword.click(PropertiesFile.getPropValue("LTP_SELECT_STONE_SHAPE"));
        Thread.sleep(5000);
        keyword.scrollDownToElement(PropertiesFile.getPropValue("LTP_SELECT_COLOR"));
        Thread.sleep(5000);
        keyword.click(PropertiesFile.getPropValue("LTP_SELECT_COLOR"));
        Thread.sleep(5000);
        keyword.scrollDownToElement(PropertiesFile.getPropValue("LTP_SELECT_METAL"));
        Thread.sleep(5000);
        keyword.click(PropertiesFile.getPropValue("LTP_SELECT_METAL"));
        Thread.sleep(5000);
        keyword.scrollDownToElement(PropertiesFile.getPropValue("LTP_BTN_ACCEPT_PRICE"));
        Thread.sleep(5000);
        keyword.click(PropertiesFile.getPropValue("LTP_BTN_ACCEPT_PRICE"));
        Thread.sleep(5000);
    }

    public void deleteFilters() throws InterruptedException {
        keyword.getCurrentPageUrl();
        keyword.click(PropertiesFile.getPropValue("LTP_BTN_DELETE_FILTER"));
        Thread.sleep(5000);
        keyword.click(PropertiesFile.getPropValue("LTP_BTN_DELETE_FILTER(1)"));
        Thread.sleep(5000);
        keyword.click(PropertiesFile.getPropValue("LTP_BTN_DELETEALL"));
    }

    public void sort_prd() throws InterruptedException {
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("LTP_SHORT"), 20);
        Thread.sleep(5000);
        keyword.click(PropertiesFile.getPropValue("LTP_SHORT"));
        Thread.sleep(1000);
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("LTP_BOOK_SHORT"), 10);
        Thread.sleep(1000);
        keyword.click(PropertiesFile.getPropValue("LTP_RELAVANCE"));

    }

    public void viewBTN() throws InterruptedException {
        Thread.sleep(1000);
        keyword.scrollDownToElement(PropertiesFile.getPropValue("LTP_TOOLlBAR"));
        Thread.sleep(5000);
        keyword.clickUseCss(PropertiesFile.getPropValue("LTP_BTN_VIEW2"));
        Thread.sleep(5000);
        keyword.clickUseCss(PropertiesFile.getPropValue("LTP_BTN_VIEW3"));

    }
    public void popupMessage() throws InterruptedException {
        keyword.scrollDownToElement(PropertiesFile.getPropValue("LTP_SCR_TOP"));
        Thread.sleep(1000);
        keyword.click(PropertiesFile.getPropValue("LTP_BTN_ONFO_MESSAGE"));
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("LTP_POPUP_DETAIL"),50);
        Thread.sleep(5000);
        keyword.click(PropertiesFile.getPropValue("LTP_ICON_CLOSE_PP"));
    }

    public  void LikeProduct() throws InterruptedException {
        Thread.sleep(5000);
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("LTP_BOOKLIKE"),50);
        Thread.sleep(1000);
        keyword.click(PropertiesFile.getPropValue("LTP_BTN_LIKE"));
//        Thread.sleep(1000);
//        keyword.webDriverWaitForElementPresentCss(PropertiesFile.getPropValue("LTP_TXT_BOOK_SHOWLIKE"),10);
        Thread.sleep(1000);
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("LTP_BTN_VIEW_DETAIL_BOOKLIKE"),10);
        keyword.click(PropertiesFile.getPropValue("LTP_BTN_VIEW_DETAIL_BOOKLIKE"));
        Thread.sleep(1000);
        keyword.back();
        Thread.sleep(2000);
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("LTP_BTN_SAVED_ITEM"),30);
        Thread.sleep(1000);
//        keyword.scrollDownToElement(PropertiesFile.getPropValue("LTP_BTN_SAVED_ITEM"));
//        Thread.sleep(7000);
//        keyword.click(PropertiesFile.getPropValue("LTP_BTN_SAVED_ITEM"));
//        Thread.sleep(2000);
//        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("LTP_BTN_CLOSE"),5);
//        Thread.sleep(1000);
//        keyword.clickUseCss(PropertiesFile.getPropValue("LTP_MODAL_OVERLAY"));
//        Thread.sleep(2000);
//        keyword.click(PropertiesFile.getPropValue("LTP_BTN_CLOSE"));
    }

}

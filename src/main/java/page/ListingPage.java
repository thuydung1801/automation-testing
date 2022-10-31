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
        keyword.scrollToPosition();
        Thread.sleep(2000);
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("BTN_COOKIES"), 1000);
        keyword.click(PropertiesFile.getPropValue("BTN_COOKIES"));
        Thread.sleep(2000);
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("KEY_PAGE_RING_DIAMON"), 10);
        Thread.sleep(2000);
        keyword.scrollDownToElement(PropertiesFile.getPropValue("SELECT_DIAMON_STONES"));
        Thread.sleep(1000);
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("SWITCH_BTN"), 500);
        Thread.sleep(2000);
        keyword.click(PropertiesFile.getPropValue("SWITCH_BTN"));
        Thread.sleep(1000);
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

//    public void viewBTN() throws InterruptedException {
//        keyword.click(PropertiesFile.getPropValue("LTP_BTN_VIEW_01"));
//        Thread.sleep(5000);
//        keyword.click(PropertiesFile.getPropValue("LTP_BTN_VIEW_02"));
//
//    }

    public void short_prd() throws InterruptedException {
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("LTP_SHORT"), 20);
        Thread.sleep(5000);
        keyword.click(PropertiesFile.getPropValue("LTP_SHORT"));
        Thread.sleep(1000);
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("LTP_BOOK_SHORT"), 10);
        Thread.sleep(1000);
        keyword.click(PropertiesFile.getPropValue("LTP_RELAVANCE"));

    }

}

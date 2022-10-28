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
//        keyword.clickUseCss(PropertiesFile.getPropValue("ALL_RING_BTN"));
        Thread.sleep(2000);
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
//        keyword.click(PropertiesFile.getPropValue("SELECT_DIAMON_STONES"));
        Thread.sleep(2000);
        keyword.click(PropertiesFile.getPropValue("SELECT_DIAMON_STONES"));
        Thread.sleep(2000);
    }

}

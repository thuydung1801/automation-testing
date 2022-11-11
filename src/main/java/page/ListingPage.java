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

    public void scrollToElementAndClick(String veriFyDisplay, String scrollToElement, String clickElement) throws InterruptedException {

    }


    public void goToAllProduct(String allBtn, String btnSwitch) throws InterruptedException {
        keyword.navigateToUrl(PropertiesFile.getPropValue("BASE_URL_LISTINGPAGE"));
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("BTN_COOKIES"), 20);
        keyword.click(PropertiesFile.getPropValue("BTN_COOKIES"));
        Thread.sleep(1000);
        keyword.scrollToPosition();
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue(btnSwitch), 50);
        keyword.click(PropertiesFile.getPropValue(btnSwitch));
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("LTP_TEXT_PAGE"), 50);
        keyword.hoverAndClick(PropertiesFile.getPropValue("LTP_TEXT_MOVE"));
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("LTP_CLICK_PRODUCT"), 10);
        keyword.imWait(7);
        keyword.click(PropertiesFile.getPropValue("LTP_CLICK_PRODUCT"));
        keyword.imWait(7);
        keyword.scrollDownToElement(PropertiesFile.getPropValue(allBtn));
        keyword.click(PropertiesFile.getPropValue(allBtn));
    }

    public void checkFilterStonesAndVerify(String selectElement, String clickElementVerify, String verifyDisplay, String statusElement) throws InterruptedException {
        keyword.scrollDownToElement(PropertiesFile.getPropValue(selectElement));
        keyword.click(PropertiesFile.getPropValue(selectElement));
        Thread.sleep(2000);
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue(clickElementVerify), 30);
        keyword.click(PropertiesFile.getPropValue(clickElementVerify));
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue(verifyDisplay), 30);
        keyword.CheckIsDisplayElement(PropertiesFile.getPropValue(statusElement));
    }

    public void deleteFilters() throws InterruptedException {
        keyword.getCurrentPageUrl();
        keyword.click(PropertiesFile.getPropValue("LTP_BTN_DELETE_FILTER"));
        Thread.sleep(2000);
        keyword.click(PropertiesFile.getPropValue("LTP_BTN_DELETE_FILTER(1)"));
        Thread.sleep(2000);
        keyword.click(PropertiesFile.getPropValue("LTP_BTN_DELETEALL"));
    }

    public void sort_prd() throws InterruptedException {
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("LTP_SHORT"), 20);
        Thread.sleep(1000);
        keyword.click(PropertiesFile.getPropValue("LTP_SHORT"));
        Thread.sleep(1000);
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("LTP_BOOK_SHORT"), 10);
        keyword.click(PropertiesFile.getPropValue("LTP_RELAVANCE"));
    }

    public void viewBTN() throws InterruptedException {
        keyword.scrollDownToElement(PropertiesFile.getPropValue("LTP_TOOLlBAR"));
        Thread.sleep(1000);
        keyword.clickUseCss(PropertiesFile.getPropValue("LTP_BTN_VIEW2"));
        Thread.sleep(1000);
        keyword.clickUseCss(PropertiesFile.getPropValue("LTP_BTN_VIEW3"));

    }

    public void popupMessage() throws InterruptedException {
        keyword.imWait(3);
        keyword.scrollDownToElement(PropertiesFile.getPropValue("LTP_SCR_TOP"));
        keyword.click(PropertiesFile.getPropValue("LTP_BTN_INFO_MESSAGE"));
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("LTP_POPUP_DETAIL"), 50);
        Thread.sleep(1000);
        keyword.click(PropertiesFile.getPropValue("LTP_ICON_CLOSE_PP"));
    }

    public void LikeProduct(String btnViewDetail) throws InterruptedException {
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("LTP_BOOKLIKE"), 50);
        Thread.sleep(1000);
        keyword.click(PropertiesFile.getPropValue("LTP_BTN_LIKE"));
        Thread.sleep(1000);
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue(btnViewDetail), 10);
        keyword.click(PropertiesFile.getPropValue(btnViewDetail));
        keyword.back();

    }

    public void subLikeProduct(String saveItem) throws InterruptedException {
        keyword.imWait(2);
        keyword.scrollDownToElement(PropertiesFile.getPropValue(saveItem));
        keyword.imWait(2);
        keyword.click(PropertiesFile.getPropValue(saveItem));
        keyword.imWait(2);
        keyword.clickUseCss(PropertiesFile.getPropValue("LTP_MODAL_OVERLAY"));
    }
}

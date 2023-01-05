package steps;

import io.cucumber.java.sl.In;
import tests.BaseTest;
import core.KeywordWeb;
import core.PropertiesFile;
import page.home.LoginPage;
import core.BasePage;

import java.util.Properties;

import org.testng.annotations.Test;

public class Steps2 extends BasePage {

    public Steps2() {
        super();
    }

    public Steps2(KeywordWeb key) {
        super(key);
    }

    public LoginPage objLogin;

    public void gotoLogin() throws InterruptedException {
        objLogin = new LoginPage(this.keyword);
        String a = PropertiesFile.getPropValue("CHECKOUT_LA_LBL_CODE");
        System.out.println(a);
        objLogin.loginOnWebsite("LOGIN_DATA_EMAIL", "LOGIN_DATA_PASSWORD",
                "LOGIN_DATA_PHONE_LINH", "LOGIN_DATA_PHONE_PASS", true);
    }

    public void scroll() {
        keyword.scrollToPositionByScript("window.scrollBy(0,920)");
    }

    public void filterListing() throws InterruptedException {
        keyword.navigateToUrl("https://dev4.glamira.com/glau/diamond-rings/");
        keyword.untilJqueryIsDone(50L);
        keyword.scrollToPositionByScript("window.scrollBy(0,450)");
        keyword.click("LTP_FILTER");
        Thread.sleep(2000);
        keyword.untilJqueryIsDone(50L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        keyword.click("LTP_DIAMONDS");
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
    }

    public void filterLeft(String stonesType, String stones) throws InterruptedException {
        keyword.click(stonesType);
        keyword.untilJqueryIsDone(50L);
        keyword.click(stones);
        keyword.untilJqueryIsDone(50L);
        keyword.waitForElementNotVisible(50, "//div[@class='loading-mask']");
    }

    public void filterListingByPerciousStones() throws InterruptedException {
        filterLeft("LTP_PRECIOUS_STONES", "LTP_PRECIOUS_EMERALD");
    }

    public void filterListingBySemiPreciousStones() throws InterruptedException {
        filterLeft("LTP_SEMI_PRECIOUS", "LTP_SELECT_SEMI_PRECIOUS");
    }

    public void filterListingBySwarovskiCrystals() throws InterruptedException {
        keyword.scrollDownToElement("LTP_SWAROVSKI_CRYSTALS");
        filterLeft("LTP_SWAROVSKI_CRYSTALS", "LTP_SELECT_SWAROVSKI");
    }

    public void filterListingByCulturedPearls() throws InterruptedException {
        keyword.scrollDownToElement("LTP_CULTURED_PEARLS");
        filterLeft("LTP_CULTURED_PEARLS", "LTP_SELECT_CULTURED_PEARLS");
    }

    public void filterListingByLabCreatedStones() throws InterruptedException {
        keyword.scrollDownToElement("LTP_LAB_CREATED_STONES");
        filterLeft("LTP_LAB_CREATED_STONES", "LTP_SELECT_LAB_CREATED_STONES");
    }

    public void filterListingByCabochonStones() throws InterruptedException {
        filterLeft("LTP_CABOCHON_STONES", "LTP_SELECT_CABOCHON_STONES");
    }

    public void filterListingByCarat() throws InterruptedException {
        keyword.scrollDownToElement("LTP_REMOTE_FILTER");
        keyword.click("LTP_REMOTE_FILTER");
        filterLeft("LTP_CARAT", "LTP_SELECT_FILTER_CARAT");
    }

    public void filterListingByStoneShape() throws InterruptedException {
        keyword.scrollDownToElement("LTP_REMOTE_FILTER");
        keyword.click("LTP_REMOTE_FILTER");
        filterLeft("LTP_SHAPE", "LTP_SELECT_SHAPE");
    }
    public void filterListingByColour() throws InterruptedException {
        keyword.scrollDownToElement("LTP_REMOTE_FILTER");
        keyword.click("LTP_REMOTE_FILTER");
        filterLeft("LTP_COLOR", "LTP_SELECT_COLOR");
    }
}

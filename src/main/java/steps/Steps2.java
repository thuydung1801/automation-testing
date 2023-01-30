package steps;

import tests.BaseTest;
import core.KeywordWeb;
import core.PropertiesFile;
import page.home.LoginPage;
import core.BasePage;
import java.util.Properties;
import org.testng.annotations.Test;

public class Steps2 extends BasePage {

    public Steps2(){ super(); }
    public Steps2(KeywordWeb key){
        super(key);
    }
    public LoginPage objLogin;

    public void gotoLogin() throws InterruptedException {
        objLogin = new LoginPage(this.keyword);
        String a = PropertiesFile.getPropValue("CHECKOUT_LA_LBL_CODE");
        System.out.println(a);
        objLogin.loginOnWebsite("LOGIN_DATA_EMAIL","LOGIN_DATA_PASSWORD",
                "LOGIN_DATA_PHONE_LINH","LOGIN_DATA_PHONE_PASS", true);
    }

    public void scroll(){
        keyword.scrollToPositionByScript("window.scrollBy(0,920)");
    }

    public void filterListing() throws InterruptedException {
        keyword.navigateToUrl("https://dev4.glamira.com/glau/diamond-rings/");
        keyword.untilJqueryIsDone(50L);
        keyword.scrollToPositionByScript("window.scrollBy(0,450)");
        keyword.click("LTP_FILTER");
        Thread.sleep(2000);
        keyword.untilJqueryIsDone(50L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("LTP_DIAMONDS");
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
    }

    public void filterListingByPerciousStones() throws InterruptedException {
        keyword.click("LTP_PRECIOUS_STONES");
        keyword.untilJqueryIsDone(50L);
        keyword.click("LTP_PRECIOUS_EMERALD");
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
    }
    public void filterByPerciousStones() throws InterruptedException {
        keyword.click("LTP_PRECIOUS_STONES");
        keyword.untilJqueryIsDone(50L);
        keyword.click("LTP_PRECIOUS_EMERALD");
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
    }
    public void filterByPercious() throws InterruptedException {
        keyword.click("LTP_PRECIOUS_STONES");
        keyword.untilJqueryIsDone(50L);
        keyword.click("LTP_PRECIOUS_EMERALD");
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
    }
}

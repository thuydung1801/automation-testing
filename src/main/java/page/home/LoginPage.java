package page.home;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import org.slf4j.Logger;

public class LoginPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();

    public LoginPage(KeywordWeb key){
        super(key);
    }
    public LoginPage(){ super(); }

    public void loginOnAlert(){
        keyword.handleLoginPopup(PropertiesFile.getPropValue("LOGIN_DATA_ALERT_USERNAME"),
                PropertiesFile.getPropValue("LOGIN_DATA_ALERT_PASSWORD"),
                PropertiesFile.getPropValue("LOGIN_AUTHEN_URL"));
    }
    public void loginOnWebsite() throws InterruptedException {
        Thread.sleep(3000);
        keyword.click("LOGIN_BTN_LOGIN");
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("LOGIN_LBL_LOGIN"),30);
        Thread.sleep(2000);
        keyword.sendKeys(PropertiesFile.getPropValue("LOGIN_TXT_EMAIL"),
                PropertiesFile.getPropValue("LOGIN_DATA_EMAIL"));
        Thread.sleep(2000);
        keyword.sendKeys(PropertiesFile.getPropValue("LOGIN_TXT_PASSWORD"),
                PropertiesFile.getPropValue("LOGIN_DATA_PASSWORD"));
        Thread.sleep(2000);
        keyword.click("LOGIN_BTN_SUBMITLOGIN");

    }
}

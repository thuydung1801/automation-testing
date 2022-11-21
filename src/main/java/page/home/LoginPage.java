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
    public void loginOnWebsite(String email, String password, String phone,
                               String phonePassword, boolean byEmail) throws InterruptedException {
        Thread.sleep(3000);
        keyword.click("LOGIN_BTN_LOGIN");
        keyword.webDriverWaitForElementPresent("LOGIN_LBL_LOGIN",30);
        Thread.sleep(2000);
        if(keyword.verifyElementPresent("LOGIN_TXT_EMAIL")){
            keyword.sendKeys("LOGIN_TXT_EMAIL", email);
            Thread.sleep(2000);
            keyword.sendKeys("LOGIN_TXT_PASSWORD", password);
            Thread.sleep(2000);
        }
        if(keyword.verifyElementPresent("LOGIN_TBX_PHONE")){
            keyword.sendKeys("LOGIN_TBX_PHONE", phone);
            Thread.sleep(2000);
            keyword.sendKeys("LOGIN_TXT_PASSWORD", phonePassword);
            Thread.sleep(2000);
        }
        if(keyword.verifyElementPresent("LOGIN_TXT_EMAIL_2")) {
            if (byEmail) {
                keyword.sendKeys("LOGIN_TXT_EMAIL_2", email);
                Thread.sleep(2000);
                keyword.sendKeys("LOGIN_TXT_PASSWORD", password);
                Thread.sleep(2000);
            }else {
                keyword.sendKeys("LOGIN_TBX_PHONE_2", phone);
                Thread.sleep(2000);
                keyword.sendKeys("LOGIN_TXT_PASSWORD", phonePassword);
                Thread.sleep(2000);
            }
        }

        keyword.click("LOGIN_BTN_SUBMITLOGIN");

    }
}

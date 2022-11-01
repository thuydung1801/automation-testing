package page.home;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import org.slf4j.Logger;

public class RegisterPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    public RegisterPage(){ super(); }
    public RegisterPage(KeywordWeb key){
        super(key);
    }

    public void acceptAllCookies() throws InterruptedException {

        Thread.sleep(3000);
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("BTN_COOKIES"),50);
        keyword.click(PropertiesFile.getPropValue("BTN_COOKIES"));

        //keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("LOGIN_BTN_LANGUAGE"),50);

    }
    public void chooseLanguages() throws InterruptedException {
        Thread.sleep(2000);
        keyword.scrollToPosition();
        Thread.sleep(3000);
        if(keyword.verifyElementPresent(PropertiesFile.getPropValue("LOGIN_BTN_LANGUAGE"))){
            keyword.click(PropertiesFile.getPropValue("LOGIN_BTN_LANGUAGE"));
        }
    }
    public void registFail(){

        keyword.navigateToUrl(PropertiesFile.getPropValue("BASE_URL"));
        keyword.click(PropertiesFile.getPropValue("REGIST_BTN_SUBMIT"));
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("LBL_ERROR_MESSAGE"), 10);
    }
    public void  registSuccess() throws InterruptedException {
        keyword.sendKeys(PropertiesFile.getPropValue("REGIST_TXT_FIRSTNAME"),
                PropertiesFile.getPropValue("REGIST_DATA_FISTNAME"));
        Thread.sleep(2000);
        keyword.sendKeys(PropertiesFile.getPropValue("REGIST_TXT_LASTNAME"),
                PropertiesFile.getPropValue("REGIST_DATA_LASTNAME"));
        Thread.sleep(2000);
        keyword.sendKeys(PropertiesFile.getPropValue("REGIST_TXT_MOBILE_NUMBER"),
                PropertiesFile.getPropValue("REGIST_DATA_MOBILE_NUMBER"));
        Thread.sleep(2000);
        keyword.sendKeys(PropertiesFile.getPropValue("REGIST_TXT_EMAIL_ADDRESS"),
                PropertiesFile.getPropValue("REGIST_DATA_EMAIL_ADDRESS"));
        Thread.sleep(2000);
        keyword.sendKeys(PropertiesFile.getPropValue("REGIST_TXT_EMAIL_CONFIRM"),
                PropertiesFile.getPropValue("REGIST_DATA_EMAIL_ADDRESS"));
        Thread.sleep(2000);
        keyword.sendKeys(PropertiesFile.getPropValue("REGIST_TXT_PASSWORD"),
                PropertiesFile.getPropValue("REGIST_DATA_PASSWORD"));
        Thread.sleep(2000);
        keyword.sendKeys(PropertiesFile.getPropValue("REGIST_TXT_CONFIRM_PASSWORD"),
                PropertiesFile.getPropValue("REGIST_DATA_PASSWORD"));
        keyword.recaptchaClick();
        Thread.sleep(2000);
        keyword.click(PropertiesFile.getPropValue("REGIST_BTN_SUBMIT"));
    }
}
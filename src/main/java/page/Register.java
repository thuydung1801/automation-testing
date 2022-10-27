package page;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import org.slf4j.Logger;

public class Register extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    public Register(){ super(); }
    public Register(KeywordWeb key){
        super(key);
    }

    public void acceptAllCookie(){
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("BTN_COOKIES"),50);
        keyword.click(PropertiesFile.getPropValue("BTN_COOKIES"));
    }
    public void registFail(){

        keyword.navigateToUrl(PropertiesFile.getPropValue("BASE_URL"));
        keyword.click(PropertiesFile.getPropValue("REGIST_BTN_SUBMIT"));
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("LBL_ERROR_MESSAGE"), 10);
    }
    public void registSuccess() throws InterruptedException {
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

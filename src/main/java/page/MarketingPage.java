package page;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import org.slf4j.Logger;
import page.home.LoginPage;
import page.home.RegisterPage;

public class MarketingPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private LoginPage objLogin;
    private RegisterPage objRegister ;
    public MarketingPage() {
        super();
    }
    public MarketingPage(KeywordWeb key){
        super(key);
        objLogin = new LoginPage();
        objRegister = new RegisterPage();
    }
    public void setUp() throws InterruptedException {
        objLogin.loginOnAlert();
        objRegister.acceptAllCookies();
        objRegister.chooseLanguages();
    }
    public void ipData(String name, String email,String mess, String submit) throws InterruptedException {
        keyword.imWait(5);
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("MRT_INP_NAME"),8);
        keyword.sendKeys(PropertiesFile.getPropValue("MRT_INP_NAME"), PropertiesFile.getPropValue(name));
        keyword.sendKeys(PropertiesFile.getPropValue("MRT_INP_EMAIL"),PropertiesFile.getPropValue(email));
        keyword.sendKeys(PropertiesFile.getPropValue("MRT_INP_MESSAGE"),PropertiesFile.getPropValue(mess));
        Thread.sleep(20000);
        keyword.click(PropertiesFile.getPropValue(submit));

    }
    public void checkVerifyInputNull(){
        keyword.assertEquals(PropertiesFile.getPropValue("DATA_MESSAGES_NULL"),
                PropertiesFile.getPropValue("TEXT_ERROR"));
    }
    public void checkVerifyInputWithEmailAndAmountError(){
        keyword.assertEquals(PropertiesFile.getPropValue("DATA_MESSAGES_NUMBER"),
                PropertiesFile.getPropValue("TEXT_ERROR_NUMBER"));

        keyword.assertEquals(PropertiesFile.getPropValue("DATA_MESSAGES_EMAIL"),
                PropertiesFile.getPropValue("MRT_TEXT_ERROR_EMAIL"));

    }

    public void giftCardInpWithNull() throws InterruptedException {
        setUp();
        Thread.sleep(5000);
        keyword.navigateToUrl(PropertiesFile.getPropValue("MRT_URL"));
        ipData("DATA_NULL","DATA_NULL","DATA_NULL","MRT_SUBMIT");
        checkVerifyInputNull();

    }
    public void giftCardInpWithEmailAndAmountError() throws InterruptedException {
//        setUp();
        keyword.openNewTab(PropertiesFile.getPropValue("MRT_URL"));
        keyword.sendKeys(PropertiesFile.getPropValue("MRT_INP_AMOUNT"), PropertiesFile.getPropValue("MRT_INP_DATA_AMOUNT_ERROR"));
        ipData("MRT_INP_DATA_NAME","DATA_ERROR","MRT_INP_DATA_MESSAGE","MRT_SUBMIT");
        checkVerifyInputWithEmailAndAmountError();

    }
    public void giftCardWithAmount() throws InterruptedException {
//        setUp();
        keyword.openNewTab(PropertiesFile.getPropValue("MRT_URL"));
        keyword.click( PropertiesFile.getPropValue("MRT_AMOUNT"));
        ipData("MRT_INP_DATA_NAME","MRT_INP_DATA_EMAIL","MRT_INP_DATA_MESSAGE","MRT_SUBMIT");

    }
    public void giftCardWithOtherAmount() throws InterruptedException {
//        setUp();
        keyword.openNewTab(PropertiesFile.getPropValue("MRT_URL"));
        keyword.sendKeys(PropertiesFile.getPropValue("MRT_INP_AMOUNT"), PropertiesFile.getPropValue("MRT_INP_DATA_AMOUNT"));
        ipData("MRT_INP_DATA_NAME","MRT_INP_DATA_EMAIL","MRT_INP_DATA_MESSAGE","MRT_SUBMIT");

    }

}

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
        keyword.webDriverWaitForElementPresent("MRT_INP_NAME",8);
        keyword.sendKeys("MRT_INP_NAME", name);
        keyword.sendKeys("MRT_INP_EMAIL",email);
        keyword.sendKeys("MRT_INP_MESSAGE",mess);
        Thread.sleep(20000);
        keyword.click(submit);

    }
    public void checkVerifyInputNull(){
        keyword.assertEquals("DATA_MESSAGES_NULL",
                "TEXT_ERROR");
    }
    public void checkVerifyInputWithEmailAndAmountError(){
        keyword.assertEquals("DATA_MESSAGES_NUMBER",
                "TEXT_ERROR_NUMBER");

        keyword.assertEquals("DATA_MESSAGES_EMAIL",
               "MRT_TEXT_ERROR_EMAIL");

    }

    public void giftCardInpWithNull() throws InterruptedException {
        setUp();
        Thread.sleep(5000);
        keyword.navigateToUrl("MRT_URL");
        ipData("DATA_NULL","DATA_NULL","DATA_NULL","MRT_SUBMIT");
        checkVerifyInputNull();

    }
    public void giftCardInpWithEmailAndAmountError() throws InterruptedException {
//        setUp();
        keyword.openNewTab("MRT_URL");
        keyword.sendKeys("MRT_INP_AMOUNT", "MRT_INP_DATA_AMOUNT_ERROR");
        ipData("MRT_INP_DATA_NAME","DATA_ERROR","MRT_INP_DATA_MESSAGE","MRT_SUBMIT");
        checkVerifyInputWithEmailAndAmountError();

    }
    public void giftCardWithAmount() throws InterruptedException {
//        setUp();
        keyword.openNewTab("MRT_URL");
        keyword.click( "MRT_AMOUNT");
        ipData("MRT_INP_DATA_NAME","MRT_INP_DATA_EMAIL","MRT_INP_DATA_MESSAGE","MRT_SUBMIT");

    }
    public void giftCardWithOtherAmount() throws InterruptedException {
//        setUp();
        keyword.openNewTab("MRT_URL");
        keyword.sendKeys("MRT_INP_AMOUNT", "MRT_INP_DATA_AMOUNT");
        ipData("MRT_INP_DATA_NAME","MRT_INP_DATA_EMAIL","MRT_INP_DATA_MESSAGE","MRT_SUBMIT");

    }

}

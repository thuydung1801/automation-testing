package page;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;

public class MarketingPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private LoginPage objLogin;
    private RegisterPage objRegister ;
    private LoginPage loginPage;
    private SignInPage signInPage;
    public MarketingPage() {
        super();
    }
    public MarketingPage(KeywordWeb key){
        super(key);
        objLogin = new LoginPage();
        objRegister = new RegisterPage();
        loginPage = new LoginPage();
        signInPage = new SignInPage();
    }
    public void setUp() throws InterruptedException {
        objLogin.loginOnAlert();
        objRegister.acceptAllCookies();
        objRegister.chooseLanguages();
    }
    public void ipDataGiftCard(String name, String email,String mess, String submit) throws InterruptedException {
        keyword.imWait(5);
        keyword.webDriverWaitForElementPresent("MRT_INP_NAME",8);
        keyword.sendKeys("MRT_INP_NAME", name);
        keyword.sendKeys("MRT_INP_EMAIL",email);
        keyword.sendKeys("MRT_INP_MESSAGE",mess);
        Thread.sleep(20000);
        keyword.click(submit);

    }
    public void checkVerifyInputNull(){
        keyword.assertEquals("COM_DATA_MESSAGES_NULL",
                "COM_TEXT_ERROR");
    }
    public void checkVerifyInputWithEmailAndAmountError(){
        keyword.assertEquals("COM_DATA_MESSAGES_NUMBER",
                "COM_TEXT_ERROR_NUMBER");

        keyword.assertEquals("COM_DATA_MESSAGES_EMAIL",
               "MRT_TEXT_ERROR_EMAIL");

    }

    public void giftCardInpWithNull() throws InterruptedException {
        setUp();
        Thread.sleep(5000);
        keyword.navigateToUrl("MRT_URL");
        ipDataGiftCard("COM_DATA_NULL","COM_DATA_NULL","COM_DATA_NULL","MRT_SUBMIT");
        checkVerifyInputNull();

    }
    public void giftCardInpWithEmailAndAmountError() throws InterruptedException {
//        setUp();
        keyword.openNewTab("MRT_URL");
        keyword.sendKeys("MRT_INP_AMOUNT", "MRT_INP_DATA_AMOUNT_ERROR");
        ipDataGiftCard("COM_INP_DATA_NAME","COM_DATA_ERROR","COM_INP_DATA_MESSAGE","MRT_SUBMIT");
        checkVerifyInputWithEmailAndAmountError();

    }
    public void giftCardWithAmount() throws InterruptedException {
//        setUp();
        keyword.openNewTab("MRT_URL");
        keyword.click( "MRT_AMOUNT");
        ipDataGiftCard("COM_INP_DATA_NAME","COM_INP_DATA_EMAIL","COM_INP_DATA_MESSAGE","MRT_SUBMIT");

    }
    public void giftCardWithOtherAmount() throws InterruptedException {
//        setUp();
        keyword.openNewTab("MRT_URL");
        keyword.sendKeys("MRT_INP_AMOUNT", "MRT_INP_DATA_AMOUNT");
        ipDataGiftCard("COM_INP_DATA_NAME","COM_INP_DATA_EMAIL","COM_INP_DATA_MESSAGE","MRT_SUBMIT");

    }
    public void ipDataGirftCetificate(String name, String email,String title,String message,String option, String submit){
        keyword.sendKeys("GCE_INP_NAME", name);
        keyword.sendKeys("GCE_INP_MAIL", email);
        keyword.sendKeys("GCE_INP_TITLE", title);
        keyword.sendKeys("GCE_INP_MESSAGE", message);
        if(option != null) {
            keyword.click(option);
        }
        keyword.click(submit);

    }
    public void commonGirftCetificate(){
        keyword.navigateToUrl("https://dev3.glamira.com/glde/customer/account/index/");
        keyword.click("GCE_LINK_VIEW");
        keyword.scrollDownToElement("GCE_LINK_CREATE_GIRFT");
        keyword.imWait(2);
        keyword.click("GCE_LINK_CREATE_GIRFT");
        keyword.imWait(2);
    }
    public void createNewGriftCetificateFormMyOrder() throws InterruptedException {
        setUp();
        loginPage.loginOnWebsite("COM_INP_DATA_EMAIL", "COM_INP_DATA_PASS");
        Thread.sleep(5000);
        keyword.click("GCE_BTN_ACCOUNT");
        keyword.imWait(3);
        commonGirftCetificate();
        ipDataGirftCetificate("COM_INP_DATA_NAME","COM_INP_DATA_EMAIL","COM_DATA_TITLE","COM_INP_DATA_MESSAGE",null,"GCE_BTN_SUBMIT");
    }
    public void createNewCetificateWithOptionNO(){
        ipDataGirftCetificate("COM_INP_DATA_NAME","COM_INP_DATA_EMAIL","COM_DATA_TITLE","COM_INP_DATA_MESSAGE","GCE_OPTION_NO","GCE_BTN_DOWNLOAD");
    }
    public void createNewCetificateWithOptionYES(){
        keyword.reLoadPage();
        ipDataGirftCetificate("COM_INP_DATA_NAME","COM_INP_DATA_EMAIL","COM_DATA_TITLE","COM_INP_DATA_MESSAGE",null,"GCE_BTN_DOWNLOAD");
    }

    public void adminChooseEmailLog(String text) throws InterruptedException {

//        keyword.checkStatusIsDisplay("ADMIN_CUS_EMAILLOG_BTN_FILTER");
//        System.out.printf("===========");
        Thread.sleep(3000);
        keyword.click("ADMIN_CUS_EMAILLOG_BTN_FILTER");

//        keyword.checkStatusIsDisplay("ADMIN_CUS_EMAILLOG_FILTER_INP_SUBJECT");
//        System.out.printf("===========");
        Thread.sleep(3000);
        keyword.clearText("ADMIN_CUS_EMAILLOG_FILTER_INP_SUBJECT");
        keyword.sendKeys("ADMIN_CUS_EMAILLOG_FILTER_INP_SUBJECT",text);

        Thread.sleep(3000);
        keyword.click("ADMIN_CUS_EMAILLOG_ENTER_FILTER");
        Thread.sleep(2000);
        keyword.click("ADMIN_CUS_EMAILLOG_ACTION_SELECT");
        keyword.click("ADMIN_CUS_EMAILLOG_ACTION_SELECT_VIEW");

        Thread.sleep(2000);
        keyword.checkStatusIsDisplay("ADMIN_CUS_EMAILLOG_ACTION_SELECT_LINK_CREATE");
        System.out.printf("===========");
        Thread.sleep(3000);
        keyword.click("ADMIN_CUS_EMAILLOG_ACTION_SELECT_LINK_CREATE");
        Thread.sleep(2000);

    }

    public void createNewGriftCetificateFormEmailWithLogin() throws InterruptedException {
        setUp();
        loginPage.loginOnWebsite("COM_INP_DATA_EMAIL", "COM_INP_DATA_PASS");
        Thread.sleep(5000);
        keyword.click("GCE_BTN_ACCOUNT");
        keyword.imWait(5);

        keyword.navigateToUrl("https://dev3.glamira.com/glde/customer/account/index/");
        String getIdOrder = keyword.getText("GCE_TEXT_ORDER");
        String text = getIdOrder.substring(1,getIdOrder.length());
        signInPage.openNewTabs();
        signInPage.loginAdmin("LOGIN_DATA_USER_NAME", "LOGIN_DATA_PASS_WORD");
        Thread.sleep(5000);
        signInPage.chooseMenuCustomer();
        adminChooseEmailLog(text);
        ipDataGirftCetificate("COM_INP_DATA_NAME","COM_INP_DATA_EMAIL","COM_DATA_TITLE","COM_INP_DATA_MESSAGE",null,"GCE_BTN_SUBMIT");
        Thread.sleep(2000);
    }
    public void createNewGriftCetificateFormEmailWithNotLogin(){
        keyword.navigateToUrl("https://dev3.glamira.com/glde/customer/account/index/");

    }
    public void createNewGriftCetificateWithDataNull(){
        commonGirftCetificate();
        ipDataGirftCetificate("COM_DATA_NULL", "COM_DATA_NULL","COM_DATA_NULL","COM_DATA_NULL",null,"GCE_BTN_SUBMIT");
        checkVerifyInputNull();
    }

}

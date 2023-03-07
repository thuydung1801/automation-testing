package page;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import org.slf4j.Logger;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;

public class MarketingPageMobile extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private LoginPage objLogin;
    private RegisterPage objRegister ;
    private LoginPage loginPage;
    public SignInPage signInPage;
    private MarketingPage marketingPage;
    //    private SignInPage objsignInPage;
    public MarketingPageMobile() {
        super();
    }
    public MarketingPageMobile(KeywordWeb key){
        super(key);
        objLogin = new LoginPage();
        objRegister = new RegisterPage();
        loginPage = new LoginPage();
        signInPage = new SignInPage();
        marketingPage=new MarketingPage();
//        signInPage = new SignInPage(this.keyword);
    }
    public void createNewGriftCetificateFormMyOrder() throws InterruptedException {
        //   setUp();
        loginPage.loginOnMobile("COM_INP_DATA_EMAIL", "COM_INP_DATA_PASS");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
//        keyword.webDriverWaitForElementPresent("GCE_BTN_ACCOUNT",10);
//        keyword.click("GCE_BTN_ACCOUNT");
//        keyword.imWait(3);
        commonGirftCetificate();
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        marketingPage.ipDataGirftCetificate("COM_INP_DATA_NAME","COM_INP_DATA_EMAIL","COM_DATA_TITLE","COM_INP_DATA_MESSAGE",null,"GCE_BTN_SUBMIT");
        marketingPage.verifyGCEsuccess();
    }
    public void commonGirftCetificate() throws InterruptedException {
//        keyword.navigateToUrl("https://dev3.glamira.com/glgb/customer/account/index/");
        keyword.click("CGE_CLICK_ORDER");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("CGE_CLICK_ORDER_VIEW");
        keyword.untilJqueryIsDone(30L);
        keyword.scrollDownToElement("GCE_LINK_CREATE_GIRFT");
        keyword.imWait(2);
        keyword.click("GCE_LINK_CREATE_GIRFT");
        keyword.imWait(2);
    }
}

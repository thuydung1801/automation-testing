package page.checkout;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import org.slf4j.Logger;
import page.MyAccountPage;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;

public class ShoppingBagPageMobile extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private LoginPage objLogin;
    private RegisterPage objRegister ;
    private LoginPage loginPage;
    public SignInPage signInPage;
    private MyAccountPage myAccountPage;

    public SignInPage objSignIn;

    public ShoppingBagPageMobile(){ super(); }
    public ShoppingBagPageMobile(KeywordWeb key){
        super(key);
        objLogin = new LoginPage();
        objRegister = new RegisterPage();
        loginPage = new LoginPage();
        signInPage = new SignInPage();
        myAccountPage = new MyAccountPage();
    }


    public void loginAdmin() throws InterruptedException {
        signInPage.openNewTabs();
        keyword.maximizeWindow();
        signInPage.loginAdmin("LOGIN_DATA_USER_NAME_DUNG", "LOGIN_DATA_PASS_WORD_DUNG");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

    }
    public void setup() throws InterruptedException {
        objLogin.loginOnMobile("LOGIN_DATA_EMAIL","LOGIN_DATA_PASSWORD");

    }
    public void viewReturn() throws InterruptedException {
        loginAdmin();
        keyword.click("LOGIN_ADMIN_BTN_LOGISTIC");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("LOGIN_ADMIN_BTN_LOGISTIC_ITEM");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.selectDropDownListByName("LOGIN_ADMIN_BTN_LOGISTIC_ITEM_SELECT_PAGE","200");
        keyword.pressEnter();
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        myAccountPage.searchElement();

        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("LOGIN_ADMIN_BTN_LOGISTIC_ITEM_VIEW_ORDER");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.switchToTab(2);
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("LOGIN_ADMIN_BTN_LOGISTIC_LOGIN_CUS");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        //login as customer
        keyword.selectDropDownListByName("LOGIN_ADMIN_BTN_LOGISTIC_LOGIN_CUS_UK","GLAMIRA.co.uk");
        keyword.pressEnter();
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("LOGIN_ADMIN_BTN_LOGISTIC_LOGIN_CUS_OK");
        // go to My Return
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.switchToTab(3);
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("MAC_MY_ORD_BTN_COMPLETE");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("MAC_MY_ORD_BTN_RETURN");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.verifyElementVisible("MAC_MY_ORD_VERIFY_RETURN");
    }
}

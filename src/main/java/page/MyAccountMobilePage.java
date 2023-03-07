package page;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import org.slf4j.Logger;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;

import java.security.PublicKey;
import java.util.Date;

public class MyAccountMobilePage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private LoginPage objLogin;
    private RegisterPage objRegister;
    private SignInPage signInPage;
    private MyAccountPage objMyAccount;
    public int countAdd;
    public MyAccountMobilePage(KeywordWeb key) {
        super(key);
        objLogin = new LoginPage();
        objRegister = new RegisterPage();
        signInPage = new SignInPage();
        objMyAccount = new MyAccountPage(this.keyword);
    }
    public void changeFullnameWithData() throws InterruptedException {
        setUp();
        objMyAccount.inpFullName("MAC_DATA_FIRST_NAME_STAGE", "MAC_DATA_LAST_NAME_STAGE");
        objMyAccount.checkVerifyChangeSuccess("CUS_VERIFY_NEWSLETTER_UNSUBSCRIBE", "MAC_VERIFY_DATA_FULLNAME", "name", "MAC_VERIFY_NAME", null);
    }
    public void changeFullNameWithDataNUll() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.click("BTN_MYACCOUNT_ON_MOBILE");
        commonPersonalInfOnMobile(null);
        objMyAccount.inpFullName("COM_DATA_NULL", "COM_DATA_NULL");
        objMyAccount.checkVerifyInputNull();
    }
    public void changeEmail() throws InterruptedException {
//        keyword.click("BTN_PERSONAL");
        inputChangeMail();
        objMyAccount.checkVerifyChangeSuccess("CUS_VERIFY_NEWSLETTER_UNSUBSCRIBE", "MAC_VERIFY_DATA_FULLNAME", "email", "MAC_VERIFY_EMAIL_CHANGE", "COM_INP_DATA_EMAIL_STAGE");
    }
    public void inputChangeMail() throws InterruptedException {
        commonPersonalInfOnMobile("MAC_CLICK_CHECKBOX_EMAIL");
        String timestamp = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String mail = "thanh" + timestamp + "@gmail.com";
        PropertiesFile.serPropValue("COM_INP_DATA_EMAIL_STAGE", mail);
        keyword.sendKeys("MAC_INP_EMAIL_NEW", "COM_INP_DATA_EMAIL_NEW_MOBILE");
        keyword.sendKeys("MAC_INP_PASS_CURENT_1", "COM_INP_DATA_EMAIL_STAGE_MOBILE");
        keyword.click("MAC_BTN_SAVE_2");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
    }
    public void commonPersonalInfOnMobile(String checkBox) throws InterruptedException {
        keyword.untilJqueryIsDone(70L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        keyword.click("MAC_PERSONAL_INF_MOBILE");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        if (checkBox != null) {
            keyword.click(checkBox);
        }
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
    }
    public void setUp() throws InterruptedException {
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        objRegister.acceptAllCookies();
        keyword.untilJqueryIsDone(30L);
        keyword.navigateToUrl("https://stage.glamira.co.uk/");
        keyword.untilJqueryIsDone(30L);
        objLogin.loginOnMobile("COM_INP_DATA_EMAIL_STAGE_MOBILE", "COM_INP_DATA_PASS_STAGE_MOBILE");
        keyword.untilJqueryIsDone(30L);
        keyword.navigateToUrl("https://stage.glamira.co.uk/customer/account/edit/");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
    }
//
}

package page;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import org.slf4j.Logger;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;
import page.signinSignup.SignUpPage;

import java.util.Date;

public class CreateAccountMobilePage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private SignUpPage objSignUp;
    private RegisterPage objRegist;
    private SignInPage objSignIn;
    private CreateAccountOnStagePage objCreateAccount;

    public CreateAccountMobilePage(KeywordWeb key) {
        super(key);
        objCreateAccount=new CreateAccountOnStagePage(this.keyword);
    }

    public void CreateNewCustomerSuccessfully() throws Exception {
        keyword.untilJqueryIsDone(50L);
        keyword.scrollDownToElement("LOGIN_MENULEFT");
        keyword.untilJqueryIsDone(50L);
        keyword.click("LOGIN_MENULEFT");
        keyword.untilJqueryIsDone(50L);
        keyword.click("MOBILE_BTN_LOGIN");
        keyword.untilJqueryIsDone(50L);
        keyword.scrollDownToElement("SIGNUP_BTN_CREATE_MY_ACCOUNT");
        keyword.untilJqueryIsDone(50L);
        keyword.click("SIGNUP_BTN_CREATE_MY_ACCOUNT");
        keyword.webDriverWaitForElementPresent("SIGNUP_FORM_DATA_INFORMATION", 500);
        objCreateAccount.sendKeyFormDataLogin();
        objCreateAccount.sendKeyFormPassword();
        getCodeSetup("SIGNUP_INPUT_VERIFY_CODE", "SIGNUP_BTN_SUBMIT_ACCOUNT");
        keyword.untilJqueryIsDone(50L);
        keyword.verifyElementVisible("SIGNUP_MESSAGE_REGIS_SUCCESS_US");
        keyword.assertEquals("SIGNUP_MESSAGE_SIGNUP_SUCCESS_AU", "SIGNUP_MESSAGE_REGIS_SUCCESS_US");
    }

    public void forgotPassWordCheckOut() throws Exception {
        keyword.navigateToUrl("https://stage.glamira.co.uk/glamira-pendant-elsie.html?alloy=red_white-585&stone1=diamond-Brillant");
        keyword.untilJqueryIsDone(50L);
        keyword.scrollDownToElement("CHECKOUT_ADDPRODUCT_BTN_ADD");
        keyword.click("BTN_COOKIES");
        keyword.click("CHECKOUT_ADDPRODUCT_BTN_ADD");
        keyword.verifyElementVisible("BTN_VIEW_CART");
        keyword.click("BTN_VIEW_CART");
        keyword.untilJqueryIsDone(50L);
        Thread.sleep(3000);
        keyword.click("LA_BTN_PROCEED_TO_CHECKOUT");
        keyword.verifyElementVisible("FORM_CHECKOUT_VRF");
        keyword.click("CHECKOUT_LA_HPL_FORGOT_PASS");
        sendData();
    }

    public void forgotPassWord() throws Exception {
        objRegist = new RegisterPage(this.keyword);
        keyword.untilJqueryIsDone(50L);
        keyword.deleteAllCookies();
        keyword.reLoadPage();
        keyword.deleteAllCookies();
        keyword.untilJqueryIsDone(50L);
        keyword.untilJqueryIsDone(50L);
        keyword.verifyElementVisible("FORM_LOGIN_NEW");
        keyword.untilJqueryIsDone(50L);
        keyword.click("BTN_FORGOT_PASSWORD_NEW");
        keyword.untilJqueryIsDone(50L);
        Thread.sleep(3000);
        objRegist.chooseLanguages();
        keyword.untilJqueryIsDone(30L);
        sendData();
        keyword.untilJqueryIsDone(50L);
        Thread.sleep(3000);
        keyword.assertEquals("SIGNIN_UPDATE_PASSWORD_SUCCESS", "LOGIN_MESSAGE_RESET_PASSWORD_SUCCESS");
    }

    public void sendData() throws Exception {
        keyword.untilJqueryIsDone(50L);
        objCreateAccount.sendEmail();
        objSignIn.openTabBE("https://stage.glamira.com/secured2021/");
        keyword.deleteAllCookies();
        keyword.closeWindowByIndex(1);
        keyword.switchToTab(0);
        keyword.untilJqueryIsDone(50L);
        getCodeSetup("LOGIN_INPUT_ENTER_DATA", "BTN_SUBMIT");
        sendPassWord();
        keyword.verifyElementVisible("SIGNIN_VERIFY_SUCCESS_SIGNIN_FORM");
    }

    public void sendPassWord() throws InterruptedException {
        keyword.verifyElementVisible("INPUT_CODE_NEW_EMAIL");
        String timestamp = new java.text.SimpleDateFormat("yyyyMMdd").format(new Date());
        String pass = "Ngoc*" + timestamp + "@";
        keyword.untilJqueryIsDone(10L);
        PropertiesFile.serPropValue("PASS_NEW_RD", pass);
        Thread.sleep(2000);
        keyword.click("INPUT_CODE_NEW_EMAIL");
        keyword.sendKeys("INPUT_CODE_NEW_EMAIL", "PASS_NEW_RD");
        keyword.untilJqueryIsDone(50L);
        keyword.click("BTN_SUBMIT_PASSWORD");

    }

    public void getCodeSetup(String code, String btnSubmit) throws Exception {
        objSignIn = new SignInPage(this.keyword);
        objSignIn.openTabBE("https://stage.glamira.com/secured2021/");
        keyword.deleteAllCookies();
        keyword.reLoadPage();
        objSignIn.loginAdmin(
                "nguyenngoc",
                "Admin123");
        keyword.maximizeWindow();
        keyword.untilJqueryIsDone(30L);
        if (check()) {
            keyword.click("BTN_CLOSE_MESSAGE");
        }
        objSignIn.chooseItemCustomer(
                "LOGIN_BTN_CUSTOMER",
                "LOGIN_BTN_CUSTOMER",
                "SIGNUP_VERIFY_CUSTOMER",
                "LOGIN_BTN_EMAIL_LOG",
                "SIGNUP_VERIFY_EMAIL_LOG"
        );
        keyword.untilJqueryIsDone(50L);
        objSignIn.selectActionEmailLog("LOGIN_CHECK_EMAIL_LOG_ACTION_SELECT",
                "LOGIN_SELECT_ACTIVE",
                "LOGIN_SELECT_VIEW_CHECK_EMAIL_LOG",
                "LOGIN_POPUP_MESSAGE_PASSWORD_RESET");
        objSignIn.getCodeEnterTextInField("IFRAME_DEV3",
                "LOGIN_INPUT_VERIFY_CODE",
                code, btnSubmit);
        keyword.resizeBrowser(319, 848);
    }


    boolean check() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        return keyword.verifyElementVisible("BTN_CLOSE_MESSAGE");
    }

}

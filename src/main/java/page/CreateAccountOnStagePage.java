package page;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import io.cucumber.java.sl.In;
import net.bytebuddy.asm.Advice;
import org.slf4j.Logger;
import page.CreateAccountOnStagePage;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;
import page.signinSignup.SignUpPage;

import java.security.PublicKey;
import java.util.Date;

public class CreateAccountOnStagePage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private SignUpPage objSignUp;
    private RegisterPage objRegist;
    private SignInPage objSignIn;
    private CreateAccountMobilePage objCreateAccMobile;

    public CreateAccountOnStagePage(KeywordWeb key) {
        super(key);
        objRegist = new RegisterPage(this.keyword);
        objSignIn = new SignInPage(this.keyword);
        objSignUp = new SignUpPage(this.keyword);
    }

    public void CreateNewCustomerSuccessfully() throws Exception {
        keyword.untilJqueryIsDone(50L);
        Thread.sleep(1000);
        keyword.click("LOGIN_BTN_LOGIN");
        keyword.webDriverWaitForElementPresent("LOGIN_BTN_FORGOT_PASSWORD", 50);
        Thread.sleep(2000);
      aa();
    }
public void aa() throws Exception {
    keyword.scrollDownToElement("SIGNUP_BTN_CREATE_MY_ACCOUNT");
    keyword.untilJqueryIsDone(50L);
    keyword.click("SIGNUP_BTN_CREATE_MY_ACCOUNT");
    keyword.webDriverWaitForElementPresent("SIGNUP_FORM_DATA_INFORMATION", 500);
    sendKeyFormDataLogin();
    sendKeyFormPassword();
    getCodeSetup("SIGNUP_INPUT_VERIFY_CODE", "SIGNUP_BTN_SUBMIT_ACCOUNT");
    keyword.untilJqueryIsDone(50L);
    keyword.verifyElementVisible("SIGNUP_MESSAGE_REGIST_SUCCESS_US");
    keyword.assertEquals("SIGNUP_MESSAGE_SIGNUP_SUCCESS_AU", "SIGNUP_MESSAGE_REGIST_SUCCESS_US");
}
    public void forgotPasswordCheckOut() throws Exception {
        setupForgot("https://stage.glamira.co.uk/glamira-pendant-elsie.html?alloy=red_white-585&stone1=diamond-Brillant");
        sendData();
        keyword.verifyElementVisible("SIGNIN_VERIFY_SUCCESS_SIGNIN_FORM");
    }

    public void setupForgot(String url) throws InterruptedException {
        keyword.navigateToUrl(url);
        keyword.untilJqueryIsDone(50L);
        keyword.scrollDownToElement("CHECKOUT_ADDPRODUCT_BTN_ADD");
        keyword.click("CHECKOUT_ADDPRODUCT_BTN_ADD");
        keyword.untilJqueryIsDone(50L);
        keyword.verifyElementVisible("BTN_VIEW_CART");
        keyword.click("BTN_VIEW_CART");
        keyword.untilJqueryIsDone(50L);
        keyword.untilJqueryIsDone(50L);
        Thread.sleep(2000);
        keyword.click("LA_BTN_PROCEED_TO_CHECKOUT");
        keyword.verifyElementVisible("FORM_CHECKOUT_VRF");
        keyword.untilJqueryIsDone(70L);
        keyword.click("CHECKOUT_LA_HPL_FORGOT_PASS");
    }

    public void forgotPassWord() throws Exception {
        setUpFormForgot();
        sendData();
        keyword.untilJqueryIsDone(50L);
        Thread.sleep(3000);
        keyword.assertEquals("SIGNIN_UPDATE_PASSWORD_SUCCESS", "LOGIN_MESSAGE_RESET_PASSWORD_SUCCESS");
    }

    public void setUpFormForgot() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.reLoadPage();
        keyword.deleteAllCookies();
        keyword.deleteAllCookies();
        keyword.reLoadPage();
        keyword.untilJqueryIsDone(50L);
        objRegist.acceptAllCookies();
        keyword.untilJqueryIsDone(50L);
        keyword.untilJqueryIsDone(50L);
        keyword.click("BTN_FORGOT_PASSWORD_NEW");
        keyword.untilJqueryIsDone(50L);
    }

    public void sendData() throws Exception {
        keyword.untilJqueryIsDone(50L);
        sendEmail();
        objSignIn.openTabBE("https://stage.glamira.com/secured2021/");
        keyword.deleteAllCookies();
        keyword.reLoadPage();
        keyword.deleteAllCookies();
        keyword.closeWindowByIndex(1);
        keyword.switchToTab(0);
        getCodeSetup("LOGIN_INPUT_ENTER_DATA", "BTN_SUBMIT");
        sendPassWord();
    }

    public void sendPassWord() throws InterruptedException {
        keyword.verifyElementVisible("INPUT_CODE_NEW_EMAIL");
        String timestamp = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String pass = "Ngoc*" + timestamp + "@";
        keyword.untilJqueryIsDone(10L);
        PropertiesFile.serPropValue("PASS_NEW_RD", pass);
        Thread.sleep(2000);
        keyword.click("INPUT_CODE_NEW_EMAIL");
        keyword.sendKeys("INPUT_CODE_NEW_EMAIL", "PASS_NEW_RD");
        keyword.untilJqueryIsDone(50L);
        keyword.click("BTN_SUBMIT_PASSWORD");

    }

    public void sendEmail() throws InterruptedException {
        keyword.verifyElementVisible("LOGIN_INPUT_FORGOT_PASSWORD");
        keyword.sendKeys("LOGIN_INPUT_FORGOT_PASSWORD", "SIGNUP_EMAIL_EXIST1");
        keyword.untilJqueryIsDone(50L);
        keyword.click("LOGIN_BTN_SUBMIT_FORGOT_PASSWORD");
        keyword.verifyElementVisible("SIGNIN_XPATH_ACTUAL_SENT_CODE");
    }

    public void getCodeSetup(String code, String btnSubmit) throws Exception {
        objSignIn = new SignInPage(this.keyword);
        objSignIn.openTabBE("https://stage.glamira.com/secured2021/");
        objSignIn.loginAdmin(
                "nguyenngoc",
                "Admin123");
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
    }

    public void sendKeyFormPassword() throws InterruptedException {
        objSignUp.sendKeyFullDataFormPasswordInformation("SIGNUP_PASSWORD_INFORMATION",
                "SIGNUP_DATA_EMAIL_NEW_INFORMATION", "SIGNUP_SELECT_TITLE",
                "SIGNUP_SELECT_OPTION_TITLE");
        keyword.click("SIGNUP_BTN_CREATE_ACCOUNT");
    }

    public void sendKeyFormDataLogin() throws InterruptedException {
        objSignUp = new SignUpPage(this.keyword);
        String timestamp = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String emailCreateAcc = "NgocNT" + timestamp + "@gmail.com";
        PropertiesFile.serPropValue("SIGNUP_EMAIL_EXIST1", emailCreateAcc);
        objSignUp.sendKeyFullDataFormInformation("SIGNUP_DATA_FIRST_NAME_INFORMATION", "SIGNUP_DATA_LAST_NAME_INFORMATION"
                , "SIGNUP_EMAIL_EXIST1", "SIGNUP_EMAIL_EXIST1");
        keyword.click("SIGNUP_XPATH_FOR_FORM");
        keyword.click("SIGNUP_BTN_NEXT_STEEP");
        keyword.untilJqueryIsDone(50L);
    }

    boolean check(String element) throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        return keyword.verifyElementVisible(element);
    }
}

package page;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import org.slf4j.Logger;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;
import page.signinSignup.SignUpPage;

import java.util.Date;

public class CreateAccountOnWebPageLy extends BasePage {
    private static Logger logger = LogHelper.getLogger();

    public CreateAccountOnWebPageLy(KeywordWeb key){
        super(key);
    }
    private SignUpPage objSignUp;
    private RegisterPage objRegist;
    private SignInPage objSignIn;
    private LoginPage objLogin;

    public void goToFormCreateAccount() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        Thread.sleep(1000);
        keyword.click("LOGIN_BTN_LOGIN");
        keyword.untilJqueryIsDone(50L);
        keyword.webDriverWaitForElementPresent("SIGNUP_BTN_CREATE_MY_ACCOUNT", 50);
        keyword.click("SIGNUP_BTN_CREATE_MY_ACCOUNT");
        keyword.webDriverWaitForElementPresent("SIGNUP_TXT_LOGIN_INFOMATION", 50);
    }
    public void CreateNewCustomerSuccessfully() throws Exception {
        goToFormCreateAccount();
        inputDataLogin();
        getCodeVerifyAccount();
    }
    public void inputDataLogin() throws Exception {
        String timestamp = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String emailCreateAcc = "lyttk" + timestamp + "@gmail.com";
        PropertiesFile.serPropValue("SIGNUP_EMAIL_EXIST2", emailCreateAcc);
        inputEmail("SIGNUP_DATA_FIRST_NAME_INFORMATION2", "SIGNUP_DATA_LAST_NAME_INFORMATION2"
                , "SIGNUP_EMAIL_EXIST2", "SIGNUP_EMAIL_EXIST2");
        keyword.click("SIGNUP_XPATH_FOR_FORM");
        keyword.click("SIGNUP_BTN_NEXT_STEEP");
        keyword.untilJqueryIsDone(50L);
        String passwordCreateAcc = "Ly@" + timestamp ;
        PropertiesFile.serPropValue("SIGNUP_PASSWORD_EXIST2", passwordCreateAcc);
        inputPassword("SIGNUP_PASSWORD_EXIST2", "SIGNUP_SELECT_COUNTRY","SIGNUP_NAME_COUNTRY");
        keyword.click("SIGNUP_BTN_CREATE_ACCOUNT");
       // getCodeVerifyForm("LOGIN_DATA_USER_NAME_LY", "LOGIN_DATA_PASSWORD_LY", "URL_BE_STAGE");
    }
    public void inputEmail(String firstName, String lastName, String email, String emailConfirm) throws InterruptedException {
        keyword.sendKeys("SIGNUP_FIRST_NAME_INFORMATION", firstName);
        keyword.sendKeys("SIGNUP_LAST_NAME_INFORMATION", lastName);
        keyword.sendKeys("SIGNUP_EMAIL_INFORMATION", email);
        keyword.sendKeys("SIGNUP_EMAIL_CONFIRMATION_INFORMATION", emailConfirm);
    }
    public void inputPassword( String password, String selectCountry,String nameCountry) throws InterruptedException {
        keyword.sendKeys("SIGNUP_PASSWORD_INFORMATION", password);
        keyword.untilJqueryIsDone(30L);
        if ( keyword.verifyElementVisible(selectCountry)) {
            keyword.selectDropDownListByName(selectCountry,nameCountry);
            //keyword.click(selectOneOptionTitle);
            keyword.click("SIGNUP_XPATH_FOR_FORM");
            keyword.click("SIGNUP_CHECKBOX_AGREE");
        } else {
            keyword.click("SIGNUP_XPATH_FOR_FORM");
            keyword.click("SIGNUP_CHECKBOX_AGREE");
        }
    }
    public void getCodeVerifyAccount() throws Exception {
        objSignIn = new SignInPage(this.keyword);
        keyword.untilJqueryIsDone(50L);
        objSignIn.openTabBE("URL_BE_STAGE");
        objSignIn.loginAdmin("LOGIN_DATA_USER_NAME_LY", "LOGIN_DATA_PASSWORD_LY");
        keyword.untilJqueryIsDone(50L);
        keyword.webDriverWaitForElementPresent("LOGIN_BTN_CUSTOMER", 20);
        keyword.click("LOGIN_BTN_CUSTOMER");
        keyword.untilJqueryIsDone(50L);
        keyword.untilJqueryIsDone(50L);
        keyword.click("LOGIN_BTN_EMAIL_LOG");
        keyword.webDriverWaitForElementPresent("SIGNUP_VERIFY_EMAIL_LOG", 20);
        keyword.untilJqueryIsDone(50L);
        keyword.click("LOGIN_CHECK_EMAIL_LOG_ACTION_SELECT");
        keyword.untilJqueryIsDone(50L);
        keyword.click("LOGIN_SELECT_VIEW_CHECK_EMAIL_LOG");
        objSignIn.getCodeEnterTextInField("IFRAME_STAGE",
                "LOGIN_INPUT_VERIFY_CODE",
                "SIGNUP_INPUT_VERIFY_CODE","SIGNUP_BTN_SUBMIT_ACCOUNT");
        keyword.untilJqueryIsDone(50L);
        keyword.verifyElementVisible("SIGNUP_MESSAGE_REGIST_SUCCESS_US");
        keyword.assertEquals("SIGNUP_MESSAGE_SIGNUP_SUCCESS_AU", "SIGNUP_MESSAGE_REGIST_SUCCESS_US");
    }

    public void sendKeyFormPassword() throws InterruptedException {
        objSignUp.sendKeyFullDataFormPasswordInformation("SIGNUP_PASSWORD_INFORMATION",
                "SIGNUP_DATA_PASSWORD_INFORMATION", "SIGNUP_SELECT_TITLE",
                "SIGNUP_SELECT_OPTION_TITLE");
        keyword.click("SIGNUP_BTN_CREATE_ACCOUNT");
    }
    public void sendKeyFormDataLogin() throws InterruptedException {
        objSignUp = new SignUpPage(this.keyword);
        String timestamp = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String emailCreateAcc = "lyttk" + timestamp + "@gmail.com";
        PropertiesFile.serPropValue("SIGNUP_EMAIL_EXIST2", emailCreateAcc);
        objSignUp.sendKeyFullDataFormInformation("SIGNUP_DATA_FIRST_NAME_INFORMATION2", "SIGNUP_DATA_LAST_NAME_INFORMATION2"
                , "SIGNUP_EMAIL_EXIST2", "SIGNUP_EMAIL_EXIST2");
        keyword.click("SIGNUP_XPATH_FOR_FORM");
        keyword.click("SIGNUP_BTN_NEXT_STEEP");
        keyword.untilJqueryIsDone(50L);
        String passwordCreateAcc = "Ly@" + timestamp ;
        PropertiesFile.serPropValue("SIGNUP_PASSWORD_EXIST2", passwordCreateAcc);
        objSignUp.sendKeyFullDataFormPasswordInformation("SIGNUP_PASSWORD_INFORMATION",
                "SIGNUP_PASSWORD_EXIST2", "SIGNUP_SELECT_TITLE",
                "SIGNUP_SELECT_OPTION_TITLE");
        keyword.click("SIGNUP_BTN_CREATE_ACCOUNT");
    }


    public void getCodeSetup(String code, String btnSubmit, String userName, String pass, String url) throws Exception {
        objSignIn = new SignInPage(this.keyword);
        objSignIn.openTabBE(url);
        objSignIn.loginAdmin(userName,pass);
        keyword.untilJqueryIsDone(50L);
        keyword.click("LOGIN_BTN_CUSTOMER");
        keyword.webDriverWaitForElementPresent("LOGIN_BTN_CUSTOMER", 20);
        keyword.untilJqueryIsDone(50L);
        keyword.untilJqueryIsDone(50L);
        keyword.click("LOGIN_BTN_EMAIL_LOG");
        keyword.webDriverWaitForElementPresent("SIGNUP_VERIFY_EMAIL_LOG", 20);
        keyword.untilJqueryIsDone(50L);
        objSignIn.selectActionEmailLog("LOGIN_CHECK_EMAIL_LOG_ACTION_SELECT", "LOGIN_SELECT_ACTIVE",
                "LOGIN_SELECT_VIEW_CHECK_EMAIL_LOG", "LOGIN_POPUP_MESSAGE_PASSWORD_RESET");
        objSignIn.getCodeEnterTextInField("IFRAME_STAGE", "LOGIN_INPUT_VERIFY_CODE", code, btnSubmit);
    }

    public void getCodeVerifyForm(String userName, String pass, String url) throws Exception {
        objSignIn = new SignInPage(this.keyword);
        objSignIn.openTabBE(url);
        objSignIn.loginAdmin(userName,pass);
        keyword.untilJqueryIsDone(50L);
        keyword.click("LOGIN_BTN_CUSTOMER");
        keyword.webDriverWaitForElementPresent("LOGIN_BTN_CUSTOMER", 20);
        keyword.untilJqueryIsDone(50L);
        keyword.untilJqueryIsDone(50L);
        keyword.click("LOGIN_BTN_EMAIL_LOG");
        keyword.webDriverWaitForElementPresent("SIGNUP_VERIFY_EMAIL_LOG", 20);
        keyword.untilJqueryIsDone(50L);
        objSignIn.selectActionEmailLog("LOGIN_CHECK_EMAIL_LOG_ACTION_SELECT",
                "LOGIN_SELECT_ACTIVE",
                "LOGIN_SELECT_VIEW_CHECK_EMAIL_LOG",
                "LOGIN_POPUP_MESSAGE_PASSWORD_RESET");
        objSignIn.getCodeEnterTextInField("IFRAME_STAGE",
                "LOGIN_INPUT_VERIFY_CODE",
                "SIGNUP_INPUT_VERIFY_CODE","SIGNUP_BTN_SUBMIT_ACCOUNT");
        keyword.untilJqueryIsDone(50L);
        keyword.verifyElementVisible("SIGNUP_MESSAGE_REGIST_SUCCESS_US");
        keyword.assertEquals("SIGNUP_MESSAGE_SIGNUP_SUCCESS_AU", "SIGNUP_MESSAGE_REGIST_SUCCESS_US");
    }

    public void forgotPasswordCheckOut(String dataURL, String url) throws Exception {
        setupForgot(dataURL);
        sendData(url);
        keyword.verifyElementVisible("SIGNIN_VERIFY_SUCCESS_SIGNIN_FORM");
    }

    public void setupForgot(String url) throws InterruptedException {
        keyword.navigateToUrl(url);
//        objRegist.acceptAllCookies();
        keyword.untilJqueryIsDone(50L);
        keyword.scrollDownToElement("CHECKOUT_ADDPRODUCT_BTN_ADD");
        keyword.click("CHECKOUT_ADDPRODUCT_BTN_ADD");
        keyword.untilJqueryIsDone(10L);
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

    public void forgotPassword(String url) throws Exception {
        keyword.untilJqueryIsDone(50L);
        keyword.reLoadPage();
        //keyword.navigateToUrl(url);
        setUpFormForgot();
        sendData(url);
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

    public void sendData(String url) throws Exception {
        keyword.untilJqueryIsDone(50L);
        sendEmail();
        objSignIn.openTabBE(url);
        keyword.deleteAllCookies();
        keyword.reLoadPage();
        keyword.deleteAllCookies();
        keyword.closeWindowByIndex(1);
        keyword.switchToTab(0);
        getCodeSetup("LOGIN_INPUT_ENTER_DATA", "BTN_SUBMIT", "LOGIN_DATA_USER_NAME", "LOGIN_DATA_PASS_WORD_DUNG", "URL_BE_STAGE");
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





    //    ------whthPhone
    public void createNewCustomerWithPhone() throws Exception {
//        keyword.navigateToUrl("https://dev3.glamira.com/glgb/");
        goToFormCreateAccount();
        sendKeyFormDataLogin();
        objSignUp = new SignUpPage(this.keyword);
        String timestamp = new java.text.SimpleDateFormat("HHmmss").format(new Date());
        String pass = "03" + timestamp + "77";
        PropertiesFile.serPropValue("DATA_CREATE_ACCOUNT_WITH_PHONE", pass);
        keyword.sendKeys("SIGNUP_WITH_PHONE", "DATA_CREATE_ACCOUNT_WITH_PHONE");
        keyword.click("SIGNUP_XPATH_FOR_FORM");
        keyword.click("SIGNUP_BTN_NEXT_STEEP");
        keyword.untilJqueryIsDone(50L);
        sendKeyFormPassword();
        getCodeVerifyForm("LOGIN_DATA_USER_NAME", "BE_ADMIN_PASSWORD", "URL_BE_DEV");
    }

    public void loginSuccess() throws InterruptedException {
        keyword.reLoadPage();
        objRegist.acceptAllCookies();
        objLogin.loginOnWebsite("SIGNUP_EMAIL_EXIST1", "SIGNUP_DATA_PASSWORD_INFORMATION",
                "DATA_CREATE_ACCOUNT_WITH_PHONE", "PASS_NEW_RD", false);
        keyword.untilJqueryIsDone(50L);
        keyword.verifyElementVisible("MAC_VERIFY_NAME");
    }

    public void forgotPasswordPhone() throws InterruptedException {
        setUpFormForgot();
//        keyword.click("MOBILE_NUMBER");
        keyword.sendKeys("SIGNIN_INPUT_PHONE_ENTER", "DATA_CREATE_ACCOUNT_WITH_PHONE");
        keyword.click("LOGIN_BTN_SUBMIT_FORGOT_PASSWORD");
        keyword.untilJqueryIsDone(50L);
        objSignUp.getActivationCode("INPUT_SEND_CODE_PHONE", "DATA_FORM_PASSWORD_NEW", "ACTUAL_DATA_TITLE_PASSWORD_NEW");
        keyword.untilJqueryIsDone(50L);
        sendPassWord();
    }

}

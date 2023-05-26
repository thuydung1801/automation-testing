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
        //keyword.reLoadPage();
        keyword.untilJqueryIsDone(50L);
        Thread.sleep(1000);
        keyword.click("LOGIN_BTN_LOGIN");
        keyword.untilJqueryIsDone(50L);
        keyword.webDriverWaitForElementPresent("SIGNUP_BTN_CREATE_MY_ACCOUNT", 50);
        keyword.click("SIGNUP_BTN_CREATE_MY_ACCOUNT");
        keyword.webDriverWaitForElementPresent("SIGNUP_TXT_LOGIN_INFOMATION", 50);
    }

    public void inputDataLogin(String fisrtName, String lastname,String email, String password,String nameCountry) throws Exception {
        String timestamp = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String emailCreateAcc = "lyttk" + timestamp + "@gmail.com";
        PropertiesFile.serPropValue("SIGNUP_EMAIL_EXIST2", emailCreateAcc);
        inputEmail(fisrtName, lastname,email,email);
        keyword.click("SIGNUP_XPATH_FOR_FORM");
        keyword.click("SIGNUP_BTN_NEXT_STEEP");
        keyword.untilJqueryIsDone(50L);
        String passwordCreateAcc = "Ly@" + timestamp ;
        PropertiesFile.serPropValue(password, passwordCreateAcc);
        inputPassword(password, "SIGNUP_SELECT_COUNTRY",nameCountry);
        keyword.click("SIGNUP_BTN_CREATE_ACCOUNT");
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
            keyword.click("SIGNUP_CHECKBOX_AGREE");
        } else {
            keyword.click("SIGNUP_CHECKBOX_AGREE");
        }
    }
    public void getCode(String url,String userName,String passWord) throws Exception{
        objSignIn = new SignInPage(this.keyword);
        keyword.untilJqueryIsDone(50L);
        objSignIn.openTabBE(url);
        objSignIn.loginAdmin(userName,passWord );
        keyword.untilJqueryIsDone(50L);
        keyword.webDriverWaitForElementPresent("LOGIN_BTN_CUSTOMER", 20);
        keyword.click("LOGIN_BTN_CUSTOMER");
        keyword.untilJqueryIsDone(50L);
        keyword.untilJqueryIsDone(50L);
        keyword.click("LOGIN_BTN_EMAIL_LOG");
        keyword.webDriverWaitForElementPresent("SIGNUP_VERIFY_EMAIL_LOG", 20);
        keyword.untilJqueryIsDone(50L);
        keyword.webDriverWaitForElementPresent("LOGIN_CHECK_EMAIL_LOG_ACTION_SELECT", 20);
        keyword.click("LOGIN_CHECK_EMAIL_LOG_ACTION_SELECT");
        keyword.untilJqueryIsDone(50L);
        keyword.click("LOGIN_SELECT_VIEW_CHECK_EMAIL_LOG");
    }
    public void getCodeVerifyAccountNew(String url,String userName,String passWord) throws Exception {
        getCode(url,userName, passWord);
        getCodeEnterTextInField("IFRAME_STAGE",
                "LOGIN_INPUT_VERIFY_CODE",
                "SIGNUP_INPUT_VERIFY_CODE","SIGNUP_BTN_SUBMIT_ACCOUNT");
        keyword.untilJqueryIsDone(50L);
        keyword.webDriverWaitForElementPresent("SIGNUP_MESSAGE_REGIST_SUCCESS_US",20);
        keyword.assertEquals("SIGNUP_MESSAGE_SIGNUP_SUCCESS_AU", "SIGNUP_MESSAGE_REGIST_SUCCESS_US");
    }
    public void getCodeVerifyAccount(String url,String userName,String passWord) throws Exception {
        getCode(url,userName, passWord);
        getCodeEnterTextInField("IFRAME_STAGE",
                "LOGIN_INPUT_VERIFY_CODE",
                "SIGNUP_INPUT_VERIFY_CODE_FORGOT_PASSWORD","SIGNUP_BTN_SUBMIT_FORGOT_PASSWORD");
        keyword.untilJqueryIsDone(50L);
    }
    public void inputPasswordNew(String password) throws Exception {
        String timestamp = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String passwordNew = "Ly@" + timestamp ;
        PropertiesFile.serPropValue(password, passwordNew);
        keyword.sendKeys("INPUT_CODE_NEW_EMAIL",password);
        keyword.untilJqueryIsDone(50L);
        keyword.click("BTN_SUBMIT_PASSWORD");
        keyword.untilJqueryIsDone(50L);
        Thread.sleep(3000);
        keyword.assertEquals("SIGNIN_UPDATE_PASSWORD_SUCCESS", "LOGIN_MESSAGE_RESET_PASSWORD_SUCCESS");

    }

    public void getCodeEnterTextInField(String iframe, String getCode, String inputCode, String btnSubmit) throws Exception {
        keyword.untilJqueryIsDone(50L);
        keyword.switchToIFrameByXpath(iframe);
        String code = keyword.getText(getCode);
        keyword.closeWindowByIndex(1);
        keyword.switchToTab(0);
        keyword.untilJqueryIsDone(50L);
        keyword.sendKeys(inputCode,code);
        System.out.println("value code:");
        keyword.untilJqueryIsDone(50L);
        keyword.click(btnSubmit);
    }
    public void goToFormForgotPassword() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        Thread.sleep(1000);
        keyword.click("LOGIN_BTN_LOGIN");
        keyword.untilJqueryIsDone(50L);
        keyword.webDriverWaitForElementPresent("SIGNIN_BTN_FORGOT_PASSWORD", 50);
        keyword.click("SIGNIN_BTN_FORGOT_PASSWORD");
        keyword.untilJqueryIsDone(50L);
        keyword.webDriverWaitForElementPresent("LOGIN_INPUT_FORGOT_PASSWORD", 50);
    }

    public void inputEmailForgotPassword(String email) throws InterruptedException {
        keyword.sendKeys("LOGIN_INPUT_FORGOT_PASSWORD",email);
        keyword.untilJqueryIsDone(50L);
        keyword.click("LOGIN_BTN_SUBMIT_FORGOT_PASSWORD");
        keyword.webDriverWaitForElementPresent("SIGNIN_TXT_VERIFY_SENT_CODE",60);
    }
    public void changePassword(String passWordOld, String passWordNew) throws InterruptedException {
        String timestamp = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String pass = "Ly@"+timestamp;
        keyword.webDriverWaitForElementPresent("MAC_BTN_SAVE_3",60);
        keyword.sendKeys("MAC_INP_PASS_CURENT_2",passWordOld);
        PropertiesFile.serPropValue(passWordNew,pass);
        keyword.sendKeys("MAC_INP_PASS_NEW",passWordNew);
        keyword.sendKeys("MAC_INP_PASS_CONFIRM",passWordNew);
        keyword.click("MAC_BTN_SAVE_3");
        //keyword.untilJqueryIsDone(60L);
        keyword.verifyElementVisible("SI_TXT_SAVED_SUCCESSFUL");
    }
    public void goToFormChangePassword() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        Thread.sleep(1000);
        keyword.click("SI_BTN_CHANGE_PASSWORD");
        keyword.webDriverWaitForElementPresent("SI_BTN_CHANGE_PASSWORD2",60);
        keyword.click("SI_BTN_CHANGE_PASSWORD2");

    }


}

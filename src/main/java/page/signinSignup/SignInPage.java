package page.signinSignup;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import org.slf4j.Logger;
import page.home.LoginPage;
import page.home.RegisterPage;

import java.util.Date;

public class SignInPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private SignUpPage objSignUp;
    private LoginPage objLogin;
    private RegisterPage objRegist;
    private SignInPage objSigin;
    public SignInPage(KeywordWeb key) {
        super(key);
    }
    public SignInPage() {
        super();
    }
    public void checkGoToFormLoginWithEmail() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.untilJqueryIsDone(50L);
        keyword.click("LOGIN_BTN_LOGIN");
        keyword.untilJqueryIsDone(50L);
        inputBlankAndVerify("SIGNIN_XPATH_EMAIL_REQUIRED_FIELD",
                "SIGNIN_MESSAGE_REQUIRED_FIELD", "SIGNIN_MESSAGE_REQUIRED_FIELD");
    }
    public void setup() throws InterruptedException {
        objRegist = new RegisterPage(this.keyword);
        keyword.untilJqueryIsDone(50L);
        objRegist.chooseLanguages();
    }

    public void checkGoToFormLoginWithPhone() throws InterruptedException {
        objRegist = new RegisterPage(this.keyword);
        keyword.deleteAllCookies();
        keyword.navigateToUrl("https://dev3.glamira.com/glcn/");
        keyword.untilJqueryIsDone(50L);
        Thread.sleep(3000);
        keyword.click("SIGNIN_BTN_ACC");
        keyword.untilJqueryIsDone(50L);
        objRegist.chooseLanguages();
//        keyword.untilJqueryIsDone(50L);
        Thread.sleep(2000);
        keyword.click("SIGNIN_TAB_LOGIN_IN_WITH_PHONE");
        keyword.untilJqueryIsDone(10L);
        inputBlankAndVerify("SIGNIN_MESSAGE_FAIL_WITH_MOBILE", "必填项。", "必填项。");
    }

    // Login with email and leave the password field blank
    public void enterEmailLeavePasswordFiendBlank() throws InterruptedException {
        keyword.sendKeys("SIGNIN_EMAIL_LOG", "SIGNIN_DATA_EMAIL");
        keyword.click("LOGIN_BTN_SUBMITLOGIN");
        keyword.assertEquals("SIGNIN_MESSAGE_REQUIRED_FIELD", "SIGNIN_XPATH_PASSWORD_REQUIRED_FIELD");
    }

    // Login with password and leave the email field blank
    public void enterPasswordLeaveEmailFiendBlank() throws InterruptedException {
        clearTextSendKeyAndVerify("SIGNIN_EMAIL_LOG", "SIGNIN_PASSWORD_INPUT",
                "SIGNIN_DATA_PASSWORD01", "LOGIN_BTN_SUBMITLOGIN",
                "SIGNIN_MESSAGE_REQUIRED_FIELD", "SIGNIN_XPATH_EMAIL_REQUIRED_FIELD");
    }

    //    SignIn wrong email - password
    public void wrongPasswordAndEmail() throws InterruptedException {
        objSignUp = new SignUpPage(this.keyword);
        keyword.untilJqueryIsDone(10L);
        objSignUp.clearTextAndSendKey("SIGNIN_EMAIL_LOG", "SIGNIN_EMAIL_LOG", "SIGNUP_DATA_EMAIL_INFORMATION");
        objSignUp.clearTextAndSendKey("SIGNIN_PASSWORD_INPUT", "SIGNIN_PASSWORD_INPUT", "SIGNIN_DATA_PASSWORD01");
        keyword.click("SIGNIN_FORM_LOGIN");
        keyword.click("SIGNIN_BTN_SUBMIT");
        keyword.untilJqueryIsDone(70L);
        keyword.assertEquals("SIGNIN_MESSAGE_PASSWORD_ACTUAL", "SIGNIN_MESSAGE_INVALID");
    }

    //   Login with wrong password
    public void sigInWithWrongPassword() throws InterruptedException {
        objSignUp.clearTextAndSendKey("SIGNIN_EMAIL_LOG", "SIGNIN_EMAIL_LOG", "SIGNUP_DATA_EMAIL_INVALID");
        keyword.click("SIGNIN_BTN_SUBMIT");
        keyword.untilJqueryIsDone(50L);
        keyword.assertEquals("SIGNIN_MESSAGE_PASSWORD_ACTUAL", "SIGNIN_MESSAGE_INVALID");
    }

    //  Enter the wrong email format
    public void enterWrongEmailFormat() throws InterruptedException {
        Thread.sleep(2000);
        objSignUp.clearTextAndSendKey("SIGNIN_EMAIL_LOG", "SIGNIN_EMAIL_LOG", "SIGNIN_DATA_EMAIL_WRONG_FORMAT");
        keyword.click("LOGIN_BTN_SUBMITLOGIN");
        keyword.assertEquals("SIGNIN_MESSAGE_EMAIL_WRONG_FORMAT", "SIGNIN_XPATH_EMAIL_REQUIRED_FIELD");
    }

    //  Entered the wrong code sent to the email
    public void enterWrongCodeSentToEmail() throws InterruptedException {
        keyword.click("LOGIN_BTN_FORGOT_PASSWORD");
        keyword.untilJqueryIsDone(20L);
        keyword.assertEquals("SIGNIN_MESSAGE_FORM_FORGOT", "SIGNIN_XPATH_INPUTFORM_EMAIL_FORGOT");
        keyword.sendKeys("SIGININ_INPUT_EMAIL_FORGOT", "SIGNIN_DATA_EMAIL");
        keyword.click("LOGIN_BTN_SUBMIT_FORGOT_PASSWORD");
        keyword.untilJqueryIsDone(20L);
        keyword.assertEquals("SIGNIN_MESSAGE_SENT_CODE", "SIGNIN_XPATH_ACTUAL_SENT_CODE");
        keyword.sendKeys("SIGNIN_INPUT_ENTER_CODE", "SIGNIN_DATA_CODE_SEND_KEY");
        keyword.click("SIGNIN_BTN_SUBMIT_SEND_CODE");
        keyword.untilJqueryIsDone(20L);
        keyword.assertEquals("SIGNIN_MESSAGE_UNABLE_CODE", "SIGNIN_XPATH_UNABLE_CODE");
    }

    //Resend the code to email
    public void resentTheCodeToEmail() throws Exception {
        keyword.clearText("SIGNIN_INPUT_ENTER_CODE");
        openNewTabs();
        loginAdmin("LOGIN_DATA_USER_NAME", "LOGIN_DATA_PASS_WORD");
        chooseItemCustomer("LOGIN_BTN_CUSTOMER", "LOGIN_BTN_CUSTOMER", "SIGNUP_VERIFY_CUSTOMER",
                "LOGIN_BTN_EMAIL_LOG", "SIGNUP_VERIFY_EMAIL_LOG"
        );
        selectActionEmailLog("LOGIN_CHECK_EMAIL_LOG_ACTION_SELECT", "LOGIN_SELECT_ACTIVE",
                "LOGIN_SELECT_VIEW_CHECK_EMAIL_LOG", "LOGIN_POPUP_MESSAGE_PASSWORD_RESET"
        );
        getCodeEnterTextInField("LOGIN_IFRAME_DEV3", "LOGIN_INPUT_VERIFY_CODE",
                "SIGNIN_INPUT_ENTER_CODE", "SIGNIN_BTN_SUBMIT_SEND_CODE");
        keyword.sendKeys("SIGNIN_INPUT_CREATE_NEW_PASSWORD", "SIGNIN_DATA_SEND_KEY");
        keyword.untilJqueryIsDone(70L);
        objSignUp.confirmPasswordEntryCondition("SIGNUP_MESSAGE_PASSWORD_FAIL01",
                "SIGNIN_MESSAGE_CREATE_NEW_PW", "SIGNUP_ACTUAL_MESSAGE04", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_NUMBER",
                "SIGNUP_ACTUAL_MESSAGE_AT_LAST_LOWER", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_UPPER", "SIGNUP_MESSAGE_ERROR_CHARACTERS_LIKE",
                "SIGNUP_ACTUAL_MESSAGE04"
        );
    }

    //create valid new password
    public void createNewPassword() throws InterruptedException {
        String timestamp = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String passWord = "Ngoc*" + timestamp + "@";
        PropertiesFile.serPropValue("SIGNIN_DATA_PASSWORD_NEW", passWord);
        objSignUp.clearTextAndSendKey("SIGNIN_INPUT_CREATE_NEW_PASSWORD", "SIGNIN_INPUT_CREATE_NEW_PASSWORD", "SIGNIN_DATA_PASSWORD_NEW");
        keyword.click("SIGNI_BTN_SUBMIT_RESET_PASSWORD");
        keyword.untilJqueryIsDone(30L);
        keyword.verifyElementVisible("SIGNIN_VERIFY_SUCCESS_SIGNIN_FORM");
        keyword.untilJqueryIsDone(10L);
        keyword.assertEquals("SIGNIN_UPDATE_PASSWORD_SUCCESS", "LOGIN_MESSAGE_RESET_PASSWORD_SUCCESS");
    }

    //Login successfully on Login modal
    public void loginSuccessfully() throws InterruptedException {
        keyword.untilJqueryIsDone(10L);
        keyword.sendKeys("SIGNIN_EMAIL_LOG", "SIGNIN_DATA_EMAIL");
        keyword.sendKeys("SIGNIN_PASSWORD_INPUT", "SIGNIN_DATA_PASSWORD_NEW");
        keyword.click("LOGIN_BTN_SUBMITLOGIN");
        keyword.verifyElementVisible("LOGIN_MESSAGE_SUCCESS");
    }

    //    create valid new password
    public void resetNewPassword() throws InterruptedException {
        objSignUp.clearTextAndSendKey("SIGNIN_INPUT_CREATE_NEW_PASSWORD", "SIGNIN_INPUT_CREATE_NEW_PASSWORD", "SIGNIN_RESET_PASSWORD");
//        keyword.assertEquals("AAAA", "bbbbb");
        keyword.click("SIGNI_BTN_SUBMIT_RESET_PASSWORD");
        keyword.assertEquals("SIGNIN_UPDATE_PASSWORD_SUCCESS", "");
    }


    //Login wrong phone number
    public void enterInvalidPhone() throws InterruptedException {
        clearTextSendKeyAndVerify("SIGNIN_INPUT_PHONE_NUMBER", "SIGNIN_INPUT_PHONE_NUMBER",
                "SIGNIN_PASSWORD_WRONG", "SIGNIN_BTN_SUBMIT_FORM_PHONE",
                "用户名或者密码不正确", "SIGNIN_INPUT_MESSAGE_INVALID");
    }

    //   Login wrong password
    public void enterWrongPassword() throws InterruptedException {
        objSignUp = new SignUpPage(this.keyword);
        objSignUp.clearTextAndSendKey("SIGNIN_INPUT_PHONE_NUMBER", "SIGNIN_INPUT_PHONE_NUMBER", "SIGNUP_DATA_PHONE");
        clearTextSendKeyAndVerify("SIGNIN_PASSWORD_INPUT", "SIGNIN_PASSWORD_INPUT", "SIGNIN_DATA_PASSWORD_WRONG_PHONE",
                "SIGNIN_BTN_SUBMIT_FORM_PHONE", "用户名或者密码不正确", "SIGNIN_INPUT_MESSAGE_INVALID");
    }

    //for got Pass Enter Phone Is Not The System
    public void forgotPassEnterPhoneIsNotTheSystem() throws InterruptedException {
        keyword.click("SIGNIN_XPATH_FORGOT_PASSWORD");
        keyword.untilJqueryIsDone(30L);
        keyword.click("SIGNIN_TAB_PHONE_FORGOT_PASSWORD");
        keyword.untilJqueryIsDone(10L);
        keyword.click("SIGNIN_SELECT_PHONE");
        keyword.untilJqueryIsDone(10L);
        keyword.click("SIGNIN_CHINA_PHONE");
        keyword.untilJqueryIsDone(10L);
        keyword.sendKeys("SIGNIN_INPUT_PHONE_ENTER", "SIGNIN_VALID_PHONE_CHINA");
        keyword.click("LOGIN_BTN_SUBMIT_FORGOT_PASSWORD");
        keyword.untilJqueryIsDone(50L);
        keyword.assertEquals("你的电话号码不正确。请验证手机号码後重试。", "SIGNIN_INPUT_MESSAGE_PHONE_FAIL");
    }

    //   create New Password With Invalid Phone
    public void createNewPasswordWithInvalidPhone() throws InterruptedException {
        objSignUp = new SignUpPage(this.keyword);
        objSignUp.clearTextAndSendKey("SIGNIN_INPUT_PHONE_ENTER", "SIGNIN_INPUT_PHONE_ENTER", "SIGNIN_PHONE_CHINA");
        keyword.click("SIGNIN_CLICK_FORM");
        keyword.untilJqueryIsDone(10L);
        keyword.click("LOGIN_BTN_SUBMIT_FORGOT_PASSWORD");
        keyword.untilJqueryIsDone(10L);
        openNewTabs();
//        loginAdmin(
//                "LOGIN_DATA_USER_NAME",
//                "LOGIN_DATA_PASS_WORD");
        keyword.untilJqueryIsDone(30L);
        chooseItemCustomer(
                "SIGNUP_STORES_ITEM", "SIGNUP_STORES_ITEM",
                "LOGIN_FORM_CUSTOMER", "SIGNUP_ELEMENT_SMS_LOG", "SIGNUP_VERIFY_SMS"
        );
//        objSignUp.filterSort(
//                "SIGNUP_BTN_FILTER", "SIGNUP_VERIFY_ELEMENT_FILTER",
//                "SIGNIN_PHONE_CHINA", "SIGNUP_BUTTON_APPLY_FILTERS"
//        );
//        Thread.sleep(12000);
        keyword.untilJqueryIsDone(50L);
        objSignUp.getCodeAndSendKey("SIGNIN_INPUT_ENTER_CODE", "SIGNIN_BTN_SUBMIT_SEND_CODE"
        );
        keyword.untilJqueryIsDone(50L);
        keyword.sendKeys("SIGNIN_INPUT_CREATE_NEW_PASSWORD", "SIGNIN_DATA_SEND_KEY");
        keyword.untilJqueryIsDone(30L);
        objSignUp.confirmPasswordEntryConditionWithChinese(
                "SIGNIN_MESSAGE_CREATE_NEW_PW", "SIGNUP_ACTUAL_MESSAGE04", "SIGNUP_ACTUAL_MESSAGE_CHINA",
                "SIGNUP_ACTUAL_MESSAGE_CHINA1", "SIGNUP_ACTUAL_MESSAGE_CHINA2", "SIGNUP_ACTUAL_MESSAGE_CHINA3",
                "SIGNUP_ACTUAL_MESSAGE04"
        );
    }

    //    create New Password Success
    public void createNewPasswordSuccess() throws InterruptedException {
        String timestamp = new java.text.SimpleDateFormat("yyyyMMddHHmmss ").format(new Date());
        String pass = "Ngoc*" + timestamp + "@";
        keyword.untilJqueryIsDone(10L);
        PropertiesFile.serPropValue("SIGNUP_CREATE_PASSWORD_PHONE_RD", pass);
        objSignUp.clearTextAndSendKey("SIGNIN_INPUT_CREATE_NEW_PASSWORD", "SIGNIN_INPUT_CREATE_NEW_PASSWORD", "SIGNUP_CREATE_PASSWORD_PHONE_RD");
        keyword.click("SIGNIN_BTN_SUBMIT_RESET_PASSWORD");
        keyword.untilJqueryIsDone(100L);
        Thread.sleep(2000);
        keyword.assertEquals("您更新您的密码。", "SIGN_MESSAGE_SIGNIN_SUCCESS");
    }

    //login With Phone Success
    public void loginWithPhoneSuccess() throws InterruptedException {
        keyword.untilJqueryIsDone(20L);
        keyword.click("SIGN_INPUT_SELECT_PHONE");
        keyword.untilJqueryIsDone(10L);
        keyword.click("SIGNIN_SELECT_PHONE_CHINA");
        keyword.untilJqueryIsDone(10L);
        keyword.click("SIGN_BTN_LOGIN_STORE_CHINA");
        keyword.assertEquals("必填项。", "SIGN_MESSAGE_FAIL");
        keyword.assertEquals("必填项。", "SIGNIN_MESSAGE_PASSWORD_INVALID");
        keyword.untilJqueryIsDone(10L);
        keyword.sendKeys("SIGN_INPUT_PHONE_CHINA", "SIGNIN_PHONE_CHINA");
        keyword.sendKeys("SIGN_INPUT_PASSWORD", "SIGNUP_CREATE_PASSWORD_PHONE_RD");
        keyword.click("SIGN_BTN_LOGIN_STORE_CHINA");
        keyword.untilJqueryIsDone(50L);
        keyword.verifyElementVisible("SIGN_MESSAGE_SUCCESS");
    }
    //Invalid phone number entered
    public void enterInvalidPhoneNumber() throws InterruptedException {
        keyword.sendKeys("SIGNIN_INPUT_PHONE_NUMBER", "SIGNIN_DATA_PHONE_NUMBER");
        keyword.sendKeys("SIGNIN_PASSWORD_INPUT", "SIGNIN_DATA_PASSWORD_PHONE");
        keyword.untilJqueryIsDone(50L);
//        objRegist.chooseLanguages();
        keyword.untilJqueryIsDone(50L);
        keyword.click("SIGNIN_BTN_SUBMIT_FORM_PHONE");
        keyword.assertEquals("请输入有效的手机号码。", "SIGNIN_MESSAGE_FAIL_WITH_MOBILE");
    }
    // open new right tabs
    public void openNewTabs() throws InterruptedException {
        keyword.executeJavaScript("window.open()");
        keyword.switchToTab(1);
        keyword.navigateToUrl("URL_BE_DEV3");
    }
    public void openTabBE(String urlBe) throws InterruptedException {
        keyword.executeJavaScript("window.open()");
        keyword.switchToTab(1);
        keyword.navigateToUrl(urlBe);
    }

    //login admin BackEnd (shared functions)
    public void loginAdmin(String userName, String passWord) throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.sendKeys("LOGIN_FORM_USER_NAME_BACKEND", userName);
        keyword.sendKeys("LOGIN_FORM_PASSWORD_BACKEND", passWord);
        keyword.click("LOGIN_FORM_BTN_SUBMIT_BACKEND");
    }

    //go to section customer after login admin BE.
    public void chooseItemCustomer(String scrollToElement, String clickItem, String verifyItem, String clickItemSub, String verifyItemSub) throws InterruptedException {
        keyword.untilJqueryIsDone(30L);
        keyword.scrollToPosition();
        keyword.scrollDownToElement(scrollToElement);
        keyword.click(clickItem);
        keyword.webDriverWaitForElementPresent(verifyItem, 20);
        keyword.untilJqueryIsDone(30L);
        keyword.click(clickItemSub);
        keyword.webDriverWaitForElementPresent(verifyItemSub, 20);
    }

    // Select Action Email Log
    public void selectActionEmailLog(String selectAction, String verifySelectForm, String selectView, String verifyForm) throws InterruptedException {
        keyword.imWait(50);
        keyword.click(selectAction);
//        keyword.webDriverWaitForElementPresent(verifySelectForm, 30);
        keyword.untilJqueryIsDone(50L);
        keyword.verifyElementVisible(selectView);
        keyword.untilJqueryIsDone(50L);
        keyword.click(selectView);
        keyword.webDriverWaitForElementPresent(verifyForm, 30);
    }

    // Get text and Enter the copy data -> switch to first tabs
    public void getCodeEnterTextInField(String iframe, String getTextInPutVerify, String dataInput, String btnSubmit) throws Exception {
        keyword.untilJqueryIsDone(20L);
        keyword.switchToIFrameByXpath(iframe);
        String text = keyword.getText(getTextInPutVerify);
        keyword.closeWindowByIndex(1);
        keyword.switchToTab(0);
        keyword.sendKeys(dataInput, text);
        System.out.println("value copied");
        keyword.untilJqueryIsDone(20L);
        keyword.click(btnSubmit);
    }

    public void clearTextSendKeyAndVerify(String elementClear, String sendKeyInput, String dataSendKey, String btnSubmit, String expected, String actual) throws InterruptedException {
        keyword.clearText(elementClear);
        keyword.sendKeys(sendKeyInput, dataSendKey);
        keyword.click(btnSubmit);
        keyword.untilJqueryIsDone(50L);
        keyword.assertEquals(expected, actual);
    }

    //
    public void inputBlankAndVerify(String actual1, String expected1, String expected2) throws InterruptedException {
        keyword.untilJqueryIsDone(20L);
        keyword.click("SIGNIN_BTN_SUBMIT_FORM_PHONE");
        keyword.assertEquals(expected1, actual1);
        keyword.assertEquals(expected2, "SIGNIN_XPATH_PASSWORD_REQUIRED_FIELD");
    }


    // Create new password for entering and to use your account
    public void createNewPassWord() {

        keyword.webDriverWaitForElementPresent("LOGIN_FORM_NEW_PASS_WORD", 30);
        keyword.sendKeys("LOGIN_INPUT_NEW_PASSWORD", "LOGIN_NEW_PASSWORD");
        keyword.click("LOGIN_BTN_SUBMIT_RESET_PASSWORD");
        keyword.webDriverWaitForElementPresent("LOGIN_MESSAGE_RESET_PASSWORD_SUCCESS", 10);
    }

    public boolean checkElement(String checkElement) {
        return keyword.verifyElementPresent(checkElement);
    }
}

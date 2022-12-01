package page.signinSignup;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import org.slf4j.Logger;

public class SignInPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private SignUpPage objSignUp;

    public SignInPage(KeywordWeb key) {
        super(key);
    }

    //
    public void loginLeaverEmailAndPassWord() throws InterruptedException {
        keyword.click("LOGIN_BTN_LOGIN");
        keyword.untilJqueryIsDone(20L);
        keyword.click("LOGIN_BTN_SUBMITLOGIN");
        keyword.assertEquals("SIGNIN_MESSAGE_REQUIRED_FIELD", "SIGNIN_XPATH_EMAIL_REQUIRED_FIELD");
        Thread.sleep(1000);
        keyword.assertEquals("SIGNIN_MESSAGE_REQUIRED_FIELD", "SIGNIN_XPATH_PASSWORD_REQUIRED_FIELD");
    }

    // Login with email and leave the password field blank
    public void enterEmailLeavePasswordFiendBlank() throws InterruptedException {
        keyword.sendKeys("SIGNIN_EMAIL_LOG", "SIGNIN_DATA_EMAIL");
        keyword.click("LOGIN_BTN_SUBMITLOGIN");
        keyword.assertEquals("SIGNIN_MESSAGE_REQUIRED_FIELD", "SIGNIN_XPATH_PASSWORD_REQUIRED_FIELD");
    }

    // Login with password and leave the email field blank
    public void enterPasswordLeaveEmailFiendBlank() throws InterruptedException {
        keyword.clearText("SIGNIN_EMAIL_LOG");
        keyword.sendKeys("SIGNIN_PASSWORD_INPUT", "SIGNIN_DATA_PASSWORD01");
        keyword.click("LOGIN_BTN_SUBMITLOGIN");
        keyword.assertEquals("SIGNIN_MESSAGE_REQUIRED_FIELD", "SIGNIN_XPATH_EMAIL_REQUIRED_FIELD");
    }

    //    Login wrong email - password
    public void signInWrongEmailPassword() throws InterruptedException {
        objSignUp = new SignUpPage(this.keyword);
        keyword.untilJqueryIsDone(10L);
        objSignUp.clearTextAndSendKey("SIGNIN_EMAIL_LOG", "SIGNIN_EMAIL_LOG", "SIGNUP_DATA_EMAIL_INFORMATION");
        objSignUp.clearTextAndSendKey("SIGNIN_PASSWORD_INPUT", "SIGNIN_PASSWORD_INPUT", "SIGNIN_DATA_PASSWORD01");
        keyword.click("SIGNIN_FORM_LOGIN");
        keyword.click("SIGNIN_BTN_SUBMIT");
        keyword.untilJqueryIsDone(50L);
        keyword.assertEquals("SIGNIN_MESSAGE_PASSWORD_ACTUAL", "SIGNIN_MESSAGE_INVALID");
    }

    //   Login with wrong password
    public void sigInWithWrongPassword() throws InterruptedException {
        objSignUp = new SignUpPage(this.keyword);
        objSignUp.clearTextAndSendKey("SIGNIN_EMAIL_LOG", "SIGNIN_EMAIL_LOG", "SIGNUP_DATA_EMAIL_INVALID");
        keyword.click("SIGNIN_BTN_SUBMIT");
        keyword.untilJqueryIsDone(20L);
        keyword.assertEquals("SIGNIN_MESSAGE_PASSWORD_ACTUAL", "SIGNIN_MESSAGE_INVALID");
    }

    //    Enter the wrong email format
    public void enterWrongEmailFormat() throws InterruptedException {
        objSignUp = new SignUpPage(this.keyword);
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
        chooseItemCustomer(
                "LOGIN_BTN_CUSTOMER",
                "LOGIN_BTN_CUSTOMER",
                "SIGNUP_VERIFY_CUSTOMER",
                "LOGIN_BTN_EMAIL_LOG",
                "SIGNUP_VERIFY_EMAIL_LOG"
        );
        selectActionEmailLog("LOGIN_CHECK_EMAIL_LOG_ACTION_SELECT",
                "LOGIN_SELECT_ACTIVE",
                "LOGIN_SELECT_VIEW_CHECK_EMAIL_LOG",
                "LOGIN_POPUP_MESSAGE_PASSWORD_RESET"
        );
        getCodeEnterTextInField("LOGIN_IFRAME",
                "LOGIN_INPUT_VERIFY_CODE",
                "SIGNIN_INPUT_ENTER_CODE", "SIGNIN_BTN_SUBMIT_SEND_CODE");
    }

    //Create invalid new password
    public void createNewPassword() throws InterruptedException {
        objSignUp = new SignUpPage(this.keyword);
        keyword.sendKeys("SIGNIN_INPUT_CREATE_NEW_PASSWORD", "SIGNIN_DATA_SEND_KEY");
        keyword.untilJqueryIsDone(50L);
        objSignUp.confirmPasswordEntryCondition("SIGNUP_MESSAGE_PASSWORD_FAIL01",
                "SIGNIN_MESSAGE_CREATE_NEW_PW", "SIGNUP_ACTUAL_MESSAGE04", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_NUMBER",
                "SIGNUP_ACTUAL_MESSAGE_AT_LAST_LOWER", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_UPPER", "SIGNUP_MESSAGE_ERROR_CHARACTERS_LIKE",
                "SIGNUP_ACTUAL_MESSAGE04"

        );
//        keyword.click("");
    }

    //    create valid new password
    public void resetNewPassword() throws InterruptedException {
        objSignUp = new SignUpPage(this.keyword);
        objSignUp.clearTextAndSendKey("SIGNIN_INPUT_CREATE_NEW_PASSWORD", "SIGNIN_INPUT_CREATE_NEW_PASSWORD", "SIGNIN_RESET_PASSWORD");
//        keyword.assertEquals("AAAA", "bbbbb");

    }

    //Forgot password
    public void forgotPassword() throws InterruptedException {
        keyword.click("LOGIN_BTN_FORGOT_PASSWORD");
    }


    //Entered the wrong code sent to the email
    public void enterWrongCodeToSentToTheEmail() throws InterruptedException {
        keyword.sendKeys("SIGNIN_INPUT_ENTER_CODE", "SIGNIN_DATA_CODE_SEND_KEY");
        keyword.click("SIGNIN_BTN_SUBMIT_SEND_CODE");
        keyword.untilJqueryIsDone(20L);
        keyword.assertEquals("SIGNIN_MESSAGE_UNABLE_CODE", "SIGNIN_XPATH_UNABLE_CODE");
//        openNewTabs();
//        loginAdmin("LOGIN_DATA_USER_NAME",
//                "LOGIN_DATA_PASS_WORD");
//        chooseItemCustomer(
//                "LOGIN_BTN_CUSTOMER", "LOGIN_BTN_CUSTOMER", "SIGNUP_VERIFY_CUSTOMER",
//                "LOGIN_BTN_EMAIL_LOG", "SIGNUP_VERIFY_EMAIL_LOG"
//        );
//        selectActionEmailLog("LOGIN_CHECK_EMAIL_LOG_ACTION_SELECT",
//                "LOGIN_SELECT_ACTIVE", "LOGIN_SELECT_VIEW_CHECK_EMAIL_LOG", "LOGIN_POPUP_MESSAGE_PASSWORD_RESET");
//        keyword.assertEquals("SIGNUP_MESSAGE_SIGNUP_SUCCESS", "SIGNUP_MESSAGE_REGIS_SUCCESS");
    }


    // open new right tabs
    public void openNewTabs() throws InterruptedException {
        keyword.executeJavaScript("window.open()");
        keyword.switchToTab(1);
        keyword.navigateToUrl("LOGIN_URL_BACKEND");
        keyword.webDriverWaitForElementPresent("LOGIN_FORM_LOGIN_BACKEND", 20);
    }

    //login admin BackEnd (shared functions)
    public void loginAdmin(String userName, String passWord) throws InterruptedException {
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
        keyword.imWait(30);
        keyword.click(selectAction);
        keyword.webDriverWaitForElementPresent(verifySelectForm, 20);
        keyword.click(selectView);
        keyword.webDriverWaitForElementPresent(verifyForm, 20);
    }

    // Get text and Enter the copy data -> switch to first tabs
    public void getCodeEnterTextInField(String iframe, String getTextInPutVerify, String dataInput, String btnSubmit) throws Exception {
        keyword.imWait(10);
        keyword.switchToIFrameByXpath(iframe);
        String text = keyword.getText(getTextInPutVerify);
        keyword.switchToTab(0);
        keyword.sendKeys(dataInput, text);
        System.out.println("value copied");
        keyword.click(btnSubmit);
    }

    // Create new password for entering and to use your account
    public void createNewPassWord() {
        keyword.webDriverWaitForElementPresent("LOGIN_FORM_NEW_PASS_WORD", 30);
        keyword.sendKeys("LOGIN_INPUT_NEW_PASSWORD", "LOGIN_NEW_PASSWORD");
        keyword.click("LOGIN_BTN_SUBMIT_RESET_PASSWORD");
        keyword.webDriverWaitForElementPresent("LOGIN_MESSAGE_RESET_PASSWORD_SUCCESS", 10);
    }

    public boolean checkStore(String checkElement) {
        return keyword.verifyElementPresent(checkElement);
    }
}

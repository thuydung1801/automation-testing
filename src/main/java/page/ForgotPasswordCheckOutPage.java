package page;

import core.*;
import io.cucumber.java.sl.In;
import org.slf4j.Logger;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;
import page.signinSignup.SignUpPage;

public class ForgotPasswordCheckOutPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private SignUpPage objSignUp;
    private RegisterPage objRegister;
    private LoginPage loginPage;
    public SignInPage signInPage;
    public CreateAccountOnWebPage objCreateAccount;

    public ForgotPasswordCheckOutPage() {
        super();
        objCreateAccount = new CreateAccountOnWebPage(this.keyword);
        objSignUp = new SignUpPage(this.keyword);
    }

    public void forgotPasswordWithPhone() throws InterruptedException {
        objCreateAccount.setupForgot("URL_DATA_PRODUCT_AU");
        keyword.untilJqueryIsDone(50L);
        if (keyword.verifyElementPresent("INPUT_MOBILE_NUMBER")) {
            keyword.untilJqueryIsDone(50L);
            keyword.click("INPUT_MOBILE_NUMBER");
            keyword.sendKeys("LOGIN_PHONE_NUMBER", "DATA_PHONE_FORGOT_CHECKOUT");
        } else {
            keyword.untilJqueryIsDone(50L);
            keyword.sendKeys("LOGIN_PHONE_NUMBER", "DATA_PHONE_FORGOT_CHECKOUT");
        }
        keyword.click("LOGIN_BTN_SUBMIT_FORGOT_PASSWORD");
        keyword.untilJqueryIsDone(50L);
        keyword.assertEquals("CONTENT_MESSAGE_CONFIRM_CODE", "MESSAGE_CONTENT");
        Thread.sleep(122000);
        keyword.verifyElementPresent("BTN_RESENCODE");
        keyword.click("BTN_RESENCODE");
        keyword.untilJqueryIsDone(30L);
        keyword.assertEquals("SIGNUP_CODE_SENT", "DATA_MESSAGE_RESEND");
        objSignUp.getActivationCode();
        keyword.untilJqueryIsDone(50L);
        objSignUp.getCodeAndSendKey("INPUT_SEND_CODE_PHONE", "SIGNUP_BTN_SUBMIT2");
    }

    //    "LOGIN_PHONE_NUMBER" "DATA_PHONE_FAIL"
    public void forgotPasswordPhoneNotExist() throws InterruptedException {
        forgotPasswordSendData("LOGIN_PHONE_NUMBER", "DATA_PHONE_NOT_EXIST", "SIGNIN_MESSAGE_PHONE_INCORRECT", "SIGNIN_INPUT_MESSAGE_PHONE_INCORRECT", "LOGIN_BTN_SUBMIT_FORGOT_PASSWORD", "SIGNIN_CLICK_FORM");
    }

    public void sendDataPasswordHollow() throws InterruptedException {
        verifyDataPassword(" ", "SIGNUP_ACTUAL_MESSAGE04", "SIGNUP_MESSAGE_ERROR_NUMBER",
                "SIGNUP_MESSAGE_ERROR_LOWER_LETTER", "SIGNUP_MESSAGE_ERROR_UPPER_LETTER");
    }

    public void sendPasswordInvalid() throws InterruptedException {
        verifyDataPassword("DATA_PASSWORD_INVALID", "CONTENT_CHARACTER", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_NUMBER",
                "SIGNUP_ACTUAL_MESSAGE_AT_LAST_LOWER", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_UPPER");
    }

    public void forgotSuccess() throws InterruptedException {
        forgotPasswordSendData("SIGNIN_INPUT_CREATE_NEW_PASSWORD", "DATA_PASSWORD", "SIGNIN_UPDATE_PASSWORD_SUCCESS", "INPUT_MESSAGE_UPDATE_SUCCESS_PASSWORD", "BTN_SUBMIT_PASSWORD", "FORM_RESET_PASSWORD3");
    }

    public void forgotPasswordInvalidCode() throws InterruptedException {
        forgotPasswordSendData("LOGIN_PHONE_NUMBER", "DATA_PHONE_FORGOT_CHECKOUT", "CONTENT_MESSAGE_CONFIRM_CODE", "MESSAGE_CONTENT", "LOGIN_BTN_SUBMIT_FORGOT_PASSWORD", "MODAL_CONTENT");
//        ----------Forgot password and didn't input verify code
        sendKeyAndVerifyMessage("SIGNIN_INPUT_ENTER_CODE", " ", "SIGNUP_DATA_VERIFY_MESSAGE_FAIL", "INPUT_CODE_ERROR");
////        ----------Forgot password and input invalid verify code.
        sendKeyAndVerifyMessage("SIGNIN_INPUT_ENTER_CODE", "AFFIRM_DATA_PHONE", "SIGNIN_MESSAGE_UNABLE_CODE", "SIGNIN_INPUT_MESSAGE_PHONE_INCORRECT");
    }
//    public void testLogin(String dataPhone, String dataPassWord, Boolean check) throws InterruptedException {
//        keyword.untilJqueryIsDone(50L);
//        keyword.click("BTN_CLOSE_MODAL_SEND_CODE");
//        if (check) {
//            keyword.untilJqueryIsDone(50L);
//            keyword.click("TAB_MOBILE");
////           keyword.sendKeys("");
//        }
//    }
    public void forgotPasswordSendData(String clearText, String dataKey, String expected, String actual, String btnSubmit, String form) throws InterruptedException {
        objSignUp.clearTextAndSendKey(clearText, clearText, dataKey);
        keyword.untilJqueryIsDone(20L);
        keyword.click(form);
        keyword.click(btnSubmit);
//        keyword.assertEquals(expected, actual);
    }

    public void sendKeyAndVerifyMessage(String inputSendKey, String dataKey, String expected, String actual) throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.click(inputSendKey);
        keyword.sendKeys(inputSendKey, dataKey);
        keyword.click("SIGNIN_BTN_SUBMIT_SEND_CODE");
        keyword.untilJqueryIsDone(50L);
        keyword.assertEquals(expected, actual);

    }

    public void verifyDataPassword(String data, String Character, String number,
                                   String lowerLetter, String upperLetter) throws InterruptedException {
        keyword.untilJqueryIsDone(30L);
        keyword.sendKeys("SIGNIN_INPUT_CREATE_NEW_PASSWORD", data);
        keyword.click("BTN_SUBMIT_PASSWORD");
        objSignUp.confirmPasswordEntryCondition("SIGNUP_MESSAGE_PASSWORD_FAIL01", "SIGNIN_MESSAGE_CREATE_NEW_PW", Character,
                number, lowerLetter, upperLetter,
                "SIGNUP_MESSAGE_ERROR_CHARACTERS_LIKE", "SIGNUP_MESSAGE_ERROR_CHARACTERS_LIKE");
    }

    public void forgotPasswordInvalidInputData(String value, String data) throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.waitForElementNotVisible(30, "//div[@class='loading-mask']");
        keyword.click("CHECKOUT_LA_HPL_FORGOT_PASS");
        keyword.untilJqueryIsDone(30L);
        keyword.sendKeys(value, data);
        keyword.click("LOGIN_BTN_SUBMIT_FORGOT_PASSWORD");
        keyword.untilJqueryIsDone(30L);
        keyword.assertEquals("SIGNUP_VALID_NUMBER_FIELD", "SIGNIN_MESSAGE_VALID_PHONE_");
    }
}

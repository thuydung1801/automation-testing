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

    public void forgotPasswordSuccess() throws InterruptedException {
        objCreateAccount.setupForgot("URL_DATA_PRODUCT_AU");
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
//        String text1 = keyword.getText("SIGNUP_GET_CODE_SMS");
//        String text = text1.substring(text1.length() - 6);
//        System.out.println("-----------------:" + text);
//        keyword.switchToTab(0);
//        keyword.sendKeys("INPUT_SEND_CODE_PHONE", text);
//        System.out.println("value copied");
//        keyword.click("SIGNUP_BTN_SUBMIT2");
        keyword.untilJqueryIsDone(30L);
        keyword.sendKeys("INPUT_RESET_PASSWORD", "DATA_PASSWORD");
        keyword.click("BTN_SUBMIT_PASSWORD");
//        keyword.assertEquals("SIGNIN_UPDATE_PASSWORD_SUCCESS", "INPUT_MESSAGE_UPDATE_SUCCESS_PASSWORD");
    }

    public void forgotPasswordInvalidInputData(String value, String data) throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.click("CHECKOUT_LA_HPL_FORGOT_PASS");
        keyword.untilJqueryIsDone(30L);
        keyword.sendKeys(value, data);
        keyword.click("LOGIN_BTN_SUBMIT_FORGOT_PASSWORD");
        keyword.untilJqueryIsDone(30L);
        keyword.assertEquals("SIGNUP_VALID_NUMBER_FIELD", "SIGNIN_MESSAGE_VALID_PHONE_");
    }
    //    "LOGIN_PHONE_NUMBER" "DATA_PHONE_FAIL"
    public void forgotPasswordPhoneNotExist() throws InterruptedException {
        objSignUp.clearTextAndSendKey("LOGIN_PHONE_NUMBER","LOGIN_PHONE_NUMBER","DATA_PHONE_NOT_EXIST");
        keyword.doubleClick("LOGIN_BTN_SUBMIT_FORGOT_PASSWORD");
        keyword.untilJqueryIsDone(30L);
        keyword.assertEquals("SIGNIN_MESSAGE_PHONE_INCORRECT", "SIGNIN_INPUT_MESSAGE_PHONE_INCORRECT");
    }
}

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
    public void forgotPasswordCheckout() throws InterruptedException {
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
        objSignUp.getActivationCode("INPUT_SEND_CODE_PHONE", "SIGNIN_MESSAGE_UNABLE_CODE", "ACTUAL_DATA_TITLE_PASSWORD_NEW");

    }
}

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
    private LoginPage objLogin;
    private RegisterPage objRegister;
    private LoginPage loginPage;
    public SignInPage signInPage;
    public CreateAccountOnWebPage objCreateAccount;

    public ForgotPasswordCheckOutPage() {
        super();
        objCreateAccount = new CreateAccountOnWebPage(this.keyword);
    }
    public void forgotPasswordCheckout() throws InterruptedException {
        objCreateAccount.setupForgot("URL_DATA_PRODUCT_AU");
        if (keyword.verifyElementPresent("INPUT_MOBILE_NUMBER")) {
            keyword.untilJqueryIsDone(50L);
            keyword.click("INPUT_MOBILE_NUMBER");
            keyword.sendKeys("LOGIN_PHONE_NUMBER", "123456");
        } else {
            keyword.untilJqueryIsDone(50L);
            keyword.sendKeys("LOGIN_PHONE_NUMBER", "123456");
        }
    }
}

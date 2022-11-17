package test.signinSignup;

import core.BaseTest;
import io.cucumber.java.sl.In;
import org.testng.annotations.Test;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;
import page.signinSignup.SignUpPage;


public class SignInTest extends BaseTest {
    private LoginPage objLogin;
    private RegisterPage objRegist;
    private SignInPage objSigin;

    public SignInTest() {
        super();
    }

    @Test(priority = 1, description = "Login form with for got password")
    public void testCase_LI02() throws InterruptedException {
        objLogin = new LoginPage(this.keyword);
        objRegist = new RegisterPage(this.keyword);
        objSigin = new SignInPage(this.keyword);
        objLogin.loginOnAlert();
        objSigin.login();
        objRegist.acceptAllCookies();
        objRegist.chooseLanguages();
        objSigin.clickAndVerifySignIn("LOGIN_BTN_LOGIN", "LOGIN_BTN_FORGOT_PASSWORD");
        Thread.sleep(2000);
        objSigin.clickAndVerifySignIn("LOGIN_BTN_FORGOT_PASSWORD", "LOGIN_BOX_FORGOT_PASSWORD");
        objSigin.senkeyLogin("LOGIN_INPUT_FORGOT_PASSWORD", "LOGIN_DATA_EMAIL_FORGOT_PASSWORD");
        objSigin.clickAndVerifySignIn("LOGIN_BTN_SUBMIT_FORGOT_PASSWORD", "LOGIN_BOX_ENTER_CODE_FORGOT_PASSWORD");
    }

    @Test(priority = 2, description = "Open new browser get code")
    public void testCase_LI03() throws InterruptedException {
        objSigin.openBrowser();
        objSigin.senkeyLogin("LOGIN_FORM_USER_NAME_BACKEND", "LOGIN_DATA_USER_NAME");
        objSigin.senkeyLogin("LOGIN_FORM_PASSWORD_BACKEND", "LOGIN_DATA_PASS_WORD");
        objSigin.clickAndVerifySignIn("LOGIN_FORM_BTN_SUBMIT_BACKEND", "LOGIN_BTN_CUSTOMER");
        objSigin.scrollToElementCheck("LOGIN_BTN_CUSTOMER");
        objSigin.clickAndVerifySignIn("LOGIN_BTN_CUSTOMER", "LOGIN_FORM_CSTOMER");
        objSigin.clickAndVerifySignIn("LOGIN_BTN_EMAIL_LOG", "LOGIN_HEADER_EMAIL_LOG");
    }

    @Test(priority = 3, description = "check customer with email log ")
    public void testCase_LI04() throws InterruptedException {
        keyword.imWait(10);
        objSigin.clickAndVerifySignIn("LOGIN_CHECK_EMAIL_LOG_ACTION_SELECT", "LOGIN_SELECT_ACTIVE");
        objSigin.clickAndVerifySignIn("LOGIN_SELECT_VIEW_CHECK_EMAIL_LOG", "LOGIN_POPUP_MESSAGE_PASSWORD_RESET");
    }

}

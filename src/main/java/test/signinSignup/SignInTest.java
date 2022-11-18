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
        objRegist.acceptAllCookies();
        objRegist.chooseLanguages();
        Thread.sleep(2000);
        objSigin.goToFormLoginAndEnterDataForGotPassWord();
    }

    @Test(priority = 2, description = "Open new browser get code")
    public void testCase_LI03() throws InterruptedException {
        objSigin.openNewTabs();
        objSigin.loginAdmin(
                "LOGIN_DATA_USER_NAME",
                "LOGIN_DATA_PASS_WORD"
        );
    }

    @Test(priority = 3, description = "Check customer with email log ")
    public void testCase_LI04() throws InterruptedException {
        objSigin.selectActionEmailLog(
                "LOGIN_CHECK_EMAIL_LOG_ACTION_SELECT",
                "LOGIN_SELECT_ACTIVE",
                "LOGIN_SELECT_VIEW_CHECK_EMAIL_LOG",
                "LOGIN_POPUP_MESSAGE_PASSWORD_RESET"
        );
    }

    @Test(priority = 4, description = "Get code verify")
    public void testCase_LI05() throws Exception {
        objSigin.enterTextInField();
        Thread.sleep(1000);
        keyword.imWait(5);
    }
}
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
    public void testCase_SI02() throws InterruptedException {
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
    public void testCase_SI03() throws InterruptedException {
        objSigin.openNewTabs();
        objSigin.loginAdmin(
                "LOGIN_DATA_USER_NAME",
                "LOGIN_DATA_PASS_WORD"
        );
        objSigin.chooseItemCustomer(
                "LOGIN_BTN_CUSTOMER",
                "LOGIN_BTN_CUSTOMER",
                "LOGIN_FORM_CUSTOMER",
                "LOGIN_BTN_EMAIL_LOG",
                "LOGIN_HEADER_EMAIL_LOG"
        );
    }
    @Test(priority = 3, description = "Check customer with email log ")
    public void testCase_SI04() throws InterruptedException {
        objSigin.selectActionEmailLog(
                "LOGIN_CHECK_EMAIL_LOG_ACTION_SELECT",
                "LOGIN_SELECT_ACTIVE",
                "LOGIN_SELECT_VIEW_CHECK_EMAIL_LOG",
                "LOGIN_POPUP_MESSAGE_PASSWORD_RESET"
        );
    }
    @Test(priority = 4, description = "Get code verify")
    public void testCase_SI05() throws Exception {
        objSigin.getCodeEnterTextInField("LOGIN_IFRAME",
                "LOGIN_INPUT_VERIFY_CODE",
                "LOGIN_INPUT_ENTER_DATA",
                "LOGIN_BTN_SUBMIT_CODE"
        );
        Thread.sleep(1000);
        keyword.imWait(5);
    }
    @Test(priority = 4, description = "Create new password for entering and to use your a")
    public void testCase_SI06() throws Exception {
        objSigin.createNewPassWord();
    }
}

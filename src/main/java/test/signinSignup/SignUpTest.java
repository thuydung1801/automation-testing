package test.signinSignup;


import core.BaseTest;
import io.cucumber.java.sl.In;
import org.testng.annotations.Test;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;
import page.signinSignup.SignUpPage;

public class SignUpTest extends BaseTest {
    private LoginPage objLogin;
    private RegisterPage objRegist;
    private SignUpPage objSigUp;
    private SignInPage objSignIn;

    public SignUpTest() {
        super();
    }

    @Test(priority = 1, description = "Login form with for got password")
    public void testCase_SU01() throws InterruptedException {
        objLogin = new LoginPage(this.keyword);
        objRegist = new RegisterPage(this.keyword);
        objSigUp = new SignUpPage(this.keyword);
        objLogin.loginOnAlert();
        objRegist.acceptAllCookies();
        objRegist.chooseLanguages();
        Thread.sleep(2000);
        objSigUp.goToFormCreateMyAccount();
    }

    @Test(priority = 2, description = "Create New Account- not enter valid values")
    public void testCase_SU02() throws InterruptedException {
        objSigUp.enterNotValueInformation();
    }

    @Test(priority = 3, description = "Create new customer and input invalid data for email form")
    public void testCase_SU03() throws InterruptedException {
        objSigUp.sendDataFormInformationWithEmailInvalid();
    }

    @Test(priority = 4, description = "confirmation email does not match")
    public void testCase_SU04() throws InterruptedException {
        objSigUp.sendDataFormInformationWithConfirmEmailInvalid();
    }

    @Test(priority = 5, description = "Create New Account- Sign up with a duplicate email address")
    public void testCase_SU05() throws InterruptedException {
//        objSigUp.sendKeyFullDataFormInformationAndSubmit(
//                "SIGNUP_DATA_FIRST_NAME_INFORMATION",
//                "SIGNUP_DATA_LAST_NAME_INFORMATION",
//                "SIGNUP_DATA_EMAIL_INFORMATION",
//                "SIGNUP_DATA_EMAIL_CONFIRM_INFORMATION"
//        );
        objSigUp.nextButton();
        objSigUp.sendKeyFullDataFormPasswordInformation(
                "SIGNUP_CREATE_PASSWORD",
                "SIGNUP_SELECT_OPTION_TITLE"
        );
    }

    //
    @Test(priority = 6, description = "Get the activation code sent to the email address")
    public void testCase_GetCodeBE4() throws Exception {
        objSignIn = new SignInPage(this.keyword);
        objSignIn.openNewTabs();
        objSignIn.loginAdmin(
                "LOGIN_DATA_USER_NAME",
                "LOGIN_DATA_PASS_WORD");
        Thread.sleep(1000);
        objSignIn.chooseItemCustomer();
        objSignIn.selectActionEmailLog("LOGIN_CHECK_EMAIL_LOG_ACTION_SELECT",
                "LOGIN_SELECT_ACTIVE",
                "LOGIN_SELECT_VIEW_CHECK_EMAIL_LOG",
                "LOGIN_POPUP_MESSAGE_PASSWORD_RESET");
        objSignIn.enterTextInField("LOGIN_IFRAME",
                "LOGIN_INPUT_VERIFY_CODE",
                "SIGNUP_INPUT_VERIFY_CODE", "SIGNUP_BTN_SUBMIT_ACCOUNT");
        objSigUp.clearTextAndSendKey(
                "SIGNUP_DATA_EMAIL_INVALID",
                "SIGNUP_DATA_EMAIL_INVALID",
                "SIGNUP_DATA_EMAIL_CONFIRM_INFORMATION"
        );
    }

    @Test(priority = 7, description = "Create New Account- Enter wrong format  email address")
    public void testCase_SU06() throws InterruptedException {

    }

    @Test(priority = 8, description = "Create New Account- Enter wrong format  email address")
    public void testCase_SU07() throws InterruptedException {

    }

    @Test(priority = 9, description = "Create New Account- Enter wrong format  email address")
    public void testCase_SU08() throws InterruptedException {

    }
}

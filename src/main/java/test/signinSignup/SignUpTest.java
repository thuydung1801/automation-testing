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
        if (objSigUp.checkElement("SIGNUP_SWITCH_TO_TAB_CHECK")) {
            System.out.println("next to steep");
        } else {
            objSigUp.nextButton();
            objSigUp.sendKeyFullDataFormPasswordInformation(
                    "SIGNUP_SELECT_TITLE",
                    "SIGNUP_PASSWORD_INFORMATION",
                    "SIGNUP_CREATE_PASSWORD",
                    "SIGNUP_SELECT_OPTION_TITLE"
            );
            objSigUp.submitNotClickAgree("SIGNUP_CREATE_PASSWORD");
        }
    }
    @Test(priority = 6, description = "Get the activation code sent to the email address")
    public void testCase_GetCodeBE4() throws Exception {
        objSignIn = new SignInPage(this.keyword);
        objSignIn.openNewTabs();
        objSignIn.loginAdmin(
                "LOGIN_DATA_USER_NAME",
                "LOGIN_DATA_PASS_WORD");
        objSigUp.switchToTabCheck(0);
        if (objSigUp.checkElement("SIGNUP_SWITCH_TO_TAB_CHECK")) {
            objSigUp.switchToTabCheck(1);
            objSignIn.chooseItemCustomer(
                    "SIGNUP_STORES_ITEM",
                    "SIGNUP_STORES_ITEM",
                    "LOGIN_FORM_CUSTOMER",
                    "SIGNUP_ELEMENT_SMS_LOG",
                    "SIGNUP_VERIFY_SMS"
            );
            objSigUp.filterSort(
                    "SIGNUP_BTN_FILTER",
                    "SIGNUP_VERIFY_ELEMENT_FILTER",
                    "SIGNUP_DATA_PHONE001",
                    "SIGNUP_BUTTON_APPLY_FILTERS"
            );
            objSigUp.getCodeAndSendKey(
                    "SIGNUP_GET_CODE_SMS",
                    "SIGNUP_SWITCH_TO_TAB_CHECK",
                    "SIGNUP_BTN_SUBMIT"
            );
        } else {
            objSigUp.switchToTabCheck(1);
            objSignIn.chooseItemCustomer(
                    "LOGIN_BTN_CUSTOMER",
                    "LOGIN_BTN_CUSTOMER",
                    "SIGNUP_VERIFY_CUSTOMER",
                    "LOGIN_BTN_EMAIL_LOG",
                    "SIGNUP_VERIFY_EMAIL_LOG"
            );
            objSignIn.selectActionEmailLog("LOGIN_CHECK_EMAIL_LOG_ACTION_SELECT",
                    "LOGIN_SELECT_ACTIVE",
                    "LOGIN_SELECT_VIEW_CHECK_EMAIL_LOG",
                    "LOGIN_POPUP_MESSAGE_PASSWORD_RESET");
            objSignIn.getCodeEnterTextInField("LOGIN_IFRAME",
                    "LOGIN_INPUT_VERIFY_CODE",
                    "SIGNUP_INPUT_VERIFY_CODE", "SIGNUP_BTN_SUBMIT_ACCOUNT");
            objSigUp.verifySignUpSuccess();
        }
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

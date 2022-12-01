package test.signinSignup;

import core.BaseTest;
import org.testng.annotations.Test;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;
import page.signinSignup.SignUpPage;

public class SignInTest extends BaseTest {
    private LoginPage objLogin;
    private RegisterPage objRegist;
    private SignInPage objSigin;
    private SignUpPage objSignUp;

    public SignInTest() {
        super();
    }

    @Test(priority = 1, description = "Log in and leave the email and password fields blank")
    public void testCase_SI02() throws InterruptedException {
        objLogin = new LoginPage(this.keyword);
        objRegist = new RegisterPage(this.keyword);
        objSigin = new SignInPage(this.keyword);
        objLogin.loginOnAlert();
        objRegist.acceptAllCookies();
//        objRegist.chooseLanguages();
        Thread.sleep(2000);
        objSigin.loginLeaverEmailAndPassWord();
    }

    @Test(priority = 2, description = "Login with email and leave the password field blank")
    public void testCase_SI03() throws InterruptedException {
        objSigin.enterEmailLeavePasswordFiendBlank();
    }

    @Test(priority = 3, description = "Login with password and leave the email field blank")
    public void testCase_SI04() throws InterruptedException {
        objSigin.enterPasswordLeaveEmailFiendBlank();
    }

    @Test(priority = 4, description = "Login wrong email - password")
    public void testCase_SI05() throws InterruptedException {
        objSigin.signInWrongEmailPassword();
    }

    @Test(priority = 5, description = "Login with wrong password")
    public void testCase_SI06() throws InterruptedException {
        objSigin.sigInWithWrongPassword();
    }

    @Test(priority = 6, description = "Enter the wrong email format")
    public void testCase_SI07() throws InterruptedException {
        objSigin.enterWrongEmailFormat();
    }

    //
//    //    @Test(priority = 7, description = "Forgot password")
//    public void testCase_SI09() throws InterruptedException {
////        objSigin.goToFormLoginAndEnterDataForGotPassWord();
//    }
    @Test(priority = 8, description = "Entered the wrong code sent to the email")
    public void testCase_SI0911() throws Exception {
        objSigin.enterWrongCodeSentToEmail();
        objSigin.resentTheCodeToEmail();
    }

    @Test(priority = 9, description = "Create invalid new password")
    public void testCase_SI014() throws InterruptedException {
        objSigin.createNewPassword();
    }

    @Test(priority = 10, description = "create valid new password")
    public void testCase_SI015() throws InterruptedException {
        objSigin.resetNewPassword();
    }
//
//    @Test(priority = 11, description = "Enter the wrong email format")
//    public void testCase_SI012() throws InterruptedException {
//
//    }
//
//    @Test(priority = 12, description = "Enter the wrong email format")
//    public void testCase_SI013() throws InterruptedException {
//
//    }
//
//    @Test(priority = 13, description = "Enter the wrong email format")
//    public void testCase_SI014() throws InterruptedException {
//
//    }
//
//    @Test(priority = 14, description = "Enter the wrong email format")
//    public void testCase_SI015() throws InterruptedException {
//
//    }
//    @Test(priority = 2, description = "Open new browser get code")
//    public void testCase_SI03() throws InterruptedException {
//        objSigin.openNewTabs();
//        objSigin.loginAdmin(
//                "LOGIN_DATA_USER_NAME",
//                "LOGIN_DATA_PASS_WORD"
//        );
//        objSigin.chooseItemCustomer(
//                "LOGIN_BTN_CUSTOMER",
//                "LOGIN_BTN_CUSTOMER",
//                "LOGIN_FORM_CUSTOMER",
//                "LOGIN_BTN_EMAIL_LOG",
//                "LOGIN_HEADER_EMAIL_LOG"
//        );
//    }
//    @Test(priority = 3, description = "Check customer with email log ")
//    public void testCase_SI04() throws InterruptedException {
//        objSigin.selectActionEmailLog(
//                "LOGIN_CHECK_EMAIL_LOG_ACTION_SELECT",
//                "LOGIN_SELECT_ACTIVE",
//                "LOGIN_SELECT_VIEW_CHECK_EMAIL_LOG",
//                "LOGIN_POPUP_MESSAGE_PASSWORD_RESET"
//        );
//    }
//    @Test(priority = 4, description = "Get code verify")
//    public void testCase_SI05() throws Exception {
//        objSigin.getCodeEnterTextInField("LOGIN_IFRAME",
//                "LOGIN_INPUT_VERIFY_CODE",
//                "LOGIN_INPUT_ENTER_DATA",
//                "LOGIN_BTN_SUBMIT_CODE"
//        );
//        Thread.sleep(1000);
//        keyword.imWait(5);
//    }
//    @Test(priority = 4, description = "Create new password for entering and to use your a")
//    public void testCase_SI06() throws Exception {
//        objSigin.createNewPassWord();
//    }
}

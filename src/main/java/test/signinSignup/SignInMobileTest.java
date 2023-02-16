package test.signinSignup;

import core.BasePage;
import core.BaseTest;
import core.KeywordWeb;
import core.LogHelper;
import org.testng.annotations.Test;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInMobilePage;
import page.signinSignup.SignInPage;
import page.signinSignup.SignUpPage;
import org.slf4j.Logger;

public class SignInMobileTest extends BaseTest {
    private LoginPage objLogin;
    private RegisterPage objRegist;
    private SignInMobilePage objSigInMobile;
    private static Logger logger = LogHelper.getLogger();

    public SignInMobileTest() {
        super();
    }

    @Test(priority = 1, description = "Log in and leave the email and password fields blank  \n" + "or register to the form to login the mobile")
    public void testCase_SI02() throws InterruptedException {
        logger.info("testCase_SU05");
        objSigInMobile = new SignInMobilePage(this.keyword);
        objLogin = new LoginPage(this.keyword);
        objRegist = new RegisterPage(this.keyword);
//        objLogin.loginOnAlert();
//        keyword.navigateToUrl("https://dev3.glamira.com/glgb/");
        Thread.sleep(1000);
        objRegist.chooseLanguages();
        objRegist.acceptAllCookies();
        objSigInMobile.checkGoToFormLoginWithEmail();
    }
//
//    @Test(priority = 2, description = "Login with email and leave the password field blank")
//    public void testCase_SI03() throws InterruptedException {
//        objSigInMobile.enterEmailLeavePasswordFiendBlank();
//    }
//
//    @Test(priority = 3, description = "Login with password and leave the email field blank")
//    public void testCase_SI04() throws InterruptedException {
//        objSigInMobile.enterPasswordLeaveEmailFiendBlank();
//    }
//
//    @Test(priority = 4, description = "Login wrong email - password")
//    public void testCase_SI05() throws InterruptedException {
//        objSigInMobile.wrongPasswordAndEmail();
//    }
//
//    @Test(priority = 5, description = "Login with wrong password")
//    public void testCase_SI06() throws InterruptedException {
//        objSigInMobile.sigInWithWrongPassword();
//    }
//
//    @Test(priority = 6, description = "Enter the wrong email format")
//    public void testCase_SI07() throws InterruptedException {
//        objSigInMobile.enterWrongEmailFormat();
//    }
//
//    @Test(priority = 8, description = "Entered the wrong code sent to the email")
//    public void testCase_SI014() throws Exception {
//        objSigInMobile.enterWrongCodeSentToEmail();
//
//    }
//
//    @Test(priority = 8, description = "Resend the code to email")
//    public void testCase_SI015() throws Exception {
//        objSigInMobile.resentTheCodeToEmail();
//    }
//
//    @Test(priority = 9, description = "create valid new password")
//    public void testCase_SI016_testCase_SI013() throws InterruptedException {
//        objSigInMobile.createNewPassword();
//    }
//
//    @Test(priority = 10, description = "Login successfully on Login modal")
//    public void testCase_SI01() throws InterruptedException {
//        objSigInMobile.loginSuccessfully();
//    }

    //
//    //----PHONE WHIT
    @Test(priority = 12, description = "Invalid phone number entered")
    public void testCase_SI09() throws InterruptedException {
        objSigInMobile.checkGoToFormLoginWithPhone();
        objSigInMobile.enterInvalidPhoneNumber();
    }

    @Test(priority = 13, description = "Login wrong phone number ")
    public void testCase_SI010() throws InterruptedException {
        objSigInMobile.enterInvalidPhone();
    }

    @Test(priority = 14, description = "Login wrong password ")
    public void testCase_SI011() throws InterruptedException {
        objSigInMobile.enterWrongPassword();
    }

    @Test(priority = 15, description = "Enter a phone number that is not in the system")
    public void testCase_SI017() throws InterruptedException {
        objSigInMobile.forgotPassEnterPhoneIsNotTheSystem();
    }

    @Test(priority = 16, description = "create valid new password")
    public void testCase_SI018() throws InterruptedException {
        objSigInMobile.createNewPasswordWithInvalidPhone();
    }

//    @Test(priority = 17, description = "create valid new password Success")
//    public void testCase_SI019() throws InterruptedException {
//        objSigInMobile.createNewPasswordSuccess();
//    }
//
//    @Test(priority = 18, description = "Login successfully on Login modal with phone number")
//    public void testCase_SI08_And_SI012() throws InterruptedException {
//        logger.info("testCase_SI08_And_SI012");
//        objSigInMobile.loginWithPhoneSuccess();
//    }
}



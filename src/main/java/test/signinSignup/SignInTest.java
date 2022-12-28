package test.signinSignup;

import core.BaseTest;
import core.LogHelper;
import org.testng.annotations.Test;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;
import page.signinSignup.SignUpPage;
import org.slf4j.Logger;

public class SignInTest extends BaseTest {
    private LoginPage objLogin;
    private RegisterPage objRegist;
    private SignInPage objSigin;
    private SignUpPage objSignUp;
    private static Logger logger = LogHelper.getLogger();

    public SignInTest() {
        super();
    }

    @Test(priority = 1, description = "Log in and leave the email and password fields blank  \n" + "or register to the form to login the mobile")
    public void testCase_SI02() throws InterruptedException {
        logger.info("testCase_SU05");
        objSigin = new SignInPage(this.keyword);
        objLogin = new LoginPage(this.keyword);
        objRegist = new RegisterPage(this.keyword);
        objSigin = new SignInPage(this.keyword);
        objLogin.loginOnAlert();
        objRegist.acceptAllCookies();
        objSigin.checkGoToFormLoginWithEmail();
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
        objSigin.wrongPasswordAndEmail();
    }

    @Test(priority = 5, description = "Login with wrong password")
    public void testCase_SI06() throws InterruptedException {
        objSigin.sigInWithWrongPassword();
    }

    @Test(priority = 6, description = "Enter the wrong email format")
    public void testCase_SI07() throws InterruptedException {
        objSigin.enterWrongEmailFormat();
    }

    @Test(priority = 8, description = "Entered the wrong code sent to the email")
    public void testCase_SI014() throws Exception {
        objSigin.enterWrongCodeSentToEmail();

    }

    @Test(priority = 8, description = "Resend the code to email")
    public void testCase_SI015() throws Exception {
        objSigin.resentTheCodeToEmail();
    }

    @Test(priority = 9, description = "create valid new password")
    public void testCase_SI016_testCase_SI013() throws InterruptedException {
        objSigin.createNewPassword();
    }
    @Test(priority = 10, description = "Login successfully on Login modal")
    public void testCase_SI01() throws InterruptedException {
        objSigin.loginSuccessfully();
    }


    //----PHONE WHIT
    @Test(priority = 12, description = "Invalid phone number entered")
    public void testCase_SI09() throws InterruptedException {
        objSigin.checkGoToFormLoginWithPhone();
        objSigin.enterInvalidPhoneNumber();
    }
    @Test(priority = 13, description = "Login wrong phone number ")
    public void testCase_SI010() throws InterruptedException {
        objSigin.enterInvalidPhone();
    }

    @Test(priority = 14, description = "Login wrong password ")
    public void testCase_SI011() throws InterruptedException {
        objSigin.enterWrongPassword();
    }

    @Test(priority = 15, description = "Enter a phone number that is not in the system")
    public void testCase_SI017() throws InterruptedException {
        objSigin.forgotPassEnterPhoneIsNotTheSystem();
    }

    @Test(priority = 16, description = "create valid new password")
    public void testCase_SI018() throws InterruptedException {
        objSigin.createNewPasswordWithInvalidPhone();
    }
    @Test(priority = 17, description = "create valid new password Success")
    public void testCase_SI019() throws InterruptedException {
        objSigin.createNewPasswordSuccess();
    }
    @Test(priority = 18, description = "Login successfully on Login modal with phone number")
    public void testCase_SI08_And_SI012() throws InterruptedException {
        logger.info("testCase_SI08_And_SI012");
        objSigin.loginWithPhoneSuccess();
    }
}

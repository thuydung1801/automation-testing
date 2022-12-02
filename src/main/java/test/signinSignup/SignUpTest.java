package test.signinSignup;
import core.BaseTest;
import core.LogHelper;
import org.testng.annotations.Test;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;
import page.signinSignup.SignUpPage;
import org.slf4j.Logger;

public class SignUpTest extends BaseTest {
    private LoginPage objLogin;
    private RegisterPage objRegist;
    private SignUpPage objSigUp;
    private SignInPage objSignIn;
    private static Logger logger = LogHelper.getLogger();
    public SignUpTest() {
        super();
    }
    @Test(priority = 1, description = "Create new customer and input email exist on database OR Create new customer and leave with blank form for required form")
    public void testCase_SU05() throws InterruptedException {
        logger.info("testCase_SU05");
        objLogin = new LoginPage(this.keyword);
        objRegist = new RegisterPage(this.keyword);
        objSigUp = new SignUpPage(this.keyword);
        objLogin.loginOnAlert();
//        objSigUp.nextUrl();
        objRegist.acceptAllCookies();
        objRegist.chooseLanguages();
        Thread.sleep(2000);
        objSigUp.goToFormCreateMyAccount();
        if (!objSigUp.checkElement("SIGNUP_WITH_PHONE")) {
            objSigUp.createCustomerWithEmail();
        } else {
            logger.info("next steep test");
        }
    }

    @Test(priority = 2, description = "Create new customer and leave with email form for required form")
    public void testCase_SU02() throws InterruptedException {
        logger.info("testCase_SU02");
        objSigUp.sendDataEmailAndConfirmEmail();
    }

    @Test(priority = 3, description = "Create new customer and input invalid data for email form")
    public void testCase_SU03() throws InterruptedException {
        logger.info("testCase_SU03");
        objSigUp.invalidDataForEmailForm();
    }

    @Test(priority = 4, description = "Enter full data and confirm email does not match")
    public void testCase_SU04() throws InterruptedException {
        logger.info("testCase_SU04");
        objSigUp.confirmEmailNotMatch();
    }

    @Test(priority = 5, description = "Create new customer create password  There are 3  types of characters and < 8 characters")
    public void testCase_SU06() throws InterruptedException {
        logger.info("testCase_SU06");
        objSigUp.clearAndSendKeyEmail();
        objSigUp.inputValidPassWordAndCheckBoxSubscribe();
    }

    @Test(priority = 6, description = "\"Create a new account with password # email register and has:\n" + "+ At least < 8 characters\n" + "+ At least 1 number\n" + "+ At least 1 lower case letter\n" + "+ At least 1 upper case letter\n" + "+ At least 1 characters like: # & $ ( ) * + , - . : , . = ? @ { } ~\"")
    public void testCase_SU07() throws InterruptedException {
        logger.info("testCase_SU07");
        objSigUp.CreateUserWithPassword();
        objSigUp.confirmPasswordEntryConditionCharacters();
    }

    @Test(priority = 7, description = "\"Create a new account with password # email register and has:\n" + "+ At least < 8 characters\n" + "+ At least 1 number\n" + "+ At least 1 lower case letter\n" + "+ At least 1 upper case letter\n" + "+ At least 1 characters like: # & $ ( ) * + , - . : , . = ? @ { } ~\"")
    public void testCase_SU08() throws InterruptedException {
        logger.info("testCase_SU08");
        objSigUp.confirmPasswordEntryConditionNumber();
    }

    @Test(priority = 8, description = "\"Create a new account with password # email register and has:\n" + "+ At least > 8 characters\n" + "+ At least 1 number\n" + "+ At least 1 upper case letter\n" + "+ At least 1 characters like: # & $ ( ) * + , - . : , . = ? @ { } ~\"")
    public void testCase_SU09() throws InterruptedException {
        logger.info("testCase_SU09");
        objSigUp.confirmPasswordEntryConditionLowerLetter();
    }

    @Test(priority = 9, description = "\"Create a new account with password # email register and has:\n" + "+ At least > 8 characters\n" + "+ At least 1 number\n" + "+ At least 1 lower case letter\n" + "+ At least 1 characters like: # & $ ( ) * + , - . : , . = ? @ { } ~\"")
    public void testCase_SU010() throws InterruptedException {
        logger.info("testCase_SU010");
        objSigUp.confirmPasswordEntryConditionLowerUpper();
    }

    @Test(priority = 10, description = "\"Create a new account with password # email register and has:\n" + "+ At least > 8 characters\n" + "+ At least 1 number\n" + "+ At least 1 lower case letter\n" + "At least 1 upper case letter")
    public void testCase_SU011() throws InterruptedException {
        logger.info("testCase_SU011");
        objSigUp.confirmPasswordEntryConditionCharactersLike();
    }

        @Test(priority = 11, description = "Enter the wrong code sent to the email")
    public void testCase_SU012() throws InterruptedException {
        logger.info("testCase_SU012");
        objSigUp.clearTextAndSendKey("SIGNUP_PASSWORD_INFORMATION", "SIGNUP_PASSWORD_INFORMATION", "LOGIN_NEW_PASSWORD");
        objSigUp.ConfirmAndProcessGetCodeWrong();
    }

        @Test(priority = 12, description = "Resend the code to email")
    public void testCase_SU013() throws Exception {
        logger.info("testCase_SU013");
        objSigUp.resendAndGetCodeBack();
    }
//    SIGNUP WITH MOBILE
//    @Test(priority = 10, description = "Create new customer and leave with blank form for required form")
    public void testCase_SU015() throws Exception {
        logger.info("testCase_SU015");
        objSigUp.verifyRequiredFieldWithMobile();
    }
    //    @Test(priority = 11, description = "Invalid phone number entered")
    public void testCase_SU016() throws Exception {
        logger.info("testCase_SU016");
        objSigUp.enterDataSignUpWithMobile();
    }
    //    @Test(priority = 12, description = "Register an account with the phone number already in the system")
    public void testCase_SU017() throws Exception {
        logger.info("testCase_SU017");
        objSigUp.enterPhoneNumberAlreadyInSystem();
    }

    //    @Test(priority = 13, description = "Register an account with the email already in the system")
    public void testCase_SU018() throws Exception {
        logger.info("testCase_SU018");
        objSigUp.signUpWithPhoneButEmailInSystem();

    }
}

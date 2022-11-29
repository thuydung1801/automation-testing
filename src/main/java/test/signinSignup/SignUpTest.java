package test.signinSignup;

import core.BaseTest;
import core.LogHelper;
import io.cucumber.java.sl.In;
import org.testng.SkipException;
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
//        objSigUp.verifyMessageFail("SIGNUP_DATA_VERIFY_MESSAGE", "SIGNUP_FIRSTNAME_ERROR", "SIGNUP_DATA_VERIFY_MESSAGE", "SIGNUP_LASTNAME_ERROR");

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
        objSigUp.verifyMessageFail(
                "SIGNUP_MESSAGE_PASSWORD_FAIL01", "SIGNUP_ACTUAL_MESSAGE01",
                "SIGNUP_EXPECTED_MESSAGE_PASSWORD_01", "SIGNUP_ACTUAL_MESSAGE04",
                "SIGNUP_EXPECTED_MESSAGE_PASSWORD_05", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_NUMBER",
                "SIGNUP_EXPECTED_MESSAGE_PASSWORD_02", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_LOWER",
                "SIGNUP_EXPECTED_MESSAGE_PASSWORD_03", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_UPPER",
                "At least 1 characters like: # & $ ( ) * + , - . : , . = ? @ { } ~", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_CHARACTERS"
        );

    }

    @Test(priority = 7, description = "Create a new user with password <8 characters and < 3 character types")
    public void testCase_SU08() throws InterruptedException {
        logger.info("testCase_SU08");
        objSigUp.reSendPassWord();
//        objSigUp.verifyMessageWithPasswordNotIllegal();
    }

    @Test(priority = 8, description = "Enter the wrong code sent to the email")
    public void testCase_SU09() throws InterruptedException {
        logger.info("testCase_SU09");
        objSigUp.clearTextAndSendKey("SIGNUP_PASSWORD_INFORMATION", "SIGNUP_PASSWORD_INFORMATION", "LOGIN_NEW_PASSWORD");
        objSigUp.ConfirmAndProcessGetCodeWrong();
    }

    @Test(priority = 9, description = "Resend the code to email")
    public void testCase_SU010() throws Exception {
        logger.info("testCase_SU010");
        objSigUp.resendAndGetCodeBack();
    }

    //    SIGNUP WITH MOBILE
//    @Test(priority = 10, description = "Create new customer and leave with blank form for required form")
    public void testCase_SU012() throws Exception {
        logger.info("testCase_SU012");
        objSigUp.verifyRequiredFieldWithMobile();
    }

    //    @Test(priority = 11, description = "Invalid phone number entered")
    public void testCase_SU013() throws Exception {
        logger.info("testCase_SU013");
        objSigUp.enterDataSignUpWithMobile();
    }

    //    @Test(priority = 12, description = "Register an account with the phone number already in the system")
    public void testCase_SU014() throws Exception {
        logger.info("testCase_SU014");
        objSigUp.enterPhoneNumberAlreadyInSystem();
    }

    //    @Test(priority = 13, description = "Register an account with the email already in the system")
    public void testCase_SU018() throws Exception {
        logger.info("testCase_SU011");
        objSigUp.signUpWithPhoneButEmailInSystem();

    }

    //    @Test(priority = 14, description = "Register an account with the phone number already in the system")
    public void testCase_SU016() throws Exception {
        logger.info("testCase_SU014");
        objSigUp.enterPhoneNumberAlreadyInSystem();
    }
}

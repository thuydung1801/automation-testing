package test.signinSignup;

import core.BaseTest;
import core.LogHelper;
import org.testng.annotations.Test;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;
import page.signinSignup.SignUpMobilePage;
import page.signinSignup.SignUpPage;
import org.slf4j.Logger;

public class SignUpMobileTest extends BaseTest {
    private LoginPage objLogin;
    private RegisterPage objRegist;
    private SignUpMobilePage objSigUpMobile;
    private SignInPage objSignIn;
    private static Logger logger = LogHelper.getLogger();

    public SignUpMobileTest() {
        super();
    }

    @Test(priority = 1, description = "Create new customer and input email exist on database")
    public void testCase_SU05() throws InterruptedException {
        logger.info("testCase_SU05");
        objLogin = new LoginPage(this.keyword);
        objRegist = new RegisterPage(this.keyword);
        objSigUpMobile = new SignUpMobilePage(this.keyword);
        objSigUpMobile.navigateToUrlPage("https://dev3.glamira.com/glgb/");
        objRegist.acceptAllCookies();
        objSigUpMobile.goToFormCreateMyAccount();
        objSigUpMobile.createCustomerWithEmail();
    }

    //
    @Test(priority = 2, description = "Create new customer and leave with blank form for required form")
    public void testCase_SU02() throws InterruptedException {
        logger.info("testCase_SU02");
        objSigUpMobile.createCustomerWithBlankFormRequired();
    }

    @Test(priority = 3, description = "Create new customer and input invalid data for email form")
    public void testCase_SU03() throws InterruptedException {
        logger.info("testCase_SU03");
        objSigUpMobile.enterDataInvalidForEmailForm();
    }

    @Test(priority = 4, description = "Create new customer and input confirm email not same email form")
    public void testCase_SU04() throws InterruptedException {
        logger.info("testCase_SU04");
        objSigUpMobile.confirmEmailNotSameEmailForm();
    }
//
    @Test(priority = 5, description = "Create an account with the same password as the register email")
    public void testCase_SU06() throws InterruptedException {
        logger.info("testCase_SU06");
        objSigUpMobile.enterPasswordSameEmail();
    }


    @Test(priority = 6, description = "Create a new account with password # email register and has:\n" + "+ At least < 8 characters\n" + "+ At least 1 number\n" + "+ At least 1 lower case letter\n" + "+ At least 1 upper case letter\n" + "+ At least 1 characters like: # & $ ( ) * + , - . : , . = ? @ { } ~\"")
    public void testCase_SU07() throws InterruptedException {
        logger.info("testCase_SU07");
        objSigUpMobile.confirmPasswordEntryConditionCharacters();
    }

    //
    @Test(priority = 7, description = "\"Create a new account with password # email register and has:\n" + "+ At least < 8 characters\n" + "+ At least 1 number\n" + "+ At least 1 lower case letter\n" + "+ At least 1 upper case letter\n" + "+ At least 1 characters like: # & $ ( ) * + , - . : , . = ? @ { } ~\"")
    public void testCase_SU08() throws InterruptedException {
        logger.info("testCase_SU08");
        objSigUpMobile.confirmPasswordEntryConditionNumber();
    }
//
    @Test(priority = 8, description = "\"Create a new account with password # email register and has:\n" + "+ At least > 8 characters\n" + "+ At least 1 number\n" + "+ At least 1 upper case letter\n" + "+ At least 1 characters like: # & $ ( ) * + , - . : , . = ? @ { } ~\"")
    public void testCase_SU09() throws InterruptedException {
        logger.info("testCase_SU09");
        objSigUpMobile.confirmPasswordEntryConditionLowerLetter();
    }

    @Test(priority = 9, description = "\"Create a new account with password # email register and has:\n" + "+ At least > 8 characters\n" + "+ At least 1 number\n" + "+ At least 1 lower case letter\n" + "+ At least 1 characters like: # & $ ( ) * + , - . : , . = ? @ { } ~\"")
    public void testCase_SU010() throws InterruptedException {
        logger.info("testCase_SU010");
        objSigUpMobile.confirmPasswordEntryConditionLowerUpper();
    }

    @Test(priority = 10, description = "\"Create a new account with password # email register and has:\n" + "+ At least > 8 characters\n" + "+ At least 1 number\n" + "+ At least 1 lower case letter\n" + "At least 1 upper case letter")
    public void testCase_SU011() throws InterruptedException {
        logger.info("testCase_SU011");
        objSigUpMobile.confirmPasswordEntryConditionCharactersLike();
    }

    @Test(priority = 11, description = "Enter the wrong code sent to the email")
    public void testCase_SU012() throws InterruptedException {
        logger.info("testCase_SU012");
        objSigUpMobile.ConfirmAndProcessGetCodeWrong();
    }

    //
    @Test(priority = 12, description = "Resend the code to email and Signup Success")
    public void testCase_SU013_and_testCase_01() throws Exception {
        logger.info("testCase_SU013_and_testCase_01");
        objSigUpMobile.resendAndGetCodeBack();
    }

    //
    //    SIGNUP WITH MOBILE
    @Test(priority = 13, description = "Create new customer and leave with blank form for required form")
    public void testCase_SU015() throws Exception {
        logger.info("testCase_SU015");
        objSigUpMobile.navigateToUrlPage("https://dev3.glamira.com/glcn/");
        objSigUpMobile.goToFormCreateMyAccountChina();
        objSigUpMobile.verifyRequiredFieldWithMobile();
    }

    @Test(priority = 14, description = "Invalid phone number entered")
    public void testCase_SU016() throws Exception {
        logger.info("testCase_SU016");
        objSigUpMobile.enterDataSignUpWithMobile();
    }

    @Test(priority = 15, description = "Register an account with the phone number already in the system")
    public void testCase_SU017() throws Exception {
        logger.info("testCase_SU017");
        objSigUpMobile.enterPhoneNumberAlreadyInSystem();
    }

    @Test(priority = 16, description = "Create a new account with password # Phone register and has:\\n\" + \"+ At least < 8 characters\\n\" + \"+ At least 1 number\\n\" + \"+ At least 1 lower case letter\\n\" + \"+ At least 1 upper case letter\\n\" + \"+ At least 1 characters like: # & $ ( ) * + , - . : , . = ? @ { } ~\\\"\")\n")
    public void testCase_SU018() throws Exception {
        logger.info("testCase_SU018");
        objSigUpMobile.passwordLessThan8Characters();
    }

    @Test(priority = 17, description = "\"Create a new account with password # email register and has:\n" + "characters < 8\"")
    public void testCase_SU019() throws Exception {
        logger.info("testCase_SU019");
        objSigUpMobile.checkConditionAtLeast1Number();
    }

    @Test(priority = 18, description = "Create a new account with password # email register and missing lower case lette")
    public void testCase_SU020() throws Exception {
        logger.info("testCase_SU020");
        objSigUpMobile.checkConditionAtLeast1LowerLetter();
    }

    @Test(priority = 19, description = "Create a new account with password # email register and missing upper case letter")
    public void testCase_SU021() throws Exception {
        logger.info("testCase_SU021");
        objSigUpMobile.checkConditionAtLeast1UpperLetter();
    }

    @Test(priority = 20, description = "Create a new account with password # email register and missing special character")
    public void testCase_SU022() throws Exception {
        logger.info("testCase_SU022");
        objSigUpMobile.checkConditionAtLeast1CharactersLike();
    }

    @Test(priority = 21, description = "Register an account with the email already in the system")
    public void testCase_SU024() throws Exception {
        logger.info("testCase_SU023");
        objSigUpMobile.checkConditionAEmailAlreadyInTheSystem();
    }
    @Test(priority = 22, description = "Create new customer successfully with store enable phone number confirm")
    public void testCase_SU023_Case_14() throws Exception {
        logger.info("testCase_SU023_Case_14");
        objSigUpMobile.createNewCusstomerSuccessfullyWithPhone();
        objSigUpMobile.getActivationCode();
    }
}

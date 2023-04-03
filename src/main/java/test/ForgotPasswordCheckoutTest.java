package test;

import core.BaseTest;
import core.LogHelper;
import org.slf4j.Logger;
import org.testng.annotations.Test;
import page.CreateAccountOnWebPage;
import page.ForgotPasswordCheckOutPage;
import page.LoginReturnFormPage;
import page.home.RegisterPage;

public class ForgotPasswordCheckoutTest extends BaseTest {
    private static Logger logger = LogHelper.getLogger();
    private RegisterPage objRegist;
    private LoginReturnFormPage objLoginReturn;
    private ForgotPasswordCheckOutPage objForgotPassWord;
    public CreateAccountOnWebPage objCreateAccount;

    public ForgotPasswordCheckoutTest() throws InterruptedException {
        super();
        objRegist = new RegisterPage(this.keyword);
        objLoginReturn = new LoginReturnFormPage();
        objCreateAccount = new CreateAccountOnWebPage(this.keyword);
        objForgotPassWord = new ForgotPasswordCheckOutPage();

    }
    @Test(priority = 1, description = "Forgot password and didn't input password")
    public void testCase_NLA_33() throws InterruptedException {
        logger.info("testCase_NLA_33");
        objRegist.acceptAllCookies();
        objForgotPassWord.forgotPasswordWithPhone();
        objForgotPassWord.sendDataPasswordHollow();
    }

    @Test(priority = 2, description = "Forgot password and input invalid password")
    public void testCase_NLA_34() throws InterruptedException {
        logger.info("testCase_NLA_34");
        objForgotPassWord.sendPasswordInvalid();
    }

    @Test(priority = 3, description = "Forgot password successfully and using Resend code with Mobile")
    public void testCase_NLA_24_25() throws InterruptedException {
        logger.info("testCase_NLA_24_25");
        objForgotPassWord.forgotSuccess();
    }

    @Test(priority = 4, description = "Forgot password and input Phone wrong format")
    public void testCase_NLA_29() throws InterruptedException {
        logger.info("testCase_NLA_29");
        objForgotPassWord.forgotPasswordInvalidInputData("LOGIN_PHONE_NUMBER", "DATA_PHONE_FAIL");
    }

    @Test(priority = 5, description = "Forgot password and input Phone not exist on customer ")
    public void testCase_NLA_30() throws InterruptedException {
        logger.info("testCase_NLA_30");
        objForgotPassWord.forgotPasswordPhoneNotExist();
    }

    @Test(priority = 6, description = " Forgot password and didn't input verify code + Forgot password and input invalid verify code")
    public void testCase_NLA31_NLA32() throws InterruptedException {
        logger.info("testCase_NLA31_NLA32");
        objForgotPassWord.forgotPasswordInvalidCode();
    }

    @Test(priority = 7, description = " TEST LOGIN WHEN FORGOT SUCCESS")
    public void testCase_NLA_TestLOGIN() throws InterruptedException {
        logger.info("testCase_NLA31_NLA32");
//        objForgotPassWord.testLogin();
    }
}

package test;

import core.BaseTest;
import core.LogHelper;
import org.slf4j.Logger;
import org.testng.annotations.Test;
import page.CreateAccountOnWebPage;
import page.ForgotPasswordCheckOutPage;
import page.LoginReturnFormPage;
import page.home.RegisterPage;

public class ForgotPasswordCheckoutMobileTest extends BaseTest {
    private static Logger logger = LogHelper.getLogger();
    private RegisterPage objRegist;
    private LoginReturnFormPage objLoginReturn;
    private ForgotPasswordCheckOutPage objForgotPassWord;
    public CreateAccountOnWebPage objCreateAccount;

    public ForgotPasswordCheckoutMobileTest() {
        super();
        objRegist = new RegisterPage(this.keyword);
        objLoginReturn = new LoginReturnFormPage();
        objCreateAccount = new CreateAccountOnWebPage(this.keyword);
        objForgotPassWord = new ForgotPasswordCheckOutPage();
    }

    public void setup() throws InterruptedException {
//        keyword.scrollToPositionByScript("window.scrollBy(0,300)");
        objRegist.acceptAllCookies();
    }

    @Test(priority = 1, description = "Forgot password and didn't input password")
    public void testCaseMB_NLA_33() throws InterruptedException {
        logger.info("testCase_NLA_33");
        setup();
//        objForgotPassWord.forgotPasswordWithPhone();
        keyword.resizeBrowser(319, 848);
        objForgotPassWord.sendDataPasswordHollow();

    }

    @Test(priority = 2, description = "Forgot password and input invalid password")
    public void testCaseMB_NLA_34() throws InterruptedException {
        logger.info("testCase_NLA_34");
        objForgotPassWord.sendPasswordInvalid();
    }

    @Test(priority = 3, description = "Forgot password successfully and using Resend code with Mobile")
    public void testCaseMB_NLA_24_25() throws InterruptedException {
        logger.info("testCase_NLA_24_25");
        objForgotPassWord.forgotSuccess();
    }

    @Test(priority = 4, description = "Forgot password and input Phone wrong format")
    public void testCaseMB_NLA_29() throws InterruptedException {
        logger.info("testCase_NLA_29");
        objForgotPassWord.forgotPasswordInvalidInputData("LOGIN_PHONE_NUMBER", "DATA_PHONE_FAIL");
    }

    @Test(priority = 5, description = "Forgot password and input Phone not exist on customer ")
    public void testCaseMB_NLA_30() throws InterruptedException {
        logger.info("testCase_NLA_30");
        objForgotPassWord.forgotPasswordPhoneNotExist();
    }

    @Test(priority = 6, description = " Forgot password and didn't input verify code + Forgot password and input invalid verify code")
    public void testCaseMB_NLA_31_NLA_32() throws InterruptedException {
        logger.info("testCase_NLA_31_NLA_32");
        objForgotPassWord.forgotPasswordInvalidCode();
    }
}

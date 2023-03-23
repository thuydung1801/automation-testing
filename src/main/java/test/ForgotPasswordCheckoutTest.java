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

    public ForgotPasswordCheckoutTest() {
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
    public void testCase_LNA33() throws InterruptedException {
        logger.info("testCase_LNA33");
        setup();
        objForgotPassWord.forgotPasswordWithPhone();
        objForgotPassWord.sendDataPasswordHollow();
    }
    @Test(priority = 2, description = "Forgot password and input invalid password")
    public void testCase_LNA34() throws InterruptedException {
        logger.info("testCase_LNA34");
        objForgotPassWord.sendPasswordInvalid();
    }
    @Test(priority = 3, description = "Forgot password successfully and using Resend code with Mobile")
    public void testCase_LNA24_25() throws InterruptedException {
        logger.info("testCase_LNA24_25");
        objForgotPassWord.forgotSuccess();
    }
    @Test(priority = 4, description = "Forgot password and input Phone wrong format")
    public void testCase_LNA29() throws InterruptedException {
        logger.info("testCase_LNA29");
        objForgotPassWord.forgotPasswordInvalidInputData("LOGIN_PHONE_NUMBER", "DATA_PHONE_FAIL");
    }
    @Test(priority = 5, description = "Forgot password and input Phone not exist on customer ")
    public void testCase_LNA30() throws InterruptedException {
        logger.info("testCase_LNA30");
        objForgotPassWord.forgotPasswordPhoneNotExist();
    }
    @Test(priority = 6, description = " Forgot password and didn't input verify code + Forgot password and input invalid verify code")
    public void testCase_LNA31_LNA32() throws InterruptedException {
        logger.info("testCase_LNA31_LNA32");
        objForgotPassWord.forgotPasswordInvalidCode();
    }
}

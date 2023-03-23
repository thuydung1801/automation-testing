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
    @Test(priority = 1, description = "Forgot password successfully and using Resend code with Mobile + Forgot password successfully with Mobile option")
    public void testCase_LNA24_LN25() throws InterruptedException {
        logger.info("testCaseWeb_forgotPassWord");
        setup();
        objForgotPassWord.forgotPasswordSuccess();
    }
    @Test(priority = 2, description = "Forgot password and input Phone wrong format")
    public void testCase_LNA29() throws InterruptedException {
        logger.info("testCase_LNA29");
//        setup();
        objForgotPassWord.forgotPasswordInvalidInputData("LOGIN_PHONE_NUMBER","DATA_PHONE_FAIL");
    }
    @Test(priority = 3, description = "Forgot password and input Phone not exist on customer")
    public void testCase_LNA30() throws InterruptedException {
        logger.info("testCase_LNA30");
//        setup();
        objForgotPassWord.forgotPasswordPhoneNotExist();
    }
}

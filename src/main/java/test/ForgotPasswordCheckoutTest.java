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
    @Test(priority = 22, description = "Forgot password successfully with Email option")
    public void testCase_LNA22() throws InterruptedException {
        logger.info("testCaseWeb_forgotPassWord");
        setup();
        objForgotPassWord.forgotPasswordCheckout();

    }
}

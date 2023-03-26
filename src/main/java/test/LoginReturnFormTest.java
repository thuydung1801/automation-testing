package test;

import core.BaseTest;
import core.LogHelper;
import org.slf4j.Logger;
import org.testng.annotations.Test;
import page.CreateAccountOnMobilePage;
import page.CreateAccountOnWebPage;
import page.LoginReturnFormPage;
import page.home.RegisterPage;

public class LoginReturnFormTest extends BaseTest {
    private static Logger logger = LogHelper.getLogger();
    private RegisterPage objRegist;
    private LoginReturnFormPage objLoginReturn;

    public LoginReturnFormTest() {
        super();
        objRegist = new RegisterPage(this.keyword);
        objLoginReturn = new LoginReturnFormPage();
    }

    public void setUpLogin() throws InterruptedException {
        objRegist.acceptAllCookies();

    }

//            @Test(priority = 1, description = "Submit Return form, login successfully")
//    public void testCase_LS_01() throws InterruptedException {
//        setUpLogin();
//        objLoginReturn.loginSuccess();
//    }

    @Test(priority = 2, description = "Input email or order having space")
    public void testCase_LS_03() throws InterruptedException {
        setUpLogin();
        objLoginReturn.emailHaveSpace();
    }

    @Test(priority = 3, description = "Next step return form, login with password not matching email customer")
    public void testCase_LS_02() throws InterruptedException {
        objLoginReturn.passwordNotMatching();
    }

    @Test(priority = 4, description = "Next step with customer invalid")
    public void testCase_LS_04() throws InterruptedException {
        objLoginReturn.customerDataInvalid("DATA_EMAIL_INVALID", "DATA_EMAIL_FAIL", "EMAIL_ERROR");
    }

    @Test(priority = 5, description = "Next step with customer valid but don't have any order return avaiable")
    public void testCase_LS_05() throws InterruptedException {
        objLoginReturn.customerDataInvalid("DATA_EMAIL_NOT_HAVE_ORDER_RETURN", "MESSAGE_NOT_HAVE_ORDER_RETURN", "RETURN_MESSAGE_CONTENT");
    }

    @Test(priority = 6, description = "Submit Return form, Next step and not input Email")
    public void testCase_LS_06() throws InterruptedException {
        objLoginReturn.customerDataInvalid("DATA_EMAIL_SPACE", "SIGNUP_DATA_VERIFY_MESSAGE", "EMAIL_ERROR");
    }

    @Test(priority = 7, description = " loginSuccess Return order with the order > 60days")
    public void testCase_LS_01() throws InterruptedException {
        objLoginReturn.loginSuccess();
    }
}

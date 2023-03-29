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

    @Test(priority = 1, description = "Next step with customer invalid")
    public void testCase_LS_04() throws InterruptedException {
        setUpLogin();
        objLoginReturn.goToFormLoginReturn();
        objLoginReturn.dataFormLoginReturnForm("DATA_EMAIL_INVALID", "", true, "DATA_EMAIL_FAIL", "EMAIL_ERROR");
    }

    @Test(priority = 2, description = "Next step with customer valid but don't have any order return avaiable")
    public void testCase_LS_05() throws InterruptedException {
        objLoginReturn.dataFormLoginReturnForm("DATA_EMAIL_NOT_HAVE_ORDER_RETURN", "", true, "MESSAGE_NOT_HAVE_ORDER_RETURN", "RETURN_MESSAGE_CONTENT");
    }

    @Test(priority = 3, description = "Submit Return form, Next step and not input Email")
    public void testCase_LS_06() throws InterruptedException {
        objLoginReturn.dataFormLoginReturnForm("", "", true, "SIGNUP_DATA_VERIFY_MESSAGE", "EMAIL_ERROR");
    }
    @Test(priority = 4, description = "Next step return form, login with password not matching email customer")
    public void testCase_LS_02() throws InterruptedException {
        objLoginReturn.dataFormLoginReturnForm("DATA_EMAIL_RETURN", "REGIST_DATA_PASSWORD", false, "LA_MESSAGE_INVALID_LOGIN", "MESSAGE_FAIL_RETURN_FORM");
    }

    @Test(priority = 5, description = "Submit Return form, login successfully + Input email or order having space")
    public void testCase_LS_01_03() throws InterruptedException {
        objLoginReturn.dataFormLoginReturnForm("DATA_EMAIL_RETURN", "DATA_PASSWORD_LOGIN_RETURN", false, "DATA_LABLE", "STEP_LABLE");
    }

//    @Test(priority = 6, description = "The order having order date before >60days")
    public void testCase_LS_07() throws InterruptedException {
        setUpLogin();
        objLoginReturn.goToFormLoginReturn();
        objLoginReturn.orderDate("DATA_EMAIL_RETURN2","DATA_PASSWORD_LOGIN_RETURN","CHECK_WITHDRAWAL","OPTION_RESIZE");
    }
    @Test(priority = 7, description = "Return order with the order haven't the item avaiable resizing")
    public void testCase_LS_08() throws InterruptedException {
        setUpLogin();
        objLoginReturn.goToFormLoginReturn();
        objLoginReturn.orderDate("EMAIL_RETURN_LOGIN_NOT_RESIZE","DATA_PASSWORD_LOGIN_RETURN","OPTION_RESIZE","CHECK_WITHDRAWAL");
    }
}

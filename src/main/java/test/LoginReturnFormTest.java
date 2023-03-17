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

    @Test(priority = 1, description = "Submit Return form, login successfully")
    public void testCase_LS_01() throws InterruptedException {
        setUpLogin();
        objLoginReturn.loginSuccess();
    }
}

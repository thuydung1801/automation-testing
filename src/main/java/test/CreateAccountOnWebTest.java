package test;

import core.BaseTest;
import core.LogHelper;
import org.slf4j.Logger;
import org.testng.annotations.Test;
import page.CreateAccountOnWebPage;
import page.home.LoginPage;
import page.home.RegisterPage;

public class CreateAccountOnWebTest extends BaseTest {
    private static Logger logger = LogHelper.getLogger();
    private LoginPage objLogin;
    private RegisterPage objRegist;
    private CreateAccountOnWebPage objCreateAccOnWeb;

    public CreateAccountOnWebTest() {
        super();
        objCreateAccOnWeb = new CreateAccountOnWebPage(this.keyword);
        objRegist = new RegisterPage(this.keyword);
    }
    public void installation() throws Exception {
        objRegist.acceptAllCookies();
    }

    @Test(priority = 1, description = "Create new customer successfully with store enable email confirm")
    public void testCase_CreateAccount() throws Exception {
        logger.info("testCase_CreateAccount");
        installation();
        objCreateAccOnWeb.CreateNewCustomerSuccessfully();
    }

    @Test(priority = 2, description = "forgot password")
    public void testCase_forgotPassWord() throws Exception {
        logger.info("testCase_forGotPassWord");
        objCreateAccOnWeb.forgotPassword();
    }

    @Test(priority = 3, description = "forgot password - checkOut")
    public void testCase_forgotPassWordCheckOut() throws Exception {
        logger.info("testCase_forgotPassWordCheckOut");
        objCreateAccOnWeb.forgotPasswordCheckOut();
    }
//  ------------------------------- WITH PHONE--------------------------
@Test(priority = 1, description = "Create new customer successfully with store enable phone confirm")
public void testCase_CreateAccountWithPhone() throws Exception {
    logger.info("testCase_CreateAccountWithPhone");
    installation();
    objCreateAccOnWeb.CreateNewCustomerSuccessfully();
}


}

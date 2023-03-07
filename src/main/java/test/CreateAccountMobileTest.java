package test;

import core.BaseTest;
import core.LogHelper;
import org.slf4j.Logger;
import org.testng.annotations.Test;
import page.CreateAccountOnMobilePage;
import page.home.RegisterPage;

public class CreateAccountMobileTest extends BaseTest {
    private static Logger logger = LogHelper.getLogger();
    private RegisterPage objRegist;
    private CreateAccountOnMobilePage objCreateAccountMobile;
    private CreateAccountOnWebTest objCreateAccountOnWeb;
    public CreateAccountMobileTest() {
        super();
        objCreateAccountMobile = new CreateAccountOnMobilePage(this.keyword);
        objCreateAccountOnWeb = new CreateAccountOnWebTest();
    }
    @Test(priority = 1, description = "Create new customer successfully with store enable email confirm")
    public void testCaseMb_CreateAccount() throws Exception {
        logger.info("testCase_CreateAccount");
        objRegist.acceptAllCookies();
        objCreateAccountMobile.CreateNewCustomerSuccessfully();
    }

    @Test(priority = 2, description = "forgot password")
    public void testCaseMb_forgotPassWord() throws Exception {
        logger.info("testCase_forGotPassWord");
        keyword.resizeBrowser(319, 848);
        objCreateAccountMobile.forgotPassword();
    }

    @Test(priority = 3, description = "forgot password - checkOut")
    public void testCaseMb_forgotPassWordCheckOut() throws Exception {
        logger.info("testCase_forGotPassWordCheckOut");
        objCreateAccountMobile.forgotPasswordCheckOut();
    }
}

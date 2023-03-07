package test;

import core.BaseTest;
import core.LogHelper;
import org.slf4j.Logger;
import org.testng.annotations.Test;
import page.CreateAccountMobilePage;
import page.CreateAccountOnStagePage;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignUpPage;

public class CreateAccountMobileTest extends BaseTest {
    private static Logger logger = LogHelper.getLogger();
    private RegisterPage objRegist;
    private CreateAccountMobilePage objCreateAccountMobile;
    private CreateAccountOnStageTest objCreateAccountOnWeb;
    public CreateAccountMobileTest() {
        super();
        objCreateAccountMobile = new CreateAccountMobilePage(this.keyword);
        objCreateAccountOnWeb = new CreateAccountOnStageTest();
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

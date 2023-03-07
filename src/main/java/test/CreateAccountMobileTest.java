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
    private LoginPage objLogin;
    private RegisterPage objRegist;
    private CreateAccountMobilePage objCreateAccMobile;
    private CreateAccountOnStageTest objCreateAccStage;
    private CreateAccountOnStagePage objCreateAccStagePage;
    private SignUpPage objSigUp;

    public CreateAccountMobileTest() {
        super();
        objCreateAccMobile = new CreateAccountMobilePage(this.keyword);
        objCreateAccStage = new CreateAccountOnStageTest();
        objCreateAccStagePage = new CreateAccountOnStagePage(this.keyword);
    }

    @Test(priority = 1, description = "Create new customer successfully with store enable email confirm")
    public void testCaseMb_CreateAccount() throws Exception {
        logger.info("testCase_CreateAccount");
        objCreateAccStage.installation();
        objCreateAccMobile.CreateNewCustomerSuccessfully();
    }

    @Test(priority = 2, description = "forgot password")
    public void testCaseMb_forgotPassWord() throws Exception {
        logger.info("testCase_forGotPassWord");
        keyword.resizeBrowser(319, 848);
        objCreateAccMobile.forgotPassWord();
    }

    @Test(priority = 3, description = "forgot password - checkOut")
    public void testCaseMb_forgotPassWordCheckOut() throws Exception {
        logger.info("testCase_forGotPassWordCheckOut");
        objCreateAccMobile.forgotPassWordCheckOut();
    }
}

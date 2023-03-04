package test;

import core.BaseTest;
import core.KeywordWeb;
import core.LogHelper;
import org.slf4j.Logger;
import org.testng.annotations.Test;
import page.CreateAccountOnStagePage;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignUpPage;

public class CreateAccountOnStageTest extends BaseTest {
    private static Logger logger = LogHelper.getLogger();
    private LoginPage objLogin;
    private RegisterPage objRegist;
    private CreateAccountOnStagePage objCreateAcc;
    private SignUpPage objSigUp;

    public CreateAccountOnStageTest() {
        super();
    }


    @Test(priority = 1, description = "Create new customer successfully with store enable email confirm")
    public void testCase_CreateAccount() throws Exception {
        logger.info("testCase_CreateAccount");
        objRegist = new RegisterPage(this.keyword);
        objSigUp = new SignUpPage(this.keyword);
        objCreateAcc = new CreateAccountOnStagePage(this.keyword);
        objSigUp.navigateToUrlPage("https://stage.glamira.co.uk/");
        keyword.untilJqueryIsDone(50L);
        keyword.scrollToPosition();
        objRegist.acceptAllCookies();
        objCreateAcc.CreateNewCustomerSuccessfully();
    }
    @Test(priority = 2, description = "forgot password")
    public void testCase_forgotPassWord() throws Exception {
        logger.info("testCase_forGotPassWord");
        objCreateAcc.forGotPassWord();
    }
    @Test(priority = 3, description = "forgot password - checkOut")
    public void testCase_forgotPassWordCheckOut() throws Exception {
        logger.info("testCase_forgotPassWordCheckOut");
        objCreateAcc.forgotPassWordCheckOut();
    }
}

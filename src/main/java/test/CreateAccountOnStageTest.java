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
    public void testCase_SU01() throws Exception {
        logger.info("testCase_SU05");
        objLogin = new LoginPage(this.keyword);
        objRegist = new RegisterPage(this.keyword);
        objSigUp = new SignUpPage(this.keyword);
        objCreateAcc = new CreateAccountOnStagePage(this.keyword);
        objSigUp.navigateToUrlPage("https://stage.glamira.co.uk/");
        keyword.untilJqueryIsDone(50L);
        keyword.scrollToPosition();
        Thread.sleep(2000);
//        objRegist.chooseLanguages();
        objRegist.acceptAllCookies();
        objCreateAcc.CreateNewCustomerSuccessfully();
    }
}

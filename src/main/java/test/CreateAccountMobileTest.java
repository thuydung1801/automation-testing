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
    private SignUpPage objSigUp;

    public CreateAccountMobileTest() {
        super();
    }

    @Test(priority = 1, description = "Create new customer successfully with store enable email confirm")
    public void testCaseMb_CreateAccount() throws Exception {
        logger.info("testCase_CreateAccount");
        objLogin = new LoginPage(this.keyword);
        objRegist = new RegisterPage(this.keyword);
        objSigUp = new SignUpPage(this.keyword);
        objCreateAccMobile = new CreateAccountMobilePage(this.keyword);
        keyword.navigateToUrl("https://stage.glamira.co.uk/");
        keyword.scrollToPosition();
        objRegist.acceptAllCookies();
        objCreateAccMobile.CreateNewCustomerSuccessfully();
    }

    @Test(priority = 2, description = "forgot password")
    public void testCaseMb_forgotPassWord() throws Exception {
        logger.info("testCase_forGotPassWord");
        objCreateAccMobile.forGotPassWord();
    }

    @Test(priority = 3, description = "forgot password - checkOut")
    public void testCaseMb_forgotPassWordCheckOut() throws Exception {
        logger.info("testCase_forGotPassWordCheckOut");
        objLogin = new LoginPage(this.keyword);
        objRegist = new RegisterPage(this.keyword);
        objSigUp = new SignUpPage(this.keyword);
        objCreateAccMobile.forGotPassWordCheckOut();
    }
}

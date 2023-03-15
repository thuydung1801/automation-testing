package test;

import core.BaseTest;
import core.LogHelper;
import org.slf4j.Logger;
import org.testng.annotations.Test;
import page.CreateAccountOnMobilePage;
import page.CreateAccountOnWebPage;
import page.home.RegisterPage;

public class CreateAccountMobileTest extends BaseTest {
    private static Logger logger = LogHelper.getLogger();
    private RegisterPage objRegist;
    private CreateAccountOnMobilePage objCreateAccountMobile;
    private CreateAccountOnWebTest objCreateAccountOnWeb;
    private CreateAccountOnWebPage CreateAccountOnWeb;

    public CreateAccountMobileTest() {
        super();
        objCreateAccountMobile = new CreateAccountOnMobilePage(this.keyword);
        objCreateAccountOnWeb = new CreateAccountOnWebTest();
        CreateAccountOnWeb = new CreateAccountOnWebPage(this.keyword);
        objRegist = new RegisterPage(this.keyword);
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
        objCreateAccountMobile.forgotPasswordCheckOut("URL_BE_DEV3");
    }

    //    -------Mobile
    @Test(priority = 4, description = "Create new customer successfully with store enable email confirm")
    public void testCaseMbPhone_CreateAccount() throws Exception {
        logger.info("testCaseMbPhone_CreateAccount");
        objCreateAccountMobile.CreateNewCustomerWithPhone();
    }

    @Test(priority = 5, description = "forgot password")
    public void testCaseMBPhone_forgotPassWord() throws Exception {
        logger.info("testCase_forGotPassWord");
        keyword.resizeBrowser(319, 848);
        CreateAccountOnWeb.forgotPasswordPhone();
    }

    @Test(priority = 6, description = "Login")
    public void testCaseWithPhone_login() throws Exception {
        logger.info("testCaseWithPhone_login");
        keyword.resizeBrowser(319, 848);
        objCreateAccountMobile.LoginSuccessWithPhone("DATA_CREATE_ACCOUNT_WITH_PHONE", "PASS_NEW_RD");
    }

}

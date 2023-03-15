package test;

import core.BaseTest;
import core.LogHelper;
import org.slf4j.Logger;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.CreateAccountOnWebPage;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignUpPage;

public class CreateAccountOnWebTest extends BaseTest {
    private static Logger logger = LogHelper.getLogger();
    private SignUpPage objSignUp;
    private RegisterPage objRegist;
    private CreateAccountOnWebPage objCreateAccOnWeb;
    public CreateAccountOnWebTest() {
        super();
        objCreateAccOnWeb = new CreateAccountOnWebPage(this.keyword);
        objRegist = new RegisterPage(this.keyword);
        objSignUp = new SignUpPage(this.keyword);
    }

    public void installation() throws Exception {
        objRegist.acceptAllCookies();
    }

    //    @Test(priority = 1, description = "Create new customer successfully with store enable email confirm")
    public void testCase_CreateAccount() throws Exception {
        logger.info("testCase_CreateAccount");
        installation();
        objCreateAccOnWeb.CreateNewCustomerSuccessfully();
    }

    //    @Test(priority = 2, description = "forgot password")
    public void testCase_forgotPassWord() throws Exception {
        logger.info("testCase_forGotPassWord");
        objCreateAccOnWeb.forgotPassword("URL_BE_DEV3");
    }

    //    @Test(priority = 3, description = "forgot password - checkOut")
    public void testCase_forgotPassWordCheckOut() throws Exception {
        logger.info("testCase_forgotPassWordCheckOut");
        objCreateAccOnWeb.forgotPasswordCheckOut("URL_DATA_PRODUCT", "URL_BE_DEV3");
    }

    //  ------------------------------- WITH PHONE--------------------------
    @Test(priority = 4, description = "Create new customer successfully with store enable phone confirm")
//    @Parameters("baseURL")
    public void testCaseWithPhon_CreateAccount() throws Exception {
        logger.info("testCaseWithPhon_CreateAccount");
        installation();
        objCreateAccOnWeb.CreateNewCustomerWithPhone();
    }

    @Test(priority = 5, description = "forgot password")
    public void testCaseWithPhone_forgotPassWord() throws Exception {
        logger.info("testCaseWithPhone_forgotPassWord");
        objCreateAccOnWeb.forgotPasswordPhone();
    }

    @Test(priority = 6, description = "forgot password - checkOut")
    public void testCaseWithPhone_forgotPassWordCheckOut() throws Exception {
        logger.info("testCase_forgotPassWordCheckOut");
        objCreateAccOnWeb.forgotPasswordCheckOut("URL_DATA_PRODUCT", "URL_BE_DEV3");
    }

}


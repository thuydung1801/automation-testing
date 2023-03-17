package test;

import core.BaseTest;
import core.LogHelper;
import org.slf4j.Logger;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.CreateAccountOnWebPage;
import page.MyAccountPage;
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
    public void testCaseWeb_CreateAccount() throws Exception {
        logger.info("testCaseWeb_CreateAccount");
        installation();
        objCreateAccOnWeb.CreateNewCustomerSuccessfully();
    }

//    @Test(priority = 2, description = "forgot password")
    public void testCaseWeb_forgotPassWord() throws Exception {
        logger.info("testCaseWeb_forgotPassWord");
        objCreateAccOnWeb.forgotPassword("URL_BE_DEV3");
    }

//    @Test(priority = 3, description = "forgot password - checkOut")
    public void testCaseWeb_forgotPassWordCheckOut() throws Exception {
        logger.info("testCaseWeb_forgotPassWordCheckOut");
        objCreateAccOnWeb.forgotPasswordCheckOut("URL_DATA_PRODUCT", "URL_BE_DEV3");
    }
    //  ------------------------------- WITH PHONE--------------------------
    @Test(priority = 4, description = "Create new customer successfully with store enable phone confirm")
//    @Parameters("baseURL")
    public void testWebPhone_CreateAccount() throws Exception {
        logger.info("testWebPhone_CreateAccount");
        installation();
        objCreateAccOnWeb.createNewCustomerWithPhone();
    }

    @Test(priority = 5, description = "forgot password")
    public void testWebPhone_forgotPassWord() throws Exception {
        logger.info("testWebPhone_forgotPassWord");
        objCreateAccOnWeb.forgotPasswordPhone();
    }

    @Test(priority = 6, description = "Login")
    public void testWebPhone_loginWeb() throws Exception {
        logger.info("testWebPhone_loginWeb");
        objCreateAccOnWeb.loginSuccess();
    }

}


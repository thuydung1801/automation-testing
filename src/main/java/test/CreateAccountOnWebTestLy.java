package test;

import core.BaseTest;
import core.LogHelper;
import org.slf4j.Logger;
import org.testng.annotations.Test;
import page.CreateAccountOnWebPageLy;
import page.checkout.ShoppingBagPage;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;
import page.signinSignup.SignUpPage;

public class CreateAccountOnWebTestLy extends BaseTest {
    private static Logger logger = LogHelper.getLogger();

    private LoginPage objLogin;

    public SignInPage objSignIn;
    private RegisterPage objRegist;
    private CreateAccountOnWebPageLy objCreateAccOnWeb;

    public CreateAccountOnWebTestLy() {
        super();
    }

    public void commonShopping() throws InterruptedException {
        objCreateAccOnWeb = new CreateAccountOnWebPageLy(this.keyword);
        objLogin = new LoginPage(this.keyword);
        objRegist = new RegisterPage(this.keyword);
        objSignIn = new SignInPage(this.keyword);
        //objLogin.loginOnAlert();
        objRegist.acceptAllCookies();
        //objRegist.chooseLanguages();
    }

    @Test(priority = 1, description = "Create new customer successfully with store enable email confirm")
    public void testCaseWeb_CreateAccount() throws Exception {
        logger.info("testCaseWeb_CreateAccount");
        commonShopping();
        objCreateAccOnWeb.CreateNewCustomerSuccessfully();
    }

    @Test(priority = 2, description = "forgot password")
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

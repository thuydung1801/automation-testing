package test;

import core.BaseTest;
import core.LogHelper;
import org.slf4j.Logger;
import org.testng.annotations.Test;
import page.CreateAccountOnWebPageLy;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;

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
        objRegist.acceptAllCookies();
    }

    @Test(priority = 2, description = "Create new customer successfully")
    public void testCaseWeb_CreateAccount() throws Exception {
        logger.info("testCaseWeb_CreateAccount");
        commonShopping();
        objCreateAccOnWeb.goToFormCreateAccount();
        objCreateAccOnWeb.inputDataLogin();
        objCreateAccOnWeb.getCodeVerifyAccountNew();
    }

    @Test(priority = 1, description = "forgot password")
    public void testCaseWeb_forgotPassWord() throws Exception {
        logger.info("testCaseWeb_forgotPassWord");
        commonShopping();
        objCreateAccOnWeb.goToFormForgotPassword();
        objCreateAccOnWeb.inputEmailForgotPassword();
        objCreateAccOnWeb.getCodeVerifyAccount();
    }

        @Test(priority = 3, description = "changeEmail")
    public void testCaseWeb_changeEmail() throws Exception {
        logger.info("testCaseWeb_changeEmail");
        //objCreateAccOnWeb.forgotPasswordCheckOut("URL_DATA_PRODUCT", "URL_BE_DEV3");
    }



}

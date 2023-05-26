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
        objCreateAccOnWeb.inputDataLogin("SIGNUP_DATA_FIRST_NAME_INFORMATION2","SIGNUP_DATA_LAST_NAME_INFORMATION2",
                "SIGNUP_EMAIL_EXIST2","SIGNUP_PASSWORD_EXIST2","SIGNUP_NAME_COUNTRY");
        objCreateAccOnWeb.getCodeVerifyAccountNew("URL_BE_STAGE","LOGIN_DATA_USER_NAME_LY","LOGIN_DATA_PASSWORD_LY");
    }

    @Test(priority = 1, description = "forgot password")
    public void testCaseWeb_forgotPassWord() throws Exception {
        logger.info("testCaseWeb_forgotPassWord");
        commonShopping();
        objCreateAccOnWeb.goToFormForgotPassword();
        objCreateAccOnWeb.inputEmailForgotPassword("SIGNUP_EMAIL_EXIST2");
        objCreateAccOnWeb.getCodeVerifyAccount("URL_BE_STAGE","LOGIN_DATA_USER_NAME_LY","LOGIN_DATA_PASSWORD_LY");
        objCreateAccOnWeb.inputPasswordNew("SIGNUP_PASSWORD_EXIST2");
    }

    @Test(priority = 3, description = "changePassword")
    public void testCaseWeb_changePassword() throws Exception {
        logger.info("testCaseWeb_changePassword");
        objCreateAccOnWeb.goToFormChangePassword();
        objCreateAccOnWeb.changePassword("SIGNUP_PASSWORD_EXIST2","SIGNUP_PASSWORD_EXIST2");
    }



}

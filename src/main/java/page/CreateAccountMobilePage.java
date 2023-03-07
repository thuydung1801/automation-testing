package page;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import org.slf4j.Logger;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;
import page.signinSignup.SignUpPage;

import java.util.Date;

public class CreateAccountMobilePage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private SignUpPage objSignUp;
    private RegisterPage objRegist;
    private SignInPage objSignIn;
    private CreateAccountOnStagePage objCreateAccount;

    public CreateAccountMobilePage(KeywordWeb key) {
        super(key);
        objCreateAccount = new CreateAccountOnStagePage(this.keyword);
        objSignIn = new SignInPage(this.keyword);
        objRegist = new RegisterPage(this.keyword);
    }

    public void CreateNewCustomerSuccessfully() throws Exception {
        keyword.untilJqueryIsDone(50L);
        keyword.scrollDownToElement("LOGIN_MENULEFT");
        keyword.untilJqueryIsDone(50L);
        keyword.click("LOGIN_MENULEFT");
        keyword.untilJqueryIsDone(50L);
        keyword.click("MOBILE_BTN_LOGIN");
        keyword.untilJqueryIsDone(50L);
        objCreateAccount.aa();
    }

    public void forgotPassWord() throws Exception {
        objCreateAccount.setUpFormForgot();
        objCreateAccount.sendData();
        keyword.resizeBrowser(319, 848);
        keyword.assertEquals("SIGNIN_UPDATE_PASSWORD_SUCCESS", "LOGIN_MESSAGE_RESET_PASSWORD_SUCCESS");
    }

    public void forgotPasswordCheckOut() throws Exception {
        objCreateAccount.setupForgot("https://stage.glamira.co.uk/glamira-pendant-elsie.html?alloy=red_white-585&stone1=diamond-Brillan");
        objCreateAccount.sendData();
        keyword.resizeBrowser(319, 848);
        keyword.verifyElementVisible("SIGNIN_VERIFY_SUCCESS_SIGNIN_FORM");
    }
}

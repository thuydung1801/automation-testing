package page;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import org.slf4j.Logger;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;
import page.signinSignup.SignUpPage;

public class CreateAccountOnMobilePage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private SignUpPage objSignUp;
    private SignInPage objSignIn;
    private CreateAccountOnWebPage objCreateAccount;

    public CreateAccountOnMobilePage(KeywordWeb key) {
        super(key);
        objCreateAccount = new CreateAccountOnWebPage(this.keyword);
        objSignIn = new SignInPage(this.keyword);
    }

    public void CreateNewCustomerSuccessfully() throws Exception {
        selectMenu();
        objCreateAccount.createAndVerifyForm();
    }

    public void selectMenu() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.scrollDownToElement("LOGIN_MENULEFT");
        keyword.untilJqueryIsDone(50L);
        keyword.click("LOGIN_MENULEFT");
        keyword.untilJqueryIsDone(50L);
        keyword.click("MOBILE_BTN_LOGIN");
        keyword.untilJqueryIsDone(50L);
    }

    public void forgotPassword() throws Exception {
        objCreateAccount.setUpFormForgot();
        objCreateAccount.sendData("URL_BE_DEV3");
        keyword.resizeBrowser(319, 848);
        keyword.assertEquals("SIGNIN_UPDATE_PASSWORD_SUCCESS", "LOGIN_MESSAGE_RESET_PASSWORD_SUCCESS");
    }

    public void forgotPasswordCheckOut(String dataURL) throws Exception {
        objCreateAccount.setupForgot("https://stage.glamira.co.uk/glamira-pendant-elsie.html?alloy=red_white-585&stone1=diamond-Brillan");
        objCreateAccount.sendData(dataURL);
        keyword.resizeBrowser(319, 848);
        keyword.verifyElementVisible("SIGNIN_VERIFY_SUCCESS_SIGNIN_FORM");
    }
    public void CreateNewCustomerWithPhone() throws Exception {
        selectMenu();
        objCreateAccount.CreateNewCustomerWithPhone();
    }
    public void LoginSuccessWithPhone(String phone, String phonePassword) throws InterruptedException {
        selectMenu();
        keyword.sendKeys("LOGIN_TBX_PHONE_2", phone);
        Thread.sleep(2000);
        keyword.sendKeys("LOGIN_TXT_PASSWORD", phonePassword);
        keyword.untilJqueryIsDone(50L);
        keyword.verifyElementVisible("MAC_VERIFY_NAME");
    }

}

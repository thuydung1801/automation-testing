package page;

import core.BasePage;
import core.LogHelper;
import org.slf4j.Logger;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;

public class LoginReturnFormPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private LoginPage objLogin;
    private RegisterPage objRegister;
    private LoginPage loginPage;
    public SignInPage signInPage;

    public LoginReturnFormPage() {
        super();
    }
    public void loginSuccess() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
        keyword.click("LOGIN_RETURN_FORM_BTN_RETURN");
        keyword.untilJqueryIsDone(50L);
        keyword.verifyElementVisible("MENU_LEFT_RETURN_FORM");
        keyword.click("BTN_RETURN_FORM");
        keyword.untilJqueryIsDone(50L);
    }
}

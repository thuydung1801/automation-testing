package page.signinSignup;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import org.slf4j.Logger;
import page.home.LoginPage;
import page.home.RegisterPage;

import java.util.Date;

public class SignInMobilePage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private SignInPage objSignIn;
    private RegisterPage objRegist;

    public SignInMobilePage() {
        super();
    }
    public SignInMobilePage(KeywordWeb key) {
        super(key);
    }
    public void checkGoToFormLoginWithEmail() throws InterruptedException {
        objSignIn = new SignInPage(this.keyword);
        keyword.untilJqueryIsDone(50L);
        keyword.scrollDownToElement("MOBILE_HAMBURGER");
        keyword.click("MOBILE_HAMBURGER");
        keyword.untilJqueryIsDone(50L);
        keyword.click("MOBILE_ICON_SIGNIN");
        keyword.untilJqueryIsDone(50L);
        objSignIn.inputBlankAndVerify("SIGNIN_XPATH_EMAIL_REQUIRED_FIELD",
                "SIGNIN_MESSAGE_REQUIRED_FIELD", "SIGNIN_MESSAGE_REQUIRED_FIELD");
    }
}

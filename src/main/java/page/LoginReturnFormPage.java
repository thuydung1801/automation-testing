package page;

import core.BasePage;
import core.LogHelper;
import io.cucumber.java.hr.Kad;
import org.bouncycastle.asn1.cms.KEKIdentifier;
import org.slf4j.Logger;
import org.testng.Assert;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;

public class LoginReturnFormPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    public SignInPage signInPage;
    public LoginReturnFormPage() {
        super();
    }
    public void loginSuccess() throws InterruptedException {
        keyword.reLoadPage();
        keyword.untilJqueryIsDone(50L);
        keyword.sendKeys("INPUT_EMAIL_FORM", "DATA_EMAIL_RETURN");
        keyword.click("BTN_SUBMIT_RETURN_FORM");
        keyword.untilJqueryIsDone(50L);
        keyword.sendKeys("SIGNUP_PASSWORD_INFORMATION", "DATA_PASSWORD_LOGIN_RETURN");
        keyword.click("BTN_SUBMIT_RETURN_FORM");
        keyword.untilJqueryIsDone(50L);
        keyword.verifyElementVisible("FORM_MY_RETURN");
        keyword.click("BTN_CREATE_RETURN");
        keyword.untilJqueryIsDone(50L);
        keyword.assertEquals("DATA_LABLE", "STEP_LABLE");
    }
    public void emailHaveSpace() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
        keyword.click("LOGIN_RETURN_FORM_BTN_RETURN");
        keyword.untilJqueryIsDone(50L);
        keyword.verifyElementVisible("MENU_LEFT_RETURN_FORM");
        keyword.click("BTN_RETURN_FORM");
        keyword.untilJqueryIsDone(50L);
        keyword.sendKeys("INPUT_EMAIL_FORM", "DATA_EMAIL_RETURN_HAVE_SPACE");
        keyword.click("BTN_SUBMIT_RETURN_FORM");
        keyword.untilJqueryIsDone(50L);
        keyword.verifyElementPresent("SIGNUP_PASSWORD_INFORMATION");
    }

    public void passwordNotMatching() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.sendKeys("SIGNUP_PASSWORD_INFORMATION", "DATA_PASSWORD_LOGIN_RETURN_FAIL");
        keyword.click("BTN_SUBMIT_RETURN_FORM");
        keyword.untilJqueryIsDone(50L);
        keyword.assertEquals("CHECKOUT_LA_DATA_ERROR_PASS", "MESSAGE_FAIL_RETURN_FORM");
    }

    public void customerDataInvalid(String dataEmail, String dataTextFail, String messageContent) throws InterruptedException {
        keyword.reLoadPage();
        keyword.untilJqueryIsDone(50L);
        keyword.sendKeys("INPUT_EMAIL_FORM", dataEmail);
        keyword.click("BTN_SUBMIT_RETURN_FORM");
        keyword.untilJqueryIsDone(50L);
        keyword.untilJqueryIsDone(50L);
        keyword.assertEquals(dataTextFail, messageContent);
    }
}

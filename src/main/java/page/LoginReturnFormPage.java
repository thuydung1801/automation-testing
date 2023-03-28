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

    public void goToFormLoginReturn() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
        keyword.click("LOGIN_RETURN_FORM_BTN_RETURN");
        keyword.untilJqueryIsDone(50L);
        keyword.untilJqueryIsDone(50L);
        keyword.verifyElementVisible("MENU_LEFT_RETURN_FORM");
        keyword.click("BTN_RETURN_FORM");
    }
    public void dataFormLoginReturnForm(String dataEmail, String dataPassword, boolean check, String data, String actual) throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.reLoadPage();
        keyword.untilJqueryIsDone(50L);
        keyword.sendKeys("INPUT_EMAIL_FORM", "  ");
        keyword.sendKeys("INPUT_EMAIL_FORM", dataEmail);
        keyword.click("BTN_SUBMIT_RETURN_FORM");
        keyword.untilJqueryIsDone(50L);
        if (check) {
            keyword.assertEquals(data, actual);
        } else {
            keyword.untilJqueryIsDone(50L);
            keyword.verifyElementVisible("SIGNUP_PASSWORD_INFORMATION");
            keyword.untilJqueryIsDone(20L);
            keyword.sendKeys("SIGNUP_PASSWORD_INFORMATION", dataPassword);
            keyword.click("BTN_SUBMIT_RETURN_FORM");
            keyword.untilJqueryIsDone(50L);
            if (keyword.verifyElementPresent("BTN_CREATE_RETURN")){
                keyword.click("BTN_CREATE_RETURN");
            }
            keyword.assertEquals(data, actual);
        }
    }

}

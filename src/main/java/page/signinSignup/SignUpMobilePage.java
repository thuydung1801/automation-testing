package page.signinSignup;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import org.slf4j.Logger;
import page.home.RegisterPage;

import java.util.Date;

public class SignUpMobilePage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private SignInMobilePage objSignIn;
    private SignUpMobilePage objSigUpMobile;
    private RegisterPage objRegist;

    public SignUpMobilePage(KeywordWeb key) {
        super(key);
    }
    public void navigateToUrlPage(String url) throws InterruptedException {
        keyword.navigateToUrl(url);
    }
    public void goToFormCreateMyAccount() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.scrollDownToElement("LOGIN_MENULEFT");
        keyword.click("LOGIN_MENULEFT");
        keyword.untilJqueryIsDone(50L);
        keyword.click("MOBILE_BTN_LOGIN");
        keyword.untilJqueryIsDone(50L);
        keyword.webDriverWaitForElementPresent("LOGIN_BTN_FORGOT_PASSWORD", 50);
        Thread.sleep(2000);
        keyword.scrollDownToElement("SIGNUP_BTN_CREATE_MY_ACCOUNT");
        keyword.untilJqueryIsDone(50L);
        keyword.click("SIGNUP_BTN_CREATE_MY_ACCOUNT");
        keyword.webDriverWaitForElementPresent("SIGNUP_FORM_DATA_INFORMATION", 500);
    }
    public void clearTextAndSendKey(String clearText, String inputSendKey, String dataSendKey) throws InterruptedException {
        keyword.clearText(clearText);
        keyword.sendKeys(inputSendKey, dataSendKey);
    }
    // sendKey full data form information (not click check box agree) ( form 2/3- pasWord)
    public void sendKeyFullDataFormPasswordInformation(String inputPassword, String password, String selectTitle, String selectOneOptionTitle) throws InterruptedException {
        keyword.sendKeys(inputPassword, password);
        keyword.untilJqueryIsDone(30L);
        if (checkElement(selectTitle)) {
            keyword.click(selectTitle);
//            keyword.checkStatusIsDisplay(selectOneOptionTitle);
            keyword.click(selectOneOptionTitle);
            keyword.click("SIGNUP_XPATH_FOR_FORM");
            keyword.click("SIGNUP_CHECKBOX_AGREE");
        } else {
            keyword.click("SIGNUP_XPATH_FOR_FORM");
            keyword.click("SIGNUP_CHECKBOX_AGREE");
        }
    }
    //Create an account with the same password as the register email
    public void enterPasswordSameEmail() throws InterruptedException {
        clearTextAndSendKey("SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_DATA_EMAIL_NEW_INFORMATION");
        keyword.untilJqueryIsDone(10L);
        keyword.click("SIGNUP_XPATH_FOR_FORM");
        keyword.click("SIGNUP_BTN_NEXT_STEEP");
        keyword.untilJqueryIsDone(50L);
        keyword.clearText("SIGNUP_PASSWORD_INFORMATION");
        sendKeyFullDataFormPasswordInformation("SIGNUP_PASSWORD_INFORMATION",
                "SIGNUP_DATA_EMAIL_NEW_INFORMATION", "SIGNUP_SELECT_TITLE",
                "SIGNUP_SELECT_OPTION_TITLE");
        keyword.click("SIGNUP_BTN_CREATE_ACCOUNT");
        keyword.untilJqueryIsDone(50L);
        Thread.sleep(2000);
        keyword.assertEquals("SIGNUP_MESSAGE_PASSWORD_NOT_SAME_MAIL", "SIGNIN_MESSAGE_DATA_EXIST");
    }
    public boolean checkElement(String checkElement) {
        return keyword.verifyElementVisible(checkElement);
    }
}

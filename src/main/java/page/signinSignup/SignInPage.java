package page.signinSignup;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;

public class SignInPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    public SignInPage(KeywordWeb key) {
        super(key);
    }
    // Go to the login form and use the forgot password function
    public void goToFormLoginAndEnterDataForGotPassWord() throws InterruptedException {
        keyword.click("LOGIN_BTN_LOGIN");
        keyword.webDriverWaitForElementPresent("LOGIN_BTN_FORGOT_PASSWORD", 20);
        Thread.sleep(2000);
        keyword.click("LOGIN_BTN_FORGOT_PASSWORD");
        keyword.webDriverWaitForElementPresent("LOGIN_BOX_FORGOT_PASSWORD", 20);
        keyword.sendKeys("LOGIN_INPUT_FORGOT_PASSWORD", "LOGIN_DATA_EMAIL_FORGOT_PASSWORD");
        keyword.click("LOGIN_BTN_SUBMIT_FORGOT_PASSWORD");
        keyword.webDriverWaitForElementPresent("LOGIN_BOX_ENTER_CODE_FORGOT_PASSWORD", 20);
    }
    // open new right tabs
    public void openNewTabs() throws InterruptedException {
        keyword.executeJavaScript("window.open()");
        keyword.switchToTab(1);
        keyword.navigateToUrl("LOGIN_URL_BACKEND");
        keyword.webDriverWaitForElementPresent("LOGIN_FORM_LOGIN_BACKEND", 20);
    }

    //login admin BackEnd (shared functions)
    public void loginAdmin(String userName, String passWord) throws InterruptedException {
        keyword.sendKeys("LOGIN_FORM_USER_NAME_BACKEND", userName);
        keyword.sendKeys("LOGIN_FORM_PASSWORD_BACKEND", passWord);
        keyword.click("LOGIN_FORM_BTN_SUBMIT_BACKEND");
        keyword.webDriverWaitForElementPresent("LOGIN_BTN_CUSTOMER", 20);
        keyword.scrollDownToElement("LOGIN_BTN_CUSTOMER");
        keyword.click("LOGIN_BTN_CUSTOMER");
        keyword.webDriverWaitForElementPresent("LOGIN_FORM_CSTOMER", 20);
        Thread.sleep(2000);
        keyword.click("LOGIN_BTN_EMAIL_LOG");
        keyword.webDriverWaitForElementPresent("LOGIN_HEADER_EMAIL_LOG", 20);
    }
    // Select Action Email Log
    public void selectActionEmailLog(String selectAction, String verifySelectForm, String selectView, String verifyForm) throws InterruptedException {
        keyword.imWait(30);
        keyword.click(selectAction);
        keyword.webDriverWaitForElementPresent(verifySelectForm, 20);
        keyword.click(selectView);
        keyword.webDriverWaitForElementPresent(verifyForm, 20);
    }
    // Get text and Enter the copy data -> switch to first tabs
    public void enterTextInField() throws Exception {
        keyword.imWait(10);
        keyword.switchToIFrameByXpath("LOGIN_IFRAME");
        String text = keyword.getText("LOGIN_INPUT_VERIFY_CODE");
        keyword.switchToTab(0);
        keyword.sendKeys("LOGIN_INPUT_ENTER_DATA", text);
        System.out.println("value copied");
        keyword.click("LOGIN_BTN_SUBMIT_CODE");
    }
    // Create new password for entering and to use your account
    public  void createNewPassWord() throws InterruptedException {

    }
}

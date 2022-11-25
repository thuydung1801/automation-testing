package page.signinSignup;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import org.slf4j.Logger;

public class SignInPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    public SignInPage(KeywordWeb key) {
        super(key);
    }
    public SignInPage() {
        super();
    }
    // Go to the login form and use the forgot password function (with Email)
    public void goToFormLoginAndEnterDataForGotPassWord() throws InterruptedException {
        keyword.click("LOGIN_BTN_LOGIN");
        keyword.webDriverWaitForElementPresent("LOGIN_BTN_FORGOT_PASSWORD", 20);
        Thread.sleep(2000);
        keyword.click("LOGIN_BTN_FORGOT_PASSWORD");
        if (checkStore("LOGIN_INPUT_FORGOT_PASSWORD")) {
            keyword.webDriverWaitForElementPresent("LOGIN_BOX_FORGOT_PASSWORD", 20);
            keyword.sendKeys("LOGIN_INPUT_FORGOT_PASSWORD", "LOGIN_DATA_EMAIL_FORGOT_PASSWORD");
            keyword.click("LOGIN_BTN_SUBMIT_FORGOT_PASSWORD");
            keyword.webDriverWaitForElementPresent("LOGIN_BOX_ENTER_CODE_FORGOT_PASSWORD", 20);
        } else {
            keyword.sendKeys("LOGIN_PHONE_NUMBER", "LOGIN_DATA_PHONE_FORGOT_PASSWORD");
        }
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
    }
    //go to section customer after login admin BE.
    public void chooseItemCustomer(String scrollToElement, String clickItem, String verifyItem, String clickItemSub, String verifyItemSub) throws InterruptedException {
        keyword.imWait(3);
        keyword.scrollToPosition();
        keyword.scrollDownToElement(scrollToElement);
        keyword.click(clickItem);
        keyword.webDriverWaitForElementPresent(verifyItem, 20);
        Thread.sleep(2000);
        keyword.click(clickItemSub);
        keyword.webDriverWaitForElementPresent(verifyItemSub, 20);
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
    public void getCodeEnterTextInField(String iframe, String getTextInPutVerify, String dataInput, String btnSubmit) throws Exception {
        keyword.imWait(10);
        keyword.switchToIFrameByXpath(iframe);
        String text = keyword.getText(getTextInPutVerify);
        keyword.switchToTab(0);
        keyword.sendKeys(dataInput, text);
        System.out.println("value copied");
        keyword.click(btnSubmit);
    }
    // Create new password for entering and to use your account
    public void createNewPassWord()   {
        keyword.webDriverWaitForElementPresent("LOGIN_FORM_NEW_PASS_WORD", 30);
        keyword.sendKeys("LOGIN_INPUT_NEW_PASSWORD", "LOGIN_NEW_PASSWORD");
        keyword.click("LOGIN_BTN_SUBMIT_RESET_PASSWORD");
        keyword.webDriverWaitForElementPresent("LOGIN_MESSAGE_RESET_PASSWORD_SUCCESS", 10);
    }
    public boolean checkStore(String checkElement) {
        return keyword.verifyElementPresent(checkElement);
    }
}

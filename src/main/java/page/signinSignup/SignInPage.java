package page.signinSignup;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import org.slf4j.Logger;
import page.home.LoginPage;

public class SignInPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    public SignInPage(KeywordWeb key) {super(key);}
    public SignInPage() {super();}
    // click Share
    public void clickAndVerifySignIn(String clickElement, String veriFyElement) throws InterruptedException {
        keyword.click(clickElement);
        keyword.webDriverWaitForElementPresent(veriFyElement, 10);
    }
    public void scrollToElementCheck(String elementScroll) throws InterruptedException {
        keyword.scrollDownToElement(elementScroll);
    }
    // sendKey share
    public void senkeyLogin(String getInputText, String senKey) throws InterruptedException {
        keyword.sendKeys(getInputText, senKey);
    }
    public void login() throws InterruptedException {
        keyword.navigateToUrl("BASE_URL");
        keyword.webDriverWaitForElementPresent("LOGIN_HEADER_NAVIGATE", 20);
    }
// openBrowser
    public void openBrowser() throws InterruptedException {
        keyword.openNewTab("LOGIN_URL_BACKEND");
        keyword.webDriverWaitForElementPresent("LOGIN_FORM_LOGIN_BACKEND",20);
   }
}

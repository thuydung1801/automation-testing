package page.signinSignup;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import page.home.LoginPage;

import java.security.PublicKey;

public class SignInPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();

    public SignInPage(KeywordWeb key) {
        super(key);
    }

    public SignInPage() {
        super();
    }

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
    public void openNewTabs() throws InterruptedException {
        keyword.executeJavaScript("window.open()");
        keyword.switchToTab(1);
        keyword.navigateToUrl("LOGIN_URL_BACKEND");
        keyword.webDriverWaitForElementPresent("LOGIN_FORM_LOGIN_BACKEND", 20);
    }

    // Switch To IFrame of element reset code
    public void iFrame() throws InterruptedException {
        keyword.imWait(10);
        keyword.switchToIFrameByXpath("LOGIN_IFRAME");
    }

    // Get Text of Element to store in variable call "text"
    public String getTextOfElement() throws Exception {
        return keyword.getText("LOGIN_INPUT_VERIFY_CODE");
    }

    //Enter the copy data
    public void enterTextInField() throws Exception {
        keyword.sendKeys("LOGIN_INPUT_ENTER_DATA", getTextOfElement());
        System.out.println("value copied");
    }

    public void backToPreviousTab() throws InterruptedException {
        keyword.switchToTab(0);
    }
}

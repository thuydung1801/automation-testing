package page.checkout;

import core.BasePage;
import core.KeywordWeb;
import core.PropertiesFile;

public class LoginAndAddressPage extends BasePage {
    public LoginAndAddressPage(KeywordWeb key) {
        super(key);
    }

    // delete and re-enter data
    public void clearTextAndSendKey(String clearText, String inputSendKey, String senKey) throws InterruptedException {
        keyword.clearText(clearText);
        Thread.sleep(1000);
        keyword.sendKeys(inputSendKey, senKey);
    }

    //    senKey function share
    public void senKey(String senkey, String getPropValue) {
        keyword.imWait(2);
        keyword.sendKeys(senkey, getPropValue);
    }

    //   check webDriver Wait For Element Present
    public void webDriverWaitForElementPresent(String dataCheck) {
        keyword.webDriverWaitForElementPresent(dataCheck, 20);
    }

    //Choose any product to pay
    public void goToPageProduct() throws InterruptedException {
        keyword.imWait(3);
        keyword.navigateToUrl("URL_NOTLOGIN");
        keyword.imWait(3);
        keyword.scrollDownToElement("CHECKOUT_SELECT_PRODUCT");
        keyword.imWait(1);
        keyword.click("CHECKOUT_SELECT_PRODUCT");
        Thread.sleep(2000);
        keyword.scrollDownToElement("CHECKOUT_SELECT_RING_SIZE");
        keyword.imWait(2);
        keyword.click("CHECKOUT_SELECT_RING_SIZE");
        keyword.webDriverWaitForElementPresent("CHECKOUT_POPUP_SIZE", 20);
        keyword.scrollDownToElement("CHECKOUT_SELECT_ONE_SIZE");
        keyword.click("CHECKOUT_SELECT_ONE_SIZE");
    }

    //  button submit
    public void clickButtonSubmit(String buttonSubmit) {
        keyword.click(PropertiesFile.getPropValue(buttonSubmit));
    }

    //  button product
    public void clickButtonAddProduct() {
        keyword.imWait(5);
        keyword.doubleClick("CHECK_OUT_BTN_ADD_PRODUCT");
        keyword.imWait(5);
        keyword.click("CHECKOUT_VIEW_DETAIL");
    }

    public void btnSubmitCheckOut() throws InterruptedException {
        keyword.doubleClick("CHECKOUT_BTN_PROCEED_CHECKOUT");
        keyword.webDriverWaitForElementPresent("CHECKOUT_BOOX_CHECKOUT_GUEST", 20);
        keyword.click("CECKOUT_BTN_CONTINUE");
        Thread.sleep(1000);
    }

    public void goBack() {
        keyword.scrollDownToElement("CHECKOUT_BTN_BACK");
        keyword.click("CHECKOUT_BTN_BACK");
    }


    //check Login AngVerify Customer Regis Wit Invalid Email
    public void LoginAngVerifyCustomerRegisWitInvalidhEmail(String verifyEmail, String verifyPass) throws InterruptedException {
        keyword.webDriverWaitForElementPresent(verifyEmail, 10);
        keyword.sendKeys("CHECKOUT_DATA_EMAIL_ADDRESS",
                "CHECKOUT_DATA_EMAIL_NOT_EXIST");
        keyword.webDriverWaitForElementPresent(verifyPass, 10);
        keyword.sendKeys("CHECKOUT_DATA_PASSWORD",
                "CHECKOUT_DATA_PASSWORD_ENTER");

    }

    //Check InvalidEmail email
    public void invalidEmail(String message, String inputEmail, String inpputPass) {
        keyword.webDriverWaitForElementPresent(message, 10);
        keyword.clearText(inputEmail);
        keyword.sendKeys(inputEmail,
                "CHECKOUT_DATA_EMAIL_ENTER");
        keyword.clearText(inpputPass);
        keyword.sendKeys(inpputPass,
                "CHECKOUT_DATA_PASSWORD_ENTER");
        keyword.doubleClick("CHECKOUT_BTN_LOGIN_RGT_CUSTOMER");
    }

    public void forgotPassword() throws InterruptedException {
        keyword.click("CHECKOUT_BTN_FORGOT_PASSWORD");
        keyword.webDriverWaitForElementPresent("CHECKOUT_BOOX_FOR_GOT_PASSWORD", 20);
        Thread.sleep(2000);
        keyword.click("CHECKOUT_BTN_BACK_FOR_GOT_PASSWORD");
    }
}

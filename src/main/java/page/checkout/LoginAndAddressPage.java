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
        keyword.clearText(PropertiesFile.getPropValue(clearText));
        Thread.sleep(1000);
        keyword.sendKeys(PropertiesFile.getPropValue(inputSendKey),
                PropertiesFile.getPropValue(senKey));
    }
    //    senKey function share
    public void senKey(String senkey, String getPropValue) {
        keyword.imWait(2);
        keyword.sendKeys(PropertiesFile.getPropValue(senkey),
                PropertiesFile.getPropValue(getPropValue));
    }
    //   check webDriver Wait For Element Present
    public void webDriverWaitForElementPresent(String dataCheck) {
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue(dataCheck), 20);
    }
    //Choose any product to pay
    public void goToPageProduct() throws InterruptedException {
        keyword.imWait(3);
        keyword.navigateToUrl(PropertiesFile.getPropValue("URL_NOTLOGIN"));
        keyword.imWait(3);
        keyword.scrollDownToElement(PropertiesFile.getPropValue("CHECKOUT_SELECT_PRODUCT"));
        keyword.imWait(1);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_SELECT_PRODUCT"));
        Thread.sleep(2000);
        keyword.scrollDownToElement(PropertiesFile.getPropValue("CHECKOUT_SELECT_RING_SIZE"));
        keyword.imWait(2);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_SELECT_RING_SIZE"));
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_POPUP_SIZE"), 20);
        keyword.scrollDownToElement(PropertiesFile.getPropValue("CHECKOUT_SELECT_ONE_SIZE"));
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_SELECT_ONE_SIZE"));
    }
    //  button submit
    public void clickButtonSubmit(String buttonSubmit) {
        keyword.click(PropertiesFile.getPropValue(buttonSubmit));
    }

    //  button product
    public void clickButtonAddProduct() {
        keyword.imWait(5);
        keyword.doubleClick(PropertiesFile.getPropValue("CHECK_OUT_BTN_ADD_PRODUCT"));
        keyword.imWait(5);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_VIEW_DETAIL"));
    }

    public void btnSubmitCheckOut() throws InterruptedException {
        keyword.doubleClick(PropertiesFile.getPropValue("CHECKOUT_BTN_PROCEED_CHECKOUT"));
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_BOOX_CHECKOUT_GUEST"), 20);
        keyword.click(PropertiesFile.getPropValue("CECKOUT_BTN_CONTINUE"));
        Thread.sleep(1000);
    }
    public void goBack() {
        keyword.scrollDownToElement(PropertiesFile.getPropValue("CHECKOUT_BTN_BACK"));
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_BTN_BACK"));
    }


    //check Login AngVerify Customer Regis Wit Invalid Email
    public void LoginAngVerifyCustomerRegisWitInvalidhEmail(String verifyEmail, String verifyPass) throws InterruptedException {
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue(verifyEmail), 10);
        keyword.sendKeys(PropertiesFile.getPropValue("CHECKOUT_DATA_EMAIL_ADDRESS"),
                PropertiesFile.getPropValue("CHECKOUT_DATA_EMAIL_NOT_EXIST"));
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue(verifyPass), 10);
        keyword.sendKeys(PropertiesFile.getPropValue("CHECKOUT_DATA_PASSWORD"),
                PropertiesFile.getPropValue("CHECKOUT_DATA_PASSWORD_ENTER"));

    }
    //Check InvalidEmail email
    public void invalidEmail(String message, String inputEmail, String inpputPass)  {
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue(message), 10);
        keyword.clearText(PropertiesFile.getPropValue(inputEmail));
        keyword.sendKeys(PropertiesFile.getPropValue(inputEmail),
                PropertiesFile.getPropValue("CHECKOUT_DATA_EMAIL_ENTER"));
        keyword.clearText(PropertiesFile.getPropValue(inpputPass));
        keyword.sendKeys(PropertiesFile.getPropValue(inpputPass),
                PropertiesFile.getPropValue("CHECKOUT_DATA_PASSWORD_ENTER"));
        keyword.doubleClick(PropertiesFile.getPropValue("CHECKOUT_BTN_LOGIN_RGT_CUSTOMER"));
    }
}

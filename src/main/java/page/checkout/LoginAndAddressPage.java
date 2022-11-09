package page.checkout;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import io.cucumber.java.sl.In;
import org.slf4j.Logger;
import page.home.RegisterPage;

public class LoginAndAddressPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();

    public LoginAndAddressPage(KeywordWeb key) {
        super(key);
    }

    public LoginAndAddressPage() {
        super();
    }

    private RegisterPage objRegis;
    public RegisterPage objRegist;

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

    public void clickBtnSubmit() throws InterruptedException {
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_PROCEED"));
    }

    public void clickPtnAddProduct() throws InterruptedException {
        keyword.imWait(5);
        keyword.doubleClick(PropertiesFile.getPropValue("CHECK_OUT_BTN_ADD_PRODUCT"));
        keyword.imWait(5);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_VIEW_DETAIL"));
    }

    public void btnSubmitCheckOut() throws InterruptedException {
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_BTN_PROCEED_CHECKOUT"));
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_BOOX_CHECKOUT_GUEST"), 30);
        keyword.click(PropertiesFile.getPropValue("CECKOUT_BTN_CONTINUE"));
        Thread.sleep(1000);
    }

    public void enterDataUserName() throws InterruptedException {
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_FORM_LOGIN_ADDRESS"), 20);
        Thread.sleep(2000);
        keyword.sendKeys(PropertiesFile.getPropValue("CHECKOUT_DATA_FIRSTNAME"),
                PropertiesFile.getPropValue("CHECKOUT_DATA_FIRSNAME_ENTER"));
        keyword.sendKeys(PropertiesFile.getPropValue("CHECKOUT_DATA_LASTNAME"),
                PropertiesFile.getPropValue("CHECKOUT_DATA_LASTNAME_ENTER"));
    }

    public void enterDataEmial() throws InterruptedException {
        keyword.imWait(2);
        keyword.sendKeys(PropertiesFile.getPropValue("CHECKOUT_DATA_EMAIL"),
                PropertiesFile.getPropValue("CHECKOUT_DATA_EMAIL_ENTER"));
        keyword.sendKeys(PropertiesFile.getPropValue("CHECKOUT_DATA_CONFIRMEMAIL"),
                PropertiesFile.getPropValue("CHECKOUT_DATA_CONFIRMEMAIL_ENTER"));
    }

    //----exception Email.
    public void enterDataEmailFail1() throws InterruptedException {
        Thread.sleep(2000);
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_MESSAGE_FAILE_EMAIL02"), 20);
        keyword.clearText(PropertiesFile.getPropValue("CHECKOUT_DATA_CONFIRMEMAIL"));
        Thread.sleep(1000);
        keyword.sendKeys(PropertiesFile.getPropValue("CHECKOUT_DATA_CONFIRMEMAIL"),
                PropertiesFile.getPropValue("CHECKOUT_DATA_EMAIL_FAILD_2"));
    }

    public void enterDataEmailFail2(String messageFail) throws InterruptedException {
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue(messageFail), 20);
        keyword.clearText(PropertiesFile.getPropValue("CHECKOUT_DATA_CONFIRMEMAIL"));
        Thread.sleep(1000);
        keyword.sendKeys(PropertiesFile.getPropValue("CHECKOUT_DATA_CONFIRMEMAIL"),
                PropertiesFile.getPropValue("CHECKOUT_DATA_EMAIL_FAILD_1"));
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue(messageFail), 20);
        Thread.sleep(1000);
        keyword.clearText(PropertiesFile.getPropValue("CHECKOUT_DATA_CONFIRMEMAIL"));
        Thread.sleep(1000);
        keyword.sendKeys(PropertiesFile.getPropValue("CHECKOUT_DATA_CONFIRMEMAIL"),
                PropertiesFile.getPropValue("CHECKOUT_DATA_EMAIL_ENTER"));
    }

    //-------------------------PHONE ST
    public void enterDataPhone() throws InterruptedException {
        keyword.sendKeys(PropertiesFile.getPropValue("CHECKOUT_DATA_PHONE"),
                PropertiesFile.getPropValue("CHECKOUT_DATA_PHONE_ENTER_FAIL"));
    }

    public void enterDataPhoneFail1(String dataCheck, String inputPhone, String dataPhone1, String dataPass) throws InterruptedException {
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue(dataCheck), 20);
        keyword.clearText(PropertiesFile.getPropValue(inputPhone));
        Thread.sleep(2000);
        keyword.sendKeys((PropertiesFile.getPropValue(inputPhone)), PropertiesFile.getPropValue(dataPhone1));
        keyword.imWait(2);
        keyword.webDriverWaitForElementPresent((PropertiesFile.getPropValue(dataCheck)), 20);
        keyword.clearText(PropertiesFile.getPropValue(inputPhone));
        Thread.sleep(1000);
        keyword.sendKeys(PropertiesFile.getPropValue(inputPhone), PropertiesFile.getPropValue(dataPass));
    }

    //---------------------------END
    //----------------- Address Validation
    public void AddressValidation(String booxMessage, String btn) throws InterruptedException {
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue(booxMessage), 20);
        Thread.sleep(1000);
        keyword.click(PropertiesFile.getPropValue(btn));
    }

    public void delete_reEnterTheAddress(String Street, String zipCode, String city) throws InterruptedException {
        keyword.clearText(PropertiesFile.getPropValue(Street));
        keyword.sendKeys(PropertiesFile.getPropValue(Street), PropertiesFile.getPropValue("CHECKOUT_DATA_STREET_ENTER01"));
        Thread.sleep(1000);
        keyword.clearText(PropertiesFile.getPropValue(zipCode));
        keyword.sendKeys(PropertiesFile.getPropValue(zipCode), PropertiesFile.getPropValue("CHECKOUT_DATA_ZIPCODE_ENTER01"));
        Thread.sleep(1000);
        keyword.clearText(PropertiesFile.getPropValue(city));
        keyword.sendKeys(PropertiesFile.getPropValue(city), PropertiesFile.getPropValue("CHECKOUT_DATA_CITY_ENTER01"));
        Thread.sleep(1000);
    }

    public void enterDataCompany() throws InterruptedException {
        keyword.sendKeys(PropertiesFile.getPropValue("CHECKOUT_DATA_COMPANY"),
                PropertiesFile.getPropValue("CHECKOUT_DATA_COMPANY_ENTER"));
    }

    public void enterDataStreet() throws InterruptedException {
        keyword.sendKeys(PropertiesFile.getPropValue("CHECKOUT_DATA_STREET"),
                PropertiesFile.getPropValue("CHECKOUT_DATA_STREET_ENTER"));
    }

    public void enterDataZipCode() throws InterruptedException {
        keyword.sendKeys(PropertiesFile.getPropValue("CHECKOUT_DATA_ZIPCODE"),
                PropertiesFile.getPropValue("CHECKOUT_DATA_ZIPCODE_ENTER"));
    }

    public void enterDataCity() throws InterruptedException {
        keyword.sendKeys(PropertiesFile.getPropValue("CHECKOUT_DATA_CITY"),
                PropertiesFile.getPropValue("CHECKOUT_DATA_CITY_ENTER"));
    }


    public void updateEditTextName(String inputTextName, String editName) throws InterruptedException {
        Thread.sleep(3000);
//        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue
//                ("CHECKOUT_BOOX_VERIFY_BOOX_INFO_ADDRESS"), 20);
        keyword.scrollDownToElement(PropertiesFile.getPropValue("CHECKOUT_BOOX_LOGINADDRESS_SUCCESS"));
        keyword.doubleClick(PropertiesFile.getPropValue("CHECKOUT_BTN_EDIT"));
//        Thread.sleep(2000);
//        keyword.clearText(PropertiesFile.getPropValue(inputTextName));
//        keyword.imWait(2);
//        keyword.sendKeys(PropertiesFile.getPropValue(inputTextName), PropertiesFile.getPropValue(editName));
    }
    public void customerLogin(String url) throws InterruptedException {
        keyword.navigateToUrl(url);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_BTN_LOGIN_RGT_CUSTOMER"));
    }
    public void verifyEmialPassW() throws InterruptedException {
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_MESSAGE_EMAIL_ERROR"), 10);
        keyword.sendKeys(PropertiesFile.getPropValue("CHECKOUT_DATA_EMAIL_ADDRESS"),
                PropertiesFile.getPropValue("CHECKOUT_DATA_EMAIL_ENTER"));
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_MESSAGE_PASSW_ERROR"), 10);
        keyword.sendKeys(PropertiesFile.getPropValue("CHECKOUT_DATA_PASSWORD"),
                PropertiesFile.getPropValue("CHECKOUT_DATA_PASSWORD_ENTER"));
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_BTN_LOGIN"));
    }
}

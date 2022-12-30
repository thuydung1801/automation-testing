package page.checkout;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import org.slf4j.Logger;
import page.home.RegisterPage;
import page.signinSignup.SignUpPage;

public class LoginAndAddressPage extends BasePage {
    public LoginAndAddressPage(KeywordWeb key) {
        super(key);
    }

    private RegisterPage objRegis;
    private SignUpPage objSignUp;
    private static Logger logger = LogHelper.getLogger();

    //   check webDriver Wait For Element Present
    public void webDriverWaitForElementPresent(String dataCheck) {
        keyword.webDriverWaitForElementPresent(dataCheck, 20);
    }

    public void scrollAndClickElement(String elementScroll, String elementClick) throws InterruptedException {
        keyword.scrollDownToElement(elementScroll);
        keyword.untilJqueryIsDone(20L);
        keyword.click(elementClick);
    }

    public void selectProductAndGoToCheckOut(String element1, String element2, String element3) throws InterruptedException {
        scrollAndClickElement(element1, element1);
        scrollAndClickElement(element2, element2);
        scrollAndClickElement(element3, element3);
        keyword.untilJqueryIsDone(50L);
        keyword.click("PRD_BTN_ADDCART");
        keyword.untilJqueryIsDone(70L);
        keyword.imWait(10);
        keyword.click("CHECKOUT_VIEW_DETAIL");
        keyword.untilJqueryIsDone(100L);
        keyword.untilJqueryIsDone(100L);
        Thread.sleep(2000);
        keyword.click("LA_BTN_PROCEED_TO_CHECKOUT");
    }

    public void sendAllDataForm(String firstName, String lastName, String email, String confirmEmail, String phone, String company, String street, String zipCode, String country) throws InterruptedException {
        keyword.sendKeys("LP_INPUT_FIRST_NAME", firstName);
        keyword.sendKeys("LP_INPUT_LAST_NAME", lastName);
        keyword.sendKeys("LP_INPUT_EMAIL", email);
        keyword.sendKeys("LP_INPUT_CONFIRM_EMAIL", confirmEmail);
        keyword.sendKeys("LP_INPUT_TELEPHONE", phone);
        keyword.sendKeys("LP_INPUT_COMPANY", company);
        keyword.sendKeys("LP_INPUT_STREET", street);
        keyword.sendKeys("LP_INPUT_POSTAL", zipCode);
        keyword.sendKeys("LP_INPUT_CITY", country);
    }

    public void editFormAddressAndVerify(String btnSavem, String btnEdit, String clearText, String dataSendKey, String expect, String actual) throws InterruptedException {
        keyword.untilJqueryIsDone(30L);
        keyword.click(btnEdit);
        objSignUp.clearTextAndSendKey(clearText, clearText, dataSendKey);
        keyword.click(btnSavem);
        keyword.untilJqueryIsDone(30L);
        keyword.assertEquals(expect, actual);
    }


    //    getAttributeValue
    public void verifyFillAllData() throws InterruptedException {
        keyword.verifyAttributeValues("LA_DATA_FIRST_NAME", "LA_INPUT_FILL_DATA_FIRST_NAME");
        keyword.verifyAttributeValues("LA_DATA_LAST_NAME", "LA_INPUT_FILL_DATA_LAST_NAME");
        keyword.verifyAttributeValues("LA_DATA_PHONE", "LA_INPUT_FILL_DATA_PHONE");
        keyword.verifyAttributeValues("LP_DATA_COMPANY", "LA_INPUT_FILL_DATA_COMPANY");
        keyword.verifyAttributeValues("LP_DATA_STREET", "LA_INPUT_FILL_DATA_STREET");
        keyword.verifyAttributeValues("LP_POSTAL_CODE_MALTA", "LA_INPUT_FILL_DATA_POSTCODE");
        keyword.verifyAttributeValues("LP_COUNTRY", "LA_INPUT_FILL_DATA_CITY");
//        keyword.getAttributeValues("LP_COUNTRY", "LA_INPUT_FILL_DATA_COUNTRY_ID");
    }

    public void sendKeyFormAddNewFormAddress(String inputPhone, String inputCompany, String inputStreet, String inputPostal, String inputCity) throws InterruptedException {
        keyword.sendKeys(inputPhone, "LA_DATA_PHONE");
        keyword.sendKeys(inputCompany, "LP_DATA_COMPANY");
        keyword.sendKeys(inputStreet, "LP_DATA_STREET");
        keyword.sendKeys(inputPostal, "LP_DATA_POSTAL");
        keyword.sendKeys(inputCity, "LP_DATA_CITY");
        keyword.click("LA_EDIT_BTN_SAVE");
    }

    public boolean checkButtonSave() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        return keyword.verifyElementVisible("LA_INPUT_SAVE_ADDRESS");
    }

    //clear all
    public void clearAllData() throws InterruptedException {
        keyword.clearText("LP_INPUT_FIRST_NAME");
        keyword.clearText("LP_INPUT_LAST_NAME");
        keyword.clearText("LP_INPUT_EMAIL");
        keyword.clearText("LP_INPUT_TELEPHONE");
        keyword.clearText("LP_INPUT_COMPANY");
        keyword.clearText("LP_INPUT_STREET");
        keyword.clearText("LP_INPUT_POSTAL");
        keyword.clearText("LP_INPUT_CITY");
    }

    //clear all form add new address
    public void clearAllFormAddNewAndVerifyRequiredForm() throws InterruptedException {
        keyword.clearText("LA_INPUT_FILL_DATA_FIRST_NAME");
        keyword.clearText("LA_INPUT_FILL_DATA_LAST_NAME");
        keyword.clearText("LA_INPUT_FILL_DATA_PHONE");
        keyword.clearText("LA_INPUT_FILL_DATA_COMPANY");
        keyword.clearText("LA_INPUT_FILL_DATA_STREET");
        keyword.clearText("LA_INPUT_FILL_DATA_POSTCODE");
        keyword.clearText("LA_INPUT_FILL_DATA_CITY");
        keyword.click("LA_EDIT_BTN_SAVE");

    }

    //verify All  required field
    public void verifyAllRequiredField() throws InterruptedException {
        keyword.assertEquals("LA_LIST_MESSAGE_REQUIRED_FIELD", "LP_MESSAGE_FIELD_FIRST_NAME");
        keyword.assertEquals("LA_LIST_MESSAGE_REQUIRED_FIELD", "LA_MESSAGE_FIELD_LAST_NAME");
        keyword.assertEquals("LA_LIST_MESSAGE_REQUIRED_FIELD", "LA_MESSAGE_FIELD_EMAIL");
        keyword.assertEquals("LA_LIST_MESSAGE_REQUIRED_FIELD", "LA_MESSAGE_FIELD_CONFIRM_EMAIL");
        keyword.assertEquals("LA_LIST_MESSAGE_REQUIRED_FIELD", "LA_MESSAGE_FIELD_PHONE");
        keyword.assertEquals("LA_LIST_MESSAGE_REQUIRED_FIELD", "LA_MESSAGE_STREET_FIELD");
        keyword.assertEquals("LA_LIST_MESSAGE_REQUIRED_FIELD", "LA_MESSAGE_FIELD_ZIP_CODE");
        keyword.assertEquals("LA_LIST_MESSAGE_REQUIRED_FIELD", "LA_MESSAGE_FIELD_CITY");
    }

    //Login customer with Email not exist or Password invalid from checkout page
    public void loginCustomerWithEmailNotExistPassword() throws InterruptedException {
        keyword.navigateToUrl("LP_URL_OLD_DESIGN");
        objRegis = new RegisterPage(this.keyword);
        objRegis.acceptAllCookies();
        keyword.untilJqueryIsDone(100L);
        selectProductAndGoToCheckOut("LP_SELECT_PRODUCT_OLD", "LP_SELECT_RING_SIZE", "LP_CHOSE_RING_SIZE");
//        selectProductAndGoToCheckOut("SELECT_PRODUCT_CHECKOUT", "PRD_DROPDOWN", "SELECT_RINGSIZE_OPTION");
        keyword.untilJqueryIsDone(100L);
        keyword.sendKeys("LA_INPUT_EMAIL", "LA_DATA_EMAIL");
        keyword.sendKeys("LA_INPUT_PASSWORD", "LA_DATA_PASSWORD");
        keyword.untilJqueryIsDone(10L);
        keyword.click("LA_BTN_LOGIN_ADDRESS");
        keyword.untilJqueryIsDone(100L);
        keyword.assertEquals("LA_MESSAGE_INVALID_LOGIN", "LA_INPUT_MESSAGE_INVALID_LOGIN");
    }


    //Input invalid email on the Login and Address tab
    public void invalidEmailOnTheLogin() throws InterruptedException {
        objSignUp = new SignUpPage(this.keyword);
        objSignUp.clearTextAndSendKey("LA_INPUT_EMAIL", "LA_INPUT_EMAIL", "LA_DATA_EMAIL_INVALID");
        keyword.click("LA_BTN_LOGIN");
        keyword.untilJqueryIsDone(100L);
        keyword.assertEquals("LA_MESSAGE_EMAIL_INVALID", "CHECKOUT_LA_LBL_ERROR_MAIL");
    }

    //clear All Form and verifyForm
    public void clearAllFormAndVerifyRequiredForm() throws InterruptedException {
        keyword.clearText("LA_INPUT_FILL_DATA_FIRST_NAME");
        keyword.clearText("LA_INPUT_FILL_DATA_LAST_NAME");
        keyword.click("LA_EDIT_BTN_SAVE");
        keyword.assertEquals("LA_LIST_MESSAGE_REQUIRED_FIELD", "LA_MESSAGE_REQUIRE_FIRST_NAME");
        keyword.assertEquals("LA_LIST_MESSAGE_REQUIRED_FIELD", "LA_MESSAGE_REQUIRE_LAST_NAME");
        keyword.assertEquals("LA_LIST_MESSAGE_REQUIRED_FIELD", "LA_MESSAGE_REQUIRE_PHONE");
        keyword.assertEquals("LA_LIST_MESSAGE_REQUIRED_FIELD", "LA_MESSAGE_REQUIRE_STREET");
        keyword.assertEquals("LA_LIST_MESSAGE_REQUIRED_FIELD", "LA_MESSAGE_REQUIRE_ZIP");
        keyword.assertEquals("LA_LIST_MESSAGE_REQUIRED_FIELD", "LA_MESSAGE_REQUIRE_CITY");
    }

    //Leave blank Email and Password
    public void leaveBlankEmailAndPassword() throws InterruptedException {
        keyword.clearText("LA_INPUT_EMAIL");
        keyword.clearText("LA_INPUT_PASSWORD");
        keyword.click("CHECKOUT_LA_BTN_LOGIN");
        keyword.assertEquals("LA_LIST_MESSAGE_REQUIRED_FIELD", "CHECKOUT_LA_LBL_ERROR_MAIL");
        keyword.assertEquals("LA_LIST_MESSAGE_REQUIRED_FIELD", "LA_ERROR_PASSWORD");
    }

    //Check link forgot password
    public void checkLinkForgotPassword() throws InterruptedException {
        keyword.click("LA_LINK_FORGOT_PASSWORD");
        keyword.untilJqueryIsDone(50L);
        keyword.verifyElementVisible("LP_FORGOT_PASSWORD_PAGE");
    }

    //Next to Payment page successfully with Guest option and Ship to this address is yes
    public void nextToPaymentPageWithAddress() throws InterruptedException {
        keyword.back();
        keyword.untilJqueryIsDone(50L);
        keyword.click("LP_BTN_CONTINUE");
        sendAllDataForm("LA_DATA_FIRST_NAME", "LA_DATA_LAST_NAME", "LA_DATA_EMAIL", "LP_EMAIL_CONFIRM", "LA_DATA_PASSWORD", "LP_DATA_COMPANY", "LP_DATA_STREET", "LP_POSTAL_CODE_MALTA", "LP_COUNTRY");
        keyword.assertEquals("LA_MESSAGE_EMAIL_CONFIRM_ERROR", "LP_INPUT_EMAIL_CONFIRM_ERROR");
    }

    //    emailInvalid
    public void emailInvalid() throws InterruptedException {
        objSignUp = new SignUpPage(this.keyword);
        keyword.untilJqueryIsDone(50L);
        objSignUp.clearTextAndSendKey("LP_EMAIL_CONFIRM_FAIL", "LP_EMAIL_CONFIRM_FAIL", "LP_EMAIL_INVALID");
        keyword.untilJqueryIsDone(70L);
        keyword.assertEquals("LA_MESSAGE_EMAIL_INVALID", "LP_EMAIL_CONFIRM_INVALID");
    }

    //
    public void checkNotCopyPasteEmail() throws InterruptedException {
        keyword.untilJqueryIsDone(30L);
        keyword.clearText("LP_EMAIL_COPY_PASTE");
        keyword.clearText("LP_EMAIL_CONFIRM_FAIL");
        keyword.untilJqueryIsDone(30L);
        keyword.checkNotCopyPastesKeyboardEvents("LP_EMAIL_COPY_PASTE", "LP_DATA_EMAIL_COPY_PASTE");
        keyword.untilJqueryIsDone(10L);
        keyword.assertEquals("LA_MESSAGE_NOT_ALLOW", "LA_INPUT_MESSAGE_NOT_ALLOW_ACTION");
    }

    //    leaveBlankRequiredForm
    public void leaveBlankRequiredForm() throws InterruptedException {
        keyword.untilJqueryIsDone(20L);
        clearAllData();
        keyword.click("LP_BTN_TO_PLAY");
        keyword.untilJqueryIsDone(30L);
        verifyAllRequiredField();
        keyword.assertEquals("LA_MESSAGE_ALL_REQUIRED_FIELDS", "LP_INPUT_MESSAGE_REQUIRED_ALL_DATA_FIELD");
    }

    //    enterInvalidPhone
    public void enterInvalidPhone() throws InterruptedException {
        keyword.clearLocalStorage();
        keyword.reLoadPage();
        keyword.untilJqueryIsDone(50L);
        keyword.click("LP_BTN_CONTINUE");
        sendAllDataForm("LA_DATA_FIRST_NAME", "LA_DATA_LAST_NAME", "LA_DATA_EMAIL", "LA_DATA_CONFIRM_EMAIL", "LA_DATA_PHONE_INVALID", "LP_DATA_COMPANY", "LP_DATA_STREET", "LP_POSTAL_CODE_MALTA", "LP_COUNTRY");
        keyword.assertEquals("LA_DATA_MESSAGE_PHONE_FIELD", "LA_MESSAGE_FIELD_PHONE");
    }

    //    nextToPaymentSuccess
    public void nextToPaymentSuccess() throws InterruptedException {
        objSignUp.clearTextAndSendKey("LA_INPUT_TELEPHONE_FIELD", "LA_INPUT_TELEPHONE_FIELD", "LA_DATA_PHONE");
        keyword.click("LP_BTN_TO_PLAY");
        keyword.untilJqueryIsDone(20L);
        String textShipping = keyword.getText("LP_INPUT_MESSAGE_SHOPPING_ADDRESS").replaceAll("\\s", " ");
        keyword.simpleAssertEquals("LA_SHIPPING_ADDRESS_MESSAGE", textShipping);
    }

    //    nextToPaymentSuccessOnChangeNoShipToAddress
    public void nextToPaymentSuccessOnChangeNoShipToAddress() throws InterruptedException {
        keyword.untilJqueryIsDone(20L);
        keyword.clearLocalStorage();
        keyword.reLoadPage();
        keyword.untilJqueryIsDone(50L);
        keyword.untilJqueryIsDone(50L);
        keyword.click("LP_BTN_CONTINUE");
        sendAllDataForm("LA_DATA_FIRST_NAME", "LA_DATA_LAST_NAME", "LA_DATA_EMAIL",
                "LA_DATA_CONFIRM_EMAIL", "LA_DATA_PHONE", "LP_DATA_COMPANY",
                "LP_DATA_STREET", "LP_POSTAL_CODE_MALTA", "LP_COUNTRY");
        keyword.click("LA_BTN_NO_SHIP_ADDRESS");
        keyword.untilJqueryIsDone(50L);
        keyword.click("LP_BTN_TO_PLAY");
        verifyFillAllData();
    }


    //    editAddressWithCustomerNotLogin
    public void editAddressWithCustomerNotLogin() throws InterruptedException {
        keyword.click("LA_INPUT_SAVE_ADDRESS");
        editFormAddressAndVerify("LA_INPUT_SAVE_ADDRESS", "LA_BTN_EDIT",
                "LA_INPUT_FILL_DATA_FIRST_NAME", "LA_DATA_NAME_EDIT",
                "LA_MESSAGE_SAVE_SUCCESS", "LA_INPUT_MESSAGE_SAVE_SUCCESS");
    }

    //editAddressWithCustomerLogin
    public void editAddressWithCustomerLogin() throws InterruptedException {
        keyword.reLoadPage();
        keyword.untilJqueryIsDone(20L);
        keyword.click("LA_BTN_EDIT_CUSTOMER_LOGIN");
        objSignUp.clearTextAndSendKey("LA_EDIT_NAME", "LA_EDIT_NAME", "LA_DATA_NAME_EDIT");
        keyword.click("LA_EDIT_BTN_SAVE");
        keyword.untilJqueryIsDone(50L);
        keyword.assertEquals("LA_MESSAGE_UPDATE_SUCCESS", "LA_INPUT_MESSAGE_SAVE_SUCCESS");
    }

    //    nexToProcessToCheckOut
    public void nexToProcessToCheckOutBillingSameAsShipping() throws InterruptedException {
        keyword.click("LA_PROCEED_TO_CHECK_OUT_BTN");
        keyword.untilJqueryIsDone(50L);
//        keyword.checkDisplayOfStringInText("LP_INPUT_MESSAGE_SHOPPING_ADDRESS", "LP_DATA_STREET");
        String textShipping = keyword.getText("LP_INPUT_MESSAGE_SHOPPING_ADDRESS").replaceAll("\\s", " ");
        keyword.simpleAssertEquals("LA_MESSAGE_SHIPPING_ADDRESS", textShipping);
    }

    //nexToProcessToCheckOutBillingNotSameShipping
    public void nexToProcessToCheckOutcheckedSameAsShipping() throws InterruptedException {
        keyword.untilJqueryIsDone(20L);
        keyword.click("LA_LOGIN_AND_ADDRESS");
        keyword.untilJqueryIsDone(50L);
        keyword.click("LA_BTN_SAME_AS_SHIPPING");
        keyword.untilJqueryIsDone(50L);
        keyword.click("LA_ADD_NEW_BILLING_ADDRESS");
        keyword.untilJqueryIsDone(20L);
        objSignUp.clearTextAndSendKey("LA_EDIT_NAME", "LA_EDIT_NAME", "LA_DATA_NAME_EDIT_NEW");
        objSignUp.clearTextAndSendKey("LA_EDIT_LAST_NAME", "LA_EDIT_LAST_NAME", "LA_DATA_NAME_EDIT");
        sendKeyFormAddNewFormAddress("LA_BILL_PHONE", "LA_BILL_COMPANY",
                "LA_BILL_STREET", "LA_BILL_POSTAL", "LA_BILL_CITY");
        keyword.untilJqueryIsDone(70L);
        keyword.click("LA_PROCEED_TO_CHECK_OUT_BTN");
        String textShipping = keyword.getText("LP_INPUT_MESSAGE_SHOPPING_ADDRESS").replaceAll("\\s", " ");
        String textBill = keyword.getText("LA_INPUT_BILL_ADDRESS").replaceAll("\\s", " ");
        keyword.simpleAssertEquals("LA_MESSAGE_SHIPPING_ADDRESS", textShipping);
        keyword.untilJqueryIsDone(10L);
        keyword.simpleAssertEquals("LA_MESSAGE_BILL_ADDRESS", textBill);
    }

    //nexToProcessToCheckOutBillingNotSameShipping
    public void nexToProcessToCheckOutBillingNoteSameShipping() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.click("LA_LOGIN_AND_ADDRESS");
        keyword.untilJqueryIsDone(20L);
        keyword.click("LA_BTN_SAME_AS_SHIPPING");
        keyword.click("LA_PROCEED_TO_CHECK_OUT_BTN");
        String textShipping = keyword.getText("LP_INPUT_MESSAGE_SHOPPING_ADDRESS").replaceAll("\\s", " ");
        keyword.simpleAssertEquals("LA_MESSAGE_SHIPPING_ADDRESS", textShipping);
        keyword.assertEquals("LA_BILLING_ADDRESS_FILL_TEXT_SAME_AS_SHIPPING", "LA_INPUT_TEXT_FILL_SAME_AS_SHIPPING");
    }

    //Add New Address successfully with customer login
    public void addNewAddress() throws InterruptedException {
        keyword.clearLocalStorage();
        keyword.reLoadPage();
        keyword.untilJqueryIsDone(70L);
        keyword.sendKeys("LA_INPUT_USE_NAME", "LA_DATA_EMAIL");
        keyword.sendKeys("LA_INPUT_ACCOUNT_PASSWORD", "REGIST_DATA_PASSWORD");
        keyword.untilJqueryIsDone(10L);
        keyword.click("LA_BTN_LOGIN");
        keyword.untilJqueryIsDone(50L);
        if (checkButtonSave()) {
            keyword.click("LA_INPUT_SAVE_ADDRESS");
            keyword.click("LA_BTN_ADD_ADDRESS");
        } else {
            keyword.untilJqueryIsDone(10L);
            keyword.click("LA_BTN_ADD_ADDRESS");
        }
        sendKeyFormAddNewFormAddress("LA_INPUT_FILL_DATA_PHONE", "LA_INPUT_FILL_DATA_COMPANY",
                "LA_INPUT_FILL_DATA_STREET", "LA_INPUT_FILL_DATA_POSTCODE", "LA_INPUT_FILL_DATA_CITY");
        keyword.untilJqueryIsDone(70L);
        keyword.assertEquals("LA_MESSAGE_UPDATE_SUCCESS", "LA_INPUT_MESSAGE_SAVE_SUCCESS");
    }

    //    addNewAddressFillAllRequiredField
    public void addNewAddressFillAllRequiredField() throws InterruptedException {
        keyword.click("LA_BTN_ADD_ADDRESS");
        clearAllFormAndVerifyRequiredForm();
    }

    //    removeAddressWithCustomerLogin
    public void removeAddressWithCustomerLogin() throws InterruptedException {
        keyword.click("LA_BTN_CANCEL");
        keyword.untilJqueryIsDone(100L);
        keyword.click("LA_BTN_DELETE_ADDRESS");
        keyword.verifyElementVisible("LA_POPUP_CONFIRM_DELETE");
        keyword.assertEquals("LA_MESSAGE_DELETE", "LA_INPUT_MESSAGE_DELETE");
        keyword.click("LA_BTN_OK_DELETE_ADDRESS");
        keyword.checkElementIsNotDisplayed("LA_POPUP_CONFIRM_DELETE");

    }
}

package page.checkout;

import core.BasePage;
import core.KeywordWeb;
import core.PropertiesFile;
import page.home.RegisterPage;
import page.signinSignup.SignUpPage;

public class LoginAndAddressPage extends BasePage {
    public LoginAndAddressPage(KeywordWeb key) {
        super(key);
    }

    private RegisterPage objRegis;
    private SignUpPage objSignUp;

    // delete and re-enter data
//    public void clearTextAndSendKey(String clearText, String inputSendKey, String senKey) throws InterruptedException {
//        keyword.clearText(clearText);
//        Thread.sleep(1000);
//        keyword.sendKeys(inputSendKey, senKey);
//    }

    //    senKey function share
//    public void senKey(String senkey, String getPropValue) {
//        keyword.imWait(2);
//        keyword.sendKeys(senkey, getPropValue);
//    }

    //   check webDriver Wait For Element Present
    public void webDriverWaitForElementPresent(String dataCheck) {
        keyword.webDriverWaitForElementPresent(dataCheck, 20);
    }

    public void scrollAndClickElement(String elementScroll, String elementClick) throws InterruptedException {
        keyword.scrollDownToElement(elementScroll);
        keyword.untilJqueryIsDone(20L);
        keyword.click(elementClick);
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
        objRegis = new RegisterPage(this.keyword);
        keyword.navigateToUrl("BASE_URL_CHECKOUT_NOT_LOGIN");
        objRegis.acceptAllCookies();
        keyword.untilJqueryIsDone(100L);
        selectProductAndGoToCheckOut("SELECT_PRODUCT_CHECKOUT", "PRD_DROPDOWN", "SELECT_RINGSIZE_OPTION");
        keyword.untilJqueryIsDone(100L);
        keyword.sendKeys("LA_INPUT_EMAIL", "LA_DATA_EMAIL");
        keyword.sendKeys("LA_INPUT_PASSWORD", "LA_DATA_PASSWORD");
        keyword.click("CHECKOUT_LA_BTN_LOGIN");
        keyword.untilJqueryIsDone(100L);
        keyword.assertEquals("LA_MESSAGE_INVALID_LOGIN", "LA_INPUT_MESSAGE_INVALID_LOGIN");
    }


    //Input invalid email on the Login and Address tab
    public void invalidEmailOnTheLogin() throws InterruptedException {
        objSignUp = new SignUpPage(this.keyword);
        objSignUp.clearTextAndSendKey("LA_INPUT_EMAIL", "LA_INPUT_EMAIL", "LA_DATA_EMAIL_INVALID");
        keyword.assertEquals("LA_MESSAGE_EMAIL_INVALID", "CHECKOUT_LA_LBL_ERROR_MAIL");
    }

    //Leave blank Email and Password
    public void leaveBlankEmialAndPassword() throws InterruptedException {
        keyword.clearText("LA_INPUT_EMAIL");
        keyword.clearText("LA_INPUT_PASSWORD");
        keyword.click("CHECKOUT_LA_BTN_LOGIN");
        keyword.assertEquals("LA_MESSAGE_LEAVE_BLANK_EMAIL", "CHECKOUT_LA_LBL_ERROR_MAIL");
        keyword.assertEquals("LA_MESSAGE_LEAVE_BLANK_PASSWORD", "LA_ERROR_PASSWORD");
    }

    //Check link forgot password
    public void checkLinkForgotPassword() throws InterruptedException {
        keyword.click("LA_LINK_FORGOT_PASSWORD");
        keyword.untilJqueryIsDone(50L);
        keyword.verifyElementVisible("LP_FORGOT_PASSWORD_PAGE");
    }

    //Next to Payment page successfully with Guest option and Ship to this address is yes
    public void nextToPaymentPageWithAddress() throws InterruptedException {
        keyword.navigateToUrl("LP_URL_OLD_DESIGN");
        objRegis = new RegisterPage(this.keyword);
        objRegis.acceptAllCookies();
        keyword.untilJqueryIsDone(50L);
        selectProductAndGoToCheckOut("LP_SELECT_PRODUCT_OLD", "LP_SELECT_RING_SIZE", "LP_CHOSE_RING_SIZE");
        keyword.imWait(10);
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
    public void copyPasteEmail() throws InterruptedException {
        keyword.untilJqueryIsDone(30L);
        keyword.clearText("LP_EMAIL_COPY_PASTE");
        keyword.clearText("LP_EMAIL_CONFIRM_FAIL");
        keyword.checkNotCopyPastesKeyboardEvents("LP_EMAIL_COPY_PASTE", "LP_DATA_EMAIL_COPY_PASTE");
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
        keyword.click("LP_BTN_CONTINUE");
        sendAllDataForm("LA_DATA_FIRST_NAME", "LA_DATA_LAST_NAME", "LA_DATA_EMAIL", "LA_DATA_CONFIRM_EMAIL", "LA_DATA_PHONE_INVALID", "LP_DATA_COMPANY", "LP_DATA_STREET", "LP_POSTAL_CODE_MALTA", "LP_COUNTRY");
        keyword.assertEquals("LA_DATA_MESSAGE_PHONE_FIELD", "LA_MESSAGE_FIELD_PHONE");
    }

    //    nextToPaymentSuccess
    public void nextToPaymentSuccess() throws InterruptedException {
        objSignUp.clearTextAndSendKey("LA_INPUT_TELEPHONE_FIELD", "LA_INPUT_TELEPHONE_FIELD", "LA_DATA_PHONE");
        keyword.click("LP_BTN_TO_PLAY");
        keyword.untilJqueryIsDone(20L);
//       keyword.assertEquals();
    }

    //    nextToPaymentSuccessOnChangeNoShipToAddress
    public void nextToPaymentSuccessOnChangeNoShipToAddress() throws InterruptedException {
        keyword.untilJqueryIsDone(20L);
        keyword.clearLocalStorage();
        keyword.reLoadPage();
        keyword.click("LP_BTN_CONTINUE");
        sendAllDataForm("LA_DATA_FIRST_NAME", "LA_DATA_LAST_NAME", "LA_DATA_EMAIL", "LA_DATA_CONFIRM_EMAIL", "LA_DATA_PHONE", "LP_DATA_COMPANY", "LP_DATA_STREET", "LP_POSTAL_CODE_MALTA", "LP_COUNTRY");
        keyword.click("LA_BTN_NO_SHIP_ADDRES");
        keyword.untilJqueryIsDone(50L);
        keyword.click("LP_BTN_TO_PLAY");
        verifyFillAllData();
    }

    public void editFormAddressAndVerify(String btnSavem, String btnEdit, String clearText, String dataSendKey, String expect, String actual) throws InterruptedException {
        keyword.untilJqueryIsDone(30L);
        keyword.click(btnEdit);
        objSignUp.clearTextAndSendKey(clearText, clearText, dataSendKey);
        keyword.click(btnSavem);
        keyword.untilJqueryIsDone(30L);
        keyword.assertEquals(expect, actual);
    }

    //    editAddressWithCustomerNotLogin
    public void editAddressWithCustomerNotLogin() throws InterruptedException {
        keyword.click("LA_INPUT_SAVE_ADDRESS");
        editFormAddressAndVerify("LA_INPUT_SAVE_ADDRESS", "LA_BTN_EDIT",
                "LA_INPUT_FILL_DATA_FIRST_NAME", "LA_DATA_NAME_EDIT",
                "LA_MESSAGE_SAVE_SUCCESS", "LA_INPUT_MESSAGE_SAVE_SUCCESS");
    }

    //editAddressWithCusomerLogin
    public void editAddressWithCusomerLogin() throws InterruptedException {
        editFormAddressAndVerify("LA_EDIT_BTN_SAVE", "LA_BTN_EDIT",
                "LA_EDIT_NAME", "LA_DATA_NAME_EDIT",
                "LA_MESSAGE_UPDATE_SUCCESS", "LA_INPUT_MESSAGE_SAVE_SUCCESS");

    }

    //Add New Address successfully with customer login
    public void addNewAddress() throws InterruptedException {
        keyword.clearLocalStorage();
        keyword.reLoadPage();
        keyword.sendKeys("LA_INPUT_USE_NAME", "LA_DATA_EMAIL");
        keyword.sendKeys("LA_INPUT_ACCOUNT_PASSWORD", "REGIST_DATA_PASSWORD");
        keyword.click("LA_BTN_LOGIN");
        keyword.untilJqueryIsDone(30L);
        keyword.click("LA_BTN_ADD_ADDRESS");
        keyword.untilJqueryIsDone(20L);
        keyword.click("LA_EDIT_BTN_SAVE");
        keyword.assertEquals("LA_MESSAGE_UPDATE_SUCCESS", "LA_INPUT_MESSAGE_SAVE_SUCCESS");
    }

    //    addNewAddressFillAllRequiredField
    public void addNewAddressFillAllRequiredField() throws InterruptedException {
        keyword.click("LA_BTN_ADD_ADDRESS");
        keyword.clearText("LA_INPUT_FILL_DATA_FIRST_NAME");
        keyword.clearText("LA_INPUT_FILL_DATA_LAST_NAME");
        keyword.clearText("LA_INPUT_FILL_DATA_PHONE");
        keyword.clearText("LA_INPUT_FILL_DATA_COMPANY");
        keyword.clearText("LA_INPUT_FILL_DATA_STREET");
        keyword.clearText("LA_INPUT_FILL_DATA_POSTCODE");
        keyword.clearText("LA_INPUT_FILL_DATA_CITY");
        keyword.click("LA_EDIT_BTN_SAVE");
    }

    //    removeAddressWithCustomerLogin
    public void removeAddressWithCustomerLogin() throws InterruptedException {
        keyword.click("LA_BTN_DELETE_ADDRESS");
//        keyword.verifyElementVisible("LA_POPUP_EDIT_INFO_ADDRESS");
//        objSignUp.clearTextAndSendKey("LA_EDIT_NAME","LA_EDIT_NAME","LA_DATA_NAME_EDIT");
//        keyword.untilJqueryIsDone(30L);
        keyword.verifyElementVisible("LA_POPUP_CONFIRM_DELETE");
        keyword.click("LA_BTN_OK_DELETE_ADDRESS");
        keyword.checkElementIsNotDisplayed("LA_POPUP_CONFIRM_DELETE");
    }

    //  button submit
    public void clickButtonSubmit(String buttonSubmit) {
        keyword.click(PropertiesFile.getPropValue(buttonSubmit));
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

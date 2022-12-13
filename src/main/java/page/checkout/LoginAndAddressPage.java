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

    public void scrollAndClickElement(String elementScroll, String elementClick) throws InterruptedException {
        keyword.scrollDownToElement(elementScroll);
        keyword.untilJqueryIsDone(20L);
        keyword.click(elementClick);
    }

    public void selectProductAndGoToCheckOut(String element1, String element2, String element3) throws InterruptedException {
        scrollAndClickElement(element1, element1);
        keyword.untilJqueryIsDone(20L);
        scrollAndClickElement(element2, element2);
        keyword.untilJqueryIsDone(20L);
        scrollAndClickElement(element3, element3);
        keyword.untilJqueryIsDone(30L);
        keyword.click("PRD_BTN_ADDCART");
        keyword.untilJqueryIsDone(50L);
        keyword.click("CHECKOUT_VIEW_DETAIL");
        keyword.untilJqueryIsDone(30L);
        keyword.click("LA_BTN_PROCEED_TO_CHECKOUT");
    }

    public void sendKey(String firstName, String lastName, String email, String confirmEmail, String phone, String company, String street, String zipCode,String country) throws InterruptedException {
        keyword.sendKeys("LP_INPUT_FIRST_NAME", firstName);
        keyword.sendKeys("LP_INPUT_LAST_NAME", lastName);
        keyword.sendKeys("LP_INPUT_EMAIL",email);
        keyword.sendKeys("LP_INPUT_CONFIRM_EMAIL","LA_DATA_CONFIRM_EMAIL");
        keyword.sendKeys("LP_INPUT_TELEPHONE","LA_DATA_PHONE");
        keyword.sendKeys("LP_INPUT_COMPANY","LP_DATA_COMPANY");
        keyword.sendKeys("LP_INPUT_STREET","LP_DATA_STREET");
        keyword.sendKeys("LP_INPUT_POSTAL","LP_DATA_POSTAL");
        keyword.sendKeys("LP_INPUT_CITY","LP_DATA_CITY");
        keyword.sendKeys("LP_INPUT_CITY","LP_DATA_CITY");
    }

    //Login customer with Email not exist or Password invalid from checkout page
    public void loginCustomerWithEmailNotExistPassword() throws InterruptedException {
        objRegis = new RegisterPage(this.keyword);
        keyword.navigateToUrl("BASE_URL_CHECKOUT_NOT_LOGIN");
        objRegis.acceptAllCookies();
        selectProductAndGoToCheckOut("SELECT_PRODUCT_CHECKOUT", "PRD_DROPDOWN", "SELECT_RINGSIZE_OPTION");
        keyword.untilJqueryIsDone(50L);
        keyword.sendKeys("LA_INPUT_EMAIL", "LA_DATA_EMAIL");
        keyword.sendKeys("LA_INPUT_PASSWORD", "LA_DATA_PASSWORD");
        keyword.click("CHECKOUT_LA_BTN_LOGIN");
        keyword.untilJqueryIsDone(30L);
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
        keyword.verifyElementVisible("LP_FORGOT_PASSWORD_PAGE");
    }

    //Next to Payment page successfully with Guest option and Ship to this address is yes
    public void nextToPaymentPageWithAddress() throws InterruptedException {
        keyword.navigateToUrl("LP_URL_OLD_DESIGN");
        selectProductAndGoToCheckOut("LP_SELECT_PRODUCT_OLD", "LP_SELECT_RING_SIZE", "LP_CHOSE_RING_SIZE");
        keyword.click("LP_BTN_CONTINUE");
        keyword.sendKeys("LP_INPUT_FIRST_NAME", "LA_DATA_FIRST_NAME");
        keyword.sendKeys("LP_INPUT_LAST_NAME", "LA_DATA_LAST_NAME");


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

package test.checkout;

import core.AllureTestListener;
import core.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.checkout.LoginAndAddressPage;

import page.home.LoginPage;
import page.home.RegisterPage;

@Listeners({AllureTestListener.class})
public class LoginAndAddressTest extends BaseTest {
    private LoginAndAddressPage objLoginAdrPage;
    private LoginPage objLogin;
    private RegisterPage objRegis;

    public LoginAndAddressTest() {
        super();
    }

    @Test(priority = 1, description = "Choose any product to pay")
    public void testCase_01_checkOutOneProduct() throws InterruptedException {
        objLoginAdrPage = new LoginAndAddressPage(this.keyword);
        objLogin = new LoginPage(this.keyword);
        objRegis = new RegisterPage(this.keyword);
        objLogin.loginOnAlert();
        objRegis.acceptAllCookies();
        objRegis.chooseLanguages();
        objLoginAdrPage.goToPageProduct();
        objLoginAdrPage.clickButtonAddProduct();
        objLoginAdrPage.btnSubmitCheckOut();
        Thread.sleep(2000);
    }

    @Test(priority = 2, description = "manipulate the address input form confirm the fields")
    public void testCase_LA_06() {
        objLoginAdrPage.clickButtonSubmit("CHECKOUT_PROCEED");
    }

    @Test(priority = 3, description = "Enter all Data Login Address")
    public void testCase_LA07() throws InterruptedException {
        Thread.sleep(1000);
        objLoginAdrPage.webDriverWaitForElementPresent("CHECKOUT_FORM_LOGIN_ADDRESS"
        );
        objLoginAdrPage.senKey("CHECKOUT_DATA_FIRSTNAME", "CHECKOUT_DATA_FIRSNAME_ENTER");
        objLoginAdrPage.senKey("CHECKOUT_DATA_LASTNAME", "CHECKOUT_DATA_LASTNAME_ENTER");
        objLoginAdrPage.senKey("CHECKOUT_DATA_EMAIL", "CHECKOUT_DATA_EMAIL_ENTER");
        objLoginAdrPage.senKey("CHECKOUT_DATA_CONFIRMEMAIL", "CHECKOUT_DATA_CONFIRMEMAIL_ENTER");
        objLoginAdrPage.senKey("CHECKOUT_DATA_PHONE", "CHECKOUT_DATA_PHONE_ENTER_FAIL");
        objLoginAdrPage.senKey("CHECKOUT_DATA_COMPANY", "CHECKOUT_DATA_COMPANY_ENTER");
        objLoginAdrPage.senKey("CHECKOUT_DATA_STREET", "CHECKOUT_DATA_STREET_ENTER");
        objLoginAdrPage.senKey("CHECKOUT_DATA_ZIPCODE", "CHECKOUT_DATA_ZIPCODE_ENTER");
        objLoginAdrPage.senKey("CHECKOUT_DATA_CITY", "CHECKOUT_DATA_CITY_ENTER");
        objLoginAdrPage.clickButtonSubmit("CHECKOUT_PROCEED");
    }

    @Test(priority = 4, description = "Enter Email Fail (wrong format)")
    public void testCase_LA08() throws InterruptedException {
        objLoginAdrPage.webDriverWaitForElementPresent("CHECKOUT_MESSAGE_FAILE_EMAIL02");
        objLoginAdrPage.clearTextAndSendKey("CHECKOUT_DATA_CONFIRMEMAIL", "CHECKOUT_DATA_CONFIRMEMAIL", "CHECKOUT_DATA_EMAIL_FAILD_2");
        objLoginAdrPage.clickButtonSubmit("CHECKOUT_PROCEED");
    }

    @Test(priority = 5, description = "")
    public void testCase_LA09() throws InterruptedException {
        objLoginAdrPage.webDriverWaitForElementPresent("CHECKOUT_MESSAGE_FAILE_EMAIL03");
        objLoginAdrPage.clearTextAndSendKey("CHECKOUT_DATA_CONFIRMEMAIL", "CHECKOUT_DATA_CONFIRMEMAIL", "CHECKOUT_DATA_EMAIL_FAILD_1");
        objLoginAdrPage.webDriverWaitForElementPresent("CHECKOUT_MESSAGE_FAILE_EMAIL03");
        objLoginAdrPage.clearTextAndSendKey("CHECKOUT_DATA_CONFIRMEMAIL", "CHECKOUT_DATA_CONFIRMEMAIL", "CHECKOUT_DATA_EMAIL_ENTER");
    }

    @Test(priority = 6, description = "Enter Phone Fail (wrong format) ")
    public void testCase_LA10() throws InterruptedException {
        objLoginAdrPage.webDriverWaitForElementPresent("CHECKOUT_DATA_MESSAGE_PHONE");
        objLoginAdrPage.clearTextAndSendKey("CHECKOUT_DATA_PHONE", "CHECKOUT_DATA_PHONE", "CHECKOUT_DATA_PHONE_ENTER_FAIL01");
        objLoginAdrPage.webDriverWaitForElementPresent("CHECKOUT_DATA_MESSAGE_PHONE");
        objLoginAdrPage.clearTextAndSendKey("CHECKOUT_DATA_PHONE", "CHECKOUT_DATA_PHONE", "CHECKOUT_DATA_PHONE_ENTER_SUCCESS01");
        objLoginAdrPage.clickButtonSubmit("CHECKOUT_PROCEED");
        objLoginAdrPage.webDriverWaitForElementPresent("CHECKOUT_BOOX_MESSAGE_FAIL");
        Thread.sleep(2000);
        objLoginAdrPage.clickButtonSubmit("CHECKOUT_BTN_CANCEL");
        objLoginAdrPage.clearTextAndSendKey("CHECKOUT_DATA_STREET", "CHECKOUT_DATA_STREET", "CHECKOUT_DATA_STREET_ENTER01");
        objLoginAdrPage.clearTextAndSendKey("CHECKOUT_DATA_ZIPCODE", "CHECKOUT_DATA_ZIPCODE", "CHECKOUT_DATA_ZIPCODE_ENTER01");
        objLoginAdrPage.clearTextAndSendKey("CHECKOUT_DATA_CITY", "CHECKOUT_DATA_CITY", "CHECKOUT_DATA_CITY_ENTER01");
        objLoginAdrPage.clickButtonSubmit("CHECKOUT_PROCEED");
        Thread.sleep(7000);
    }

    @Test(priority = 8, description = "Customer login\n")
    public void testCase_LA18() {
        objLoginAdrPage.goBack();
    }

    @Test(priority = 9, description = "On checkout page, Click I forgot my password link")
    public void testCase_LA05() throws InterruptedException {
        objLoginAdrPage.forgotPassword();
    }
    @Test(priority = 10, description = "manipulate the login form without entering information")
    public void testCase_LA01() {
        objLoginAdrPage.clickButtonSubmit("CHECKOUT_BTN_LOGIN_RGT_CUSTOMER");
    }

    @Test(priority = 11, description = "Customer Login - Enter Data Email Error")
    public void testCase_LA2() throws InterruptedException {
        objLoginAdrPage.LoginAngVerifyCustomerRegisWitInvalidhEmail("CHECKOUT_MESSAGE_EMAIL_ERROR", "CHECKOUT_MESSAGE_PASSW_ERROR");
        objLoginAdrPage.clickButtonSubmit("CHECKOUT_BTN_LOGIN_RGT_CUSTOMER");
    }
    @Test(priority = 12, description = "re-enter email and password until correct")
    public void testCase_LA3() throws InterruptedException {
        objLoginAdrPage.invalidEmail("CHECKOUT_MESSAGE_INVALID_LOGIN_OR_PASSW", "CHECKOUT_DATA_EMAIL_ADDRESS", "CHECKOUT_DATA_PASSWORD");
        objLoginAdrPage.clickButtonSubmit("CHECKOUT_BTN_LOGIN_RGT_CUSTOMER");
    }
    @Test(priority = 13, description = "aa")
    public void testCase_LA04() {
    }
}

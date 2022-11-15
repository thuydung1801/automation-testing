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
    public void testCase_LA_05() throws InterruptedException {
        objLoginAdrPage.clickBtnSubmit();
    }

    @Test(priority = 3, description = "enter exceptions")
    public void testCase_LA06() throws InterruptedException {
        Thread.sleep(1000);
        objLoginAdrPage.enterDataUserName();
        objLoginAdrPage.enterDataEmail();
        objLoginAdrPage.senKey(
                "CHECKOUT_DATA_PHONE",
                "CHECKOUT_DATA_PHONE_ENTER_FAIL"
        );
        objLoginAdrPage.senKey(
                "CHECKOUT_DATA_COMPANY",
                "CHECKOUT_DATA_COMPANY_ENTER"
        );
        objLoginAdrPage.senKey(
                "CHECKOUT_DATA_STREET",
                "CHECKOUT_DATA_STREET_ENTER"
        );
        objLoginAdrPage.senKey(
                "CHECKOUT_DATA_ZIPCODE",
                "CHECKOUT_DATA_ZIPCODE_ENTER"
        );
        objLoginAdrPage.senKey(
                "CHECKOUT_DATA_CITY",
                "CHECKOUT_DATA_CITY_ENTER"
        );
        objLoginAdrPage.clickBtnSubmit();
    }

    @Test(priority = 4, description = "Enter Email Fail (wrong format)")
    public void testCase_LA07() throws InterruptedException {
        objLoginAdrPage.enterDataEmailFail1();
        objLoginAdrPage.clearTextAndSendKey(
                "CHECKOUT_DATA_CONFIRMEMAIL",
                "CHECKOUT_DATA_CONFIRMEMAIL",
                "CHECKOUT_DATA_EMAIL_FAILD_2");
        objLoginAdrPage.clickBtnSubmit();
    }

    @Test(priority = 5, description = "")
    public void testCase_LA08() throws InterruptedException {
        objLoginAdrPage.enterDataEmailFail2("CHECKOUT_MESSAGE_FAILE_EMAIL03");
        objLoginAdrPage.clearTextAndSendKey(
                "CHECKOUT_DATA_CONFIRMEMAIL",
                "CHECKOUT_DATA_CONFIRMEMAIL",
                "CHECKOUT_DATA_EMAIL_FAILD_1");
        objLoginAdrPage.clearTextAndSendKey("CHECKOUT_DATA_CONFIRMEMAIL",
                "CHECKOUT_DATA_CONFIRMEMAIL",
                "CHECKOUT_DATA_EMAIL_ENTER"
        );
    }

    @Test(priority = 6, description = "Enter Phone Fail (wrong format) ")
    public void testCase_LA09() throws InterruptedException {
        objLoginAdrPage.enterDataPhoneFail1
                (
                        "CHECKOUT_DATA_MESSAGE_PHONE",
                        "CHECKOUT_DATA_PHONE",
                        "CHECKOUT_DATA_PHONE_ENTER_FAIL01",
                        "CHECKOUT_DATA_PHONE_ENTER_SUCCESS01"
                );
        objLoginAdrPage.clickBtnSubmit();
        objLoginAdrPage.AddressValidation
                (
                        "CHECKOUT_BOOX_MESSAGE_FAIL",
                        "CHECKOUT_BTN_CANCEL");

        objLoginAdrPage.clearTextAndSendKey(
                "CHECKOUT_DATA_STREET",
                "CHECKOUT_DATA_STREET",
                "CHECKOUT_DATA_STREET_ENTER01"
        );
        objLoginAdrPage.clearTextAndSendKey(
                "CHECKOUT_DATA_ZIPCODE",
                "CHECKOUT_DATA_ZIPCODE",
                "CHECKOUT_DATA_ZIPCODE_ENTER01"
        );
        objLoginAdrPage.clearTextAndSendKey(
                "CHECKOUT_DATA_CITY",
                "CHECKOUT_DATA_CITY",
                "CHECKOUT_DATA_CITY_ENTER01"
        );
        objLoginAdrPage.clickBtnSubmit();
        Thread.sleep(7000);
    }

    @Test(priority = 8, description = "Customer login\n")
    public void testCase_LA18()  {
        objLoginAdrPage.goBack();
    }

    @Test(priority = 9, description = "manipulate the login form without entering information")
    public void testCase_LA01()  {
        objLoginAdrPage.customerLogin();
    }

    @Test(priority = 10, description = "Customer Login - Enter Data Email Error")
    public void testCase_LA2() throws InterruptedException {
        objLoginAdrPage.LoginAngVerifyCustomerRegisWitInvalidhEmail(
                "CHECKOUT_MESSAGE_EMAIL_ERROR",
                "CHECKOUT_MESSAGE_PASSW_ERROR");
        objLoginAdrPage.customerLogin();
    }

    @Test(priority = 11, description = "re-enter email and password until correct")
    public void testCase_LA3() throws InterruptedException {
        objLoginAdrPage.InvalidEmail
                (
                        "CHECKOUT_MESSAGE_INVALID_LOGIN_OR_PASSW",
                        "CHECKOUT_DATA_EMAIL_ADDRESS",
                        "CHECKOUT_DATA_PASSWORD"
                );
        objLoginAdrPage.customerLogin();
    }

    @Test(priority = 12, description = "aa")
    public void testCase_LA04()  {

    }
}

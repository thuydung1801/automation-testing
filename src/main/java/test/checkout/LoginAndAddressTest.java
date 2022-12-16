package test.checkout;

import core.AllureTestListener;
import core.BaseTest;
import core.LogHelper;
import org.slf4j.Logger;
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

    private static Logger logger = LogHelper.getLogger();

    //    @Test(priority = 1, description = "Login customer with Email not exist or Password invalid from checkout page")
    public void testCase_LA_02() throws InterruptedException {
        logger.info("testCase_LA_02");
        objLoginAdrPage = new LoginAndAddressPage(this.keyword);
        objLogin = new LoginPage(this.keyword);
        objLogin.loginOnAlert();
        objLoginAdrPage.loginCustomerWithEmailNotExistPassword();
    }

    //    @Test(priority = 2, description = "Input invalid email on the Login and Address tab")
    public void testCase_LA_03() throws InterruptedException {
        logger.info("testCase_LA_03");
        objLoginAdrPage.invalidEmailOnTheLogin();
    }

    //    @Test(priority = 3, description = "Leave blank Email and Password")
    public void testCase_LA_04() throws InterruptedException {
        logger.info("testCase_LA_04");
        objLoginAdrPage.leaveBlankEmialAndPassword();
    }

    //    @Test(priority = 4, description = "Check link forgot password")
    public void testCase_LA_05() throws InterruptedException {
        logger.info("testCase_LA_05");
        objLoginAdrPage.checkLinkForgotPassword();
    }

    @Test(priority = 5, description = "Next to Payment page successfully with Guest option and Ship to this address is yes")
    public void testCase_LA_08() throws InterruptedException {
        logger.info("testCase_LA_08");
//        objRegis = new RegisterPage(this.keyword);
//        objRegis.acceptAllCookies();
        objLoginAdrPage = new LoginAndAddressPage(this.keyword);
        objLogin = new LoginPage(this.keyword);
        objLogin.loginOnAlert();
        objLoginAdrPage.nextToPaymentPageWithAddress();
    }

    @Test(priority = 6, description = "Input Email/Email Confirm form invalid data")
    public void testCase_LA_09() throws InterruptedException {
        logger.info("testCase_LA_09");
        objLoginAdrPage.emailInvalid();
    }

    @Test(priority = 7, description = "Using copy/paste email for Email confirm form")
    public void testCase_LA_010() throws InterruptedException {
        logger.info("testCase_LA_010");
        objLoginAdrPage.copyPasteEmail();
    }

    @Test(priority = 8, description = "Next to Payment page with leave blank with the required form")
    public void testCase_LA_011() throws InterruptedException {
        logger.info("testCase_LA_011");
        objLoginAdrPage.leaveBlankRequiredForm();

    }

    @Test(priority = 9, description = "Input invalid phone on the Login and Address tab")
    public void testCase_LA_012() throws InterruptedException {
        logger.info("testCase_LA_012");
        objLoginAdrPage.enterInvalidPhone();
    }

    @Test(priority = 10, description = "Next to Payment page successfully with Guest option and Ship to this address is yes")
    public void testCase_LA_06() throws InterruptedException {
        logger.info("testCase_LA_06");
        objLoginAdrPage.nextToPaymentSuccess();
    }

    @Test(priority = 11, description = "Next to Payment page successfully with Guest option and Ship to this address is yes ,select button sip to address ")
    public void testCase_LA_07() throws InterruptedException {
        logger.info("testCase_LA_07");
        objLoginAdrPage.nextToPaymentSuccessOnChangeNoShipToAddress();
    }

    @Test(priority = 12, description = "Edit Address successfully with customer not login")
    public void testCase_LA_018() throws InterruptedException {
        logger.info("testCase_LA_018");
        objLoginAdrPage.editAddressWithCustomerNotLogin();
    }
    @Test(priority = 13, description = "Add New Address successfully with customer login")
    public void testCase_LA_021() throws InterruptedException {
        logger.info("testCase_LA_019");
        objLoginAdrPage.addNewAddress();
    }
    @Test(priority = 14, description = "Add New Address and didn't fill all required field")
    public void testCase_LA_022() throws InterruptedException {
        logger.info("testCase_LA_019");
        objLoginAdrPage.addNewAddressFillAllRequiredField();
    }
    @Test(priority = 15, description = "Remove Address successfully with customer login")
    public void testCase_LA_019() throws InterruptedException {
        logger.info("testCase_LA_019");
        objLoginAdrPage.removeAddressWithCustomerLogin();
    }
    @Test(priority = 16, description = "Edit Address successfully with customer login")
    public void testCase_LA_020() throws InterruptedException {
        logger.info("testCase_LA_019");
        objLoginAdrPage.editAddressWithCusomerLogin();
    }



}

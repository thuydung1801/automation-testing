package test.checkout;

import core.AllureTestListener;
import core.BaseTest;
import core.LogHelper;
import org.apache.log4j.Priority;
import org.slf4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.checkout.LoginAndAddressPage;

import page.home.LoginPage;
import page.home.RegisterPage;

@Listeners({AllureTestListener.class})
public class LoginAndAddressTest extends BaseTest {
    private static Logger logger = LogHelper.getLogger();
    private LoginAndAddressPage objLoginAdrPage;
    private LoginPage objLogin;
    private RegisterPage objRegis;

    public LoginAndAddressTest() {
        super();
    }

    @Test(priority = 1)
    public void testcase_01_checkOutOneProduct() throws InterruptedException {
        objLoginAdrPage = new LoginAndAddressPage(this.keyword);
        objLogin = new LoginPage(this.keyword);
        objRegis = new RegisterPage(this.keyword);
        objLogin.loginOnAlert();
        objRegis.acceptAllCookies();
        objRegis.chooseLanguages();
        objLoginAdrPage.goToPageProduct();
        objLoginAdrPage.clickPtnAddProduct();
        objLoginAdrPage.btnSubmitCheckOut();
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void testcase_LA_05() throws InterruptedException {
        objLoginAdrPage.clickBtnSubmit();
    }

    @Test(priority = 3)
    public void testcase_LA06() throws InterruptedException {
        Thread.sleep(1000);
        objLoginAdrPage.enterDataUserName();
        objLoginAdrPage.enterDataEmial();
        objLoginAdrPage.enterDataPhone();
        objLoginAdrPage.enterDataCompany();
        objLoginAdrPage.enterDataStreet();
        objLoginAdrPage.enterDataZipCode();
        objLoginAdrPage.enterDataCity();
        objLoginAdrPage.clickBtnSubmit();
    }

    @Test(priority = 4, description = "Enter Email Fail (wrong format)")
    public void testcase_LA07() throws InterruptedException {
        objLoginAdrPage.enterDataEmailFail1();
        objLoginAdrPage.clickBtnSubmit();
    }

    @Test(priority = 5, description = "")
    public void tescase_LA08() throws InterruptedException {
        objLoginAdrPage.enterDataEmailFail2("CHECKOUT_MESSAGE_FAILE_EMAIL03");
    }

    @Test(priority = 6, description = "Enter Phone Fail (wrong format) ")
    public void testcase_LA09() throws InterruptedException {
        objLoginAdrPage.enterDataPhoneFail1("CHECKOUT_DATA_PHONE",
                "CHECKOUT_DATA_PHONE_ENTER_SUCCESS");
        objLoginAdrPage.clickBtnSubmit();
    }
    @Test(priority = 7, description = "")
    public void testcase_LA10() throws InterruptedException {
    }
}

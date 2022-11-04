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
        objLoginAdrPage.GuestNewCustomer();

    }

    @Test(priority = 2)
    public void testcase_02_enterDataAddresse() throws InterruptedException {
        Thread.sleep(1000);
        objLoginAdrPage.enterDataAddresse();
    }
}

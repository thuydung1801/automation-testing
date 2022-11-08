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

    @Test(priority = 4)
    public void testcase_LA07() throws InterruptedException {
        objLoginAdrPage.enterDataEmailFail();
        objLoginAdrPage.clickBtnSubmit();
    }
}

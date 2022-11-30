package test.checkout;

import core.AllureTestListener;
import core.BaseTest;
import core.LogHelper;
import org.slf4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.checkout.LoginAddressPage;
import page.checkout.ShoppingBagPage;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;

@Listeners({ AllureTestListener.class })
public class LoginAddressTest extends BaseTest {
    private static Logger logger = LogHelper.getLogger();
    private ShoppingBagPage objShoppingBagPage;
    private LoginPage objLogin;

    public SignInPage objSignIn;
    private RegisterPage objRegist;
    private LoginAddressPage objLoginAddress;

    public LoginAddressTest() { super();}

    public void customerNotLogin() throws InterruptedException {
        objShoppingBagPage = new ShoppingBagPage(this.keyword);
        objLogin = new LoginPage(this.keyword);
        objRegist = new RegisterPage(this.keyword);
        objSignIn = new SignInPage(this.keyword);
        objLoginAddress = new LoginAddressPage(this.keyword);
        objLogin.loginOnAlert();
        objRegist.acceptAllCookies();
        objRegist.chooseLanguages();
    }

    @Test(priority = 1,
            description = "Add new billing address with all valid data and next page successfully")
    public void NLA_02() throws InterruptedException {
        logger.info("NLA_02");
        customerNotLogin();
        objShoppingBagPage.addProductWithOutOptions("https://dev3.glamira.com/glgb/glamira-bracelet-tanel.html?alloy=white_red-375&stone1=diamond-Brillant");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objLoginAddress.moveToAddressPage();
        objLoginAddress.fillContactInformation(false, "CHECKOUT_LA_DATA_STREET_1",
                "CHECKOUT_LA_DATA_CODE_1","CHECKOUT_LA_DATA_CITY_1");
        objLoginAddress.verifyMelissa();

    }
    @Test(priority = 2,
            description = "Add new billing address using suggest address with store no state")
    public void NLA_03() throws InterruptedException {
        logger.info("NLA_03");
        objLoginAddress.resetForNewCase();
        objShoppingBagPage.addProductWithOutOptions("https://dev3.glamira.com/glgb/glamira-bracelet-tanel.html?alloy=white_red-375&stone1=diamond-Brillant");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objLoginAddress.moveToAddressPage();
        objLoginAddress.fillContactInformation(true, null, null, null);
        objLoginAddress.verifyMelissa();

    }

    @Test(priority = 3,
            description = "Add new billing address and continue with your input options")
    public void NLA_05() throws InterruptedException {
        logger.info("NLA_05");
        //objLoginAddress.resetForNewCase();
        customerNotLogin();
        objShoppingBagPage.addProductWithOutOptions("https://dev3.glamira.com/glgb/glamira-bracelet-tanel.html?alloy=white_red-375&stone1=diamond-Brillant");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objLoginAddress.moveToAddressPage();
        objLoginAddress.fillContactInformation(false, "CHECKOUT_LA_DATA_STREET_3",
                "CHECKOUT_LA_DATA_CODE_2", "CHECKOUT_LA_DATA_CITY_2");
        objLoginAddress.chooseAddressOnValidation();
        objLoginAddress.verifyMelissa();
    }
}

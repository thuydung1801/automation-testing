package test.checkout;

import core.BaseTest;
import org.testng.annotations.Test;
import page.checkout.ShoppingBagPage;
import page.home.LoginPage;
import page.home.RegisterPage;

public class ShoppingBagTest extends BaseTest {
    private ShoppingBagPage objShoppingBagPage;

    private LoginPage objLogin;
    private RegisterPage objRegist;

    public ShoppingBagTest(){ super();}

    @Test
    public void testCase_SP_01() throws InterruptedException {
        objShoppingBagPage = new ShoppingBagPage(this.keyword);
        objLogin = new LoginPage(this.keyword);
        objRegist = new RegisterPage(this.keyword);

        objLogin.loginOnAlert();
        objRegist.acceptAllCookies();
        objRegist.chooseLanguages();
        objLogin.loginOnWebsite();
        objShoppingBagPage.addProduct("https://dev3.glamira.com/glgb/womens-ring-smart-ornament-skub7047.html?alloy=white-silber");


    }

}

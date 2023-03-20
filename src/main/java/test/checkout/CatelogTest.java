package test.checkout;

import core.BaseTest;
import core.LogHelper;
import org.slf4j.Logger;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.MarketingPage;
import page.checkout.CatelogPage;
import page.checkout.LoginAddressPage;
import page.checkout.ShoppingBagPage;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;

public class CatelogTest extends BaseTest {
    private static Logger logger = LogHelper.getLogger();
    private CatelogPage testCatelog;

    public CatelogTest(){
        super();
        testCatelog = new CatelogPage(this.keyword);
    }
    @Test(priority = 1)
    @Parameters({"baseURL"})
    public void checkSpecialDeals(String baseURL) throws InterruptedException {
        testCatelog.checkSpecialDeals(baseURL);
    }


}

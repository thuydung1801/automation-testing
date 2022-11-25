package test.checkout;

import core.AllureTestListener;
import core.BaseTest;
import core.LogHelper;
import org.slf4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.checkout.ShoppingBagPage;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;

@Listeners({ AllureTestListener.class })
public class CheckOutInUSStoreTest extends BaseTest {
    private static Logger logger = LogHelper.getLogger();
    private ShoppingBagPage objShoppingBagPage;

    private LoginPage objLogin;

    public SignInPage objSignIn;
    private RegisterPage objRegist;

    public CheckOutInUSStoreTest(){ super();}

    public void commonShopping() throws InterruptedException {
        objShoppingBagPage = new ShoppingBagPage(this.keyword);
        objLogin = new LoginPage(this.keyword);
        objRegist = new RegisterPage(this.keyword);
        objSignIn = new SignInPage(this.keyword);
        objLogin.loginOnAlert();
        keyword.navigateToUrl("https://dev3.glamira.com/glus/");
        objRegist.acceptAllCookies();
        objRegist.chooseLanguages();
        objLogin.loginOnWebsite("LOGIN_DATA_EMAIL","LOGIN_DATA_PASSWORD",
                "LOGIN_DATA_PHONE_LINH","LOGIN_DATA_PHONE_PASS", true);

    }

    //@Test(priority = 1, description="Check out with payment method Affirm")
    public void testCase_Affirm() throws InterruptedException {
        logger.info("testCase_Affirm");
        commonShopping();
        objShoppingBagPage.addProductWithGift("https://dev3.glamira.com/glus/universe-adore-5-mm.html?alloy=white_red-585&profile=prA&thickness=tn_1.6&womenstone=diamond-zirconia");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.checkOutWithAffirm();
    }

    @Test(priority = 2, description= "Add Extended plan successfully")
    public void testCase_MS_15() throws InterruptedException {
        logger.info("testCase_MS_15");
        commonShopping();
        objShoppingBagPage.addProductWithOutOptions("https://dev3.glamira.com/glus/glamira-men-pendant-weisded.html?alloy=yellow-585&stone1=diamond-Swarovsky");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.addExtendedPlan("CHECKOUT_BTN_EXTENDED");
        objShoppingBagPage.verifyExtendedProtectionPlan(35);
    }

    @Test(priority = 2, description= "Add Extended+ plan successfully")
    public void testCase_MS_16() throws InterruptedException {
        logger.info("testCase_MS_16");
        //commonShopping();
        //objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.addExtendedPlan("CHECKOUT_BTN_EXTENDED_PLUS");
        objShoppingBagPage.verifyExtendedProtectionPlan(60);
        objShoppingBagPage.removeProduct("CHECKOUT_ICON_REMOVE_PENDANT");
    }

    @Test(priority = 3, description= "Add Extended plan with item having 35% amount < amount min")
    public void testCase_MS_17() throws InterruptedException {
        logger.info("testCase_MS_17");
        //commonShopping();
        objShoppingBagPage.addProductWithOutOptions("https://dev3.glamira.com/glus/glamira-nose-pin-jadeline.html?alloy=white-585&stone1=diamond-Brillant");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.addExtendedPlan("CHECKOUT_BTN_EXTENDED");
        objShoppingBagPage.verifyExtendedProtectionPlanWithAmountMin("62");
    }

    @Test(priority = 4, description= "Add Extended + plan witn item having 60% amount < amount min")
    public void testCase_MS_18() throws InterruptedException {
        logger.info("testCase_MS_17");
        //commonShopping();
        //objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.addExtendedPlan("CHECKOUT_BTN_EXTENDED_PLUS");
        objShoppingBagPage.verifyExtendedProtectionPlanWithAmountMin("68");
    }

    @Test(priority = 5, description= "Remove Extended plan")
    public void testCase_MS_19() throws InterruptedException {
//        commonShopping();
//        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.addExtendedPlan("CHECKOUT_BTN_EXTENDED_PLUS");
        objShoppingBagPage.extendedIsNotApplied();
    }

    @Test(priority = 6, description= "Remove Extended+ plan")
    public void testCase_MS_20() throws InterruptedException {
        //commonShopping();
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.addExtendedPlan("CHECKOUT_BTN_EXTENDED");
        objShoppingBagPage.addExtendedPlan("CHECKOUT_BTN_EXTENDED");
        objShoppingBagPage.extendedIsNotApplied();
    }

    @Test(priority = 6, description= "Edit item with item has selected warranty option")
    public void testCase_MS_21() throws InterruptedException {
        //commonShopping();
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.addExtendedPlan("CHECKOUT_BTN_EXTENDED_PLUS");
        objShoppingBagPage.editMetalOptions();
        objShoppingBagPage.verifyExtendedProtectionPlan(60);

    }

    @Test(priority = 7, description= "Add Extended plan with item having 35% amount < amount min")
    public void testCase_MS_10() throws InterruptedException {
        logger.info("testCase_MS_10");
        //commonShopping();
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.clickEstimate();
        objShoppingBagPage.editTaxInformation("CHECKOUT_DATA_POSTAL_CODE_2");
        objShoppingBagPage.checkEstimateTax("CHECKOUT_DATA_TAX_PERCENT_12345");

    }

    @Test(priority = 8, description= "Add Extended plan with item having 35% amount < amount min")
    public void testCase_MS_11() throws InterruptedException {
        logger.info("testCase_MS_11");
        //commonShopping();
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.clickEstimate();
        objShoppingBagPage.editTaxInformation("CHECKOUT_DATA_POSTAL_CODE_1");
        objShoppingBagPage.checkEstimateTax("CHECKOUT_DATA_TAX_PERCENT_10031");

    }

}

package test.checkout;

import core.AllureTestListener;
import core.BaseTest;
import core.LogHelper;
import org.slf4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.MyAccountPage;
import page.checkout.ShoppingBagPage;
import page.checkout.ShoppingBagPageMobile;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;

@Listeners({ AllureTestListener.class })
public class ShoppingBagTestMobile extends BaseTest {
    private static Logger logger = LogHelper.getLogger();
    private ShoppingBagPage objShoppingBagPage;

    private LoginPage objLogin;

    public SignInPage objSignIn;
    private RegisterPage objRegist;
    private ShoppingBagPageMobile shoppingBagPageMobile;
    private MyAccountPage myAccountPage;

    public ShoppingBagTestMobile(){ super();}
    public void commonShopping() throws InterruptedException {
        objShoppingBagPage = new ShoppingBagPage(this.keyword);
        shoppingBagPageMobile = new ShoppingBagPageMobile(this.keyword);
        objLogin = new LoginPage(this.keyword);
        objRegist = new RegisterPage(this.keyword);
        objSignIn = new SignInPage(this.keyword);
        myAccountPage = new MyAccountPage(this.keyword);

        //objLogin.loginOnAlert();
        objRegist.acceptAllCookies();
        //objRegist.chooseLanguages();
//        objLogin.loginOnWebsite("LOGIN_DATA_EMAIL","LOGIN_DATA_PASSWORD",
//                "LOGIN_DATA_PHONE_LINH","LOGIN_DATA_PHONE_PASS", true);
          objLogin.loginOnMobile("LOGIN_DATA_EMAIL","LOGIN_DATA_PASSWORD");
    }
    @Test
    //(priority = 1, description = "Remove item from cart successfully with the shopping bag having 1 item")
    public void testCase_SP_02() throws InterruptedException{
        logger.info("testCase_SP_02");
        commonShopping();
//        shoppingBagPageMobile.setup();
        objShoppingBagPage.addProduct("https://stage.glamira.co.uk/mens-ring-smart-queen-skup7013.html?alloy=white-375&utm_widget=recommendation");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.removeProduct("CHECKOUT_ICON_REMOVE_MENRING");
        objShoppingBagPage.confirmMessage("CHECKOUT_MESSAGES_EMPTY");
    }
    @Test
    //(priority = 8, description = "Add engraving for couple ring")
    public void testCase_SP_17() throws InterruptedException {
        logger.info("testCase_SP_17");
//        commonShopping();
        objShoppingBagPage.addProductWithGift("https://stage.glamira.co.uk/charming-view.html?alloy=white-585&womenstone=diamond-zirconia");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.viewDetail("CHECKOUT_BTN_VIEWDETAIL_COUPLERING_MOBILE");
        objShoppingBagPage.inputEngravingwithCoupleRing("CHECKOUT_DATA_ENGRAVING","CHECKOUT_HYPERLINK_ADD"
                ,"CHECKOUT_TXT_WOMEN_ENGRAVING","CHECKOUT_TXT_MEN_ENGRAVING");
        shoppingBagPageMobile.inputCorrectly("CHECKOUT_DATA_ENGRAVING_MOBILE","CHECKOUT_LBL_ENGRAVING_MOBILE");

    }
    @Test
    //(priority = 15, description = "Checkout successfully")
    public void testCase_SP_26_RV_02_04() throws InterruptedException {
        logger.info("testCase_SP_26");
//        commonShopping();
        objShoppingBagPage.clickShoppingBagPage();
        //objShoppingBagPage.clickGiftWrapping();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.checkOutWithVisa("success");
    }
    @Test
    //(priority = 13, description ="Edit product with bridal set product")
    public void testCase_SP_24() throws InterruptedException {
        logger.info("testCase_SP_24");
        //commonShopping();
        objShoppingBagPage.addProductWithGift("https://stage.glamira.co.uk/universe-adore-5-mm.html?alloy=white_red-585&profile=prA&thickness=tn_1.6&womenstone=diamond-zirconia");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.clickEdit("CHECKOUT_BTN_EDIT_UNIVERSE");
        objShoppingBagPage.editCoupleRings();
        shoppingBagPageMobile.compareData("CHECKOUT_DATA_24_1","CHECKOUT_BAG_LBL_STONE_MOBILE");
        objShoppingBagPage.compareData("CHECKOUT_DATA_24_2","CHECKOUT_BAG_LBL_PROFILE_MOBILE");
        objShoppingBagPage.confirmMessage("CHECKOUT_BAG_LBL_SIZE");
    }
    @Test
    public void testCase_SP_04() throws InterruptedException{
        logger.info("testCase_SP_04");
        //commonShoppingWithOutCookies();
        objShoppingBagPage.addProduct("https://stage.glamira.co.uk/mens-ring-smart-queen-skup7013.html?alloy=white-375&utm_widget=recommendation");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.changeQty("CHECKOUT_DATA_QTY_2");

    }
    @Test
    //(priority = 19, description = "Place order with Paypal express /Affirm/... successfully")
    public void testCase_RV_07() throws InterruptedException {
        logger.info("testCase_RV_07");
        //commonShopping();
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.checkOutWithPayPal();
    }
    @Test
    public void testCase_Myorder_Return() throws InterruptedException {
        logger.info("testCase_Myorder_Return");
        commonShopping();
        shoppingBagPageMobile.stepReturn();
    }

}

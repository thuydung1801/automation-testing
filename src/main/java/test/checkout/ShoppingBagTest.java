package test.checkout;

import core.BaseTest;
import core.LogHelper;
import jdk.jfr.Description;
import org.slf4j.Logger;
import org.testng.annotations.Test;
import page.checkout.ShoppingBagPage;
import page.home.LoginPage;
import page.home.RegisterPage;

public class ShoppingBagTest extends BaseTest {
    private static Logger logger = LogHelper.getLogger();
    private ShoppingBagPage objShoppingBagPage;

    private LoginPage objLogin;
    private RegisterPage objRegist;

    public ShoppingBagTest(){ super();}

    public void commonShopping() throws InterruptedException {
        objShoppingBagPage = new ShoppingBagPage(this.keyword);
        objLogin = new LoginPage(this.keyword);
        objRegist = new RegisterPage(this.keyword);

        objLogin.loginOnAlert();
        objRegist.acceptAllCookies();
        objRegist.chooseLanguages();
        objLogin.loginOnWebsite();
    }

    @Test (priority = 4)
    @Description("Remove item from cart succcessfully with the shopping bag having mutiple items")
    public void testCase_SP_01() throws InterruptedException {
        logger.info("testCase_SP_01");
        commonShopping();

        objShoppingBagPage.addProduct("https://dev3.glamira.com/glgb/womens-ring-smart-ornament-skub7047.html?alloy=white-silber");
        objShoppingBagPage.addProduct("https://dev3.glamira.com/glgb/mens-ring-smart-queen-skup7013.html?alloy=white-375&utm_widget=recommendation");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.removeProduct("CHECKOUT_ICON_REMOVE_WOMENRING");

    }
    @Test (priority = 1)
    @Description("Remove item from cart successfully with the shopping bag having 1 item")
    public void testCase_SP_02() throws InterruptedException{
        logger.info("testCase_SP_02");
        commonShopping();

        objShoppingBagPage.addProduct("https://dev3.glamira.com/glgb/mens-ring-smart-queen-skup7013.html?alloy=white-375&utm_widget=recommendation");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.removeProduct("CHECKOUT_ICON_REMOVE_MENRING");
        objShoppingBagPage.confirmMessage("CHECKOUT_MESSAGES_EMPTY");
    }
    @Test (priority = 2)
    @Description("Remove item from cart successfully with the shopping bag having 1 normal item and 1 free gift")
    public void testCase_SP_03() throws InterruptedException{
        logger.info("testCase_SP_03");

        objShoppingBagPage.addProductWithGift("https://dev3.glamira.com/glgb/smart-ornament-skub7047.html?alloy=white-platin");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.removeProduct("CHECKOUT_ICON_REMOVE_COUPLERING");
        objShoppingBagPage.confirmMessage("CHECKOUT_MESSAGES_EMPTY");
        objShoppingBagPage.confirmMessage("CHECKOUT_MESSAGES_GIFT");

    }
    @Test (priority = 5)
    @Description("Update quantity using qty button successfully")
    public void testCase_SP_04() throws InterruptedException{
        logger.info("testCase_SP_04");

        objShoppingBagPage.addProduct("https://dev3.glamira.com/glgb/mens-ring-smart-queen-skup7013.html?alloy=white-375&utm_widget=recommendation");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.changeQty("CHECKOUT_DATA_QTY_2");

    }

    @Test (priority = 6)
    @Description("Checking situation that add more than 4 products with same type")
    public void testCase_SP_05() throws InterruptedException{
        logger.info("testCase_SP_05");
        commonShopping();
        objShoppingBagPage.clickShoppingBagPage();

        objShoppingBagPage.changeQty("CHECKOUT_DATA_QTY_MAX");
        objShoppingBagPage.confirmMessage("CHECKOUT_MESSAGES_GIFT_UPDATE");
        objShoppingBagPage.addProduct("https://dev3.glamira.com/glgb/mens-ring-smart-queen-skup7013.html?alloy=white-375&utm_widget=recommendation");
        objShoppingBagPage.confirmMessage("CHECKOUT_MESSAGES_ERROR");

    }
    @Test (priority = 3, description = "Add engraving with single ring")
    @Description("Add engraving for single ring")
    public void testCase_SP_15() throws InterruptedException {
        logger.info("testCase_SP_15");
        commonShopping();
        objShoppingBagPage.addProduct("https://dev3.glamira.com/glgb/glamira-ring-zanessa.html?alloy=white-585&stone1=diamond-sapphire&stone2=diamond-sapphire");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.viewDetail("CHECKOUT_BTN_VIEWDETAIL_GLAMIRARING");
        objShoppingBagPage.inputEngravingwithSingleRing("CHECKOUT_DATA_ENGRAVING",
                "CHECKOUT_HYPERLINK_ADD",
                "CHECKOUT_LBL_ENGRAVING_GLAMIRA");

    }
    @Test(priority = 8)
    @Description("Add engraving for couple ring")
    public void testCase_SP_17() throws InterruptedException {
        logger.info("testCase_SP_17");
        commonShopping();
        objShoppingBagPage.addProductWithGift("https://dev3.glamira.com/glgb/charming-view.html?alloy=white-585&womenstone=diamond-zirconia");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.viewDetail("CHECKOUT_BTN_VIEWDETAIL_COUPLERING");
        objShoppingBagPage.inputEngravingwithCoupleRing();

    }
    @Test(priority = 7)
    public void testCase_SP_16() throws Exception {
        logger.info("testCase_SP_16");
        commonShopping();
        objShoppingBagPage.addProductWithEngraving("https://dev3.glamira.com/glgb/glamira-ring-zanessa.html?alloy=white-585&stone1=diamond-sapphire&stone2=diamond-sapphire");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.viewDetail("CHECKOUT_BTN_VIEWDETAIL_GLAMIRARING");
        objShoppingBagPage.inputEngravingwithSingleRing("CHECKOUT_DATA_ENGRAVING_2","CHECKOUT_ICON_ADD",
                "CHECKOUT_LBL_ENGRAVING");

    }


}

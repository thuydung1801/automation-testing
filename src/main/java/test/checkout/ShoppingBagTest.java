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

import static org.testng.TestRunner.PriorityWeight.priority;

@Listeners({ AllureTestListener.class })
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
    public void commonShoppingWithOutCookies() throws InterruptedException {
        objShoppingBagPage = new ShoppingBagPage(this.keyword);
        objLogin = new LoginPage(this.keyword);

        objLogin.loginOnWebsite();
    }

    @Test (priority = 4, description = "Remove item from cart succcessfully with the shopping bag having mutiple items")
    public void testCase_SP_01() throws InterruptedException {
        logger.info("testCase_SP_01");
        //commonShoppingWithOutCookies();

        objShoppingBagPage.addProduct("https://dev3.glamira.com/glgb/womens-ring-smart-ornament-skub7047.html?alloy=white-silber");
        objShoppingBagPage.addProduct("https://dev3.glamira.com/glgb/mens-ring-smart-queen-skup7013.html?alloy=white-375&utm_widget=recommendation");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.removeProduct("CHECKOUT_ICON_REMOVE_WOMENRING");

    }
    @Test (priority = 1, description = "Remove item from cart successfully with the shopping bag having 1 item")
    public void testCase_SP_02() throws InterruptedException{
        logger.info("testCase_SP_02");
        commonShopping();

        objShoppingBagPage.addProduct("https://dev3.glamira.com/glgb/mens-ring-smart-queen-skup7013.html?alloy=white-375&utm_widget=recommendation");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.removeProduct("CHECKOUT_ICON_REMOVE_MENRING");
        objShoppingBagPage.confirmMessage("CHECKOUT_MESSAGES_EMPTY");
    }
    @Test (priority = 2, description="Remove item from cart successfully with the shopping bag having 1 normal item and 1 free gift")
    public void testCase_SP_03() throws InterruptedException{
        logger.info("testCase_SP_03");
        //commonShopping();
        objShoppingBagPage.addProductWithGift("https://dev3.glamira.com/glgb/smart-ornament-skub7047.html?alloy=white-platin");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.removeProduct("CHECKOUT_ICON_REMOVE_COUPLERING");
        objShoppingBagPage.confirmMessage("CHECKOUT_MESSAGES_EMPTY");
        objShoppingBagPage.confirmMessage("CHECKOUT_MESSAGES_GIFT");

    }
    @Test (priority = 5, description = "Update quantity using qty button successfully")
    public void testCase_SP_04() throws InterruptedException{
        logger.info("testCase_SP_04");
        //commonShoppingWithOutCookies();
        objShoppingBagPage.addProduct("https://dev3.glamira.com/glgb/mens-ring-smart-queen-skup7013.html?alloy=white-375&utm_widget=recommendation");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.changeQty("CHECKOUT_DATA_QTY_2");

    }

    @Test (priority = 6, description = "Checking situation that add more than 4 products with same type")
    public void testCase_SP_05() throws InterruptedException{
        logger.info("testCase_SP_05");
        //commonShoppingWithOutCookies();
        objShoppingBagPage.clickShoppingBagPage();

        objShoppingBagPage.changeQty("CHECKOUT_DATA_QTY_MAX");
        objShoppingBagPage.confirmMessage("CHECKOUT_MESSAGES_GIFT_UPDATE");
        objShoppingBagPage.addProduct("https://dev3.glamira.com/glgb/mens-ring-smart-queen-skup7013.html?alloy=white-375&utm_widget=recommendation");
        objShoppingBagPage.confirmMessage("CHECKOUT_MESSAGES_ERROR");

    }
    @Test (priority = 3, description = "Add engraving with single ring")
    public void testCase_SP_15() throws InterruptedException {
        logger.info("testCase_SP_15");
        //commonShopping();
        objShoppingBagPage.addProduct("https://dev3.glamira.com/glgb/glamira-ring-zanessa.html?alloy=white-585&stone1=diamond-sapphire&stone2=diamond-sapphire");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.viewDetail("CHECKOUT_BTN_VIEWDETAIL_GLAMIRARING");
        objShoppingBagPage.inputEngravingwithSingleRing("CHECKOUT_DATA_ENGRAVING",
                "CHECKOUT_HYPERLINK_ADD_15",
                "CHECKOUT_LBL_ENGRAVING_GLAMIRA");

    }
    @Test(priority = 8, description = "Add engraving for couple ring")
    public void testCase_SP_17() throws InterruptedException {
        logger.info("testCase_SP_17");
        //commonShopping();
        objShoppingBagPage.addProductWithGift("https://dev3.glamira.com/glgb/charming-view.html?alloy=white-585&womenstone=diamond-zirconia");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.viewDetail("CHECKOUT_BTN_VIEWDETAIL_COUPLERING");
        objShoppingBagPage.inputEngravingwithCoupleRing("CHECKOUT_DATA_ENGRAVING","CHECKOUT_HYPERLINK_ADD_17"
                ,"CHECKOUT_TXT_WOMEN_ENGRAVING","CHECKOUT_TXT_MEN_ENGRAVING");
        objShoppingBagPage.inputCorrectly("CHECKOUT_DATA_ENGRAVING","CHECKOUT_LBL_ENGRAVING");

    }
    @Test(priority = 7, description = "edit engraving")
    public void testCase_SP_16() throws Exception {
        logger.info("testCase_SP_16");
        //commonShoppingWithOutCookies();
        objShoppingBagPage.addProductWithEngraving("https://dev3.glamira.com/glgb/glamira-ring-zanessa.html?alloy=white-585&stone1=diamond-sapphire&stone2=diamond-sapphire");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.viewDetail("CHECKOUT_BTN_VIEWDETAIL_GLAMIRARING");
        objShoppingBagPage.inputEngravingwithSingleRing("CHECKOUT_DATA_ENGRAVING_2","CHECKOUT_ICON_ADD",
                "CHECKOUT_LBL_ENGRAVING_GLAMIRA");

    }
    @Test (priority = 9, description = "Edit engraving for the bridal set item")
    public void testCase_SP_18() throws InterruptedException {
        logger.info("testCase_SP_18");

        //commonShopping();

        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.viewDetail("CHECKOUT_BTN_VIEWDETAIL_COUPLERING");
        objShoppingBagPage.inputEngravingwithCoupleRing("CHECKOUT_DATA_ENGRAVING_2","CHECKOUT_ICON_ADD",
                "CHECKOUT_TXT_WOMEN_ENGRAVING_18","CHECKOUT_TXT_MEN_ENGRAVING_18");
        objShoppingBagPage.inputCorrectly("CHECKOUT_DATA_ENGRAVING_2","CHECKOUT_LBL_ENGRAVING");

    }
    @Test (priority = 10, description="Add engraving with text > max lenght")
    public void testCase_SP_19() throws InterruptedException {
        logger.info("testCase_SP_19");

        //commonShopping();

        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.viewDetail("CHECKOUT_BTN_VIEWDETAIL_COUPLERING");
        objShoppingBagPage.inputEngravingwithCoupleRing("CHECKOUT_DATA_19","CHECKOUT_ICON_ADD",
                "CHECKOUT_TXT_WOMEN_ENGRAVING_18","CHECKOUT_TXT_MEN_ENGRAVING_18");
        objShoppingBagPage.inputError("CHECKOUT_LBL_MAXLENGTH_MESSAGES_1","CHECKOUT_LBL_MAXLENGTH_MESSAGES_2",
                "CHECKOUT_DATA_19_OUTPUT","CHECKOUT_LBL_ENGRAVING", true);

    }
    @Test(priority = 11, description = "Add engraving with some special character don't allow input")
    public void testCase_SP_20() throws InterruptedException {
        logger.info("testCase_SP_20");
        //commonShopping();
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.viewDetail("CHECKOUT_BTN_VIEWDETAIL_COUPLERING");
        objShoppingBagPage.inputEngravingwithCoupleRing("CHECKOUT_DATA_20","CHECKOUT_ICON_ADD",
                "CHECKOUT_TXT_WOMEN_ENGRAVING_18","CHECKOUT_TXT_MEN_ENGRAVING_18");
        objShoppingBagPage.inputError("CHECKOUT_LBL_ICON_MESSAGES_1","CHECKOUT_LBL_ICON_MESSAGES_2",
                "","", false);

    }
    @Test (priority = 12, description = "Edit product successfully with normal product")
        public void testCase_SP_21() throws InterruptedException {
        logger.info("testCase_SP_21");
        //commonShopping();
        objShoppingBagPage.addBraceletProduct("https://dev3.glamira.com/glgb/glamira-bracelet-tanel.html?alloy=white_red-375&stone1=diamond-Brillant");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.clickEdit("CHECKOUT_BTN_EDIT_BRACELET");
        objShoppingBagPage.editOptions();
    }

    //pending do bug
    //@Test(priority = 12, description = "Edit product successfully with pair earning product")
        public void testCase_SP_22() throws InterruptedException {
        logger.info("testCase_SP_22");
        commonShopping();
        objShoppingBagPage.addBraceletProduct("https://dev3.glamira.com/glgb/glamira-men-earring-torreon.html?alloy=white-375&stone1=diamond-Brillant");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.clickEdit("CHECKOUT_BTN_EDIT_EARING");
        objShoppingBagPage.editEaringOptions();
    }
    @Test(priority = 13, description ="Edit product with bridal set product")
    public void testCase_SP_24() throws InterruptedException {
        logger.info("testCase_SP_24");
        //commonShopping();
        objShoppingBagPage.addProductWithGift("https://dev3.glamira.com/glgb/universe-adore-5-mm.html?alloy=white_red-585&profile=prA&thickness=tn_1.6&womenstone=diamond-zirconia");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.clickEdit("CHECKOUT_BTN_EDIT_UNIVERSE");
        objShoppingBagPage.editCoupleRings();
        objShoppingBagPage.compareData("CHECKOUT_DATA_24_1","CHECKOUT_BAG_LBL_STONE");
        objShoppingBagPage.compareData("CHECKOUT_DATA_24_2","CHECKOUT_BAG_LBL_PROFILE");
        objShoppingBagPage.confirmMessage("CHECKOUT_BAG_LBL_SIZE");
    }

    @Test(priority = 14, description = "Edit product but missing fill required field")
    public void testCase_SP_25() throws InterruptedException {
        logger.info("testCase_SP_25");
        //commonShopping();
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.clickEdit("CHECKOUT_BTN_EDIT_UNIVERSE");
        objShoppingBagPage.missingFillSize();
        objShoppingBagPage.compareData("CHECKOUT_MESSAGES_UPDATE_24","CHECKOUT_LBL_MESSAGES_UPDATE_24");
    }
    @Test(priority = 15, description = "Checkout successfully")
    public void testCase_SP_26_RV_02_04() throws InterruptedException {
        logger.info("testCase_SP_26");
        //commonShopping();
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.clickGiftWrapping();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.checkOutWithVisa("success");
    }

    @Test(priority = 16, description = "Place order with Credit card but missing information card")
    public void testCase_RV_05() throws InterruptedException {
        logger.info("testCase_RV_05");
        //commonShopping();
        objShoppingBagPage.addProductWithGift("https://dev3.glamira.com/glgb/universe-adore-5-mm.html?alloy=white_red-585&profile=prA&thickness=tn_1.6&womenstone=diamond-zirconia");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.checkOutWithVisa("failByMissing");
    }

    @Test (priority = 17, description = "Place order with Card issue")
    public void testCase_RV_06() throws InterruptedException {
        logger.info("testCase_RV_06");
        //commonShopping();
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.checkOutWithVisa("failByCard");
    }

    @Test (priority = 19, description = "Place order with Paypal express /Affirm/... successfully")
    public void testCase_RV_07() throws InterruptedException {
        logger.info("testCase_RV_07");
        //commonShopping();
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.checkOutWithPayPal();
    }
    @Test(priority = 18, description = "Place order and don't choose any payment method")
    public void testCase_RV_10() throws InterruptedException {
        logger.info("testCase_RV_10");
        //commonShopping();
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.submit();
    }

    @Test(priority = 20, description = "Place order with Bank Transfer method successfully")
    public void testCase_RV_09() throws InterruptedException {
        logger.info("testCase_RV_09");
        //commonShopping();
        objShoppingBagPage.addProductWithGift("https://dev3.glamira.com/glgb/universe-adore-5-mm.html?alloy=white_red-585&profile=prA&thickness=tn_1.6&womenstone=diamond-zirconia");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.checkOutWithBankTransfer();
    }

    @Test (priority = 21, description = "Place order with Klanar method successfully")
    public void testCase_RV_08() throws InterruptedException {
        logger.info("testCase_RV_08");
        //commonShopping();
        objShoppingBagPage.addProductWithGift("https://dev3.glamira.com/glgb/universe-adore-5-mm.html?alloy=white_red-585&profile=prA&thickness=tn_1.6&womenstone=diamond-zirconia");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.checkOutWithKlarnaLater();
        objShoppingBagPage.clickPrint();
    }

    @Test (priority = 22, description = "Place order and apply full amount store credit successfully")
    public void testCase_RV_11() throws InterruptedException {
        logger.info("testCase_RV_11");
        commonShopping();
        objShoppingBagPage.addProductWithGift("https://dev3.glamira.com/glgb/universe-adore-5-mm.html?alloy=white_red-585&profile=prA&thickness=tn_1.6&womenstone=diamond-zirconia");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.checkOutWithStoreCredit("equals");
        objShoppingBagPage.clickPrint();

    }

    @Test (priority = 23, description = "Place order and apply full amount store credit successfully")
    public void testCase_RV_12() throws InterruptedException {
        logger.info("testCase_RV_12");
        commonShopping();
        objShoppingBagPage.addProductWithGift("https://dev3.glamira.com/glgb/universe-adore-5-mm.html?alloy=white_red-585&profile=prA&thickness=tn_1.6&womenstone=diamond-zirconia");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.checkOutWithStoreCredit("less");

    }
    @Test (priority = 24, description = "Place order and apply full amount store credit successfully")
    public void testCase_RV_13() throws InterruptedException {
        logger.info("testCase_RV_13");
        commonShopping();
        objShoppingBagPage.addProductWithGift("https://dev3.glamira.com/glgb/universe-adore-5-mm.html?alloy=white_red-585&profile=prA&thickness=tn_1.6&womenstone=diamond-zirconia");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.checkOutWithStoreCredit("wrong");

    }
    @Test (priority = 27, description = "Place order and apply full amount store credit successfully")
    public void testCase_RV_14() throws InterruptedException {
        logger.info("testCase_RV_14");
        commonShopping();
        objShoppingBagPage.addProductWithGift("https://dev3.glamira.com/glgb/universe-adore-5-mm.html?alloy=white_red-585&profile=prA&thickness=tn_1.6&womenstone=diamond-zirconia");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.checkOutWithStoreCredit("more");
    }

    @Test (priority = 25, description = "Place order and apply full amount store credit successfully")
    public void testCase_RV_15() throws InterruptedException {
        logger.info("testCase_RV_15");
        commonShopping();
        //objShoppingBagPage.addProductWithGift("https://dev3.glamira.com/glgb/universe-adore-5-mm.html?alloy=white_red-585&profile=prA&thickness=tn_1.6&womenstone=diamond-zirconia");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.checkOutWithStoreCredit("max");

    }

    @Test (priority = 26, description = "Place order and apply full amount store credit successfully")
    public void testCase_RV_16() throws InterruptedException {
        logger.info("testCase_RV_16");
        commonShopping();
        //objShoppingBagPage.addProductWithGift("https://dev3.glamira.com/glgb/universe-adore-5-mm.html?alloy=white_red-585&profile=prA&thickness=tn_1.6&womenstone=diamond-zirconia");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.cancelUseCredit();

    }


}

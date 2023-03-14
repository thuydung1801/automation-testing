package test.checkout;

import core.AllureTestListener;
import core.BaseTest;
import core.LogHelper;
import org.slf4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.checkout.ShoppingBagPage;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;

import java.net.URL;

@Listeners({ AllureTestListener.class })
public class ShoppingBagTest extends BaseTest {
    private static Logger logger = LogHelper.getLogger();
    private ShoppingBagPage objShoppingBagPage;

    private LoginPage objLogin;

    public SignInPage objSignIn;
    private RegisterPage objRegist;

    public ShoppingBagTest(){ super();}

    public void commonShopping() throws InterruptedException {
        objShoppingBagPage = new ShoppingBagPage(this.keyword);
        objLogin = new LoginPage(this.keyword);
        objRegist = new RegisterPage(this.keyword);
        objSignIn = new SignInPage(this.keyword);
        //objLogin.loginOnAlert();
        objRegist.acceptAllCookies();
        //objRegist.chooseLanguages();
        objLogin.loginOnWebsite("COM_INP_DATA_EMAIL_STAGE","COM_INP_DATA_PASS_STAGE",
                "LOGIN_DATA_PHONE_LINH","LOGIN_DATA_PHONE_PASS", true);
      //  objLogin.loginOnMobile("LOGIN_DATA_EMAIL","LOGIN_DATA_PASSWORD");
    }
    public void commonShopping1() throws InterruptedException {
        objShoppingBagPage = new ShoppingBagPage(this.keyword);
        objLogin = new LoginPage(this.keyword);
        objRegist = new RegisterPage(this.keyword);
        objSignIn = new SignInPage(this.keyword);
        //objLogin.loginOnAlert();
        objRegist.acceptAllCookies();
        //objRegist.chooseLanguages();
        objLogin.loginOnWebsite("COM_INP_DATA_EMAIL","COM_INP_DATA_PASS",
                "LOGIN_DATA_PHONE_LINH","LOGIN_DATA_PHONE_PASS", true);
        //  objLogin.loginOnMobile("LOGIN_DATA_EMAIL","LOGIN_DATA_PASSWORD");
    }

    @Test
//            (priority = 4, description = "Remove item from cart succcessfully with the shopping bag having mutiple items")
    @Parameters("baseURL")
    public void testCase_SP_01(String baseURL) throws InterruptedException {
        logger.info("testCase_SP_01");
//        commonShopping();
        //https://stage.glamira.co.uk/
        objShoppingBagPage.addProduct(baseURL+"womens-ring-smart-ornament-skub7047.html?alloy=white-silber");
        objShoppingBagPage.addProduct(baseURL+"mens-ring-smart-queen-skup7013.html?alloy=white-375&utm_widget=recommendation");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.removeProduct("CHECKOUT_ICON_REMOVE_WOMENRING");

    }
    //pending with reCapcha
    @Test
    @Parameters("baseURL")
    public void testCase_CheckoutWithGiftCard(String baseURL) throws InterruptedException {
        objShoppingBagPage.createGiftCard(baseURL);
    }
    @Test
//            (priority = 1, description = "Remove item from cart successfully with the shopping bag having 1 item")
    @Parameters("baseURL")
    public void testCase_SP_02(String baseURL) throws InterruptedException{
        logger.info("testCase_SP_02");
        commonShopping();
        //https://stage.glamira.co.uk/
        objShoppingBagPage.addProduct(baseURL+"mens-ring-smart-queen-skup7013.html?alloy=white-375&utm_widget=recommendation");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.removeProduct("CHECKOUT_ICON_REMOVE_MENRING");
        objShoppingBagPage.confirmMessage("CHECKOUT_MESSAGES_EMPTY");
    }
    @Test
//            (priority = 2, description="Remove item from cart successfully with the shopping bag having 1 normal item and 1 free gift")
    @Parameters("baseURL")
    public void testCase_SP_03(String baseURL) throws InterruptedException{
        logger.info("testCase_SP_03");
//        commonShopping();
        //https://stage.glamira.co.uk/
        objShoppingBagPage.addProductWithGift(baseURL+"smart-ornament-skub7047.html?alloy=white-platin");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.removeProduct("CHECKOUT_ICON_REMOVE_COUPLERING");
        objShoppingBagPage.confirmMessage("CHECKOUT_MESSAGES_EMPTY");
        //objShoppingBagPage.confirmMessage("CHECKOUT_MESSAGES_GIFT");

    }
    @Test
//            (priority = 5, description = "Update quantity using qty button successfully")
    @Parameters("baseURL")
    public void testCase_SP_04(String baseURL) throws InterruptedException{
        logger.info("testCase_SP_04");
        //commonShoppingWithOutCookies();
//        https://stage.glamira.co.uk/
        objShoppingBagPage.addProduct(baseURL+"mens-ring-smart-queen-skup7013.html?alloy=white-375&utm_widget=recommendation");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.changeQty("CHECKOUT_DATA_QTY_2");

    }

    @Test
//            (priority = 6, description = "Checking situation that add more than 4 products with same type")
    @Parameters("baseURL")
    public void testCase_SP_05(String baseURL) throws InterruptedException{
        logger.info("testCase_SP_05");
//        commonShopping();
//        commonShoppingWithOutCookies();
        objShoppingBagPage.clickShoppingBagPage();

        objShoppingBagPage.changeQty("CHECKOUT_DATA_QTY_MAX");
        objShoppingBagPage.confirmMessage("CHECKOUT_MESSAGES_GIFT_UPDATE");
        objShoppingBagPage.addProduct(baseURL+"mens-ring-smart-queen-skup7013.html?alloy=white-375&utm_widget=recommendation");
        objShoppingBagPage.confirmMessage("CHECKOUT_MESSAGES_ERROR");

    }
    @Test
//            (priority = 3, description = "Add engraving with single ring")
    @Parameters("baseURL")
    public void testCase_SP_15(String baseURL) throws InterruptedException {
        logger.info("testCase_SP_15");
        //commonShopping();
        //https://stage.glamira.co.uk/
        objShoppingBagPage.addProduct(baseURL+"glamira-ring-zanessa.html?alloy=white-585&stone1=diamond-sapphire&stone2=diamond-sapphire");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.viewDetail("CHECKOUT_BTN_VIEWDETAIL_GLAMIRARING");
        objShoppingBagPage.inputEngravingwithSingleRing("web","CHECKOUT_DATA_ENGRAVING",
                "CHECKOUT_HYPERLINK_ADD",
                "CHECKOUT_LBL_ENGRAVING_GLAMIRA");

    }
    @Test
            //(priority = 8, description = "Add engraving for couple ring")
    @Parameters("baseURL")
    public void testCase_SP_17(String baseURL) throws InterruptedException {
        logger.info("testCase_SP_17");
//        commonShopping();
        //https://stage.glamira.co.uk/
        objShoppingBagPage.addProductWithGift(baseURL+"charming-view.html?alloy=white-585&womenstone=diamond-zirconia");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.viewDetail("CHECKOUT_BTN_VIEWDETAIL_COUPLERING");
        objShoppingBagPage.inputEngravingwithCoupleRing("CHECKOUT_DATA_ENGRAVING","CHECKOUT_HYPERLINK_ADD"
                ,"CHECKOUT_TXT_WOMEN_ENGRAVING","CHECKOUT_TXT_MEN_ENGRAVING");
        objShoppingBagPage.inputCorrectly("CHECKOUT_DATA_ENGRAVING","CHECKOUT_LBL_ENGRAVING");

    }
    @Test
//            (priority = 7, description = "edit engraving")
    @Parameters("baseURL")
    public void testCase_SP_16(String baseURL) throws Exception {
        logger.info("testCase_SP_16");
        //commonShopping();
        //objShoppingBagPage.addProductWithEngraving("https://dev4.glamira.com/glau/glamira-ring-zanessa.html?alloy=white-585&stone1=diamond-sapphire&stone2=diamond-sapphire");
        //objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.backPage(baseURL);
        objShoppingBagPage.viewDetail("CHECKOUT_BTN_VIEWDETAIL_GLAMIRARING");
        objShoppingBagPage.inputEngravingwithSingleRing("web","CHECKOUT_DATA_ENGRAVING_2","CHECKOUT_ICON_ADD",
                "CHECKOUT_LBL_ENGRAVING_GLAMIRA");

    }
    @Test
//            (priority = 9, description = "Edit engraving for the bridal set item")
    @Parameters("baseURL")
    public void testCase_SP_18(String baseURL) throws InterruptedException {
        logger.info("testCase_SP_18");
        //commonShopping();
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.viewDetail("CHECKOUT_BTN_VIEWDETAIL_COUPLERING");
        objShoppingBagPage.inputEngravingwithCoupleRing("CHECKOUT_DATA_ENGRAVING_2","CHECKOUT_ICON_ADD",
                "CHECKOUT_TXT_WOMEN_ENGRAVING_18","CHECKOUT_TXT_MEN_ENGRAVING_18");
        objShoppingBagPage.inputCorrectly("CHECKOUT_DATA_ENGRAVING_2","CHECKOUT_LBL_ENGRAVING");

    }
    @Test
//            (priority = 10, description="Add engraving with text > max lenght")
    @Parameters("baseURL")
    public void testCase_SP_19(String baseURL) throws InterruptedException {
        logger.info("testCase_SP_19");

        //commonShopping();

        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.viewDetail("CHECKOUT_BTN_VIEWDETAIL_COUPLERING");
        objShoppingBagPage.inputEngravingwithCoupleRing("CHECKOUT_DATA_19","CHECKOUT_ICON_ADD",
                "CHECKOUT_TXT_WOMEN_ENGRAVING_18","CHECKOUT_TXT_MEN_ENGRAVING_18");
        objShoppingBagPage.inputError("CHECKOUT_LBL_MAXLENGTH_MESSAGES_1","CHECKOUT_LBL_MAXLENGTH_MESSAGES_2",
                "CHECKOUT_DATA_19_OUTPUT","CHECKOUT_LBL_ENGRAVING", true);

    }
//    @Test(priority = 11, description = "Add engraving with some special character don't allow input")
    public void testCase_SP_20(String baseURL) throws InterruptedException {
        logger.info("testCase_SP_20");
        //commonShopping();
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.viewDetail("CHECKOUT_BTN_VIEWDETAIL_COUPLERING");
        objShoppingBagPage.inputEngravingwithCoupleRing("CHECKOUT_DATA_20","CHECKOUT_ICON_ADD",
                "CHECKOUT_TXT_WOMEN_ENGRAVING_18","CHECKOUT_TXT_MEN_ENGRAVING_18");
        objShoppingBagPage.inputError("CHECKOUT_LBL_ICON_MESSAGES_1","CHECKOUT_LBL_ICON_MESSAGES_2",
                "","", false);

    }
    @Test
//            (priority = 12, description = "Edit product successfully with normal product")
    @Parameters("baseURL")
    public void testCase_SP_21(String baseURL) throws InterruptedException {
        logger.info("testCase_SP_21");
        //commonShopping();
        objShoppingBagPage.addProductWithOutOptions(baseURL+"glamira-bracelet-tanel.html?alloy=white_red-375&stone1=diamond-Brillant");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.clickEdit("CHECKOUT_BTN_EDIT_BRACELET");
        objShoppingBagPage.editOptions();
    }

    //pending do bug
    //@Test(priority = 12, description = "Edit product successfully with pair earning product")
        public void testCase_SP_22(String baseURL) throws InterruptedException {
        logger.info("testCase_SP_22");
        //commonShopping();
        //https://stage.glamira.co.uk/
        objShoppingBagPage.addProductWithOutOptions(baseURL+"glamira-men-earring-torreon.html?alloy=white-375&stone1=diamond-Brillant");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.clickEdit("CHECKOUT_BTN_EDIT_EARING");
        objShoppingBagPage.editEaringOptions();
    }
    @Test
            //(priority = 13, description ="Edit product with bridal set product")
    @Parameters("baseURL")
    public void testCase_SP_24(String baseURL) throws InterruptedException {
        logger.info("testCase_SP_24");
        //commonShopping();
        //https://stage.glamira.co.uk/
        objShoppingBagPage.addProductWithGift(baseURL+"universe-adore-5-mm.html?alloy=white_red-585&profile=prA&thickness=tn_1.6&womenstone=diamond-zirconia");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.clickEdit("CHECKOUT_BTN_EDIT_UNIVERSE");
        objShoppingBagPage.editCoupleRings();
        objShoppingBagPage.compareData("CHECKOUT_DATA_24_1","CHECKOUT_BAG_LBL_STONE");
        objShoppingBagPage.compareData("CHECKOUT_DATA_24_2","CHECKOUT_BAG_LBL_PROFILE");
        objShoppingBagPage.confirmMessage("CHECKOUT_BAG_LBL_SIZE");
    }

    @Test
//            (priority = 14, description = "Edit product but missing fill required field")
    @Parameters("baseURL")
    public void testCase_SP_25(String baseURL) throws InterruptedException {
        logger.info("testCase_SP_25");
        //commonShopping();
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.clickEdit("CHECKOUT_BTN_EDIT_UNIVERSE");
        objShoppingBagPage.missingFillSize();
        objShoppingBagPage.compareData("CHECKOUT_MESSAGES_UPDATE_24","CHECKOUT_LBL_MESSAGES_UPDATE_24");
    }
    @Test
            //(priority = 15, description = "Checkout successfully")
    @Parameters("baseURL")
    public void testCase_SP_26_RV_02_04(String baseURL) throws InterruptedException {
        logger.info("testCase_SP_26");
//        commonShopping();
        objShoppingBagPage.clickShoppingBagPage();
        //objShoppingBagPage.clickGiftWrapping();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.checkOutWithVisa("success","stage");
    }
    @Test
    //(priority = 15, description = "Checkout successfully")
    @Parameters("baseURL")
    public void testCase_SP_26_RV_02_04_dev(String baseURL) throws InterruptedException {
        logger.info("testCase_SP_26");
        commonShopping1();
        objShoppingBagPage.clickShoppingBagPage();
        //objShoppingBagPage.clickGiftWrapping();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.checkOutWithVisa("success","dev");
    }


    @Test
//            (priority = 16, description = "Place order with Credit card but missing information card")
    @Parameters("baseURL")
    public void testCase_RV_05(String baseURL) throws InterruptedException {
        logger.info("testCase_RV_05");
//        commonShopping();
        //https://stage.glamira.co.uk/
        objShoppingBagPage.addProductWithGift(baseURL+"universe-adore-5-mm.html?alloy=white_red-585&profile=prA&thickness=tn_1.6&womenstone=diamond-zirconia");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.checkOutWithVisa("emptyCardNumber",null);
        objShoppingBagPage.checkOutWithVisa("emptyExpirationDate",null);
        objShoppingBagPage.checkOutWithVisa("emptyCVC",null);
    }

    @Test
//            (priority = 17, description = "Place order with Card issue")
    @Parameters("baseURL")
    public void testCase_RV_06(String baseURL) throws InterruptedException {
        logger.info("testCase_RV_06");
        //commonShopping();
//        objShoppingBagPage.clickShoppingBagPage();
//        objShoppingBagPage.moveToPagecheckOut();
//        objShoppingBagPage.checkOut();
        objShoppingBagPage.checkOutWithVisa("failByCard",null);

    }

    @Test
            //(priority = 19, description = "Place order with Paypal express /Affirm/... successfully")
    @Parameters("baseURL")
    public void testCase_RV_07(String baseURL) throws InterruptedException {
        logger.info("testCase_RV_07");
        //commonShopping();
        objShoppingBagPage.backPage(baseURL);
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.checkOutWithPayPal();
    }
//    @Test
//            (priority = 18, description = "Place order and don't choose any payment method")
    @Parameters("baseURL")
    public void testCase_RV_10(String baseURL) throws InterruptedException {
        logger.info("testCase_RV_10");
        //commonShopping();
        objShoppingBagPage.backPage(baseURL);
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.submit();
    }

//    @Test
//            (priority = 20, description = "Place order with Bank Transfer method successfully")
    @Parameters("baseURL")
    public void testCase_RV_09(String baseURL) throws InterruptedException {
        logger.info("testCase_RV_09");
        //commonShopping();
        objShoppingBagPage.addProductWithGift(baseURL+"https://stage.glamira.co.uk/universe-adore-5-mm.html?alloy=white_red-585&profile=prA&thickness=tn_1.6&womenstone=diamond-zirconia");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.checkOutWithBankTransfer();
    }

//    @Test
            //(priority = 21, description = "Place order with Klanar method successfully")
    @Parameters("baseURL")
    public void testCase_RV_08(String baseURL) throws InterruptedException {
        logger.info("testCase_RV_08");
        //commonShopping();
        //objShoppingBagPage.addProductWithGift("https://stage.glamira.co.uk/universe-adore-5-mm.html?alloy=white_red-585&profile=prA&thickness=tn_1.6&womenstone=diamond-zirconia");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.checkOutWithKlarnaLater();
        //objShoppingBagPage.clickPrint();
    }

//    @Test
//            (priority = 22, description = "Place order and apply full amount store credit successfully")
    @Parameters("baseURL")
    public void testCase_RV_11(String baseURL) throws InterruptedException {
        logger.info("testCase_RV_11");
        //commonShopping();
        //https://stage.glamira.co.uk/
        objShoppingBagPage.addProductWithGift(baseURL+"universe-adore-5-mm.html?alloy=white_red-585&profile=prA&thickness=tn_1.6&womenstone=diamond-zirconia");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.checkOutWithStoreCredit("equals");
        objShoppingBagPage.clickPrint();

    }

//    @Test
//            (priority = 23, description = "Place order and apply partial store credit  successfully")
    @Parameters("baseURL")
    public void testCase_RV_12(String baseURL) throws InterruptedException {
        logger.info("testCase_RV_12");
        //commonShopping();
        //https://stage.glamira.co.uk/
        objShoppingBagPage.addProductWithGift(baseURL+"universe-adore-5-mm.html?alloy=white_red-585&profile=prA&thickness=tn_1.6&womenstone=diamond-zirconia");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.checkOutWithStoreCredit("less");

    }
//    @Test
//            (priority = 24, description = "Input invalid store credit")
    @Parameters("baseURL")
    public void testCase_RV_13(String baseURL) throws InterruptedException {
        logger.info("testCase_RV_13");
        //commonShopping();
        //https://stage.glamira.co.uk/
        objShoppingBagPage.addProductWithGift(baseURL+"universe-adore-5-mm.html?alloy=white_red-585&profile=prA&thickness=tn_1.6&womenstone=diamond-zirconia");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.checkOutWithStoreCredit("wrong");

    }
//    @Test
//            (priority = 27, description = "Place order and input store credit > total amount")
    @Parameters("baseURL")
    public void testCase_RV_14(String baseURL) throws InterruptedException {
        logger.info("testCase_RV_14");
        //commonShopping();
        //https://stage.glamira.co.uk/
        objShoppingBagPage.addProductWithGift(baseURL+"universe-adore-5-mm.html?alloy=white_red-585&profile=prA&thickness=tn_1.6&womenstone=diamond-zirconia");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.checkOutWithStoreCredit("more");
    }

//    @Test
//            (priority = 25, description = "Input store credit > store credit avaible")
    @Parameters("baseURL")
    public void testCase_RV_15(String baseURL) throws InterruptedException {
        logger.info("testCase_RV_15");
        //commonShopping();
        //https://stage.glamira.co.uk/
        objShoppingBagPage.addProductWithGift(baseURL+"universe-adore-5-mm.html?alloy=white_red-585&profile=prA&thickness=tn_1.6&womenstone=diamond-zirconia");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.checkOutWithStoreCredit("max");

    }
    //bug k hien thi messages khi cancel
//    @Test
//            (priority = 26, description = "Cancel store credit successfully")
    @Parameters("baseURL")
    public void testCase_RV_16(String baseURL) throws InterruptedException {
        logger.info("testCase_RV_16");
        //commonShopping();
        //https://stage.glamira.co.uk/
        objShoppingBagPage.addProductWithGift(baseURL+"universe-adore-5-mm.html?alloy=white_red-585&profile=prA&thickness=tn_1.6&womenstone=diamond-zirconia");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.cancelUseCredit();

    }

    @Test
//            (priority = 28, description = "Place order and apply full amount giftcard  successfully")

    @Parameters("baseURL")
    public void testCase_RV_17_19(String baseURL) throws InterruptedException {
        logger.info("testCase_RV_17_19");
        commonShopping();
        //https://stage.glamira.co.uk/
        objShoppingBagPage.addProductWithGift(baseURL+"universe-adore-5-mm.html?alloy=white_red-585&profile=prA&thickness=tn_1.6&womenstone=diamond-zirconia");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.applyCoupon("AUTOTEST",false);
        objShoppingBagPage.getOrderNumber();
        objShoppingBagPage.openNewTab();
        objShoppingBagPage.verifyOrderStatus("ORDER_STATUS_PROCESS");
        objShoppingBagPage.checkInvoices();
    }

    @Test
//            (priority = 29, description = "Place order and apply partial giftcard  successfully")
    @Parameters("baseURL")
    public void testCase_RV_18(String baseURL) throws InterruptedException {
        logger.info("testCase_RV_18");
        //commonShopping();
        //https://stage.glamira.co.uk/
        objShoppingBagPage.addProductWithGift(baseURL+"universe-adore-5-mm.html?alloy=white_red-585&profile=prA&thickness=tn_1.6&womenstone=diamond-zirconia");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.applyCoupon("AUTOTEST1",true);
        objShoppingBagPage.getOrderNumber();
        objShoppingBagPage.openNewTab();
        objShoppingBagPage.verifyOrderStatus("ORDER_STATUS_PENDING");
        objShoppingBagPage.checkGiftCardStatus("AUTOTEST1");

    }

    @Test
//            (priority = 30, description = "Apply a gift card having status Expired or Used")
    @Parameters("baseURL")
    public void testCase_RV_20(String baseURL) throws InterruptedException {
        logger.info("testCase_RV_20");
        //commonShopping();
        //https://stage.glamira.co.uk/
        objShoppingBagPage.addProductWithGift(baseURL+"universe-adore-5-mm.html?alloy=white_red-585&profile=prA&thickness=tn_1.6&womenstone=diamond-zirconia");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.applyUsedCoupon("AUTOTEST1");

    }

//    @Test
//            (priority = 31, description = "Place order and apply (store credit + giftcard)")
    @Parameters("baseURL")
    public void testCase_RV_21(String baseURL) throws InterruptedException {
        logger.info("testCase_RV_21");
//        commonShopping();
        //objShoppingBagPage.addProductWithGift("https://dev4.glamira.com/glau/universe-adore-5-mm.html?alloy=white_red-585&profile=prA&thickness=tn_1.6&womenstone=diamond-zirconia");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.applyCouponAnUseStoreCredit("TNZ_489_HJ96");

    }

    @Test
//            (priority = 32, description = "Place order with shipping label successfully")
    @Parameters("baseURL")
    public void testCase_RV_31(String baseURL) throws InterruptedException {
        logger.info("testCase_RV_31");
//        commonShopping();
        //https://stage.glamira.co.uk/
        objShoppingBagPage.addProductWithOutOptions(baseURL+"glamira-bracelet-tanel.html?alloy=white_red-375&stone1=diamond-Brillant");
        objShoppingBagPage.addShippingLabel(baseURL);

    }

    @Test
//            (priority = 33, description = "Place order and unchecked I have read and accepted the Terms & Conditions")
    @Parameters("baseURL")
    public void testCase_RV_32(String baseURL) throws InterruptedException {
        logger.info("testCase_RV_32");
        //commonShopping();
        //https://stage.glamira.co.uk/
        objShoppingBagPage.addProductWithOutOptions(baseURL+"glamira-bracelet-tanel.html?alloy=white_red-375&stone1=diamond-Brillant");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.notAccpectConditions();

    }
    @Test
//            (priority = 34, description = "Place order with shipping label successfully")
    @Parameters("baseURL")
    public void testCase_RV_33(String baseURL) throws InterruptedException {
        logger.info("testCase_RV_31");
        commonShopping();
        //https://stage.glamira.co.uk/
//        objShoppingBagPage.addProductWithOutOptions(baseURL+"glamira-bracelet-tanel.html?alloy=white_red-375&stone1=diamond-Brillant");
        objShoppingBagPage.addShippingLabel(baseURL);

    }


    //@Test
    public void checkOutStageDE() throws InterruptedException {
        objShoppingBagPage = new ShoppingBagPage(this.keyword);
        logger.info("checkOutStageDE");
        objShoppingBagPage.checkOutWithOldDesign();
    }



}

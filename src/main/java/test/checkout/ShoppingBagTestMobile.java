package test.checkout;

import core.AllureTestListener;
import core.BaseTest;
import core.LogHelper;
import org.slf4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
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
          objLogin.loginOnMobile("COM_INP_DATA_EMAIL_STAGE","COM_INP_DATA_PASS_STAGE");
    }
    //done SP02
    @Test
    //(priority = 1, description = "Remove item from cart successfully with the shopping bag having 1 item")
    @Parameters("baseURL")
    public void testCase_SP_02(String baseURL) throws InterruptedException{
        logger.info("testCase_SP_02");
        commonShopping();
//        shoppingBagPageMobile.setup();
        objShoppingBagPage.addProduct(baseURL+"mens-ring-smart-queen-skup7013.html?alloy=white-375&utm_widget=recommendation");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.removeProduct("CHECKOUT_ICON_REMOVE_MENRING");
        objShoppingBagPage.confirmMessage("CHECKOUT_MESSAGES_EMPTY");
    }
    @Test
    @Parameters("baseURL")
    public void testCase_CheckoutWithGiftCard(String baseURL) throws InterruptedException {
        objShoppingBagPage.createGiftCard(baseURL);
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
//            (priority = 3, description = "Add engraving with single ring")
    @Parameters("baseURL")
    public void testCase_SP_15(String baseURL) throws InterruptedException {
        logger.info("testCase_SP_15");
        //commonShopping();
        //https://stage.glamira.co.uk/
        objShoppingBagPage.addProduct(baseURL+"glamira-ring-zanessa.html?alloy=white-585&stone1=diamond-sapphire&stone2=diamond-sapphire");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.viewDetail("CHECKOUT_BTN_VIEWDETAIL_GLAMIRARING_MOBILE");
        objShoppingBagPage.inputEngravingwithSingleRing("mobile","CHECKOUT_DATA_ENGRAVING",
                "CHECKOUT_HYPERLINK_ADD",
                "CHECKOUT_LBL_ENGRAVING_GLAMIRA_MOBILE");

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
    //DONE SP04
    @Test
//            (priority = 5, description = "Update quantity using qty button successfully")
    @Parameters("baseURL")
    public void testCase_SP_04(String baseURL) throws InterruptedException{
        logger.info("testCase_SP_04");
        //commonShoppingWithOutCookies();
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
//            (priority = 7, description = "edit engraving")
    @Parameters("baseURL")
    public void testCase_SP_16(String baseURL) throws Exception {
        logger.info("testCase_SP_16");
        //commonShopping();
        //objShoppingBagPage.addProductWithEngraving("https://dev4.glamira.com/glau/glamira-ring-zanessa.html?alloy=white-585&stone1=diamond-sapphire&stone2=diamond-sapphire");
        //objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.backPage(baseURL);
        objShoppingBagPage.viewDetail("CHECKOUT_BTN_VIEWDETAIL_GLAMIRARING_MOBILE");
        objShoppingBagPage.inputEngravingwithSingleRing("mobile","CHECKOUT_DATA_ENGRAVING_2","CHECKOUT_ICON_ADD",
                "CHECKOUT_LBL_ENGRAVING_GLAMIRA_MOBILE");

    }
    //DONE SP17
    @Test
    //(priority = 8, description = "Add engraving for couple ring")
    @Parameters("baseURL")
    public void testCase_SP_17(String baseURL) throws InterruptedException {
        logger.info("testCase_SP_17");
//        commonShopping();
        objShoppingBagPage.addProductWithGift(baseURL+"charming-view.html?alloy=white-585&womenstone=diamond-zirconia");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.viewDetail("CHECKOUT_BTN_VIEWDETAIL_COUPLERING_MOBILE");
        objShoppingBagPage.inputEngravingwithCoupleRing("CHECKOUT_DATA_ENGRAVING","CHECKOUT_HYPERLINK_ADD"
                ,"CHECKOUT_TXT_WOMEN_ENGRAVING","CHECKOUT_TXT_MEN_ENGRAVING");
        shoppingBagPageMobile.inputCorrectly("CHECKOUT_DATA_ENGRAVING","CHECKOUT_LBL_ENGRAVING_MOBILE","web");

    }
    @Test
//            (priority = 9, description = "Edit engraving for the bridal set item")
    @Parameters("baseURL")
    public void testCase_SP_18(String baseURL) throws InterruptedException {
        logger.info("testCase_SP_18");
//        commonShopping();
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.viewDetail("CHECKOUT_BTN_VIEWDETAIL_COUPLERING_MOBILE");
        objShoppingBagPage.inputEngravingwithCoupleRing("CHECKOUT_DATA_ENGRAVING_2","CHECKOUT_ICON_ADD",
                "CHECKOUT_TXT_WOMEN_ENGRAVING_18","CHECKOUT_TXT_MEN_ENGRAVING_18");
        shoppingBagPageMobile.inputCorrectly("CHECKOUT_DATA_ENGRAVING_2","CHECKOUT_LBL_ENGRAVING_MOBILE","web");

    }
    @Test
//            (priority = 10, description="Add engraving with text > max lenght")
    @Parameters("baseURL")
    public void testCase_SP_19(String baseURL) throws InterruptedException {
        logger.info("testCase_SP_19");

        //commonShopping();

        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.viewDetail("CHECKOUT_BTN_VIEWDETAIL_COUPLERING_MOBILE");
        objShoppingBagPage.inputEngravingwithCoupleRing("CHECKOUT_DATA_19","CHECKOUT_ICON_ADD",
                "CHECKOUT_TXT_WOMEN_ENGRAVING_18","CHECKOUT_TXT_MEN_ENGRAVING_18");
        objShoppingBagPage.inputError("CHECKOUT_LBL_MAXLENGTH_MESSAGES_1","CHECKOUT_LBL_MAXLENGTH_MESSAGES_2",
                "CHECKOUT_DATA_19_OUTPUT","CHECKOUT_LBL_ENGRAVING_MOBILE", true);

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
    //DONE SP24
    @Test
    //(priority = 13, description ="Edit product with bridal set product")
    @Parameters("baseURL")
    public void testCase_SP_24(String baseURL) throws InterruptedException {
        logger.info("testCase_SP_24");
        //commonShopping();
        objShoppingBagPage.addProductWithGift(baseURL+"universe-adore-5-mm.html?alloy=white_red-585&profile=prA&thickness=tn_1.6&womenstone=diamond-zirconia");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.clickEdit("CHECKOUT_BTN_EDIT_UNIVERSE");
        objShoppingBagPage.editCoupleRings();
        shoppingBagPageMobile.compareData("CHECKOUT_DATA_24_1","CHECKOUT_BAG_LBL_STONE_MOBILE");
        objShoppingBagPage.compareData("CHECKOUT_DATA_24_2","CHECKOUT_BAG_LBL_PROFILE_MOBILE");
        objShoppingBagPage.confirmMessage("CHECKOUT_BAG_LBL_SIZE");
    }
    @Test
//            (priority = 14, description = "Edit product but missing fill required field")
    @Parameters("baseURL")
    public void testCase_SP_25(String baseURL) throws InterruptedException {
        logger.info("testCase_SP_25");
        //commonShopping();
        keyword.reLoadPage();
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.clickEdit("CHECKOUT_BTN_EDIT_UNIVERSE");
        objShoppingBagPage.missingFillSize();
        objShoppingBagPage.compareData("CHECKOUT_MESSAGES_UPDATE_24","CHECKOUT_LBL_MESSAGES_UPDATE_24");
    }

    //DONE SP26_RV02_04
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
//            (priority = 16, description = "Place order with Credit card but missing information card")
    @Parameters("baseURL")
    public void testCase_RV_05(String baseURL) throws InterruptedException {
        logger.info("testCase_RV_05");
//        commonShopping();
//        https://stage.glamira.co.uk/
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

    //DONE RV07
    @Test
    //(priority = 19, description = "Place order with Paypal express /Affirm/... successfully")
    @Parameters("baseURL")
    public void testCase_RV_07(String baseURL) throws InterruptedException {
        logger.info("testCase_RV_07");
//        commonShopping();
        objShoppingBagPage.backPage(baseURL);
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.checkOutWithPayPal();
    }
    @Test
//            (priority = 28, description = "Place order and apply full amount giftcard  successfully")

    @Parameters("baseURL")
    public void testCase_RV_17_19(String baseURL) throws InterruptedException {
        logger.info("testCase_RV_17_19");
//        commonShopping();
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
        keyword.resizeBrowser(319,848);
    }

    @Test
//            (priority = 29, description = "Place order and apply partial giftcard  successfully")
    @Parameters("baseURL")
    public void testCase_RV_18(String baseURL) throws InterruptedException {
        logger.info("testCase_RV_18");
//        commonShopping();
        //https://stage.glamira.co.uk/
        objShoppingBagPage.addProductWithGift(baseURL+"universe-adore-5-mm.html?alloy=white_red-585&profile=prA&thickness=tn_1.6&womenstone=diamond-zirconia");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.applyCoupon("TNZ_491_FX63",true);
        objShoppingBagPage.getOrderNumber();
        objShoppingBagPage.openNewTab();
        objShoppingBagPage.verifyOrderStatus("ORDER_STATUS_PENDING");
        objShoppingBagPage.checkGiftCardStatus("TNZ_491_FX63");
        keyword.resizeBrowser(319,848);
    }

    @Test
//            (priority = 30, description = "Apply a gift card having status Expired or Used")
    @Parameters("baseURL")
    public void testCase_RV_20(String baseURL) throws InterruptedException {
        logger.info("testCase_RV_20");
//        commonShopping();
        //https://stage.glamira.co.uk/
        objShoppingBagPage.addProductWithGift(baseURL+"universe-adore-5-mm.html?alloy=white_red-585&profile=prA&thickness=tn_1.6&womenstone=diamond-zirconia");
        objShoppingBagPage.clickShoppingBagPage();
        objShoppingBagPage.moveToPagecheckOut();
        objShoppingBagPage.checkOut();
        objShoppingBagPage.applyUsedCoupon("TNZ_491_FX63");
        keyword.resizeBrowser(319,848);
    }
    @Test
//            (priority = 32, description = "Place order with shipping label successfully")
    @Parameters("baseURL")
    public void testCase_RV_31(String baseURL) throws InterruptedException {
        logger.info("testCase_RV_31");
//        commonShopping();
        //https://stage.glamira.co.uk/
        objShoppingBagPage.addProductWithOutOptions(baseURL+"glamira-bracelet-tanel.html?alloy=white_red-375&stone1=diamond-Brillant");
        objShoppingBagPage.addShippingLabel(baseURL,false);

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
//        commonShopping();
        //https://stage.glamira.co.uk/
//        objShoppingBagPage.addProductWithOutOptions(baseURL+"glamira-bracelet-tanel.html?alloy=white_red-375&stone1=diamond-Brillant");
        objShoppingBagPage.addShippingLabel(baseURL,true);

    }

    //DONE
    @Test
    @Parameters("baseURL")
    public void testCase_Myorder_Return(String baseURL) throws InterruptedException {
        logger.info("testCase_Myorder_Return");
        commonShopping();
        shoppingBagPageMobile.stepReturn();
    }

}

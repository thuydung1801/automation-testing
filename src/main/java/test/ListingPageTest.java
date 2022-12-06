package test;

import core.BaseTest;
import core.LogHelper;
import org.slf4j.Logger;
import org.testng.annotations.Test;
import page.ListingPage;
import page.home.LoginPage;
import page.home.RegisterPage;

public class ListingPageTest extends BaseTest {
    private ListingPage testListingPage;
    private LoginPage objLogin;
    private RegisterPage objRegist;

    public ListingPageTest() {
        super();
    }
    private static Logger logger = LogHelper.getLogger();

    @Test(priority = 1, description = "Sticker on left filter when scrolling")
    public void testCase_LP01() throws InterruptedException {
        logger.info("testCase_LP01");
        testListingPage = new ListingPage((this.keyword));
        objRegist = new RegisterPage(this.keyword);
        objLogin = new LoginPage(this.keyword);
        objLogin.loginOnAlert();
        objRegist.acceptAllCookies();
        testListingPage.goToAllProduct();
    }
    @Test(priority = 2, description = "Check position of Sticker on left filter when applying filter option + scrolling")
    public void testCase_LP02() throws InterruptedException {
        logger.info("testCase_LP02");
        testListingPage.checkPositionOfSticker();
    }
    @Test(priority = 3, description = "Check position of Sticker on left filter when clicking to UPLOAD MORE button")
    public void testCase_LP03() throws InterruptedException {
        logger.info("testCase_LP03");
        testListingPage.checkPositionOfStickerWhenUpLoadMore();
    }
    @Test(priority = 4, description = "Check position of Sticker on left filter when applying filter option + scrolling")
    public void testCase_LP04() throws InterruptedException {
        logger.info("testCase_LP04");
        testListingPage.usingAjaxPageNotLoadAgain();
    }

    @Test(priority =5, description = "Filter price displayed when the option has been applied")
    public void testCase_LTP05() throws InterruptedException {
        logger.info("testCase_LP05");
        testListingPage.filterPrice();
    }

    @Test(priority = 6, description = "Remove 1 or many items filter")
    public void testCase_LTP06() throws InterruptedException {
        logger.info("testCase_LP06");
        testListingPage.removeItemsFilter();
    }
    @Test(priority = 7, description = "Filter 1 stone")
    public void testCase_LTP07() throws InterruptedException {
        logger.info("testCase_LP07");
        testListingPage.filterItem();
    }
////
//    @Test(priority = 6, description = "---Check Message Popup")
//    public void testCase_LTP05() throws InterruptedException {
//        Thread.sleep(1000);
//        testListingPage.popupMessage();
//    }
////
//    @Test(priority = 7, description = "---Check Like Product")
//    public void testCase_LTP06() throws InterruptedException {
//        Thread.sleep(1000);
//        testListingPage.likeProduct
//                (
//                        "LTP_BTN_VIEW_DETAIL_BOOKLIKE"
//                );
//        testListingPage.subLikeProduct("LTP_BTN_SAVED_ITEM");
//    }
}
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
    @Test(priority = 8, description = "Input data of Min > Max price")
    public void testCase_LTP09() throws InterruptedException {
        logger.info("testCase_LP09");
        testListingPage.enterPrice();
    }
    @Test(priority = 9, description = "Loading page endless with Upload more button instead of pagination")
    public void testCase_LTP015() throws InterruptedException {
        logger.info("testCase_LP015");
        testListingPage.checkUploadPage();
    }
    @Test(priority = 10, description = "The number of items in brackets must be the item limit each time the page loads, specifically: Upload More(30)")
    public void testCase_LTP016() throws InterruptedException {
        logger.info("testCase_LP016");
        testListingPage.checkUploadMore30Item();
    }
    @Test(priority = 11, description = "TLoading page endless with \"Upload more\" button - do not display this text when not a product load")
    public void testCase_LTP017() throws InterruptedException {
        logger.info("testCase_LP017");
        testListingPage.notShowButtonUploadMore();
    }
//    @Test(priority = 12, description = "Check show button : Upload more (Number products of listing page < 30 products)")
    public void testCase_LTP018() throws InterruptedException {
        logger.info("testCase_LP018");
        testListingPage.notShowButtonUploadMoreWhenProductOfPageLessThan30();
    }
}
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

    @Test(priority = 1, description = "Input data of Min > Max price")
    public void testCase_LP09() throws InterruptedException {
        logger.info("testCase_LP09");
        testListingPage = new ListingPage((this.keyword));
        objRegist = new RegisterPage(this.keyword);
        objLogin = new LoginPage(this.keyword);
        objLogin.loginOnAlert();
        objRegist.acceptAllCookies();
        testListingPage.goToAllProduct();
        testListingPage.filterPrice();
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

    @Test(priority = 12, description = "Check show button : Upload more (Number products of listing page < 30 products)")
    public void testCase_LTP018() throws InterruptedException {
        logger.info("testCase_LP018");
        testListingPage.notShowButtonUploadMoreWhenProductOfPageLessThan30();
    }
    @Test(priority = 12, description = "Check show button: Upload more when all the products on the page have been loaded  then go back to top and scrolling again")
    public void testCase_LTP019() throws InterruptedException {
        logger.info("testCase_LP019");
        testListingPage.checkButtonUploadMoreWhenShowFullProduct();
    }

@Test(priority = 12, description = "Auto loading product with 6 pages")
public void testCase_LTP020() throws InterruptedException {
    logger.info("testCase_LP020");
    testListingPage.checkButtonUploadMoreWhenShowFullProduct();
}
    @Test(priority = 12, description = "Check function saved this item")
    public void testCase_LTP040() throws InterruptedException {
        logger.info("testCase_LP043");
        testListingPage.checkButtonUploadMoreWhenShowFullProduct();
    }
}
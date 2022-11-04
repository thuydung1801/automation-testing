package test;

import core.BaseTest;
import org.testng.annotations.Test;
import page.ListingPage;
import page.home.LoginPage;

public class ListingPageTest extends BaseTest {
    private ListingPage testListingPage;
    private LoginPage objLogin;

    public ListingPageTest() {
        super();
    }

    @Test(priority = 1, description = "STEEP 1: GO TO LISTINGPAGE")
    public void testcase01_goToPageLT() throws InterruptedException {
        testListingPage = new ListingPage((this.keyword));
        objLogin = new LoginPage(this.keyword);
        objLogin.loginOnAlert();
        testListingPage.acceptAllCookies();
        testListingPage.goToAllProduct();
        Thread.sleep(1000);
    }

    @Test(priority = 2, description = "--- CHECK FILTER")
    public void testcase02_selectFilters() throws InterruptedException {
        testListingPage.filTerStone();
    }

    @Test(priority = 3, description = "---DELETE FILTER")
    public void testcase03_deleteFilters() throws InterruptedException {
        testListingPage.deleteFilters();
    }

    @Test(priority = 4, description = "---CHECK  VIEW SORT")
    public void testcase04_view() throws InterruptedException {
        testListingPage.sort_prd();
    }

    @Test(priority = 5, description = "--- CHECK SELECT STATUS VIEW")
    public void testcase05_selectView() throws InterruptedException {
        testListingPage.viewBTN();
    }
    @Test(priority = 6, description = "---CHECK MESSAGE POPUP")
    public void testcase06_checkMessage_Popup() throws InterruptedException {
        Thread.sleep(1000);
        testListingPage.popupMessage();
    }
    @Test(priority = 7, description = "---CHECK LIKE PRODUCT")
    public void testcase07_CheckLikeProduct() throws InterruptedException {
        Thread.sleep(1000);
        testListingPage.LikeProduct();
    }
}

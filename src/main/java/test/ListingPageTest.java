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

    @Test(priority = 1)
    public void testcase01_goToPageLT() throws InterruptedException {
        testListingPage = new ListingPage((this.keyword));
        objLogin = new LoginPage(this.keyword);
        objLogin.loginOnAlert();
        testListingPage.acceptAllCookies();
        testListingPage.goToAllProduct();
        Thread.sleep(1000);
    }

    @Test(priority = 2)
    public void testcase02_selectFilters() throws InterruptedException {
        testListingPage.filTerStone();
    }

    @Test(priority = 3)
    public void testcase03_deleteFilters() throws InterruptedException {
        testListingPage.deleteFilters();
    }

    @Test(priority = 4)
    public void testcase04_view() throws InterruptedException {
        testListingPage.sort_prd();
    }

    @Test(priority = 5)
    public void testcase05_selectView() throws InterruptedException {
        testListingPage.viewBTN();
    }

    @Test(priority = 6)
    public void testcase06_checkMessage_Popup() throws InterruptedException {
        Thread.sleep(1000);
        testListingPage.popupMessage();
    }
}

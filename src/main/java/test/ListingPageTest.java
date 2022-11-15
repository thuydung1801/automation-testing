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
        testListingPage.goToAllProduct(
                "ALL_RING_BTN",
                "SWITCH_BTN");
        Thread.sleep(1000);
    }

    @Test(priority = 2, description = "--- CHECK FILTER")
    public void testcase_LTP01() throws InterruptedException {
        testListingPage.checkFilterStonesAndVerify(
                "SELECT_DIAMON_STONES",
                "LTP_VERIFY_SELECT_DIAMOND_STONES_01",
                "LTP_VERIFY_DISPLAY_DIAMOND_STONES_01",
                "LTP_CHECK_STT_ELEMENT_01");
        testListingPage.checkFilterStonesAndVerify(
                "LTP_SELECT_PRECIOUS_STONE",
                "LTP_VERIFY_SELECT_PRECIOUS_STONES_01",
                "LTP_VERIFY_DISPLAY_PRECIOUS_STONES",
                "LTP_CHECK_STT_ELEMENT_PRECIOUS_01");
        testListingPage.checkFilterStonesAndVerify(
                "LTP_SELECT_SEMI_PRECIOUS_STONE",
                "LTP_VERIFY_SELECT_SEMI_PRECIOUS_STONE_01",
                "LTP_VERIFY_DISPLAY_SEMI_PRECIOUS_STONES",
                "LTP_CHECK_STT_ELEMENT_SEMI_PRECIOUS_01"
        );
        testListingPage.checkFilterStonesAndVerify(
                "LPT_SELECT_NATURAL_ZIRCON",
                "LTP_VERIFY_SELECT_NATURAL_ZIRCON",
                "LTP_VERIFY_DISPLAY_NATURAL_ZIRCON",
                "LTP_CHECK_STT_ELEMENT_NATURAL_ZIRCON"
        );
        testListingPage.checkFilterStonesAndVerify(
                "LTP_SELECT_COATED_TOPAZ",
                "LTP_VERIFY_SELECT_COATED_TOPAZ",
                "LTP_VERIFY_DISPLAY_COATED_TOPAZ",
                "LTP_CHECK_STT_ELEMENT_COATED_TOPAZ"
        );
        testListingPage.checkFilterStonesAndVerify(
                "LTP_SELECT_COLOR",
                "LTP_CLICK_SELECT_COLOR",
                "LTP_VERIFY_DISPLAY_COLOR",
                "LTP_CHECK_STT_ELEMENT_COLOR"
        );
//        testListingPage.scrollAndActive();
        testListingPage.checkFilterStonesAndVerify(
                "LTP_SELECT_METAL",
                "LTP_CLICK_SELECT_METAL",
                "LTP_VERIFY_DISPLAY_METAL",
                "LTP_CHECK_STT_ELEMENT_METAL"
        );
    }

    @Test(priority = 3, description = "---DELETE FILTER")
    public void testcase_LTP02() throws InterruptedException {
        testListingPage.deleteFilters();
    }

    @Test(priority = 4, description = "---CHECK  VIEW SORT")
    public void testcase_LTP03() throws InterruptedException {
        testListingPage.sort_prd();
    }
//
    @Test(priority = 5, description = "--- CHECK SELECT STATUS VIEW")
    public void testcase_LTP04() throws InterruptedException {
        testListingPage.viewBTN();
    }
//
    @Test(priority = 6, description = "---CHECK MESSAGE POPUP")
    public void testcase_LTP05() throws InterruptedException {
        Thread.sleep(1000);
        testListingPage.popupMessage();
    }
//
    @Test(priority = 7, description = "---CHECK LIKE PRODUCT")
    public void testcase_LTP06() throws InterruptedException {
        Thread.sleep(1000);
        testListingPage.LikeProduct
                (
                        "LTP_BTN_VIEW_DETAIL_BOOKLIKE"
                );
        testListingPage.subLikeProduct("LTP_BTN_SAVED_ITEM");
    }
}

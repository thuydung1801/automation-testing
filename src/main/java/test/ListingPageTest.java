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

    @Test(priority = 1, description = "GO TO LISTINGPAGE")
    public void testCase01_goToPageLT() throws InterruptedException {
        testListingPage = new ListingPage((this.keyword));
        objLogin = new LoginPage(this.keyword);
        objLogin.loginOnAlert();
        testListingPage.acceptAllCookies();
        testListingPage.goToAllProduct(
                "ALL_RING_BTN",
                "SWITCH_BTN");
        Thread.sleep(1000);
    }

    @Test(priority = 2, description = "--- Check Filter Left")
    public void testCase_LTP01() throws InterruptedException {
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
    @Test(priority = 3, description = "---Delete Filter")
    public void testCase_LTP02() throws InterruptedException {
        testListingPage.deleteFilters();
    }
    @Test(priority = 4, description = "---Check View Sort")
    public void testCase_LTP03() throws InterruptedException {
        testListingPage.sort_product();
    }

    @Test(priority = 5, description = "--- Check Select Status View")
    public void testCase_LTP04() throws InterruptedException {
        testListingPage.viewBTN();
    }
//
    @Test(priority = 6, description = "---Check Message Popup")
    public void testCase_LTP05() throws InterruptedException {
        Thread.sleep(1000);
        testListingPage.popupMessage();
    }
//
    @Test(priority = 7, description = "---Check Like Product")
    public void testCase_LTP06() throws InterruptedException {
        Thread.sleep(1000);
        testListingPage.LikeProduct
                (
                        "LTP_BTN_VIEW_DETAIL_BOOKLIKE"
                );
        testListingPage.subLikeProduct("LTP_BTN_SAVED_ITEM");
    }
}

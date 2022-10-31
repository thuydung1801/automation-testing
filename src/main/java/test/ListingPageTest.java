package test;
import core.BaseTest;
import org.testng.annotations.Test;
import page.ListingPage;
import page.Register;
public class ListingPageTest extends BaseTest {
    private ListingPage testListingPage;
    public ListingPageTest() {
        super();
    }
    @Test(priority = 1)
    public void testcase01_goToPageLT() throws InterruptedException {
        testListingPage = new ListingPage((this.keyword));
        testListingPage.acceptAllCookies();
        testListingPage.goToAllProduct();
        Thread.sleep(1000);
    }
    @Test(priority = 2)
    public void testcase02_selectFilters() throws InterruptedException {
        testListingPage = new ListingPage(this.keyword);
        testListingPage.filTerStone();
    }
    @Test(priority = 3)
    public void testcase03_deleteFilters() throws InterruptedException {
        testListingPage = new ListingPage(this.keyword);
        testListingPage.deleteFilters();
    }
    @Test(priority = 4)
    public void testcase04_view() throws InterruptedException {
        testListingPage = new ListingPage(this.keyword);
        testListingPage.short_prd();
    }
}

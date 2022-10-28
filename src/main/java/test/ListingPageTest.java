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

    @Test
    public void testcase01() throws InterruptedException {
        testListingPage = new ListingPage((this.keyword));
        testListingPage.acceptAllCookies();
        testListingPage.goToAllProduct();

    }
}

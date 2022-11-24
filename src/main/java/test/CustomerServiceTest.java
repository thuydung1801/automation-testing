package test;

import core.BaseTest;
import org.testng.annotations.Test;
import page.CustomerServicePage;
import page.ProductDetailPage;

public class CustomerServiceTest extends BaseTest {
    private CustomerServicePage testCustomerService;

    public CustomerServiceTest() {
        super();
        testCustomerService = new CustomerServicePage(this.keyword);

    }
    @Test(priority = 1, description = "My product detail/ Filter _ Filter reviews with ratting option")
    public void filter_ratting_01() throws InterruptedException {
        testCustomerService.filterWithRatting();

    }
    @Test(priority = 2,description = "Filter review with checkbox")
    public void filter_checkBox() throws InterruptedException {
        testCustomerService.filterWithCheckBox();

    }
    @Test(priority = 3,description = "Filter review with checksort")
    public void filter_checkSort() throws InterruptedException {
        testCustomerService.filterWithCheckSort();

    }
    @Test(priority = 4,description = "Filter review with checkbox and ratting")
    public void filter_checkBox_and_ratting() throws InterruptedException {
        testCustomerService.filterCheckBoxAndRatting();

    }
    @Test(priority = 5,description = "Filter review with checksort and ratting")
    public void filter_checkSort_and_ratting () throws InterruptedException {
        testCustomerService.filterWithCheckSortAndRatting();

    }

    @Test(priority = 6,description = "Filter review with checksort and checkbox")
    public void filter_checkSort_and_checkSort () throws InterruptedException {
        testCustomerService.filterCheckBoxAndCheckSort();

    }
    @Test(priority = 7,description = "Test case Newsletter")
    public void testCase_NL_01() throws InterruptedException {
        testCustomerService.myAccountSubscribeGlamiraNewsletter();
    }
    @Test(priority = 8,description = "Test case Newsletter")
    public void testCase_NL_02() throws InterruptedException {
        testCustomerService.myAccountUnSubscribeGlamiraNewsletter();
    }
    @Test(priority = 9,description = "Test case Newsletter")
    public void testCase_NL_03() throws InterruptedException {
        testCustomerService.footerSubscribeGlamiraNewsletter();
    }
    @Test(priority = 10,description = "Test case Newsletter")
    public void testCase_NL_04() throws InterruptedException {
        testCustomerService.footerSubscribeGlamiraNewsletterWithEmailNull();
    }
    @Test(priority = 11,description = "Test case Newsletter")
    public void testCase_NL_05() throws InterruptedException {
        testCustomerService.footerSubscribeGlamiraNewsletterWithNoCaptcha();
    }


}

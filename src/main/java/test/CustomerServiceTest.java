package test;

import core.BaseTest;
import org.testng.annotations.Test;
import page.CustomerServicePage;
import page.ProductDetailPage;

import java.text.ParseException;

public class CustomerServiceTest extends BaseTest {
    private CustomerServicePage testCustomerService;

    public CustomerServiceTest() {
        super();
        testCustomerService = new CustomerServicePage(this.keyword);

    }
    @Test(priority = 1, description = "My product detail/ Filter _ Filter reviews with ratting option")
    public void filter_ratting_01() throws InterruptedException {
        testCustomerService.filterWithRatting1();

    }
    @Test(priority = 2, description = "My product detail/ Filter _ Filter When the ratting has no reviews")
    public void filter_ratting_02() throws InterruptedException {
        testCustomerService.filterWithRatting2();

    }
    @Test(priority = 3,description = "Filter reviews with Show reviews with my current combination")
    public void filter_ratting_03() throws InterruptedException {
        testCustomerService.filterWithCheckBox1();

    }
    @Test(priority = 4,description = "Filter reviews with Only reviews from United Kingdom")
    public void filter_ratting_04() throws InterruptedException {
        testCustomerService.filterWithCheckBox2();

    }
    @Test(priority = 5,description = "Filter reviews with With images")
    public void filter_ratting_05() throws InterruptedException {
        testCustomerService.filterWithCheckBox3();

    }
    @Test(priority = 6,description = "Filter review with checkbox")
    public void filter_ratting_06() throws InterruptedException {
        testCustomerService.filterWithCheckBox4();

    }
    @Test(priority = 7,description = "when filter with filter has no results")
    public void filter_ratting_07() throws InterruptedException {
        testCustomerService.filterNoResults();

    }
    @Test(priority = 8,description = "Filter review with checksort")
    public void filter_ratting_08() throws InterruptedException {
        testCustomerService.filterWithCheckSort1();

    }
    @Test(priority = 9,description = "Filter review with checksort")
    public void filter_ratting_09() throws InterruptedException {
        testCustomerService.filterWithCheckSort2();

    }
    @Test(priority = 10,description = "Filter review with checksort")
    public void filter_ratting_10() throws InterruptedException, ParseException {
        testCustomerService.filterWithCheckSort3();

    }
    @Test(priority = 11,description = "Filter review with checksort")
    public void filter_ratting_11() throws InterruptedException {
        testCustomerService.filterWithCheckSort4();

    }
    @Test(priority = 12,description = "Filter review with checksort")
    public void filter_ratting_12() throws InterruptedException {
        testCustomerService.filterWithCheckSort5();

    }
    @Test(priority = 13,description = "Filter review with checksort")
    public void filter_ratting_13() throws InterruptedException {
        testCustomerService.filterWithCheckBox1AndRating1();

    }

    @Test(priority = 13,description = "Filter review with checkbox and ratting")
    public void filter_checkBox_and_ratting() throws InterruptedException {
        testCustomerService.filterCheckBoxAndRatting();

    }
    @Test(priority = 14,description = "Filter review with checksort and ratting")
    public void filter_checkSort_and_ratting () throws InterruptedException {
        testCustomerService.filterWithCheckSortAndRatting();

    }

    @Test(priority = 15,description = "Filter review with checksort and checkbox")
    public void filter_checkSort_and_checkSort () throws InterruptedException {
        testCustomerService.filterCheckBoxAndCheckSort();

    }
    @Test(priority = 16,description = "Test case Newsletter")
    public void testCase_NL_01() throws InterruptedException {
        testCustomerService.myAccountSubscribeGlamiraNewsletter();
    }
    @Test(priority = 17,description = "Test case Newsletter")
    public void testCase_NL_02() throws InterruptedException {
        testCustomerService.myAccountUnSubscribeGlamiraNewsletter();
    }
    @Test(priority = 19,description = "Test case Newsletter")
    public void testCase_NL_03() throws InterruptedException {
        testCustomerService.footerSubscribeGlamiraNewsletter();
    }
    @Test(priority = 20,description = "Test case Newsletter")
    public void testCase_NL_04() throws InterruptedException {
        testCustomerService.footerSubscribeGlamiraNewsletterWithEmailNull();
    }
    @Test(priority = 21,description = "Test case Newsletter")
    public void testCase_NL_05() throws InterruptedException {
        testCustomerService.footerSubscribeGlamiraNewsletterWithNoCaptcha();
    }


}

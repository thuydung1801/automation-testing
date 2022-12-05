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
//    @Test(priority = 2, description = "My product detail/ Filter _ Filter When the ratting has no reviews")
//    public void filter_ratting_02() throws InterruptedException {
//        testCustomerService.filterWithRatting2();
//
//    }
//    @Test(priority = 3,description = "Filter reviews with Show reviews with my current combination")
//    public void filter_ratting_03() throws InterruptedException {
//        testCustomerService.filterWithCheckBox1();
//
//    }
//    @Test(priority = 4,description = "Filter reviews with Only reviews from United Kingdom")
//    public void filter_ratting_04() throws InterruptedException {
//        testCustomerService.filterWithCheckBox2();
//
//    }
//    @Test(priority = 5,description = "Filter reviews with With images")
//    public void filter_ratting_05() throws InterruptedException {
//        testCustomerService.filterWithCheckBox3();
//
//    }
//    @Test(priority = 6,description = "Filter reviews with Verified Buyers")
//    public void filter_ratting_06() throws InterruptedException {
//        testCustomerService.filterWithCheckBox4();
//
//    }
//    @Test(priority = 7,description = "when filter with filter has no results")
//    public void filter_ratting_07() throws InterruptedException {
//        testCustomerService.filterNoResults();
//
//    }
//    @Test(priority = 8,description = "Check Sort By: Relevance")
//    public void filter_ratting_08() throws InterruptedException {
//        testCustomerService.filterWithCheckSort1();
//
//    }
    @Test(priority = 9,description = "Check Sort By: Highest Rating")
    public void filter_ratting_09() throws InterruptedException {
        testCustomerService.filterWithCheckSort2();

    }
//    @Test(priority = 10,description = "Check Sort By: Date")
//    public void filter_ratting_10() throws InterruptedException, ParseException {
//        testCustomerService.filterWithCheckSort3();
//
//    }
    @Test(priority = 11,description = "Check Sort By: Lowest Rating")
    public void filter_ratting_11() throws InterruptedException {
        testCustomerService.filterWithCheckSort4();

    }
    @Test(priority = 12,description = "Check Sort By: Helpfulness")
    public void filter_ratting_12() throws InterruptedException {
        testCustomerService.filterWithCheckSort5();

    }
    @Test(priority = 13,description = "Combined filter Show reviews with my current combination +  ratting option")
    public void filter_ratting_13() throws InterruptedException {
        testCustomerService.filterWithCheckBox1AndRating1();

    }
    @Test(priority = 14,description = "Combined filter Only reviews from United Kingdom +  ratting option")
    public void filter_ratting_14() throws InterruptedException {
        testCustomerService.filterWithCheckBox2AndRating1();

    }
    @Test(priority = 15,description = "Combined filter With images +  ratting option")
    public void filter_ratting_15() throws InterruptedException {
        testCustomerService.filterWithCheckBox3AndRating1();

    }
    @Test(priority = 16,description = "Combined filter Verified Buyers +  ratting option")
    public void filter_ratting_16() throws InterruptedException {
        testCustomerService.filterWithCheckBox4AndRating1();

    }
    @Test(priority = 17,description = "Combine filter with rating without review")
    public void filter_ratting_17() throws InterruptedException {
        testCustomerService.filterWithCheckBoxAndRatingNoReview();

    }


    @Test(priority = 18,description = "Combine filter with sort by: Show reviews with my current combination + Relevance")
    public void filter_ratting_18() throws InterruptedException {
        testCustomerService.filterCheckBox1AndCheckSort1();

    }
    @Test(priority = 19,description = "Combine filter with sort by: Show reviews with my current combination + Highest ratting")
    public void filter_ratting_19() throws InterruptedException {
        testCustomerService.filterCheckBox1AndCheckSort2();

    }
    @Test(priority = 20,description = "Combine filter with sort by: Show reviews with my current combination + Date ")
    public void filter_ratting_20() throws InterruptedException, ParseException {
        testCustomerService.filterCheckBox1AndCheckSort3();

    }
    @Test(priority = 21,description = "Combine filter with sort by: Show reviews with my current combination + Lowest ratting")
    public void filter_ratting_21() throws InterruptedException {
        testCustomerService.filterCheckBox1AndCheckSort4();

    }
    @Test(priority = 22,description = "Combine filter with sort by: Show reviews with my current combination + Helpfulness")
    public void filter_ratting_22() throws InterruptedException {
        testCustomerService.filterCheckBox1AndCheckSort5();
    }


    @Test(priority = 23,description = "Test case Newsletter")
    public void testCase_NL_01() throws InterruptedException {
        testCustomerService.myAccountSubscribeGlamiraNewsletter();
    }
    @Test(priority = 23,description = "Test case Newsletter")
    public void testCase_NL_02() throws InterruptedException {
        testCustomerService.myAccountUnSubscribeGlamiraNewsletter();
    }
    @Test(priority = 25,description = "Test case Newsletter")
    public void testCase_NL_03() throws InterruptedException {
        testCustomerService.footerSubscribeGlamiraNewsletter();
    }
    @Test(priority = 26,description = "Test case Newsletter")
    public void testCase_NL_04() throws InterruptedException {
        testCustomerService.footerSubscribeGlamiraNewsletterWithEmailNull();
    }
    @Test(priority = 27,description = "Test case Newsletter")
    public void testCase_NL_05() throws InterruptedException {
        testCustomerService.footerSubscribeGlamiraNewsletterWithNoCaptcha();
    }


}

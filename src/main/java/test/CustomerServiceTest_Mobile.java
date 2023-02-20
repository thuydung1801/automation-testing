package test;

import core.BaseTest;
import org.testng.annotations.Test;
import page.CustomerServicePage;
import page.CustomerServicePage_Mobile;

public class CustomerServiceTest_Mobile extends BaseTest {
    private CustomerServicePage testCustomerService;
    private CustomerServicePage_Mobile testCustomerServiceMobile;
    public CustomerServiceTest_Mobile() {
        super();
        testCustomerService = new CustomerServicePage(this.keyword);
        testCustomerServiceMobile = new CustomerServicePage_Mobile(this.keyword);
    }
    @Test(priority = 1, description = "My product detail/ Filter _ Filter reviews with ratting option")
    public void filter_ratting_01() throws InterruptedException {
        testCustomerService.filterWithRatting1();

    }
    @Test(priority = 2, description = "My product detail/ Filter _ Filter When the ratting has no reviews")
    public void filter_ratting_02() throws InterruptedException {
        testCustomerServiceMobile.filterWithRatting2();

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
    @Test(priority = 6,description = "Filter reviews with Verified Buyers")
    public void filter_ratting_06() throws InterruptedException {
        testCustomerService.filterWithCheckBox4();

    }

}

package test;

import core.BaseTest;
import org.testng.annotations.Test;
import page.MarketingPage;

public class MarketingTest extends BaseTest {
    private MarketingPage testMarketing;

    public MarketingTest(){
        super();
        testMarketing = new MarketingPage(this.keyword);
    }
//    @Test(priority = 1, description = "Add to cart a new Gift card ")
//    public void testCase_GC_03() throws InterruptedException {
//        testMarketing.giftCardInpWithNull();
//    }
//    @Test(priority = 2)
//    public void testCase_GC_04() throws InterruptedException {
//        testMarketing.giftCardInpWithEmailAndAmountError();
//    }
//    @Test(priority = 3)
//    public void testCase_GC_01() throws InterruptedException {
//        testMarketing.giftCardWithAmount();
//    }
//    @Test(priority = 4)
//    public void testCase_GC_02() throws InterruptedException {
//        testMarketing.giftCardWithOtherAmount();
//    }
//    @Test(priority = 5, description = "Create New Grift Cetificate")
//    public void testCase_GCE_01() throws InterruptedException {
//        testMarketing.createNewGriftCetificateFormMyOrder();
//    }
//    @Test(priority = 6)
//    public void testCase_GCE_06() throws InterruptedException {
//        testMarketing.createNewCetificateWithOptionNO();
//    }
//    @Test(priority = 7)
//    public void testCase_GCE_05() throws InterruptedException {
//        testMarketing.createNewCetificateWithOptionYES();
//    }
//    @Test(priority = 8)
//    public void testCase_GCE_04() throws InterruptedException {
//        testMarketing.createNewGriftCetificateWithDataNull();
//    }
    @Test(priority = 9)
    public void testCase_GCE_02() throws InterruptedException {
        testMarketing.createNewGriftCetificateFormEmailWithLogin();
    }
}

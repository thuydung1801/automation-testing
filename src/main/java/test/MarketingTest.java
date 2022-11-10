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
    @Test(priority = 1)
    public void testCase_GC_03() throws InterruptedException {
        testMarketing.case_GC03();
    }
    @Test(priority = 2)
    public void testCase_GC_04() throws InterruptedException {
        testMarketing.case_GC04();
    }
    @Test(priority = 3)
    public void testCase_GC_01() throws InterruptedException {
        testMarketing.case_GC01();
    }
    @Test(priority = 4)
    public void testCase_GC_02() throws InterruptedException {
        testMarketing.case_GC02();
    }
}

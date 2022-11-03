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
    public void RunMarketing() throws InterruptedException {
        testMarketing.caseGiftCard();
    }
}

package test;

import core.BaseTest;
import org.testng.annotations.Test;
import page.demoAndroidPage;

import java.net.MalformedURLException;

public class demoAndroidTest extends BaseTest {
    private demoAndroidPage demoAndroidPage;
    public demoAndroidTest() throws MalformedURLException {
        super();
        demoAndroidPage = new demoAndroidPage(this.keyword);
    }
    @Test
    public void testCase1() throws InterruptedException {
        demoAndroidPage.test1("animationBy");
    }

}

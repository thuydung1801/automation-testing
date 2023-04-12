package page;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import org.slf4j.Logger;

import java.net.MalformedURLException;

public class demoAndroidPage extends BasePage {
//    public static AndroidDriver<MobileElement> driver;
    public static Logger logger = LogHelper.getLogger();
    public demoAndroidPage() throws MalformedURLException {super();}
    public demoAndroidPage(KeywordWeb key){
        super(key);
    }
    public void test1(String element) throws InterruptedException {
        Thread.sleep(20000);
        keyword.clickById("jobsBy");
        Thread.sleep(5000);
        keyword.clickById("allowWhenUsingBy");
        Thread.sleep(5000);
        keyword.clickById("allowWhenUsingBy");

//        driver.navigate().to("https://www.glamira.sg/glamira-bracelet-tanel.html?alloy=white_red-375&stone1=diamond-Brillant");

        keyword.navigateToUrl("https://www.glamira.sg/glamira-bracelet-tanel.html?alloy=white_red-375&stone1=diamond-Brillant");
        Thread.sleep(15000);
        keyword.click(element);
    }
}

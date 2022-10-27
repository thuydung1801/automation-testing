package test;

import core.BaseTest;
import core.PropertiesFile;
import org.testng.annotations.Test;
import page.HomePage;
import static org.testng.AssertJUnit.assertEquals;

public class Home001 extends BaseTest {
    private HomePage objHome;
    public Home001() {
        super();
    }
    //@Test
    public void testCase1() throws Exception {
        System.out.println("testCase1");

        objHome = new HomePage(this.keyword);
        //objHome.gotoElementMenu();
        keyword.navigateToUrl(PropertiesFile.getPropValue("URL_BROWSER_WINDOW"));
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("BTN_NEW_TAB"), 60);
//        keyword.executeJavaScript("document.getElementById('tabButton').click()");
//        //keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("TXT_NEWTAB"), 60);
//        keyword.switchToTab(0);
//        Thread.sleep(2000);
//        //keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("BTN_NEW_TAB"), 60);
//        keyword.switchToTab(1);
//        Thread.sleep(2000);
//        //keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("TXT_NEWTAB"), 60);
//        keyword.closeTab(1);
        keyword.click(PropertiesFile.getPropValue("BTN_NEWWINDOW"));
        //keyword.listWindowID();
        keyword.switchToWindowByIndex(1);
        //keyword.switchToWindow("CDwindow-9F9284D34368B738F0AD14BF1770BDD8");
        Thread.sleep(2000);
        keyword.closeWindowByIndex(1);

    }
    @Test
    public void test3() throws Exception {
        keyword.navigateToUrl(PropertiesFile.getPropValue("URL_ALERT"));
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("BTN_CLICK_ME"), 10);
        keyword.click(PropertiesFile.getPropValue("BTN_CLICK_ME"));
        Thread.sleep(3000);
        assertEquals(PropertiesFile.getPropValue("TXT_ALERT1"),keyword.getAlertText());
        keyword.takeScreenshot("png","report/alert1.jpg");
        keyword.acceptAlert();
        Thread.sleep(3000);



    }
}

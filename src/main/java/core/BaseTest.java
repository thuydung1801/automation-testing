package core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.testng.annotations.*;
//import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

import static core.KeywordWeb.driver;

public class BaseTest {
    private static Logger logger = LogHelper.getLogger();
    protected KeywordWeb keyword;

    //    public static AndroidDriver<MobileElement> driver;
    public static WebDriverWait                wait;
    public BaseTest() throws MalformedURLException {
        keyword = new KeywordWeb();
    }
    public static AndroidDriver<MobileElement> getDriver() {
        return driver;
    }
    @BeforeSuite
    public void beforeSuite() throws Exception {
        PropertiesFile.setPropertiesFile();
    }
    @BeforeTest

    public void beforeTest() throws Exception {
        //String platformName, String platformVersion,String deviceName,String appPackage,String appActivity
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformname", PropertiesFile.getPropValue("platformName"));
        capabilities.setCapability("platformVersion", PropertiesFile.getPropValue("platformVersion"));
        capabilities.setCapability("deviceName", PropertiesFile.getPropValue("deviceName"));
        capabilities.setCapability("appPackage", PropertiesFile.getPropValue("appPackage"));
        capabilities.setCapability("appActivity", PropertiesFile.getPropValue("appActivity"));
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        wait = new WebDriverWait(driver, 10);
    }
//    @AfterMethod
//    public void teardown() {
//        driver.quit();
//    }
}

package tests;
import java.io.IOException;
import java.lang.reflect.Method;

import core.KeywordWeb;
import core.PropertiesFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import steps.Steps;
import utils.ChromeOptionsUtil;

import static core.KeywordWeb.driver;

public class BaseTest {
    protected KeywordWeb keyword;
    public BaseTest() {
        keyword = new KeywordWeb();
    }
    ChromeOptionsUtil chromeOptionsUtil = new ChromeOptionsUtil();
    public static WebDriver getDriver() {
        return driver;
    }
    Steps steps;
    @BeforeSuite
    public void beforeSuite(){
        PropertiesFile.setPropertiesFile();
    }
    @BeforeTest
    public void beforeTest() throws Exception {
        keyword.openBrowser(PropertiesFile.getPropValue("BROWSER_NAME"), PropertiesFile.getPropValue("BASE_URL"));
        keyword.maximizeWindow();
    }
    @BeforeClass
    public void setupTestClass() throws IOException {
        driver = new ChromeDriver(chromeOptionsUtil.getChromeOptions());
        driver.manage().window().maximize();
        steps = new Steps(driver);
        steps.preTestSetup();
    }
    @BeforeMethod
    public void setupTestMethod(Method method) {
        steps.folderUtil.setUpFilesAndFolders(method.getName());
    }
//    @AfterTest
//    public void quitDriver() {
//        driver.quit();
//    }
}

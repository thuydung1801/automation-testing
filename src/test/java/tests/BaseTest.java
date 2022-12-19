package tests;
import java.lang.reflect.Method;

import core.KeywordWeb;
import core.PropertiesFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import steps.Steps;
import utils.ChromeOptionsUtil;
public class BaseTest {
    protected KeywordWeb keyword;
    public BaseTest() {
        keyword = new KeywordWeb();
    }
    ChromeOptionsUtil chromeOptionsUtil = new ChromeOptionsUtil();
    public WebDriver driver;
    Steps steps;
    @BeforeSuite
    public void beforeSuite(){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        WebDriver wd =new ChromeDriver();
        String baseUrl = "https://www.google.com";
        wd.get(baseUrl);
    }
    @BeforeClass
    public void setupTestClass() {
        driver = new ChromeDriver(chromeOptionsUtil.getChromeOptions());
        driver.manage().window().maximize();
        steps = new Steps(driver);
        steps.preTestSetup();
    }
    @BeforeMethod
    public void setupTestMethod(Method method) {
        steps.folderUtil.setUpFilesAndFolders(method.getName());
    }
    @AfterClass
    public void quitDriver() {
        driver.quit();
    }
}

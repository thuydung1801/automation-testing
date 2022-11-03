package core;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.slf4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;

import static core.KeywordWeb.driver;



public class BaseTest {
    private static Logger logger = LogHelper.getLogger();
    protected KeywordWeb keyword;
//    public static WebDriver driver;
    public BaseTest(){
        keyword = new KeywordWeb();
    }
    public static WebDriver getDriver() {
        return driver;
    }
    @BeforeSuite
    public void beforeSuite() throws Exception {
        PropertiesFile.setPropertiesFile();
    }

    @BeforeTest
    public void beforeTest() throws Exception {
        keyword.openBrowser(PropertiesFile.getPropValue("BROWSER_NAME"),PropertiesFile.getPropValue("BASE_URL"));
        keyword.maximizeWindow();
    }
    //@AfterMethod
    public void takeScreenshot(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                TakesScreenshot ts = (TakesScreenshot) driver;
                File source = ts.getScreenshotAs(OutputType.FILE);
                File theDir = new File("./screenshots/");
                if (!theDir.exists()) {
                    theDir.mkdirs();
                }
                // result.getName() lấy tên của test case xong gán cho tên File chụp màn hình
                FileHandler.copy(source, new File("./screenshots/" + result.getName() + ".png"));
                System.out.println("Taked screenshot: " + result.getName());
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }

    @AfterTest
    public void afterTest() throws Exception {
        keyword.closeBrowser();
    }

}

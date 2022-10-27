package core;

import org.slf4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTest {
    private static Logger logger = LogHelper.getLogger();
    protected KeywordWeb keyword;
    public BaseTest(){
        keyword = new KeywordWeb();
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
    @AfterTest
    public void afterTest() throws Exception {
        keyword.closeBrowser();
    }

}

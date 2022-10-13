package Common_Page;

import Page_Lib.App_Lib;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AbstractBase_Test {
    ChromeDriver driver;
    private App_Lib app;

    @BeforeTest
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        app = new App_Lib(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

    public App_Lib App() {
        return app;
    }

}

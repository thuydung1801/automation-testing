package Common_Page;

import Page_Lib.App_Lib;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class AbstractBase_Test {
   // ChromeDriver driver;
    private App_Lib App;

    String username = "webmasterglamira-group";
    String accesskey = "Zc41qUZTrlgQTWKjCGAuPpsFrZiCNW8yyOmbo9pY9e8V5TIyXP";
    static RemoteWebDriver driver = null;
    String gridURL = "@hub.lambdatest.com/wd/hub";
    private void setup() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("version", "70.0");
        capabilities.setCapability("platform", "win11"); // If this cap isn't specified, it will just get any available one.
        capabilities.setCapability("build", "LambdaTest_Dung");
        capabilities.setCapability("name", "LambdaTestJava_Dung");
        try {
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @BeforeTest
    public void setUp() throws Exception {
        setup();
        WebDriverManager.chromedriver().setup();
          //  driver = new ChromeDriver();
        App = new App_Lib(driver);


    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

    public App_Lib App() {
        return App;
    }

}

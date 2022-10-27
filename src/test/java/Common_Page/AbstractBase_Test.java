package Common_Page;

import Page_Lib.App_Lib;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class AbstractBase_Test {
    // ChromeDriver driver;
    private App_Lib App;
    boolean status = false;
    String username = "nguyenthingoc1052000";
    String accesskey = "mL1BJLIDr2WgDbjtQVaw1hJISaAssHzGB1FVNNxH6t9SLzbt7r";
    static RemoteWebDriver driver = null;
    ChromeDriver dr;
//    WebDriver dr;

    String gridURL = "@hub.lambdatest.com/wd/hub";

    private void setup() throws MalformedURLException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("browserName", "chrome");
//        capabilities.setCapability("version", "105.0");
//        capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get any available one.
//        capabilities.setCapability("build", "GLAMIRA_Automation");
//        capabilities.setCapability("name", "GLAMIRA_Automation");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("version", "70.0");
        capabilities.setCapability("platform", "win10");
        capabilities.setCapability("build", "GLAMIRA_Automation");
        capabilities.setCapability("name", "GLAMIRA_Automation");
        capabilities.setCapability("network", true);
        capabilities.setCapability("visual", true);
        capabilities.setCapability("video", true);
        capabilities.setCapability("console", true);
//        URL url = new URL("https://dev1.glamira.com");
//        driver = new AppiumDriver(url,cap);
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
//        setup();
//        ChromeOptions options = new ChromeOptions();
//        HashMap<String, Integer> cookie = new HashMap<>();
//        cookie.put("profile.default_content_settings.cookies", 2);
//        options.setExperimentalOption("prefs", cookie);
//        WebDriverManager.chromedriver().setup();


        ChromeOptions options = new ChromeOptions();
        HashMap<String,Integer> conen = new HashMap<String,Integer>();
        HashMap<String,Object> pro = new HashMap<String,Object>();
        HashMap<String,Object> pre = new HashMap<String,Object>();

        conen.put("notifications" , 1);
        pro.put("manege_default_content_settings" , conen);
        pre.put("profile" ,pro);
        options.setExperimentalOption("prefs" , pre);




        WebDriverManager.chromedriver().setup();
//        String[] arguments = {"-----start-maximized"};
//        options.addArguments(arguments);
//        driver = new ChromeDriver(options);



        dr = new ChromeDriver(options);

        App = new App_Lib(dr);


    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
            driver.quit();
        }
//        dr.quit();
    }

    public App_Lib App() {
        return App;
    }

}

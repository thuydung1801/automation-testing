package Page_Lib;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Flow_Lib {
    private RemoteWebDriver driver;

    public Flow_Lib(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public void navigateToUrl(String url) {
        this.driver.get(url);
    }

    public String getCurrentPageUrl() {
        return this.driver.getCurrentUrl();
    }

    public String getCurrentPageTitle() {
        return this.driver.getTitle();

    }
}

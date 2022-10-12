package Page_Lib;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class Flow_Lib {
    private WebDriver driver;

    public Flow_Lib(WebDriver driver) {
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

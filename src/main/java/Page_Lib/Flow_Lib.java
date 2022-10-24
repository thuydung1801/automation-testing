package Page_Lib;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flow_Lib {
  public static   RemoteWebDriver driver ;
    //    WebDriver driver;
    private WebDriverWait wait;

    public Flow_Lib(RemoteWebDriver driver) {
        this.driver = driver;
    }

    //    String url = "https://dev1.glamira.com/glde";
    public void navigateToUrl(String url) {
        driver.navigate().to(url);
    }
    public void openNewTab(String url){

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(url);
    }

    public String getCurrentPageUrl() {
        return this.driver.getCurrentUrl();
    }
    public void printfCurrentPageUrl() {
        System.out.printf("url"+this.driver.getCurrentUrl());
    }

    public String getCurrentPageTitle() {
        return this.driver.getTitle();

    }
}

package Page_Lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App_Lib {
    private ChromeDriver driver;
    private Page_Lib page;
    private Flow_Lib flow;

    public App_Lib(ChromeDriver driver) {
        this.driver = driver;
        page = new Page_Lib(this.driver);
        flow = new Flow_Lib(this.driver);
    }

    public Page_Lib Pages() {
        return page;
    }

    public Flow_Lib Flow() {
        return flow;
    }
}

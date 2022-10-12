package Page_Lib;

import org.openqa.selenium.WebDriver;

public class App_Lib {
    private WebDriver driver;
    private Page_Lib page;
    private Flow_Lib flow;

    public App_Lib(WebDriver driver) {
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

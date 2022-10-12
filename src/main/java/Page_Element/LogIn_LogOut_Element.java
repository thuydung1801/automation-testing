package Page_Element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LogIn_LogOut_Element {
    WebDriver driver;
    public LogIn_LogOut_Element(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}

package Page_Element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header_Element {
//    WebDriver driver;
    ChromeDriver driver;
    @FindBy(xpath = "//span[contains(text(),'Log In/Sign Up')]") public WebElement headerLogin;

//    @FindBy(xpath = "//span[contains(text(),'Log In/Sign Up')]") public WebElement headerLogin;
//    @FindBy(xpath = "//span[contains(text(),'Log In/Sign Up')]") public WebElement headerLogin;

    public Header_Element(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}

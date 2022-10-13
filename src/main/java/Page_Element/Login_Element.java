
package Page_Element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Element {
    //    WebDriver driver;
    ChromeDriver driver;
    //    BNINE
    @FindBy(xpath = "//span[@class='authorization-text']") public WebElement LoginPage;
    @FindBy(xpath = "//input[@id='email']") public WebElement EnterEmail;
    @FindBy(xpath = "(//input[@id='pass'])[1]") public WebElement EnterPass;
    @FindBy(xpath = "(//button[@id='send2'])[1]") public WebElement Submit;
    public Login_Element(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}

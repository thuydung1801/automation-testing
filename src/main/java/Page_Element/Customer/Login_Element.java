
package Page_Element.Customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Element {
    //    WebDriver driver;
    RemoteWebDriver driver;
    //    BNINE
    @FindBy(xpath = "//a[@title='Einloggen/Anmelden']") public WebElement LoginPage;

    @FindBy(xpath = "//input[@id='login-email']") public WebElement EnterEmail;
    @FindBy(xpath = "//input[@id='login-password']") public WebElement EnterPass;
    @FindBy(xpath = "(//form[@class='form login-form'])[1]") public WebElement Submit;
//    LogOut

    @FindBy(className = "authorization-text") public  WebElement Click_BtnLogout;
    public Login_Element(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}

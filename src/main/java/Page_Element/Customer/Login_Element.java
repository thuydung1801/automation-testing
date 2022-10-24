
package Page_Element.Customer;

import org.apache.xmlgraphics.image.loader.cache.ExpirationPolicy;
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
    @FindBy(css = "li.authorization-link.login") public WebElement LoginPage;
    @FindBy(xpath = "//input[@id='login-email']") public WebElement EnterEmail;
    @FindBy(xpath = "//input[@id='login-password']") public WebElement EnterPass;
    @FindBy(className = "amgdprcookie-policy") public WebElement Submit;
    @FindBy(css = "button.amgdprcookie-button.-allow") public WebElement Submit1;
    @FindBy(xpath = "//form[@class='form login-form']//button[@type='submit']") public WebElement SubMitLogin;
    @FindBy(css = "li.authorization-link.login") public WebElement slectAAA;
    @FindBy(xpath = "//a[@title='My Account']") public WebElement MyAccLogOut;
    @FindBy (css = "div.tab-content.content-popup.geoip-popup-content") public WebElement isDisplayBookSwithch;
    @FindBy (css = "a.btn-stay-here.geoip-close") public WebElement ClickStayOnHere;
//    Logout
    @FindBy(css = "li.account-link") public WebElement ClickLogOut;
    @FindBy(xpath = "//div[@class='logout-action']") public WebElement isDisplayBookLogOut;
    @FindBy(xpath = "//a[normalize-space()='Logout']") public WebElement LogOuts;

    public Login_Element(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}


package Page.Customer;

import Page_Element.Customer.Login_Element;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Login_Page {
    RemoteWebDriver driver;
    Login_Element Login;
    public Login_Page(RemoteWebDriver driver) {
        this.driver = driver;
        Login = new Login_Element(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    public void click() {
        Login.LoginPage.click();
    }
    public void EnterMail() {
        Login.EnterEmail.sendKeys("sophie@onlinebizsoft.com");
    }
    public void EnterPw() {
        Login.EnterPass.sendKeys("12345678");
    }
    public void SubmitBtnCookies() {
        Login.Submit.click();
    }
//    public  void SubmitBtn(){
//        Login.Submit1.click();
//    }
    public void LogOutBtn() {
        Login.Click_BtnLogout.isDisplayed();
    }

}


package Page.Customer;

import Page_Element.Customer.Login_Element;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
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

    public void SubmitBtnCookies1() {
        Login.Submit1.click();
    }

    public void SubmitBtnAction() throws InterruptedException {
        Login.SubMitLogin.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        Boolean StatusDisPlayBook = Login.isDisplayBookSwithch.isDisplayed();
        System.out.print("CHECK:~~~~~~~~~~ Display a Book Switch.");
        if (!StatusDisPlayBook) {
            System.out.print("Don't Have a Book Switch to......" + "\n");
            Thread.sleep(10000);
        } else {
            Thread.sleep(10000);
            System.out.println("\n" + "STATUS:~~~~~~~~~ Is Display");
            Login.ClickStayOnHere.click();
            Thread.sleep(1000);
            System.out.println("\n" + "MESSAGE:~~~~~~~~~ Click Successfully!");
        }
    }

    public void ClickLogOuts() throws InterruptedException {
        Thread.sleep(2000);
        Login.ClickLogOut.click();
        Thread.sleep(1000);
        System.out.println("CHECK:~~~~~~~~~~Is Display LogOut");
        boolean StatusBookLogOut = Login.isDisplayBookLogOut.isDisplayed();
        if (!StatusBookLogOut) {
            System.out.println("~~~~~~~~~OUT~~~~~~~~~~~");
        } else {
            System.out.println("\n" + "STATUS:~~~~~~~~~~Is Display");
            Thread.sleep(3000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", Login.LogOuts);
            System.out.println("\n" + "Scroll to Element");
            Thread.sleep(2000);
            Login.LogOuts.click();
        }
    }

//


}

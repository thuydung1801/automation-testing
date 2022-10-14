
package Page;

        import Page_Element.Header_Element;
        import Page_Element.Login_Element;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.remote.RemoteWebDriver;

public class Login_Page {
    RemoteWebDriver driver ;
    Login_Element Login;


    public Login_Page(RemoteWebDriver driver) {
        this.driver = driver;
        Login = new Login_Element(driver);

    }

    public void click() {
        Login.LoginPage.click();
    }
    public void EnterMail() {
        Login.EnterEmail.sendKeys("nguyenthilien1962@gmail.com");
    }
    public void EnterPw() {
        Login.EnterPass.sendKeys("Lien1962@");
    }
    public void SubmitBtn() {Login.Submit.click();}

}

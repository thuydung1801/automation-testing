package Tests.Customer;

import Common_Page.AbstractBase_Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LogIn extends AbstractBase_Test {
    // ChromeDriver driver;
    @Test
    public void Run() throws InterruptedException {
        App().Flow().navigateToUrl("https://dev3.glamira.com/");
//        App().Pages().LogInOutage().SubmitBtnCookies();
        App().Pages().LogInOutage().SubmitBtnCookies1();
        Thread.sleep(4000);
        App().Pages().LogInOutage().click();
        App().Pages().LogInOutage().EnterMail();
        App().Pages().LogInOutage().EnterPw();
//        App().Pages().LogInOutage().SubmitBtnCookies();
//        App().Pages().LogInOutage().SubmitBtnCookies1();
        App().Pages().LogInOutage().SubmitBtnAction();
//        App().Pages().LogInOutage().LogOutBtn();
    }
   @Test
    public void LogOut() {
        App().Pages().LogInOutage().LogOut();
   }


}


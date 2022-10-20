package Tests.Customer;

import Common_Page.AbstractBase_Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LogIn extends AbstractBase_Test {
    // ChromeDriver driver;
    @Test
    public void Run() throws InterruptedException {
        System.out.println("Steep1:----- get URL Page");
        App().Flow().navigateToUrl("https://dev3.glamira.com/");
//        App().Pages().LogInOutage().SubmitBtnCookies();
        System.out.println("Steep2:----- Accep Cookies");
        App().Pages().LogInOutage().SubmitBtnCookies1();
        Thread.sleep(4000);
        System.out.println("Steep3:----- ClickIconAccound");
        App().Pages().LogInOutage().click();
        System.out.println("Steep4:----- enterEmail");
        App().Pages().LogInOutage().EnterMail();
        System.out.println("Steep5:----- enterPassW");
        App().Pages().LogInOutage().EnterPw();
//        App().Pages().LogInOutage().SubmitBtnCookies();
//        App().Pages().LogInOutage().SubmitBtnCookies1();
        System.out.println("Steep5:----- SubMit..");
        App().Pages().LogInOutage().SubmitBtnAction();
//        App().Pages().LogInOutage().LogOutBtn();
    }

    @Test
    public void LogOut() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("SteepII:----- ClickIconAccound");
        App().Pages().LogInOutage().LogOut();
        System.out.println("SteepII:----- ClickIconAccound");
        App().Pages().LogInOutage().ClickLogOuts();
    }
}


package Tests.Customer;

import Common_Page.AbstractBase_Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class LogIn extends AbstractBase_Test {
    // ChromeDriver driver;
    @Test
    public void Run() throws InterruptedException {

        System.out.println("Steep1:----- get URL Page");
        App().Flow().navigateToUrl("https://dev3.glamira.com/");
//        App().Pages().LogInOutage().SubmitBtnCookies();
        Thread.sleep(1000);
        System.out.println("Steep2:----- Accep Cookies");
        App().Pages().LogInOutage().SubmitBtnCookies1();
        Thread.sleep(4000);
        System.out.println("Steep3:----- ClickIconAccound");
        App().Pages().LogInOutage().click();
        System.out.println("Steep4:----- enterEmail");
        Thread.sleep(1000);
        App().Pages().LogInOutage().EnterMail();
        Thread.sleep(1000);
        System.out.println("Steep5:----- enterPassW");
        App().Pages().LogInOutage().EnterPw();
        Thread.sleep(1000);
//        App().Pages().LogInOutage().SubmitBtnCookies();
//        App().Pages().LogInOutage().SubmitBtnCookies1();
        System.out.println("Steep5:----- SubMit..");
        App().Pages().LogInOutage().SubmitBtnAction();

        Thread.sleep(7000);
        System.out.println("STP:~~~~~~~~~~~LOGOUT~~~~~~~~~~~~~~~~~~~~");
        Thread.sleep(1000);
        App().Flow().getCurrentPageUrl();
        System.out.println(App().Flow().getCurrentPageUrl());
        App().Pages().LogInOutage().ClickLogOuts();
        System.out.println("STATUS:----- LogOut Succesfuly !");
    }


}


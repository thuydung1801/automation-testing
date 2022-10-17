package Tests.Customer;

import Common_Page.AbstractBase_Test;
import org.testng.annotations.Test;
public class LogIn extends AbstractBase_Test {
    // ChromeDriver driver;
    @Test
    public void Run() {
        App().Flow().navigateToUrl("https://dev1.glamira.com/glgb");
        App().Pages().LogInOutage().click();
        App().Pages().LogInOutage().EnterMail();
        App().Pages().LogInOutage().EnterPw();
        App().Pages().LogInOutage().SubmitBtn();
    }
    @Test
    public void LogOut(){
        App().Flow().getCurrentPageUrl();
//        App().Pages().LogInOutage().LogOutBtn();

    }
}


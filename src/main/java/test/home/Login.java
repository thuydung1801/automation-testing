package test.home;

import core.BaseTest;
import org.testng.annotations.Test;
import page.home.LoginPage;
import page.home.RegisterPage;

public class Login extends BaseTest {
    private LoginPage objLogin;

    private RegisterPage objRegist;

    public Login(){ super();}

    @Test
    public void login() throws InterruptedException {
        objLogin = new LoginPage(this.keyword);
        objRegist = new RegisterPage(this.keyword);
        //objLogin.loginOnAlert();
        objRegist.acceptAllCookies();
        //objRegist.chooseLanguages();
//        objLogin.loginOnWebsite("LOGIN_DATA_EMAIL","LOGIN_DATA_PASSWORD",
//                "LOGIN_DATA_PHONE_LINH","LOGIN_DATA_PHONE_PASS", true);
        objLogin.loginOnMobile("LOGIN_DATA_EMAIL","LOGIN_DATA_PASSWORD");
    }
}

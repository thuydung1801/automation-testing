package page.checkout;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import org.slf4j.Logger;
import page.MyAccountPage;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;

public class LoginAddressPageMobile extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private LoginPage objLogin;
    private RegisterPage objRegister ;
    private LoginPage loginPage;
    public SignInPage signInPage;
    private MyAccountPage myAccountPage;

    public SignInPage objSignIn;
    private LoginAddressPage loginAddressPage;
    public LoginAddressPageMobile(){ super(); }
    public LoginAddressPageMobile(KeywordWeb key){
        super(key);
        objLogin = new LoginPage();
        objRegister = new RegisterPage();
        loginPage = new LoginPage();
        signInPage = new SignInPage();
        myAccountPage = new MyAccountPage();
        loginAddressPage=new LoginAddressPage();
    }
}

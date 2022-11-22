package test.signinSignup;


import core.BaseTest;
import io.cucumber.java.sl.In;
import org.testng.annotations.Test;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;
import page.signinSignup.SignUpPage;

public class SignUpTest extends BaseTest {
    private LoginPage objLogin;
    private RegisterPage objRegist;
    private SignUpPage objSigUp;

    public SignUpTest() {
        super();
    }

    @Test(priority = 1, description = "Login form with for got password")
    public void testCase_SU01() throws InterruptedException {
        objLogin = new LoginPage(this.keyword);
        objRegist = new RegisterPage(this.keyword);
        objSigUp = new SignUpPage(this.keyword);
        objLogin.loginOnAlert();
        objRegist.acceptAllCookies();
        objRegist.chooseLanguages();
        Thread.sleep(2000);
        objSigUp.goToFormCreateMyAccount();
    }

    @Test(priority = 2, description = "Create New Account- not enter valid values")
    public void testCase_SU02() throws InterruptedException {
        objSigUp.enterNotValueInformation();
    }

    @Test(priority = 3, description = "Create New Account- Sign up with a duplicate email address")
    public void testCase_SU03() throws InterruptedException {
        objSigUp.sendKeyFullDataFormInformation(
                "SIGNUP_DATA_FIRST_NAME_INFORMATION",
                "SIGNUP_DATA_LAST_NAME_INFORMATION",
                "SIGNUP_DATA_EMAIL_INFORMATION",
                "SIGNUP_DATA_EMAIL_CONFIRM_INFORMATION"
        );
        objSigUp.sendKeyFullDataFormPasswordInformation(
                "SIGNUP_CREATE_PASSWORD",
                "SIGNUP_SELECT_OPTION_TITLE"
        );

    }
    @Test(priority = 4, description = "Create New Account- Enter wrong format  email address")
    public void testCase_SU04()throws InterruptedException {

    }
    @Test(priority = 4, description = "Create New Account- Enter wrong format  email address")
    public void testCase_SU05()throws InterruptedException {

    }
    @Test(priority = 4, description = "Create New Account- Enter wrong format  email address")
    public void testCase_SU06()throws InterruptedException {

    }
}

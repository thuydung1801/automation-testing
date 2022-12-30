package steps;

import tests.BaseTest;
import core.KeywordWeb;
import core.PropertiesFile;
import page.home.LoginPage;
import core.BasePage;
import java.util.Properties;
import org.testng.annotations.Test;

public class Steps2 extends BasePage {

    public Steps2(){ super(); }
    public Steps2(KeywordWeb key){
        super(key);
    }
    public LoginPage objLogin;

    public void gotoLogin() throws InterruptedException {
        objLogin = new LoginPage(this.keyword);
        String a = PropertiesFile.getPropValue("CHECKOUT_LA_LBL_CODE");
        System.out.println(a);
        objLogin.loginOnWebsite("LOGIN_DATA_EMAIL","LOGIN_DATA_PASSWORD",
                "LOGIN_DATA_PHONE_LINH","LOGIN_DATA_PHONE_PASS", true);
    }

    public void scroll(){
        keyword.scrollToPositionByScript("window.scrollBy(0,920)");
    }
}

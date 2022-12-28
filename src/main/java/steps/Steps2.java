package steps;

import core.BasePage;
import core.KeywordWeb;
import core.PropertiesFile;
import page.home.LoginPage;

public class Steps2 extends BasePage {

    public Steps2(){ super(); }
    public Steps2(KeywordWeb key){
        super(key);
    }


    public LoginPage objLogin;

    public void a() throws InterruptedException {
        objLogin = new LoginPage(this.keyword);
        String a = PropertiesFile.getPropValue("CHECKOUT_LA_LBL_CODE");
        System.out.println(a);
        objLogin.loginOnWebsite("LOGIN_DATA_EMAIL","LOGIN_DATA_PASSWORD",
                "LOGIN_DATA_PHONE_LINH","LOGIN_DATA_PHONE_PASS", true);
    }
}

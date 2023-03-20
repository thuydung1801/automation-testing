package page.checkout;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import org.slf4j.Logger;
import org.testng.Assert;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class CatelogPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private LoginPage objLogin;
    private RegisterPage objRegister ;
    private LoginPage loginPage;
    public SignInPage signInPage;
    public CatelogPage(){ super(); }
    public CatelogPage(KeywordWeb key){
        super(key);
        objLogin = new LoginPage();
        objRegister = new RegisterPage();
        loginPage = new LoginPage();
        signInPage = new SignInPage();
    }
    public void setUp() throws InterruptedException {
//        objLogin.loginOnAlert();
        objRegister.acceptAllCookies();
//        objRegister.chooseLanguages();
    }

//    private CatelogPage catelogPage;
    public void checkSpecialDeals(String url) throws InterruptedException {
        setUp();
        keyword.navigateToUrl(url + "special-deals/");
        keyword.untilJqueryIsDone(50L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        if(keyword.verifyElementVisible("CATELOG_FILTER")){
            int count = 1;
            String[] name = {"All", "Rings", "Necklaces", "Earrings","Bracelets","Brooches","Anklets","Nose Pins","Best Sellers"};
            while (count<10){
                String ele = PropertiesFile.getPropValue("CATELOG_NAME_FILTER") + count+"]/span";
                String getText = keyword.getText(ele);
                logger.info("getText===" + getText);
                logger.info("getName===" + name[count-1]);
                keyword.untilJqueryIsDone(50L);
                keyword.assertEquals(name[count-1],getText);
                count++;
            }
        }
    }
}

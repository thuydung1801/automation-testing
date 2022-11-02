package page;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import org.slf4j.Logger;
import page.home.LoginPage;
import page.home.RegisterPage;

public class MarketingPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private LoginPage objLogin;
    private RegisterPage objRegister ;
    public MarketingPage() {
        super();
    }
    public MarketingPage(KeywordWeb key){
        super(key);
        objLogin = new LoginPage();
        objRegister = new RegisterPage();
    }
    public void setUp() throws InterruptedException {
        objLogin.loginOnAlert();
        objRegister.acceptAllCookies();
        objRegister.chooseLanguages();
    }
    public void caseGiftCard() throws InterruptedException {
        setUp();
        keyword.navigateToUrl(PropertiesFile.getPropValue("MRT_URL"));
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("MRT_INP_NAME"), 5000);
//        Thread.sleep(20000);
        keyword.sendKeys(PropertiesFile.getPropValue("MRT_INP_NAME"),PropertiesFile.getPropValue("MRT_INP_DATA_NAME"));
        Thread.sleep(1000);
        keyword.sendKeys(PropertiesFile.getPropValue("MRT_INP_EMAIL"),PropertiesFile.getPropValue("MRT_INP_DATA_EMAIL"));

    }

}

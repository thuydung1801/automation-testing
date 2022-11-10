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
    public void ipData(String name, String email,String mess, String submit) throws InterruptedException {
        keyword.imWait(5);
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("MRT_INP_NAME"),8);
        keyword.sendKeys(PropertiesFile.getPropValue("MRT_INP_NAME"), PropertiesFile.getPropValue(name));
        keyword.sendKeys(PropertiesFile.getPropValue("MRT_INP_EMAIL"),PropertiesFile.getPropValue(email));
        keyword.sendKeys(PropertiesFile.getPropValue("MRT_INP_MESSAGE"),PropertiesFile.getPropValue(mess));
        Thread.sleep(20000);
        keyword.click(PropertiesFile.getPropValue(submit));
        if(keyword.verifyElementVisible(PropertiesFile.getPropValue("TEXT_ERROR")) ||
                keyword.verifyElementVisible(PropertiesFile.getPropValue("MRT_TEXT_ERROR"))){

            System.out.printf("Error...." + "\n");
        }else{
            System.out.printf("Continue..." + "\n");
        }
        keyword.openNewTab(PropertiesFile.getPropValue("MRT_URL"));
        Thread.sleep(2000);

    }

    public void case_GC03() throws InterruptedException {
        setUp();
        Thread.sleep(5000);
        keyword.navigateToUrl(PropertiesFile.getPropValue("MRT_URL"));
        ipData("DATA_NULL","DATA_NULL","DATA_NULL","MRT_SUBMIT");

    }
    public void case_GC04() throws InterruptedException {
//        setUp();
        keyword.sendKeys(PropertiesFile.getPropValue("MRT_INP_AMOUNT"), PropertiesFile.getPropValue("MRT_INP_DATA_AMOUNT_ERROR"));
        ipData("MRT_INP_DATA_NAME","DATA_ERROR","MRT_INP_DATA_MESSAGE","MRT_SUBMIT");


    }
    public void case_GC01() throws InterruptedException {
//        setUp();
        keyword.click( PropertiesFile.getPropValue("MRT_AMOUNT"));
        ipData("MRT_INP_DATA_NAME","MRT_INP_DATA_EMAIL","MRT_INP_DATA_MESSAGE","MRT_SUBMIT");

    }
    public void case_GC02() throws InterruptedException {
//        setUp();
        keyword.sendKeys(PropertiesFile.getPropValue("MRT_INP_AMOUNT"), PropertiesFile.getPropValue("MRT_INP_DATA_AMOUNT"));
        ipData("MRT_INP_DATA_NAME","MRT_INP_DATA_EMAIL","MRT_INP_DATA_MESSAGE","MRT_SUBMIT");

    }

}

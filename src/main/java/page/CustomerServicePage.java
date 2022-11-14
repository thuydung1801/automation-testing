package page;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import org.slf4j.Logger;
import page.home.LoginPage;
import page.home.RegisterPage;

public class CustomerServicePage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private LoginPage objLogin;
    private RegisterPage objRegister ;
    public CustomerServicePage() {
        super();
    }
    public CustomerServicePage(KeywordWeb key){
        super(key);
        objLogin = new LoginPage();
        objRegister = new RegisterPage();
    }
    public void setUp() throws InterruptedException {
        objLogin.loginOnAlert();
        objRegister.acceptAllCookies();
        objRegister.chooseLanguages();
        Thread.sleep(5000);
        keyword.openNewTab(PropertiesFile.getPropValue("URL_PRODUCT_DETAIL"));
        Thread.sleep(2000);
    }

    public void commonLoad() throws InterruptedException {
        keyword.imWait(5);
        keyword.openNewTab(PropertiesFile.getPropValue("URL_PRODUCT_DETAIL"));

    }
    public void clickDropdown(){
        keyword.click(PropertiesFile.getPropValue("CUS_PRD_FILTER_SELECT"));
        keyword.imWait(2);
        keyword.randomElement(PropertiesFile.getPropValue("CUS_PRD_FILTER_CHECKSORT"));
    }

    public void Filter_01_02() throws InterruptedException {
        setUp();
        keyword.scrollDownToElement(PropertiesFile.getPropValue("CUS_PRD_FILTER_RATTING_1"));
        keyword.imWait(2);
        keyword.click(PropertiesFile.getPropValue("CUS_PRD_FILTER_RATTING_1"));

        Thread.sleep(10000);
        System.out.printf("When the ratting has no reviews" + "\n");
        keyword.click(PropertiesFile.getPropValue("CUS_PRD_FILTER_RATTING_2"));
        commonLoad();


    }
    public void Filter_checkBox() throws InterruptedException {
        keyword.randomConcatElement(PropertiesFile.getPropValue("CUS_PRD_FILTER_CHECKBOX_ELE"),5);
    }
    public void Filter_checkSort() throws InterruptedException {
        commonLoad();
        keyword.imWait(2);
        clickDropdown();
        commonLoad();

    }
    public void Filter_checkBox_and_ratting() throws InterruptedException {
        keyword.click(PropertiesFile.getPropValue("CUS_PRD_FILTER_RATTING_1"));
        Filter_checkBox();
        System.out.printf("done checkbox-ratting" + "\n");
        commonLoad();
    }
    public void Filter_checkSort_and_ratting() throws InterruptedException {
        keyword.click(PropertiesFile.getPropValue("CUS_PRD_FILTER_RATTING_1"));
        keyword.imWait(2);
        clickDropdown();
        System.out.printf("done checksort-ratting"+"\n");

    }
    public void Filter_checkBox_and_checkSort() throws InterruptedException {

        Filter_checkBox();
        keyword.imWait(2);
        clickDropdown();
        System.out.printf("done checksort-checkbox"+"\n");
    }


}

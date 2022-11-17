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
        keyword.openNewTab("URL_PRODUCT_DETAIL");
        Thread.sleep(2000);
    }

    public void commonLoad() throws InterruptedException {
        keyword.imWait(5);
        keyword.openNewTab("URL_PRODUCT_DETAIL");

    }
    public void clickDropdown(){
        keyword.click("CUS_PRD_FILTER_SELECT");
        keyword.imWait(2);
        keyword.randomElement("CUS_PRD_FILTER_CHECKSORT");
    }

    public void filterWithRatting() throws InterruptedException {
        setUp();
        keyword.scrollDownToElement("CUS_PRD_FILTER_RATTING_1");
        keyword.imWait(2);
        keyword.click("CUS_PRD_FILTER_RATTING_1");

        Thread.sleep(10000);
        System.out.printf("When the ratting has no reviews" + "\n");
        keyword.click("CUS_PRD_FILTER_RATTING_2");
        commonLoad();


    }
    public void filterWithCheckBox() throws InterruptedException {
        keyword.randomConcatElement("CUS_PRD_FILTER_CHECKBOX_ELE",5);
    }
    public void filterWithCheckSort() throws InterruptedException {
        commonLoad();
        keyword.imWait(2);
        clickDropdown();
        commonLoad();

    }
    public void filterCheckBoxAndRatting() throws InterruptedException {
        keyword.click("CUS_PRD_FILTER_RATTING_1");
        filterWithCheckBox();
        System.out.printf("done checkbox-ratting" + "\n");
        commonLoad();
    }
    public void filtercWithCheckSortAndRatting() throws InterruptedException {
        keyword.click("CUS_PRD_FILTER_RATTING_1");
        keyword.imWait(2);
        clickDropdown();
        System.out.printf("done checksort-ratting"+"\n");

    }
    public void filterCheckBoxAndCheckSort() throws InterruptedException {

        filterWithCheckBox();
        keyword.imWait(2);
        clickDropdown();
        System.out.printf("done checksort-checkbox"+"\n");
    }


}

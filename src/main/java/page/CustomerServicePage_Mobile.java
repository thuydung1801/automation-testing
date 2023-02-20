package page;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import org.slf4j.Logger;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;

public class CustomerServicePage_Mobile extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private LoginPage objLogin;
    private RegisterPage objRegister ;
    private SignInPage signInPage;
    private CustomerServicePage customerServicePage;

    public CustomerServicePage_Mobile() {
        super();
    }
    public CustomerServicePage_Mobile(KeywordWeb key){
        super(key);
        objLogin = new LoginPage();
        objRegister = new RegisterPage();
        signInPage = new SignInPage();
        customerServicePage = new CustomerServicePage();
    }
    public void filterWithRatting2() throws InterruptedException {
      //  objRegister.acceptAllCookies();
        System.out.printf("When the ratting has no reviews" + "\n");
        keyword.click("CUS_PRD_FILTER_RATTING_2");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.assertEquals("CUS_DATA_VERIFY_PRD_FILTER_NO_REVIEW","CUS_VERIFY_PRD_FILTER_NO_REVIEW");
        customerServicePage.commonLoad();

    }

}

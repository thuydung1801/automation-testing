package page;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import org.slf4j.Logger;
import org.testng.Assert;
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
       // keyword.scrollDownToElement("CUS_PRD_FILTER_RATTING_2");
//        keyword.scrollToPosition();
//        keyword.untilJqueryIsDone(30L);
//        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
//       // Thread.sleep(2000);
//        objRegister.acceptAllCookies();
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        System.out.printf("When the ratting has no reviews" + "\n");
        keyword.click("CUS_PRD_FILTER_RATTING_2");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.assertEquals("CUS_DATA_VERIFY_PRD_FILTER_NO_REVIEW","CUS_VERIFY_PRD_FILTER_NO_REVIEW");
        customerServicePage.commonLoad();
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
//       // Thread.sleep(2000);
        objRegister.acceptAllCookies();
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

    }
    public void checkVerifyHighestRatting() throws InterruptedException {

        boolean check;
        if(customerServicePage.checkHighestRatting("CUS_VERIFY1_PRD_FILTER_CHECKSORT_2_MOBILE","CUS_VERIFY2_PRD_FILTER_CHECKSORT_2_MOBILE")){
            check = true;
        }
        else{
            check=false;
        }
        logger.info("compare from with " + true);
        Assert.assertEquals(check, true);
    }
    public void checkVerifyLowestRatting() throws InterruptedException {

        boolean check;
        if(customerServicePage.checkLowestRatting("CUS_VERIFY1_PRD_FILTER_CHECKSORT_2_MOBILE","CUS_VERIFY2_PRD_FILTER_CHECKSORT_2_MOBILE")){
            check=true;
        }
        else{
            check=false;
        }
        logger.info("compare from with " + true);
        Assert.assertEquals(check, true);
    }
    public void filterWithCheckSort2() throws InterruptedException {
        customerServicePage.commonLoad();
        customerServicePage.clickDropdown("CUS_PRD_FILTER_CHECKSORT_2");
        checkVerifyHighestRatting();

    }
    public void filterWithCheckSort4() throws InterruptedException {
        customerServicePage.clickDropdown("CUS_PRD_FILTER_CHECKSORT_4");
        checkVerifyLowestRatting();
    }
    public void commonNewsLetterWithAccount() throws InterruptedException {
        keyword.imWait(3);
        keyword.click("CUS_MENU");
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("CUS_NEWSLETTER");
        keyword.imWait(3);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("CUS_NEWSLETTER_CHECKBOX");
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        keyword.click("CUS_NEWSLETTER_SUBMIT_ACCOUNT");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

    }
    public void myAccountSubscribeGlamiraNewsletter() throws InterruptedException {
//        setUp();
        keyword.openNewTab("https://dev3.glamira.com/glgb/");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

//        objRegister.acceptAllCookies();
        objLogin.loginOnMobile("COM_INP_DATA_EMAIL", "COM_INP_DATA_PASS");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

//        keyword.navigateToUrl("https://dev3.glamira.com/glgb/customer/account/index/");
        commonNewsLetterWithAccount();
        customerServicePage.checkVerifyNewsletter("CUS_VERIFY_NEWSLETTER_SUBSCRIBE","CUS_VERIFY_DATA_NEWSLETTER_SUBSCRIBE");


    }
    public void myAccountUnSubscribeGlamiraNewsletter() throws InterruptedException {
        commonNewsLetterWithAccount();
        customerServicePage.checkVerifyNewsletter("CUS_VERIFY_NEWSLETTER_UNSUBSCRIBE","CUS_VERIFY_DATA_NEWSLETTER_UNSUBSCRIBE");

    }

}

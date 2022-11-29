package page;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import org.slf4j.Logger;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;

public class CustomerServicePage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private LoginPage objLogin;
    private RegisterPage objRegister ;

    private SignInPage signInPage;
    public CustomerServicePage() {
        super();
    }
    public CustomerServicePage(KeywordWeb key){
        super(key);
        objLogin = new LoginPage();
        objRegister = new RegisterPage();
        signInPage = new SignInPage();
    }

    public void setUp() throws InterruptedException {

        objLogin.loginOnAlert();
        keyword.navigateToUrl("https://dev3.glamira.com/glus/");
        objRegister.acceptAllCookies();
        objRegister.chooseLanguages();
        keyword.untilJqueryIsDone(30L);

        keyword.openNewTab("URL_PRODUCT_DETAIL");
        keyword.untilJqueryIsDone(30L);

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
    public void filterWithCheckSortAndRatting() throws InterruptedException {
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
    public void commonNewsLetterWithAccount(){
        keyword.imWait(3);
        keyword.click("CUS_NEWSLETTER");
        keyword.imWait(3);
        keyword.click("CUS_NEWSLETTER_CHECKBOX");
        keyword.click("CUS_NEWSLETTER_SUBMIT_ACCOUNT");
    }
    public void checkVerifyInputNull(){
        keyword.assertEquals("COM_DATA_MESSAGES_NULL",
                "COM_TEXT_ERROR");
    }
    public void myAccountSubscribeGlamiraNewsletter() throws InterruptedException {
        keyword.openNewTab("https://dev3.glamira.com/glus/");
        objLogin.loginOnWebsite("COM_INP_DATA_EMAIL", "COM_INP_DATA_PASS",null,null,true);
        keyword.untilJqueryIsDone(30L);

        keyword.navigateToUrl("https://dev3.glamira.com/glde/customer/account/index/");
        commonNewsLetterWithAccount();

    }
    public void myAccountUnSubscribeGlamiraNewsletter() throws InterruptedException {
        commonNewsLetterWithAccount();
    }
    public void footerSubscribeGlamiraNewsletter() throws InterruptedException {
//        keyword.reLoadPage();
        keyword.sendKeys("CUS_NEWSLETTER_INP_EMAIL","COM_INP_DATA_EMAIL");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        keyword.click("CUS_NEWSLETTER_SUBMIT_FOOTER");
        keyword.untilJqueryIsDone(30L);

        keyword.recaptchaClickSubmit();
//        keyword.click("CUS_NEWSLETTER_CHECKBOX_CAPTCHA");
//        Thread.sleep(3000);
//        keyword.click("CUS_NEWSLETTER_SUBMIT_CAPTCHA");
    }
    public void footerSubscribeGlamiraNewsletterWithEmailNull() throws InterruptedException {
        keyword.clearText("CUS_NEWSLETTER_INP_EMAIL");
        keyword.imWait(3);
        keyword.sendKeys("CUS_NEWSLETTER_INP_EMAIL","COM_DATA_NULL");
        keyword.click("CUS_NEWSLETTER_SUBMIT_FOOTER");
        checkVerifyInputNull();

    }
    public void footerSubscribeGlamiraNewsletterWithNoCaptcha() throws InterruptedException {
        keyword.sendKeys("CUS_NEWSLETTER_INP_EMAIL","COM_INP_DATA_EMAIL");
        keyword.untilJqueryIsDone(30L);

        keyword.click("CUS_NEWSLETTER_SUBMIT_FOOTER");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        keyword.click("CUS_NEWSLETTER_SUBMIT_CAPTCHA");
        checkVerifyInputNull();

    }



}

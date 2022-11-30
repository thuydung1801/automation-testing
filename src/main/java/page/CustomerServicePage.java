package page;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import org.slf4j.Logger;
import org.testng.Assert;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        keyword.reLoadPage();
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

    }
    public void clickDropdown(String element,String verify) throws InterruptedException {
        keyword.click("CUS_PRD_FILTER_SELECT");
        keyword.imWait(2);
        keyword.click(element);
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
//        keyword.randomElement("CUS_PRD_FILTER_CHECKSORT");
//        commonLoad();

    }

    public void filterWithRatting1() throws InterruptedException {
        setUp();
        keyword.scrollDownToElement("CUS_PRD_FILTER_RATTING_1");
        keyword.imWait(2);
        keyword.click("CUS_PRD_FILTER_RATTING_1");

        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.verifyElementVisible("CUS_VERIFY_PRD_FILTER_RATTING_1");
        keyword.verifyElementVisible("CUS_VERIFY_STAR_PRD_FILTER_RATTING_1");

    }
    public void filterWithRatting2() throws InterruptedException {
        System.out.printf("When the ratting has no reviews" + "\n");
        keyword.click("CUS_PRD_FILTER_RATTING_2");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.assertEquals("CUS_DATA_VERIFY_PRD_FILTER_NO_REVIEW","CUS_VERIFY_PRD_FILTER_NO_REVIEW");
        commonLoad();

    }
    public void checkVerrifyCheckBox(String element, String verify) throws InterruptedException {
        keyword.scrollDownToElement(element);
        keyword.click(element);
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        if(verify == null){
            keyword.assertEquals("CUS_DATA_VERIFY_PRD_FILTER_NO_REVIEW","CUS_VERIFY_PRD_FILTER_NO_REVIEW");
        }
        else{
            keyword.verifyElementVisible(verify);
        }
        keyword.reLoadPage();
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
    }

    public void filterWithCheckBox1() throws InterruptedException {
        checkVerrifyCheckBox("CUS_PRD_FILTER_CHECKBOX_1",null);
    }
    public void filterWithCheckBox2() throws InterruptedException {
//        keyword.randomConcatElement("CUS_PRD_FILTER_CHECKBOX_ELE",5);
        checkVerrifyCheckBox("CUS_PRD_FILTER_CHECKBOX_2","CUS_VERIFY_PRD_FILTER_CHECKBOX_2");

    }
    public void filterWithCheckBox3() throws InterruptedException {
        checkVerrifyCheckBox("CUS_PRD_FILTER_CHECKBOX_3",null);

    }
    public void filterWithCheckBox4() throws InterruptedException {
        checkVerrifyCheckBox("CUS_PRD_FILTER_CHECKBOX_4","CUS_VERIFY_PRD_FILTER_CHECKBOX_4");

    }
    public void filterNoResults() throws InterruptedException {
        System.out.printf("when filter with filter has no results" + "\n");
        keyword.click("CUS_PRD_FILTER_CHECKBOX_1");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("CUS_PRD_FILTER_CHECKBOX_2");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("CUS_PRD_FILTER_CHECKBOX_3");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("CUS_PRD_FILTER_CHECKBOX_4");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.untilJqueryIsDone(30L);
        keyword.assertEquals("CUS_DATA_VERIFY_PRD_FILTER_NO_REVIEW","CUS_VERIFY_PRD_FILTER_NO_REVIEW");

    }
    public void checkVerifyDate() throws ParseException, InterruptedException {
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        String date1 = keyword.getText("CUS_VERIFY_DATE1_PRD_FILTER_CHECKSORT_3");
        String date2 = keyword.getText("CUS_VERIFY_DATE2_PRD_FILTER_CHECKSORT_3");
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        System.out.printf("date 1 : " + date1 + "\n");
        System.out.printf("date 2 : " + date2 + "\n");

        Date date_1 = sdf.parse(date1);
        Date date_2 = sdf.parse(date2);
        boolean check = date_1.after(date_2); //true
        Assert.assertEquals(check, true);
        keyword.reLoadPage();
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

    }
    public void filterWithCheckSort1() throws InterruptedException {
        commonLoad();
        keyword.imWait(2);
        clickDropdown("CUS_PRD_FILTER_CHECKSORT_1",null);

    }
    public void filterWithCheckSort2() throws InterruptedException {
        commonLoad();
        clickDropdown("CUS_PRD_FILTER_CHECKSORT_2",null);
    }
    public void filterWithCheckSort3() throws InterruptedException, ParseException {
        commonLoad();
        clickDropdown("CUS_PRD_FILTER_CHECKSORT_3",null);
        checkVerifyDate();

    }
    public void filterWithCheckSort4() throws InterruptedException {
        clickDropdown("CUS_PRD_FILTER_CHECKSORT_4",null);

    }
    public void filterWithCheckSort5() throws InterruptedException {
        commonLoad();
        clickDropdown("CUS_PRD_FILTER_CHECKSORT_5",null);

    }
    public void commonCheckBoxAndRating(String rating, String checkBox) throws InterruptedException {
        commonLoad();
        keyword.click(rating);
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click(checkBox);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.reLoadPage();
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

    }
    public void filterWithCheckBox1AndRating1() throws InterruptedException {
        commonCheckBoxAndRating("CUS_PRD_FILTER_RATTING_1","CUS_PRD_FILTER_CHECKBOX_1");

    }
    public void filterCheckBoxAndRatting() throws InterruptedException {
        keyword.click("CUS_PRD_FILTER_RATTING_1");
//        filterWithCheckBox();
        System.out.printf("done checkbox-ratting" + "\n");
        commonLoad();
    }
    public void filterWithCheckSortAndRatting() throws InterruptedException {
        keyword.click("CUS_PRD_FILTER_RATTING_1");
        keyword.imWait(2);
//        clickDropdown();
        System.out.printf("done checksort-ratting"+"\n");

    }
    public void filterCheckBoxAndCheckSort() throws InterruptedException {

//        filterWithCheckBox();
        keyword.imWait(2);
//        clickDropdown();
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

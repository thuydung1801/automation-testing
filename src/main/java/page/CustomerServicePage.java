package page;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.Logger;
import org.testng.Assert;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static core.KeywordWeb.driver;

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
//        keyword.navigateToUrl("https://dev3.glamira.com/glus/");
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
        keyword.scrollDownToElement("CUS_PRD_FILTER_RATTING_1");
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
        if(verify == null ||keyword.verifyElementVisible("CUS_VERIFY_PRD_FILTER_NO_REVIEW") ){
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
        checkVerrifyCheckBox("CUS_PRD_FILTER_CHECKBOX_3","CUS_VERIFY_IMG_PRD_FILTER_CHECKBOX_3");

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
    public void clickDropdown(String element) throws InterruptedException {
        keyword.click("CUS_PRD_FILTER_SELECT");
        Thread.sleep(2000);
        keyword.untilJqueryIsDone(30L);
        keyword.click(element);
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

    }
    public boolean checkHighestRatting(String verify1,String verify2){
        String vrf1 = keyword.getAttribute(verify1);
        String verify_1 = vrf1.substring(7,vrf1.length()-2);
        String vrf2 = keyword.getAttribute(verify2);
        String verify_2 = vrf2.substring(7,vrf2.length()-2);
        if(Integer.parseInt(verify_1) >= Integer.parseInt(verify_2) ){
            return true;
        }
        else{
            return false;
        }

    }
    public void checkVerifyHighestRatting() throws InterruptedException {

        boolean check;
        if(checkHighestRatting("CUS_VERIFY1_PRD_FILTER_CHECKSORT_2","CUS_VERIFY2_PRD_FILTER_CHECKSORT_2")){
            check = true;
        }
        else{
            check=false;
        }
        logger.info("compare from with " + true);
        Assert.assertEquals(check, true);
    }
    public boolean checkLowestRatting(String verify1,String verify2) throws InterruptedException{
        String vrf1 = keyword.getAttribute(verify1);
        String verify_1 = vrf1.substring(7,vrf1.length()-2);
        String vrf2 = keyword.getAttribute(verify2);
        String verify_2 = vrf2.substring(7,vrf2.length()-2);
        if(Integer.parseInt(verify_1) <= Integer.parseInt(verify_2) ){
            return true;
        }
        else{
            return false;
        }
    }
    public void checkVerifyLowestRatting() throws InterruptedException {

        boolean check;
        if(checkLowestRatting("CUS_VERIFY1_PRD_FILTER_CHECKSORT_2","CUS_VERIFY2_PRD_FILTER_CHECKSORT_2")){
            check=true;
        }
        else{
            check=false;
        }
        logger.info("compare from with " + true);
        Assert.assertEquals(check, true);
    }
    public boolean checkHelpFulness(String verify1,String verify2){
        String vrf1 = keyword.getText(verify1);
        String vrf2 = keyword.getText(verify2);
        if(Integer.parseInt(vrf1) >= Integer.parseInt(vrf2) ){
            return true;
        }
        else{
            return false;
        }
    }
    public void checkVerifyHelpFulness(){
        boolean check;

        if(checkHelpFulness("CUS_VERIFY1_HELP_PRD_FILTER_CHECKSORT_5","CUS_VERIFY2_HELP_PRD_FILTER_CHECKSORT_5")){
            check = true;
        }
        else{
            check=false;
        }
        logger.info("compare from with " + true);
        Assert.assertEquals(check, true);

    }
    public boolean checkDate() throws ParseException, InterruptedException {
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        String date1 = keyword.getText("CUS_VERIFY_DATE1_PRD_FILTER_CHECKSORT_3");
        String date2 = keyword.getText("CUS_VERIFY_DATE2_PRD_FILTER_CHECKSORT_3");
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        System.out.printf("date 1 : " + date1 + "\n");
        System.out.printf("date 2 : " + date2 + "\n");

        Date date_1 = sdf.parse(date1);
        Date date_2 = sdf.parse(date2);
        boolean check = date_1.after(date_2);
        return check;
    }

    public void checkVerifyDate() throws ParseException, InterruptedException {
        boolean check = checkDate(); //true
        logger.info("compare from with " + true);
        Assert.assertEquals(check, true);
        keyword.reLoadPage();
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

    }
    public void filterWithCheckSort1() throws InterruptedException {
        commonLoad();
        keyword.imWait(2);
        clickDropdown("CUS_PRD_FILTER_CHECKSORT_1");

    }
    public void filterWithCheckSort2() throws InterruptedException {
        commonLoad();
        clickDropdown("CUS_PRD_FILTER_CHECKSORT_2");
        checkVerifyHighestRatting();

    }
    public void filterWithCheckSort3() throws InterruptedException, ParseException {
        commonLoad();
        clickDropdown("CUS_PRD_FILTER_CHECKSORT_3");
        checkVerifyDate();

    }
    public void filterWithCheckSort4() throws InterruptedException {
        clickDropdown("CUS_PRD_FILTER_CHECKSORT_4");
        checkVerifyLowestRatting();
    }
    public void filterWithCheckSort5() throws InterruptedException {
        commonLoad();
        clickDropdown("CUS_PRD_FILTER_CHECKSORT_5");
        checkVerifyHelpFulness();

        commonLoad();
    }
    public void commonCheckBoxAndRating(String rating, String checkBox,String verifyChechBox) throws InterruptedException {

        keyword.click(rating);
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        keyword.click(checkBox);
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        boolean check ;
        if(keyword.verifyElementVisible("CUS_VERIFY_PRD_FILTER_NO_REVIEW")){

            keyword.assertEquals("CUS_DATA_VERIFY_PRD_FILTER_NO_REVIEW","CUS_VERIFY_PRD_FILTER_NO_REVIEW");
            check = true;
        }
        else if(keyword.verifyElementVisible("CUS_VERIFY_STAR_PRD_FILTER_RATTING_1") &&
                keyword.verifyElementVisible(verifyChechBox)){
            check = true;

        }
        else{
            check=false;

        }
        logger.info("compare from with " + true);
        Assert.assertEquals(check,true);


    }
    public void filterWithCheckBox1AndRating1() throws InterruptedException {
        commonLoad();
        commonCheckBoxAndRating("CUS_PRD_FILTER_RATTING_1","CUS_PRD_FILTER_CHECKBOX_1",null);

    }
    public void filterWithCheckBox2AndRating1() throws InterruptedException {
        commonLoad();
        commonCheckBoxAndRating("CUS_PRD_FILTER_RATTING_1","CUS_PRD_FILTER_CHECKBOX_2","CUS_VERIFY_PRD_FILTER_CHECKBOX_2");

    }
    public void filterWithCheckBox3AndRating1() throws InterruptedException {
        commonLoad();
        commonCheckBoxAndRating("CUS_PRD_FILTER_RATTING_1","CUS_PRD_FILTER_CHECKBOX_3","CUS_VERIFY_IMG_PRD_FILTER_CHECKBOX_3");

    }
    public void filterWithCheckBox4AndRating1() throws InterruptedException {
        commonLoad();
        commonCheckBoxAndRating("CUS_PRD_FILTER_RATTING_1","CUS_PRD_FILTER_CHECKBOX_4","CUS_VERIFY_PRD_FILTER_CHECKBOX_4");

    }
    public void filterWithCheckBoxAndRatingNoReview() throws InterruptedException {
        commonLoad();
        keyword.click("CUS_PRD_FILTER_RATTING_2");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.randomConcatElement("CUS_PRD_FILTER_CHECKBOX_ELE",5);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        keyword.assertEquals("CUS_DATA_VERIFY_PRD_FILTER_NO_REVIEW","CUS_VERIFY_PRD_FILTER_NO_REVIEW");

    }
    public void filterCheckBoxAndCheckSort(String checkBox, String checkSort) throws InterruptedException {
        commonLoad();
        keyword.click(checkBox);
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        clickDropdown(checkSort);
//        keyword.untilJqueryIsDone(30L);
//        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

    }
    public void checkVerifyCheckBoxAndCheckSort(String verifyCheckBox, String verifyCheckSort1,String verifyCheckSort2,boolean a) throws InterruptedException {
        boolean check;
        if(keyword.verifyElementVisible("CUS_VERIFY_PRD_FILTER_NO_REVIEW")){
            keyword.assertEquals("CUS_DATA_VERIFY_PRD_FILTER_NO_REVIEW","CUS_VERIFY_PRD_FILTER_NO_REVIEW");
            check=true;
        }else if(keyword.verifyElementVisible(verifyCheckBox) &&
                checkLowestRatting("CUS_VERIFY1_PRD_FILTER_CHECKSORT_2","CUS_VERIFY2_PRD_FILTER_CHECKSORT_2")){
            check=true;
        }else{
            check=false;
        }
        logger.info("compare from with " + true);
        Assert.assertEquals(check,true);


    }
    public void filterCheckBox1AndCheckSort1() throws InterruptedException {
        filterCheckBoxAndCheckSort("CUS_PRD_FILTER_CHECKBOX_1","CUS_PRD_FILTER_CHECKSORT_1");
    }
    public void filterCheckBox1AndCheckSort2() throws InterruptedException {
        filterCheckBoxAndCheckSort("CUS_PRD_FILTER_CHECKBOX_1","CUS_PRD_FILTER_CHECKSORT_2");
        boolean check;
        if(keyword.verifyElementVisible("CUS_VERIFY_PRD_FILTER_NO_REVIEW")){
            keyword.assertEquals("CUS_DATA_VERIFY_PRD_FILTER_NO_REVIEW","CUS_VERIFY_PRD_FILTER_NO_REVIEW");
            check=true;
        }else if(checkHighestRatting("CUS_VERIFY1_PRD_FILTER_CHECKSORT_2","CUS_VERIFY2_PRD_FILTER_CHECKSORT_2")){
            check=true;
        }else{
            check=false;
        }
        logger.info("compare from with " + true);
        Assert.assertEquals(check,true);

    }
    public void filterCheckBox1AndCheckSort3() throws InterruptedException, ParseException {
        filterCheckBoxAndCheckSort("CUS_PRD_FILTER_CHECKBOX_1","CUS_PRD_FILTER_CHECKSORT_3");
        boolean check;
        if(keyword.verifyElementVisible("CUS_VERIFY_PRD_FILTER_NO_REVIEW")){
            keyword.assertEquals("CUS_DATA_VERIFY_PRD_FILTER_NO_REVIEW","CUS_VERIFY_PRD_FILTER_NO_REVIEW");
            check=true;
        }else if(checkDate()){
            check=true;
        }else{
            check=false;
        }
        logger.info("compare from with " + true);
        Assert.assertEquals(check,true);

    }
    public void filterCheckBox1AndCheckSort4() throws InterruptedException {
        filterCheckBoxAndCheckSort("CUS_PRD_FILTER_CHECKBOX_1","CUS_PRD_FILTER_CHECKSORT_4");
        boolean check;
        if(keyword.verifyElementVisible("CUS_VERIFY_PRD_FILTER_NO_REVIEW")){
            keyword.assertEquals("CUS_DATA_VERIFY_PRD_FILTER_NO_REVIEW","CUS_VERIFY_PRD_FILTER_NO_REVIEW");
            check=true;
        }else if(checkLowestRatting("CUS_VERIFY1_PRD_FILTER_CHECKSORT_2","CUS_VERIFY2_PRD_FILTER_CHECKSORT_2")){
            check=true;
        }else{
            check=false;
        }
        logger.info("compare from with " + true);
        Assert.assertEquals(check,true);

    }
    public void filterCheckBox1AndCheckSort5() throws InterruptedException {
        filterCheckBoxAndCheckSort("CUS_PRD_FILTER_CHECKBOX_1","CUS_PRD_FILTER_CHECKSORT_5");
        boolean check;
        if(keyword.verifyElementVisible("CUS_VERIFY_PRD_FILTER_NO_REVIEW")){
            keyword.assertEquals("CUS_DATA_VERIFY_PRD_FILTER_NO_REVIEW","CUS_VERIFY_PRD_FILTER_NO_REVIEW");
            check=true;
        }else if(checkHelpFulness("CUS_VERIFY1_HELP_PRD_FILTER_CHECKSORT_5","CUS_VERIFY2_HELP_PRD_FILTER_CHECKSORT_5")) {
            check=true;
        }else{
            check=false;
        }
        logger.info("compare from with " + true);
        Assert.assertEquals(check,true);

    }

    public void commonNewsLetterWithAccount() throws InterruptedException {
        keyword.imWait(3);
        keyword.click("CUS_NEWSLETTER");
        keyword.imWait(3);
        keyword.click("CUS_NEWSLETTER_CHECKBOX");
        keyword.click("CUS_NEWSLETTER_SUBMIT_ACCOUNT");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

    }
    public void checkVerifyInputNull(){
        keyword.assertEquals("COM_DATA_MESSAGES_NULL",
                "COM_TEXT_ERROR");
    }
    public void checkVerifyNewsletter(String element, String message){
        if(keyword.verifyElementVisible(element)){
            keyword.assertEquals(message,element);
        }
        else{
            logger.info("Erorr....");
        }
    }
    public void myAccountSubscribeGlamiraNewsletter() throws InterruptedException {
//        setUp();
        keyword.openNewTab("https://dev3.glamira.com/glde/");
        objLogin.loginOnWebsite("COM_INP_DATA_EMAIL", "COM_INP_DATA_PASS",null,null,true);
        keyword.untilJqueryIsDone(30L);

        keyword.navigateToUrl("https://dev3.glamira.com/glde/customer/account/index/");
        commonNewsLetterWithAccount();
        checkVerifyNewsletter("CUS_VERIFY_NEWSLETTER_SUBSCRIBE","CUS_VERIFY_DATA_NEWSLETTER_SUBSCRIBE");


    }
    public void myAccountUnSubscribeGlamiraNewsletter() throws InterruptedException {
        commonNewsLetterWithAccount();
        checkVerifyNewsletter("CUS_VERIFY_NEWSLETTER_UNSUBSCRIBE","CUS_VERIFY_DATA_NEWSLETTER_UNSUBSCRIBE");

    }
    public void footerSubscribeGlamiraNewsletter() throws InterruptedException {
//        keyword.reLoadPage();
        keyword.sendKeys("CUS_NEWSLETTER_INP_EMAIL","COM_INP_DATA_EMAIL");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("CUS_NEWSLETTER_SUBMIT_FOOTER");

        keyword.untilJqueryIsDone(30L);
        keyword.click("CUS_NEWSLETTER_SUBMIT_CAPTCHA");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        checkVerifyNewsletter("CUS_VERIFY_NEWSLETTER_SUBSCRIBE","CUS_VERIFY_DATA_NEWSLETTER_FOOTER_SUBSCRIBE");
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

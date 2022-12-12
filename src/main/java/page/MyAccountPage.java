package page;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import org.slf4j.Logger;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;

import java.util.Date;

public class MyAccountPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private LoginPage objLogin;
    private RegisterPage objRegister ;
    private SignInPage signInPage;
    public MyAccountPage(){super();}
    public MyAccountPage(KeywordWeb key){
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

        keyword.navigateToUrl("https://dev3.glamira.com/glde/");
        keyword.untilJqueryIsDone(30L);
        objLogin.loginOnWebsite("COM_INP_DATA_EMAIL", "COM_INP_DATA_PASS",null,null,true);
        keyword.untilJqueryIsDone(30L);
        keyword.navigateToUrl("https://dev3.glamira.com/glde/customer/account/edit/");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

    }
    public void commonPersonalInf(String checkBox) throws InterruptedException {
        keyword.click("MAC_PERSONAL_INF");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        if(checkBox!=null){
            keyword.click(checkBox);
        }
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

    }
    public void inpFullName(String firstName, String lastName) throws InterruptedException {

        keyword.clearText("MAC_INP_FIRST_NAME");
        keyword.sendKeys("MAC_INP_FIRST_NAME",firstName);
        keyword.clearText("MAC_INP_LAST_NAME");
        keyword.sendKeys("MAC_INP_LAST_NAME",lastName);
        keyword.click("MAC_BTN_SAVE_1");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");


    }
    public void inputChangeMail() throws InterruptedException {
        commonPersonalInf("MAC_CLICK_CHECKBOX_EMAIL");
        String timestamp = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String mail = "dung"+timestamp+"@gmail.com";
        PropertiesFile.serPropValue("COM_INP_DATA_EMAIL",mail);
        keyword.sendKeys("MAC_INP_EMAIL_NEW","COM_INP_DATA_EMAIL");
        keyword.sendKeys("MAC_INP_PASS_CURENT_1","COM_INP_DATA_PASS");
        keyword.click("MAC_BTN_SAVE_2");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

    }
    public void inpChangePassword() throws InterruptedException {
        commonPersonalInf("MAC_CLICK_CHECKBOX_PASS");
        String timestamp = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String pass = "Dung*"+timestamp;
        keyword.sendKeys("MAC_INP_PASS_CURENT_2","COM_INP_DATA_PASS");
        PropertiesFile.serPropValue("COM_INP_DATA_PASS",pass);
        keyword.sendKeys("MAC_INP_PASS_NEW","COM_INP_DATA_PASS");
        keyword.sendKeys("MAC_INP_PASS_CONFIRM","COM_INP_DATA_PASS");
        keyword.click("MAC_BTN_SAVE_3");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

    }
    public void checkVerifyChangeSuccess(String element, String message){
        if(keyword.verifyElementVisible(element)){
            keyword.assertEquals(message,element);
        }
        else{
            logger.info("Erorr....");
        }
    }

    public void changeFullnameWithData() throws InterruptedException {
        setUp();
        inpFullName("MAC_DATA_FIRST_NAME","MAC_DATA_LAST_NAME");
        checkVerifyChangeSuccess("CUS_VERIFY_NEWSLETTER_UNSUBSCRIBE","MAC_VERIFY_DATA_FULLNAME");
    }
    public void checkVerifyInputNull(){
        if(keyword.verifyElementVisible("COM_TEXT_ERROR")){
            keyword.assertEquals("COM_DATA_MESSAGES_NULL",
                    "COM_TEXT_ERROR");
        }

    }

    public void changeFullnameWithDataNUll() throws InterruptedException {
        commonPersonalInf(null);
        inpFullName("COM_DATA_NULL","COM_DATA_NULL");
        checkVerifyInputNull();
    }
    public void changeEmail() throws InterruptedException {
        inputChangeMail();
        checkVerifyChangeSuccess("CUS_VERIFY_NEWSLETTER_UNSUBSCRIBE","MAC_VERIFY_DATA_FULLNAME");

    }
    public void changePassword() throws InterruptedException {
        inpChangePassword();
        checkVerifyChangeSuccess("CUS_VERIFY_NEWSLETTER_UNSUBSCRIBE","MAC_VERIFY_DATA_FULLNAME");

    }



}

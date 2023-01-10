package steps;

import io.cucumber.java.sl.In;
import page.home.RegisterPage;
import page.signinSignup.SignUpPage;
import tests.BaseTest;
import core.KeywordWeb;
import core.PropertiesFile;
import page.home.LoginPage;
import core.BasePage;

import java.util.Date;
import java.util.Properties;

import org.testng.annotations.Test;

public class Steps2 extends BasePage {
    public RegisterPage regis;

    public Steps2() {
        super();
    }

    public Steps2(KeywordWeb key) {
        super(key);

    }

    public LoginPage objLogin;
    public SignUpPage objSignIn;


    public void gotoLogin() throws InterruptedException {

        String a = PropertiesFile.getPropValue("CHECKOUT_LA_LBL_CODE");
        System.out.println(a);
        objLogin.loginOnWebsite("LOGIN_DATA_EMAIL", "LOGIN_DATA_PASSWORD",
                "LOGIN_DATA_PHONE_LINH", "LOGIN_DATA_PHONE_PASS", true);
    }

    public void scroll() {
        keyword.scrollToPositionByScript("window.scrollBy(0,920)");
    }

    public void filterListing() throws InterruptedException {
        keyword.navigateToUrl("https://dev4.glamira.com/glau/diamond-rings/");
        keyword.untilJqueryIsDone(50L);
        keyword.scrollToPositionByScript("window.scrollBy(0,450)");
        keyword.click("LTP_FILTER");
        Thread.sleep(2000);
        keyword.untilJqueryIsDone(50L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        keyword.click("LTP_DIAMONDS");
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
    }

    public void filterLeft(String stonesType, String stones) throws InterruptedException {
        keyword.click(stonesType);
        keyword.untilJqueryIsDone(50L);
        keyword.click(stones);
        keyword.untilJqueryIsDone(50L);
        keyword.waitForElementNotVisible(50, "//div[@class='loading-mask']");
    }

    public void filterListingByPerciousStones() throws InterruptedException {
        filterLeft("LTP_PRECIOUS_STONES", "LTP_PRECIOUS_EMERALD");
    }

    public void filterListingBySemiPreciousStones() throws InterruptedException {
        filterLeft("LTP_SEMI_PRECIOUS", "LTP_SELECT_SEMI_PRECIOUS");
    }

    public void filterListingBySwarovskiCrystals() throws InterruptedException {
        keyword.scrollDownToElement("LTP_SWAROVSKI_CRYSTALS");
        filterLeft("LTP_SWAROVSKI_CRYSTALS", "LTP_SELECT_SWAROVSKI");
    }

    public void filterListingByCulturedPearls() throws InterruptedException {
        keyword.scrollDownToElement("LTP_CULTURED_PEARLS");
        filterLeft("LTP_CULTURED_PEARLS", "LTP_SELECT_CULTURED_PEARLS");
    }

    public void filterListingByLabCreatedStones() throws InterruptedException {
        keyword.scrollDownToElement("LTP_LAB_CREATED_STONES");
        filterLeft("LTP_LAB_CREATED_STONES", "LTP_SELECT_LAB_CREATED_STONES");
    }

    public void filterListingByCabochonStones() throws InterruptedException {
        filterLeft("LTP_CABOCHON_STONES", "LTP_SELECT_CABOCHON_STONES");
    }

    public void filterListingByCarat() throws InterruptedException {
        keyword.scrollDownToElement("LTP_REMOTE_FILTER");
        keyword.click("LTP_REMOTE_FILTER");
        filterLeft("LTP_CARAT", "LTP_SELECT_FILTER_CARAT");
    }

    public void filterListingByStoneShape() throws InterruptedException {
        keyword.scrollDownToElement("LTP_REMOTE_FILTER");
        keyword.click("LTP_REMOTE_FILTER");
        filterLeft("LTP_SHAPE", "LTP_SELECT_SHAPE");
    }
    public void filterListingByColour() throws InterruptedException {
        keyword.scrollDownToElement("LTP_REMOTE_FILTER");
        keyword.click("LTP_REMOTE_FILTER");
        filterLeft("LTP_COLOR", "LTP_SELECT_COLOR");
    }
    public void setUp() throws InterruptedException {
        regis = new RegisterPage();
        objLogin = new LoginPage(this.keyword);
        objSignIn = new SignUpPage(this.keyword);
        keyword.navigateToUrl("https://dev4.glamira.com/glau/");
        regis.chooseLanguages();
        keyword.untilJqueryIsDone(70L);
        objLogin.loginOnWebsite("linh@onlinebizsoft.com","Linh@123",null,null,true);

    }
    public void setUp1() throws InterruptedException {
        regis = new RegisterPage();
        objLogin = new LoginPage(this.keyword);
        objSignIn = new SignUpPage(this.keyword);
        keyword.navigateToUrl("https://dev4.glamira.com/glau/");
        regis.chooseLanguages();
        keyword.untilJqueryIsDone(70L);
    }
    public void myAccount_Overview_Content() throws InterruptedException {
        setUp();
        keyword.navigateToUrl("https://dev4.glamira.com/glau/customer/account/");
    }
    public void myAccount_Overview_Footer() throws InterruptedException {
       keyword.scrollToPositionByScript("window.scrollBy(0,10000)");
       keyword.untilJqueryIsDone(70L);
       keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
    }
    public void return_CustomerExist() throws InterruptedException {
        setUp();
        keyword.navigateToUrl("https://dev4.glamira.com/glau/return/order/index/");
        keyword.untilJqueryIsDone(70L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
    }
    public void return_CustomerNotExist() throws InterruptedException {
        keyword.click("MAC_BTN_LOGOUT");
        keyword.click("MAC_LOGOUT_OK");
        keyword.untilJqueryIsDone(70L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.navigateToUrl("https://dev4.glamira.com/glau/return");
        keyword.untilJqueryIsDone(70L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
    }
    public void signUp_FormHomeLogin() throws InterruptedException {
        setUp1();
        keyword.click("LOGIN_BTN_LOGIN");
        keyword.untilJqueryIsDone(70L);
     //   keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

    }
    public void signUp_FormCreateAccount_Step1() throws InterruptedException {
        keyword.reLoadPage();
        objSignIn.goToFormCreateMyAccount();
    }
    public void signUp_FormCreateAccountError_Step1() throws InterruptedException {
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("SIGNUP_BTN_NEXT_STEEP");
        keyword.untilJqueryIsDone(70L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
    }
    public void signUp_FormCreateAccount_Step2() throws InterruptedException {
        String firstName = "Thuy";
        String lastName = "Dung";
        String timestamp = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String mail = "dung"+timestamp+"@gmail.com";
        PropertiesFile.serPropValue("COM_INP_DATA_EMAIL_UI",mail);
        objSignIn.sendKeyFullDataFormInformation(firstName,lastName,mail,mail);
        keyword.click("SIGNUP_BTN_NEXT_STEEP");
        keyword.untilJqueryIsDone(70L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

    }
    public void signUp_FormCreateAccountError_Step2() throws InterruptedException {
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("SIGNUP_BTN_CREATE_ACCOUNT");
        keyword.untilJqueryIsDone(70L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
    }
    public void signUp_FormCreateAccount_Step3() throws InterruptedException {
        keyword.sendKeys("SIGNUP_PASSWORD_INFORMATION","LOGIN_NEW_PASSWORD");
        keyword.click("SIGNUP_CHECKBOX_AGREE");
        keyword.click("SIGNUP_BTN_CREATE_ACCOUNT");
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

    }
    public void signUp_FormCreateAccountError_Step3() throws InterruptedException {
        keyword.click("SIGNUP_BTN_SUBMIT_ACCOUNT");
        keyword.untilJqueryIsDone(70L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
    }
    public void sinIn_FormHomeForgotPassword() throws InterruptedException {
        setUp1();
        keyword.click("LOGIN_BTN_LOGIN");
        keyword.hoverAndClick("LOGIN_BTN_FORGOT_PASSWORD");
        keyword.untilJqueryIsDone(70L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

    }
    public void sinIn_FormForgotPassword_Email() throws InterruptedException {
        keyword.click("LOGIN_BTN_FORGOT_PASSWORD");
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
    }
    public void sinIn_FormForgotPassword_EmailError() throws InterruptedException {
        keyword.click("LOGIN_BTN_SUBMIT_FORGOT_PASSWORD");
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
    }





}

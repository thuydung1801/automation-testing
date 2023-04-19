package page.checkout;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import org.slf4j.Logger;
import org.testng.Assert;
import page.MyAccountPage;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;

public class ShoppingBagPageMobile extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private LoginPage objLogin;
    private RegisterPage objRegister ;
    private LoginPage loginPage;
    public SignInPage signInPage;
    private MyAccountPage myAccountPage;

    public SignInPage objSignIn;
    private ShoppingBagPage shoppingBagPage;

    public ShoppingBagPageMobile(){ super(); }
    public ShoppingBagPageMobile(KeywordWeb key){
        super(key);
        objLogin = new LoginPage();
        objRegister = new RegisterPage();
        loginPage = new LoginPage();
        signInPage = new SignInPage();
        myAccountPage = new MyAccountPage();
        shoppingBagPage=new ShoppingBagPage();
    }
    public void inputCorrectly(String data, String engraving, String domain) throws InterruptedException {
//        keyword.click("CHECKOUT_VIEWDETAIL_BTN_SAVE");
//        Thread.sleep(10000);
//        keyword.click("CHECKOUT_BTN_VIEWDETAIL_COUPLERING_MOBILE");
//        Thread.sleep(2000);
//        String actual = keyword.getText(engraving);
//        String expect = PropertiesFile.getPropValue(data);
//        logger.info(expect);
//        keyword.simpleAssertEquals(expect+ " - "+ expect
//                , actual);
        shoppingBagPage.inputCorrectly(data,engraving, domain);
        keyword.click("PRD_BTN_CLOSE_VIEWDETAIL");
    }

    public void loginAdmin() throws InterruptedException {
        signInPage.openNewTabs();
        keyword.maximizeWindow();
        signInPage.loginAdmin("LOGIN_DATA_USER_NAME_DUNG", "LOGIN_DATA_PASS_WORD_DUNG");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

    }
    public void setup() throws InterruptedException {
        objLogin.loginOnMobile("LOGIN_DATA_EMAIL","LOGIN_DATA_PASSWORD");

    }
    public void viewReturn() throws InterruptedException {
        loginAdmin();
        keyword.click("LOGIN_ADMIN_BTN_LOGISTIC");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("LOGIN_ADMIN_BTN_LOGISTIC_ITEM");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.selectDropDownListByName("LOGIN_ADMIN_BTN_LOGISTIC_ITEM_SELECT_PAGE","200");
        keyword.pressEnter();
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        System.out.printf("----select UK-----");
        logger.info("select UK");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.selectDropDownListByName("LOGIN_ADMIN_BTN_LOGISTIC_LOGIN_CUS_UK","    Glamira UK");
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        Thread.sleep(1000);
        keyword.click("LOGIN_ADMIN_BTN_LOGISTIC_BTN_SEARCH_CUS_UK");
//        keyword.pressEnter();
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        myAccountPage.searchElement();

        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
//        keyword.click("LOGIN_ADMIN_BTN_LOGISTIC_ITEM_VIEW_ORDER");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        int tabNum = Integer.parseInt(PropertiesFile.getPropValue("COUNT_ITEM") )+1;
        logger.info(String.valueOf(tabNum));
        keyword.switchToTab(tabNum);
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("LOGIN_ADMIN_BTN_LOGISTIC_LOGIN_CUS");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        //login as customer
//        keyword.selectDropDownListByName("LOGIN_ADMIN_BTN_LOGISTIC_LOGIN_CUS_UK","GLAMIRA.co.uk");
//        keyword.pressEnter();
//        keyword.untilJqueryIsDone(60L);
//        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("LOGIN_ADMIN_BTN_LOGISTIC_LOGIN_CUS_OK");
        // go to My Return
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.switchToTab(3);
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.resizeBrowser(319,848);

        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        keyword.click("MAC_MY_ORD_BTN_COMPLETE");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("MAC_MY_ORD_BTN_VIEW_RETURN_MOBILE");
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        keyword.click("MAC_MY_ORD_BTN_RETURN");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.verifyElementVisible("MAC_MY_ORD_VERIFY_RETURN");
    }
    public void stepReturn() throws InterruptedException {

        viewReturn();
        boolean check;
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        String s = keyword.getText("MAC_MY_ORD_VERIFY_RETURN_GET_ID_ORDER2");
        String id=s.substring(1,s.length());
        System.out.printf("ID : " + id +"\n");
        if(id.equalsIgnoreCase(PropertiesFile.getPropValue("KEY_ID_ORDER"))){
            logger.info("Failed by id:" + id);
            check=false;
        }
        else{
            //PropertiesFile.serPropValue("KEY_ID_ORDER",id);
            check= true;
        }

        //create new return
        if(check){
            keyword.untilJqueryIsDone(60L);
            keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
            keyword.click("MAC_MY_ORD_RETURN_STEP1_CHECKBOX1");
            keyword.keysBoardWithDOWN("MAC_MY_ORD_RETURN_STEP1_SELECT1");
            keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
            keyword.click("MAC_MY_ORD_RETURN_STEP1_CHECKBOX2");

            if(keyword.verifyElementVisible("MAC_MY_ORD_RETURN_STEP1_TEXTAREA")){
                keyword.sendKeys("MAC_MY_ORD_RETURN_STEP1_TEXTAREA","MAC_MY_ORD_RETURN_STEP1_DATA_TEXTAREA");
                keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
                keyword.sendKeys("MAC_MY_ORD_RETURN_STEP1_UPLOAD_IMG1","C:\\Users\\Thuy Dung\\Documents\\Kiến trúc và thiết kế phần mềm\\Assigntment45\\media\\images\\products\\main\\kemhop.jpg");
                keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
                keyword.sendKeys("MAC_MY_ORD_RETURN_STEP1_UPLOAD_IMG2","C:\\Users\\Thuy Dung\\Documents\\Kiến trúc và thiết kế phần mềm\\Assigntment45\\media\\images\\products\\main\\kemly.jpg");
                keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
                keyword.sendKeys("MAC_MY_ORD_RETURN_STEP1_UPLOAD_IMG3","C:\\Users\\Thuy Dung\\Documents\\Kiến trúc và thiết kế phần mềm\\Assigntment45\\media\\images\\products\\main\\kemque.jpg");

            }
            else{
                keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
                keyword.click("MAC_MY_ORD_RETURN_STEP1_SELECT2");
                keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
                keyword.doubleClick("MAC_MY_ORD_RETURN_STEP1_SELECT2_OPTION");
                keyword.untilJqueryIsDone(60L);
                keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
                keyword.doubleClick("//div[@class='column main']");
                keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
            }

            keyword.scrollDownToElement("MAC_MY_ORD_RETURN_STEP2");
            keyword.doubleClick("MAC_MY_ORD_RETURN_STEP2");
            keyword.untilJqueryIsDone(60L);
            keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
//            keyword.click("MAC_MY_ORD_RETURN_STEP2_CHECKBOX");
            keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
            keyword.click("MAC_MY_ORD_RETURN_STEP3");
            keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
            keyword.click("MAC_MY_ORD_RETURN_SUBMIT");
            logger.info("done");
            keyword.untilJqueryIsDone(60L);
            keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

            keyword.verifyElementVisible("MAC_MY_ORD_RETURN_SUCCESS");
            PropertiesFile.serPropValue("KEY_ID_ORDER",id);
        }else {
            Assert.assertTrue(false);}
    }
    public void compareData(String expect, String actual) throws InterruptedException {
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        keyword.click("//div[@class='actions-toolbar bottom']//a[@title='Universe Adore 5 mm']");
        Thread.sleep(1000);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.assertEquals(expect, actual);
    }
}

package page;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.testng.Assert;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;

import java.util.Date;
import java.util.Objects;

public class MyAccountPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private LoginPage objLogin;
    private RegisterPage objRegister ;
    private SignInPage signInPage;
    public int countAdd;
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
    public void setUp1() throws InterruptedException {
        objLogin.loginOnAlert();
//        keyword.navigateToUrl("https://dev3.glamira.com/glus/");
        objRegister.acceptAllCookies();
        objRegister.chooseLanguages();
        keyword.untilJqueryIsDone(30L);

        keyword.navigateToUrl("https://dev3.glamira.com/glgb/");
        keyword.untilJqueryIsDone(30L);
        objLogin.loginOnWebsite("COM_INP_DATA_EMAIL", "COM_INP_DATA_PASS",null,null,true);
        keyword.untilJqueryIsDone(30L);
//        keyword.navigateToUrl("https://dev3.glamira.com/glde/customer/account/edit/");
//        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

    }
    public void commonPersonalInf(String checkBox) throws InterruptedException {
        keyword.untilJqueryIsDone(70L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        keyword.click("MAC_PERSONAL_INF");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        if(checkBox!=null){
            keyword.click(checkBox);
        }
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

    }
    public void inpFullName(String firstName, String lastName) throws InterruptedException {
        boolean check;
        keyword.clearText("MAC_INP_FIRST_NAME");
        keyword.sendKeys("MAC_INP_FIRST_NAME",firstName);
        keyword.clearText("MAC_INP_LAST_NAME");
        keyword.sendKeys("MAC_INP_LAST_NAME",lastName);

        keyword.click("MAC_BTN_SAVE_1");
        keyword.untilJqueryIsDone(60L);

//        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");


    }
    public void inputChangeMail() throws InterruptedException {
        commonPersonalInf("MAC_CLICK_CHECKBOX_EMAIL");
        String timestamp = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String mail = "dung"+timestamp+"@gmail.com";
        PropertiesFile.serPropValue("COM_INP_DATA_EMAIL",mail);
        keyword.sendKeys("MAC_INP_EMAIL_NEW","COM_INP_DATA_EMAIL");
        keyword.sendKeys("MAC_INP_PASS_CURENT_1","COM_INP_DATA_PASS");
        keyword.click("MAC_BTN_SAVE_2");
        keyword.untilJqueryIsDone(60L);
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
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

    }
    public void logout() throws InterruptedException {
        keyword.click("MAC_BTN_LOGOUT");
        keyword.untilJqueryIsDone(60L);
        keyword.click("MAC_LOGOUT_OK");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        objLogin.loginOnWebsite("COM_INP_DATA_EMAIL", "COM_INP_DATA_PASS",null,null,true);
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("LOGIN_BTN_LOGIN");
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        boolean test;
        String a = keyword.getText("MAC_VERIFY_NAME");
        if(a.contains("Hallo")){
            test = true;
        }
        else {
            test = false;
        }
        logger.info("check change name....");
        Assert.assertEquals(test,true);



    }
    public void checkVerifyChangeSuccess(String element, String message,String change,String eleChange, String verify) throws InterruptedException {

        if(keyword.verifyElementVisible(element)){
            boolean test ;
            keyword.assertEquals(message,element);
            keyword.untilJqueryIsDone(60L);
            keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
            switch (change){
                case "name" :
                    String s1 = PropertiesFile.getPropValue("MAC_DATA_FIRST_NAME");
                    String s2 = PropertiesFile.getPropValue("MAC_DATA_LAST_NAME");
                    String name = s1 +" "+ s2;
                    String a = keyword.getText(eleChange);
                    if(a.contains(name)){
                        test = true;
                    }
                    else {
                        test = false;
                    }
                    logger.info("check change name....");
                    Assert.assertEquals(test,true);
                    break;
                case "email":
                    String s = keyword.getText(eleChange);
                    if(s.contains(PropertiesFile.getPropValue(verify))){
                        test = true;
                    }
                    else {
                        test = false;
                    }
                    logger.info("check change email....");
                    Assert.assertEquals(test,true);
                    break;
                case "pass":
//                    keyword.click("MAC_PERSONAL_INF");
//                    keyword.untilJqueryIsDone(60L);
//                    keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
//                    keyword.click("MAC_CLICK_CHECKBOX_EMAIL");
//                    if(keyword.getAttributeWithValue(eleChange).contains(PropertiesFile.getPropValue(verify))){
//                        test = true;
//                    }
//                    else {
//                        test = false;
//                    }
//                    logger.info("check change pass....");
//                    Assert.assertEquals(test,true);
                    logout();
                    break;
                case "null":
                    logger.info("NULL....");
                    break;
                default:
                    logger.info("NULL....");
                    break;
            }
        }
        else {
            logger.info("Erorr....");
        }
    }

    public void changeFullnameWithData() throws InterruptedException {
        setUp();
        inpFullName("MAC_DATA_FIRST_NAME","MAC_DATA_LAST_NAME");
        checkVerifyChangeSuccess("CUS_VERIFY_NEWSLETTER_UNSUBSCRIBE","MAC_VERIFY_DATA_FULLNAME","name","MAC_VERIFY_NAME",null);

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
//        checkVerifyChangeSuccess("COM_TEXT_ERROR", "COM_DATA_MESSAGES_NULL",null, null,null);
    }
    public void changeEmail() throws InterruptedException {
        inputChangeMail();
        checkVerifyChangeSuccess("CUS_VERIFY_NEWSLETTER_UNSUBSCRIBE","MAC_VERIFY_DATA_FULLNAME","email","MAC_VERIFY_EMAIL_CHANGE","COM_INP_DATA_EMAIL");

    }

    public void changePassword() throws InterruptedException {
        inpChangePassword();
        checkVerifyChangeSuccess("CUS_VERIFY_NEWSLETTER_UNSUBSCRIBE","MAC_VERIFY_DATA_FULLNAME","pass","MAC_VERIFY_PASS_CHANGE","COM_INP_DATA_PASS");

    }
    public void commonMyAddress(String element,String elementEdit) throws InterruptedException {
        keyword.openNewTab("https://dev3.glamira.com/glde/customer/address/index/#");
        keyword.click(element);
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        countAdd = keyword.countNumberOfElement("MAC_COUNT_ADDRESS");
        if(elementEdit!=null){
            keyword.click(elementEdit);
            keyword.untilJqueryIsDone(30L);
            keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        }
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

    }
    public void inpEditAddress(String label,String element,String btnEdit,String textStreet) throws InterruptedException {
        commonMyAddress(element,btnEdit);
        keyword.clearText("MAC_INP_FIRST_NAME");
        keyword.sendKeys("MAC_INP_FIRST_NAME","MAC_DATA_FIRST_NAME");
        keyword.clearText("MAC_INP_LAST_NAME");
        keyword.sendKeys("MAC_INP_LAST_NAME","MAC_DATA_LAST_NAME");
        keyword.clearText("MAC_INP_COMPANY");
        keyword.sendKeys("MAC_INP_COMPANY","COM_DATA_TITLE");
        keyword.clearText("MAC_INP_PHONE_NUM");
        keyword.sendKeys("MAC_INP_PHONE_NUM","MAC_DATA_PHONE_NUM");
        keyword.clearText("MAC_INP_STREET");
        keyword.imWait(3);
        keyword.sendKeys("MAC_INP_STREET",textStreet);
        Thread.sleep(1000);
        keyword.keysBoardWithDOWN("MAC_INP_STREET_DIV");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        Thread.sleep(1000);
        keyword.click("MAC_BTN_SAVE_ADDRESS");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        if(keyword.verifyElementVisible("CUS_VERIFY_NEWSLETTER_SUBSCRIBE")){
            keyword.assertEquals("MAC_VERIFY_DATA_ADDRESS","CUS_VERIFY_NEWSLETTER_SUBSCRIBE");
        }
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        boolean check;
        String s = PropertiesFile.getPropValue(textStreet);
        String a =  keyword.getText("MAC_VERIFY_SETAS_BILLING_ADDRESS");
        System.out.printf("a===" + a + "\n");
        System.out.printf("s===" + s+ "\n");
        switch (label){
            case "billing":
                if( keyword.getText("MAC_VERIFY_SETAS_BILLING_ADDRESS").contains(s)){

                    check=true;
                }
                else{
                    check=false;
                }
                logger.info("check verify edit billing address...");
                Assert.assertEquals(check,true);
                break;
            case "shipping":
                if(keyword.getText("MAC_VERIFY_SETAS_SHIPPING_ADDRESS").contains(s)){
                    check=true;
                }
                else{
                    check=false;
                }
                logger.info("check verify edit shipping address...");
                Assert.assertEquals(check,true);
                break;
            case "add":
                int b = keyword.countNumberOfElement("MAC_COUNT_ADDRESS");
                System.out.printf("======count: " + countAdd + "\n");
                System.out.printf("======count b: " + b + "\n");
                if(countAdd + 1 == b){
                    check = true;
                }
                else {
                    check=false;
                }
                logger.info("check add...");
                Assert.assertEquals(check,true);
                keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
                break;
            case "edit":
                String n = keyword.getText("MAC_VERIFY_EDIT_ENTRIES");
                System.out.printf("n== " + n +"\n");
                System.out.printf("== " + PropertiesFile.getPropValue("MAC_DATA_STREET3") +"\n");
                if(n.contains(s)){
                    check = true;
                }
                else {
                    check=false;
                }
                logger.info("check edit Additional Address Entries...");
                Assert.assertEquals(check,true);

                break;

            default:
                logger.info("NULL...");
                break;

        }

    }
    public void editBillingAddress() throws InterruptedException {
        inpEditAddress("billing","MAC_MY_ADDRESS_DIRECTORY","MAC_BTN_EDIT_BILLING_ADDRESS","MAC_DATA_STREET1");
    }
    public void editShippingAddress() throws InterruptedException {
       // setUp();
        inpEditAddress("shipping","MAC_MY_ADDRESS_DIRECTORY","MAC_BTN_EDIT_SHIPPING_ADDRESS","MAC_DATA_STREET2");
    }
    public void addNewAddress() throws InterruptedException {
        //setUp();
        inpEditAddress("add","MAC_MY_ADDRESS_DIRECTORY","MAC_BTN_ADD_NEW_ADDRESS","MAC_DATA_STREET9");

    }
    public void editAdditionalAddressEntries() throws InterruptedException {
        //setUp();
        inpEditAddress("edit","MAC_MY_ADDRESS_DIRECTORY","MAC_LINKTEXT_EDIT","MAC_DATA_STREET3");
    }
    public void deleteAdditionalAddressEntries() throws InterruptedException {
//        keyword.openNewTab("https://dev3.glamira.com/glde/customer/address/index/#");
        keyword.click("MAC_MY_ADDRESS_DIRECTORY");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        boolean check;
        int a = keyword.countNumberOfElement("MAC_COUNT_ADDRESS");
        System.out.printf("a===" + a +"\n");
        keyword.click("MAC_LINKTEXT_DELETE");
        keyword.untilJqueryIsDone(60L);
        keyword.click("MAC_BTN_DELETE_OK");
        keyword.untilJqueryIsDone(60L);
        if(keyword.verifyElementVisible("CUS_VERIFY_NEWSLETTER_SUBSCRIBE")){
            keyword.assertEquals("MAC_VERIFY_DATA_DELETE_ADDRESS","CUS_VERIFY_NEWSLETTER_SUBSCRIBE");
        }
        int b = keyword.countNumberOfElement("MAC_COUNT_ADDRESS");
        System.out.printf("b===" + b +"\n");
        if(a == b+1){
            check = true;
        }
        else {
            check=false;
        }
        logger.info("check delete...");
        Assert.assertEquals(check,true);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

    }
    public void setAsDefaultAddress() throws InterruptedException {
//        keyword.openNewTab("https://dev3.glamira.com/glde/customer/address/index/#");
//        keyword.click("MAC_MY_ADDRESS_DIRECTORY");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        String s = keyword.getText("MAC_VERIFY_SETAS_ADDRESS");
        keyword.click("MAC_LINKTEXT_SETAS");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        if(keyword.verifyElementVisible("CUS_VERIFY_NEWSLETTER_SUBSCRIBE")){
            keyword.assertEquals("MAC_VERIFY_DATA_ADDRESS","CUS_VERIFY_NEWSLETTER_SUBSCRIBE");
        }
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        boolean check;
        String a = keyword.getText("MAC_VERIFY_SETAS_SHIPPING_ADDRESS");
        String b = keyword.getText("MAC_VERIFY_SETAS_BILLING_ADDRESS");
        System.out.printf("s==" + s +"\n");
        System.out.printf("a==" + a +"\n");
        System.out.printf("b==" + b +"\n");
        if(keyword.getText("MAC_VERIFY_SETAS_SHIPPING_ADDRESS").contains(s) &&
                keyword.getText("MAC_VERIFY_SETAS_BILLING_ADDRESS").contains(s)){

                check=true;
        }
        else{
            check=false;
        }
        logger.info("check verify address...");
        Assert.assertEquals(check,true);
    }
    public void editSetAsDefaultAddress(String address,String checkBox,String eleText) throws InterruptedException {
       // commonMyAddress("MAC_MY_ADDRESS_DIRECTORY","MAC_LINKTEXT_EDIT");
        keyword.sendKeys("MAC_INP_STREET",address);
        keyword.keysBoardWithDOWN("MAC_INP_STREET_DIV");
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click(checkBox);
        boolean check;
        String s = PropertiesFile.getPropValue(address);

//        String s = keyword.getAttributeWithValue("MAC_INP_STREET");
        keyword.click("MAC_BTN_SAVE_ADDRESS");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        String a = keyword.getText(eleText);
        System.out.printf("s==" + s +"\n");
        System.out.printf("a==" + a +"\n");

        if(keyword.getText(eleText).contains(s) ){

            check=true;
        }
        else{
            check=false;
        }
        logger.info("check verify address...");
        Assert.assertEquals(check,true);

    }
    public void editSetDefaultBilling() throws InterruptedException {
        commonMyAddress("MAC_MY_ADDRESS_DIRECTORY","MAC_LINKTEXT_EDIT");
        editSetAsDefaultAddress("MAC_DATA_STREET6","MAC_CHECKBOX_DEFAULT_BILLING","MAC_VERIFY_SETAS_BILLING_ADDRESS");

    }
    public void editSetDefaultShipping() throws InterruptedException {
        commonMyAddress("MAC_MY_ADDRESS_DIRECTORY","MAC_LINKTEXT_EDIT");
        editSetAsDefaultAddress("MAC_DATA_STREET7","MAC_CHECKBOX_DEFAULT_SHIPPING","MAC_VERIFY_SETAS_SHIPPING_ADDRESS");

    }
    public void commonWishList(String element) throws InterruptedException {
        int count;
        boolean check;
       keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        if(keyword.verifyElementVisible("MAC_WISHLISH_SAVE_NO_DISPLAY")){
            count = 0;
        }else{
            String s = keyword.getText("MAC_WISHLISH_COUNT_SAVE");
            System.out.printf("s..... = " + s + "\n");
            count = Integer.parseInt(s);
        }
        System.out.printf("count.... = " + count + "\n");
        keyword.scrollDownToElement(element);
        keyword.click(element);
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        if(keyword.verifyElementVisible("MAC_VERIFY_ICON_HEART")){
            keyword.untilJqueryIsDone(60L);
            keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
            Thread.sleep(25000);
//            keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
//            commonViewWishList();
//            keyword.webDriverWaitForElementPresent("MAC_WISHLISH_COUNT_SAVE_DISPLAY",100);
            String s = keyword.getText("MAC_WISHLISH_COUNT_SAVE");
            System.out.printf("s..... = " + s + "\n");
            if(s==null){
                System.out.printf("Null"+"\n");
            }
            int count2 = Integer.parseInt(s);
            if(count + 1 == count2){
                check = true;
            }else{
                check = false;
            }
            logger.info("check verify save item...");
            Assert.assertEquals(check,true);
        }

    }
    public void saveItemFormProductView() throws InterruptedException {
        setUp1();

        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.navigateToUrl("https://dev3.glamira.com/glgb/catalog/product_compare/index/");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        keyword.navigateToUrl("URL_WISHLIST_PRODUCT_DETAIL");
        commonWishList("MAC_BTN_HEART");

    }
    public void saveItemFormProductList() throws InterruptedException {
        keyword.navigateToUrl("URL_WISHLIST_PRODUCT_LIST");
        commonWishList("MAC_ICON_HEART");
    }
    public void commonViewWishList() throws InterruptedException {
        keyword.reLoadPage();
        keyword.click("MAC_LINK_HEART");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        keyword.click("MAC_BTN_VIEW_WISHLIST");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

    }
    public void compareMyWishProduct() throws InterruptedException {
        boolean check;
        keyword.navigateToUrl("URL_WISHLIST_PRODUCT_LIST");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("MAC_WISHLIST_ICON_HEART");
        String a = keyword.getText("MAC_WISHLIST_GET_TITLE");
        System.out.printf("a==== " + a + "\n");
        commonViewWishList();
        String s = keyword.getText("MAC_WISHLIST_GET_TITLE_COMPARE");
        System.out.printf("s====" + s + "\n");
        if(a.equalsIgnoreCase(s)){
            check=true;
        }else{
            check=false;
        }
        logger.info("check verify compare item...");
        Assert.assertEquals(check,true);
    }
    public int checkCountRemove(){
        String a = keyword.getText("MAC_WISHLIST_TITLLE_COUNT_SAVE");
        System.out.printf("a=== " + a + "\n");
        String split = a.split("\\s" , 0)[0];
        System.out.printf("split=== " + split + "\n");
        int num = Integer.parseInt(split);
        System.out.printf("num === "+num +"\n");
        return num;
    }
    public void removeItemSave() throws InterruptedException {
        boolean check;
        commonViewWishList();
        int num1 = checkCountRemove();
        keyword.click("MAC_BTN_REMOVE_WISHLIST");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        int num2 = checkCountRemove();
        if(num1-1==num2){
            check=true;
        }else{
            check=false;
        }
        logger.info("check verify remove save item...");
        Assert.assertEquals(check,true);

    }
    public void checkVerifyAdmin() throws InterruptedException {
        signInPage.openNewTabs();
        signInPage.loginAdmin("LOGIN_DATA_USER_NAME_DUNG", "LOGIN_DATA_PASS_WORD_DUNG");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        signInPage.chooseItemCustomer("LOGIN_BTN_CUSTOMER","LOGIN_BTN_CUSTOMER",
                "SIGNUP_VERIFY_CUSTOMER","LOGIN_BTN_EMAIL_LOG",
                "SIGNUP_VERIFY_EMAIL_LOG");
        adminChooseEmailLog("EMAIL_ADDRESS");
    }
    public void adminChooseEmailLog(String text) throws InterruptedException {

//        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.untilJqueryIsDone(30L);
        keyword.webDriverWaitForElementPresent("ADMIN_CUS_EMAILLOG_BTN_FILTER",20);
        Thread.sleep(2000);
        keyword.click("ADMIN_CUS_EMAILLOG_BTN_FILTER");

        keyword.untilJqueryIsDone(30L);

        keyword.clearText("ADMIN_CUS_EMAILLOG_FILTER_INP_RECIPIENT");
        keyword.sendKeys("ADMIN_CUS_EMAILLOG_FILTER_INP_RECIPIENT",text);

        keyword.untilJqueryIsDone(30L);
        keyword.click("ADMIN_CUS_EMAILLOG_ENTER_FILTER");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.assertEquals(text,"ADMIN_CUS_EMAILLOG_TEXT_RECIPIENT");
        keyword.assertEquals("ADMIN_CUS_DATA_EMAILLOG_TEXT_RECIPIENT_TEMP","ADMIN_CUS_EMAILLOG_TEXT_RECIPIENT_TEMP");
//        keyword.click("ADMIN_CUS_EMAILLOG_ACTION_SELECT");
//        keyword.click("ADMIN_CUS_EMAILLOG_ACTION_SELECT_VIEW");
//
//        keyword.untilJqueryIsDone(30L);
//        keyword.scrollDownToElement("ADMIN_CUS_EMAILLOG_ACTION_SELECT_LINK_CREATE");
//        keyword.webDriverWaitForElementPresent("ADMIN_CUS_EMAILLOG_ACTION_SELECT_LINK_CREATE",20);
//        keyword.checkStatusIsDisplay("ADMIN_CUS_EMAILLOG_ACTION_SELECT_LINK_CREATE");
//        System.out.printf("===========");
//        keyword.scrollDownToElement("ADMIN_CUS_EMAILLOG_ACTION_SELECT_LINK_CREATE");
//        keyword.click("ADMIN_CUS_EMAILLOG_ACTION_SELECT_LINK_CREATE");
        keyword.untilJqueryIsDone(30L);

    }
    public void emailSelectItem() throws InterruptedException {
        setUp1();
//        keyword.reLoadPage();
        keyword.click("MAC_LINK_HEART");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        // commonViewWishList();
        keyword.click("MAC_WISHLIST_EMAIL_BTN");
        keyword.untilJqueryIsDone(60L);

        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        keyword.sendKeys("MAC_WISHLIST_EMAIL_INP_NAME","COM_INP_DATA_NAME");
        keyword.sendKeys("MAC_WISHLIST_EMAIL_INP_MAIL","COM_INP_DATA_EMAIL");
        keyword.sendKeys("MAC_WISHLIST_EMAIL_INP_REMAIL","EMAIL_ADDRESS");
        keyword.sendKeys("MAC_WISHLIST_EMAIL_INP_MESSAGE","COM_DATA_TITLE");
        keyword.click("MAC_WISHLIST_EMAIL_CHECKBOX_SUB");
        keyword.click("MAC_WISHLIST_EMAIL_BTN_SUBMIT");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        if(keyword.verifyElementVisible("CUS_VERIFY_NEWSLETTER_SUBSCRIBE")){
            keyword.assertEquals("MAC_VERIFY_DATA_WISHLIST_EMAIL","CUS_VERIFY_NEWSLETTER_SUBSCRIBE");
        }
        checkVerifyAdmin();
    }
    public void logOut() throws InterruptedException {
        setUp1();
        keyword.navigateToUrl("https://dev3.glamira.com/glgb/customer/account/index/");
        keyword.click("MAC_BTN_LOGOUT");
        keyword.untilJqueryIsDone(60L);
        keyword.click("MAC_LOGOUT_OK");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        if(keyword.verifyElementVisible("MAC_LOGOUT_VERIFY_MESSAGE")){
            keyword.assertEquals("MAC_LOGOUT_DATA_MESSAGE","MAC_LOGOUT_VERIFY_MESSAGE");
        }

    }




}

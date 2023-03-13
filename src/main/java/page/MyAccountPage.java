package page;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import io.appium.java_client.android.nativekey.PressesKey;
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
     //   objLogin.loginOnAlert();
//        keyword.navigateToUrl("https://dev3.glamira.com/glus/");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        objRegister.acceptAllCookies();
      //  objRegister.chooseLanguages();
        keyword.untilJqueryIsDone(30L);
        keyword.navigateToUrl("https://stage.glamira.co.uk/");
        keyword.untilJqueryIsDone(30L);
        objLogin.loginOnWebsite("COM_INP_DATA_EMAIL_STAGE", "COM_INP_DATA_PASS_STAGE",null,null,true);
        keyword.untilJqueryIsDone(30L);
        keyword.navigateToUrl("https://stage.glamira.co.uk/customer/account/edit/");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
    }
    public void setUp1() throws InterruptedException {
//        objLogin.loginOnAlert();
       keyword.navigateToUrl("https://stage.glamira.co.uk/");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        objRegister.acceptAllCookies();
//        objRegister.chooseLanguages();
        keyword.untilJqueryIsDone(30L);

        keyword.navigateToUrl("https://stage.glamira.co.uk/");
        keyword.untilJqueryIsDone(30L);
//        objLogin.loginOnWebsite("COM_INP_DATA_EMAIL", "COM_INP_DATA_PASS",null,null,true);
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
        PropertiesFile.serPropValue("COM_INP_DATA_EMAIL_STAGE",mail);
        keyword.sendKeys("MAC_INP_EMAIL_NEW","COM_INP_DATA_EMAIL_STAGE");
        keyword.sendKeys("MAC_INP_PASS_CURENT_1","COM_INP_DATA_PASS_STAGE");
        keyword.click("MAC_BTN_SAVE_2");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

    }
    public void inpChangePassword() throws InterruptedException {
        commonPersonalInf("MAC_CLICK_CHECKBOX_PASS");
        String timestamp = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String pass = "Dung*"+timestamp;
        keyword.sendKeys("MAC_INP_PASS_CURENT_2","COM_INP_DATA_PASS_STAGE");
        PropertiesFile.serPropValue("COM_INP_DATA_PASS_STAGE",pass);
        keyword.sendKeys("MAC_INP_PASS_NEW","COM_INP_DATA_PASS_STAGE");
        keyword.sendKeys("MAC_INP_PASS_CONFIRM","COM_INP_DATA_PASS_STAGE");
        keyword.click("MAC_BTN_SAVE_3");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

    }
    public void logOut() throws InterruptedException {
         keyword.click("MAC_BTN_LOGOUT");
        keyword.untilJqueryIsDone(60L);
        keyword.click("MAC_LOGOUT_OK");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        if(keyword.verifyElementVisible("MAC_LOGOUT_VERIFY_MESSAGE")){
            keyword.assertEquals("MAC_LOGOUT_DATA_MESSAGE","MAC_LOGOUT_VERIFY_MESSAGE");
        }
        Thread.sleep(5000);
        keyword.verifyElementVisible("MAC_LOGOUT_VERIFY_HOMEPAGE");

    }

    public void logOutLogIn() throws InterruptedException {
        logOut();
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        objLogin.loginOnWebsite("COM_INP_DATA_EMAIL_STAGE", "COM_INP_DATA_PASS_STAGE",null,null,true);
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("LOGIN_BTN_ACCOUNT");
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        boolean test;
        String message = keyword.getText("MAC_VERIFY_NAME");
        if(message.contains("Hello")){
            test = true;
        }
        else {
            test = false;
        }
        logger.info("check change password....");
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
                    String firstName = PropertiesFile.getPropValue("MAC_DATA_FIRST_NAME_STAGE");
                    String lastName = PropertiesFile.getPropValue("MAC_DATA_LAST_NAME_STAGE");
                    String name = firstName +" "+ lastName;
                    String text = keyword.getText(eleChange);
                    if(text.contains(name)){
                        test = true;
                    }
                    else {
                        test = false;
                    }
                    logger.info("check change name....");
                    Assert.assertEquals(test,true);
                    break;
                case "email":
                    String textEle = keyword.getText(eleChange);
                    if(textEle.contains(PropertiesFile.getPropValue(verify))){
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
                    logOutLogIn();
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
        inpFullName("MAC_DATA_FIRST_NAME_STAGE","MAC_DATA_LAST_NAME_STAGE");
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
        checkVerifyChangeSuccess("CUS_VERIFY_NEWSLETTER_UNSUBSCRIBE","MAC_VERIFY_DATA_FULLNAME","email","MAC_VERIFY_EMAIL_CHANGE","COM_INP_DATA_EMAIL_STAGE");

    }

    public void changePassword() throws InterruptedException {
//        setUp1();
        keyword.navigateToUrl("https://stage.glamira.co.uk/customer/account/");
        inpChangePassword();
        checkVerifyChangeSuccess("CUS_VERIFY_NEWSLETTER_UNSUBSCRIBE","MAC_VERIFY_DATA_FULLNAME","pass","MAC_VERIFY_PASS_CHANGE","COM_INP_DATA_PASS_STAGE");

    }
    public void deleteAccount(String data) throws InterruptedException {
//        setUp1();
        keyword.openNewTab("https://stage.glamira.co.uk/customer/account/edit/");
        keyword.click("MAC_DELETE_ACCOUNT");
        Thread.sleep(2000);
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.sendKeys("MAC_DELETE_ACCOUNT_INP_PASS",data);
        keyword.click("MAC_DELETE_ACCOUNT_BTN_DELETE");
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("MAC_DELETE_ACCOUNT_BTN_OK");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        if(keyword.verifyElementVisible("MAC_DELETE_ACCOUNT_VERIFY_MESSAGE")){
            keyword.assertEquals("MAC_DELETE_ACCOUNT_DATA_MESSAGE","MAC_DELETE_ACCOUNT_VERIFY_MESSAGE");
        }
    }
    public void commonMyAddress(String element,String elementEdit) throws InterruptedException {
        keyword.openNewTab("https://stage.glamira.co.uk/customer/address/index/#");
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
    public void inpEditAddress(String label,String element,String btnEdit,String textStreet,boolean melissa) throws InterruptedException {
        commonMyAddress(element,btnEdit);
        keyword.clearText("MAC_INP_FIRST_NAME");
        keyword.sendKeys("MAC_INP_FIRST_NAME","MAC_DATA_FIRST_NAME_STAGE");
        keyword.clearText("MAC_INP_LAST_NAME");
        keyword.sendKeys("MAC_INP_LAST_NAME","MAC_DATA_LAST_NAME_STAGE");
        keyword.clearText("MAC_INP_COMPANY");
        keyword.sendKeys("MAC_INP_COMPANY","COM_DATA_TITLE");
        keyword.clearText("MAC_INP_PHONE_NUM");
        keyword.sendKeys("MAC_INP_PHONE_NUM","MAC_DATA_PHONE_NUM");
        keyword.clearText("MAC_INP_STREET");
        keyword.imWait(3);
        keyword.sendKeys("MAC_INP_STREET",textStreet);
        if(melissa){

            Thread.sleep(1000);
            keyword.keysBoardWithDOWN("MAC_INP_STREET_DIV");
            keyword.untilJqueryIsDone(60L);
            keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
            Thread.sleep(1000);

        }
        else {
            keyword.clearText("MAC_INP_CITY");
            keyword.sendKeys("MAC_INP_CITY","MAC_INP_DATA_CITY");
            keyword.keysBoardWithDOWN("MAC_INP_STATE");
            keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
            keyword.clearText("MAC_INP_CODE_CITY");
            keyword.sendKeys("MAC_INP_CODE_CITY","MAC_INP_DATA_CODE_CITY");
        }
        keyword.click("MAC_BTN_SAVE_ADDRESS");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        if(keyword.verifyElementVisible("CUS_VERIFY_NEWSLETTER_SUBSCRIBE")){
            keyword.assertEquals("MAC_VERIFY_DATA_ADDRESS","CUS_VERIFY_NEWSLETTER_SUBSCRIBE");
        }
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        boolean check;
        String street = PropertiesFile.getPropValue(textStreet);
        String textBilling =  keyword.getText("MAC_VERIFY_SETAS_BILLING_ADDRESS");
        System.out.printf("a===" + textBilling + "\n");
        System.out.printf("s===" + street+ "\n");
        switch (label){
            case "billing":
                if( keyword.getText("MAC_VERIFY_SETAS_BILLING_ADDRESS").contains(street)){

                    check=true;
                }
                else{
                    check=false;
                }
                logger.info("check verify edit billing address...");
                Assert.assertEquals(check,true);
                break;
            case "shipping":
                if(keyword.getText("MAC_VERIFY_SETAS_SHIPPING_ADDRESS").contains(street)){
                    check=true;
                }
                else{
                    check=false;
                }
                logger.info("check verify edit shipping address...");
                Assert.assertEquals(check,true);
                break;
            case "add":
                int count = keyword.countNumberOfElement("MAC_COUNT_ADDRESS");
                System.out.printf("======count: " + countAdd + "\n");
                System.out.printf("======count b: " + count + "\n");
                if(countAdd + 1 == count){
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
                String textEdit = keyword.getText("MAC_VERIFY_EDIT_ENTRIES");
                System.out.printf("n== " + textEdit +"\n");
                System.out.printf("== " + PropertiesFile.getPropValue("MAC_DATA_STREET3") +"\n");
                if(textEdit.contains(street)){
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
        inpEditAddress("billing","MAC_MY_ADDRESS_DIRECTORY","MAC_BTN_EDIT_BILLING_ADDRESS","MAC_DATA_STREET1",false);
    }
    public void editShippingAddress() throws InterruptedException {
       // setUp();
        inpEditAddress("shipping","MAC_MY_ADDRESS_DIRECTORY","MAC_BTN_EDIT_SHIPPING_ADDRESS","MAC_DATA_STREET2",false);
    }
    public void addNewAddress() throws InterruptedException {
        //setUp();
        inpEditAddress("add","MAC_MY_ADDRESS_DIRECTORY","MAC_BTN_ADD_NEW_ADDRESS","MAC_DATA_STREET9",false);

    }
    public void editAdditionalAddressEntries() throws InterruptedException {
        //setUp();
        inpEditAddress("edit","MAC_MY_ADDRESS_DIRECTORY","MAC_LINKTEXT_EDIT","MAC_DATA_STREET3",false);
    }
    public void deleteAdditionalAddressEntries() throws InterruptedException {
//        keyword.openNewTab("https://dev3.glamira.com/glde/customer/address/index/#");
        keyword.click("MAC_MY_ADDRESS_DIRECTORY");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        boolean check;
        int countAddress = keyword.countNumberOfElement("MAC_COUNT_ADDRESS");
        System.out.printf("a===" + countAddress +"\n");
        keyword.click("MAC_LINKTEXT_DELETE");
        keyword.untilJqueryIsDone(60L);
        keyword.click("MAC_BTN_DELETE_OK");
        keyword.untilJqueryIsDone(60L);
        if(keyword.verifyElementVisible("CUS_VERIFY_NEWSLETTER_SUBSCRIBE")){
            keyword.assertEquals("MAC_VERIFY_DATA_DELETE_ADDRESS","CUS_VERIFY_NEWSLETTER_SUBSCRIBE");
        }
        int countAddressEdit = keyword.countNumberOfElement("MAC_COUNT_ADDRESS");
        System.out.printf("b===" + countAddressEdit +"\n");
        if(countAddress == countAddressEdit+1){
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
        String address = keyword.getText("MAC_VERIFY_SETAS_ADDRESS");
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
        System.out.printf("s==" + address +"\n");
        System.out.printf("a==" + a +"\n");
        System.out.printf("b==" + b +"\n");
        if(keyword.getText("MAC_VERIFY_SETAS_SHIPPING_ADDRESS").contains(address) &&
                keyword.getText("MAC_VERIFY_SETAS_BILLING_ADDRESS").contains(address)){

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
        String textAddress = PropertiesFile.getPropValue(address);

//        String s = keyword.getAttributeWithValue("MAC_INP_STREET");
        keyword.click("MAC_BTN_SAVE_ADDRESS");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        String text = keyword.getText(eleText);
        System.out.printf("s==" + textAddress +"\n");
        System.out.printf("a==" + text +"\n");

        if(keyword.getText(eleText).contains(textAddress) ){

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
            String countSave = keyword.getText("MAC_WISHLISH_COUNT_SAVE");
            System.out.printf("s..... = " + countSave + "\n");
            count = Integer.parseInt(countSave);
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
            keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
//            commonViewWishList();
//            keyword.webDriverWaitForElementPresent("MAC_WISHLISH_COUNT_SAVE_DISPLAY",100);
            String countSave = keyword.getText("MAC_WISHLISH_COUNT_SAVE");
            System.out.printf("s..... = " + countSave + "\n");
            if(countSave==null){
                System.out.printf("Null"+"\n");
            }
            int count2 = Integer.parseInt(countSave);
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
//        setUp1();

        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.navigateToUrl("https://stage.glamira.co.uk/catalog/product_compare/index/");
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
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

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
        String textTitle = keyword.getText("MAC_WISHLIST_GET_TITLE");
        System.out.printf("a==== " + textTitle + "\n");
        commonViewWishList();
        String textTitleComp = keyword.getText("MAC_WISHLIST_GET_TITLE_COMPARE");
        System.out.printf("s====" + textTitleComp + "\n");
        if(textTitle.equalsIgnoreCase(textTitleComp)){
            check=true;
        }else{
            check=false;
        }
        logger.info("check verify compare item...");
        Assert.assertEquals(check,true);
    }
    public int checkCountRemove(){
        String textTitle = keyword.getText("MAC_WISHLIST_TITLLE_COUNT_SAVE");
        System.out.printf("a=== " + textTitle + "\n");
        String split = textTitle.split("\\s" , 0)[0];
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
     //   setUp1();
        commonViewWishList();
        keyword.click("MAC_WISHLIST_EMAIL_BTN");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.sendKeys("MAC_WISHLIST_EMAIL_INP_NAME","COM_INP_DATA_NAME");
        keyword.sendKeys("MAC_WISHLIST_EMAIL_INP_MAIL","COM_INP_DATA_EMAIL_STAGE");
        keyword.sendKeys("MAC_WISHLIST_EMAIL_INP_REMAIL","EMAIL_ADDRESS");
        keyword.sendKeys("MAC_WISHLIST_EMAIL_INP_MESSAGE","COM_DATA_TITLE");
//        keyword.click("//div[@class=\"recaptcha-checkbox-checkmark\"]");
//        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        keyword.click("MAC_WISHLIST_EMAIL_CHECKBOX_SUB");
        keyword.click("MAC_WISHLIST_EMAIL_BTN_SUBMIT");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        if(keyword.verifyElementVisible("CUS_VERIFY_NEWSLETTER_SUBSCRIBE")){
            keyword.assertEquals("MAC_VERIFY_DATA_WISHLIST_EMAIL","CUS_VERIFY_NEWSLETTER_SUBSCRIBE");
        }
        checkVerifyAdmin();
    }

    public void viewOrder(String textBefore, String btnView,String textAfter) throws InterruptedException {
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        String textID = keyword.getText(textBefore);
        System.out.printf("a======= " + textID + "\n");
        keyword.click(btnView);
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        String textIDComp = keyword.getText(textAfter);
        System.out.printf("b======= " + textIDComp + "\n");
        logger.info("check verify veiw my order....");
        Assert.assertEquals(textIDComp,textID);

    }
    public void viewOrderComplete() throws InterruptedException {
//        setUp1();
        keyword.openNewTab("https://stage.glamira.co.uk/sales/order/history/");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("MAC_MY_ORD_BTN_COMPLETE");
        viewOrder("MAC_MY_ORD_TEXT_ID_COMPLETE","MAC_MY_ORD_BTN_VIEW_COMPLETE","MAC_MY_ORD_VERIFY_TEXT_ID_COMPLETE");

    }
    public void viewOrderRecent() throws InterruptedException {
        keyword.back();
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        viewOrder("MAC_MY_ORD_TEXT_ID_ITEM","MAC_MY_ORD_BTN_VIEW","MAC_MY_ORD_VERIFY_TEXT_ID_ITEM");

    }
    public void loginAdmin() throws InterruptedException {
        signInPage.openNewTabs();
        signInPage.loginAdmin("LOGIN_DATA_USER_NAME_DUNG", "LOGIN_DATA_PASS_WORD_DUNG");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

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
        System.out.printf("----select UK-----");
        logger.info("select UK");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.selectDropDownListByName("LOGIN_ADMIN_BTN_LOGISTIC_LOGIN_CUS_UK","    Glamira UK");
        keyword.pressEnter();
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

        searchElement();
//        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
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

        keyword.click("LOGIN_ADMIN_BTN_LOGISTIC_LOGIN_CUS_OK");
        // go to My Return
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.switchToTab(3);
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("MAC_MY_ORD_BTN_COMPLETE");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("MAC_MY_ORD_BTN_RETURN");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.verifyElementVisible("MAC_MY_ORD_VERIFY_RETURN");
    }
    public boolean checkOrderLoginCus() throws InterruptedException {
        boolean check = false;
            int count = Integer.parseInt(PropertiesFile.getPropValue("COUNT_ITEM"));
            String key = PropertiesFile.getPropValue("LOGIN_ADMIN_BTN_LOGISTIC_ITEM_VIEW_ORDER1")+count
                    +PropertiesFile.getPropValue("LOGIN_ADMIN_BTN_LOGISTIC_ITEM_VIEW_ORDER2");
            System.out.printf("key----" + key);
            while(keyword.verifyElementVisible(key)){

                keyword.click(key);
                keyword.untilJqueryIsDone(80L);
                keyword.waitForElementNotVisible(20,"//div[@class='loading-mask']");
                keyword.untilJqueryIsDone(80L);
                keyword.waitForElementNotVisible(20,"//div[@class='loading-mask']");
                keyword.untilJqueryIsDone(80L);
                keyword.waitForElementNotVisible(20,"//div[@class='loading-mask']");

                Thread.sleep(20000);
                keyword.switchToCurrentTab();
                String status = String.valueOf(verifyIdReturn());
               // keyword.click("//div[@id='ordereditor-account-link']//a[@href='#'][normalize-space()='Edit']");
                if(status.equalsIgnoreCase(String.valueOf(false)) || keyword.verifyElementPresent("VERIFY_NOT_LOGIN_CUS")){
                    count++;
                    PropertiesFile.serPropValue("COUNT_ITEM", String.valueOf(count));
                    key =PropertiesFile.getPropValue("LOGIN_ADMIN_BTN_LOGISTIC_ITEM_VIEW_ORDER1")+count
                            +PropertiesFile.getPropValue("LOGIN_ADMIN_BTN_LOGISTIC_ITEM_VIEW_ORDER2") ;
                    keyword.switchToTab(1);
                }
                else{
                    check=true;
                    break;
                }

            }
            return check;

    }
    public void searchElement() throws InterruptedException {
        while(true) {
            boolean check = checkOrderLoginCus();
            logger.info(String.valueOf(check));
            if(check){
                return;

            }
            else {
                keyword.click("LOGIN_ADMIN_BTN_LOGISTIC_ITEM_BTN_NEXT_PAGE");
                keyword.untilJqueryIsDone(60L);
                keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

            }
        }
    }
    public boolean verifyIdReturn() throws InterruptedException {
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        String s = keyword.getText("MAC_MY_ORD_VERIFY_RETURN_GET_ID_ORDER");
        String id=s.substring(1,10);
        System.out.printf("ID : " + id +"\n");
        if(id.equalsIgnoreCase(PropertiesFile.getPropValue("KEY_ID_ORDER"))){
            logger.info("Failed by id:" + id);
            return false;
        }
        else{
           // PropertiesFile.serPropValue("KEY_ID_ORDER",id);
            return true;
        }
    }
    public void stepReturn() throws InterruptedException {

        viewReturn();
        boolean check;
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        String s = keyword.getText("MAC_MY_ORD_VERIFY_RETURN_GET_ID_ORDER2");
        String id=s.substring(1,s.length());
        System.out.printf("ID2 : " + id +"\n");
        if(id.equalsIgnoreCase(PropertiesFile.getPropValue("KEY_ID_ORDER"))){
            logger.info("Failed by id:" + id);
            check=false;
        }
        else{
            //PropertiesFile.serPropValue("KEY_ID_ORDER",id);
            check= true;
        }

        //create new return
        if(check ){
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
        }else {Assert.assertTrue(false);}
    }
    public void upLoadItemOrder() throws InterruptedException {
        boolean check;
        keyword.back();
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        int numItem =  keyword.countNumberOfElement("MAC_MY_ORD_TABLE_ITEM");
        System.out.printf("a = " + numItem +"\n");
        keyword.click("MAC_MY_ORD_BTN_UPLAOD_MORE");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        int numItemEdit = keyword.countNumberOfElement("MAC_MY_ORD_TABLE_ITEM");
        System.out.printf("a = " + numItemEdit +"\n");
        System.out.printf("a-b " +numItem +"<"+numItemEdit+"\n");
        if(numItem+10 == numItemEdit){
            check = true;
        }else{
            check=false;
        }
        logger.info("check verify upload more my order....");
        Assert.assertEquals(check,true);
    }
    public void checkStatus(String status,String verifyId,String verifyIcon,String verifyText, String dataId, String dataText) throws InterruptedException {
        switch (status){
            case "confirmation":
                logger.info("check verify id order....");
                keyword.assertEquals(dataId,verifyId);
                logger.info("check verify status....");
                keyword.assertEquals(dataText,verifyText);
                keyword.verifyElementVisible(verifyIcon) ;
                break;
            case "delivery" :
                keyword.untilJqueryIsDone(60L);
                keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
                keyword.click("MAC_MY_ORD_BTN_COMPLETE");
                logger.info("check verify id order....");
                keyword.untilJqueryIsDone(60L);
                keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
                keyword.assertEquals(dataId,verifyId);
                logger.info("check verify status....");
                keyword.assertEquals(dataText,verifyText);
                keyword.verifyElementVisible(verifyIcon) ;
                break;

        }

    }
    public void checkStatusConfirmation() throws InterruptedException {
       // setUp1();
        keyword.openNewTab("https://stage.glamira.co.uk/sales/order/history/");

        checkStatus("confirmation","MAC_OVER_ID_ORDER_STATUS_CONFIR","MAC_OVER_STATUS_CONFIR_ICON",
                "MAC_OVER_STATUS_CONFIR","MAC_OVER_DATA_ID_ORDER_STATUS_CONFIR","MAC_OVER_DATA_STATUS_CONFIR");
    }
    public void checkStatusDelivery() throws InterruptedException {
        keyword.reLoadPage();
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        checkStatus("delivery","MAC_OVER_ID_ORDER_STATUS_DELIVERY","MAC_OVER_STATUS_DELIVERY_ICON",
                "MAC_OVER_STATUS_DELIVERY","MAC_OVER_DATA_ID_ORDER_STATUS_DELIVERY","MAC_OVER_DATA_STATUS_DELIVERY");
    }
    public void setUp2() throws InterruptedException {
        objLogin.loginOnAlert();

        objRegister.acceptAllCookies();
        objRegister.chooseLanguages();
        keyword.untilJqueryIsDone(30L);

        keyword.navigateToUrl("https://dev3.glamira.com/glau/");
        keyword.untilJqueryIsDone(30L);
        objLogin.loginOnWebsite("COM_INP_DATA_EMAIL", "COM_INP_DATA_PASS",null,null,true);
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");

    }
    public void checkFunctionInfoCustomer(String element,String verify, String data) throws InterruptedException {
        boolean check;
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click(element);
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        System.out.printf("getText: " + keyword.getText(verify) + "\n");
        System.out.printf("getData: " + PropertiesFile.getPropValue(data) + "\n");
        if(keyword.getText(verify).contains(PropertiesFile.getPropValue(data))){
            check=true;
        }
        else{
            check=false;
        }
        logger.info("check verify My overview....");
        Assert.assertEquals(check,true);
    }
    public void checkContactInfo() throws InterruptedException {
        keyword.back();
        checkFunctionInfoCustomer("MAC_OVER_EDIT_CONTACT_INFO","MAC_OVER_VERIFY_GET_CONTACT_INFO","MAC_OVER_VERIFY_DATA_CONTACT_INFO");
    }
    public void checkChangePassword() throws InterruptedException {
//        setUp2();
        keyword.navigateToUrl("https://stage.glamira.co.uk/customer/account/");
        checkFunctionInfoCustomer("MAC_OVER_LINK_CHANGE_PASS","MAC_OVER_VERIFY_GET_CHANGE_PASS","MAC_OVER_VERIFY_DATA_CHANGE_PASS");
    }
    public void checkChangeShippingAddress() throws InterruptedException {
        keyword.back();
        checkFunctionInfoCustomer("MAC_OVER_EDIT_SHIPPING_ADDRESS","MAC_OVER_VERIFY_GET_TITTLE_ADDRESS","MAC_VERIFY_DATA_TITTLE_ADDRESS");
    }
    public void checkChangeBillingAddress() throws InterruptedException {
        keyword.back();
        checkFunctionInfoCustomer("MAC_OVER_EDIT_BILLING_ADDRESS","MAC_OVER_VERIFY_GET_TITTLE_ADDRESS","MAC_VERIFY_DATA_TITTLE_ADDRESS");
    }
    public void checkChangeNewsLetter() throws InterruptedException {
        keyword.back();
        checkFunctionInfoCustomer("MAC_OVER_EDIT_NEWSLETTER","MAC_OVER_VERIFY_GET_TITTLE_NEWSLETTER","MAC_VERIFY_DATA_TITTLE_NEWSLETTER");
    }

}

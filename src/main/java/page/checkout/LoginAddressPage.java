package page.checkout;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import org.slf4j.Logger;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;

import java.util.Date;

public class LoginAddressPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();

    public LoginAddressPage(KeywordWeb key){
        super(key);
    }
    public LoginAddressPage(){ super(); }

    public ShoppingBagPage objShoppingBagPage;
    private RegisterPage objRegist;
    private LoginAddressPage objLoginAddress;

    public void moveToAddressPage(){
        keyword.webDriverWaitForElementPresent("CHECKOUT_BTN_CONTINUE_GUEST",40);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("CHECKOUT_BTN_CONTINUE_GUEST");
    }


    public void fillContactInformation(boolean isSuggestion, String street,
                                       String code, String city) throws InterruptedException {
        String timestamp = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        keyword.webDriverWaitForElementPresent("CHECKOUT_LA_TBX_FIRST",20);
        keyword.sendKeys("CHECKOUT_LA_TBX_FIRST","LOGIN_DATA_ALERT_USERNAME");
        keyword.sendKeys("CHECKOUT_LA_TBX_LAST","LOGIN_DATA_ALERT_USERNAME");
        String mail = "linh"+timestamp+"@gmail.com";
        PropertiesFile.serPropValue("CHECKOUT_LA_DATA_EMAIL",mail);
        keyword.sendKeys("CHECKOUT_LA_TBX_EMAIL","CHECKOUT_LA_DATA_EMAIL");
        keyword.untilJqueryIsDone(50L);
        keyword.sendKeys("CHECKOUT_LA_TBX_CFEMAIL","CHECKOUT_LA_DATA_EMAIL");
        keyword.sendKeys("CHECKOUT_LA_TBX_PHONE","AFFIRM_DATA_PHONE");
        if (isSuggestion){
            keyword.sendKeys("CHECKOUT_LA_TBX_STREET","CHECKOUT_LA_DATA_STREET_2");
            Thread.sleep(2000);
            keyword.sendKeys("CHECKOUT_LA_TBX_STREET"," ");
            keyword.webDriverWaitForElementPresent("CHECKOUT_LA_SUGGESTLIST",40);
            keyword.click("CHECKOUT_LA_SUGGESTLIST");
        }else {
            keyword.sendKeys("CHECKOUT_LA_TBX_STREET",street);
            keyword.sendKeys("CHECKOUT_LA_TBX_ZIP",code);
            keyword.sendKeys("CHECKOUT_LA_TBX_CITY",city);
        }
        keyword.click("CHECKOUT_BTN_CHECKOUT_ADDRESS");

    }

    public void chooseAddressOnValidation(boolean isSuggest, String btnAdd) throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        if (!isSuggest){
            keyword.click("CHECKOUT_LA_CBX_YOURINPUT");
        }
        keyword.untilJqueryIsDone(50L);
        keyword.click(btnAdd);
    }

    public void addNewAddress(boolean isSuggestion, String street,
                              String code, String city, String btnAdd) throws InterruptedException {
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click(btnAdd);
        keyword.untilJqueryIsDone(50L);
        keyword.webDriverWaitForElementPresent("CHECKOUT_LA_TBX_FIRST",20);
        keyword.sendKeys("CHECKOUT_LA_TBX_FIRST_2","LOGIN_DATA_ALERT_USERNAME");
        keyword.sendKeys("CHECKOUT_LA_TBX_LAST_2","LOGIN_DATA_ALERT_USERNAME");
        keyword.sendKeys("CHECKOUT_LA_TBX_PHONE_2","AFFIRM_DATA_PHONE");
        if (isSuggestion){
            keyword.sendKeys("CHECKOUT_LA_TBX_STREET_2","CHECKOUT_LA_DATA_STREET_2");
            Thread.sleep(5000);
            keyword.sendKeys("CHECKOUT_LA_TBX_STREET_2"," ");
            keyword.webDriverWaitForElementPresent("CHECKOUT_LA_SUGGESTLIST_2",10);
            keyword.click("CHECKOUT_LA_SUGGESTLIST_2");
        }else {
            keyword.sendKeys("CHECKOUT_LA_TBX_STREET_2",street);
            keyword.sendKeys("CHECKOUT_LA_TBX_ZIP_2",code);
            keyword.sendKeys("CHECKOUT_LA_TBX_CITY_2",city);
        }
        keyword.click("CHECKOUT_LA_BTN_SAVE_ADDRESS");
    }

    public void isAddNewAddress(){
        keyword.webDriverWaitForElementPresent("CHECKOUT_LA_MELISSA_ENABLE_2",10);
        keyword.webDriverWaitForElementPresent("CHECKOUT_LA_MELISSA_ENABLE_3",10);
    }

    public void verifyMelissa() throws InterruptedException {
        keyword.untilJqueryIsDone(70L);
        keyword.webDriverWaitForElementPresent("CHECKOUT_LA_SHIPMENT_SELECTED",20);
        keyword.webDriverWaitForElementPresent("CHECKOUT_LA_MELISSA_ENABLE",20);
    }

    public void compareAddress(String data, String location){
        keyword.webDriverWaitForElementPresent(location,10);
        keyword.assertEquals(data,location);
    }
    public void resetForNewCase() throws InterruptedException {
        deleteAllCookies();
        objRegist.acceptAllCookies();
    }

    public void deleteAllCookies() throws InterruptedException {
        objLoginAddress = new LoginAddressPage(this.keyword);
        objRegist = new RegisterPage(this.keyword);
        keyword.deleteAllCookies();
        keyword.reLoadPage();
        keyword.untilJqueryIsDone(50L);
    }

    public void editAddress(String btnEdit) throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.click(btnEdit);
        keyword.untilJqueryIsDone(50L);
        keyword.clearText("CHECKOUT_LA_TBX_ZIP_2");
        keyword.sendKeys("CHECKOUT_LA_TBX_ZIP_2","BT62 4HX");
        keyword.click("CHECKOUT_LA_BTN_SAVE_ADDRESS");
    }

    public void editFullShippingAddress() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.click("CHECKOUT_BTN_EDIT_SHIP_ADDRESS_2");
        keyword.untilJqueryIsDone(50L);
        keyword.clearText("CHECKOUT_LA_TBX_FIRST_2");
        keyword.clearText("CHECKOUT_LA_TBX_LAST_2");
        keyword.clearText("CHECKOUT_LA_TBX_PHONE_2");
        keyword.clearText("CHECKOUT_LA_TBX_STREET_2");
        keyword.clearText("CHECKOUT_LA_TBX_ZIP_2");
        keyword.clearText("CHECKOUT_LA_TBX_CITY_2");
        keyword.sendKeys("CHECKOUT_LA_TBX_FIRST_2","LOGIN_DATA_ALERT_USERNAME");
        keyword.sendKeys("CHECKOUT_LA_TBX_LAST_2","LOGIN_DATA_ALERT_USERNAME");
        keyword.sendKeys("CHECKOUT_LA_TBX_PHONE_2","AFFIRM_DATA_PHONE");
        keyword.sendKeys("CHECKOUT_LA_TBX_STREET_2","CHECKOUT_LA_DATA_STREET_6");
        keyword.sendKeys("CHECKOUT_LA_TBX_ZIP_2","CHECKOUT_LA_DATA_CODE_4");
        keyword.sendKeys("CHECKOUT_LA_TBX_CITY_2","CHECKOUT_LA_DATA_CITY_4");
        keyword.click("CHECKOUT_LA_BTN_SAVE_ADDRESS");
    }

    public void resetAndRefillAddress() throws InterruptedException {
        keyword.webDriverWaitForElementPresent("CHECKOUT_LA_TBX_FIRST",20);
        keyword.clearText("CHECKOUT_LA_TBX_STREET");
        keyword.clearText("CHECKOUT_LA_TBX_ZIP");
        keyword.clearText("CHECKOUT_LA_TBX_CITY");
        keyword.untilJqueryIsDone(50L);
        keyword.sendKeys("CHECKOUT_LA_TBX_STREET_3","CHECKOUT_LA_DATA_STREET_5");
        keyword.sendKeys("CHECKOUT_LA_TBX_ZIP_3","CHECKOUT_LA_DATA_CODE_3");
        keyword.sendKeys("CHECKOUT_LA_TBX_CITY_3","CHECKOUT_LA_DATA_CITY_3");
        keyword.click("CHECKOUT_BTN_CHECKOUT_ADDRESS");
    }

    public void goBack(String verifyElement) throws InterruptedException {
        keyword.scrollDownToElement("CHECKOUT_LA_BTN_BACK");
        keyword.untilJqueryIsDone(50L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("CHECKOUT_LA_BTN_BACK");
        keyword.untilJqueryIsDone(50L);
        keyword.webDriverWaitForElementPresent(verifyElement,30);
    }

    public void editBillingAddress() throws InterruptedException {
        keyword.click("CHECKOUT_BTN_EDIT_BILLING_ADDRESS");
        resetAndRefillAddress();
        verifyMelissa();
        compareAddress("CHECKOUT_DATA_EXPECT_DATA_3","CHECKOUT_LBL_ADDRESS_INFO");
    }

    public void checkOutNotLogin() throws InterruptedException {
        keyword.click("CHECKOUT_LA_PROCEED");
        keyword.untilJqueryIsDone(50L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("CHECKOUT_CBX_CHECKOUT_BANK");
        keyword.untilJqueryIsDone(50L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("CHECKOUT_BTN_ORDER");
        keyword.untilJqueryIsDone(50L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.webDriverWaitForElementPresent("CHECKOUT_SUCCESSPAGE", 30);
        keyword.verifyElementPresent("CHECKOUT_SUCCESSPAGE");
        keyword.sendKeys("SUCCESS_TBX_PASSWORD","CHECKOUT_DATA_PASSWORD_CREATE");
        keyword.click("SUCCESS_BTN_CREATE_ACCOUNT");
    }

    public void loginOnLAPage() throws InterruptedException {
        keyword.sendKeys("CHECKOUT_LA_TBX_USERNAME","LOGIN_DATA_EMAIL");
        keyword.sendKeys("CHECKOUT_LA_TBX_PASS","LOGIN_DATA_PASSWORD");
        keyword.click("CHECKOUT_LA_BTN_LOGIN");
        keyword.untilJqueryIsDone(30L);
        keyword.webDriverWaitForElementPresent("CHECKOUT_LBL_CHECKOUT",10);

    }

    public void loginFailed(String flag) throws InterruptedException {
        if (flag.equals("noEmail")){
            keyword.untilJqueryIsDone(50L);
            keyword.sendKeys("CHECKOUT_LA_TBX_PASS","LOGIN_DATA_PASSWORD");
            keyword.untilJqueryIsDone(30L);
            keyword.click("CHECKOUT_LA_BTN_LOGIN");
            keyword.untilJqueryIsDone(30L);
            keyword.assertEquals("CHECKOUT_MESSAGES_UPDATE_24","CHECKOUT_LA_LBL_ERROR_MAIL");
        }else if(flag.equals("wrongPass")){
            keyword.sendKeys("CHECKOUT_LA_TBX_USERNAME","LOGIN_DATA_EMAIL");
            keyword.sendKeys("CHECKOUT_LA_TBX_PASS","CHECKOUT_DATA_PASSWORD_ENTER");
            keyword.click("CHECKOUT_LA_BTN_LOGIN");
            keyword.untilJqueryIsDone(30L);
            keyword.assertEquals("CHECKOUT_LA_DATA_ERROR_PASS","CHECKOUT_LA_LBL_ERROR_PASS");
        } else if (flag.equals("invalidEmail")) {
            keyword.sendKeys("CHECKOUT_LA_TBX_USERNAME","LOGIN_DATA_PASSWORD");
            keyword.sendKeys("CHECKOUT_LA_TBX_PASS","CHECKOUT_DATA_PASSWORD_ENTER");
            keyword.click("CHECKOUT_LA_BTN_LOGIN");
            keyword.untilJqueryIsDone(30L);
            keyword.assertEquals("CHECKOUT_LA_MESSAGE_USERNAME","CHECKOUT_LA_LBL_ERROR_MAIL");
        }
    }
    public void addNewBillingAddress(boolean isSuggestion, String street,
                              String code, String city) throws InterruptedException {
        keyword.untilJqueryIsDone(70L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("CHECKOUT_HPL_NEW_ADDRESS_LOGIN");
        keyword.untilJqueryIsDone(50L);
        keyword.webDriverWaitForElementPresent("CHECKOUT_LA_TBX_FIRST",20);
        keyword.sendKeys("CHECKOUT_LA_TBX_FIRST_3","LOGIN_DATA_ALERT_USERNAME");
        keyword.sendKeys("CHECKOUT_LA_TBX_LAST_3","LOGIN_DATA_ALERT_USERNAME");
        keyword.sendKeys("CHECKOUT_LA_TBX_PHONE_3","AFFIRM_DATA_PHONE");
        if (isSuggestion){
            keyword.sendKeys("CHECKOUT_LA_TBX_STREET_4","CHECKOUT_LA_DATA_STREET_2");
            keyword.webDriverWaitForElementPresent("CHECKOUT_LA_SUGGESTLIST",10);
            keyword.click("CHECKOUT_LA_SUGGESTLIST");
        }else {
            keyword.sendKeys("CHECKOUT_LA_TBX_STREET_4",street);
            keyword.sendKeys("CHECKOUT_LA_TBX_ZIP_4",code);
            keyword.sendKeys("CHECKOUT_LA_TBX_CITY_4",city);
        }
        keyword.click("CHECKOUT_LA_BTN_SAVE_ADDRESS_2");
    }

    public void removeAddress(String btnRemove) throws InterruptedException {
        keyword.webDriverWaitForElementPresent(btnRemove,20);
        keyword.untilJqueryIsDone(70L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click(btnRemove);
        keyword.untilJqueryIsDone(70L);
        keyword.click("CHECKOUT_LA_BTN_REMOVE_BILLING_ADDRESS_CF");
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.waitForElementNotVisible(10,btnRemove);
    }

    public void checkNumberOfAddress(String expected) throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        String count = String.valueOf(keyword.countNumberOfElement("CHECKOUT_LA_LIST_ADDRESS"));
        logger.info(count);
        keyword.simpleAssertEquals(expected,count);
    }

    public void proceedAddress() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.untilJqueryIsDone(50L);
        keyword.click("CHECKOUT_BTN_CHECKOUT_ADDRESS");
        keyword.untilJqueryIsDone(50L);
    }

    public void removeShippingAddress() throws InterruptedException {
        Integer count = keyword.countNumberOfElement("CHECKOUT_LA_LIST_SHIPPING_ADDRESS");
        removeAddress("CHECKOUT_LA_BTN_REMOVE_SHIPPING_ADDRESS");
        String actualCount = String.valueOf(keyword.countNumberOfElement("CHECKOUT_LA_LIST_SHIPPING_ADDRESS"));
        keyword.simpleAssertEquals(actualCount, String.valueOf(count-1));
    }

    public void wrongFormatCode() throws InterruptedException {
        fillContactInformation(false, "CHECKOUT_LA_DATA_STREET_3",
                "CHECKOUT_LA_DATA_CODE_5", "CHECKOUT_LA_DATA_CITY_2");
        keyword.untilJqueryIsDone(50L);
        keyword.click("CHECKOUT_LA_ADDRESS_POPUP_CANCEL");
        keyword.assertEquals("CHECKOUT_LA_MESSAGES_CODE","CHECKOUT_LA_LBL_CODE");
    }

    public void invalidCodeSymbols() throws InterruptedException {
        keyword.clearText("CHECKOUT_LA_TBX_ZIP");
        keyword.sendKeys("CHECKOUT_LA_TBX_ZIP","CHECKOUT_LA_DATA_CODE_6");
        keyword.assertEquals("CHECKOUT_LA_MESSAGES_CODE","CHECKOUT_LA_LBL_CODE");
        keyword.assertEquals("CHECKOUT_LA_MESSAGE_ERROR_SYMBOLS","CHECKOUT_LA_LBL_ERROR_SYMBOLS");
    }

    public void forgotPassword(String flag) throws InterruptedException {
        switch (flag) {
            case "noEmail":
                keyword.click("CHECKOUT_LA_HPL_FORGOT_PASS");
                keyword.webDriverWaitForElementPresent("CHECKOUT_LA_TBX_FORGOT_PASS_EMAIL", 10);
                keyword.click("CHECKOUT_LA_BTN_FORGOT_PASS_SUBMIT");
                keyword.assertEquals("CHECKOUT_MESSAGES_UPDATE_24", "CHECKOUT_LA_MESSAGE_FORGOT_PASS");
                break;
            case "wrong format":
                keyword.clearText("CHECKOUT_LA_TBX_FORGOT_PASS_EMAIL");
                keyword.sendKeys("CHECKOUT_LA_TBX_FORGOT_PASS_EMAIL", "sophie@");
                keyword.click("CHECKOUT_LA_BTN_FORGOT_PASS_SUBMIT");
                keyword.assertEquals("CHECKOUT_LA_MESSAGE_USERNAME", "CHECKOUT_LA_MESSAGE_FORGOT_PASS");
                break;
            case "invalid code":
                keyword.clearText("CHECKOUT_LA_TBX_FORGOT_PASS_EMAIL");
                keyword.sendKeys("CHECKOUT_LA_TBX_FORGOT_PASS_EMAIL", "LOGIN_DATA_EMAIL");
                keyword.untilJqueryIsDone(50L);
                keyword.click("CHECKOUT_LA_BTN_FORGOT_PASS_SUBMIT");
                keyword.untilJqueryIsDone(50L);
                keyword.sendKeys("CHECKOUT_LA_TBX_FORGOT_PASS_CODE", "12345");
                keyword.click("CHECKOUT_LA_BTN_SEND_CODE_SUBMIT");
                keyword.untilJqueryIsDone(50L);
                keyword.assertEquals("CHECKOUT_LA_MESSAGE_CODE", "CHECKOUT_LA_LBL_MESSAGE_CODE");
                break;
            case "blank code":
                keyword.clearText("CHECKOUT_LA_TBX_FORGOT_PASS_CODE");
                keyword.click("CHECKOUT_LA_BTN_SEND_CODE_SUBMIT");
                keyword.untilJqueryIsDone(50L);
                keyword.assertEquals("CHECKOUT_LA_MESSAGE_CODE_2", "CHECKOUT_LA_LBL_MESSAGE_CODE");
                break;
        }
    }

}

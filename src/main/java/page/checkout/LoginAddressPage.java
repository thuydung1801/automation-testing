package page.checkout;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import org.slf4j.Logger;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;

public class LoginAddressPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();

    public LoginAddressPage(KeywordWeb key){
        super(key);
    }
    public LoginAddressPage(){ super(); }

    public ShoppingBagPage objShoppingBagPage;
    private RegisterPage objRegist;

    public void moveToAddressPage(){
        keyword.webDriverWaitForElementPresent("CHECKOUT_BTN_CONTINUE_GUEST",30);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("CHECKOUT_BTN_CONTINUE_GUEST");
    }


    public void fillContactInformation(boolean isSuggestion, String street,
                                       String code, String city) throws InterruptedException {
        keyword.webDriverWaitForElementPresent("CHECKOUT_LA_TBX_FIRST",20);
        keyword.sendKeys("CHECKOUT_LA_TBX_FIRST","LOGIN_DATA_ALERT_USERNAME");
        keyword.sendKeys("CHECKOUT_LA_TBX_LAST","LOGIN_DATA_ALERT_USERNAME");
        keyword.sendKeys("CHECKOUT_LA_TBX_EMAIL","LOGIN_DATA_EMAIL");
        keyword.untilJqueryIsDone(50L);
        keyword.sendKeys("CHECKOUT_LA_TBX_CFEMAIL","LOGIN_DATA_EMAIL");
        keyword.sendKeys("CHECKOUT_LA_TBX_PHONE","AFFIRM_DATA_PHONE");
        if (isSuggestion){
            keyword.sendKeys("CHECKOUT_LA_TBX_STREET","CHECKOUT_LA_DATA_STREET_2");
            keyword.webDriverWaitForElementPresent("CHECKOUT_LA_SUGGESTLIST",10);
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
                              String code, String city) throws InterruptedException {
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10,"//div[@class='loading-mask']");
        keyword.click("CHECKOUT_HPL_NEW_ADDRESS");
        keyword.untilJqueryIsDone(50L);
        keyword.webDriverWaitForElementPresent("CHECKOUT_LA_TBX_FIRST",20);
        keyword.sendKeys("CHECKOUT_LA_TBX_FIRST_2","LOGIN_DATA_ALERT_USERNAME");
        keyword.sendKeys("CHECKOUT_LA_TBX_LAST_2","LOGIN_DATA_ALERT_USERNAME");
        keyword.sendKeys("CHECKOUT_LA_TBX_PHONE_2","AFFIRM_DATA_PHONE");
        if (isSuggestion){
            keyword.sendKeys("CHECKOUT_LA_TBX_STREET_2","CHECKOUT_LA_DATA_STREET_2");
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
        keyword.untilJqueryIsDone(30L);
        keyword.webDriverWaitForElementPresent("CHECKOUT_LA_SHIPMENT_SELECTED",20);
        keyword.webDriverWaitForElementPresent("CHECKOUT_LA_MELISSA_ENABLE",20);
    }

    public void compareAddress(String data, String location){
        keyword.webDriverWaitForElementPresent(location,10);
        keyword.assertEquals(data,location);
    }
    public void resetForNewCase() throws InterruptedException {
        objRegist = new RegisterPage(this.keyword);
        keyword.deleteAllCookies();
        keyword.reLoadPage();
        keyword.untilJqueryIsDone(50L);
        objRegist.acceptAllCookies();
    }

    public void editAddress() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.click("CHECKOUT_BTN_EDIT_ADDRESS");
        keyword.untilJqueryIsDone(50L);
        keyword.clearText("CHECKOUT_LA_TBX_ZIP_2");
        keyword.sendKeys("CHECKOUT_LA_TBX_ZIP_2","BT62 4HX");
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

    public void goBack() throws InterruptedException {
        keyword.scrollDownToElement("CHECKOUT_LA_BTN_BACK");
        keyword.click("CHECKOUT_LA_BTN_BACK");
        keyword.untilJqueryIsDone(50L);
        keyword.webDriverWaitForElementPresent("CHECKOUT_BTN_CONTINUE_GUEST",30);
    }

    public void editBillingAddress() throws InterruptedException {
        keyword.click("CHECKOUT_BTN_EDIT_BILLING_ADDRESS");
        resetAndRefillAddress();
        verifyMelissa();
        compareAddress("CHECKOUT_DATA_EXPECT_DATA_3","CHECKOUT_LBL_ADDRESS_INFO");
    }

}

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
            keyword.click("CHECKOUT_LA_SUGGESTLIST");
        }else {
            keyword.sendKeys("CHECKOUT_LA_TBX_STREET",street);
            keyword.sendKeys("CHECKOUT_LA_TBX_ZIP",code);
            keyword.sendKeys("CHECKOUT_LA_TBX_CITY",city);
        }
        keyword.click("CHECKOUT_BTN_CHECKOUT_ADDRESS");

    }

    public void chooseAddressOnValidation(){
        keyword.click("CHECKOUT_LA_CBX_YOURINPUT");
        keyword.click("CHECKOUT_LA_BTN_APPLY_ADDRESS");
    }



    public void verifyMelissa() throws InterruptedException {
        keyword.untilJqueryIsDone(30L);
        keyword.webDriverWaitForElementPresent("CHECKOUT_LA_SHIPMENT_SELECTED",20);
        keyword.webDriverWaitForElementPresent("CHECKOUT_LA_MELISSA_ENABLE",20);
        String text = keyword.getText("//span[@class='address-info']");
        logger.info(text);
    }
    public void resetForNewCase() throws InterruptedException {
        objRegist = new RegisterPage(this.keyword);
        keyword.deleteAllCookies();
        keyword.reLoadPage();
        keyword.untilJqueryIsDone(50L);
        objRegist.acceptAllCookies();
    }

}

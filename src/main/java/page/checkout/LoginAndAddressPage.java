package page.checkout;
import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import org.slf4j.Logger;
import page.home.RegisterPage;
public class LoginAndAddressPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();

    public LoginAndAddressPage(KeywordWeb key){
        super(key);
    }
    public LoginAndAddressPage(){ super(); }
    private RegisterPage objRegis;
    public RegisterPage objRegist;

//    public void acceptAllCookies() {
//        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("BTN_COOKIES"), 50);
//        keyword.click(PropertiesFile.getPropValue("BTN_COOKIES"));
//    }
    public  void goToPageProduct() throws InterruptedException {
        keyword.navigateToUrl(PropertiesFile.getPropValue("URL_NOTLOGIN"));
        Thread.sleep(5000);
        keyword.scrollDownToElement(PropertiesFile.getPropValue("CHECKOUT_SELECT_PRODUCT"));
        Thread.sleep(2000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_SELECT_PRODUCT"));
        Thread.sleep(2000);
        keyword.scrollDownToElement(PropertiesFile.getPropValue("CHECKOUT_SELECT_RING_SIZE"));
        Thread.sleep(2000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_SELECT_RING_SIZE"));
        Thread.sleep(2000);
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_POPUP_SIZE"),20);
        keyword.scrollDownToElement(PropertiesFile.getPropValue("CHECKOUT_SELECT_ONE_SIZE"));
        Thread.sleep(2000);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_SELECT_ONE_SIZE"));
    }
    public void  clickPtnAddProduct () throws InterruptedException {
        Thread.sleep(3000);
        keyword.click(PropertiesFile.getPropValue("CHECK_OUT_BTN_ADD_PRODUCT"));
        Thread.sleep(1000);
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_POPUP_MINICART_CONTENT"),20);
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_VIEW_DETAIL"));
        Thread.sleep(2000);
    }
    public void btnSubmitCheckOut() throws InterruptedException {
        keyword.click(PropertiesFile.getPropValue("CHECKOUT_BTN_PROCEED_CHECKOUT"));
        Thread.sleep(1000);
    }
    public void GuestNewCustomer() throws InterruptedException {
        Thread.sleep(1000);
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_BOOX_CHECKOUT_GUEST"), 20);
        Thread.sleep(2000);
        keyword.click(PropertiesFile.getPropValue("CECKOUT_BTN_CONTINUE"));
        Thread.sleep(1000);
    }
    public void enterDataAddresse () throws InterruptedException {
        keyword.webDriverWaitForElementPresent(PropertiesFile.getPropValue("CHECKOUT_FORM_LOGIN_ADDRESS"),20);
        Thread.sleep(2000);

    }

}

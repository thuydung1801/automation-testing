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

public class MyAccountMobilePage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private LoginPage objLogin;
    private RegisterPage objRegister;
    private SignInPage signInPage;
    private MyAccountPage objMyAccount;
    public int countAdd;

    public MyAccountMobilePage(KeywordWeb key) {
        super(key);
        objLogin = new LoginPage();
        objRegister = new RegisterPage();
        signInPage = new SignInPage();
        objMyAccount = new MyAccountPage(this.keyword);
    }

    public void changeFullnameWithData() throws InterruptedException {
        objMyAccount.inpFullName("MAC_DATA_FIRST_NAME_STAGE", "MAC_DATA_LAST_NAME_STAGE");
        objMyAccount.checkVerifyChangeSuccess("CUS_VERIFY_NEWSLETTER_UNSUBSCRIBE", "MAC_VERIFY_DATA_FULLNAME", "name", "MAC_VERIFY_NAME", null);
    }

    public void changeFullNameWithDataNUll() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.click("BTN_MYACCOUNT_ON_MOBILE");
        commonPersonalInfOnMobile(null);
        objMyAccount.inpFullName("COM_DATA_NULL", "COM_DATA_NULL");
        objMyAccount.checkVerifyInputNull();
    }

    public void changeEmail() throws InterruptedException {
//        keyword.click("BTN_PERSONAL");
        inputChangeMail();
        objMyAccount.checkVerifyChangeSuccess("CUS_VERIFY_NEWSLETTER_UNSUBSCRIBE", "MAC_VERIFY_DATA_FULLNAME", "email", "MAC_VERIFY_EMAIL_CHANGE", "COM_INP_DATA_EMAIL_VERIFY_MOBILE");
    }

    public void changePassword() throws InterruptedException {
//        setUp1();
        keyword.navigateToUrl("https://stage.glamira.co.uk/customer/account/");
        inpChangePassword();
        keyword.click("BTN_MYACCOUNT_ON_MOBILE");
        keyword.untilJqueryIsDone(50L);
        objMyAccount.logOut();
        objLogin.loginOnMobile("COM_INP_DATA_EMAIL_MOBILE", "COM_PASSWORD_NEW_MOBILE");
        keyword.untilJqueryIsDone(50L);
        keyword.waitForElementNotVisible(30, "//div[@class='loading-mask']");
        keyword.verifyElementVisible("SIGNUP_VERIFY_SIGNUP");
    }

    public void inputChangeMail() throws InterruptedException {
//        commonPersonalInfOnMobile("MAC_CLICK_CHECKBOX_EMAIL");
        keyword.click("BTN_CHANGE_EMAIL_MOBILE");
        String timestamp = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String mail = "thanhh" + timestamp + "@gmail.com";
        PropertiesFile.serPropValue("COM_INP_DATA_EMAIL_MOBILE", mail);
        keyword.untilJqueryIsDone(50L);
        keyword.sendKeys("MAC_INP_EMAIL_NEW", "COM_INP_DATA_EMAIL_MOBILE");
        keyword.sendKeys("MAC_INP_PASS_CURENT_1", "COM_PASSWORD_NEW_MOBILE");
        keyword.click("MAC_BTN_SAVE_2");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
    }

    public void editBillingAddress() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.click("BTN_MYACCOUNT_ON_MOBILE");
        keyword.untilJqueryIsDone(50L);
        keyword.click("BTN_MYADDRESS_MOBILE");
        keyword.untilJqueryIsDone(50L);
        keyword.click("MAC_BTN_EDIT_BILLING_ADDRESS");
        objMyAccount.inpEditAddress("billing", "BTN_MYADDRESS_MOBILE", "BTN_EDIT_ADDRESS", "MAC_DATA_STREET1", false);
    }

    public void editShippingAddress() throws InterruptedException {
        keyword.click("MAC_BTN_EDIT_SHIPPING_ADDRESS");
        objMyAccount.inpEditAddress("billing", "BTN_MYADDRESS_MOBILE", "BTN_EDIT_ADDRESS", "MAC_DATA_STREET1", false);
    }

    public void addNewAddress() throws InterruptedException {
        countAdd = keyword.countNumberOfElement("MAC_COUNT_ADDRESS");
        System.out.println("-------------------------------- :" + countAdd);
        keyword.click("MAC_BTN_ADD_NEW_ADDRESS");
        objMyAccount.inpEditAddress("add", "MAC_MY_ADDRESS_DIRECTORY", "MAC_BTN_ADD_NEW_ADDRESS", "MAC_DATA_STREET9", false);
    }

    public void compareMyWishProductMobile() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        objMyAccount.compareMyWishProduct("MAC_LINK_HEART_MOBILE");
    }

    public void editAdditionalAddressEntries() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.click("MAC_LINKTEXT_EDIT");
        objMyAccount.inpEditAddress("edit", "MAC_MY_ADDRESS_DIRECTORY", "MAC_LINKTEXT_EDIT", "MAC_DATA_STREET3", false);
    }

    public void deleteAdditionalAddressEntries() throws InterruptedException {
        keyword.navigateToUrl("https://stage.glamira.co.uk/customer/account/");
        keyword.click("BTN_MYACCOUNT_ON_MOBILE");
        objMyAccount.deleteAdditionalAddressEntries();
    }

    public void editSetDefaultBilling() throws InterruptedException {
        keyword.untilJqueryIsDone(30L);
        keyword.click("MAC_LINKTEXT_EDIT");
        keyword.untilJqueryIsDone(30L);
        objMyAccount.editSetAsDefaultAddress("MAC_DATA_STREET6", "MAC_CHECKBOX_DEFAULT_BILLING", "MAC_VERIFY_SETAS_BILLING_ADDRESS");
    }

    public void editSetDefaultShipping() throws InterruptedException {
//        commonMyAddress("MAC_MY_ADDRESS_DIRECTORY", "MAC_LINKTEXT_EDIT");
        objMyAccount.editSetAsDefaultAddress("MAC_DATA_STREET7", "MAC_CHECKBOX_DEFAULT_SHIPPING", "MAC_VERIFY_SETAS_SHIPPING_ADDRESS");

    }

    public void inpChangePassword() throws InterruptedException {
//        commonPersonalInf("MAC_CLICK_CHECKBOX_PASS");
        keyword.click("BTN_MYACCOUNT_ON_MOBILE");
        keyword.click("MAC_PERSONAL_INF_MOBILE");
        keyword.click("BTN_CHANGE_PASSWORD");
        keyword.untilJqueryIsDone(50L);
        String timestamp = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String pass = "Thanhh*" + timestamp;
        keyword.sendKeys("MAC_INP_PASS_CURENT_2", "COM_PASSWORD_NEW_MOBILE");
        PropertiesFile.serPropValue("COM_PASSWORD_NEW_MOBILE", pass);
        keyword.sendKeys("MAC_INP_PASS_NEW", "COM_PASSWORD_NEW_MOBILE");
        keyword.sendKeys("MAC_INP_PASS_CONFIRM", "COM_PASSWORD_NEW_MOBILE");
        keyword.click("MAC_BTN_SAVE_3");
        keyword.untilJqueryIsDone(60L);
        keyword.assertEquals("MAC_VERIFY_DATA_FULLNAME", "CUS_VERIFY_NEWSLETTER_UNSUBSCRIBE");
    }

    public void commonPersonalInfOnMobile(String checkBox) throws InterruptedException {
        keyword.untilJqueryIsDone(70L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        keyword.click("MAC_PERSONAL_INF_MOBILE");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        if (checkBox != null) {
            keyword.click(checkBox);
        }
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
    }

    public void setUp() throws InterruptedException {
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        objRegister.acceptAllCookies();
        keyword.untilJqueryIsDone(30L);
        keyword.navigateToUrl("https://stage.glamira.co.uk/");
        keyword.untilJqueryIsDone(30L);
        objLogin.loginOnMobile("COM_INP_DATA_EMAIL_MOBILE", "COM_PASSWORD_NEW_MOBILE");
        keyword.untilJqueryIsDone(30L);
        keyword.navigateToUrl("https://stage.glamira.co.uk/customer/account/edit/");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
    }

    public void viewOrderComplete() throws InterruptedException {
        keyword.openNewTab("https://stage.glamira.co.uk/sales/order/history/");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(30, "//div[@class='loading-mask']");
        keyword.click("MAC_MY_ORD_BTN_COMPLETE");
        keyword.untilJqueryIsDone(50L);
        keyword.click("BTN_MORE_SHOW");
        objMyAccount.viewOrder("MAC_MY_ORD_TEXT_ID_COMPLETE", "MAC_MY_ORD_BTN_VIEW_COMPLETE", "MAC_MY_ORD_VERIFY_TEXT_ID_COMPLETE");
    }

    public void viewOrderRecent() throws InterruptedException {
        keyword.back();
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(30, "//div[@class='loading-mask']");
        keyword.click("BTN_SHOW_MORE_RECENT");
        objMyAccount.viewOrder("MAC_MY_ORD_TEXT_ID_ITEM", "MAC_MY_ORD_BTN_VIEW", "MAC_MY_ORD_VERIFY_TEXT_ID_ITEM");
    }

    public void viewReturn() throws InterruptedException {
        keyword.switchToTab(1);
        keyword.deleteAllCookies();
        keyword.reLoadPage();
        keyword.switchToTab(0);
        objMyAccount.viewReturn();
    }
public void checkStatusConfirmation() throws InterruptedException {
    keyword.openNewTab("https://stage.glamira.co.uk/sales/order/history/");
    objMyAccount.checkStatus("confirmation", "MAC_OVER_ID_ORDER_STATUS_CONFIR_MOBILE", "MAC_OVER_STATUS_CONFIR_ICON",
            "MAC_OVER_STATUS_CONFIR_MOBILE", "MAC_OVER_DATA_ID_ORDER_STATUS_CONFIR_MOBILE", "MAC_OVER_DATA_STATUS_CONFIR");
}
    public void checkStatusDelivery() throws InterruptedException {
        keyword.reLoadPage();
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        objMyAccount.checkStatus("delivery", "MAC_OVER_ID_ORDER_STATUS_DELIVERY_MOBILE", "MAC_OVER_STATUS_DELIVERY_ICON_MOBILE",
                "MAC_OVER_STATUS_DELIVERY_MOBILE", "MAC_OVER_DATA_ID_ORDER_STATUS_DELIVERY_MOBILE", "MAC_OVER_DATA_STATUS_DELIVERY");
    }

}

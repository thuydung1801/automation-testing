package page;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import org.slf4j.Logger;
import org.testng.Assert;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;

import java.util.Date;

public class MyAccountMobilePage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private LoginPage objLogin;
    private RegisterPage objRegister;
    private SignInPage signInPage;
    private MyAccountPage myAccount;
    public int countAdd;

    public MyAccountMobilePage() {
        super();
    }

    public MyAccountMobilePage(KeywordWeb key) {
        super(key);
        objLogin = new LoginPage();
        objRegister = new RegisterPage();
        signInPage = new SignInPage();
        myAccount = new MyAccountPage();
    }
    public void setUp1() throws InterruptedException {
        objRegister.acceptAllCookies();
        keyword.untilJqueryIsDone(50L);
        keyword.scrollDownToElement("MOBILE_HAMBURGER");
        keyword.untilJqueryIsDone(50L);
        keyword.doubleClick("MOBILE_HAMBURGER");
        keyword.untilJqueryIsDone(50L);
        Thread.sleep(5000);
        keyword.click("MOBILE_ICON_SIGNIN");
        keyword.untilJqueryIsDone(50L);
        keyword.sendKeys("LOGIN_TXT_EMAIL_4", "COM_INP_DATA_EMAIL_TEST");
        Thread.sleep(1000);
        keyword.sendKeys("LOGIN_TXT_PASSWORD", "COM_INP_DATA_PASS");
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        keyword.click("LOGIN_BTN_SUBMITLOGIN");
    }
    public void commonPersonalInf(String checkBox) throws InterruptedException {
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


    public void inputChangeMail() throws InterruptedException {
//        commonPersonalInf("MAC_CLICK_CHECKBOX_EMAIL");
        keyword.click("BTN_CHANGE_EMAIL");
        keyword.untilJqueryIsDone(50L);
        String timestamp = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String mail = "why" + timestamp + "@gmail.com";
        PropertiesFile.serPropValue("COM_INP_DATA_EMAIL2", mail);
        keyword.sendKeys("MAC_INP_EMAIL_NEW", "COM_INP_DATA_EMAIL2");
        keyword.sendKeys("MAC_INP_PASS_CURENT_1", "COM_INP_DATA_PASS2");
        keyword.click("MAC_BTN_SAVE_2");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");

    }

    public void inpChangePassword() throws InterruptedException {
        commonPersonalInf("MAC_CLICK_CHECKBOX_PASS");
        String timestamp = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String pass = "Ngoc" + timestamp;
        keyword.untilJqueryIsDone(50L);
        keyword.sendKeys("MAC_INP_PASS_CURENT_2", "COM_INP_DATA_PASS2");
        PropertiesFile.serPropValue("COM_INP_DATA_PASS2", pass);
        keyword.sendKeys("MAC_INP_PASS_NEW", "COM_INP_DATA_PASS2");
        keyword.sendKeys("MAC_INP_PASS_CONFIRM", "COM_INP_DATA_PASS2");
        keyword.click("MAC_BTN_SAVE_3");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");

    }

    public void logOut() throws InterruptedException {
        keyword.click("MAC_BTN_LOGOUT");
        keyword.untilJqueryIsDone(60L);
        keyword.click("MAC_LOGOUT_OK");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        if (keyword.verifyElementVisible("MAC_LOGOUT_VERIFY_MESSAGE")) {
            keyword.assertEquals("MAC_LOGOUT_DATA_MESSAGE", "MAC_LOGOUT_VERIFY_MESSAGE");
        }
        Thread.sleep(5000);
        keyword.verifyElementVisible("MAC_LOGOUT_VERIFY_HOMEPAGE");

    }

    public void logOutLogIn() throws InterruptedException {
        logOut();
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        objLogin.loginOnWebsite("COM_INP_DATA_EMAIL4", "COM_INP_DATA_PASS", null, null, true);
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        keyword.click("LOGIN_BTN_ACCOUNT");
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        boolean test;
        String message = keyword.getText("MAC_VERIFY_NAME");
        if (message.contains("Hello")) {
            test = true;
        } else {
            test = false;
        }
        logger.info("check change password....");
        Assert.assertEquals(test, true);


    }

    public void checkVerifyChangeSuccess(String element, String message, String change, String eleChange, String verify) throws InterruptedException {
        if (keyword.verifyElementVisible(element)) {
            boolean test;
            keyword.assertEquals(message, element);
            keyword.untilJqueryIsDone(60L);
            keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
            switch (change) {
                case "name":
                    String firstName = PropertiesFile.getPropValue("MAC_DATA_FIRST_NAME_STAGE");
                    String lastName = PropertiesFile.getPropValue("MAC_DATA_LAST_NAME_STAGE");
                    String name = firstName + " " + lastName;
                    String text = keyword.getText(eleChange);
                    if (text.contains(name)) {
                        test = true;
                    } else {
                        test = false;
                    }
                    logger.info("check change name....");
                    Assert.assertEquals(test, true);
                    break;
                case "email":
                    String textEle = keyword.getText(eleChange);
                    if (textEle.contains(PropertiesFile.getPropValue(verify))) {
                        test = true;
                    } else {
                        test = false;
                    }
                    logger.info("check change email....");
                    Assert.assertEquals(test, true);
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
        } else {
            logger.info("Erorr....");
        }
    }

    public void changeFullnameWithData() throws InterruptedException {
        myAccount.setUp();
        keyword.untilJqueryIsDone(50L);
        keyword.untilJqueryIsDone(50L);
        myAccount.inpFullName("MAC_DATA_FIRST_NAME_STAGE", "MAC_DATA_LAST_NAME_STAGE");
        keyword.untilJqueryIsDone(50L);
        checkVerifyChangeSuccess("CUS_VERIFY_NEWSLETTER_UNSUBSCRIBE", "MAC_VERIFY_DATA_FULLNAME", "name", "MAC_VERIFY_NAME", null);
    }

    public void checkVerifyInputNull() {
        if (keyword.verifyElementVisible("COM_TEXT_ERROR")) {
            keyword.assertEquals("COM_DATA_MESSAGES_NULL",
                    "COM_TEXT_ERROR");
        }
    }

    public void changeFullnameWithDataNUll() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.click("BTN_MYACCOUNT");
        keyword.untilJqueryIsDone(50L);
        commonPersonalInf(null);
        myAccount.inpFullName("COM_DATA_NULL", "COM_DATA_NULL");
        checkVerifyInputNull();
//        checkVerifyChangeSuccess("COM_TEXT_ERROR", "COM_DATA_MESSAGES_NULL",null, null,null);
    }

    public void changeEmail() throws InterruptedException {
        inputChangeMail();
        keyword.untilJqueryIsDone(50L);
//        checkVerifyChangeSuccess("CUS_VERIFY_NEWSLETTER_UNSUBSCRIBE", "MAC_VERIFY_DATA_FULLNAME", "email", "MAC_VERIFY_EMAIL_CHANGE", "COM_INP_DATA_EMAIL");
        keyword.assertEquals("MAC_VERIFY_DATA_FULLNAME", "CUS_VERIFY_NEWSLETTER_UNSUBSCRIBE");
    }

    public void changePassword() throws InterruptedException {
//        setUp1();
        keyword.navigateToUrl("https://dev3.glamira.com/glgb/customer/account");
        keyword.click("BTN_MYACCOUNT");
        inpChangePassword();
        keyword.untilJqueryIsDone(50L);
        keyword.untilJqueryIsDone(50L);
        keyword.assertEquals("MAC_VERIFY_DATA_FULLNAME", "CUS_VERIFY_NEWSLETTER_UNSUBSCRIBE");

    }

    public void deleteAccount() throws InterruptedException {
//        setUp1();
        keyword.openNewTab("https://dev3.glamira.com/glgb/customer/account/edit/");
        keyword.click("MAC_DELETE_ACCOUNT");
        Thread.sleep(2000);
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        keyword.sendKeys("MAC_DELETE_ACCOUNT_INP_PASS", "COM_INP_DATA_PASS2");
        keyword.click("MAC_DELETE_ACCOUNT_BTN_DELETE");
        keyword.untilJqueryIsDone(50L);
        keyword.click("MAC_DELETE_ACCOUNT_BTN_OK");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        if (keyword.verifyElementVisible("MAC_DELETE_ACCOUNT_VERIFY_MESSAGE")) {
            keyword.assertEquals("MAC_DELETE_ACCOUNT_DATA_MESSAGE", "MAC_DELETE_ACCOUNT_VERIFY_MESSAGE");
        }

    }

    public void commonMyAddress(String element, String elementEdit) throws InterruptedException {
        keyword.openNewTab("https://dev3.glamira.com/glgb/customer/address/index/#");
        keyword.untilJqueryIsDone(50L);
//        keyword.click(element);
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        countAdd = keyword.countNumberOfElement("MAC_COUNT_ADDRESS");
        if (elementEdit != null) {
            keyword.untilJqueryIsDone(50L);
            keyword.scrollToPositionByScript("window.scrollBy(0,700)");
            keyword.untilJqueryIsDone(50L);
            keyword.click(elementEdit);
            keyword.untilJqueryIsDone(30L);
            keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        }
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
    }

    public void inpEditAddress(String label, String element, String btnEdit, String textStreet, boolean melissa) throws InterruptedException {
        commonMyAddress(element, btnEdit);
        keyword.clearText("MAC_INP_FIRST_NAME");
        keyword.sendKeys("MAC_INP_FIRST_NAME", "MAC_DATA_FIRST_NAME_STAGE");
        keyword.clearText("MAC_INP_LAST_NAME");
        keyword.sendKeys("MAC_INP_LAST_NAME", "MAC_DATA_LAST_NAME_STAGE");
        keyword.clearText("MAC_INP_COMPANY");
        keyword.sendKeys("MAC_INP_COMPANY", "COM_DATA_TITLE");
        keyword.clearText("MAC_INP_PHONE_NUM");
        keyword.sendKeys("MAC_INP_PHONE_NUM", "MAC_DATA_PHONE_NUM");
        keyword.clearText("MAC_INP_STREET");
        keyword.imWait(3);
        keyword.sendKeys("MAC_INP_STREET", textStreet);
        if (melissa) {
            Thread.sleep(1000);
            keyword.keysBoardWithDOWN("MAC_INP_STREET_DIV");
            keyword.untilJqueryIsDone(60L);
            keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
            Thread.sleep(1000);

        } else {
            keyword.clearText("MAC_INP_CITY");
            keyword.sendKeys("MAC_INP_CITY", "MAC_INP_DATA_CITY");
            keyword.keysBoardWithDOWN("MAC_INP_STATE");
            keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
            keyword.clearText("MAC_INP_CODE_CITY");
            keyword.sendKeys("MAC_INP_CODE_CITY", "MAC_INP_DATA_CODE_CITY");
        }
        keyword.click("MAC_BTN_SAVE_ADDRESS");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(30, "//div[@class='loading-mask']");
        keyword.untilJqueryIsDone(50L);
        keyword.untilJqueryIsDone(50L);
//        keyword.verifyElementVisible("CUS_VERIFY_NEWSLETTER_SUBSCRIBE");
        keyword.assertEquals("MAC_VERIFY_DATA_ADDRESS", "CUS_VERIFY_NEWSLETTER_SUBSCRIBE");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        boolean check;
        String street = PropertiesFile.getPropValue(textStreet);
        String textBilling = keyword.getText("MAC_VERIFY_SETAS_BILLING_ADDRESS");
        System.out.printf("a===" + textBilling + "\n");
        System.out.printf("s===" + street + "\n");
        switch (label) {
            case "billing":
                if (keyword.getText("MAC_VERIFY_SETAS_BILLING_ADDRESS").contains(street)) {

                    check = true;
                } else {
                    check = false;
                }
                logger.info("check verify edit billing address...");
                Assert.assertEquals(check, true);
                break;
            case "shipping":
                if (keyword.getText("MAC_VERIFY_SETAS_SHIPPING_ADDRESS").contains(street)) {
                    check = true;
                } else {
                    check = false;
                }
                logger.info("check verify edit shipping address...");
                Assert.assertEquals(check, true);
                break;
            case "add":
                int count = keyword.countNumberOfElement("MAC_COUNT_ADDRESS");
                System.out.printf("======count: " + countAdd + "\n");
                System.out.printf("======count b: " + count + "\n");
                if (countAdd + 1 == count) {
                    check = true;
                } else {
                    check = false;
                }
                logger.info("check add...");
                keyword.untilJqueryIsDone(50L);
                Assert.assertEquals(check, true);
                keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
                break;
            case "edit":
                String textEdit = keyword.getText("MAC_VERIFY_EDIT_ENTRIES");
                System.out.printf("n== " + textEdit + "\n");
                System.out.printf("== " + PropertiesFile.getPropValue("MAC_DATA_STREET3") + "\n");
                if (textEdit.contains(street)) {
                    check = true;
                } else {
                    check = false;
                }
                logger.info("check edit Additional Address Entries...");
                Assert.assertEquals(check, true);

                break;

            default:
                logger.info("NULL...");
                break;

        }

    }

    public void deleteAdditionalAddressEntries() throws InterruptedException {
//        keyword.openNewTab("https://dev3.glamira.com/glde/customer/address/index/#");
//        keyword.click("MAC_MY_ADDRESS_DIRECTORY");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        boolean check;
        int countAddress = keyword.countNumberOfElement("MAC_COUNT_ADDRESS");
        System.out.printf("a===" + countAddress + "\n");
        keyword.click("MAC_LINKTEXT_DELETE");
        keyword.untilJqueryIsDone(60L);
        keyword.click("MAC_BTN_DELETE_OK");
        keyword.untilJqueryIsDone(60L);
        keyword.untilJqueryIsDone(60L);
        if (keyword.verifyElementVisible("CUS_VERIFY_NEWSLETTER_SUBSCRIBE")) {
            keyword.assertEquals("MAC_VERIFY_DATA_DELETE_ADDRESS", "CUS_VERIFY_NEWSLETTER_SUBSCRIBE");
        }
        int countAddressEdit = keyword.countNumberOfElement("MAC_COUNT_ADDRESS");
        System.out.printf("b===" + countAddressEdit + "\n");
        if (countAddress == countAddressEdit + 1) {
            check = true;
        } else {
            check = false;
        }
        logger.info("check delete...");
        keyword.untilJqueryIsDone(50L);
        Assert.assertEquals(check, true);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");

    }

    public void saveItemFormProductView() throws InterruptedException {
//        setUp();
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        keyword.navigateToUrl("https://dev3.glamira.com/glgb/catalog/product_compare/index/");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        keyword.navigateToUrl("https://dev3.glamira.com/glgb/glamira-ring-mutia.html?alloy=yellow_white-750&stone1=diamond-Brillant&stone2=diamond-Brillant");
        keyword.untilJqueryIsDone(50L);
        myAccount.commonWishList("MAC_BTN_HEART");

    }

    public void saveItemFormProductList() throws InterruptedException {
        keyword.navigateToUrl("https://dev3.glamira.com/glgb/diamond-rings/diamond/");
        myAccount.commonWishList("MAC_ICON_HEART");
    }

    public void commonViewWishList() throws InterruptedException {
//        keyword.reLoadPage();
        keyword.untilJqueryIsDone(50L);
        keyword.untilJqueryIsDone(50L);
        keyword.scrollDownToElement("MAC_LINK_HEART_PHONE");
        keyword.untilJqueryIsDone(50L);
        keyword.click("MAC_LINK_HEART_PHONE");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(50, "//div[@class='loading-mask']");
        keyword.untilJqueryIsDone(50L);
        keyword.untilJqueryIsDone(50L);
        Thread.sleep(2000);
        keyword.scrollDownToElement("MAC_BTN_VIEW_WISHLIST");
        keyword.click("MAC_BTN_VIEW_WISHLIST");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
    }

    public void compareMyWishProduct() throws InterruptedException {
        boolean check;
        keyword.navigateToUrl("https://dev3.glamira.com/glgb/diamond-rings/diamond/");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        Thread.sleep(2000);
        keyword.click("MAC_WISHLIST_ICON_HEART");
        String textTitle = keyword.getText("MAC_WISHLIST_GET_TITLE");
        System.out.printf("a==== " + textTitle + "\n");
        commonViewWishList();
        keyword.untilJqueryIsDone(50L);
        String textTitleComp = keyword.getText("MAC_WISHLIST_GET_TITLE_COMPARE");
        System.out.printf("s====" + textTitleComp + "\n");
        textTitle.equalsIgnoreCase(textTitleComp);
    }

    public void checkVerifyAdmin() throws InterruptedException {
        signInPage.openNewTabs();
        signInPage.loginAdmin("LOGIN_DATA_USER_NAME", "BE_ADMIN_PASSWORD");
        keyword.untilJqueryIsDone(30L);
        keyword.maximizeWindow();
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        signInPage.chooseItemCustomer("LOGIN_BTN_CUSTOMER", "LOGIN_BTN_CUSTOMER",
                "SIGNUP_VERIFY_CUSTOMER", "LOGIN_BTN_EMAIL_LOG",
                "SIGNUP_VERIFY_EMAIL_LOG");
        adminChooseEmailLog("EMAIL_ADDRESS");
        keyword.resizeBrowser(319, 848);
    }

    public void adminChooseEmailLog(String text) throws InterruptedException {

//        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        keyword.untilJqueryIsDone(30L);
        keyword.webDriverWaitForElementPresent("ADMIN_CUS_EMAILLOG_BTN_FILTER", 20);
        keyword.untilJqueryIsDone(50L);
        Thread.sleep(2000);
        keyword.scrollDownToElement("ADMIN_CUS_EMAILLOG_BTN_FILTER");
        keyword.click("ADMIN_CUS_EMAILLOG_BTN_FILTER");
        keyword.untilJqueryIsDone(30L);
        keyword.clearText("ADMIN_CUS_EMAILLOG_FILTER_INP_RECIPIENT");
        keyword.sendKeys("ADMIN_CUS_EMAILLOG_FILTER_INP_RECIPIENT", text);
        keyword.untilJqueryIsDone(30L);
        keyword.click("ADMIN_CUS_EMAILLOG_ENTER_FILTER");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        keyword.assertEquals(text, "ADMIN_CUS_EMAILLOG_TEXT_RECIPIENT");
        keyword.assertEquals("ADMIN_CUS_DATA_EMAILLOG_TEXT_RECIPIENT_TEMP", "ADMIN_CUS_EMAILLOG_TEXT_RECIPIENT_TEMP");
        keyword.untilJqueryIsDone(30L);
    }

    public void emailSelectItem() throws InterruptedException {
//        setUp();
        commonViewWishList();
        keyword.click("MAC_WISHLIST_EMAIL_BTN");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        keyword.sendKeys("MAC_WISHLIST_EMAIL_INP_NAME", "COM_INP_DATA_NAME");
        keyword.sendKeys("MAC_WISHLIST_EMAIL_INP_MAIL", "COM_INP_DATA_EMAIL4");
        keyword.sendKeys("MAC_WISHLIST_EMAIL_INP_REMAIL", "EMAIL_ADDRESS");
        keyword.sendKeys("MAC_WISHLIST_EMAIL_INP_MESSAGE", "COM_DATA_TITLE");
        keyword.click("MAC_WISHLIST_EMAIL_CHECKBOX_SUB");
        keyword.click("MAC_WISHLIST_EMAIL_BTN_SUBMIT");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        if (keyword.verifyElementVisible("CUS_VERIFY_NEWSLETTER_SUBSCRIBE")) {
            keyword.assertEquals("MAC_VERIFY_DATA_WISHLIST_EMAIL", "CUS_VERIFY_NEWSLETTER_SUBSCRIBE");
        }
        checkVerifyAdmin();
        keyword.closeWindowByIndex(1);
        keyword.switchToTab(0);
    }

    public void viewOrder(String textBefore, String btnView, String textAfter, String btnShow) throws InterruptedException {
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        keyword.untilJqueryIsDone(50L);
        String textID = keyword.getText(textBefore);
        System.out.printf("a======= " + textID + "\n");
        keyword.untilJqueryIsDone(50L);
        keyword.scrollToPositionByScript("window.scrollBy(0,300)");
        keyword.untilJqueryIsDone(50L);
        keyword.click(btnShow);
        keyword.untilJqueryIsDone(50L);
        keyword.click(btnView);
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        String textIDComp = keyword.getText(textAfter);
        System.out.printf("b======= " + textIDComp + "\n");
        logger.info("check verify veiw my order....");
        Assert.assertEquals(textIDComp, textID);

    }

    public void viewOrderComplete() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.deleteAllCookies();
        keyword.reLoadPage();
        keyword.untilJqueryIsDone(50L);
        setUp1();
        keyword.navigateToUrl("https://dev3.glamira.com/glgb/sales/order/history/");
        keyword.untilJqueryIsDone(60L);
        keyword.click("MAC_MY_ORD_BTN_COMPLETE");
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        viewOrder("MAC_MY_ORD_TEXT_ID_COMPLETE", "MAC_MY_ORD_BTN_VIEW_COMPLETE", "MAC_MY_ORD_VERIFY_TEXT_ID_COMPLETE", "BTN_MORE_SHOW");
    }

    public void loginAdmin() throws InterruptedException {
        signInPage.openNewTabs();
        keyword.deleteAllCookies();
        keyword.reLoadPage();
        keyword.untilJqueryIsDone(50L);
        keyword.untilJqueryIsDone(50L);
        signInPage.loginAdmin("LOGIN_DATA_USER_NAME", "BE_ADMIN_PASSWORD");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        keyword.maximizeWindow();
    }

    public void viewReturn() throws InterruptedException {
        loginAdmin();
        keyword.click("LOGIN_ADMIN_BTN_LOGISTIC");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        keyword.click("LOGIN_ADMIN_BTN_LOGISTIC_ITEM");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        keyword.selectDropDownListByName("LOGIN_ADMIN_BTN_LOGISTIC_ITEM_SELECT_PAGE", "200");
        keyword.pressEnter();
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(30, "//div[@class='loading-mask']");
        searchElement();
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        keyword.click("LOGIN_ADMIN_BTN_LOGISTIC_ITEM_VIEW_ORDER2");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        keyword.switchToTab(2);
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        keyword.click("LOGIN_ADMIN_BTN_LOGISTIC_LOGIN_CUS");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        //login as customer
        keyword.selectDropDownListByName("LOGIN_ADMIN_BTN_LOGISTIC_LOGIN_CUS_UK", "GLAMIRA.co.uk");
        keyword.pressEnter();
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        keyword.click("LOGIN_ADMIN_BTN_LOGISTIC_LOGIN_CUS_OK");
        // go to My Return
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        keyword.switchToTab(3);
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        keyword.click("MAC_MY_ORD_BTN_COMPLETE");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(50, "//div[@class='loading-mask']");
        keyword.click("MAC_MY_ORD_BTN_RETURN");
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        keyword.verifyElementVisible("MAC_MY_ORD_VERIFY_RETURN");
    }

    public void searchElement() throws InterruptedException {
        while (true) {
            keyword.untilJqueryIsDone(50L);
            Thread.sleep(3000);
            boolean check = keyword.verifyElementVisible("LOGIN_ADMIN_BTN_LOGISTIC_ITEM_VIEW_ORDER2");
            logger.info(String.valueOf(check));
            if (check) {
                return;
            } else {
                keyword.click("LOGIN_ADMIN_BTN_LOGISTIC_ITEM_BTN_NEXT_PAGE");
                keyword.untilJqueryIsDone(60L);
                keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");

            }
        }
    }


    public void stepReturn() throws InterruptedException {
        viewReturn();
        boolean check;
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        String s = keyword.getText("MAC_MY_ORD_VERIFY_RETURN_GET_ID_ORDER");
        String id = s.substring(1, s.length());
        System.out.printf("ID : " + id + "\n");
        if (id.equalsIgnoreCase(PropertiesFile.getPropValue("KEY_ID_ORDER"))) {
            logger.info("Failed by id:" + id);
            check = false;
        } else {
            //PropertiesFile.serPropValue("KEY_ID_ORDER",id);
            check = true;
        }

        //create new return
        if (check) {
            keyword.untilJqueryIsDone(60L);
            keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
            keyword.click("MAC_MY_ORD_RETURN_STEP1_CHECKBOX1");
            keyword.keysBoardWithDOWN("MAC_MY_ORD_RETURN_STEP1_SELECT1");
            keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
            keyword.click("MAC_MY_ORD_RETURN_STEP1_CHECKBOX2");
            keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
            keyword.click("MAC_MY_ORD_RETURN_STEP1_SELECT2");
            keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
            keyword.doubleClick("MAC_MY_ORD_RETURN_STEP1_SELECT2_OPTION");
            keyword.untilJqueryIsDone(60L);
            keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
            keyword.doubleClick("//div[@class='column main']");
            keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
            keyword.scrollDownToElement("MAC_MY_ORD_RETURN_STEP2");
            keyword.doubleClick("MAC_MY_ORD_RETURN_STEP2");
            keyword.untilJqueryIsDone(60L);
            keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
            keyword.click("MAC_MY_ORD_RETURN_STEP2_CHECKBOX");
            keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
            keyword.click("MAC_MY_ORD_RETURN_STEP3");
            keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
            keyword.click("MAC_MY_ORD_RETURN_SUBMIT");
            logger.info("done");
            keyword.untilJqueryIsDone(60L);
            keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");

            keyword.verifyElementVisible("MAC_MY_ORD_RETURN_SUCCESS");
            PropertiesFile.serPropValue("KEY_ID_ORDER", id);
        } else {
            Assert.assertTrue(false);
        }
    }
    public void checkStatus(String status, String verifyId, String verifyIcon, String verifyText, String dataId, String dataText) throws InterruptedException {
        switch (status) {
            case "confirmation":
                logger.info("check verify id order....");
                keyword.untilJqueryIsDone(50L);
                keyword.untilJqueryIsDone(50L);
                keyword.assertEquals(dataId, verifyId);
                logger.info("check verify status....");
                keyword.assertEquals(dataText, verifyText);
                keyword.verifyElementVisible(verifyIcon);
                break;
            case "delivery":
                keyword.untilJqueryIsDone(60L);
                keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
                keyword.click("MAC_OVER_BTN_COMPLETE");
                logger.info("check verify id order....");
                keyword.untilJqueryIsDone(60L);
                keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
                keyword.assertEquals(dataId, verifyId);
                logger.info("check verify status....");
                keyword.assertEquals(dataText, verifyText);
                keyword.verifyElementVisible(verifyIcon);
                break;

        }

    }

    public void checkStatusConfirmation() throws InterruptedException {
        keyword.resizeBrowser(319, 848);
        keyword.deleteAllCookies();
        keyword.reLoadPage();
        keyword.untilJqueryIsDone(50L);
        setUp3();
        keyword.openNewTab("https://dev3.glamira.com/glgb/sales/order/history/");
        keyword.click("BTN_UPLOAD_MORE");
        keyword.untilJqueryIsDone(50L);
        checkStatus("confirmation", "MAC_OVER_ID_ORDER_STATUS_CONFIR", "MAC_OVER_STATUS_CONFIR_ICON",
                "MAC_OVER_STATUS_CONFIR", "MAC_OVER_DATA_ID_ORDER_STATUS_CONFIR", "MAC_OVER_DATA_STATUS_CONFIR");
    }

    public void setUp3() throws InterruptedException {
        objRegister = new RegisterPage(this.keyword);
        objRegister.acceptAllCookies();
        keyword.untilJqueryIsDone(50L);
        keyword.untilJqueryIsDone(50L);
        keyword.sendKeys("SIGNIN_EMAIL_LOG", "COM_INP_DATA_EMAIL_TEST");
        Thread.sleep(1000);
        keyword.sendKeys("SIGN_INPUT_PASSWORD", "COM_INP_DATA_PASS");
        Thread.sleep(1000);
        keyword.click("LOGIN_BTN_SUBMITLOGIN");
        keyword.waitForElementNotVisible(20, "//div[@class='loading-mask']");
    }

    public void checkFunctionInfoCustomer(String element, String verify, String data) throws InterruptedException {
        boolean check;
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(50, "//div[@class='loading-mask']");
        keyword.scrollToPositionByScript("window.scrollBy(0,500)");
        keyword.click(element);
        keyword.untilJqueryIsDone(60L);
        keyword.waitForElementNotVisible(10, "//div[@class='loading-mask']");
        System.out.printf("getText: " + keyword.getText(verify) + "\n");
        System.out.printf("getData: " + PropertiesFile.getPropValue(data) + "\n");
        keyword.untilJqueryIsDone(50L);
        if (keyword.getText(verify).contains(PropertiesFile.getPropValue(data))) {
            check = true;
        } else {
            check = false;
        }
        logger.info("check verify My overview....");

        Assert.assertEquals(check, true);
    }

    public void checkChangePassword() throws InterruptedException {
//        setUp2();
        keyword.navigateToUrl("https://dev3.glamira.com/glgb/customer/account/");
        checkFunctionInfoCustomer("MAC_OVER_LINK_CHANGE_PASS", "MAC_OVER_VERIFY_GET_CHANGE_PASS", "MAC_OVER_VERIFY_DATA_CHANGE_PASS");
    }
}

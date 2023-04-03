package page;

import core.BasePage;
import core.LogHelper;
import io.cucumber.java.hr.Kad;
import org.bouncycastle.asn1.cms.KEKIdentifier;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.testng.Assert;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;
import org.openqa.selenium.Keys;

public class MyReturnPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    public SignInPage signInPage;
    public RegisterPage objRegister;
    public SignInPage objSignIn;

    public MyReturnPage() {
        super();
        objRegister = new RegisterPage(this.keyword);
        objSignIn = new SignInPage(this.keyword);
    }

    public void goToFormLoginReturn() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
        keyword.untilJqueryIsDone(50L);
        keyword.click("LOGIN_RETURN_FORM_BTN_RETURN");
        keyword.untilJqueryIsDone(50L);
        keyword.untilJqueryIsDone(50L);
        keyword.verifyElementVisible("MENU_LEFT_RETURN_FORM");
        keyword.click("BTN_RETURN_FORM");
    }

    public void dataFormLoginReturnForm(String dataEmail, String dataPassword, boolean check, String data, String actual,String dataSelect) throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.reLoadPage();
        keyword.untilJqueryIsDone(50L);
        keyword.sendKeys("INPUT_EMAIL_FORM", dataEmail);
        keyword.click("BTN_SUBMIT_RETURN_FORM");
        keyword.untilJqueryIsDone(50L);
        if (check) {
            keyword.assertEquals(data, actual);
        } else {
            keyword.untilJqueryIsDone(50L);
            keyword.verifyElementVisible("SIGNUP_PASSWORD_INFORMATION");
            keyword.untilJqueryIsDone(20L);
            keyword.sendKeys("SIGNUP_PASSWORD_INFORMATION", dataPassword);
            keyword.click("BTN_SUBMIT_RETURN_FORM");
            keyword.untilJqueryIsDone(50L);
            if (keyword.verifyElementPresent("BTN_CREATE_RETURN")) {
                keyword.click("SELECT_ORDER_RETURN");
                keyword.click(dataSelect);
                keyword.untilJqueryIsDone(30L);
                String getTextBefore = keyword.getText("SELECT_ORDER_RETURN");
                System.out.println("-------------------" + getTextBefore);

                keyword.click("BTN_CREATE_RETURN");
                keyword.untilJqueryIsDone(50L);
                getTextBefore.contains("ORDER_ID_RETURN");
            }
            keyword.assertEquals(data, actual);
        }
    }
    public void returnSuccess() throws InterruptedException {
        orderReturn("DATA_EMAIL_RETURN2", "DATA_PASSWORD_LOGIN_RETURN", "OPTION_RESIZE", "CHECK_WITHDRAWAL","SELECT_OPTION_ORDER_ITEM_RETURN_NO_RESIZE");
    }

    public void orderReturn(String dataEmail, String dataPassWord, String checkShow, String selectElement, String dataSelect) throws InterruptedException {
        keyword.reLoadPage();
        keyword.deleteAllCookies();
        keyword.untilJqueryIsDone(30L);
        keyword.deleteAllCookies();
        keyword.reLoadPage();
        keyword.untilJqueryIsDone(50L);
        objRegister.acceptAllCookies();
        keyword.untilJqueryIsDone(30L);
        if (keyword.verifyElementPresent("CHECK_FORM_LOGIN")) {
            keyword.untilJqueryIsDone(50L);
            keyword.click("BTN_CLOSE_MODAL_LOGIN");
        }
        goToFormLoginReturn();
        dataFormLoginReturnForm(dataEmail, dataPassWord, false, "DATA_LABLE", "STEP_LABLE",dataSelect);
        checkShowTitle(checkShow, selectElement);
    }

    public void checkShowTitle(String checkShow, String selectElement) throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.click("MAC_MY_ORD_RETURN_STEP1_SELECT1");
        keyword.untilJqueryIsDone(30L);
        keyword.waitForElementNotVisible(30, checkShow);
        keyword.untilJqueryIsDone(30L);
        selectStep(selectElement);
        keyword.untilJqueryIsDone(50L);
        cancelOrderReturn();
    }

    public void selectStep(String selectElement) throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.click("MAC_MY_ORD_RETURN_STEP1_CHECKBOX1");
        keyword.untilJqueryIsDone(30L);
        keyword.click("MAC_MY_ORD_RETURN_STEP1_SELECT1");
        keyword.untilJqueryIsDone(30L);
        keyword.click(selectElement);
        keyword.untilJqueryIsDone(20L);
        keyword.click("SELECT_ITEM_RESIZE");
        if (keyword.verifyElementPresent("MAC_MY_ORD_RETURN_STEP1_SELECT2")) {
            keyword.untilJqueryIsDone(30L);
            keyword.click("MAC_MY_ORD_RETURN_STEP1_SELECT2");
            keyword.untilJqueryIsDone(30L);
            keyword.click("SELECT_SIZE_RETURN");
        } else {
            keyword.untilJqueryIsDone(50L);
            keyword.click("SELECT_REASON_ORDER_RETURN");
            keyword.untilJqueryIsDone(30L);
            keyword.click("ITEM_SELECT_REASON");
            keyword.untilJqueryIsDone(50L);
            getCodeReturn();
            keyword.untilJqueryIsDone(50L);
            keyword.click("SELECT_METHOD_PAYMENT");
            keyword.untilJqueryIsDone(50L);
            keyword.click("SELECT_METHOD_OPTION");
        }
//        STEP 2 / 3
        keyword.untilJqueryIsDone(50L);
        keyword.scrollDownToElement("CHOSE_SHIPPING");
        keyword.click("CHOSE_SHIPPING");
        //        STEP3 / 3
        keyword.untilJqueryIsDone(30L);
        keyword.click("MAC_MY_ORD_RETURN_STEP3");
        keyword.untilJqueryIsDone(30L);
        keyword.click("MAC_MY_ORD_RETURN_SUBMIT");
        keyword.untilJqueryIsDone(50L);
        keyword.assertEquals("MESSAGE_RETURNSUCCESS", "INPUT_MESSAGE_SUCCESS");
    }

    public void cancelOrderReturn() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.click("CLICK_LINK_HEAR");
        keyword.untilJqueryIsDone(30L);
        keyword.click("BTN_CANCEL_MY_RETURN");
        keyword.untilJqueryIsDone(30L);
        keyword.click("BTN_OK_CANCEL");
        keyword.untilJqueryIsDone(50L);
        keyword.assertEquals("MESSAGE_CANCEL_SUCCESS", "SIGNUP_CODE_RESEND");
//        keyword.assertEquals("DATA_CANCEL","BTN_NOTE_CANCEL");
    }

    public void getCodeReturn() throws InterruptedException {
        String getOrderId = keyword.numberOnly("ORDER_NUMBER");
        System.out.println("-----------------------------" + getOrderId);
        keyword.untilJqueryIsDone(50L);
        objSignIn.openTabBE("ADMIN_URL");
        keyword.deleteAllCookies();
        keyword.deleteAllCookies();
        keyword.reLoadPage();
        objSignIn.loginAdmin(
                "LOGIN_DATA_USER_NAME",
                "LOGIN_DATA_PASS_WORD");
        keyword.untilJqueryIsDone(30L);
        if(keyword.verifyElementPresent("CHECK_SHOW_INCOMING_MODAL_BE")){
            keyword.click("CLOSE_BTN_INCOMING");
        }
        objSignIn.chooseItemCustomer(
                "ITEM_INVENTORY",
                "ITEM_INVENTORY",
                "ITEM_INSTOCK_REQUEST",
                "ITEM_INSTOCK_REQUEST",
                "FOEM_INSTOCK"
        );
        keyword.untilJqueryIsDone(70L);
        Thread.sleep(2000);
        keyword.sendKeys("SEARCH_ORDER_ID", getOrderId + "\n");
        keyword.untilJqueryIsDone(50L);
        String getCode = keyword.getText("GET_CODE_RETURN");
        keyword.closeTab(1);
        keyword.switchToTab(0);
        keyword.untilJqueryIsDone(50L);
        keyword.sendKeys("INPUT_SEND_CODE_RETURN", getCode);
    }

}

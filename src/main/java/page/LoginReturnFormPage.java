package page;

import core.BasePage;
import core.LogHelper;
import io.cucumber.java.hr.Kad;
import org.bouncycastle.asn1.cms.KEKIdentifier;
import org.slf4j.Logger;
import org.testng.Assert;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;

public class LoginReturnFormPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    public SignInPage signInPage;
    public RegisterPage objRegister;

    public LoginReturnFormPage() {
        super();
        objRegister = new RegisterPage(this.keyword);
    }

    public void goToFormLoginReturn() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
        keyword.click("LOGIN_RETURN_FORM_BTN_RETURN");
        keyword.untilJqueryIsDone(50L);
        keyword.untilJqueryIsDone(50L);
        keyword.verifyElementVisible("MENU_LEFT_RETURN_FORM");
        keyword.click("BTN_RETURN_FORM");
    }

    public void dataFormLoginReturnForm(String dataEmail, String dataPassword, boolean check, String data, String actual) throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.reLoadPage();
        keyword.untilJqueryIsDone(50L);
        keyword.sendKeys("INPUT_EMAIL_FORM", "  ");
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
                String getTextBefore = keyword.getText("SELECT_ORDER_RETURN");
                System.out.println("-------------------" + getTextBefore);
                keyword.click("BTN_CREATE_RETURN");
                keyword.untilJqueryIsDone(50L);
                getTextBefore.contains("ORDER_ID_RETURN");
            }
            keyword.assertEquals(data, actual);
        }
    }

    public void orderDate(String dataEmail, String dataPassWord, String checkShow, String selectElement) throws InterruptedException {
        keyword.reLoadPage();
        keyword.deleteAllCookies();
        keyword.untilJqueryIsDone(30L);
        keyword.deleteAllCookies();
        keyword.untilJqueryIsDone(50L);
        objRegister.acceptAllCookies();
        goToFormLoginReturn();
        dataFormLoginReturnForm(dataEmail, dataPassWord, false, "DATA_LABLE", "STEP_LABLE");
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
        if (keyword.verifyElementPresent("SELECT_ITEM_RESIZE")) {
            keyword.click("SELECT_ITEM_RESIZE");
            keyword.untilJqueryIsDone(30L);
            keyword.click("MAC_MY_ORD_RETURN_STEP1_SELECT2");
            keyword.untilJqueryIsDone(30L);
            keyword.click("SELECT_SIZE_RETURN");
        } else {

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
}

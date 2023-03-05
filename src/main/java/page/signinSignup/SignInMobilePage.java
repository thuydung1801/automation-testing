package page.signinSignup;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import org.slf4j.Logger;
import page.MyAccountPage;
import page.home.LoginPage;
import page.home.RegisterPage;

import java.util.Date;

public class SignInMobilePage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private SignInPage objSignIn;
    private SignUpPage objSignUp;
    private RegisterPage objRegist;

    public SignInMobilePage() {
        super();
    }

    public SignInMobilePage(KeywordWeb key) {
        super(key);
        objSignIn = new SignInPage(this.keyword);
        objSignUp = new SignUpPage(this.keyword);
        objRegist = new RegisterPage(this.keyword);
    }

    public void checkGoToFormLoginWithEmail() throws InterruptedException {

        keyword.untilJqueryIsDone(50L);
        keyword.scrollDownToElement("MOBILE_HAMBURGER");
        keyword.click("MOBILE_HAMBURGER");
        keyword.untilJqueryIsDone(50L);
        keyword.click("MOBILE_ICON_SIGNIN");
        keyword.untilJqueryIsDone(50L);
        objSignIn.inputBlankAndVerify("SIGNIN_XPATH_EMAIL_REQUIRED_FIELD",
                "SIGNIN_MESSAGE_REQUIRED_FIELD", "SIGNIN_MESSAGE_REQUIRED_FIELD");
    }

    public void resentTheCodeToEmail() throws Exception {
        keyword.clearText("SIGNIN_INPUT_ENTER_CODE");
        objSignIn.openNewTabs();
        objSignIn.loginAdmin("LOGIN_DATA_USER_NAME", "LOGIN_DATA_PASS_WORD");
        keyword.maximizeWindow();
        keyword.untilJqueryIsDone(50L);
        objSignIn.chooseItemCustomer("LOGIN_BTN_CUSTOMER", "LOGIN_BTN_CUSTOMER", "SIGNUP_VERIFY_CUSTOMER",
                "LOGIN_BTN_EMAIL_LOG", "SIGNUP_VERIFY_EMAIL_LOG"
        );
        objSignIn.selectActionEmailLog("LOGIN_CHECK_EMAIL_LOG_ACTION_SELECT", "LOGIN_SELECT_ACTIVE",
                "LOGIN_SELECT_VIEW_CHECK_EMAIL_LOG", "LOGIN_POPUP_MESSAGE_PASSWORD_RESET"
        );
        objSignIn.getCodeEnterTextInField("LOGIN_IFRAME_DEV3", "LOGIN_INPUT_VERIFY_CODE",
                "SIGNIN_INPUT_ENTER_CODE", "SIGNIN_BTN_SUBMIT_SEND_CODE");
        keyword.resizeBrowser(319, 848);
        keyword.sendKeys("SIGNIN_INPUT_CREATE_NEW_PASSWORD", "SIGNIN_DATA_SEND_KEY");
        keyword.untilJqueryIsDone(70L);
        objSignUp.confirmPasswordEntryCondition("SIGNUP_MESSAGE_PASSWORD_FAIL01",
                "SIGNIN_MESSAGE_CREATE_NEW_PW", "SIGNUP_ACTUAL_MESSAGE04", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_NUMBER",
                "SIGNUP_ACTUAL_MESSAGE_AT_LAST_LOWER", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_UPPER", "SIGNUP_MESSAGE_ERROR_CHARACTERS_LIKE",
                "SIGNUP_ACTUAL_MESSAGE04"
        );
    }

    public void createNewPasswordWithInvalidPhone() throws InterruptedException {
        objSignUp.clearTextAndSendKey("SIGNIN_INPUT_PHONE_ENTER", "SIGNIN_INPUT_PHONE_ENTER", "SIGNIN_PHONE_CHINA");
        keyword.click("SIGNIN_CLICK_FORM");
        keyword.untilJqueryIsDone(10L);
        keyword.click("LOGIN_BTN_SUBMIT_FORGOT_PASSWORD");
        keyword.untilJqueryIsDone(10L);
        objSignIn.openNewTabs();
        keyword.maximizeWindow();
        keyword.deleteAllCookies();
        keyword.reLoadPage();
        keyword.untilJqueryIsDone(50L);
        objSignIn.loginAdmin(
                "LOGIN_DATA_USER_NAME",
                "LOGIN_DATA_PASS_WORD");
        keyword.untilJqueryIsDone(30L);
        objSignIn.chooseItemCustomer(
                "SIGNUP_STORES_ITEM", "SIGNUP_STORES_ITEM",
                "LOGIN_FORM_CUSTOMER", "SIGNUP_ELEMENT_SMS_LOG", "SIGNUP_VERIFY_SMS"
        );
//        objSignUp.filterSort(
//                "SIGNUP_BTN_FILTER", "SIGNUP_VERIFY_ELEMENT_FILTER",
//                "SIGNIN_PHONE_CHINA", "SIGNUP_BUTTON_APPLY_FILTERS"
//        );
//        Thread.sleep(12000);
        keyword.untilJqueryIsDone(50L);
        objSignUp.getCodeAndSendKey("SIGNIN_INPUT_ENTER_CODE", "SIGNIN_BTN_SUBMIT_SEND_CODE"
        );
        keyword.resizeBrowser(319, 848);
        keyword.untilJqueryIsDone(50L);
        keyword.sendKeys("SIGNIN_INPUT_CREATE_NEW_PASSWORD", "SIGNIN_DATA_SEND_KEY");
        keyword.untilJqueryIsDone(30L);
        objSignUp.confirmPasswordEntryConditionWithChinese(
                "SIGNIN_MESSAGE_CREATE_NEW_PW", "SIGNUP_ACTUAL_MESSAGE04", "SIGNUP_ACTUAL_MESSAGE_CHINA",
                "SIGNUP_ACTUAL_MESSAGE_CHINA1", "SIGNUP_ACTUAL_MESSAGE_CHINA2", "SIGNUP_ACTUAL_MESSAGE_CHINA3",
                "SIGNUP_ACTUAL_MESSAGE04"
        );
    }

    public void checkGoToFormLoginWithPhone() throws InterruptedException {
        keyword.deleteAllCookies();
        keyword.navigateToUrl("https://dev3.glamira.com/glcn/");
        keyword.untilJqueryIsDone(50L);
        keyword.untilJqueryIsDone(50L);
        keyword.scrollDownToElement("MOBILE_HAMBURGER");
        keyword.click("MOBILE_HAMBURGER");
        keyword.untilJqueryIsDone(50L);
        keyword.click("MOBILE_ICON_SIGNIN");
        keyword.untilJqueryIsDone(50L);
        objRegist.chooseLanguages();
//        keyword.untilJqueryIsDone(50L);
        Thread.sleep(2000);
        keyword.click("SIGNIN_TAB_LOGIN_IN_WITH_PHONE");
        keyword.untilJqueryIsDone(10L);
        objSignIn.inputBlankAndVerify("SIGNIN_MESSAGE_FAIL_WITH_MOBILE", "必填项。", "必填项。");
    }
}

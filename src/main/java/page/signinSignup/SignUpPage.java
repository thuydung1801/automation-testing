package page.signinSignup;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import io.cucumber.java.sl.In;
import org.slf4j.Logger;

import java.security.PublicKey;

public class SignUpPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private SignUpPage objSignUp;
    private SignInPage objSignIn;

    public SignUpPage(KeywordWeb key) {
        super(key);
    }

    public void nextUrl() throws InterruptedException {
        keyword.navigateToUrl("https://dev3.glamira.com/glus/");
    }

    public void goToFormCreateMyAccount() throws InterruptedException {
        keyword.click("LOGIN_BTN_LOGIN");
        keyword.webDriverWaitForElementPresent("LOGIN_BTN_FORGOT_PASSWORD", 20);
        Thread.sleep(2000);
        keyword.click("SIGNUP_BTN_CREATE_MY_ACCOUNT");
        if (keyword.verifyElementPresent("SIGNUP_WITH_PHONE")) {
            keyword.webDriverWaitForElementPresent("SIGNUP_WITH_PHONE", 20);
        } else {
            keyword.webDriverWaitForElementPresent("SIGNUP_FORM_DATA_INFORMATION", 20);
        }
    }
//    Create new customer and input email exist on database OR Create new customer and leave with blank form for required form with email
public void createCustomerWithEmail ()throws InterruptedException {
    sendKeyFullDataFormInformation("SIGNUP_DATA_FIRST_NAME_INFORMATION", "SIGNUP_DATA_LAST_NAME_INFORMATION"
            , "SIGNUP_EMAIL_EXIST", "SIGNUP_EMAIL_EXIST");
    keyword.click("SIGNUP_BTN_NEXT_STEEP");
    sendKeyFullDataFormPasswordInformation("SIGNUP_PASSWORD_INFORMATION", "LOGIN_NEW_PASSWORD",
            "SIGNUP_SELECT_TITLE", "SIGNUP_SELECT_OPTION_TITLE");
}
    // sendKey full data form information
    public void sendKeyFullDataFormInformation(String firstName, String lastName, String email, String emailConfirm) throws InterruptedException {
        keyword.sendKeys("SIGNUP_FIRST_NAME_INFORMATION", firstName);
        keyword.sendKeys("SIGNUP_LAST_NAME_INFORMATION", lastName);
        keyword.sendKeys("SIGNUP_EMAIL_INFORMATION", email);
        keyword.sendKeys("SIGNUP_EMAIL_CONFIRMATION_INFORMATION", emailConfirm);
    }

    public void clearTextAndSendKey(String clearText, String inputSendKey, String dataSendKey) throws InterruptedException {
        keyword.clearText(clearText);
        keyword.sendKeys(inputSendKey, dataSendKey);
    }

    //
    public void clearAndSendKeyEmail() throws InterruptedException {
        clearTextAndSendKey("SIGNUP_EMAIL_INFORMATION", "SIGNUP_EMAIL_INFORMATION", "SIGNUP_DATA_EMAIL_VALID");
        clearTextAndSendKey("SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_DATA_EMAIL_VALID");
        keyword.click("SIGNUP_BTN_NEXT_STEEP");
    }

    // sendKey full data form information (not click check box agree) ( form 2/3- pasWord)
    public void sendKeyFullDataFormPasswordInformation(String inputPassword, String password, String selectTitle, String selectOneOptionTitle) throws InterruptedException {
        keyword.sendKeys(inputPassword, password);
        keyword.click(selectTitle);
        keyword.checkStatusIsDisplay(selectOneOptionTitle);
        keyword.click(selectOneOptionTitle);
        keyword.click("SIGNUP_CHECKBOX_AGREE");
    }

    //assert Equals Message
    public void verifyMessageFail(String expected01, String actual01, String expected02, String actual02, String expected03, String actual03, String expected04, String actual04, String expected05, String actual05, String expected06, String actual06) throws InterruptedException {
        keyword.assertEquals(expected01, actual01);
        Thread.sleep(1000);
        keyword.assertEquals(expected02, actual02);
        Thread.sleep(1000);
        keyword.assertEquals(expected03, actual03);
        Thread.sleep(1000);
        keyword.assertEquals(expected04, actual04);
        Thread.sleep(1000);
        keyword.assertEquals(expected05, actual05);
        Thread.sleep(1000);
        keyword.assertEquals(expected06, actual06);
    }

    //    Create new customer and leave with email form for required form
    public void sendDataEmailAndConfirmEmail() throws InterruptedException {
        keyword.reLoadPage();
        keyword.imWait(10);
        keyword.sendKeys("SIGNUP_EMAIL_INFORMATION", "SIGNUP_DATA_EMAIL_INVALID");
        keyword.sendKeys("SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_DATA_EMAIL_CONFIRM_INVALID");
        keyword.click("SIGNUP_BTN_NEXT_STEEP");
    }

    //    Create new customer and input invalid data for email form
    public void invalidDataForEmailForm() throws InterruptedException {
        keyword.sendKeys("SIGNUP_FIRST_NAME_INFORMATION", "SIGNUP_DATA_FIRST_NAME_INFORMATION");
        keyword.sendKeys("SIGNUP_LAST_NAME_INFORMATION", "SIGNUP_DATA_LAST_NAME_INFORMATION");
        keyword.clearText("SIGNUP_EMAIL_INFORMATION");
        keyword.sendKeys("SIGNUP_EMAIL_INFORMATION", "SIGNUP_DATA_EMAIL_FAIL");
        keyword.click("SIGNUP_XPATH_FOR_FORM");
        keyword.assertEquals("SIGNUP_EMAIL_SHOW_MESSAGE", "TEXT_ERROR_EMAIL");
    }

    //    Enter full data and confirm email does not match
    public void confirmEmailNotMatch() throws InterruptedException {
        clearTextAndSendKey("SIGNUP_EMAIL_INFORMATION", "SIGNUP_EMAIL_INFORMATION", "SIGNUP_DATA_EMAIL_NEW_INFORMATION");
        clearTextAndSendKey("SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_DATA_EMAIL_CONFIRM_FAIL");
        keyword.click("SIGNUP_XPATH_FOR_FORM");
        keyword.assertEquals("SIGNUP_EMAIL_NOT_SAME", "SIGNUP_ADDRESS_EMAIL_ERROR");
    }

    //    Create new customer create password  There are 3  types of characters and < 8 characters
    public void inputValidPassWordAndCheckBoxSubscribe() throws InterruptedException {
        sendKeyFullDataFormPasswordInformation("SIGNUP_PASSWORD_INFORMATION", "SIGNUP_CREATE_PASSWORD_FAIL", "SIGNUP_SELECT_TITLE", "SIGNUP_SELECT_OPTION_TITLE");
        keyword.click("SIGNUP_BTN_CREATE_ACCOUNT");
//        verifyMessageFail("SIGNUP_MESSAGE_PASSWORD_FAIL01", "SIGNUP_ACTUAL_MESSAGE01", "SIGNUP_EXPECTED_MESSAGE_PASSWORD_01", "SIGNUP_ACTUAL_MESSAGE02");
    }

    //    @Test(priority = 6, description = "Create a new user with password >= 8 characters and < 3 character types")
    public void CreateUserWithPassword() throws InterruptedException {
        clearTextAndSendKey("SIGNUP_PASSWORD_INFORMATION", "SIGNUP_PASSWORD_INFORMATION", "SIGNUP_CREATE_PASSWORD_FAIL_01");
        keyword.click("SIGNUP_BTN_CREATE_ACCOUNT");
    }

    //   verify message  with password <8 characters and < 3 character types
    public void verifyMessageWithPasswordNotIllegal() throws InterruptedException {
//        verifyMessageFail("SIGNUP_MESSAGE_PASSWORD_FAIL01", "SIGNUP_ACTUAL_MESSAGE01", "SIGNUP_MESSAGE_PASSWORD_FAIL02", "SIGNUP_ACTUAL_MESSAGE03");
        Thread.sleep(1000);
        keyword.assertEquals("SIGNUP_EXPECTED_MESSAGE_PASSWORD_01", "SIGNUP_ACTUAL_MESSAGE02");
    }

    //    get code BE and Enter the wrong code sent to the email
    public void ConfirmAndProcessGetCodeWrong() throws InterruptedException {
        keyword.click("SIGNUP_BTN_CREATE_ACCOUNT");
        keyword.webDriverWaitForElementPresent("SIGNUP_INPUT_VERIFY_CODE", 20);
        keyword.sendKeys("SIGNUP_INPUT_VERIFY_CODE", "SIGNUP_CODE_DATA");
        keyword.click("SIGNUP_BTN_SUBMIT_ACCOUNT");
//        keyword.assertEquals("AAAA", "bbbb");
    }

    // resend and get the code back
    public void resendAndGetCodeBack() throws Exception {
        objSignIn = new SignInPage(this.keyword);
        keyword.clearText("SIGNUP_INPUT_VERIFY_CODE");
        Thread.sleep(59000);
        keyword.click("SIGNUP_BTN_RESEND_CODE");
//        keyword.assertEquals("SIGNUP_CODE_SENT","");
        objSignIn.openNewTabs();
        objSignIn.loginAdmin(
                "LOGIN_DATA_USER_NAME",
                "LOGIN_DATA_PASS_WORD");
        objSignIn.chooseItemCustomer(
                "LOGIN_BTN_CUSTOMER",
                "LOGIN_BTN_CUSTOMER",
                "SIGNUP_VERIFY_CUSTOMER",
                "LOGIN_BTN_EMAIL_LOG",
                "SIGNUP_VERIFY_EMAIL_LOG"
        );
        objSignIn.selectActionEmailLog("LOGIN_CHECK_EMAIL_LOG_ACTION_SELECT",
                "LOGIN_SELECT_ACTIVE",
                "LOGIN_SELECT_VIEW_CHECK_EMAIL_LOG",
                "LOGIN_POPUP_MESSAGE_PASSWORD_RESET");
        objSignIn.getCodeEnterTextInField("LOGIN_IFRAME",
                "LOGIN_INPUT_VERIFY_CODE",
                "SIGNUP_INPUT_VERIFY_CODE", "SIGNUP_BTN_SUBMIT_ACCOUNT");
        keyword.verifyElementPresent("SIGNUP_VERIFY_SIGNUP");

    }
//---------------------------------SIGN UP WITH OBILLE

    //    verify a required field.
    public void verifyRequiredFieldWithMobile() throws InterruptedException {
        keyword.click("SIGNUP_BTN_NEXT_STEEP");
//        verifyMessageFail("SIGNUP_DATA_VERIFY_MESSAGE", "SIGNUP_FIRSTNAME_ERROR", "SIGNUP_DATA_VERIFY_MESSAGE", "SIGNUP_LASTNAME_ERROR");
        Thread.sleep(1000);
        keyword.assertEquals("SIGNUP_DATA_VERIFY_MESSAGE", "SIGNUP_PHONE_ERROR");
    }

    //Create new customer and leave with blank form for required form
    public void enterDataSignUpWithMobile() throws InterruptedException {
        sendKeyFullDataFormInformation("SIGNUP_DATA_FIRST_NAME_INFORMATION", "SIGNUP_DATA_LAST_NAME_INFORMATION", "SIGNUP_EMAIL_EXIST", "SIGNUP_EMAIL_EXIST");
        keyword.sendKeys("SIGNUP_WITH_PHONE", "SIGNUP_DATA_PHONE001");
        keyword.click("SIGNUP_BTN_NEXT_STEEP");
        keyword.assertEquals("SIGNUP_VALID_NUMBER_FIELD", "SIGNUP_PHONE_ERROR");
    }

    public void reSendPassWord() throws InterruptedException {
        clearTextAndSendKey("SIGNUP_PASSWORD_INFORMATION", "SIGNUP_PASSWORD_INFORMATION", "SIGNUP_CREATE_PASSWORD_FAIL_01");
        keyword.click("SIGNUP_BTN_CREATE_ACCOUNT");
    }

    // delete old data Register an account with the phone number already in the system
    public void enterPhoneNumberAlreadyInSystem() throws InterruptedException {
        clearTextAndSendKey("SIGNUP_WITH_PHONE", "SIGNUP_WITH_PHONE", "SIGNUP_DATA_PHONE");
        keyword.click("SIGNUP_BTN_NEXT_STEEP");
        sendKeyFullDataFormPasswordInformation("SIGNUP_PASSWORD_INFORMATION", "LOGIN_NEW_PASSWORD", "SIGNUP_SELECT_TITLE", "SIGNUP_SELECT_OPTION_TITLE");
        keyword.click("SIGNUP_BTN_CREATE_ACCOUNT");
        keyword.untilJqueryIsDone(10L);
        keyword.assertEquals("SIGNUP_MESSAGE_PHONE_ALREADY", "SIGNUP_MESSAGE_ACTUAL");
    }

    //    Create new customer successfully with store enable phone number confirm
    public void signUpWithPhoneButEmailInSystem() throws InterruptedException {
        objSignIn = new SignInPage(this.keyword);
        clearTextAndSendKey("SIGNUP_WITH_PHONE", "SIGNUP_WITH_PHONE", "SIGNUP_DATA_PHONE_ALREADY");
        keyword.click("SIGNUP_BTN_NEXT_STEEP");
        sendKeyFullDataFormPasswordInformation("SIGNUP_PASSWORD_INFORMATION", "LOGIN_NEW_PASSWORD",
                "SIGNUP_SELECT_TITLE", "SIGNUP_SELECT_OPTION_TITLE");
        keyword.click("SIGNUP_BTN_CREATE_ACCOUNT");
        keyword.assertEquals("SIGNUP_MESSAGE_DUPLICATE", "SIGNUP_MESSAGE_ACTUAL");
        clearTextAndSendKey("SIGNUP_EMAIL_INFORMATION", "SIGNUP_EMAIL_INFORMATION",
                "SIGNUP_DATA_EMAIL_TEST_WITH_PHONE");
        clearTextAndSendKey("SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_DATA_EMAIL_TEST_WITH_PHONE");
        keyword.click("SIGNUP_BTN_NEXT_STEEP");
        sendKeyFullDataFormPasswordInformation("SIGNUP_PASSWORD_INFORMATION", "LOGIN_NEW_PASSWORD",
                "SIGNUP_SELECT_TITLE", "SIGNUP_SELECT_OPTION_TITLE");
        keyword.click("SIGNUP_BTN_CREATE_ACCOUNT");
        objSignIn.openNewTabs();
        objSignIn.loginAdmin(
                "LOGIN_DATA_USER_NAME",
                "LOGIN_DATA_PASS_WORD");
        objSignIn.chooseItemCustomer(
                "SIGNUP_STORES_ITEM", "SIGNUP_STORES_ITEM",
                "LOGIN_FORM_CUSTOMER", "SIGNUP_ELEMENT_SMS_LOG", "SIGNUP_VERIFY_SMS"
        );
        filterSort(
                "SIGNUP_BTN_FILTER", "SIGNUP_VERIFY_ELEMENT_FILTER",
                "SIGNUP_PHONE_REGIS", "SIGNUP_BUTTON_APPLY_FILTERS"
        );
        keyword.untilJqueryIsDone(30L);
        getCodeAndSendKey("SIGNUP_GET_CODE_SMS", "SIGNUP_SWITCH_TO_TAB_CHECK", "SIGNUP_BTN_SUBMIT"
        );
    }

    //    Filters function
    public void filterSort(String elementFilter, String inputFilter, String sendKeyFilter, String buttonApplyFilter) throws InterruptedException {
        keyword.webDriverWaitForElementPresent(elementFilter, 20);
        Thread.sleep(12000);
        keyword.click(elementFilter);
        keyword.verifyElementPresent(inputFilter);
        keyword.sendKeys(inputFilter, sendKeyFilter);
        keyword.click(buttonApplyFilter);
    }

    //    Get code and send key
    public void getCodeAndSendKey(String getCode, String dataInput, String btnSubmit) throws InterruptedException {
        String text = keyword.getText(getCode).substring(35, 41);
        keyword.switchToTab(0);
        keyword.sendKeys(dataInput, text);
        System.out.println("value copied");
        keyword.click(btnSubmit);
    }

    public boolean checkElement(String checkElement) {
        return keyword.verifyElementPresent(checkElement);
    }

}


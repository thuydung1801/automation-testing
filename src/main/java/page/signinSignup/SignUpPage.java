package page.signinSignup;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import io.cucumber.java.sl.In;
import org.slf4j.Logger;

import java.security.PublicKey;

public class SignUpPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
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
    public void createCustomerWithEmail() throws InterruptedException {
        sendKeyFullDataFormInformation("SIGNUP_DATA_FIRST_NAME_INFORMATION", "SIGNUP_DATA_LAST_NAME_INFORMATION"
                , "SIGNUP_EMAIL_EXIST", "SIGNUP_EMAIL_EXIST");
        keyword.click("SIGNUP_BTN_NEXT_STEEP");
        sendKeyFullDataFormPasswordInformation("SIGNUP_PASSWORD_INFORMATION", "LOGIN_NEW_PASSWORD",
                "SIGNUP_SELECT_TITLE", "SIGNUP_SELECT_OPTION_TITLE");
        keyword.untilJqueryIsDone(50L);
        keyword.click("SIGNUP_BTN_CREATE_ACCOUNT");
        keyword.assertEquals("SIGNUP_MESSAGE_DUPLICATE", "SIGNIN_MESSAGE_DATA_EXIST");
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

    //    confirm password entry condition
    public void confirmPasswordEntryCondition(String titleError, String Message, String characters, String number, String lowerLetter, String upperLetter, String charactersLike, String checkElement) throws InterruptedException {
        keyword.assertEquals(titleError, Message);
        keyword.assertEquals("SIGNUP_EXPECTED_MESSAGE_PASSWORD_01", characters);
        keyword.assertEquals("SIGNUP_EXPECTED_MESSAGE_PASSWORD_05", number);
        keyword.assertEquals("SIGNUP_EXPECTED_MESSAGE_PASSWORD_02", lowerLetter);
        keyword.assertEquals("SIGNUP_EXPECTED_MESSAGE_PASSWORD_03", upperLetter);
        keyword.assertEquals("SIGNUP_EXPECTED_MESSAGE_PASSWORD_04", charactersLike);
        keyword.webDriverWaitForElementPresent(checkElement, 10);
    }

    //Create new customer and leave with blank form for required form
    public void leaveWithBlankFormRequired() throws InterruptedException {
        keyword.reLoadPage();
        keyword.imWait(10);
        keyword.sendKeys("SIGNUP_EMAIL_INFORMATION", "SIGNUP_DATA_EMAIL_INVALID");
        keyword.sendKeys("SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_DATA_EMAIL_CONFIRM_INVALID");
        keyword.click("SIGNUP_BTN_NEXT_STEEP");
        keyword.assertEquals("SIGNUP_DATA_VERIFY_MESSAGE", "SIGNUP_FIRSTNAME_ERROR");
        keyword.assertEquals("SIGNUP_DATA_VERIFY_MESSAGE", "SIGNUP_LASTNAME_ERROR");
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

    //  Create new customer and input confirm email not same email form
    public void confirmEmailNotSameEmailForm() throws InterruptedException {
        clearTextAndSendKey("SIGNUP_EMAIL_INFORMATION", "SIGNUP_EMAIL_INFORMATION", "SIGNUP_DATA_EMAIL_NEW_INFORMATION");
        clearTextAndSendKey("SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_DATA_EMAIL_CONFIRM_FAIL");
        keyword.click("SIGNUP_XPATH_FOR_FORM");
        keyword.assertEquals("SIGNUP_EMAIL_NOT_SAME", "SIGNUP_ADDRESS_EMAIL_ERROR");
    }

    //Create an account with the same password as the register email
    public void enterTheSamePasswordAsEmail() throws InterruptedException {
        keyword.sendKeys("SIGNUP_FIRST_NAME_INFORMATION", "SIGNUP_DATA_FIRST_NAME_INFORMATION");
        keyword.sendKeys("SIGNUP_LAST_NAME_INFORMATION", "SIGNUP_DATA_LAST_NAME_INFORMATION");
        keyword.click("SIGNUP_BTN_NEXT_STEEP");
        sendKeyFullDataFormPasswordInformation("SIGNUP_PASSWORD_INFORMATION",
                "SIGNIN_PASSWORD_SAME_EMAIL", "SIGNUP_SELECT_TITLE",
                "SIGNUP_SELECT_OPTION_TITLE");
        keyword.click("SIGNUP_BTN_CREATE_ACCOUNT");
        keyword.assertEquals("SIGNUP_MESSAGE_PASSWORD_NOT_SAME_MAIL", "SIGNIN_MESSAGE_DATA_EXIST");
    }

    //    Create new customer create password  There are 3  types of characters and < 8 characters
    public void inputValidPassWordAndCheckBoxSubscribe() throws InterruptedException {
        sendKeyFullDataFormPasswordInformation("SIGNUP_PASSWORD_INFORMATION", "SIGNUP_CREATE_PASSWORD_FAIL",
                "SIGNUP_SELECT_TITLE", "SIGNUP_SELECT_OPTION_TITLE");
        keyword.click("SIGNUP_BTN_CREATE_ACCOUNT");
    }

    //"Create a new account with password # email register and Character:
    public void confirmPasswordEntryConditionCharacters() throws InterruptedException {
        clearTextAndSendKey("SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_DATA_NEW_EMAIL_CONFIRM_INFORMATION");
        keyword.click("SIGNUP_BTN_NEXT_STEEP");
        sendKeyFullDataFormPasswordInformation("SIGNUP_PASSWORD_INFORMATION", "SIGNUP_CREATE_PASSWORD_FAIL_03",
                "SIGNUP_SELECT_TITLE", "SIGNUP_SELECT_OPTION_TITLE");
        keyword.click("SIGNUP_BTN_CREATE_ACCOUNT");
        confirmPasswordEntryCondition("SIGNUP_MESSAGE_PASSWORD_FAIL01",
                "SIGNUP_ACTUAL_MESSAGE01", "SIGNUP_ACTUAL_MESSAGE04", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_NUMBER",
                "SIGNUP_ACTUAL_MESSAGE_AT_LAST_LOWER", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_UPPER", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_CHARACTERS",
                "SIGNUP_ACTUAL_MESSAGE04"

        );
    }

    //"Create a new account with password # email register and Number:
    public void confirmPasswordEntryConditionNumber() throws InterruptedException {
        clearTextAndSendKey("SIGNUP_PASSWORD_INFORMATION", "SIGNUP_PASSWORD_INFORMATION", "SIGNUP_CREATE_PASSWORD_FAIL_02");
        confirmPasswordEntryCondition("SIGNUP_MESSAGE_PASSWORD_FAIL01",
                "SIGNUP_ACTUAL_MESSAGE01", "SIGN_MESSAGE_CHARACTERS", "SIGNUP_MESSAGE_ERROR_NUMBER",
                "SIGNUP_ACTUAL_MESSAGE_AT_LAST_LOWER", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_UPPER", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_CHARACTERS",
                "SIGNUP_MESSAGE_ERROR_NUMBER"
        );
    }

    //    "Create a new account with password # email register and Lower Letter:
    public void confirmPasswordEntryConditionLowerLetter() throws InterruptedException {
        clearTextAndSendKey("SIGNUP_PASSWORD_INFORMATION", "SIGNUP_PASSWORD_INFORMATION", "SIGNUP_CREATE_PASSWORD_FAIL_04");
        confirmPasswordEntryCondition("SIGNUP_MESSAGE_PASSWORD_FAIL01",
                "SIGNUP_ACTUAL_MESSAGE01", "SIGN_MESSAGE_CHARACTERS", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_NUMBER",
                "SIGNUP_MESSAGE_ERROR_LOWER_LETTER", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_UPPER", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_CHARACTERS",
                "SIGNUP_MESSAGE_ERROR_LOWER_LETTER"
        );
    }

    //"Create a new account with password # email register and upper letter:
    public void confirmPasswordEntryConditionLowerUpper() throws InterruptedException {
        clearTextAndSendKey("SIGNUP_PASSWORD_INFORMATION", "SIGNUP_PASSWORD_INFORMATION", "SIGNUP_CREATE_PASSWORD_FAIL_05");
        confirmPasswordEntryCondition("SIGNUP_MESSAGE_PASSWORD_FAIL01",
                "SIGNUP_ACTUAL_MESSAGE01", "SIGN_MESSAGE_CHARACTERS", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_NUMBER",
                "SIGNUP_ACTUAL_MESSAGE_AT_LAST_LOWER", "SIGNUP_MESSAGE_ERROR_UPPER_LETTER", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_CHARACTERS",
                "SIGNUP_MESSAGE_ERROR_UPPER_LETTER"
        );
    }

    //"Create a new account with password # email register and Character Like:
    public void confirmPasswordEntryConditionCharactersLike() throws InterruptedException {
        clearTextAndSendKey("SIGNUP_PASSWORD_INFORMATION", "SIGNUP_PASSWORD_INFORMATION", "SIGNUP_CREATE_PASSWORD_FAIL_06");
        confirmPasswordEntryCondition("SIGNUP_MESSAGE_PASSWORD_FAIL01",
                "SIGNUP_ACTUAL_MESSAGE01", "SIGN_MESSAGE_CHARACTERS", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_NUMBER",
                "SIGNUP_ACTUAL_MESSAGE_AT_LAST_LOWER", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_UPPER", "SIGNUP_MESSAGE_ERROR_CHARACTERS_LIKE",
                "SIGNUP_MESSAGE_ERROR_CHARACTERS_LIKE"
        );
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
        keyword.untilJqueryIsDone(50L);
        keyword.assertEquals("SIGNUP_MESSAGE_CODE_ERROR", "SIGNUP_MESSAGE_ACTUAL");
    }

    // resend and get the code back
    public void resendAndGetCodeBack() throws Exception {
        objSignIn = new SignInPage(this.keyword);
        keyword.clearText("SIGNUP_INPUT_VERIFY_CODE");
        Thread.sleep(59000);
        keyword.click("SIGNUP_BTN_RESEND_CODE");
        keyword.assertEquals("SIGNUP_CODE_SENT", "SIGNUP_CODE_RESEND");
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
        keyword.assertEquals("SIGNUP_MESSAGE_SIGNUP_SUCCESS", "SIGNUP_MESSAGE_REGIS_SUCCESS");
    }

    //---------------------------------SIGN UP WITH MOBILE
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
//        Case14
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
        keyword.assertEquals("SIGNUP_MESSAGE_SIGNUP_SUCCESS", "SIGNUP_MESSAGE_REGIS_SUCCESS");
    }

    public boolean checkElement(String checkElement) {
        return keyword.verifyElementPresent(checkElement);
    }
}


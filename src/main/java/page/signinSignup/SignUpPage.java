package page.signinSignup;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import io.cucumber.java.sl.In;
import org.slf4j.Logger;

import java.security.PublicKey;
import java.util.Date;

public class SignUpPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private SignInPage objSignIn;
    private SignUpPage objSignUp;

    public SignUpPage(KeywordWeb key) {
        super(key);
    }

    public void navigateToUrlPage(String url) throws InterruptedException {
        keyword.navigateToUrl(url);
    }

    public void goToFormCreateMyAccount() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        Thread.sleep(1000);
        keyword.click("SIGNUP_BTN_SIGNUP");
        keyword.webDriverWaitForElementPresent("LOGIN_BTN_FORGOT_PASSWORD", 50);
        Thread.sleep(2000);
        keyword.click("SIGNUP_BTN_CREATE_MY_ACCOUNT");
        keyword.webDriverWaitForElementPresent("SIGNUP_FORM_DATA_INFORMATION", 500);
    }

    public void goToFormCreateMyAccountChina() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        Thread.sleep(1000);
        keyword.click("SIGNUP_BTN_SIGNUP_CHINA");
        keyword.webDriverWaitForElementPresent("SIGNUP_POPUP_SIGNUP_CHINA", 50);
        Thread.sleep(2000);
        keyword.click("SIGNUP_BTN_CREATE_ACCOUNT_CHINA");
        keyword.webDriverWaitForElementPresent("SIGNUP_TITLE_PAGE_REGIS", 500);
    }

    //    Create new customer and input email exist on database OR Create new customer and leave with blank form for required form with email
    public void createCustomerWithEmail() throws InterruptedException {
        sendKeyFullDataFormInformation("SIGNUP_DATA_FIRST_NAME_INFORMATION", "SIGNUP_DATA_LAST_NAME_INFORMATION"
                , "SIGNUP_EMAIL_EXIST", "SIGNUP_EMAIL_EXIST");
        keyword.click("SIGNUP_XPATH_FOR_FORM");
        keyword.click("SIGNUP_BTN_NEXT_STEEP");
        keyword.untilJqueryIsDone(50L);
        sendKeyFullDataFormPasswordInformation("SIGNUP_PASSWORD_INFORMATION", "LOGIN_NEW_PASSWORD",
                "SIGNUP_SELECT_TITLE", "SIGNUP_SELECT_OPTION_TITLE");
        keyword.untilJqueryIsDone(50L);
        keyword.click("SIGNUP_BTN_CREATE_ACCOUNT");
        keyword.untilJqueryIsDone(70L);
        Thread.sleep(2000);
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

    // verify input invalid with store China
    public void verifyMessageFormInvalid() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.assertEquals("必填项。", "LBL_ERROR_MESSAGE");
        keyword.assertEquals("必填项。", "SIGNUP_LASTNAME_ERROR");
        keyword.assertEquals("必填项。", "SIGNUP_PHONE_ERROR");
    }

    //    Get code and send key
    public void getCodeAndSendKey(String dataInput, String btnSubmit) throws InterruptedException {
        String text = keyword.numberOnly("SIGNUP_GET_CODE_SMS");
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

    //    confirm password entry condition WITH  Chinese
    public void confirmPasswordEntryConditionWithChinese(String Message, String characters, String number, String lowerLetter, String upperLetter, String charactersLike, String checkElement) throws InterruptedException {
        keyword.assertEquals("您的密码应与您的电子邮件地址不同，并包含", Message);
        keyword.assertEquals("至少8个字符", characters);
        keyword.assertEquals("至少1个号码", number);
        keyword.assertEquals("至少1个小写", lowerLetter);
        keyword.assertEquals("至少1个大写", upperLetter);
        keyword.assertEquals("至少1个字符，例如：# & $ ( ) * + , - . : , . = ? @ { } ~ !", charactersLike);
        keyword.webDriverWaitForElementPresent(checkElement, 10);
    }

    //Create new customer and leave with blank form for required form
    public void createCustomerWithBlankFormRequired() throws InterruptedException {
        keyword.reLoadPage();
        keyword.untilJqueryIsDone(10L);
        keyword.sendKeys("SIGNUP_EMAIL_INFORMATION", "SIGNUP_DATA_EMAIL_INVALID");
        keyword.sendKeys("SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_DATA_EMAIL_CONFIRM_INVALID");
        keyword.click("SIGNUP_BTN_NEXT_STEEP");
        keyword.imWait(30);
        keyword.assertEquals("SIGNUP_DATA_VERIFY_MESSAGE", "SIGNUP_FIRSTNAME_ERROR");
        keyword.assertEquals("SIGNUP_DATA_VERIFY_MESSAGE", "SIGNUP_LASTNAME_ERROR");
    }

    //    Create new customer and input invalid data for email form
    public void enterDataInvalidForEmailForm() throws InterruptedException {
        keyword.sendKeys("SIGNUP_FIRST_NAME_INFORMATION", "SIGNUP_DATA_FIRST_NAME_INFORMATION");
        keyword.sendKeys("SIGNUP_LAST_NAME_INFORMATION", "SIGNUP_DATA_LAST_NAME_INFORMATION");
        clearTextAndSendKey("SIGNUP_EMAIL_INFORMATION", "SIGNUP_EMAIL_INFORMATION", "SIGNUP_DATA_EMAIL_FAIL");
        clearTextAndSendKey("SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_DATA_EMAIL_FAIL");
        keyword.click("SIGNUP_XPATH_FOR_FORM");
        keyword.assertEquals("SIGNUP_EMAIL_SHOW_MESSAGE", "COM_TEXT_ERROR_EMAIL");
        keyword.assertEquals("SIGNUP_EMAIL_SHOW_MESSAGE", "SIGNUP_ADDRESS_EMAIL_ERROR");
    }

    //  Create new customer and input confirm email not same email form
    public void confirmEmailNotSameEmailForm() throws InterruptedException {
        clearTextAndSendKey("SIGNUP_EMAIL_INFORMATION", "SIGNUP_EMAIL_INFORMATION", "SIGNUP_DATA_EMAIL_NEW_INFORMATION");
        clearTextAndSendKey("SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_DATA_EMAIL_CONFIRM_FAIL");
        keyword.click("SIGNUP_XPATH_FOR_FORM");
        keyword.assertEquals("SIGNUP_EMAIL_NOT_SAME", "SIGNUP_ADDRESS_EMAIL_ERROR");
    }

    //Create an account with the same password as the register email
    public void enterPasswordSameEmail() throws InterruptedException {
        clearTextAndSendKey("SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_DATA_EMAIL_NEW_INFORMATION");
        keyword.untilJqueryIsDone(10L);
        keyword.click("SIGNUP_XPATH_FOR_FORM");
        keyword.click("SIGNUP_BTN_NEXT_STEEP");
        sendKeyFullDataFormPasswordInformation("SIGNUP_PASSWORD_INFORMATION",
                "SIGNUP_DATA_EMAIL_NEW_INFORMATION", "SIGNUP_SELECT_TITLE",
                "SIGNUP_SELECT_OPTION_TITLE");
        keyword.click("SIGNUP_BTN_CREATE_ACCOUNT");
        keyword.untilJqueryIsDone(50L);
        Thread.sleep(2000);
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
        String timestamp = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String emailRegis = "NgocNT" + timestamp + "@gmail.com";
        PropertiesFile.serPropValue("SIGNIN_EMAIL_REGIS", emailRegis);
        clearTextAndSendKey("SIGNUP_EMAIL_INFORMATION", "SIGNUP_EMAIL_INFORMATION", "SIGNIN_EMAIL_REGIS");
        clearTextAndSendKey("SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNIN_EMAIL_REGIS");
        keyword.click("SIGNUP_XPATH_FOR_FORM");
        keyword.click("SIGNUP_BTN_NEXT_STEEP");
        Thread.sleep(1000);
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
        keyword.untilJqueryIsDone(20L);
        keyword.imWait(30);
        clearTextAndSendKey("SIGNUP_PASSWORD_INFORMATION", "SIGNUP_PASSWORD_INFORMATION", "LOGIN_NEW_PASSWORD");
        keyword.click("SIGNUP_BTN_CREATE_ACCOUNT");
        keyword.webDriverWaitForElementPresent("SIGNUP_INPUT_VERIFY_CODE", 20);
        keyword.untilJqueryIsDone(50L);
        Thread.sleep(3000);
        keyword.sendKeys("SIGNUP_INPUT_VERIFY_CODE", "SIGNUP_CODE_DATA");
        keyword.click("SIGNUP_BTN_SUBMIT_ACCOUNT");
        keyword.untilJqueryIsDone(50L);
        Thread.sleep(1000);
        keyword.imWait(50);
        keyword.assertEquals("SIGNUP_MESSAGE_CODE_ERROR", "SIGNUP_MESSAGE_ACTUAL");
    }

    // resend and get the code back
    public void resendAndGetCodeBack() throws Exception {
        objSignIn = new SignInPage(this.keyword);
//        keyword.clearText("SIGNUP_INPUT_VERIFY_CODE");
        Thread.sleep(5000);
        keyword.click("SIGNUP_BTN_RESEND_CODE");
        keyword.untilJqueryIsDone(50L);
        keyword.imWait(50);
        keyword.assertEquals("SIGNUP_CODE_SENT", "SIGNUP_CODE_RESEND");
        objSignIn.openTabBE("https://dev4.glamira.com/secured2021");
        objSignIn.loginAdmin(
                "LOGIN_BE_USER_NAME_DEV4",
                "LOGIN_BE_PASSWORD_DEV4");
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
        objSignIn.getCodeEnterTextInField("LOGIN_IFRAME_DEV4",
                "LOGIN_INPUT_VERIFY_CODE",
                "SIGNUP_INPUT_VERIFY_CODE", "SIGNUP_BTN_SUBMIT_ACCOUNT");
        keyword.untilJqueryIsDone(30L);
        keyword.assertEquals("SIGNUP_MESSAGE_SIGNUP_SUCCESS_AU", "SIGNUP_MESSAGE_REGIS_SUCCESS_US");
    }

    //---------------------------------SIGN UP WITH MOBILE
    //    verify a required field.
    public void verifyRequiredFieldWithMobile() throws InterruptedException {
        keyword.click("SIGNUP_BTN_NEXT_CHINA");
        keyword.untilJqueryIsDone(30L);
        verifyMessageFormInvalid();
    }

    //Create new customer and leave with blank form for required form
    public void enterDataSignUpWithMobile() throws InterruptedException {
        sendKeyFullDataFormInformation("SIGNUP_DATA_FIRST_NAME_INFORMATION", "SIGNUP_DATA_LAST_NAME_INFORMATION", "SIGNUP_EMAIL_EXIST", "SIGNUP_EMAIL_EXIST");
        keyword.click("SIGNUP_SELECT_PHONE_CHINA");
        keyword.untilJqueryIsDone(30L);
        keyword.click("SIGNUP_PHONE_CHINA");
        keyword.sendKeys("SIGNUP_WITH_PHONE", "SIGNUP_DATA_PHONE_CHINA_INVALID");
        keyword.click("SIGNUP_BTN_NEXT_CHINA");
        keyword.assertEquals("请输入有效的手机号码。", "SIGNUP_PHONE_ERROR");
    }

    public void reSendPassWord() throws InterruptedException {
        clearTextAndSendKey("SIGNUP_PASSWORD_INFORMATION", "SIGNUP_PASSWORD_INFORMATION", "SIGNUP_CREATE_PASSWORD_FAIL_01");
        keyword.click("SIGNUP_BTN_CREATE_ACCOUNT");
    }

    // delete old data Register an account with the phone number already in the system
    public void enterPhoneNumberAlreadyInSystem() throws InterruptedException {
        clearTextAndSendKey("SIGNUP_WITH_PHONE", "SIGNUP_WITH_PHONE", "SIGNIN_PHONE_CHINA");
        keyword.click("SIGNUP_BTN_NEXT_CHINA");
        sendKeyFullDataFormPasswordInformation("SIGNUP_PASSWORD_INFORMATION", "LOGIN_NEW_PASSWORD", "SIGNUP_SELECT_TITLE", "SIGNUP_SELECT_OPTION_TITLE_CHINA");
        keyword.click("SIGNUP_BTN_CREATE");
        keyword.untilJqueryIsDone(70L);
        Thread.sleep(2000);
        keyword.assertEquals("关联网站中已经存在具有相同手机号码的客户。", "SIGNUP_MESSAGE_ACTUAL");
    }

    //passwordLessThan8Characters
    public void passwordLessThan8Characters() throws InterruptedException {
        objSignUp = new SignUpPage(this.keyword);
        clearTextAndSendKey("SIGNUP_WITH_PHONE", "SIGNUP_WITH_PHONE", "SIGNUP_DATA_PHONE_CHINA");
        keyword.click("SIGNUP_BTN_CREATE");
        keyword.untilJqueryIsDone(30L);
        objSignUp.confirmPasswordEntryConditionWithChinese(
                "SIGNIN_MESSAGE_CREATE_NEW_PW", "SIGNUP_ACTUAL_MESSAGE04", "SIGNUP_ACTUAL_MESSAGE_CHINA",
                "SIGNUP_ACTUAL_MESSAGE_CHINA1", "SIGNUP_ACTUAL_MESSAGE_CHINA2", "SIGNUP_ACTUAL_MESSAGE_CHINA3",
                "SIGNUP_ACTUAL_MESSAGE04"
        );
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
        getCodeAndSendKey("SIGNUP_SWITCH_TO_TAB_CHECK", "SIGNUP_BTN_SUBMIT"
        );
        keyword.assertEquals("SIGNUP_MESSAGE_SIGNUP_SUCCESS", "SIGNUP_MESSAGE_REGIS_SUCCESS");
    }

    public boolean checkElement(String checkElement) {
        return keyword.verifyElementPresent(checkElement);
    }
}


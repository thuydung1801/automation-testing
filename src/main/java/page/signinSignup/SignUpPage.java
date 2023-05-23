package page.signinSignup;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import io.cucumber.java.sl.In;
import org.slf4j.Logger;
import page.home.RegisterPage;

import java.security.PublicKey;
import java.util.Date;

public class SignUpPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private SignInPage objSignIn;
    private SignUpPage objSignUp;
    private RegisterPage objRegist;

    public SignUpPage(KeywordWeb key) {
        super();
        objRegist = new RegisterPage(this.keyword);
    }

    public void goToFormSignup(boolean checkURL, String iconLogin) throws InterruptedException {
        if (checkURL) {
            objRegist = new RegisterPage(this.keyword);
            keyword.navigateToUrl("https://stage.glamira.com/");
            keyword.untilJqueryIsDone(50L);
            objRegist.acceptAllCookies();
        }
        keyword.untilJqueryIsDone(20L);
        keyword.untilJqueryIsDone(30L);
        keyword.verifyElementVisible(iconLogin);
        keyword.click(iconLogin);
        keyword.untilJqueryIsDone(50L);
    }

    public void goToFormCreateMyAccount() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.reLoadPage();
        keyword.untilJqueryIsDone(50L);
        keyword.untilJqueryIsDone(50L);
        keyword.click("LOGIN_BTN_LOGIN");
        keyword.webDriverWaitForElementPresent("LOGIN_BTN_FORGOT_PASSWORD", 50);
        Thread.sleep(2000);
        keyword.scrollDownToElement("SIGNUP_BTN_CREATE_MY_ACCOUNT");
        keyword.untilJqueryIsDone(50L);
        keyword.click("SIGNUP_BTN_CREATE_MY_ACCOUNT");
        keyword.webDriverWaitForElementPresent("SIGNUP_FORM_DATA_INFORMATION", 500);
    }

    public void goToFormCreateMyAccountChina() throws InterruptedException {
        keyword.navigateToUrl("URL_DEV3_CHINA");
        keyword.deleteAllCookies();
        keyword.deleteAllCookies();
        keyword.reLoadPage();
        keyword.untilJqueryIsDone(50L);
        keyword.untilJqueryIsDone(50L);
        Thread.sleep(5000);
        keyword.click("SIGNUP_BTN_SIGNUP_CHINA");
        keyword.webDriverWaitForElementPresent("SIGNUP_POPUP_SIGNUP_CHINA", 50);
        objRegist.chooseLanguages();
        keyword.untilJqueryIsDone(50L);
        keyword.click("SIGNUP_BTN_CREATE_ACCOUNT_CHINA");
        keyword.webDriverWaitForElementPresent("SIGNUP_TITLE_PAGE_REGIS", 500);
    }

    //    Create new customer and input email exist on database OR Create new customer and leave with blank form for required form with email
    public void createCustomerWithEmail() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        sendKeyFullDataFormInformation("SIGNUP_DATA_FIRST_NAME_INFORMATION", "SIGNUP_DATA_LAST_NAME_INFORMATION"
                , "SIGNUP_EMAIL_EXIST", "SIGNUP_EMAIL_EXIST");
        keyword.click("SIGNUP_XPATH_FOR_FORM");
        keyword.click("SIGNUP_BTN_NEXT_STEEP");
        keyword.untilJqueryIsDone(50L);
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

    // sendKey full data form information (not click check box agree) ( form 2/3- pasWord)
    public void sendKeyFullDataFormPasswordInformation(String inputPassword, String password, String selectTitle, String selectOneOptionTitle) throws InterruptedException {
        keyword.sendKeys(inputPassword, password);
        keyword.untilJqueryIsDone(30L);
        if (keyword.verifyElementVisible(selectTitle)) {
            keyword.click(selectTitle);
//            keyword.checkStatusIsDisplay(selectOneOptionTitle);
            keyword.click(selectOneOptionTitle);
            keyword.click("SIGNUP_XPATH_FOR_FORM");
            keyword.click("SIGNUP_CHECKBOX_AGREE");
        } else {
            keyword.click("SIGNUP_XPATH_FOR_FORM");
            keyword.click("SIGNUP_CHECKBOX_AGREE");
        }
    }

    public void createInformationSFormPassword(String dataPassword) throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.sendKeys("SIGNUP_PASSWORD_INFORMATION", dataPassword);
        keyword.untilJqueryIsDone(50L);
        keyword.click("ACCEPT_AGREE");
        keyword.untilJqueryIsDone(50L);
        keyword.click("SIGNUP_BTN_CREATE_ACCOUNT");
        keyword.untilJqueryIsDone(50L);
        Thread.sleep(5000);
    }

    //    Filters function
    public void filterSort(String elementFilter, String inputFilter, String sendKeyFilter, String buttonApplyFilter) throws InterruptedException {
        keyword.webDriverWaitForElementPresent(elementFilter, 20);
//        Thread.sleep(12000);
        keyword.click(elementFilter);
        keyword.verifyElementPresent(inputFilter);
        keyword.sendKeys(inputFilter, sendKeyFilter);
        keyword.click(buttonApplyFilter);
    }

    // verify input invalid with store China
    public void verifyMessageFormInvalid() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.untilJqueryIsDone(50L);
        keyword.assertEquals("必填项。", "LBL_ERROR_MESSAGE");
        keyword.assertEquals("必填项。", "SIGNUP_LASTNAME_ERROR");
        keyword.assertEquals("必填项。", "SIGNUP_PHONE_ERROR");
    }

    //    Get code and send key
    public void getCodeAndSendKey(String dataInput, String btnSubmit) throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
//        String text = keyword.numberOnly("SIGNUP_GET_CODE_SMS");
//        System.out.println("-----------------:" + text);
//        keyword.switchToTab(0);
//        keyword.sendKeys(dataInput, text);
//        System.out.println("value copied");
//        keyword.click(btnSubmit);
        String text1 = keyword.getText("SIGNUP_GET_CODE_SMS");
        String text = text1.substring(text1.length() - 6);
        System.out.println("-----------------:" + text);
        keyword.switchToTab(0);
        keyword.reLoadPage();
        keyword.untilJqueryIsDone(50L);
        keyword.sendKeys(dataInput, text);
        keyword.click(btnSubmit);
    }

    //    confirm password entry condition
    public void confirmPasswordEntryCondition(String titleError, String Message, String characters, String number, String lowerLetter, String upperLetter, String charactersLike, String checkElement) throws InterruptedException {
        keyword.assertEquals(titleError, Message);
        keyword.assertEquals("SIGNUP_EXPECTED_MESSAGE_PASSWORD_01", characters);
        keyword.assertEquals("SIGNUP_EXPECTED_MESSAGE_PASSWORD_05", number);
        keyword.assertEquals("SIGNUP_EXPECTED_MESSAGE_PASSWORD_02", lowerLetter);
        keyword.assertEquals("SIGNUP_EXPECTED_MESSAGE_PASSWORD_03", upperLetter);
        keyword.assertEquals("SIGNUP_EXPECTED_MESSAGE_PASSWORD_07", charactersLike);
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

    //"Create a new account with password # email register and Character:
    public void confirmPasswordEntryConditionCharacters() throws InterruptedException {
        String timestamp = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String emailRegis = "NgocNT" + timestamp + "@gmail.com";
        PropertiesFile.serPropValue("SIGNIN_EMAIL_REGIS", emailRegis);
        clearTextAndSendKey("SIGNUP_EMAIL_INFORMATION", "SIGNUP_EMAIL_INFORMATION", "SIGNIN_EMAIL_REGIS");
        clearTextAndSendKey("SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNIN_EMAIL_REGIS");
        keyword.click("SIGNUP_XPATH_FOR_FORM");
        keyword.click("SIGNUP_BTN_NEXT_STEEP");
        keyword.untilJqueryIsDone(50L);
        sendKeyFullDataFormPasswordInformation("SIGNUP_PASSWORD_INFORMATION", "SIGNUP_CREATE_PASSWORD_FAIL_03",
                "SIGNUP_SELECT_TITLE", "SIGNUP_SELECT_OPTION_TITLE");
//        keyword.click("SIGNUP_BTN_CREATE_ACCOUNT");
        confirmPasswordEntryCondition("SIGNUP_MESSAGE_PASSWORD_FAIL01",
                "SIGNUP_ACTUAL_MESSAGE01", "SIGNUP_ACTUAL_MESSAGE04", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_NUMBER",
                "SIGNUP_ACTUAL_MESSAGE_AT_LAST_LOWER", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_UPPER", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_CHARACTERS",
                "SIGNUP_ACTUAL_MESSAGE04"

        );
    }

    //"Create a new account with password # email register and Number:
    public void confirmPasswordEntryConditionNumber() throws InterruptedException {
        clearTextAndSendKey("SIGNUP_PASSWORD_INFORMATION", "SIGNUP_PASSWORD_INFORMATION", "SIGNUP_CREATE_PASSWORD_FAIL_02");
        keyword.untilJqueryIsDone(50L);
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

    //    get code BE and Enter the wrong code sent to the email
    public void confirmAndProcessGetCodeWrong() throws InterruptedException {
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
        keyword.untilJqueryIsDone(50L);
        keyword.assertEquals("SIGNUP_MESSAGE_CODE_ERROR", "SIGNUP_MESSAGE_ACTUAL");
    }

    // resend and get the code back
    public void resendAndGetCodeBack() throws Exception {
        objSignIn = new SignInPage(this.keyword);
//        keyword.clearText("SIGNUP_INPUT_VERIFY_CODE");
        keyword.untilJqueryIsDone(50L);
        keyword.untilJqueryIsDone(50L);
        Thread.sleep(100000);
        keyword.click("SIGNUP_BTN_RESEND_CODE");
        keyword.untilJqueryIsDone(50L);
        keyword.imWait(50);
//        keyword.assertEquals("SIGNUP_CODE_SENT", "SIGNUP_CODE_RESEND");
        objSignIn.openTabBE("https://stage.glamira.com/secured2021//");
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
        keyword.untilJqueryIsDone(50L);
        objSignIn.selectActionEmailLog("LOGIN_CHECK_EMAIL_LOG_ACTION_SELECT",
                "LOGIN_SELECT_ACTIVE",
                "LOGIN_SELECT_VIEW_CHECK_EMAIL_LOG",
                "LOGIN_POPUP_MESSAGE_PASSWORD_RESET");
        objSignIn.getCodeEnterTextInField("IFRAME_STAGE",
                "INPUT_CODE_SEND",
                "SIGNUP_INPUT_VERIFY_CODE", "SIGNUP_BTN_SUBMIT_ACCOUNT");
        keyword.untilJqueryIsDone(50L);
        keyword.untilJqueryIsDone(50L);
//        keyword.verifyElementVisible("SIGNUP_MESSAGE_REGIS_SUCCESS_US");
        keyword.assertEquals("SIGNUP_MESSAGE_SIGNUP_SUCCESS_AU", "SIGNUP_MESSAGE_REGIST_SUCCESS_US");
        loginSuccess();
    }

    public void loginSuccess() throws InterruptedException {
        keyword.deleteAllCookies();
        keyword.reLoadPage();
        keyword.untilJqueryIsDone(50L);
        objRegist.acceptAllCookies();
        keyword.sendKeys("LOGIN_TXT_EMAIL", "SIGNIN_EMAIL_REGIS");
        Thread.sleep(2000);
        keyword.sendKeys("LOGIN_TXT_PASSWORD", "LOGIN_NEW_PASSWORD");
        keyword.click("LOGIN_BTN_SUBMITLOGIN");
        keyword.untilJqueryIsDone(50L);
        keyword.verifyElementVisible("MAC_VERIFY_NAME");
    }

    //---------------------------------SIGN UP WITH MOBILE

    //Create new customer and leave with blank form for required form
    public void enterDataSignUpWithMobile() throws InterruptedException {
        keyword.reLoadPage();
        keyword.untilJqueryIsDone(50L);
        createInformationStep1(true, "Nguyen", true,
                true, "DATA_PHONE_INVALID", true, "SIGNUP_EMAIL_SIGNUP", true, "SIGNUP_EMAIL_SIGNUP");
        keyword.assertEquals("SIGNUP_VALID_NUMBER_FIELD", "MOBILE_NUMBER_ERROR");
    }


    // delete old data Register an account with the phone number already in the system
    public void enterPhoneNumberAlreadyInSystem() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.reLoadPage();
        createInformationStep1(true, "Nguyen", true,
                true, "EMAIL_ONE_SYSTEM", true, "SIGNUP_EMAIL_SIGNUP", true, "SIGNUP_EMAIL_SIGNUP");
        keyword.untilJqueryIsDone(20L);
        keyword.assertEquals("SIGNUP_MESSAGE_DUPLICATE", "MESSAGE_ERROR_PHONE_NUMBER");

    }

    public void passwordAtLeast8character() throws InterruptedException {
        keyword.sendKeys("SIGNUP_PASSWORD_INFORMATION", "SIGNUP_CREATE_PASSWORD_FAIL_03");
        keyword.untilJqueryIsDone(50L);
        confirmPasswordEntryCondition("SIGNUP_MESSAGE_PASSWORD_FAIL01",
                "SIGNUP_ACTUAL_MESSAGE01", "SIGNUP_ACTUAL_MESSAGE04", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_NUMBER",
                "SIGNUP_ACTUAL_MESSAGE_AT_LAST_LOWER", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_UPPER", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_CHARACTERS",
                "SIGNUP_ACTUAL_MESSAGE04"
        );
    }

    //passwordLessThan8Characters
    public void passwordLessThan8Characters() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.reLoadPage();
        String timestamp = new java.text.SimpleDateFormat("HHmmss").format(new Date());
        String phone = "094" + timestamp + "6";
        PropertiesFile.serPropValue("EMAIL_ONE_SYSTEM2", phone);
        createInformationStep1(true, "Nguyen", true,
                true, "EMAIL_ONE_SYSTEM2", true, "SIGNUP_EMAIL_SIGNUP2", true, "SIGNUP_EMAIL_SIGNUP2");
        keyword.untilJqueryIsDone(50L);
        passwordAtLeast8character();
        confirmPasswordEntryCondition("SIGNUP_MESSAGE_PASSWORD_FAIL01",
                "SIGNUP_ACTUAL_MESSAGE01", "SIGNUP_ACTUAL_MESSAGE04", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_NUMBER",
                "SIGNUP_ACTUAL_MESSAGE_AT_LAST_LOWER", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_UPPER", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_CHARACTERS",
                "SIGNUP_ACTUAL_MESSAGE04"
        );
        keyword.untilJqueryIsDone(50L);
    }

    public void passwordAtLeastNumber() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        clearTextAndSendKey("SIGNUP_PASSWORD_INFORMATION", "SIGNUP_PASSWORD_INFORMATION", "SIGNUP_CREATE_PASSWORD_FAIL_02");
        keyword.untilJqueryIsDone(50L);
        confirmPasswordEntryCondition("SIGNUP_MESSAGE_PASSWORD_FAIL01",
                "SIGNUP_ACTUAL_MESSAGE01", "SIGN_MESSAGE_CHARACTERS", "SIGNUP_MESSAGE_ERROR_NUMBER",
                "SIGNUP_ACTUAL_MESSAGE_AT_LAST_LOWER", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_UPPER", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_CHARACTERS",
                "SIGNUP_MESSAGE_ERROR_NUMBER"
        );
    }

    //    checkConditionAtLeast1Number
    public void checkConditionAtLeast1Number() throws InterruptedException {
        clearTextAndSendKey("SIGNUP_PASSWORD_INFORMATION", "SIGNUP_PASSWORD_INFORMATION", "SIGNUP_CREATE_PASSWORD_FAIL_02");
        keyword.untilJqueryIsDone(50L);
        confirmPasswordEntryConditionWithChinese(
                "SIGNUP_ACTUAL_MESSAGE01", "SIGN_MESSAGE_CHARACTERS_SUCCESS", "SIGNUP_MESSAGE_ERROR_NUMBER",
                "SIGN_MESSAGE_CHARACTERS_MOBILE", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_UPPER", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_CHARACTERS",
                "SIGNUP_MESSAGE_ERROR_NUMBER"
        );
    }

    //    checkConditionAtLeast1LowerLetter
    public void checkConditionAtLeast1LowerLetter() throws InterruptedException {
        clearTextAndSendKey("SIGNUP_PASSWORD_INFORMATION", "SIGNUP_PASSWORD_INFORMATION", "SIGNUP_CREATE_PASSWORD_FAIL_04");
        keyword.untilJqueryIsDone(50L);
        confirmPasswordEntryConditionWithChinese(
                "SIGNUP_ACTUAL_MESSAGE01", "SIGN_MESSAGE_CHARACTERS", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_NUMBER",
                "SIGNUP_MESSAGE_ERROR_LOWER_LETTER", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_UPPER", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_CHARACTERS",
                "SIGNUP_MESSAGE_ERROR_LOWER_LETTER"
        );
    }

    //    checkConditionAtLeast1UpperLetter
    public void checkConditionAtLeast1UpperLetter() throws InterruptedException {
        clearTextAndSendKey("SIGNUP_PASSWORD_INFORMATION", "SIGNUP_PASSWORD_INFORMATION", "SIGNUP_CREATE_PASSWORD_FAIL_05");
        keyword.untilJqueryIsDone(50L);
        confirmPasswordEntryConditionWithChinese(
                "SIGNUP_ACTUAL_MESSAGE01", "SIGN_MESSAGE_CHARACTERS", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_NUMBER",
                "SIGNUP_ACTUAL_MESSAGE_AT_LAST_LOWER", "SIGNUP_MESSAGE_ERROR_UPPER_LETTER", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_CHARACTERS",
                "SIGNUP_MESSAGE_ERROR_UPPER_LETTER"
        );
    }

    //    checkConditionAtLeast1CharactersLike
    public void checkConditionAtLeast1CharactersLike() throws InterruptedException {
        clearTextAndSendKey("SIGNUP_PASSWORD_INFORMATION", "SIGNUP_PASSWORD_INFORMATION", "SIGNUP_CREATE_PASSWORD_FAIL_06");
        confirmPasswordEntryConditionWithChinese(
                "SIGNUP_ACTUAL_MESSAGE01", "SIGN_MESSAGE_CHARACTERS", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_NUMBER",
                "SIGNUP_ACTUAL_MESSAGE_AT_LAST_LOWER", "SIGNUP_ACTUAL_MESSAGE_AT_LAST_UPPER", "SIGNUP_MESSAGE_ERROR_CHARACTERS_LIKE_CHINA",
                "SIGNUP_MESSAGE_ERROR_CHARACTERS_LIKE_CHINA"
        );
    }

    //    checkConditionAEmailAlreadyInTheSystem
    public void checkConditionAEmailExisted() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        if (keyword.verifyElementPresent("BTN_BACK")) {
            keyword.click("BTN_BACK");
        }
        keyword.reLoadPage();
        createInformationStep1(true, "Nguyen", true,
                true, "EMAIL_ONE_SYSTEM2", true, "DATA_EMAIL_RETURN2", true, "DATA_EMAIL_RETURN2");
        keyword.untilJqueryIsDone(50L);
        keyword.assertEquals("SIGNUP_MESSAGE_DUPLICATE", "MESSAGE_ERROR_PHONE_NUMBER");
    }

    //createNewCusstomerSuccsessWithPhone
    public void createNewCustomerSuccessfullyWithPhone() throws InterruptedException {
        keyword.untilJqueryIsDone(30L);
        keyword.reLoadPage();
        String timestamp = new java.text.SimpleDateFormat("ddHHmmss").format(new Date());
        String email = "NgocNT" + timestamp + "@gmail.com";
        keyword.untilJqueryIsDone(10L);
        PropertiesFile.serPropValue("SIGNUP_EMAIL_SIGNUP_REGISTER", email);
        createInformationStep1(true, "Nguyen", true,
                true, "EMAIL_ONE_SYSTEM2", true, "SIGNUP_EMAIL_SIGNUP_REGISTER", true, "SIGNUP_EMAIL_SIGNUP_REGISTER");
        keyword.untilJqueryIsDone(50L);
        createInformationSFormPassword("DATA_PASSWORD_LOGIN_RETURN");
        keyword.untilJqueryIsDone(50L);
        keyword.sendKeys("LOGIN_INPUT_VERIFY_CODE", "DATA_SEND_SEND_CODE");
        keyword.untilJqueryIsDone(50L);
        keyword.click("BTN_ACTIVE_ACCOUNT");
        keyword.untilJqueryIsDone(50L);
//        keyword.assertEquals("CONTENT_MESSAGE_CODE_INVALID", "XPATH_MESSAGE_INVALID_CODE");
        Thread.sleep(120000);
        keyword.click("BTN_SEND_CODE");
        keyword.untilJqueryIsDone(50L);
        keyword.untilJqueryIsDone(50L);
//        keyword.assertEquals("SIGNUP_CODE_SENT", "MESSAGE_SED_CODE");
    }

    //    Create new customer successfully with store enable phone number confirm
    public void getActivationCode() throws InterruptedException {
        objSignIn = new SignInPage(this.keyword);
        objSignIn.openNewTabs();
        keyword.deleteAllCookies();
        keyword.reLoadPage();
        keyword.untilJqueryIsDone(50L);
        objSignIn.loginAdmin(
                "LOGIN_DATA_USER_NAME",
                "LOGIN_DATA_PASS_WORD");
        objSignIn.chooseItemCustomer(
                "SIGNUP_STORES_ITEM", "SIGNUP_STORES_ITEM",
                "LOGIN_FORM_CUSTOMER", "SIGNUP_ELEMENT_SMS_LOG", "SIGNUP_VERIFY_SMS"
        );
//        filterSort(
//                "SIGNUP_BTN_FILTER", "SIGNUP_VERIFY_ELEMENT_FILTER",
//                "SIGNUP_PHONE_REGIS", "SIGNUP_BUTTON_APPLY_FILTERS"
//        );
        keyword.untilJqueryIsDone(50L);
        Thread.sleep(10000);
    }

    public void getCodeBE(String input, String data, String actual) throws InterruptedException {
        getCodeAndSendKey(input, "SIGNUP_BTN_ACTIVE_ACCOUNT"
        );
        keyword.untilJqueryIsDone(50L);
        Thread.sleep(5000);
//        keyword.assertEquals(data, actual);
    }

    //    ------------------
    public void createInformationStep1(boolean checkFistName, String dataName, boolean checkLastName,
                                       boolean checkPhone, String dataPhone, boolean checkEmail, String dataEmail,
                                       boolean checkConfirmEmail, String dataEmailConfirm) throws InterruptedException {
        if (keyword.verifyElementPresent("BTN_CREATE_NEW_ACCOUNT")) {
            keyword.untilJqueryIsDone(30L);
            keyword.click("BTN_CREATE_NEW_ACCOUNT");
        }
        keyword.untilJqueryIsDone(50L);
        keyword.untilJqueryIsDone(50L);
        Thread.sleep(2000);
        if (checkFistName) {
            keyword.sendKeys("SIGNUP_FIRST_NAME_INFORMATION", dataName);
        }
        if (checkLastName) {
            keyword.sendKeys("SIGNUP_LAST_NAME_INFORMATION", dataName);
        }
        if (checkPhone) {
            keyword.sendKeys("SIGNUP_WITH_PHONE", dataPhone);
        }
        if (checkEmail) {
            keyword.sendKeys("SIGNUP_EMAIL_INFORMATION", dataEmail);
        }
        if (checkConfirmEmail) {
            keyword.sendKeys("SIGNUP_EMAIL_CONFIRM_ERROR", dataEmailConfirm);
        }
        keyword.click("SIGNUP_BTN_NEXT_STEEP");
    }

    public void verifyRequiredFieldWithMobile() throws InterruptedException {
        createInformationStep1(false, "Nguyen", false,
                true, "DATA_PHONE_NUMBER", true, "SIGNUP_EMAIL_SIGNUP", true, "SIGNUP_EMAIL_SIGNUP");
        keyword.assertEquals("COM_DATA_MESSAGES_NULL", "MESSAGE_REQUIRED_FAILED_FRIST_NAME");
        keyword.assertEquals("COM_DATA_MESSAGES_NULL", "MESSAGE_REQUIRED_FAILED_LAST_NAME");
    }

    public void createCustomerSuccess() throws InterruptedException {
        createNewCustomerSuccessfullyWithPhone();
        getActivationCode();
        getCodeBE("LOGIN_INPUT_VERIFY_CODE", "MESSAGE_SIGNUP_SUCCESS。", "SIGNUP_CODE_RESEND");
        keyword.deleteAllCookies();
        keyword.reLoadPage();
        keyword.untilJqueryIsDone(50L);
        objRegist.acceptAllCookies();
        if (keyword.verifyElementPresent("CHECK_PHONE_NUMBER")) {
            keyword.click("CHECK_PHONE_NUMBER");
        }
        keyword.sendKeys("PHONE_NUMBER", "EMAIL_ONE_SYSTEM2");
        Thread.sleep(2000);
        keyword.sendKeys("LOGIN_TXT_PASSWORD", "DATA_PASSWORD_LOGIN_RETURN");
        keyword.click("LOGIN_BTN_SUBMITLOGIN");
        keyword.untilJqueryIsDone(50L);
        keyword.verifyElementVisible("MAC_VERIFY_NAME");
    }
}


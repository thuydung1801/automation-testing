package page.signinSignup;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import org.slf4j.Logger;
import page.home.RegisterPage;

import java.util.Date;

public class SignUpMobilePage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private SignInMobilePage objSignIn;
    private SignUpMobilePage objSigUpMobile;
    private RegisterPage objRegist;

    public SignUpMobilePage(KeywordWeb key) {
        super(key);
    }


    public void navigateToUrlPage(String url) throws InterruptedException {
        keyword.navigateToUrl(url);
    }

    public void goToFormCreateMyAccount() throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
        keyword.scrollDownToElement("MOBILE_HAMBURGER");
        keyword.click("MOBILE_HAMBURGER");
        keyword.untilJqueryIsDone(50L);
        keyword.click("MOBILE_ICON_SIGNIN");
        keyword.untilJqueryIsDone(50L);
        keyword.webDriverWaitForElementPresent("LOGIN_BTN_FORGOT_PASSWORD", 50);
        Thread.sleep(2000);
        keyword.scrollDownToElement("SIGNUP_BTN_CREATE_MY_ACCOUNT");
        keyword.untilJqueryIsDone(50L);
        keyword.click("SIGNUP_BTN_CREATE_MY_ACCOUNT");
        keyword.webDriverWaitForElementPresent("SIGNUP_FORM_DATA_INFORMATION", 500);
    }

    public void goToFormCreateMyAccountChina() throws InterruptedException {
        objRegist = new RegisterPage(this.keyword);
        keyword.untilJqueryIsDone(50L);
        keyword.deleteAllCookies();
        keyword.reLoadPage();
        keyword.untilJqueryIsDone(50L);
        keyword.scrollToPosition();
        objRegist.chooseLanguages();
        keyword.untilJqueryIsDone(50L);
        keyword.scrollDownToElement("MOBILE_HAMBURGER");
        keyword.click("MOBILE_HAMBURGER");
        keyword.untilJqueryIsDone(50L);
        keyword.click("MOBILE_ICON_SIGNIN");
        keyword.untilJqueryIsDone(50L);
        if (check()) {
            keyword.untilJqueryIsDone(50L);
            keyword.click("BTN_LOGIN_PHONE");
            keyword.click("SIGNUP_BTN_CREATE_ACCOUNT_CHINA");
        } else {
            keyword.webDriverWaitForElementPresent("SIGNUP_POPUP_SIGNUP_CHINA", 50);
            keyword.click("SIGNUP_BTN_CREATE_ACCOUNT_CHINA");
        }
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

    //
    public void clearAndSendKeyEmail() throws InterruptedException {
        clearTextAndSendKey("SIGNUP_EMAIL_INFORMATION", "SIGNUP_EMAIL_INFORMATION", "SIGNUP_DATA_EMAIL_VALID");
        clearTextAndSendKey("SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_DATA_EMAIL_VALID");
        keyword.click("SIGNUP_BTN_NEXT_STEEP");
    }

    // sendKey full data form information (not click check box agree) ( form 2/3- pasWord)
    public void sendKeyFullDataFormPasswordInformation(String inputPassword, String password, String selectTitle, String selectOneOptionTitle) throws InterruptedException {
        keyword.sendKeys(inputPassword, password);
        keyword.untilJqueryIsDone(30L);
        if (checkElement(selectTitle)) {
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
        keyword.untilJqueryIsDone(50L);
        keyword.assertEquals("必填项。", "LBL_ERROR_MESSAGE");
        keyword.assertEquals("必填项。", "SIGNUP_LASTNAME_ERROR");
        keyword.assertEquals("必填项。", "SIGNUP_PHONE_ERROR");
    }

    //    Get code and send key
    public void getCodeAndSendKey(String dataInput, String btnSubmit) throws InterruptedException {
        keyword.untilJqueryIsDone(50L);
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

    //Create an account with the same password as the register email
    public void enterPasswordSameEmail() throws InterruptedException {
        clearTextAndSendKey("SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_DATA_EMAIL_NEW_INFORMATION");
        keyword.untilJqueryIsDone(10L);
        keyword.click("SIGNUP_XPATH_FOR_FORM");
        keyword.click("SIGNUP_BTN_NEXT_STEEP");
        keyword.untilJqueryIsDone(50L);
        keyword.clearText("SIGNUP_PASSWORD_INFORMATION");
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

    //   verify message  with password <8 characters and < 3 character types
    public void verifyMessageWithPasswordNotIllegal() throws InterruptedException {
//        verifyMessageFail("SIGNUP_MESSAGE_PASSWORD_FAIL01", "SIGNUP_ACTUAL_MESSAGE01", "SIGNUP_MESSAGE_PASSWORD_FAIL02", "SIGNUP_ACTUAL_MESSAGE03");
        Thread.sleep(1000);
        keyword.assertEquals("SIGNUP_EXPECTED_MESSAGE_PASSWORD_01", "SIGNUP_ACTUAL_MESSAGE02");
    }

    //---------------------------------SIGN UP WITH MOBILE
    //    verify a required field.
    public void verifyRequiredFieldWithMobile() throws InterruptedException {
        keyword.click("SIGNUP_BTN_NEXT_CHINA");
        keyword.untilJqueryIsDone(30L);
        verifyMessageFormInvalid();
    }
    public boolean checkElement(String checkElement) {
        return keyword.verifyElementVisible(checkElement);
    }

    Boolean check() throws InterruptedException {
        return keyword.verifyElementVisible("BTN_LOGIN_PHONE");
    }
}

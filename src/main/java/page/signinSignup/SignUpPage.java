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
       nextButton();
    }

    // sendKey full data form information (not click check box agree) ( form 2/3- pasWord)
    public void sendKeyFullDataFormPasswordInformation(String inputPassword, String password, String selectTitle, String selectOneOptionTitle) throws InterruptedException {
        keyword.sendKeys(inputPassword, password);
        keyword.click(selectTitle);
        keyword.checkStatusIsDisplay(selectOneOptionTitle);
        keyword.click(selectOneOptionTitle);
        keyword.click("SIGNUP_CHECKBOX_AGREE");
    }

    public void sendData(String inputData1, String data1, String inputData2, String data2) {
        keyword.sendKeys(inputData1, data1);
        keyword.sendKeys(inputData2, data2);
    }

    //assert Equals Message
    public void verifyMessageFail(String expected01, String actual01, String expected02, String actual02) throws InterruptedException {
        keyword.assertEquals(expected01, actual01);
        Thread.sleep(1000);
        keyword.assertEquals(expected02, actual02);
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
        verifyMessageFail("SIGNUP_MESSAGE_PASSWORD_FAIL01", "SIGNUP_ACTUAL_MESSAGE01", "SIGNUP_EXPECTED_MESSAGE_PASSWORD_01", "SIGNUP_ACTUAL_MESSAGE02");
    }

    //   verify message  with password <8 characters and < 3 character types
    public void verifyMessageWithPasswordNotIllegal() throws InterruptedException {
        verifyMessageFail("SIGNUP_MESSAGE_PASSWORD_FAIL01", "SIGNUP_ACTUAL_MESSAGE01", "SIGNUP_MESSAGE_PASSWORD_FAIL02", "SIGNUP_ACTUAL_MESSAGE03");
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
        verifySignUpSuccess();

    }
//---------------------------------SIGN UP WITH OBILLE

    //    verify a required field.
    public void verifyRequiredFieldWithMobile() throws InterruptedException {
        nextButton();
        verifyMessageFail("SIGNUP_DATA_VERIFY_MESSAGE", "SIGNUP_FIRSTNAME_ERROR", "SIGNUP_DATA_VERIFY_MESSAGE", "SIGNUP_LASTNAME_ERROR");
        Thread.sleep(1000);
        keyword.assertEquals("SIGNUP_DATA_VERIFY_MESSAGE", "SIGNUP_PHONE_ERROR");
    }

    //Create new customer and leave with blank form for required form
    public void enterDataSignUpWithMobile() throws InterruptedException {
        sendKeyFullDataFormInformation("SIGNUP_DATA_FIRST_NAME_INFORMATION", "SIGNUP_DATA_LAST_NAME_INFORMATION", "SIGNUP_EMAIL_EXIST", "SIGNUP_EMAIL_EXIST");
        keyword.sendKeys("SIGNUP_WITH_PHONE", "SIGNUP_DATA_PHONE");
        nextButton();
        keyword.assertEquals("SIGNUP_VALID_NUMBER_FIELD", "SIGNUP_PHONE_ERROR");
    }

    public void reSendPassWord() throws InterruptedException {
        clearTextAndSendKey("SIGNUP_PASSWORD_INFORMATION", "SIGNUP_PASSWORD_INFORMATION", "SIGNUP_CREATE_PASSWORD_FAIL_01");
        ClickButtonCreateAccount();
    }

    // delete old data Register an account with the phone number already in the system
    public void enterPhoneNumberAlreadyInSystem()throws InterruptedException {
      sendKeyFullDataFormInformation("SIGNUP_DATA_FIRST_NAME_INFORMATION", "SIGNUP_DATA_LAST_NAME_INFORMATION", "SIGNUP_EMAIL_EXIST", "SIGNUP_EMAIL_EXIST");
        nextButton();
    }
    public void verifyMessagePhoneAlready() throws InterruptedException{

    }

    //    Enter data input email exist on database
    public void dataInputExistOnData() throws InterruptedException {
        sendKeyFullDataFormInformation(
                "SIGNUP_DATA_FIRST_NAME_INFORMATION",
                "SIGNUP_DATA_LAST_NAME_INFORMATION",
                "SIGNUP_EMAIL_EXIST",
                "SIGNUP_EMAIL_EXIST"
        );
    }

    public void submitNotClickAgree(String password) {
        keyword.click("SIGNUP_BTN_CREATE_ACCOUNT");
        keyword.checkStatusIsDisplay("SIGNUP_AGREEMENT_AGREE_ERROR");
        keyword.click("SIGNUP_CHECKBOX_AGREE");
        keyword.click("SIGNUP_BTN_CREATE_ACCOUNT");
        keyword.assertEquals("SIGNUP_MESSAGE_DUPLICATE", "SIGNUP_MESSAGE_EQUAL");
        keyword.clearText("SIGNUP_EMAIL_INFORMATION");
        keyword.sendKeys("SIGNUP_EMAIL_INFORMATION", "SIGNUP_DATA_EMAIL_NEW_INFORMATION");
        keyword.clearText("SIGNUP_EMAIL_CONFIRMATION_INFORMATION");
        keyword.sendKeys("SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_DATA_EMAIL_NEW_INFORMATION");
        keyword.click("SIGNUP_BTN_NEXT_STEEP");
        keyword.sendKeys("SIGNUP_PASSWORD_INFORMATION", password);
        keyword.click("SIGNUP_CHECKBOX_AGREE");
        keyword.click("SIGNUP_BTN_CREATE_ACCOUNT");
    }


    //  submit form , not enter valid values
    public void enterNotValueInformation() throws InterruptedException {
        if (checkElement("SIGNUP_WITH_PHONE")) {
            nextButton();
            keyword.checkStatusIsDisplay("SIGNUP_FIRSTNAME_ERROR");
            keyword.checkStatusIsDisplay("SIGNUP_LASTNAME_ERROR");
            keyword.checkStatusIsDisplay("SIGNUP_PHONE_ERROR");
        } else {
            keyword.click("SIGNUP_BTN_NEXT_STEEP");
            keyword.checkStatusIsDisplay("SIGNUP_FIRSTNAME_ERROR");
            keyword.checkStatusIsDisplay("SIGNUP_LASTNAME_ERROR");
            keyword.checkStatusIsDisplay("SIGNUP_EMAIL_ERROR");
            keyword.checkStatusIsDisplay("SIGNUP_EMAIL_CONFIRM_ERROR");
        }
    }

    //    Create new customer and input invalid data for email form
    public void sendDataFormInformationWithEmailInvalid() throws InterruptedException {
        if (checkElement("SIGNUP_WITH_PHONE")) {
            // Enter account registration information with phcheckElement("SIGNUP_WITH_PHONE")one number
            sendKeyFullDataFormInformation(
                    "SIGNUP_DATA_FIRST_NAME_INFORMATION",
                    "SIGNUP_DATA_LAST_NAME_INFORMATION",
                    "SIGNUP_RESET_EMAIL_INVALID",
                    "SIGNUP_RESET_EMAIL_INVALID"
            );
            keyword.sendKeys("SIGNUP_WITH_PHONE", "SIGNUP_DATA_PHONE001");
            keyword.click("SIGNUP_BTN_NEXT_STEEP");
            //   Enter the password and select the full information
            sendKeyFullDataFormPasswordInformation(
                    "SIGNUP_SELECT_TITLE",
                    "SIGNUP_PASSWORD_INFORMATION",
                    "SIGNUP_CREATE_PASSWORD_PHONE",
                    "SIGNUP_SELECT_OPTION_TITLE"

            );
//            keyword.click("SIGNUP_CHECKBOX_AGREE");
            keyword.click("SIGNUP_BTN_CREATE_ACCOUNT");

        } else {
            keyword.sendKeys("SIGNUP_FIRST_NAME_INFORMATION", "SIGNUP_DATA_FIRST_NAME_INFORMATION");
            keyword.sendKeys("SIGNUP_LAST_NAME_INFORMATION", "SIGNUP_DATA_LAST_NAME_INFORMATION");
            keyword.sendKeys("SIGNUP_EMAIL_INFORMATION", "SIGNUP_DATA_LAST_NAME_INFORMATION");
            keyword.click("SIGNUP_CLICK_FOCUS");
            keyword.assertEquals("SIGNUP_EMAIL_SHOW_MESSAGE", "TEXT_ERROR_EMAIL");
            clearTextAndSendKey("SIGNUP_EMAIL_INFORMATION", "SIGNUP_EMAIL_INFORMATION", "SIGNUP_DATA_EMAIL_INFORMATION");
            keyword.sendKeys("SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_DATA_NEW_EMAIL_CONFIRM_INFORMATION");
        }
    }

    //Create new customer and enter invalid data for email confirmation form (with Confirmation email entered incorrectly before)
    public void sendDataFormInformationWithConfirmEmailInvalid() throws InterruptedException {
        if (checkElement("SIGNUP_SWITCH_TO_TAB_CHECK")) {
            System.out.println("next to steep");
        } else {
            keyword.click("SIGNUP_CLICK_FOCUS");
            keyword.assertEquals("SIGNUP_EMAIL_CONFIRM_SHOW_MESSAGE", "SIGNUP_ADDRESS_EMAIL_ERROR");
            clearTextAndSendKey("SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_DATA_EMAIL_INFORMATION");
        }
    }

    //    verify success signup
    public void verifySignUpSuccess() throws InterruptedException {
        if (keyword.verifyElementPresent("SIGNUP_VERIFY_SIGNUP")) {
            logger.info("SignUp success,Welcome-msg");
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

    //    Get code and send key
    public void getCodeAndSendKey(String getCode, String dataInput, String btnSubmit) throws InterruptedException {
        String text = keyword.getText(getCode).substring(36, 41);
        keyword.switchToTab(0);
        keyword.sendKeys(dataInput, text);
        System.out.println("value copied");
        keyword.click(btnSubmit);
    }

    public void switchToTabCheck(int index) {
        keyword.switchToTab(index);
    }

    public void nextButton() {
        keyword.click("SIGNUP_BTN_NEXT_STEEP");
    }

    public void ClickButtonCreateAccount() throws InterruptedException {
        keyword.click("SIGNUP_BTN_CREATE_ACCOUNT");
    }

    public boolean checkElement(String checkElement) {
        return keyword.verifyElementPresent(checkElement);
    }

}
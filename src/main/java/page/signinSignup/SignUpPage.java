package page.signinSignup;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import org.slf4j.Logger;

public class SignUpPage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    private SignUpPage objSignUp;

    public SignUpPage(KeywordWeb key) {
        super(key);
    }

    public void goToFormCreateMyAccount() throws InterruptedException {
        keyword.click("LOGIN_BTN_LOGIN");
        keyword.webDriverWaitForElementPresent("LOGIN_BTN_FORGOT_PASSWORD", 20);
        Thread.sleep(2000);
        keyword.click("SIGNUP_BTN_CREATE_MY_ACCOUNT");
        keyword.webDriverWaitForElementPresent("SIGNUP_FORM_DATA_INFORMATION", 20);
    }

    // sendKey full data form information
    public void sendKeyFullDataFormInformationAndSubmit(String firstName, String lastName, String email, String emailConfirm) throws InterruptedException {
        keyword.sendKeys("SIGNUP_FIRST_NAME_INFORMATION", firstName);
        keyword.sendKeys("SIGNUP_LAST_NAME_INFORMATION", lastName);
        keyword.sendKeys("SIGNUP_EMAIL_INFORMATION", email);
        keyword.sendKeys("SIGNUP_EMAIL_CONFIRMATION_INFORMATION", emailConfirm);
        keyword.click("SIGNUP_BTN_NEXT_STEEP");
    }

    public void clearTextAndSendKey(String clearText, String inputSendKey, String dataSendKey) throws InterruptedException {
        keyword.clearText(clearText);
        keyword.sendKeys(inputSendKey, dataSendKey);
    }

    // sendKey full data form information (not click check box agree) ( form 2/3- pasWord)
    public void sendKeyFullDataFormPasswordInformation(String password, String selectOneOptionTitle) throws InterruptedException {
        keyword.sendKeys("SIGNUP_PASSWORD_INFORMATION", password);
        keyword.click("SIGNUP_SELECT_TITLE");
        keyword.checkStatusIsDisplay(selectOneOptionTitle);
        keyword.click(selectOneOptionTitle);
        keyword.click("SIGNUP_BTN_CREATE_ACCOUNT");
        keyword.checkStatusIsDisplay("SIGNUP_AGREEMENT_AGREE_ERROR");
        keyword.click("SIGNUP_CHECKBOX_AGREE");
        keyword.click("SIGNUP_BTN_CREATE_ACCOUNT");
        keyword.assertEquals("SIGNUP_MESSAGE_DUPLICATE", "SIGNUP_MESSAGE_EQUAL");
        keyword.clearText("SIGNUP_EMAIL_INFORMATION");
        keyword.sendKeys("SIGNUP_EMAIL_INFORMATION", "SIGNUP_DATA_EMAIL_NEW_INFORMATION");
        keyword.clearText("SIGNUP_EMAIL_CONFIRMATION_INFORMATION");
        keyword.sendKeys("SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_DATA_NEW_EMAIL_CONFIRM_INFORMATION");
        keyword.click("SIGNUP_BTN_NEXT_STEEP");
        keyword.sendKeys("SIGNUP_PASSWORD_INFORMATION", password);
        keyword.click("SIGNUP_CHECKBOX_AGREE");
        keyword.click("SIGNUP_BTN_CREATE_ACCOUNT");
    }

    //
    public void nextButton() throws InterruptedException {
        keyword.click("SIGNUP_BTN_NEXT_STEEP");
    }

    //  submit form , not enter valid values
    public void enterNotValueInformation() throws InterruptedException {
        keyword.click("SIGNUP_BTN_NEXT_STEEP");
        keyword.checkStatusIsDisplay("SIGNUP_FIRSTNAME_ERROR");
        keyword.checkStatusIsDisplay("SIGNUP_LASTNAME_ERROR");
        keyword.checkStatusIsDisplay("SIGNUP_EMAIL_ERROR");
        keyword.checkStatusIsDisplay("SIGNUP_EMAIL_CONFIRM_ERROR");
    }

    //    Create new customer and input invalid data for email form
    public void sendDataFormInformationWithEmailInvalid() throws InterruptedException {
        keyword.sendKeys("SIGNUP_FIRST_NAME_INFORMATION", "SIGNUP_DATA_FIRST_NAME_INFORMATION");
        keyword.sendKeys("SIGNUP_LAST_NAME_INFORMATION", "SIGNUP_DATA_LAST_NAME_INFORMATION");
        keyword.sendKeys("SIGNUP_EMAIL_INFORMATION", "SIGNUP_DATA_LAST_NAME_INFORMATION");
        keyword.click("SIGNUP_CLICK_FOCUS");
        keyword.assertEquals("SIGNUP_EMAIL_SHOW_MESSAGE", "TEXT_ERROR_EMAIL");
        clearTextAndSendKey("SIGNUP_EMAIL_INFORMATION", "SIGNUP_EMAIL_INFORMATION", "SIGNUP_DATA_EMAIL_INFORMATION");
        keyword.sendKeys("SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_DATA_NEW_EMAIL_CONFIRM_INFORMATION");
    }

    //Create new customer and enter invalid data for email confirmation form (with Confirmation email entered incorrectly before)
    public void sendDataFormInformationWithConfirmEmailInvalid() throws InterruptedException {
        keyword.click("SIGNUP_CLICK_FOCUS");
        keyword.assertEquals("SIGNUP_EMAIL_CONFIRM_SHOW_MESSAGE", "SIGNUP_ADDRESS_EMAIL_ERROR");
        clearTextAndSendKey("SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_EMAIL_CONFIRMATION_INFORMATION", "SIGNUP_DATA_EMAIL_INFORMATION");
    }
}
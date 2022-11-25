package page.signinSignup;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import io.cucumber.java.sl.In;
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
        if (keyword.verifyElementPresent("SIGNUP_WITH_PHONE")) {
            keyword.webDriverWaitForElementPresent("SIGNUP_WITH_PHONE", 20);
        } else {
            keyword.webDriverWaitForElementPresent("SIGNUP_FORM_DATA_INFORMATION", 20);
        }

    }

    // sendKey full data form information
    public void sendKeyFullDataFormInformationAndSubmit(String firstName, String lastName, String email, String emailConfirm) throws InterruptedException {
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
    public void sendKeyFullDataFormPasswordInformation(String selectTitle, String inputPassword, String password, String selectOneOptionTitle) throws InterruptedException {
        keyword.sendKeys(inputPassword, password);
        keyword.click(selectTitle);
        keyword.checkStatusIsDisplay(selectOneOptionTitle);
        keyword.click(selectOneOptionTitle);
    }

    //
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
            sendKeyFullDataFormInformationAndSubmit(
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
            keyword.click("SIGNUP_CHECKBOX_AGREE");
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
    public boolean checkElement(String checkElement) {
        return keyword.verifyElementPresent(checkElement);
    }

}
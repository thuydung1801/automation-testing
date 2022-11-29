package test.signinSignup;


import core.BaseTest;
import core.LogHelper;
import io.cucumber.java.sl.In;
import org.testng.SkipException;
import org.testng.annotations.Test;
import page.home.LoginPage;
import page.home.RegisterPage;
import page.signinSignup.SignInPage;
import page.signinSignup.SignUpPage;
import org.slf4j.Logger;

public class SignUpTest extends BaseTest {
    private LoginPage objLogin;
    private RegisterPage objRegist;
    private SignUpPage objSigUp;
    private SignInPage objSignIn;
    private static Logger logger = LogHelper.getLogger();

    public SignUpTest() {
        super();
    }

    @Test(priority = 1, description = "Create new customer and input email exist on database OR Create new customer and leave with blank form for required form")
    public void testCase_SU05() throws InterruptedException {
        logger.info("testCase_SU05");
        objLogin = new LoginPage(this.keyword);
        objRegist = new RegisterPage(this.keyword);
        objSigUp = new SignUpPage(this.keyword);
        objLogin.loginOnAlert();
        objRegist.acceptAllCookies();
        objRegist.chooseLanguages();
        Thread.sleep(2000);
        objSigUp.goToFormCreateMyAccount();
        if (!objSigUp.checkElement("SIGNUP_WITH_PHONE")) {
            objSigUp.sendKeyFullDataFormInformation("SIGNUP_DATA_FIRST_NAME_INFORMATION", "SIGNUP_DATA_LAST_NAME_INFORMATION"
                    , "SIGNUP_EMAIL_EXIST", "SIGNUP_EMAIL_EXIST");
            objSigUp.nextButton();
            objSigUp.sendKeyFullDataFormPasswordInformation("SIGNUP_PASSWORD_INFORMATION", "LOGIN_NEW_PASSWORD",
                    "SIGNUP_SELECT_TITLE", "SIGNUP_SELECT_OPTION_TITLE");
        } else {
            logger.info("next steep test");
        }
    }

    //    @Test(priority = 2, description = "Create new customer and leave with email form for required form")
    public void testCase_SU02() throws InterruptedException {
        logger.info("testCase_SU02");
        objSigUp.sendDataEmailAndConfirmEmail();
        objSigUp.verifyMessageFail("SIGNUP_DATA_VERIFY_MESSAGE", "SIGNUP_FIRSTNAME_ERROR", "SIGNUP_DATA_VERIFY_MESSAGE", "SIGNUP_LASTNAME_ERROR");

    }

    //    @Test(priority = 3, description = "Create new customer and input invalid data for email form")
    public void testCase_SU03() throws InterruptedException {
        logger.info("testCase_SU03");
        objSigUp.invalidDataForEmailForm();
    }

    //    @Test(priority = 4, description = "Enter full data and confirm email does not match")
    public void testCase_SU04() throws InterruptedException {
        logger.info("testCase_SU04");
        objSigUp.confirmEmailNotMatch();
    }

    //    @Test(priority = 5, description = "Create new customer create password  There are 3  types of characters and < 8 characters")
    public void testCase_SU06() throws InterruptedException {
        logger.info("testCase_SU06");
        objSigUp.clearAndSendKeyEmail();
        objSigUp.inputValidPassWordAndCheckBoxSubscribe();
    }

    //    @Test(priority = 6, description = "Create a new user with password >= 8 characters and < 3 character types")
    public void testCase_SU07() throws InterruptedException {
        logger.info("testCase_SU07");
        objSigUp.clearTextAndSendKey("SIGNUP_PASSWORD_INFORMATION", "SIGNUP_PASSWORD_INFORMATION", "SIGNUP_CREATE_PASSWORD_FAIL_01");
        objSigUp.ClickButtonCreateAccount();
        objSigUp.verifyMessageFail("SIGNUP_MESSAGE_PASSWORD_FAIL01", "SIGNUP_ACTUAL_MESSAGE01", "SIGNUP_MESSAGE_PASSWORD_FAIL02", "SIGNUP_ACTUAL_MESSAGE03");
    }

    //    @Test(priority = 7, description = "Create a new user with password <8 characters and < 3 character types")
    public void testCase_SU08() throws InterruptedException {
        logger.info("testCase_SU08");
        objSigUp.reSendPassWord();
        objSigUp.verifyMessageWithPasswordNotIllegal();
    }

    //    @Test(priority = 8, description = "Enter the wrong code sent to the email")
    public void testCase_SU09() throws InterruptedException {
        logger.info("testCase_SU09");
        objSigUp.clearTextAndSendKey("SIGNUP_PASSWORD_INFORMATION", "SIGNUP_PASSWORD_INFORMATION", "LOGIN_NEW_PASSWORD");
        objSigUp.ConfirmAndProcessGetCodeWrong();
    }

    //    @Test(priority = 9, description = "Resend the code to email")
    public void testCase_SU010() throws Exception {
        logger.info("testCase_SU010");
        objSigUp.resendAndGetCodeBack();
    }

    //    SIGNUP WITH MOBILE
    @Test(priority = 10, description = "Create new customer and leave with blank form for required form")
    public void testCase_SU012() throws Exception {
        logger.info("testCase_SU012");
        objSigUp.verifyRequiredFieldWithMobile();
    }

    @Test(priority = 11, description = "Invalid phone number entered")
    public void testCase_SU013() throws Exception {
        logger.info("testCase_SU013");
        objSigUp.enterDataSignUpWithMobile();
    }

    @Test(priority = 12, description = "Register an account with the phone number already in the system")
    public void testCase_SU014() throws Exception {
        logger.info("testCase_SU014");
        objSigUp.clearTextAndSendKey("SIGNUP_WITH_PHONE", "SIGNUP_WITH_PHONE", "SIGNUP_DATA_PHNE");
        objSigUp.enterPhoneNumberAlreadyInSystem();
        objSigUp.sendKeyFullDataFormPasswordInformation("SIGNUP_PASSWORD_INFORMATION", "LOGIN_NEW_PASSWORD", "SIGNUP_SELECT_TITLE", "SIGNUP_SELECT_OPTION_TITLE");
        objSigUp.verifyMessagePhoneAlready();
    }
//    public void
//    @Test(priority = 5, description = "Create New Account- Sign up with a duplicate email address")
//    public void testCase_SU05() throws InterruptedException {
//        if (objSigUp.checkElement("SIGNUP_SWITCH_TO_TAB_CHECK")) {
//            System.out.println("next to steep");
//        } else {
//            objSigUp.nextButton();
//            objSigUp.sendKeyFullDataFormPasswordInformation(
//                    "SIGNUP_SELECT_TITLE",
//                    "SIGNUP_PASSWORD_INFORMATION",
//                    "SIGNUP_CREATE_PASSWORD",
//                    "SIGNUP_SELECT_OPTION_TITLE"
//            );
//            objSigUp.submitNotClickAgree("SIGNUP_CREATE_PASSWORD");
//        }
//    }
//    @Test(priority = 6, description = "Get the activation code sent to the email address")
//    public void testCase_GetCodeBE4() throws Exception {
//        objSignIn = new SignInPage(this.keyword);
//        objSignIn.openNewTabs();
//        objSignIn.loginAdmin(
//                "LOGIN_DATA_USER_NAME",
//                "LOGIN_DATA_PASS_WORD");
//        objSigUp.switchToTabCheck(0);
//        if (objSigUp.checkElement("SIGNUP_SWITCH_TO_TAB_CHECK")) {
//            objSigUp.switchToTabCheck(1);
//            objSignIn.chooseItemCustomer(
//                    "SIGNUP_STORES_ITEM",
//                    "SIGNUP_STORES_ITEM",
//                    "LOGIN_FORM_CUSTOMER",
//                    "SIGNUP_ELEMENT_SMS_LOG",
//                    "SIGNUP_VERIFY_SMS"
//            );
//            objSigUp.filterSort(
//                    "SIGNUP_BTN_FILTER",
//                    "SIGNUP_VERIFY_ELEMENT_FILTER",
//                    "SIGNUP_DATA_PHONE001",
//                    "SIGNUP_BUTTON_APPLY_FILTERS"
//            );
//            objSigUp.getCodeAndSendKey(
//                    "SIGNUP_GET_CODE_SMS",
//                    "SIGNUP_SWITCH_TO_TAB_CHECK",
//                    "SIGNUP_BTN_SUBMIT"
//            );
//        } else {
//            objSigUp.switchToTabCheck(1);
//            objSignIn.chooseItemCustomer(
//                    "LOGIN_BTN_CUSTOMER",
//                    "LOGIN_BTN_CUSTOMER",
//                    "SIGNUP_VERIFY_CUSTOMER",
//                    "LOGIN_BTN_EMAIL_LOG",
//                    "SIGNUP_VERIFY_EMAIL_LOG"
//            );
//            objSignIn.selectActionEmailLog("LOGIN_CHECK_EMAIL_LOG_ACTION_SELECT",
//                    "LOGIN_SELECT_ACTIVE",
//                    "LOGIN_SELECT_VIEW_CHECK_EMAIL_LOG",
//                    "LOGIN_POPUP_MESSAGE_PASSWORD_RESET");
//            objSignIn.getCodeEnterTextInField("LOGIN_IFRAME",
//                    "LOGIN_INPUT_VERIFY_CODE",
//                    "SIGNUP_INPUT_VERIFY_CODE", "SIGNUP_BTN_SUBMIT_ACCOUNT");
//            objSigUp.verifySignUpSuccess();
//        }
//    }
//    @Test(priority = 7, description = "Create New Account- Enter wrong format  email address")
//    public void testCase_SU06() throws InterruptedException {
//    }
//    @Test(priority = 8, description = "Create New Account- Enter wrong format  email address")
//    public void testCase_SU07() throws InterruptedException {
//    }
//    @Test(priority = 9, description = "Create New Account- Enter wrong format  email address")
//    public void testCase_SU08() throws InterruptedException {
//    }
}

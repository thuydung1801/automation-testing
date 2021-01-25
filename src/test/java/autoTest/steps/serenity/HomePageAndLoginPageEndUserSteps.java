package autoTest.steps.serenity;

import autoTest.pages.HomePageAndLoginPage;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class HomePageAndLoginPageEndUserSteps {
    HomePageAndLoginPage homePageAndLoginPage;



    public void enterAValidDateOfBirthAndValidate() {
        homePageAndLoginPage.enterAValidDateOfBirthAndValidate();
    }

    public void shouldSeeUniqueCity() {
        assertThat(homePageAndLoginPage.shouldSeeUniqueCity(), is(equalTo(true)));
    }


    public void theFieldRemainsEmpty() {
        assertThat(homePageAndLoginPage.theFieldRemainsEmpty(), is(equalTo(true)));
    }

    public void enterAInvalidDateToBirthdayField() {
        homePageAndLoginPage.enterAInvalidDateToBirthdayField();

    }

    public void insertRandomEmailForMenToEmailField() {
        homePageAndLoginPage.insertRandomEmailForMenToEmailField();
    }

    public void insertRandomUsernameForMenToUsernameField() {
        homePageAndLoginPage.insertRandomUsernameForMenToUsernameField();
    }

    public void checkIfEyeButtonWorking() {
        assertThat(homePageAndLoginPage.checkIfEyeButtonWorking(), is(equalTo(true)));
    }

    public void postalCodeFieldRemainEmpty() {
        assertThat(homePageAndLoginPage.postalCodeFieldRemainEmpty(), is(equalTo(true)));
    }

    public void tooltipZipcodeIsAppear() {
        assertThat(homePageAndLoginPage.tooltipZipcodeIsAppear(), is(equalTo(true)));
    }

    public void viewCity(int city) {
        assertThat(homePageAndLoginPage.viewCity(city), is(equalTo(true)));
    }

    public void moveTallSliderToChooseHowToTall() {
        homePageAndLoginPage.moveTallSliderToChooseHowToTall();
    }

    public void choseServeralOptionsOfQuestionInEachRegistrationForm() {
        homePageAndLoginPage.choseServeralOptionsOfQuestionInEachRegistrationForm();
    }

    public void skipAllQuestionsInEveryRegistrationForm() {
        assertThat(homePageAndLoginPage.skipAllQuestionsInEveryRegistrationForm(), is(equalTo(true)));
    }

    public void answerAllQuestionInRegistrationForm() {
        assertThat(homePageAndLoginPage.answerAllQuestionInRegistrationForm(), is(equalTo(true)));
    }

    public void checkIfDuplicateOptionOfCity() {
        assertThat(homePageAndLoginPage.checkIfDuplicateOptionOfCity(), is(equalTo(true)));
    }

    public void checkIfEyeButtonWorkingInSignupPage() {
        assertThat(homePageAndLoginPage.checkIfEyeButtonWorkingInSignupPage(), is(equalTo(true)));
    }

    public void checkIfCGUPrivateCharterLinkWorking() {
        assertThat(homePageAndLoginPage.checkIfCGUPrivateCharterLinkWorking(), is(equalTo(true)));
    }

    public void checkIfBlockButtonIsCheckedByDefault() {
        assertThat(homePageAndLoginPage.checkIfBlockButtonIsCheckedByDefault(), is(equalTo(true)));
    }

    public void clickBlockButtonToRemoveSelect() {
        homePageAndLoginPage.clickBlockButtonToRemoveSelect();
    }

    public void bothTwoButtonPasswordVisibleShouldWork() {
        assertThat(homePageAndLoginPage.bothTwoButtonPasswordVisibleShouldWork(), is(equalTo(true)));
    }

    public void checkIfPasswordVisibleButtonIsWorking() {
        assertThat(homePageAndLoginPage.checkIfPasswordVisibleButtonIsWorking(), is(equalTo(true)));
    }

    public void checkIfUploadAvatarSuccessful() {
        assertThat(homePageAndLoginPage.checkIfUploadAvatarSuccessful(), is(equalTo(true)));
    }


    public void shouldSeeErrorMsgs(String message1, String message2) {
        ArrayList<String> errorMsgs = homePageAndLoginPage.getErrorMessages();
        assertThat(errorMsgs, hasItem(containsString(message1)));
        assertThat(errorMsgs, hasItem(containsString(message2)));
    }

    public void clickOn(String textLink) {
        homePageAndLoginPage.clickOnTextLink(textLink);
    }

    public void ClickOnRéinitialiserMonMotDePasseButton() {
        homePageAndLoginPage.ClickOnRéinitialiserMonMotDePasseButton();
    }

    public void enterValidEmailAndClickOnRéinitialiserMonMotDePasseButton() {
        homePageAndLoginPage.enterValidEmailAndClickOnRéinitialiserMonMotDePasseButton();
    }

    public void donTSelectAnythingAndClickValidate() {
        homePageAndLoginPage.donTSelectAnythingAndClickValidate();
    }

    public void clickRadioButtonOfAlgérienneMarocaineTunisienne() {
        homePageAndLoginPage.clickRadioButtonOfAlgérienneMarocaineTunisienne();
    }

    public void onlyTunisienneIsClicked() {
        assertThat(homePageAndLoginPage.onlyTunisienneIsClicked(), is(equalTo(true)));
    }

    public void clickElementHasText(String text) {
        homePageAndLoginPage.clickElementHasText(text);
    }

    public void switchTab() {
        homePageAndLoginPage.switchTab();
    }

    public void leaveTheAgeFieldEmptyAndValidate() {
        homePageAndLoginPage.leaveTheAgeFieldEmptyAndValidate();
    }

    public void shouldSeePositiveValueAndAnd(String date, String month, String year) {
        ArrayList<String> realDate = homePageAndLoginPage.shouldSeeRealDate();
        assertThat(realDate, hasItem(comparesEqualTo(date)));
        ArrayList<String> realMonth = homePageAndLoginPage.shouldSeeRealMonth();
        assertThat(realMonth, hasItem(comparesEqualTo(month)));
        ArrayList<String> realYear = homePageAndLoginPage.shouldSeeRealYear();
        assertThat(realYear, hasItem(comparesEqualTo(year)));
    }

    public void enterADateOfBirthOfUserUnderEighteen() {
        homePageAndLoginPage.enterADateOfBirthOfUserUnderEighteen();
    }

    public void enterAPositiveDateOfBirth(String positiveDate) {
        homePageAndLoginPage.enterAPositiveDateOfBirth(positiveDate);
    }

    public void checkIfManAccountIsCreate() {
        homePageAndLoginPage.checkIfManAccountIsCreate();
    }


    public void logoutCurrentAccountAfterCreatedSuccessful() {
        homePageAndLoginPage.logoutCurrentAccountAfterCreatedSuccessful();
    }

    public void checkSomeAccountsToCheckIfThereAreFemaleAccount() {
        homePageAndLoginPage.checkSomeAccountsToCheckIfThereAreFemaleAccount();
    }

    public void checkSomeAccountsToCheckIfThereAreMaleAccount() {
        homePageAndLoginPage.checkSomeAccountsToCheckIfThereAreMaleAccount();
    }


    public void deleteCreatedAccount() {
        assertThat(homePageAndLoginPage.deleteCreatedAccount(), is(equalTo(true)));
    }

    public void createAWomanAccountWithEmailAndUsername(String email, String username) {
        homePageAndLoginPage.createAWomanAccountWithEmailAndUsername(email, username);
    }

    public void doTheStepsToTheSignUpScreen() {
        homePageAndLoginPage.doTheStepsToTheSignUpScreen();
    }

    public void createAManAccountWithEmailAndUsername(String email, String username) {
        homePageAndLoginPage.createAManAccountWithEmailAndUsername(email, username);
    }

    public void scrollTheTestimonials() throws AWTException {
        homePageAndLoginPage.scrollTheTestimonials();
    }

    public void thePageShowNumberOfTestimonials() {
        homePageAndLoginPage.thePageShowNumberOfTestimonials();
    }

    public void displayAllErrorAtRacontezNousVotreDestin() {
        homePageAndLoginPage.displayAllErrorAtRacontezNousVotreDestin();
    }

    public void scrollTopPage() {
        homePageAndLoginPage.scrollTopPage();
    }

    public void theFormIsClosed() {
        homePageAndLoginPage.theFormIsClosed();
    }

    public void scrollToViewThatDontClick(String element) {
        homePageAndLoginPage.scrollToViewThatDontClick(element);
    }

    public void scrollAnyPage(int height) {
        homePageAndLoginPage.scrollAnyPage(height);
    }

    public void browserShouldRedirectToAtNewTab(String targetUrl, String stt) {
        homePageAndLoginPage.browserShouldRedirectToAtNewTab(targetUrl, stt);
    }

    public void scroll() {
        homePageAndLoginPage.scroll();
    }

    public void browserShouldRedirectToAtJustOneNewTab(String url, String stt) {
        homePageAndLoginPage.browserShouldRedirectToAtJustOneNewTab(url, stt);
    }


    public void showErrorMessageInAllOrFirstOneField() {
        homePageAndLoginPage.showErrorMessageInAllOrFirstOneField();
    }

    public void enterIntoNomPrénomFieldWithValue(String value) {
        homePageAndLoginPage.enterIntoNomPrénomFieldWithValue(value);
    }


    public void shouldNotSeeMessagePopUp(String mess) {
        assertThat(homePageAndLoginPage.shouldNotSeeMessagePopUp(mess), is(equalTo(true)));
    }

    public void iEnterOnlyAlphabel(String alphabet) {
        homePageAndLoginPage.iEnterOnlyAlphabel(alphabet);
    }

    public void loginGmailAndClickLinkToResetPassword() {
        homePageAndLoginPage.loginGmailAndClickLinkToResetPassword();
    }



    public void clickToLinkSeConnecter() {
        homePageAndLoginPage.clickToLinkSeConnecter();
    }

    public void thePageShowErrorInclude(String errorMess){ homePageAndLoginPage.thePageShowErrorInclude( errorMess);}


    public void alwaysSeeNotice(String notice) {
        homePageAndLoginPage.alwaysSeeNotice(notice);
    }

    public void leavePasswordFieldEmptyAndClickSubmit() {
        homePageAndLoginPage.leavePasswordFieldEmptyAndClickSubmit();
    }

    public void leaveBothUsernameAndPasswordFieldsEmpty() {
        homePageAndLoginPage.leaveBothUsernameAndPasswordFieldsEmpty();
    }

    public void leaveUsernameFieldEmptyAndClickSubmit() {
        homePageAndLoginPage.leaveUsernameFieldEmptyAndClickSubmit();
    }

    public void displayWarning(String warningText) {
        homePageAndLoginPage.displayWarning(warningText);
    }

    public void loginBackofficeAndAddANewBlackemail(String blackemail) {
        homePageAndLoginPage.loginBackofficeAndAddANewBlackemail(blackemail);
    }

    public void createAManAccountWithBlackemail(String blackemail) {
        homePageAndLoginPage.createAManAccountWithBlackemail(blackemail);
    }

    public void createAWomanAccount() {
        homePageAndLoginPage.createAWomanAccount();
    }

    public void validateEmail() {
        homePageAndLoginPage.validateEmail();
    }

    public void createAWomanAccountWithDisposableBlackEmail(String email) {
        homePageAndLoginPage.createAWomanAccountWithDisposableBlackEmail(email);
    }
    public void createAWomanAccountWithEmailAntiUsername(String antiUsername) {
        homePageAndLoginPage.createAWomanAccountWithEmailAntiUsername(antiUsername);
    }

    public void insertAntiUsernameAndClick(String antiUsername, String button) {
        homePageAndLoginPage.insertAntiUsernameAndClick(antiUsername, button);
    }

    public void insertAntiUsernameFromListAndClickCreateAccountButton() throws FileNotFoundException {
        homePageAndLoginPage.insertAntiUsernameFromListAndClickCreateAccountButton();
    }
}

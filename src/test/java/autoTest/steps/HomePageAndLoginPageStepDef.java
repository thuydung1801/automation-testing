package autoTest.steps;

import autoTest.steps.serenity.HomePageAndLoginPageEndUserSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.awt.*;
import java.io.FileNotFoundException;

public class HomePageAndLoginPageStepDef {
    @Steps
    HomePageAndLoginPageEndUserSteps homePageAndLoginPageEndUserSteps;


    @When("^Enter a valid date of birth and validate$")
    public void enterAValidDateOfBirthAndValidate() {
        homePageAndLoginPageEndUserSteps.enterAValidDateOfBirthAndValidate();
    }

    @When("^Should see unique city$")
    public void shouldSeeUniqueCity() {
        homePageAndLoginPageEndUserSteps.shouldSeeUniqueCity();
    }



    @When("^Insert random email for men to email field$")
    public void insertRandomEmailForMenToEmailField() {
        homePageAndLoginPageEndUserSteps.insertRandomEmailForMenToEmailField();
    }

    @When("^Insert random username for men to username field$")
    public void insertRandomUsernameForMenToUsernameField() {
        homePageAndLoginPageEndUserSteps.insertRandomUsernameForMenToUsernameField();
    }

    @Then("^The field remains empty$")
    public void theFieldRemainsEmpty() {
        homePageAndLoginPageEndUserSteps.theFieldRemainsEmpty();
    }

    @When("^Enter a invalid date to birthday field$")
    public void enterAInvalidDateToBirthdayField() {
        homePageAndLoginPageEndUserSteps.enterAInvalidDateToBirthdayField();
    }

    @Then("^Check if eye button working$")
    public void checkIfEyeButtonWorking() {
        homePageAndLoginPageEndUserSteps.checkIfEyeButtonWorking();
    }

    @Then("^Postal code field remain empty$")
    public void postalCodeFieldRemainEmpty() {
        homePageAndLoginPageEndUserSteps.postalCodeFieldRemainEmpty();
    }

    @And("^Tooltip zipcode is appear$")
    public void tooltipZipcodeIsAppear() {
        homePageAndLoginPageEndUserSteps.tooltipZipcodeIsAppear();
    }

    @When("^View (\\d+) city$")
    public void viewCity(int city) {
        homePageAndLoginPageEndUserSteps.viewCity(city);
    }

    @When("^Move tall slider to choose how to tall$")
    public void moveTallSliderToChooseHowToTall() {
        homePageAndLoginPageEndUserSteps.moveTallSliderToChooseHowToTall();
    }

    @When("^Chose several options of question in each registration form$")
    public void choseSeveralOptionsOfQuestionInEachRegistrationForm() {
        homePageAndLoginPageEndUserSteps.choseServeralOptionsOfQuestionInEachRegistrationForm();
    }

    @When("^Skip all questions in every registration form$")
    public void skipAllQuestionsInEveryRegistrationForm() {
        homePageAndLoginPageEndUserSteps.skipAllQuestionsInEveryRegistrationForm();
    }

    @When("^Answer all question in Registration form$")
    public void answerAllQuestionInRegistrationForm() {
        homePageAndLoginPageEndUserSteps.answerAllQuestionInRegistrationForm();
    }

    @Then("^Check if duplicate option of city$")
    public void checkIfDuplicateOptionOfCity() {
        homePageAndLoginPageEndUserSteps.checkIfDuplicateOptionOfCity();
    }

    @Then("^Check if eye button working in signup page$")
    public void checkIfEyeButtonWorkingInSignupPage() {
        homePageAndLoginPageEndUserSteps.checkIfEyeButtonWorkingInSignupPage();
    }

    @Then("^Check if CGU/Private Charter link working$")
    public void checkIfCGUPrivateCharterLinkWorking() {
        homePageAndLoginPageEndUserSteps.checkIfCGUPrivateCharterLinkWorking();
    }

    @Then("^Check if block button is checked by default$")
    public void checkIfBlockButtonIsCheckedByDefault() {
        homePageAndLoginPageEndUserSteps.checkIfBlockButtonIsCheckedByDefault();
    }

    @When("^Click Block button to remove select$")
    public void clickBlockButtonToRemoveSelect() {
        homePageAndLoginPageEndUserSteps.clickBlockButtonToRemoveSelect();
    }

    @Then("^Both two button password visible should work$")
    public void bothTwoButtonPasswordVisibleShouldWork() {
        homePageAndLoginPageEndUserSteps.bothTwoButtonPasswordVisibleShouldWork();
    }

    @When("^Check if password visible button is working$")
    public void checkIfPasswordVisibleButtonIsWorking() {
        homePageAndLoginPageEndUserSteps.checkIfPasswordVisibleButtonIsWorking();
    }

    @When("^Check if upload avatar successful$")
    public void checkIfUploadAvatarSuccessful() {
        homePageAndLoginPageEndUserSteps.checkIfUploadAvatarSuccessful();
    }

    @Then("^Display \"([^\"]*)\" and/or \"([^\"]*)\"$")
    public void displayAndOr(String message1, String message2) {
        homePageAndLoginPageEndUserSteps.shouldSeeErrorMsgs(message1, message2);
    }

    @When("^Click on \"([^\"]*)\"$")
    public void clickOn(String textLink) {
        homePageAndLoginPageEndUserSteps.clickOn(textLink);
    }

    @When("^Leave the field blank and click on réinitialiser mon mot de passe button$")
    public void leaveTheFieldBlankAndClickOnRéinitialiserMonMotDePasseButton() {
        homePageAndLoginPageEndUserSteps.ClickOnRéinitialiserMonMotDePasseButton();
    }

    @When("^enter a valid email of an existing account and click on réinitialiser mon mot de passe button$")
    public void enterAValidEmailOfAnExistingAccountAndClickOnRéinitialiserMonMotDePasseButton() {
        homePageAndLoginPageEndUserSteps.enterValidEmailAndClickOnRéinitialiserMonMotDePasseButton();
    }

    @When("^Don't select anything and click validate$")
    public void donTSelectAnythingAndClickValidate() {
        homePageAndLoginPageEndUserSteps.donTSelectAnythingAndClickValidate();
    }

    @When("^Click radio button of Algérienne, Marocaine, Tunisienne$")
    public void clickRadioButtonOfAlgérienneMarocaineTunisienne() {
        homePageAndLoginPageEndUserSteps.clickRadioButtonOfAlgérienneMarocaineTunisienne();
    }

    @Then("^Only Tunisienne is clicked$")
    public void onlyTunisienneIsClicked() {
        homePageAndLoginPageEndUserSteps.onlyTunisienneIsClicked();
    }

    @When("^Click on element that has text \"([^\"]*)\"$")
    public void clickOnElementThatHasText(String text) {
        homePageAndLoginPageEndUserSteps.clickElementHasText(text);
    }

    @When("^Switch tab$")
    public void switchTab() {
        homePageAndLoginPageEndUserSteps.switchTab();
    }

    @When("^Leave the age field empty and validate$")
    public void leaveTheAgeFieldEmptyAndValidate() {
        homePageAndLoginPageEndUserSteps.leaveTheAgeFieldEmptyAndValidate();
    }

    @Then("^Should see positive value \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void shouldSeePositiveValueAndAnd(String date, String month, String year) {
        homePageAndLoginPageEndUserSteps.shouldSeePositiveValueAndAnd(date, month, year);
    }

    @When("^Enter a positive date of birth \"([^\"]*)\"$")
    public void enterAPositiveDateOfBirth(String positiveDate) {
        homePageAndLoginPageEndUserSteps.enterAPositiveDateOfBirth(positiveDate);
    }


    @When("^Enter a date of birth of user under eighteen$")
    public void enterADateOfBirthOfUserUnderEighteen() {
        homePageAndLoginPageEndUserSteps.enterADateOfBirthOfUserUnderEighteen();

    }


    @When("^Check if man account is create$")
    public void checkIfManAccountIsCreate() {
        homePageAndLoginPageEndUserSteps.checkIfManAccountIsCreate();
    }


    @When("^Logout current account after created successful$")
    public void logoutCurrentAccountAfterCreatedSuccessful() {
        homePageAndLoginPageEndUserSteps.logoutCurrentAccountAfterCreatedSuccessful();
    }

    @When("^Check some accounts to check if there are female account$")
    public void checkSomeAccountsToCheckIfThereAreFemaleAccount() {
        homePageAndLoginPageEndUserSteps.checkSomeAccountsToCheckIfThereAreFemaleAccount();
    }

    @When("^Check some accounts to check if there are male account$")
    public void checkSomeAccountsToCheckIfThereAreMaleAccount() {
        homePageAndLoginPageEndUserSteps.checkSomeAccountsToCheckIfThereAreMaleAccount();
    }


    @And("^Delete created account$")
    public void deleteCreatedAccount() {
        homePageAndLoginPageEndUserSteps.deleteCreatedAccount();
    }

    @When("^Create a woman account with email \"([^\"]*)\" and username \"([^\"]*)\"$")
    public void createAWomanAccountWithEmailAndUsername(String email, String username) {
        homePageAndLoginPageEndUserSteps.createAWomanAccountWithEmailAndUsername(email, username);
    }

    @When("^Do the steps to the sign up screen$")
    public void doTheStepsToTheSignUpScreen() {
        homePageAndLoginPageEndUserSteps.doTheStepsToTheSignUpScreen();
    }

    @When("^Create a man account with email \"([^\"]*)\" and username \"([^\"]*)\"$")
    public void createAManAccountWithEmailAndUsername(String email, String username) {
        homePageAndLoginPageEndUserSteps.createAManAccountWithEmailAndUsername(email, username);
    }

    @When("^Scroll the testimonials$")
    public void scrollTheTestimonials() throws AWTException {
        homePageAndLoginPageEndUserSteps.scrollTheTestimonials();
    }

    @Then("^The page show number of testimonials$")
    public void thePageShowNumberOfTestimonials() {
        homePageAndLoginPageEndUserSteps.thePageShowNumberOfTestimonials();
    }

    @Then("^Display all error at Racontez-nous votre destin$")
    public void displayAllErrorAtRacontezNousVotreDestin() {
        homePageAndLoginPageEndUserSteps.displayAllErrorAtRacontezNousVotreDestin();
    }

    @When("^Scroll top page$")
    public void scrollTopPage() {
        homePageAndLoginPageEndUserSteps.scrollTopPage();
    }

    @Then("^The form is closed$")
    public void theFormIsClosed() {
        homePageAndLoginPageEndUserSteps.theFormIsClosed();
    }

    @When("^scroll to view \"([^\"]*)\" that dont click$")
    public void scrollToViewThatDontClick(String element) {
        homePageAndLoginPageEndUserSteps.scrollToViewThatDontClick(element);
    }

    @When("^Scroll Any Page \"([^\"]*)\"$")
    public void scrollAnyPage(int height) {
        homePageAndLoginPageEndUserSteps.scrollAnyPage(height);
    }

    @Then("^Browser should redirect to \"([^\"]*)\" at \"([^\"]*)\" \\(new tab\\)$")
    public void browserShouldRedirectToAtNewTab(String targetUrl, String stt) {
        homePageAndLoginPageEndUserSteps.browserShouldRedirectToAtNewTab(targetUrl, stt);
    }

    @When("^scroll$")
    public void scroll() {
        homePageAndLoginPageEndUserSteps.scroll();
    }

    @Then("^Browser should redirect to \"([^\"]*)\" at \"([^\"]*)\" \\(just one new tab\\)$")
    public void browserShouldRedirectToAtJustOneNewTab(String url, String stt) {
        homePageAndLoginPageEndUserSteps.browserShouldRedirectToAtJustOneNewTab(url, stt);
    }


    @Then("^Show error message in all or first one field$")
    public void showErrorMessageInAllOrFirstOneField() {
        homePageAndLoginPageEndUserSteps.showErrorMessageInAllOrFirstOneField();
    }

    @And("^Enter into Nom / Prénom field with value \"([^\"]*)\"$")
    public void enterIntoNomPrénomFieldWithValue(String value) {
        homePageAndLoginPageEndUserSteps.enterIntoNomPrénomFieldWithValue(value);
    }


    @When("^Should not see message pop up \"([^\"]*)\"$")
    public void shouldNotSeeMessagePopUp(String mess) {
        homePageAndLoginPageEndUserSteps.shouldNotSeeMessagePopUp(mess);
    }


    @When("^I enter only alphabel \"([^\"]*)\"$")
    public void iEnterOnlyAlphabel(String alphabet) {
        homePageAndLoginPageEndUserSteps.iEnterOnlyAlphabel(alphabet);
    }

    @When("^Login gmail and click link to reset password$")
    public void loginGmailAndClickLinkToResetPassword() {
        homePageAndLoginPageEndUserSteps.loginGmailAndClickLinkToResetPassword();
    }

    @When("^Click to link Se connecter$")
    public void clickToLinkSeConnecter() {
        homePageAndLoginPageEndUserSteps.clickToLinkSeConnecter();
    }


    @Then("^The page show error include \"([^\"]*)\"$")
    public void thePageShowErrorInclude(String errorMess) throws Throwable {
        homePageAndLoginPageEndUserSteps.thePageShowErrorInclude( errorMess);
    }

    @When("^Always see notice \"([^\"]*)\"$")
    public void alwaysSeeNotice(String notice) {
        homePageAndLoginPageEndUserSteps.alwaysSeeNotice(notice);
    }

    @When("^Leave password field empty and click submit$")
    public void leavePasswordFieldEmptyAndClickSubmit() {
        homePageAndLoginPageEndUserSteps.leavePasswordFieldEmptyAndClickSubmit();
    }

    @When("^Leave both username and password fields empty$")
    public void leaveBothUsernameAndPasswordFieldsEmpty() {
        homePageAndLoginPageEndUserSteps.leaveBothUsernameAndPasswordFieldsEmpty();
    }

    @When("^Leave username field empty and click submit$")
    public void leaveUsernameFieldEmptyAndClickSubmit() {
        homePageAndLoginPageEndUserSteps.leaveUsernameFieldEmptyAndClickSubmit();
    }

    @Then("^Display warning \"([^\"]*)\"$")
    public void displayWarning(String warningText)  {
        homePageAndLoginPageEndUserSteps.displayWarning(warningText);
    }

    @When("^Login backoffice and add a new blackemail \"([^\"]*)\"$")
    public void loginBackofficeAndAddANewBlackemail(String blackemail) {
        homePageAndLoginPageEndUserSteps.loginBackofficeAndAddANewBlackemail(blackemail);
    }

    @When("^Create a woman account$")
    public void createAWomanAccount() {
        homePageAndLoginPageEndUserSteps.createAWomanAccount();
    }

    @When("^Validate email$")
    public void validateEmail() {
        homePageAndLoginPageEndUserSteps.validateEmail();
    }

    @When("^Create a woman account with disposable/black email \"([^\"]*)\"$")
    public void createAWomanAccountWithDisposableBlackEmail(String email) {
        homePageAndLoginPageEndUserSteps.createAWomanAccountWithDisposableBlackEmail(email);
    }
    @When("^Create a woman account with email anti username \"([^\"]*)\"$")
    public void createAWomanAccountWithEmailAntiUsername(String antiUsername) {
        homePageAndLoginPageEndUserSteps.createAWomanAccountWithEmailAntiUsername(antiUsername);
    }

    @When("^Insert anti username \"([^\"]*)\" and click \"([^\"]*)\"$")
    public void insertAntiUsernameAndClick(String antiUsername, String button) {
        homePageAndLoginPageEndUserSteps.insertAntiUsernameAndClick(antiUsername, button);
    }

    @When("^Insert anti username from list and click create account button$")
    public void insertAntiUsernameFromListAndClickCreateAccountButton() throws FileNotFoundException {
        homePageAndLoginPageEndUserSteps.insertAntiUsernameFromListAndClickCreateAccountButton();
    }
}

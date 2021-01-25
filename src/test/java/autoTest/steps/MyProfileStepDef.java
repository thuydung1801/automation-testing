package autoTest.steps;

import autoTest.steps.serenity.MyProfileEndUserSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.awt.*;
import java.io.FileNotFoundException;
import java.text.ParseException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class MyProfileStepDef {
    @Steps
    MyProfileEndUserSteps myProfileEndUserSteps;

    @When("^Upload picture again$")

    public void uploadPictureAgain() throws AWTException {
        myProfileEndUserSteps.uploadPictureAgain();
    }

    @When("^Remove account from black list$")
    public void removeAccountFromBlackList() {
        myProfileEndUserSteps.removeAccountFromBlackList();
    }

    @Then("^Statistic should be correct$")
    public void statisticShouldBeCorrect() {
        myProfileEndUserSteps.statisticShouldBeCorrect();
    }

    @When("^Button password visible should work$")
    public void buttonPasswordVisibleShouldWork() {
        myProfileEndUserSteps.buttonPasswordVisibleShouldWork();
    }

    @Then("^Setting modal is closed$")
    public void settingModalIsClosed() {
        myProfileEndUserSteps.settingModalIsClosed();
    }

    @Then("^Should see modal explanation of the photo filter$")
    public void shouldSeeModalExplanationOfThePhotoFilter() {
        myProfileEndUserSteps.shouldSeeModalExplanationOfThePhotoFilter();
    }

    @And("^Button filter photo remain turn off$")
    public void buttonFilterPhotoRemainTurnOff() {
        myProfileEndUserSteps.buttonFilterPhotoRemainTurnOff();
    }


    @When("^Active photo filter button$")
    public void activePhotoFilterButton() {
        myProfileEndUserSteps.activePhotoFilterButton();
    }

    @Then("^Should see Modal explain about need to add photo$")
    public void shouldSeeModalExplainAboutNeedToAddPhoto() {
        myProfileEndUserSteps.shouldSeeModalExplainAboutNeedToAddPhoto();
    }

    @When("^Deactive photo filter button$")
    public void deactivePhotoFilterButton() {
        myProfileEndUserSteps.deactivePhotoFilterButton();
    }

    @When("^Should see text area is disable$")
    public void shouldSeeTextAreaIsDisable() {
        myProfileEndUserSteps.shouldSeeTextAreaIsDisable();
    }

    @And("^Check if information we selected is displayed correctly in Profile$")
    public void checkIfInformationWeSelectedIsDisplayedCorrectlyInProfile() {
        myProfileEndUserSteps.checkIfInformationWeSelectedIsDisplayedCorrectlyInProfile();
    }

    @When("^Leave all edit profile fields empty and click validate$")
    public void leaveAllEditProfileFieldsEmptyAndClickValidate() {
        myProfileEndUserSteps.leaveAllEditProfileFieldsEmptyAndClickValidate();
    }

    @When("^Fill all my profile empty fields$")
    public void fillAllMyProfileEmptyFields() {
        myProfileEndUserSteps.fillAllEmptyFields();

    }

    @When("^Edit my profile again$")
    public void editMyProfileAgain() {
        myProfileEndUserSteps.editMyProfileAgain();
    }


    @And("^Fill all my criteria empty fields$")
    public void fillAllMyCriteriaEmptyFields() {
        myProfileEndUserSteps.fillAllMyCriteriaEmptyFields();
    }

    @And("^Check if information about My criteria we selected is displayed correctly in Profile$")
    public void checkIfInformationAboutMyCriteriaWeSelectedIsDisplayedCorrectlyInProfile() {
        myProfileEndUserSteps.checkInfomationAboutMyCriteria();
    }

    @And("^Edit my criteria again$")
    public void editMyCriteriaAgain() {
        myProfileEndUserSteps.editMyCriteriaAgain();
    }


    @When("^Leave all edit criteria fields empty and click validate$")
    public void leaveAllEditCriteriaFieldsEmptyAndClickValidate() {
        myProfileEndUserSteps.leaveAllEditCriteriaFieldsEmptyAndClickValidate();
    }

    @When("^Active age filter from \"([^\"]*)\" to \"([^\"]*)\"$")
    public void activeAgeFilterFromTo(int minAge, int maxAge) {
        myProfileEndUserSteps.activeAgeFilterFromTo(minAge, maxAge);
    }

    @When("^Delete \"([^\"]*)\" from favorites list$")
    public void deleteFromFavoritesList(String name) {
        myProfileEndUserSteps.deleteFromFavoritesList(name);
    }

    @When("^Upload picture \"([^\"]*)\" from library in computer$")
    public void uploadPictureFromLibraryInComputer(String picture) throws AWTException {
        myProfileEndUserSteps.uploadPictureFromLibraryInComputer(picture);
    }

    @When("^Deactive age filter$")
    public void deactiveAgeFilter() {
        myProfileEndUserSteps.deactiveAgeFilter();
    }

    @When("^Check if content of alert text about age filter is correct$")
    public void checkIfContentOfAlertTextAboutAgeFilterIsCorrect() {
        myProfileEndUserSteps.checkIfContentOfAlertTextAboutAgeFilterIsCorrect();
    }

    @Then("^Should not see smile, visit notification of \"([^\"]*)\"$")
    public void shouldNotSeeSmileVisitNotificationOf(String user) throws AWTException {
        myProfileEndUserSteps.shouldNotSeeSmileVisitNotificationOf(user);
    }

    @When("^Check number of visit, smile notification$")
    public void checkNumberOfVisitSmileNotification() throws AWTException {
        myProfileEndUserSteps.checkNumberOfVisitSmileNotification();
    }

    @And("^Should not see contact request notification of \"([^\"]*)\"$")
    public void shouldNotSeeContactRequestNotificationOf(String userName) throws AWTException {
        myProfileEndUserSteps.shouldNotSeeContactRequestNotificationOf(userName);

    }

    @When("^Check if content of alert text about age filter is already disapear$")
    public void checkIfContentOfAlertTextAboutAgeFilterIsAlreadyDisapear() {
        myProfileEndUserSteps.ContentOfAlertTextAboutAgeFilterIsAlreadyDisapear();
    }

    @When("^Check number of messages$")
    public void checkNumberOfMessages() throws AWTException {
        myProfileEndUserSteps.checkNumberOfMessages();
    }


    @And("^Should not see message of \"([^\"]*)\"$")
    public void shouldNotSeeMessageOf(String user) throws Throwable {
        myProfileEndUserSteps.shouldNotSeeMessageOf(user);
    }

    @When("^Turn off library window$")
    public void turnOffLibraryWindow() throws AWTException {
        myProfileEndUserSteps.turnOffLibraryWindow();

    }

    @When("^Should see warning-message about Photo refuse$")
    public void shouldSeeWarningMessageAboutPhotoRefuse() {
        myProfileEndUserSteps.SeeWarningMessageAboutPhotoRefuse();
    }

    @When("^Should see stop icon on rejected photo$")
    public void shouldSeeStopIconOnRejectedPhoto() {
        myProfileEndUserSteps.shouldSeeStopIconOnRejectedPhoto();
    }

    @When("^Upload file from library in computer$")
    public void uploadFileFromLibraryInComputer() throws AWTException {
        myProfileEndUserSteps.uploadFileFromLibraryInComputer();
    }

    @When("^Upload picture \"([^\"]*)\" to under approval process$")
    public void uploadPictureToUnderApprovalProcess(String picture) throws AWTException {
        myProfileEndUserSteps.uploadPictureToUnderApprovalProcess(picture);
    }

    @When("^Insert and completely erases My Introduction in profile$")
    public void insertAndCompletelyErasesMyIntroductionInProfile() {
        myProfileEndUserSteps.insertAndCompletelyErasesMyIntroductionInProfile();
    }

    @When("^Deactive age filter and log out$")
    public void deactiveAgeFilterAndLogOut() {
        myProfileEndUserSteps.deactiveAgeFilterAndLogOut();

    }


    @When("^Active age filter from \"([^\"]*)\" to \"([^\"]*)\" and log out$")
    public void activeAgeFilterFromToAndLogOut(int minAge, int maxAge) {
        myProfileEndUserSteps.activeAgeFilterFromToAndLogOut(minAge, maxAge);
    }


    @When("^Change passwword from \"([^\"]*)\" to \"([^\"]*)\" and logout$")
    public void changePasswwordFromToAndLogout(String passWord1, String passWord2) {
        myProfileEndUserSteps.changePasswwordFromToAndLogout(passWord1, passWord2);
    }


    @Then("^Can login with new password \"([^\"]*)\"$")
    public void canLoginWithNewPassword(String newPassWord) {
        myProfileEndUserSteps.canLoginWithNewPassword(newPassWord);
    }


    @When("^Login with old passwword \"([^\"]*)\"$")
    public void loginWithOldPasswword(String oldPassWord) {
        myProfileEndUserSteps.loginWithOldPasswword(oldPassWord);
    }


    @When("^Send smile and contact request to \"([^\"]*)\" when age filter is active$")
    public void sendSmileAndContactRequestToWhenAgeFilterIsActive(String womanAccount) {
        myProfileEndUserSteps.sendSmileAndContactRequestToWhenAgeFilterIsActive(womanAccount);
    }

    @When("^Send smile and contact request to \"([^\"]*)\" when age filter is deactive$")
    public void sendSmileAndContactRequestToWhenAgeFilterIsDeactive(String womanAccount) {
        myProfileEndUserSteps.sendSmileAndContactRequestToWhenAgeFilterIsDeactive(womanAccount);
    }

    @When("^Send message to \"([^\"]*)\"$")
    public void sendMessageTo(String userName) {
        myProfileEndUserSteps.sendMessageTo(userName);
    }

    @When("^Smile with \"([^\"]*)\"$")
    public void smileWith(String userName) {
        myProfileEndUserSteps.smileWith(userName);
    }

    @When("^Send message and smile to \"([^\"]*)\" when age filter is active$")
    public void sendMessageAndSmileToWhenAgeFilterIsActive(String userAccount) {
        myProfileEndUserSteps.sendMessageAndSmileToWhenAgeFilterIsActive(userAccount);
    }

    @When("^Send smile and message to \"([^\"]*)\" when age filter is deactive$")
    public void sendSmileAndMessageToWhenAgeFilterIsDeactive(String userAccount) {
        myProfileEndUserSteps.sendSmileAndMessageToWhenAgeFilterIsDeactive(userAccount);
    }

    @When("^Should see message with \"([^\"]*)\"$")
    public void shouldSeeMessageWith(String userName) {
        myProfileEndUserSteps.shouldSeeMessageWith(userName);
    }

    @When("^Should see smile, visit notification of \"([^\"]*)\"$")
    public void shouldSeeSmileVisitNotificationOf(String userName) {
        myProfileEndUserSteps.shouldSeeSmileVisitNotificationOf(userName);
    }

    @When("^Discuss with \"([^\"]*)\"$")
    public void discussWith(String userName) {
        myProfileEndUserSteps.discussWith(userName);
    }

    @When("^Make sure Blacklist do not contain account \"([^\"]*)\" we will going to be searching$")
    public void makeSureBlacklistDoNotContainAccountWeWillGoingToBeSearching(String account) {
        myProfileEndUserSteps.makeSureBlacklistDoNotContainAccountWeWillGoingToBeSearching(account);
    }

    @And("^Should not see account \"([^\"]*)\" in blacklist$")
    public void shouldNotSeeAccountInBlacklist(String account) {
        myProfileEndUserSteps.shouldNotSeeAccountInBlacklist(account);
    }

    @When("^Make sure age filter of man account \"([^\"]*)\" still remain turn off$")
    public void makeSureAgeFilterOfManAccountStillRemainTurnOff(String username) {
        myProfileEndUserSteps.makeSureAgeFilterOfManAccountStillRemainTurnOff(username);
    }

    @Then("^Should see red border in password and new email fields$")
    public void shouldSeeRedBorderInPasswordAndNewEmailFields() {
        myProfileEndUserSteps.shouldSeeRedBorderInPasswordAndNewEmailFields();
    }

    @Then("^Check if Warning confirm email exist$")
    public void checkIfWarningConfirmEmailExist() {
        myProfileEndUserSteps.checkIfWarningConfirmEmailExist();
    }

    @When("^Verify confirm Email link$")
    public void verifyConfirmEmailLink() {
        myProfileEndUserSteps.verifyConfirmEmailLink();
    }

    @Then("^See his favorites online - the case existing profiles online$")
    public void seeHisFavoritesOnlineTheCaseExistingProfilesOnline() {
        myProfileEndUserSteps.seeHisFavoritesOnlineTheCaseExistingProfilesOnline();
    }

    @Then("^See his favorites online - the case no profile online$")
    public void seeHisFavoritesOnlineTheCaseNoProfileOnline() {
        myProfileEndUserSteps.seeHisFavoritesOnlineTheCaseNoProfileOnline();
    }

    @Then("^Visiting a profile from the favorites page$")
    public void visitingAProfileFromTheFavoritesPage() {
        myProfileEndUserSteps.visitingAProfileFromTheFavoritesPage();
    }

    @Then("^Showing error message this profile already in your favorites$")
    public void showingErrorMessageThisProfileAlreadyInYourFavorites() { myProfileEndUserSteps.showingErrorMessageThisProfileAlreadyInYourFavorites();
    }

    @When("^Remove first profile from favoris list$")
    public void removeFirstProfileFromFavorisList() { myProfileEndUserSteps.removeFirstProfileFromFavorisList();
    }

    @Then("^The favoris list do not show above profile$")
    public void theFavorisListDoNotShowAboveProfile() { myProfileEndUserSteps. theFavorisListDoNotShowAboveProfile();
    }

    @Then("^The page shows \"([^\"]*)\" error message$")
    public void thePageShowsErrorMessage(String value) {
        myProfileEndUserSteps.thePageShowsErrorMessage(value);
    }

    @When("^Click on first profile in discovery$")
    public void clickOnFirstProfileInDiscovery() { myProfileEndUserSteps.clickOnFirstProfileInDiscovery();
    }

    @Then("^Checking above profile have to in favorite list$")
    public void checkingAboveProfileHaveToInFavoriteList() { myProfileEndUserSteps.checkingAboveProfileHaveToInFavoriteList();
    }

    @Then("^The discovery page dont show \"([^\"]*)\"$")
    public void theDiscoveryPageDontShow(String name)  {
        myProfileEndUserSteps.theDiscoveryPageDontShow(name);
    }

    @Then("^Display BlackList$")
    public void displayBlackList() {
        myProfileEndUserSteps.displayBlackList();
    }

    @When("^Click to one conversation$")
    public void clickToOneConversation() { myProfileEndUserSteps.clickToOneConversation();
    }

    @Then("^Check blocked result$")
    public void checkBlockedResult() throws Exception { myProfileEndUserSteps.checkBlockedResult();
    }

    @When("^Click first person in discovery$")
    public void clickFirstPersonInDiscovery() { myProfileEndUserSteps.clickFirstPersonInDiscovery();
    }

    @Then("^The page show notification The block is confirmed$")
    public void thePageShowNotificationTheBlockIsConfirmed() { myProfileEndUserSteps.thePageShowNotificationTheBlockIsConfirmed();
    }

    @Then("^The block list have to store above profile$")
    public void theBlockListHaveToStoreAboveProfile() { myProfileEndUserSteps.theBlockListHaveToStoreAboveProfile();
    }

    @Then("^Check unblocked result$")
    public void checkUnblockedResult() { myProfileEndUserSteps.checkUnblockedResult();
    }

    @When("^Disable age filter$")
    public void disableAgeFilter() { myProfileEndUserSteps.disableAgeFilter();
    }

    @Then("^The page dont show a person who is blocking us$")
    public void thePageDontShowAPersonWhoIsBlockingUs() { myProfileEndUserSteps.thePageDontShowAPersonWhoIsBlockingUs();
    }

    @Then("^All profile dont show notification box$")
    public void allProfileDontShowNotificationBox() { myProfileEndUserSteps.allProfileDontShowNotificationBox();
    }

    @When("^Enable age filter$")
    public void enableAgeFilter() { myProfileEndUserSteps.enableAgeFilter();
    }

    @Then("^The page show green alert$")
    public void thePageShowGreenAlert() { myProfileEndUserSteps.thePageShowGreenAlert();
    }

    @Then("^The page dont have \"([^\"]*)\"$")
    public void thePageDontHave(String element) {
        myProfileEndUserSteps. thePageDontHave( element);
    }

    @Then("^Can not send message$")
    public void canNotSendMessage() { myProfileEndUserSteps.canNotSendMessage();
    }

    @Then("^The page show pop up to choose age range$")
    public void thePageShowPopUpToChooseAgeRange() { myProfileEndUserSteps.thePageShowPopUpToChooseAgeRange();
    }

    @Then("^Age filter info do not change$")
    public void ageFilterInfoDoNotChange() { myProfileEndUserSteps.ageFilterInfoDoNotChange();
    }

    @When("^Click a man profile who is out of my filter$")
    public void clickAManProfileWhoIsOutOfMyFilter() { myProfileEndUserSteps.clickAManProfileWhoIsOutOfMyFilter();
    }

    @When("^Visit a man profile \\(who is out of my filter\\) and whose birthday is$")
    public void visitAManProfileWhoIsOutOfMyFilterAndWhoseBirthdayIs() { myProfileEndUserSteps.visitAManProfileWhoIsOutOfMyFilterAndWhoseBirthdayIs();
    }

    @Then("^Should see red border in Message field$")
    public void shouldSeeRedBorderInMessageField() {
        myProfileEndUserSteps.shouldSeeRedBorderInMessageField();
    }

    @Then("^Setting \"([^\"]*)\" is closed$")
    public void settingIsClosed(String modal)  {
        myProfileEndUserSteps.settingIsClosed(modal);
    }

    @When("^Change setting of notification$")
    public void changeSettingOfNotification() {
        myProfileEndUserSteps.changeSettingOfNotification();
    }

    @Then("^Edit nickname and check new nickname$")
    public void editNicknameAndCheckNewNickname() {
        myProfileEndUserSteps.editNicknameAndCheckNewNickname();
    }

    @When("^Insert anti username from list and click validate$")
    public void insertAntiUsernameFromListAndClickValidate() throws FileNotFoundException {
        myProfileEndUserSteps.insertAntiUsernameFromListAndClickValidate();
    }
}

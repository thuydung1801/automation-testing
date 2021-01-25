package autoTest.steps.serenity;

import autoTest.model.Statistic;
import autoTest.pages.MyProfileModule;

import java.awt.*;
import java.io.FileNotFoundException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MyProfileEndUserSteps {
    MyProfileModule myProfileModule;

    public void uploadPictureAgain() throws AWTException {
        myProfileModule.uploadPictureAgain();

    }

    public void removeAccountFromBlackList() {
        myProfileModule.removeAccountFromBlackList();
    }

    public void statisticShouldBeCorrect() {
        Statistic displayStatistic = myProfileModule.getStatisticFromHTML();
        Statistic apiStatistic = myProfileModule.getStatisticFromAPI();
        assertThat(displayStatistic.getSmileCount(), comparesEqualTo(apiStatistic.getSmileCount()));
        assertThat(displayStatistic.getViewCount(), comparesEqualTo(apiStatistic.getViewCount()));
        assertThat(displayStatistic.getOnlineFavouriteCount(), comparesEqualTo(apiStatistic.getOnlineFavouriteCount()));
    }

    public void buttonPasswordVisibleShouldWork() {
        assertThat(myProfileModule.buttonPasswordVisibleShouldWork(), is(equalTo(true)));
    }

    public void settingModalIsClosed() {
        assertThat(myProfileModule.settingModalIsClosed(), is(equalTo(true)));
    }

    public void shouldSeeModalExplanationOfThePhotoFilter() {
        assertThat(myProfileModule.shouldSeeModalExplanationOfThePhotoFilter(), is(equalTo(true)));
    }

    public void buttonFilterPhotoRemainTurnOff() {
        assertThat(myProfileModule.buttonFilterPhotoRemainTurnOff(), is(equalTo(true)));
    }

    public void activePhotoFilterButton() {
        assertThat(myProfileModule.activePhotoFilterButton(), is(equalTo(true)));
    }

    public void shouldSeeModalExplainAboutNeedToAddPhoto() {
        assertThat(myProfileModule.shouldSeeModalExplainAboutNeedToAddPhoto(), is(equalTo(true)));
    }

    public void deactivePhotoFilterButton() {
        assertThat(myProfileModule.deactivePhotoFilterButton(), is(equalTo(true)));
    }

    public void shouldSeeTextAreaIsDisable() {
        assertThat(myProfileModule.shouldSeeTextAreaIsDisable(), is(equalTo(true)));
    }

    public void checkIfInformationWeSelectedIsDisplayedCorrectlyInProfile() {
        assertThat(myProfileModule.checkIfInformationWeSelectedIsDisplayedCorrectlyInProfile(), is(equalTo(true)));
    }

    public void leaveAllEditProfileFieldsEmptyAndClickValidate() {
        assertThat(myProfileModule.leaveAllEditProfileFieldsEmptyAndClickValidate(), is(equalTo(true)));
    }

    public void fillAllEmptyFields() {
        assertThat(myProfileModule.fillAllEmptyFields(), is(equalTo(true)));
    }

    public void editMyProfileAgain() {
        assertThat(myProfileModule.editMyProfileAgain(), is(equalTo(true)));
    }

    public void fillAllMyCriteriaEmptyFields() {
        assertThat(myProfileModule.fillAllMyCriteriaEmptyFields(), is(equalTo(true)));
    }

    public void checkInfomationAboutMyCriteria() {
        assertThat(myProfileModule.checkInfomationAboutMyCriteria(), is(equalTo(true)));
    }

    public void editMyCriteriaAgain() {
        assertThat(myProfileModule.editMyCriteriaAgain(), is(equalTo(true)));
    }

    public void leaveAllEditCriteriaFieldsEmptyAndClickValidate() {
        assertThat(myProfileModule.leaveAllEditCriteriaFieldsEmptyAndClickValidate(), is(equalTo(true)));
    }

    public void activeAgeFilterFromTo(int minAge, int maxAge) {
        assertThat(myProfileModule.activeAgeFilterFromTo(minAge, maxAge), is(equalTo(true)));
    }

    public void deleteFromFavoritesList(String name) {
        myProfileModule.deleteFromFavoritesList(name);
    }

    public void uploadPictureFromLibraryInComputer(String picture) throws AWTException {
        myProfileModule.uploadPictureFromLibraryInComputer(picture);
    }

    public void deactiveAgeFilter() {
        assertThat(myProfileModule.deactiveAgeFilter(), is(equalTo(true)));
    }

    public void checkIfContentOfAlertTextAboutAgeFilterIsCorrect() {
        assertThat(myProfileModule.checkIfContentOfAlertTextAboutAgeFilterIsCorrect(), is(equalTo(true)));
    }

    public void shouldNotSeeSmileVisitNotificationOf(String user) throws AWTException {
        assertThat(myProfileModule.shouldNotSeeSmileVisitNotificationOf(user), is(equalTo(true)));
    }

    public void checkNumberOfVisitSmileNotification() throws AWTException {
        myProfileModule.checkNumberOfVisitSmileNotification();
    }

    public void shouldNotSeeContactRequestNotificationOf(String userName) throws AWTException {
        assertThat(myProfileModule.shouldNotSeeContactRequestNotificationOf(userName), is(equalTo(true)));
    }

    public void ContentOfAlertTextAboutAgeFilterIsAlreadyDisapear() {
        assertThat(myProfileModule.ContentOfAlertTextAboutAgeFilterIsAlreadyDisapear(), is(equalTo(true)));
    }


    public void checkNumberOfMessages() throws AWTException {
        myProfileModule.checkNumberOfMessages();
    }

    public void shouldNotSeeMessageOf(String user) throws AWTException {
        assertThat(myProfileModule.shouldNotSeeMessageOf(user), is(equalTo(true)));
    }

    public void turnOffLibraryWindow() throws AWTException {
        myProfileModule.turnOffLibraryWindow();
    }

    public void SeeWarningMessageAboutPhotoRefuse() {
        assertThat(myProfileModule.SeeWarningMessageAboutPhotoRefuse(), is(equalTo(true)));
    }

    public void shouldSeeStopIconOnRejectedPhoto() {
        assertThat(myProfileModule.shouldSeeStopIconOnRejectedPhoto(), is(equalTo(true)));
    }

    public void uploadFileFromLibraryInComputer() throws AWTException {
        myProfileModule.uploadFileFromLibraryInComputer();
    }

    public void uploadPictureToUnderApprovalProcess(String picture) throws AWTException {
        myProfileModule.uploadPictureToUnderApprovalProcess(picture);
    }

    public void insertAndCompletelyErasesMyIntroductionInProfile() {
        myProfileModule.insertAndCompletelyErasesMyIntroductionInProfile();

    }

    public void deactiveAgeFilterAndLogOut() {
        myProfileModule.deactiveAgeFilterAndLogOut();
    }


    public void activeAgeFilterFromToAndLogOut(int minAge, int maxAge) {
        myProfileModule.activeAgeFilterFromToAndLogOut(minAge, maxAge);
    }

    public void changePasswwordFromToAndLogout(String passWord1, String passWord2) {
        myProfileModule.changePasswwordFromToAndLogout(passWord1, passWord2);
    }

    public void canLoginWithNewPassword(String newPassWord) {
        myProfileModule.canLoginWithNewPassword(newPassWord);
    }

    public void loginWithOldPasswword(String oldPassWord) {
        myProfileModule.loginWithOldPasswword(oldPassWord);
    }


    public void sendSmileAndContactRequestToWhenAgeFilterIsActive(String womanAccount) {
        myProfileModule.sendSmileAndContactRequestToWhenAgeFilterIsActive(womanAccount);
    }

    public void sendSmileAndContactRequestToWhenAgeFilterIsDeactive(String womanAccount) {
        assertThat(myProfileModule.sendSmileAndContactRequestToWhenAgeFilterIsDeactive(womanAccount), is(equalTo(true)));
    }

    public void sendMessageTo(String userName) {
        myProfileModule.sendMessageTo(userName);
    }

    public void smileWith(String userName) {
        myProfileModule.smileWith(userName);
    }

    public void sendMessageAndSmileToWhenAgeFilterIsActive(String userAccount) {
        myProfileModule.sendMessageAndSmileToWhenAgeFilterIsActive(userAccount);
    }

    public void sendSmileAndMessageToWhenAgeFilterIsDeactive(String userAccount) {
        myProfileModule.sendSmileAndMessageToWhenAgeFilterIsDeactive(userAccount);
    }

    public void shouldSeeMessageWith(String userName) {
        assertThat(myProfileModule.shouldSeeMessageWith(userName), is(equalTo(true)));
    }

    public void shouldSeeSmileVisitNotificationOf(String userName) {
        assertThat(myProfileModule.shouldSeeSmileVisitNotificationOf(userName), is(equalTo(true)));
    }

    public void discussWith(String userName) {
        myProfileModule.discussWith(userName);
    }

    public void makeSureBlacklistDoNotContainAccountWeWillGoingToBeSearching(String account) {
        myProfileModule.makeSureBlacklistDoNotContainAccountWeWillGoingToBeSearching(account);
    }

    public void shouldNotSeeAccountInBlacklist(String account) {
        assertThat(myProfileModule.shouldNotSeeAccountInBlacklist(account), is(equalTo(true)));
    }

    public void makeSureAgeFilterOfManAccountStillRemainTurnOff(String username) {
        myProfileModule.makeSureAgeFilterOfManAccountStillRemainTurnOff(username);
    }

    public void shouldSeeRedBorderInPasswordAndNewEmailFields() {
        assertThat(myProfileModule.shouldSeeRedBorderInPasswordAndNewEmailFields(), is(equalTo(true)));
    }

//    public void verifyLinkConfirmEmail() {
//        myProfileModule.verifyLinkConfirmEmail();
//    }

    public void checkIfWarningConfirmEmailExist() {
        assertThat(myProfileModule.checkIfWarningConfirmEmailExist(), is(equalTo(true)));
    }


    public void verifyConfirmEmailLink() {
        myProfileModule.verifyConfirmEmailLink();
    }

    public void seeHisFavoritesOnlineTheCaseExistingProfilesOnline(){
        myProfileModule.seeHisFavoritesOnlineTheCaseExistingProfilesOnline();
    }

    public void seeHisFavoritesOnlineTheCaseNoProfileOnline(){ myProfileModule.seeHisFavoritesOnlineTheCaseNoProfileOnline();}

    public void visitingAProfileFromTheFavoritesPage(){ myProfileModule.visitingAProfileFromTheFavoritesPage() ;}

    public void showingErrorMessageThisProfileAlreadyInYourFavorites(){
        myProfileModule.showingErrorMessageThisProfileAlreadyInYourFavorites();
    }

    public void removeFirstProfileFromFavorisList(){ myProfileModule.removeFirstProfileFromFavorisList();}

    public void  theFavorisListDoNotShowAboveProfile(){ myProfileModule. theFavorisListDoNotShowAboveProfile();}

    public void thePageShowsErrorMessage(String value){ myProfileModule.thePageShowsErrorMessage(value) ;}

    public void clickOnFirstProfileInDiscovery(){ myProfileModule.clickOnFirstProfileInDiscovery();}

    public void checkingAboveProfileHaveToInFavoriteList(){ myProfileModule.checkingAboveProfileHaveToInFavoriteList();}

    public void theDiscoveryPageDontShow(String name){ myProfileModule.theDiscoveryPageDontShow(name);}

    public void displayBlackList(){ myProfileModule.displayBlackList();}

    public void clickToOneConversation(){ myProfileModule.clickToOneConversation();}

    public void checkBlockedResult() throws Exception { myProfileModule.checkBlockedResult();}

    public void clickFirstPersonInDiscovery(){ myProfileModule.clickFirstPersonInDiscovery();}

    public void thePageShowNotificationTheBlockIsConfirmed(){ myProfileModule.thePageShowNotificationTheBlockIsConfirmed();}

    public void theBlockListHaveToStoreAboveProfile(){ myProfileModule.theBlockListHaveToStoreAboveProfile();}

    public void checkUnblockedResult(){ myProfileModule.checkUnblockedResult();}

    public void disableAgeFilter(){ myProfileModule.disableAgeFilter();}

    public void thePageDontShowAPersonWhoIsBlockingUs(){ myProfileModule.thePageDontShowAPersonWhoIsBlockingUs();}

    public void allProfileDontShowNotificationBox(){ myProfileModule.allProfileDontShowNotificationBox();}

    public void enableAgeFilter(){ myProfileModule.enableAgeFilter();}

    public void thePageShowGreenAlert(){ myProfileModule.thePageShowGreenAlert();}

    public void  thePageDontHave(String element){ myProfileModule. thePageDontHave( element);}

    public void canNotSendMessage(){ myProfileModule.canNotSendMessage();}

    public void thePageShowPopUpToChooseAgeRange(){ myProfileModule.thePageShowPopUpToChooseAgeRange();}

    public void ageFilterInfoDoNotChange(){ myProfileModule.ageFilterInfoDoNotChange();}

    public void clickAManProfileWhoIsOutOfMyFilter(){ myProfileModule.clickAManProfileWhoIsOutOfMyFilter();}

    public void visitAManProfileWhoIsOutOfMyFilterAndWhoseBirthdayIs(){ myProfileModule.visitAManProfileWhoIsOutOfMyFilterAndWhoseBirthdayIs();}

    public void shouldSeeRedBorderInMessageField() {
        assertThat(myProfileModule.shouldSeeRedBorderInMessageField(), is(equalTo(true)));
    }

    public void settingIsClosed(String modal) {
        assertThat(myProfileModule.settingIsClosed(modal), is(equalTo(true)));
    }

    public void changeSettingOfNotification() {
        myProfileModule.changeSettingOfNotification();
    }

    public void editNicknameAndCheckNewNickname() {
        myProfileModule.editNicknameAndCheckNewNickname();
    }

    public void insertAntiUsernameFromListAndClickValidate() throws FileNotFoundException {
        myProfileModule.insertAntiUsernameFromListAndClickValidate();
    }
}

package autoTest.steps.serenity;

import autoTest.pages.DiscoveriesPage;
import autoTest.pages.MektoubeCommonPage;
import autoTest.service.TestDataService;

import java.awt.*;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.containsString;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public class DiscoveriesPageEndUserSteps {

    DiscoveriesPage discoveriesPage;
    MektoubeCommonPage commonPage = new MektoubeCommonPage();

    public void cannotSeeLetterButton() {
        assertThat(discoveriesPage.cannotSeeLetterButton(), is(equalTo(true)));
    }

    public void cannotSeeSmileButton() {
        assertThat(discoveriesPage.cannotSeeSmileButton(), is(equalTo(true)));
    }

    public void cannotSeeDiscussButton() {
        assertThat(discoveriesPage.cannotSeeDiscussButton(), is(equalTo(true)));
    }

    public void cannotSeeAdviceToDiscussButton() {
        assertThat(discoveriesPage.cannotSeeAdviceToDiscussButton(), is(equalTo(true)));
    }

    public void shouldSeeInMyProfileInformation(String pratiquant) {
        assertThat(discoveriesPage.shouldSeeInMyProfileInformation(pratiquant), is(equalTo(true)));

    }

    public void shouldSeeInMyResearch(String pratiquant) {
        assertThat(discoveriesPage.shouldSeeInMyResearch(pratiquant), is(equalTo(true)));
    }

    public void uploadAvatarFromComputer() throws AWTException {
        discoveriesPage.uploadAvatarFromComputer();

    }

    public void itShouldRedirectTo(String urlName) {
        String url = TestDataService.properties.getProperty(urlName);
        if (url == null) {
            url = urlName;
        }
        if (url.contentEquals("http://aide.mektoube.fr/")) {
            String parentHandle = getDriver().getWindowHandle();
            for (String winHandle : getDriver().getWindowHandles()) {
                if (!winHandle.equals(parentHandle)) {
                    getDriver().switchTo().window(winHandle);
                    try {
                        Thread.sleep(5 * 1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            assertThat(commonPage.getCurrentUrl(), containsString(url));
            getDriver().close();
            getDriver().switchTo().window(parentHandle);
        } else {
            assertThat(commonPage.getCurrentUrl(), containsString(url));
        }
    }

    public void shouldNotShowThisBlockedAccount() {
        assertThat(discoveriesPage.shouldNotShowThisBlockedAccount(), is(equalTo(true)));
    }

    public void shouldSeeButtonSmileDiscussOrDestinyAgain() {
        assertThat(discoveriesPage.shouldSeeButtonSmileDiscussOrDestinyAgain(), is(equalTo(true)));
    }

    public void shouldSeeButtonSmileDiscussOrDestinyAgainInMaleProfile() {
        assertThat(discoveriesPage.shouldSeeButtonSmileDiscussOrDestinyAgainInMaleProfile(), is(equalTo(true)));
    }

    public void clickOnWhichIndexIsContainAvatar(String fieldName, int number) {
        discoveriesPage.clickOnWhichIndexIsContainAvatar(fieldName, number);
    }

    public void avatarPictureIsPopup() {
        assertThat(discoveriesPage.avatarPictureIsPopup(), is(equalTo(true)));
    }

    public void checkIfPopupAvatarIsClosed() {
        assertThat(discoveriesPage.checkIfPopupAvatarIsClosed(), is(equalTo(true)));
    }

    public void wiewTwentyProfileAndProfileNamesIsSortedCorrectly() {
        assertThat(discoveriesPage.wiewTwentyProfileAndProfileNamesIsSortedCorrectly(), is(equalTo(true)));
    }

    public void checkIfContentInModalShowFull() {
        assertThat(discoveriesPage.checkIfContentInModalShowFull(), is(equalTo(true)));
    }

    public void checkIfContentInAdvertisement() {
        assertThat(discoveriesPage.checkIfContentInAdvertisement(), is(equalTo(true)));
    }

    public void clickConfirmWithoutInputCode() {
        discoveriesPage.clickConfirmWithoutInputCode();
    }

    public void shouldSeeRedAlert(String alert) {
        assertThat(discoveriesPage.shouldSeeRedAlert(alert), is(equalTo(true)));
    }

    public void alloPassModalIsClosed() {
        assertThat(discoveriesPage.alloPassModalIsClosed(), is(equalTo(true)));
    }

    public void selectTheProfileHasNameThatWeAreSearching(String name) {
        discoveriesPage.selectTheProfileHasNameThatWeAreSearching(name);
    }

    public void selectBlockThisPerson() {
        discoveriesPage.selectBlockThisPerson();
    }

    public void shouldSeeBlockAccount() {
        assertThat(discoveriesPage.shouldSeeBlockAccount(), is(equalTo(true)));
    }

    public void getProfileName() {
        discoveriesPage.getProfileName();
    }

    public void clickOnBlackliste() {
        discoveriesPage.clickOnBlackliste();
    }

    public void shouldSeeCompleteProfile() {
        assertThat(discoveriesPage.shouldSeeCompleteProfile(), is(equalTo(true)));
    }

    public void checkTheConnectionStatus() {
        assertThat(discoveriesPage.checkTheConnectionStatus(), is(equalTo(true)));
    }

    public void canSeeFavoriteAccountInProfile() {
        assertThat(discoveriesPage.canSeeFavoriteAccountInProfile(), is(equalTo(true)));
    }


    public void selectReportAbuseButton() {
        discoveriesPage.selectReportAbuseButton();
    }

    public void chooseAProfileSimilarThatContainAvatar() {
        discoveriesPage.chooseAProfileSimilarThatContainAvatar();
    }

    public void chooseASimilarProfile() {
        discoveriesPage.chooseASimilarProfile();
    }


    public void searchAccount(String userName) {
        discoveriesPage.searchAccount(userName);
    }

    public void reportAndBlockAProfile() {
        discoveriesPage.reportAndBlockAProfile();
    }


    public void shouldSeeBlockedAccountInBlacklistAndRemoveIt() {
        discoveriesPage.shouldSeeBlockedAccountInBlacklistAndRemoveIt();
    }

    public void deleteBlockedAccountFromBlacklist() {
        discoveriesPage.deleteBlockedAccountFromBlacklist();
    }

    public void canViewTwentyCompleteProfile() {
        discoveriesPage.canViewTwentyCompleteProfile();
    }

    public void thePopupShowErrorMessageLine() {
        discoveriesPage.thePopupShowErrorMessageLine();
    }

    public void thePageShowUsersThatHaveOnline() {
        discoveriesPage.thePageShowUsersThatHaveOnline();
    }

    public void theLabelDontShow(String silhouette, String silhouetteText) {
        discoveriesPage.theLabelDontShow(silhouette, silhouetteText);
    }

    public void theFilterIsReseted() {
        discoveriesPage.theFilterIsReseted();
    }

    public void theAgeLabelDontShowAgeRange() {
        discoveriesPage.theAgeLabelDontShowAgeRange();
    }

    public void theSizeLabelDontShowSize() {
        discoveriesPage.theSizeLabelDontShowSize();
    }

    public void theCountryLabelDontShowCountry() {
        discoveriesPage.theCountryLabelDontShowCountry();
    }

    public void theOriginLabelDontShowOrigin() {
        discoveriesPage.theOriginLabelDontShowOrigin();
    }

    public void clickOnSpecialElementIs(String element) {
        discoveriesPage.clickOnSpecialElementIs(element);
    }

    public void thePageShowNotificationAndDontShowInThisSearchResult() {
        discoveriesPage.thePageShowNotificationAndDontShowInThisSearchResult();
    }

    public void thePageShowNotificationEditedFilter() {
        discoveriesPage.thePageShowNotificationEditedFilter();
    }

    public void checkingInSaveListHaveEditedName(String name) {
        discoveriesPage.checkingInSaveListHaveEditedName(name);
    }

    public void thePageShowAllProfileHaveBirthdayToday() {
        discoveriesPage.thePageShowAllProfileHaveBirthdayToday();
    }

    public void setUpAgeRangeFromTo(int numb1, int numb2) {
        discoveriesPage.setUpAgeRangeFromTo(numb1, numb2);
    }

    public void thePageShowAllProfileThatHaveAgeRangeFromTo(int num1, int num2) {
        discoveriesPage.thePageShowAllProfileThatHaveAgeRangeFromTo(num1, num2);
    }

    public void thePageShowAllProfilesThatHavePictureProfile() {
        discoveriesPage.thePageShowAllProfilesThatHavePictureProfile();
    }

    public void thePageShowAllProfileThatHaveAboveSilhouette() {
        discoveriesPage.thePageShowAllProfileThatHaveAboveSilhouette();
    }

    public void thePageOnlyOneChoiceCanBeSelected() {
        discoveriesPage.thePageOnlyOneChoiceCanBeSelected();
    }

    public void thePageShowAllProfileThatHaveAboveChoicedChildren() {
        discoveriesPage.thePageShowAllProfileThatHaveAboveChoicedChildren();
    }

    public void thePageShowAllProfileThatHaveAbovePratiquant() {
        discoveriesPage.thePageShowAllProfileThatHaveAbovePratiquant();
    }

    public void thePageShowAllProfilesThatHaveAboveSmokingChoice() {
        discoveriesPage.thePageShowAllProfilesThatHaveAboveSmokingChoice();
    }

    public void thePageShowAllProfilesThatHaveAboveLevelOfStudy() {
        discoveriesPage.thePageShowAllProfilesThatHaveAboveLevelOfStudy();
    }

    public void thePageShowAllProfileThatHaveAboveEnteredName() {
        discoveriesPage.thePageShowAllProfileThatHaveAboveEnteredName();
    }

    public void thePopupShowsRedErrorMessage() {
        discoveriesPage.thePopupShowsRedErrorMessage();
    }

    public void theCoutryLabelShowCountryText() {
        discoveriesPage.theCoutryLabelShowCountryText();
    }

    public void thePageShowAllProfileThatHaveAboveFamilySituation() {
        discoveriesPage.thePageShowAllProfileThatHaveAboveFamilySituation();
    }

    public void thePageShowNameInSearchListIs(String nameSearch) {
        discoveriesPage.thePageShowNameInSearchListIs(nameSearch);
    }

    public void thePageShowAllProfileThatHaveAboveCountry() throws IOException, ParseException {
        discoveriesPage.thePageShowAllProfileThatHaveAboveCountry();
    }

    public void theSearchNamePopUpShowErrorMessage(String errorMess) {
        discoveriesPage.theSearchNamePopUpShowErrorMessage(errorMess);
    }

    public void checkingThatThereIsNoDuplicatesProfilesOnTheDiscovery() {
        discoveriesPage.checkingThatThereIsNoDuplicatesProfilesOnTheDiscovery();
    }

    public void checkingAProfileWithoutConnectionPoint() {
        discoveriesPage.checkingAProfileWithoutConnectionPoint();
    }

    public void checkingAProfileWithTheOrangeConnectionPoint() {
        discoveriesPage.checkingAProfileWithTheOrangeConnectionPoint();
    }

    public void checkingAProfileWithTheGreenConnectionPoin() {
        discoveriesPage.checkingAProfileWithTheGreenConnectionPoint();
    }

    public void thePictureHaveToCorrectSize() {
        discoveriesPage.thePictureHaveToCorrectSize();
    }

    public void theNumberOfProfileThatHaveNotPictureProfile() {
        discoveriesPage.theNumberOfProfileThatHaveNotPictureProfile();
    }

    public void seeTheGoodFlag() {
        discoveriesPage.seeTheGoodFlag();
    }

    public void browserShouldRedirectToThisPerson() throws Exception {
        discoveriesPage.browserShouldRedirectToThisPerson();
    }

    public void thePageShowAllProfileThatHaveAboveOrigin() throws InterruptedException {
        discoveriesPage.thePageShowAllProfileThatHaveAboveOrigin();
    }

    public void setUpSizeCm(int size) {
        discoveriesPage.setUpSizeCm(size);
    }

    public void thePageShowAllProfileThatHaveMaxSizeCm(int size) {
        discoveriesPage.thePageShowAllProfileThatHaveMaxSizeCm(size);
    }

    public void saveIdOfProfileIs(String profile) {
        discoveriesPage.saveIdOfProfileIs(profile);
    }

    public void clickIfItIsDisable(String element) {
        discoveriesPage.clickIfItIsDisable(element);
    }

    public void uploadAvatarFromComputerToUnderApprovalProcess(String picture) throws AWTException {
        discoveriesPage.uploadAvatarFromComputerToUnderApprovalProcess(picture);
    }

    public void theDiscoveryPageShowAllManProfile(){ discoveriesPage.theDiscoveryPageShowAllManProfile();}

    public void theDiscoveryPageShowAllWomanProfile(){ discoveriesPage.theDiscoveryPageShowAllWomanProfile();}

    public void setUpSizeFromCmToCm(int minSize, int maxSize){ discoveriesPage.setUpSizeFromCmToCm( minSize, maxSize);}

    public void thePageShowAllProfileThatHaveSizeFromCmToCm(int minSize, int maxSize){ discoveriesPage.thePageShowAllProfileThatHaveSizeFromCmToCm(minSize,maxSize) ;}

}

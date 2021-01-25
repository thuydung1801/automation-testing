package autoTest.steps;

import autoTest.steps.serenity.DiscoveriesPageEndUserSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.json.simple.parser.ParseException;

import java.io.IOException;

import java.awt.*;

public class DiscoveriesPageStepDef {
    @Steps
    DiscoveriesPageEndUserSteps discoveriesPageEndUserSteps;

    @Then("^Cannot see letter button$")
    public void cannotSeeLetterButton() {
        discoveriesPageEndUserSteps.cannotSeeLetterButton();
    }

    @And("^Cannot see smile button$")
    public void cannotSeeSmileButton() {
        discoveriesPageEndUserSteps.cannotSeeSmileButton();
    }

    @And("^Cannot see discuss button$")
    public void cannotSeeDiscussButton() {
        discoveriesPageEndUserSteps.cannotSeeDiscussButton();
    }

    @And("^Cannot see advice to discuss button$")
    public void cannotSeeAdviceToDiscussButton() {
        discoveriesPageEndUserSteps.cannotSeeAdviceToDiscussButton();
    }

    @When("^Should see \"([^\"]*)\" in My profile information$")
    public void shouldSeeInMyProfileInformation(String Pratiquant) {
        discoveriesPageEndUserSteps.shouldSeeInMyProfileInformation(Pratiquant);
    }

    @And("^Should see \"([^\"]*)\" in My research$")
    public void shouldSeeInMyResearch(String Pratiquant) {
        discoveriesPageEndUserSteps.shouldSeeInMyResearch(Pratiquant);
    }

    @When("^Upload avatar from computer$")
    public void uploadAvatarFromComputer() throws AWTException {
        discoveriesPageEndUserSteps.uploadAvatarFromComputer();
    }

    @Then("^It should redirect to \"([^\"]*)\"$")
    public void itShouldRedirectTo(String urlName) {
        discoveriesPageEndUserSteps.itShouldRedirectTo(urlName);
    }

    @Then("^Should not show this blocked account$")
    public void shouldNotShowThisBlockedAccount() {
        discoveriesPageEndUserSteps.shouldNotShowThisBlockedAccount();
    }

    @Then("^should see button smile, discuss or destiny again$")
    public void shouldSeeButtonSmileDiscussOrDestinyAgain() {
        discoveriesPageEndUserSteps.shouldSeeButtonSmileDiscussOrDestinyAgain();
    }

    @Then("^should see button smile, discuss or destiny again in male profile$")
    public void shouldSeeButtonSmileDiscussOrDestinyAgainInMaleProfile() {
        discoveriesPageEndUserSteps.shouldSeeButtonSmileDiscussOrDestinyAgainInMaleProfile();
    }

    @When("^Click on \"([^\"]*)\" which index is \"([^\"]*)\" contain avatar$")
    public void clickOnWhichIndexIsContainAvatar(String fieldName, int number) {
        discoveriesPageEndUserSteps.clickOnWhichIndexIsContainAvatar(fieldName, number);
    }

    @When("^Avatar picture is popup$")
    public void avatarPictureIsPopup() {
        discoveriesPageEndUserSteps.avatarPictureIsPopup();
    }

    @When("^Check if popup avatar is closed$")
    public void checkIfPopupAvatarIsClosed() {
        discoveriesPageEndUserSteps.checkIfPopupAvatarIsClosed();
    }

    @Then("^View twenty profile and profile names is sorted correctly$")
    public void viewTwentyProfileAndProfileNamesIsSortedCorrectly() {
        discoveriesPageEndUserSteps.wiewTwentyProfileAndProfileNamesIsSortedCorrectly();
    }

    @When("^Check if content in modal show full$")
    public void checkIfContentInModalShowFull() {
        discoveriesPageEndUserSteps.checkIfContentInModalShowFull();
    }

    @When("^Check if content in Advertisement$")
    public void checkIfContentInAdvertisement() {
        discoveriesPageEndUserSteps.checkIfContentInAdvertisement();
    }

    @When("^Click confirm without input code$")
    public void clickConfirmWithoutInputCode() {
        discoveriesPageEndUserSteps.clickConfirmWithoutInputCode();
    }

    @Then("^Should see red alert \"([^\"]*)\"$")
    public void shouldSeeRedAlert(String alert) {
        discoveriesPageEndUserSteps.shouldSeeRedAlert(alert);
    }

    @Then("^Allo pass modal is closed$")
    public void alloPassModalIsClosed() {
        discoveriesPageEndUserSteps.alloPassModalIsClosed();
    }

    @When("^Select the profile has name \"([^\"]*)\" that we are searching$")
    public void selectTheProfileHasNameThatWeAreSearching(String name) {
        discoveriesPageEndUserSteps.selectTheProfileHasNameThatWeAreSearching(name);
    }

    @When("^Select block this person$")
    public void selectBlockThisPerson() {
        discoveriesPageEndUserSteps.selectBlockThisPerson();
    }

    @Then("^Should see Block account$")
    public void shouldSeeBlockAccount() {
        discoveriesPageEndUserSteps.shouldSeeBlockAccount();
    }

    @When("^Get profile name$")
    public void getProfileName() {
        discoveriesPageEndUserSteps.getProfileName();
    }

    @When("^Click on BlackList$")
    public void clickOnBlackList() {
        discoveriesPageEndUserSteps.clickOnBlackliste();
    }

    @Then("^Should see complete profile$")
    public void shouldSeeCompleteProfile() {
        discoveriesPageEndUserSteps.shouldSeeCompleteProfile();
    }

    @Then("^Check the connection status$")
    public void checkTheConnectionStatus() {
        discoveriesPageEndUserSteps.checkTheConnectionStatus();
    }

    @Then("^Add a woman to favorite and should see that woman account display in favorite$")
    public void addAWomanToFavoriteAndShouldSeeThatWomanAccountDisplayInFavorite() {
        discoveriesPageEndUserSteps.canSeeFavoriteAccountInProfile();
    }


    @When("^Select report abuse button$")
    public void selectReportAbuseButton() {
        discoveriesPageEndUserSteps.selectReportAbuseButton();
    }

    @When("^choose a profile similar that contain avatar$")
    public void chooseAProfileSimilarThatContainAvatar() {
        discoveriesPageEndUserSteps.chooseAProfileSimilarThatContainAvatar();

    }

    @When("^Choose a similar profile$")
    public void chooseASimilarProfile() {
        discoveriesPageEndUserSteps.chooseASimilarProfile();
    }


    @When("^Search account \"([^\"]*)\"$")
    public void searchAccount(String userName) {
        discoveriesPageEndUserSteps.searchAccount(userName);
    }

    @When("^Report and block a profile$")
    public void reportAndBlockAProfile() {
        discoveriesPageEndUserSteps.reportAndBlockAProfile();
    }


    @Then("^Should see blocked account in Blacklist and remove it$")
    public void shouldSeeBlockedAccountInBlacklistAndRemoveIt() {
        discoveriesPageEndUserSteps.shouldSeeBlockedAccountInBlacklistAndRemoveIt();

    }

    @When("^Delete blocked account from blacklist$")
    public void deleteBlockedAccountFromBlacklist() {
        discoveriesPageEndUserSteps.deleteBlockedAccountFromBlacklist();
    }

    @Then("^Can view twenty complete profile$")
    public void canViewTwentyCompleteProfile() {
        discoveriesPageEndUserSteps.canViewTwentyCompleteProfile();
    }

    @Then("^The popup show error message line$")
    public void thePopupShowErrorMessageLine() {
        discoveriesPageEndUserSteps.thePopupShowErrorMessageLine();
    }

    @Then("^The page show users that have online$")
    public void thePageShowUsersThatHaveOnline() {
        discoveriesPageEndUserSteps.thePageShowUsersThatHaveOnline();
    }

    @Then("^The filter is reseted$")
    public void theFilterIsReseted() {
        discoveriesPageEndUserSteps.theFilterIsReseted();
    }

    @Then("^The age label dont show age range$")
    public void theAgeLabelDontShowAgeRange() {
        discoveriesPageEndUserSteps.theAgeLabelDontShowAgeRange();
    }

    @Then("^The \"([^\"]*)\" label dont show \"([^\"]*)\"$")
    public void theLabelDontShow(String silhouette, String silhouetteText) {
        discoveriesPageEndUserSteps.theLabelDontShow(silhouette, silhouetteText);
    }

    @Then("^The size label dont show size$")
    public void theSizeLabelDontShowSize() {
        discoveriesPageEndUserSteps.theSizeLabelDontShowSize();
    }

    @Then("^The country label dont show country$")
    public void theCountryLabelDontShowCountry() {
        discoveriesPageEndUserSteps.theCountryLabelDontShowCountry();
    }

    @Then("^The origin label dont show origin$")
    public void theOriginLabelDontShowOrigin() {
        discoveriesPageEndUserSteps.theOriginLabelDontShowOrigin();
    }

    @When("^Click on special element is \"([^\"]*)\"$")
    public void clickOnSpecialElementIs(String element) {
        discoveriesPageEndUserSteps.clickOnSpecialElementIs(element);
    }

    @Then("^The page show notification and dont show in this search result$")
    public void thePageShowNotificationAndDontShowInThisSearchResult() {
        discoveriesPageEndUserSteps.thePageShowNotificationAndDontShowInThisSearchResult();
    }

    @Then("^The page show notification Edited filter$")
    public void thePageShowNotificationEditedFilter() {
        discoveriesPageEndUserSteps.thePageShowNotificationEditedFilter();
    }

    @And("^Checking in save list have edited name \"([^\"]*)\"$")
    public void checkingInSaveListHaveEditedName(String name) {
        discoveriesPageEndUserSteps.checkingInSaveListHaveEditedName(name);
    }

    @Then("^The page show all profile have birthday today$")
    public void thePageShowAllProfileHaveBirthdayToday() {
        discoveriesPageEndUserSteps.thePageShowAllProfileHaveBirthdayToday();
    }

    @When("^Set up age range from (\\d+) to (\\d+)$")
    public void setUpAgeRangeFromTo(int numb1, int numb2) {
        discoveriesPageEndUserSteps.setUpAgeRangeFromTo(numb1, numb2);
    }

    @When("^The page show all profile that have age range from (\\d+) to (\\d+)$")
    public void thePageShowAllProfileThatHaveAgeRangeFromTo(int num1, int num2) {
        discoveriesPageEndUserSteps.thePageShowAllProfileThatHaveAgeRangeFromTo(num1, num2);
    }

    @Then("^The page show all profiles that have picture profile$")
    public void thePageShowAllProfilesThatHavePictureProfile() {
        discoveriesPageEndUserSteps.thePageShowAllProfilesThatHavePictureProfile();
    }

    @Then("^The page show all profile that have above silhouette$")
    public void thePageShowAllProfileThatHaveAboveSilhouette() {
        discoveriesPageEndUserSteps.thePageShowAllProfileThatHaveAboveSilhouette();
    }

    @Then("^The page only one choice can be selected$")
    public void thePageOnlyOneChoiceCanBeSelected() {
        discoveriesPageEndUserSteps.thePageOnlyOneChoiceCanBeSelected();
    }

    @Then("^The page show all profile that have above choiced children$")
    public void thePageShowAllProfileThatHaveAboveChoicedChildren() {
        discoveriesPageEndUserSteps.thePageShowAllProfileThatHaveAboveChoicedChildren();
    }

    @Then("^The page show all profile that have above pratiquant$")
    public void thePageShowAllProfileThatHaveAbovePratiquant() {
        discoveriesPageEndUserSteps.thePageShowAllProfileThatHaveAbovePratiquant();
    }

    @Then("^The page show all profiles that have above smoking choice$")
    public void thePageShowAllProfilesThatHaveAboveSmokingChoice() {
        discoveriesPageEndUserSteps.thePageShowAllProfilesThatHaveAboveSmokingChoice();
    }

    @Then("^The page show all profiles that have above level of study$")
    public void thePageShowAllProfilesThatHaveAboveLevelOfStudy() {
        discoveriesPageEndUserSteps.thePageShowAllProfilesThatHaveAboveLevelOfStudy();
    }

    @Then("^The page show all profile that have above entered name$")
    public void thePageShowAllProfileThatHaveAboveEnteredName() {
        discoveriesPageEndUserSteps.thePageShowAllProfileThatHaveAboveEnteredName();
    }

    @Then("^The popup shows red error message$")
    public void thePopupShowsRedErrorMessage() {
        discoveriesPageEndUserSteps.thePopupShowsRedErrorMessage();
    }

    @And("^The Coutry label show Country Text$")
    public void theCoutryLabelShowCountryText() {
        discoveriesPageEndUserSteps.theCoutryLabelShowCountryText();
    }

    @Then("^The page show all profile that have above family situation$")
    public void thePageShowAllProfileThatHaveAboveFamilySituation() {
        discoveriesPageEndUserSteps.thePageShowAllProfileThatHaveAboveFamilySituation();
    }

    @Then("^The page show name in search list is \"([^\"]*)\"$")
    public void thePageShowNameInSearchListIs(String nameSearch) {
        discoveriesPageEndUserSteps.thePageShowNameInSearchListIs(nameSearch);
    }

    @Then("^The page show all profile that have above country$")
    public void thePageShowAllProfileThatHaveAboveCountry() throws IOException, ParseException {
        discoveriesPageEndUserSteps.thePageShowAllProfileThatHaveAboveCountry();
    }

    @Then("^The search name pop up show error message \"([^\"]*)\"$")
    public void theSearchNamePopUpShowErrorMessage(String errorMess) {
        discoveriesPageEndUserSteps.theSearchNamePopUpShowErrorMessage(errorMess);
    }

    @Then("^Checking that there is no duplicates profiles on the discovery$")
    public void checkingThatThereIsNoDuplicatesProfilesOnTheDiscovery() {
        discoveriesPageEndUserSteps.checkingThatThereIsNoDuplicatesProfilesOnTheDiscovery();
    }

    @Then("^Checking a profile without connection point$")
    public void checkingAProfileWithoutConnectionPoint() {
        discoveriesPageEndUserSteps.checkingAProfileWithoutConnectionPoint();
    }

    @Then("^Checking a profile with the orange connection point$")
    public void checkingAProfileWithTheOrangeConnectionPoint() {
        discoveriesPageEndUserSteps.checkingAProfileWithTheOrangeConnectionPoint();
    }

    @Then("^Checking a profile with the green connection point$")
    public void checkingAProfileWithTheGreenConnectionPoint() {
        discoveriesPageEndUserSteps.checkingAProfileWithTheGreenConnectionPoin();
    }

    @Then("^The picture have to correct size$")
    public void thePictureHaveToCorrectSize() {
        discoveriesPageEndUserSteps.thePictureHaveToCorrectSize();
    }

    @Then("^The number of profile that have not picture profile$")
    public void theNumberOfProfileThatHaveNotPictureProfile() {
        discoveriesPageEndUserSteps.theNumberOfProfileThatHaveNotPictureProfile();
    }

    @Then("^See the good flag$")
    public void seeTheGoodFlag() {
        discoveriesPageEndUserSteps.seeTheGoodFlag();
    }

    @Then("^Browser should redirect to this person$")
    public void browserShouldRedirectToThisPerson() throws Exception {
        discoveriesPageEndUserSteps.browserShouldRedirectToThisPerson();
    }

    @Then("^The page show all profile that have above origin$")
    public void thePageShowAllProfileThatHaveAboveOrigin() throws InterruptedException {
        discoveriesPageEndUserSteps.thePageShowAllProfileThatHaveAboveOrigin();
    }

    @When("^Set up size (\\d+) cm$")
    public void setUpSizeCm(int size) {
        discoveriesPageEndUserSteps.setUpSizeCm(size);
    }

    @Then("^The page show all profile that have max size (\\d+) cm$")
    public void thePageShowAllProfileThatHaveMaxSizeCm(int size) {
        discoveriesPageEndUserSteps.thePageShowAllProfileThatHaveMaxSizeCm(size);
    }


    @When("^Save id of profile is \"([^\"]*)\"$")
    public void saveIdOfProfileIs(String profile) {
        discoveriesPageEndUserSteps.saveIdOfProfileIs(profile);
    }

    @When("^Click \"([^\"]*)\" if it is disable$")
    public void clickIfItIsDisable(String element) {
        discoveriesPageEndUserSteps.clickIfItIsDisable(element);
    }

    @When("^Upload avatar \"([^\"]*)\" from computer to under approval process$")
    public void uploadAvatarFromComputerToUnderApprovalProcess(String picture) throws AWTException {
        discoveriesPageEndUserSteps.uploadAvatarFromComputerToUnderApprovalProcess(picture);
    }

    @When("^Upload avatar \"([^\"]*)\" from computer to rejected$")
    public void uploadAvatarFromComputerToRejected(String picture) throws AWTException {
        discoveriesPageEndUserSteps.uploadAvatarFromComputerToUnderApprovalProcess(picture);
    }

    @Then("^The discovery page show all man profile$")
    public void theDiscoveryPageShowAllManProfile() { discoveriesPageEndUserSteps.theDiscoveryPageShowAllManProfile();
    }

    @Then("^The discovery page show all woman profile$")
    public void theDiscoveryPageShowAllWomanProfile() { discoveriesPageEndUserSteps.theDiscoveryPageShowAllWomanProfile();
    }

    @When("^Set up size from (\\d+) cm to (\\d+) cm$")
    public void setUpSizeFromCmToCm(int minSize, int maxSize) { discoveriesPageEndUserSteps.setUpSizeFromCmToCm( minSize, maxSize);
    }

    @Then("^The page show all profile that have size from (\\d+) cm to (\\d+) cm$")
    public void thePageShowAllProfileThatHaveSizeFromCmToCm(int minSize, int maxSize) { discoveriesPageEndUserSteps.thePageShowAllProfileThatHaveSizeFromCmToCm(minSize,maxSize);
    }
}

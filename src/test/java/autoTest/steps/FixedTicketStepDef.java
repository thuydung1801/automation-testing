package autoTest.steps;

import autoTest.steps.serenity.FixedTicketEndUserSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.awt.*;

public class FixedTicketStepDef {
    @Steps

    FixedTicketEndUserSteps fixedTicketEndUserSteps;

    @When("^go back$")
    public void goBack() {
        fixedTicketEndUserSteps.goBack();
    }

    @When("^Should see unique saved search name$")
    public void shouldSeeUniqueSavedSearchName() {
        fixedTicketEndUserSteps.shouldSeeUniqueSavedSearchName();
    }

    @When("^Edit saved search has name \"([^\"]*)\"$")
    public void editSavedSearchHasName(String name) {
        fixedTicketEndUserSteps.editSavedSearchHasName(name);
    }

    @When("^Edit name of saved search has name \"([^\"]*)\" to \"([^\"]*)\"$")
    public void editNameOfSavedSearchHasNameTo(String name1, String name2) {
        fixedTicketEndUserSteps.editNameOfSavedSearchHasNameTo(name1, name2);
    }

    @When("^Should see unique saved search name is \"([^\"]*)\"$")
    public void shouldSeeUniqueSavedSearchNameIs(String name) {
        fixedTicketEndUserSteps.shouldSeeUniqueSavedSearchNameContain(name);
    }

    @When("^Delete the search has name is \"([^\"]*)\"$")
    public void deleteTheSearchHasNameIs(String name) {
        fixedTicketEndUserSteps.deleteTheSearchHasNameIs(name);
    }

    @Then("^Profile just shows next profile icon$")
    public void profileJustShowsNextProfileIcon() {
        fixedTicketEndUserSteps.profileJustShowsNextProfileIcon();
    }

    @And("^Click on last profile in discovery$")
    public void clickOnLastProfileInDiscovery() {
        fixedTicketEndUserSteps.clickOnLastProfileInDiscovery();
    }

    @Then("^Profile just shows previous profile icon$")
    public void profileJustShowsPreviousProfileIcon() {
        fixedTicketEndUserSteps.profileJustShowsPreviousProfileIcon();
    }

    @Then("^Profile show previous profile and next profile$")
    public void profileShowPreviousProfileAndNextProfile() {
        fixedTicketEndUserSteps.profileShowPreviousProfileAndNextProfile();
    }

    @Then("^The last message must be displayed$")
    public void theLastMessageMustBeDisplayed() {
        fixedTicketEndUserSteps.theLastMessageMustBeDisplayed();
    }

    @Then("^The cancel gif is enable$")
    public void theCancelGifIsEnable() {
        fixedTicketEndUserSteps.theCancelGifIsEnable();
    }

    @Then("^The page have criteria number in discovery have to zero by default$")
    public void thePageHaveCriteriaNumberInDiscoveryHaveToZeroByDefault() {
        fixedTicketEndUserSteps.thePageHaveCriteriaNumberInDiscoveryHaveToZeroByDefault();
    }

    @When("^Save data to check again that are \"([^\"]*)\" and \"([^\"]*)\"$")
    public void saveDataToCheckAgainThatAreAnd(String value1, String value2) {
        fixedTicketEndUserSteps.saveDataToCheckAgainThatAreAnd(value1, value2);
    }

    @When("^Click on first profile in discovery non save name$")
    public void clickOnFirstProfileInDiscoveryNonSaveName() {
        fixedTicketEndUserSteps.clickOnFirstProfileInDiscoveryNonSaveName();
    }

    @Then("^The Pays and Region label still display the selected selection$")
    public void thePaysAndRegionLabelStillDisplayTheSelectedSelection() {
        fixedTicketEndUserSteps.thePaysAndRegionLabelStillDisplayTheSelectedSelection();
    }


    @When("^Sroll on top (\\d+)$")
    public void srollOnTop(int numb) {
        fixedTicketEndUserSteps.srollOnTop(numb);
    }

    @When("^Sroll on top (\\d+) by robot$")
    public void srollOnTopByRobot(int numb) throws AWTException {
        fixedTicketEndUserSteps.srollOnTopByRobot(numb);
    }

    @Then("^The last message must be not display$")
    public void theLastMessageMustBeNotDisplay() throws Exception {
        fixedTicketEndUserSteps.theLastMessageMustBeNotDisplay();
    }

    @Then("^The quote message and last message must be corresponding$")
    public void theQuoteMessageAndLastMessageMustBeCorresponding() { fixedTicketEndUserSteps.theQuoteMessageAndLastMessageMustBeCorresponding();
    }

    @And("^The page dont show Smile and Discuss buttons$")
    public void thePageDontShowSmileAndDiscussButtons() { fixedTicketEndUserSteps.thePageDontShowSmileAndDiscussButtons();
    }

    @Then("^The selection list contains \"([^\"]*)\" in line (\\d+)$")
    public void theSelectionListContainsInLine(String selectionText, int lineNum) {
        fixedTicketEndUserSteps.theSelectionListContainsInLine(selectionText,lineNum);
    }

    @And("^The page show Smile and Discuss buttons$")
    public void thePageShowSmileAndDiscussButtons() { fixedTicketEndUserSteps. thePageShowSmileAndDiscussButtons();
    }

    @Then("^The message nunber from \"([^\"]*)\" are (\\d+)$")
    public void theMessageNunberFromAre(String name, int numb) {
        fixedTicketEndUserSteps.theMessageNunberFromAre( name,  numb);
    }

    @Then("^Check ephemeral report modal$")
    public void checkEphemeralReportModal() { fixedTicketEndUserSteps.checkEphemeralReportModal();
    }

    @Then("^Should see meta tag \"([^\"]*)\"$")
    public void shouldSeeMetaTag(String metaTag)  {
       fixedTicketEndUserSteps.shouldSeeMetaTag(metaTag);
    }

    @Then("^Time of quote message, last message and real time have same$")
    public void timeOfQuoteMessageLastMessageAndRealTimeHaveSame() { fixedTicketEndUserSteps.timeOfQuoteMessageLastMessageAndRealTimeHaveSame();
    }

    @Then("^Profile status must match in discovery, profile and message$")
    public void profileStatusMustMatchInDiscoveryProfileAndMessage() { fixedTicketEndUserSteps.profileStatusMustMatchInDiscoveryProfileAndMessage();
    }


    @When("^Should see profile of account \"([^\"]*)\"$")
    public void shouldSeeProfileOfAccount(String accountName)  {
       fixedTicketEndUserSteps.shouldSeeProfileOfAccount(accountName);
    }

    @When("^Should see all notifications and messages of account PhuongChi$")
    public void shouldSeeAllNotificationsAndMessagesOfAccountPhuongChi() throws AWTException {
        fixedTicketEndUserSteps.shouldSeeAllNotificationsAndMessagesOfAccountPhuongChi();
    }

    @Then("^The testimonials contain all it's parts$")
    public void theTestimonialsContainAllItSParts() {
        fixedTicketEndUserSteps.theTestimonialsContainAllItSParts();
    }


    @Then("^The page show message \"([^\"]*)\" at \"([^\"]*)\"$")
    public void thePageShowMessageAt(String errorMess, String element) {
        fixedTicketEndUserSteps.thePageShowMessageAt( errorMess,  element);
    }

    @When("^Create a man account with email \"([^\"]*)\"$")
    public void createAManAccountWithEmail(String email) {
        fixedTicketEndUserSteps.createAManAccountWithEmail(email);
    }

    @Then("^The page show pop up voice report confirm$")
    public void thePageShowPopUpVoiceReportConfirm() {
        fixedTicketEndUserSteps.thePageShowPopUpVoiceReportConfirm();
    }

    @When("^Allow to use microphone$")
    public void allowToUseMicrophone() { fixedTicketEndUserSteps.allowToUseMicrophone();
    }

    @When("^Click on last message -(\\d+)$")
    public void clickOnLastMessage(int index) { fixedTicketEndUserSteps.clickOnLastMessage(index);
    }

    @Then("^The last voice message is not allowed playing$")
    public void theLastVoiceMessageIsNotAllowedPlaying() { fixedTicketEndUserSteps.theLastVoiceMessageIsNotAllowedPlaying();
    }

    @And("^The voice message still recording$")
    public void theVoiceMessageStillRecording() { fixedTicketEndUserSteps.theVoiceMessageStillRecording();
    }

    @When("^Upload ephemeral picture is \"([^\"]*)\"$")
    public void uploadEphemeralPictureIs(String imageName) throws AWTException {
        fixedTicketEndUserSteps.uploadEphemeralPictureIs( imageName);
    }

    @And("^Dont show sent image that changed extension$")
    public void dontShowSentImageThatChangedExtension() { fixedTicketEndUserSteps.dontShowSentImageThatChangedExtension();
    }

    @When("^Login gmail and click link to RETURN TO MEKTOUBE$")
    public void loginGmailAndClickLinkToRETURNTOMEKTOUBE() { fixedTicketEndUserSteps.loginGmailAndClickLinkToRETURNTOMEKTOUBE();
    }

    @Then("^The account name is \"([^\"]*)\"$")
    public void theAccountNameIs(String name) {
        fixedTicketEndUserSteps.theAccountNameIs( name);
    }

    @When("^Counting number of boost profile on discovery$")
    public void countingNumberOfBoostProfileOnDiscovery() { fixedTicketEndUserSteps.countingNumberOfBoostProfileOnDiscovery();
    }

    @Then("^The boost profiles like when not refreshed$")
    public void theBoostProfilesLikeWhenNotRefreshed() { fixedTicketEndUserSteps.theBoostProfilesLikeWhenNotRefreshed();
    }

    @And("^The button is disabled that is \"([^\"]*)\"$")
    public void theButtonIsDisabledThatIs(String element)  {
        fixedTicketEndUserSteps.theButtonIsDisabledThatIs(element);
    }
}

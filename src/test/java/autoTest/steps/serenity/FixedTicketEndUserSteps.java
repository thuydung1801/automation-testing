package autoTest.steps.serenity;

import autoTest.pages.FixedTicket;

import java.awt.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class FixedTicketEndUserSteps {
    FixedTicket fixedTicket;

    public void goBack() {
        fixedTicket.goBack();
    }

    public void shouldSeeUniqueSavedSearchName() {
        assertThat(fixedTicket.shouldSeeUniqueSavedSearchName(), is(equalTo(true)));
    }

    public void editSavedSearchHasName(String name) {
        fixedTicket.editSavedSearchHasName(name);
    }

    public void editNameOfSavedSearchHasNameTo(String name1, String name2) {
        fixedTicket.editNameOfSavedSearchHasNameTo(name1, name2);
    }

    public void shouldSeeUniqueSavedSearchNameContain(String name) {
        assertThat(fixedTicket.shouldSeeUniqueSavedSearchNameContain(name), is(equalTo(true)));
    }

    public void deleteTheSearchHasNameIs(String name) {
        fixedTicket.deleteTheSearchHasNameIs(name);
    }


    public void profileJustShowsNextProfileIcon() {
        fixedTicket.profileJustShowsNextProfileIcon();
    }

    public void clickOnLastProfileInDiscovery() {
        fixedTicket.clickOnLastProfileInDiscovery();
    }

    public void profileJustShowsPreviousProfileIcon() {
        fixedTicket.profileJustShowsPreviousProfileIcon();
    }

    public void profileShowPreviousProfileAndNextProfile() {
        fixedTicket.profileShowPreviousProfileAndNextProfile();
    }

    public void theLastMessageMustBeDisplayed() {
        fixedTicket.theLastMessageMustBeDisplayed();
    }

    public void theCancelGifIsEnable() {
        fixedTicket.theCancelGifIsEnable();
    }

    public void thePageHaveCriteriaNumberInDiscoveryHaveToZeroByDefault() {
        fixedTicket.thePageHaveCriteriaNumberInDiscoveryHaveToZeroByDefault();
    }

    public void saveDataToCheckAgainThatAreAnd(String value1, String value2) {
        fixedTicket.saveDataToCheckAgainThatAreAnd(value1, value2);
    }

    public void clickOnFirstProfileInDiscoveryNonSaveName() {
        fixedTicket.clickOnFirstProfileInDiscoveryNonSaveName();
    }

    public void thePaysAndRegionLabelStillDisplayTheSelectedSelection() {
        fixedTicket.thePaysAndRegionLabelStillDisplayTheSelectedSelection();
    }

    public void srollOnTop(int numb) {
        fixedTicket.srollOnTop(numb);
    }

    public void srollOnTopByRobot(int numb) throws AWTException {
        fixedTicket.srollOnTopByRobot(numb);
    }

    public void theLastMessageMustBeNotDisplay() throws Exception {
        fixedTicket.theLastMessageMustBeNotDisplay();
    }

    public void theQuoteMessageAndLastMessageMustBeCorresponding(){ fixedTicket.theQuoteMessageAndLastMessageMustBeCorresponding();}

    public void thePageDontShowSmileAndDiscussButtons(){ fixedTicket.thePageDontShowSmileAndDiscussButtons();}

    public void theSelectionListContainsInLine(String selectionText, int lineNum){ fixedTicket.theSelectionListContainsInLine( selectionText,  lineNum);}

    public void  thePageShowSmileAndDiscussButtons(){ fixedTicket. thePageShowSmileAndDiscussButtons();}

    public void theMessageNunberFromAre(String name, int numb){ fixedTicket.theMessageNunberFromAre( name,  numb);}

    public void checkEphemeralReportModal(){ fixedTicket.checkEphemeralReportModal();}

    public void shouldSeeMetaTag(String metaTag) {
        assertThat(fixedTicket.shouldSeeMetaTag(metaTag), is(equalTo(true)));
    }

    public void timeOfQuoteMessageLastMessageAndRealTimeHaveSame(){ fixedTicket.timeOfQuoteMessageLastMessageAndRealTimeHaveSame();}

    public void profileStatusMustMatchInDiscoveryProfileAndMessage(){ fixedTicket.profileStatusMustMatchInDiscoveryProfileAndMessage();}

    public void shouldSeeProfileOfAccount(String accountName) {
        assertThat(fixedTicket.shouldSeeProfileOfAccount(accountName), is(equalTo(true)));
    }

    public void shouldSeeAllNotificationsAndMessagesOfAccountPhuongChi() throws AWTException {
       fixedTicket.shouldSeeAllNotificationsAndMessagesOfAccountPhuongChi();
    }

    public void theTestimonialsContainAllItSParts(){
        fixedTicket.theTestimonialsContainAllItSParts();
    }

    public void thePageShowMessageAt(String errorMess, String element){ fixedTicket.thePageShowMessageAt( errorMess,  element);}

    public void createAManAccountWithEmail(String email){ fixedTicket.createAManAccountWithEmail(email);}

    public void thePageShowPopUpVoiceReportConfirm(){ fixedTicket.thePageShowPopUpVoiceReportConfirm();}

    public void allowToUseMicrophone(){ fixedTicket.allowToUseMicrophone(); }

    public void clickOnLastMessage(int index){ fixedTicket.clickOnLastMessage(index);}

    public void theLastVoiceMessageIsNotAllowedPlaying(){ fixedTicket.theLastVoiceMessageIsNotAllowedPlaying();}

    public void theVoiceMessageStillRecording(){ fixedTicket.theVoiceMessageStillRecording() ;}

    public void uploadEphemeralPictureIs(String imageName) throws AWTException { fixedTicket.uploadEphemeralPictureIs( imageName);}

    public void dontShowSentImageThatChangedExtension(){ fixedTicket.dontShowSentImageThatChangedExtension() ;}

    public void loginGmailAndClickLinkToRETURNTOMEKTOUBE(){ fixedTicket.loginGmailAndClickLinkToRETURNTOMEKTOUBE();}

    public void theAccountNameIs(String name){ fixedTicket.theAccountNameIs( name);}

    public void countingNumberOfBoostProfileOnDiscovery(){ fixedTicket.countingNumberOfBoostProfileOnDiscovery();}

    public void theBoostProfilesLikeWhenNotRefreshed(){ fixedTicket.theBoostProfilesLikeWhenNotRefreshed();}

    public void theButtonIsDisabledThatIs(String element){ fixedTicket.theButtonIsDisabledThatIs( element);}

}

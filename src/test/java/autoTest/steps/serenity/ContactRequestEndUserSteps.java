package autoTest.steps.serenity;

import autoTest.pages.ContactRequestPage;

import java.awt.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ContactRequestEndUserSteps {
    ContactRequestPage contactRequestPage;

    public void chooseProfileContainContactRequestButton() {
        contactRequestPage.chooseProfileContainContactRequestButton();
    }

    public void shouldSeeExplanationInTheMessageField() {
        assertThat(contactRequestPage.shouldSeeExplanationInTheMessageField(), is(equalTo(true)));
    }

    public void theModalForWriteMessageIsClosing() {
        assertThat(contactRequestPage.theModalForWriteMessageIsClosing(), is(equalTo(true)));
    }

    public void shouldSeeSeeTherePagesOfExplanation() {
        assertThat(contactRequestPage.shouldSeeSeeTherePagesOfExplanation(), is(equalTo(true)));
    }

    public void checkIfInspirationalTextCanChange() throws AWTException {
        assertThat(contactRequestPage.checkIfInspirationalTextCanChange(), is(equalTo(true)));
    }

    public void choseInspirationalText() throws AWTException {
        assertThat(contactRequestPage.choseInspirationalText(), is(equalTo(true)));
    }

    public void loginInByWomanAccount() {
        contactRequestPage.loginInByWomanAccount();
    }

    public void acceptContactRequestOf(String user) {
        contactRequestPage.acceptContactRequestOf(user);
    }

    public void shouldSeeMessageWithFirstExceptCommercialMessage(String user) {
        assertThat(contactRequestPage.shouldSeeMessageWithFirst(user), is(equalTo(true)));
    }

    public void shouldSeeMessageWithSameContentOfSentMessage() {
        assertThat(contactRequestPage.shouldSeeMessageWithSameContentOfSentMessage(), is(equalTo(true)));
    }

    public void shouldSeeAppearInLogChat(String name) {
        assertThat(contactRequestPage.shouldSeeAppearInLogChat(name), is(equalTo(true)));
    }

    public void shouldSeeTextOnButtonChangeTo(String text) {
        assertThat(contactRequestPage.shouldSeeTextOnButtonChangeTo(text), is(equalTo(true)));
    }


    public void shouldSeeWomanNameOnCrossYourDestiniesScreen(String name) {
        assertThat(contactRequestPage.shouldSeeWomanNameOnCrossYourDestiniesScreen(name), is(equalTo(true)));
    }

    public void shouldSeeWomanNameOnMessageScreen(String name) {
        assertThat(contactRequestPage.shouldSeeWomanNameOnMessageScreen(name), is(equalTo(true)));
    }

    public void shouldSeeDiscussAndSmileButton() {
        assertThat(contactRequestPage.shouldSeeDiscussAndSmileButton(), is(equalTo(true)));
    }


    public void shouldSendMessageAsUsual(String text) {
        assertThat(contactRequestPage.shouldSendMessageAsUsual(text), is(equalTo(true)));
    }

    public void shouldSeeRequestContactMessageBelowProfileAvatar(String mess) {
        assertThat(contactRequestPage.shouldSeeRequestContactMessageBelowProfileAvatar(mess), is(equalTo(true)));
    }


    public void doNotSeeNameOfOnContactRequestList(String name) {
        assertThat(contactRequestPage.doNotSeeNameOfOnContactRequestList(name), is(equalTo(true)));
    }

    public void clickDiscussAgainWithWomanThatAlreadyDeleteMessage() {
        contactRequestPage.clickDiscussAgainWithWomanThatAlreadyDeleteMessage();
    }

    public void getProfileManeOn(String element) {
        contactRequestPage.getProfileManeOn(element);
    }

    public void shouldSeeWomanNameThatDeletedMessageOnMessageScreen() {
        assertThat(contactRequestPage.shouldSeeWomanNameThatDeletedMessageOnMessageScreen(), is(equalTo(true)));
    }

    public void doNotSeeNameOfOnMessageScreen(String name) {
        assertThat(contactRequestPage.doNotSeeNameOfOnMessageScreen(name), is(equalTo(true)));
    }

    public void logOutCurrentMaleAccountAndLoginWithWomanAccount() {
        contactRequestPage.logOutCurrentMaleAccountAndLoginWithWomanAccount();
    }

    public void shouldSeeContactRequestIsBlocked() {
        assertThat(contactRequestPage.shouldSeeContactRequestIsBlocked(), is(equalTo(true)));
    }

    public void searchWomanAccountAndSendInspirationalText(String womanAccount) throws AWTException {
        contactRequestPage.searchWomanAccountAndSendInspirationalText(womanAccount);
    }

    public void searchWomanAccountAndContactRequest(String womanAccount) {
        contactRequestPage.searchWomanAccountAndContactRequest(womanAccount);
    }

    public void clickOnUserProfileLinkAndShouldSeeDiscussAndSmileButton() {
        contactRequestPage.clickOnUserProfileLinkAndShouldSeeDiscussAndSmileButton();
    }

    public void clickToSeeProfileOfTheManWhoSendContactRequest() {
        contactRequestPage.clickToSeeProfileOfTheManWhoSendContactRequest();
    }


    public void thePageShowsPopup() {
        contactRequestPage.thePageShowsPopup();
    }

    public void thePageDontShowDuplicateInvitations() {
        contactRequestPage.thePageDontShowDuplicateInvitations();
    }

    public void thePageShowsAGreenAcceptButtonAndAWhiteRefuseButtonInEachInvitations() {
        contactRequestPage.thePageShowsAGreenAcceptButtonAndAWhiteRefuseButtonInEachInvitations();
    }

    public void theRequestContactPageDontShowThisPerson() {
        contactRequestPage.theRequestContactPageDontShowThisPerson();
    }

    public void theMessagePageHaveThisPerson() {
        contactRequestPage.theMessagePageHaveThisPerson();
    }

    public void theRequestContactPageStillShowsThisPerson() {
        contactRequestPage.theRequestContactPageStillShowsThisPerson();
    }

    public void theMessagePageDontHaveThisPerson() {
        contactRequestPage.theMessagePageDontHaveThisPerson();
    }

    public void thePageShowsFiveLastRefusalsProfile() {
        contactRequestPage.thePageShowsFiveLastRefusalsProfile();
    }

    public void theLastRefusalsListDontShowThisPerson() {
        contactRequestPage.theLastRefusalsListDontShowThisPerson();
    }

    public void theLastRefusalsListStillShowThisPerson() {
        contactRequestPage.theLastRefusalsListStillShowThisPerson();
    }

    public void thePageShowsAllInvitationsArePresent() {
        contactRequestPage.thePageShowsAllInvitationsArePresent();
    }

    public void theRequestContactTextHavePinkDot() {
        contactRequestPage.theRequestContactTextHavePinkDot();
    }

    public void theRequestContactTextDontHavePinkDot() {
        contactRequestPage.theRequestContactTextDontHavePinkDot();
    }

    public void clickDécouvrirDesProfilsOnCroisezVosDestinsScreen() {
        contactRequestPage.clickDécouvrirDesProfilsOnCroisezVosDestinsScreen();
    }

    public void deleteMessageOf(String name) {
        contactRequestPage.deleteMessageOf(name);
    }

    public void shouldNotSeeWomanNameOnCrossYourDestiniesScreen(String name) {
        assertThat(contactRequestPage.shouldNotSeeWomanNameOnCrossYourDestiniesScreen(name), is(equalTo(true)));
    }

    public void shouldSeeUnreadMessageOfOnMessageScreen(String name) {
        assertThat(contactRequestPage.shouldSeeUnreadMessageOfOnMessageScreen(name), is(equalTo(true)));
    }

    public void acceptContactRequestOfToAnswerLater(String account) {
        contactRequestPage.acceptContactRequestOfToAnswerLater(account);
    }

    public void refuseContactRequestOf(String account) {
        contactRequestPage.refuseContactRequestOf(account);
    }

    public void checkIfIndicatorDisplayRightForNewContactRequest() {
        assertThat(contactRequestPage.checkIfIndicatorDisplayRightForNewContactRequest(), is(equalTo(true)));
    }


    public void clickOnAvatarOnChatHeader() {
        contactRequestPage.clickOnAvatarOnChatHeader();
    }

    public void clickOnAvatarNextToEachChatMessage() {
        contactRequestPage.clickOnAvatarNextToEachChatMessage();
    }

    public void refuseFirstCrossAndSeeLastFiveRefusalsButton() {
        contactRequestPage.refuseFirstCrossAndSeeLastFiveRefusalsButton();
    }
    public void acceptContactRequestNowOfInRefuseList(String name){
        contactRequestPage.acceptContactRequestNowOfInRefuseList(name);
    }
}

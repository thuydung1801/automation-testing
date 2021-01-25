package autoTest.steps;

import autoTest.steps.serenity.ContactRequestEndUserSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.awt.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ContactRequestStepDef {
    @Steps
    ContactRequestEndUserSteps contactRequestEndUserSteps;

    @When("^Choose profile contain contact request button$")
    public void chooseProfileContainContactRequestButton() {
        contactRequestEndUserSteps.chooseProfileContainContactRequestButton();
    }

    @Then("^Should see explanation in the message field$")
    public void shouldSeeExplanationInTheMessageField() {
        contactRequestEndUserSteps.shouldSeeExplanationInTheMessageField();
    }

    @Then("^The modal for write message is closing$")
    public void theModalForWriteMessageIsClosing() {
        contactRequestEndUserSteps.theModalForWriteMessageIsClosing();
    }

    @Then("^Should see see there pages of explanation of the feature on the point of view of a man$")
    public void shouldSeeSeeTherePagesOfExplanationOfTheFeatureOnThePointOfViewOfAMan() {
        contactRequestEndUserSteps.shouldSeeSeeTherePagesOfExplanation();
    }

    @When("^Check if inspirational text can change when choose another one$")
    public void checkIfInspirationalTextCanChangeWhenChooseAnotherOne() throws AWTException {
        contactRequestEndUserSteps.checkIfInspirationalTextCanChange();
    }

    @When("^Chose inspirational text$")
    public void choseInspirationalText() throws AWTException {
        contactRequestEndUserSteps.choseInspirationalText();
    }

    @When("^Login in by woman account$")
    public void loginInByWomanAccount() {
        contactRequestEndUserSteps.loginInByWomanAccount();
    }

    @When("^Accept contact request of \"([^\"]*)\"$")
    public void acceptContactRequestOf(String user) {
        contactRequestEndUserSteps.acceptContactRequestOf(user);
    }

    @When("^Should see message with \"([^\"]*)\" first except commercial message$")
    public void shouldSeeMessageWithFirstExceptCommercialMessage(String user) {
        contactRequestEndUserSteps.shouldSeeMessageWithFirstExceptCommercialMessage(user);
    }

    @Then("^Should see message with same content of sent message$")
    public void shouldSeeMessageWithSameContentOfSentMessage() {
        contactRequestEndUserSteps.shouldSeeMessageWithSameContentOfSentMessage();
    }

    @And("^Should see \"([^\"]*)\" appear in log chat$")
    public void shouldSeeAppearInLogChat(String name) {
        contactRequestEndUserSteps.shouldSeeAppearInLogChat(name);
    }


    @Then("^Should see text on button change to \"([^\"]*)\"$")
    public void shouldSeeTextOnButtonChangeTo(String text) {
        contactRequestEndUserSteps.shouldSeeTextOnButtonChangeTo(text);
    }

    @Then("^Should see discuss and smile button$")
    public void shouldSeeDiscussAndSmileButton() {
        contactRequestEndUserSteps.shouldSeeDiscussAndSmileButton();
    }

    @When("^Should see request contact message \"([^\"]*)\" below profile avatar$")
    public void shouldSeeRequestContactMessageBelowProfileAvatar(String mess) {
        contactRequestEndUserSteps.shouldSeeRequestContactMessageBelowProfileAvatar(mess);
    }

    @Then("^Should see message \"([^\"]*)\" sent$")
    public void shouldSeeMessageSent(String text) {
        contactRequestEndUserSteps.shouldSendMessageAsUsual(text);
    }

    @When("^Do not see name of \"([^\"]*)\" on contact request list$")
    public void doNotSeeNameOfOnContactRequestList(String name) {
        contactRequestEndUserSteps.doNotSeeNameOfOnContactRequestList(name);
    }

    @When("^Click Discuss again with Woman that already delete message$")
    public void clickDiscussAgainWithWomanThatAlreadyDeleteMessage() {
        contactRequestEndUserSteps.clickDiscussAgainWithWomanThatAlreadyDeleteMessage();
    }

    @When("^Get profile mane on \"([^\"]*)\"$")
    public void getProfileManeOn(String element) {
        contactRequestEndUserSteps.getProfileManeOn(element);
    }

    @Then("^Should see woman name that deleted message on Message screen$")
    public void shouldSeeWomanNameThatDeletedMessageOnMessageScreen() {
        contactRequestEndUserSteps.shouldSeeWomanNameThatDeletedMessageOnMessageScreen();
    }

    @Then("^Do not see name of \"([^\"]*)\" on Message screen$")
    public void doNotSeeNameOfOnMessageScreen(String name) {
        contactRequestEndUserSteps.doNotSeeNameOfOnMessageScreen(name);
    }


    @When("^Log out current male account and login with woman account$")
    public void logOutCurrentMaleAccountAndLoginWithWomanAccount() {
        contactRequestEndUserSteps.logOutCurrentMaleAccountAndLoginWithWomanAccount();
    }


    @And("^Should see contact request is blocked$")
    public void shouldSeeContactRequestIsBlocked() {
        contactRequestEndUserSteps.shouldSeeContactRequestIsBlocked();
    }

    @When("^Search woman account \"([^\"]*)\" and send inspirational text$")
    public void searchWomanAccountAndSendInspirationalText(String womanAccount) throws AWTException {
        contactRequestEndUserSteps.searchWomanAccountAndSendInspirationalText(womanAccount);
    }

    @When("^Search woman account \"([^\"]*)\" and contact request$")
    public void searchWomanAccountAndContactRequest(String womanAccount) {
        contactRequestEndUserSteps.searchWomanAccountAndContactRequest(womanAccount);
    }

    @When("^Click on user profile link and should see discuss and smile button$")
    public void clickOnUserProfileLinkAndShouldSeeDiscussAndSmileButton() {
        contactRequestEndUserSteps.clickOnUserProfileLinkAndShouldSeeDiscussAndSmileButton();
    }


    @When("^Click to see profile of the man who send contact request$")
    public void clickToSeeProfileOfTheManWhoSendContactRequest() {
        contactRequestEndUserSteps.clickToSeeProfileOfTheManWhoSendContactRequest();
    }

    @Then("^The page shows popup$")
    public void thePageShowsPopup() {
        contactRequestEndUserSteps.thePageShowsPopup();
    }

    @Then("^The page dont show duplicate invitations$")
    public void thePageDontShowDuplicateInvitations() {
        contactRequestEndUserSteps.thePageDontShowDuplicateInvitations();
    }

    @Then("^The page shows a green accept button and a white refuse button in each invitations$")
    public void thePageShowsAGreenAcceptButtonAndAWhiteRefuseButtonInEachInvitations() {
        contactRequestEndUserSteps.thePageShowsAGreenAcceptButtonAndAWhiteRefuseButtonInEachInvitations();
    }

    @Then("^The request-contact page dont show this person$")
    public void theRequestContactPageDontShowThisPerson() {
        contactRequestEndUserSteps.theRequestContactPageDontShowThisPerson();
    }

    @And("^The message page have this person$")
    public void theMessagePageHaveThisPerson() {
        contactRequestEndUserSteps.theMessagePageHaveThisPerson();
    }

    @And("^The request-contact page still shows this person$")
    public void theRequestContactPageStillShowsThisPerson() {
        contactRequestEndUserSteps.theRequestContactPageStillShowsThisPerson();
    }

    @Then("^The message page dont have this person$")
    public void theMessagePageDontHaveThisPerson() {
        contactRequestEndUserSteps.theMessagePageDontHaveThisPerson();
    }

    @Then("^The page shows five last refusals profile$")
    public void thePageShowsFiveLastRefusalsProfile() {
        contactRequestEndUserSteps.thePageShowsFiveLastRefusalsProfile();
    }

    @Then("^The last refusals list dont show this person$")
    public void theLastRefusalsListDontShowThisPerson() {
        contactRequestEndUserSteps.theLastRefusalsListDontShowThisPerson();
    }

    @Then("^The last refusals list still show this person$")
    public void theLastRefusalsListStillShowThisPerson() {
        contactRequestEndUserSteps.theLastRefusalsListStillShowThisPerson();
    }

    @Then("^The page shows all invitations are present$")
    public void thePageShowsAllInvitationsArePresent() {
        contactRequestEndUserSteps.thePageShowsAllInvitationsArePresent();
    }

    @Then("^The Request Contact text have pink dot$")
    public void theRequestContactTextHavePinkDot() {
        contactRequestEndUserSteps.theRequestContactTextHavePinkDot();
    }

    @Then("^The Request Contact text dont have pink dot$")
    public void theRequestContactTextDontHavePinkDot() {
        contactRequestEndUserSteps.theRequestContactTextDontHavePinkDot();
    }

    @When("^Click Découvrir des profils on Croisez vos destins screen$")
    public void clickDécouvrirDesProfilsOnCroisezVosDestinsScreen() {
        contactRequestEndUserSteps.clickDécouvrirDesProfilsOnCroisezVosDestinsScreen();
    }

    @When("^Delete message of \"([^\"]*)\"$")
    public void deleteMessageOf(String name) {
        contactRequestEndUserSteps.deleteMessageOf(name);
    }

    @When("^Should not see woman name \"([^\"]*)\" on Cross Your Destinies screen$")
    public void shouldNotSeeWomanNameOnCrossYourDestiniesScreen(String name) {
        contactRequestEndUserSteps.shouldNotSeeWomanNameOnCrossYourDestiniesScreen(name);
    }

    @When("^Should see woman name \"([^\"]*)\" on Cross Your Destinies screen$")
    public void shouldSeeWomanNameOnCrossYourDestiniesScreen(String name) {
        contactRequestEndUserSteps.shouldSeeWomanNameOnCrossYourDestiniesScreen(name);
    }

    @When("^Should see woman name \"([^\"]*)\" on Message screen$")
    public void shouldSeeWomanNameOnMessageScreen(String name)  {
        contactRequestEndUserSteps.shouldSeeWomanNameOnMessageScreen(name);
    }

    @When("^Should see unread message of \"([^\"]*)\" on Message screen$")
    public void shouldSeeUnreadMessageOfOnMessageScreen(String name)  {
        contactRequestEndUserSteps.shouldSeeUnreadMessageOfOnMessageScreen(name);
    }

    @When("^Accept contact request of \"([^\"]*)\" to answer later$")
    public void acceptContactRequestOfToAnswerLater(String account)  {
        contactRequestEndUserSteps.acceptContactRequestOfToAnswerLater(account);
    }

    @When("^Refuse contact request of \"([^\"]*)\"$")
    public void refuseContactRequestOf(String account)  {
        contactRequestEndUserSteps.refuseContactRequestOf(account);
    }

    @Then("^Check if indicator display right for new contact request$")
    public void checkIfIndicatorDisplayRightForNewContactRequest() {
        contactRequestEndUserSteps.checkIfIndicatorDisplayRightForNewContactRequest();
    }

    @When("^Click on avatar on chat header$")
    public void clickOnAvatarOnChatHeader() {
        contactRequestEndUserSteps.clickOnAvatarOnChatHeader();
    }

    @When("^Click on avatar next to each chat message$")
    public void clickOnAvatarNextToEachChatMessage() {
        contactRequestEndUserSteps.clickOnAvatarNextToEachChatMessage();
    }

    @Then("^Refuse first cross and see Last five refusals button$")
    public void refuseFirstCrossAndSeeLastFiveRefusalsButton() {
        contactRequestEndUserSteps.refuseFirstCrossAndSeeLastFiveRefusalsButton();
    }
}

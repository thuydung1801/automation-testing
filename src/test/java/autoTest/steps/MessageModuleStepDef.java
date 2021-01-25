package autoTest.steps;

import autoTest.steps.serenity.MessageModuleEndUserSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.awt.*;

public class MessageModuleStepDef {
    @Steps
    MessageModuleEndUserSteps messageModuleEndUserSteps;

    @When("^Check if inspirational text in Chat field can change when choose another one$")
    public void checkIfInspirationalTextInChatFieldCanChangeWhenChooseAnotherOne() throws AWTException {
        messageModuleEndUserSteps.IfInspirationalTextInChatFieldCanChange();
    }

    @When("^Send inspirational text in Chat field and should see message is sent$")
    public void sendInspirationalTextInChatFieldAndShouldSeeMessageIsSent() {
        messageModuleEndUserSteps.sendInspirationalTextInChatField();
    }

    @When("^Should see message contain insipration text of Woman$")
    public void shouldSeeMessageContainInsiprationTextOfWoman() {
        messageModuleEndUserSteps.shouldSeeMessageContainInsiprationTextOfWoman();
    }

    @When("^Upload ephemeral picture$")
    public void uploadEphemeralPicture() throws AWTException {
        messageModuleEndUserSteps.uploadEphemeralPicture();
    }

    @Then("^Should see report a ephemeral picture modal close$")
    public void shouldSeeReportAEphemeralPictureModalClose() {
        messageModuleEndUserSteps.ReportAEphemeralPictureModalClose();
    }

    @When("^See the first ephemeral picture and click close$")
    public void seeTheFirstEphemeralPictureAndClickClose() {
        messageModuleEndUserSteps.seeTheFirstEphemeralPictureAndClickClose();
    }

    @Then("^Should see the second ephemeral picture$")
    public void shouldSeeTheSecondEphemeralPicture() {
        messageModuleEndUserSteps.shouldSeeTheSecondEphemeralPicture();
    }

    @Then("^Check if status of unread message picture is right$")
    public void checkIfStatusOfUnreadMessagePictureIsRight() {
        messageModuleEndUserSteps.checkIfStatusOfUnreadMessagePictureIsRight();
    }

    @Then("^Check if status of read message picture is right$")
    public void checkIfStatusOfReadMessagePictureIsRight() {
        messageModuleEndUserSteps.checkIfStatusOfReadMessagePictureIsRight();
    }

    @Then("^Showing conversation$")
    public void showingConversation() {
        messageModuleEndUserSteps.showingConversation();
    }

    @When("^Scroll special element \"([^\"]*)\"$")
    public void scrollSpecialElement(String element) throws AWTException {
        messageModuleEndUserSteps.scrollSpecialElement(element);
    }

    @Then("^The page show discussions that are sorted from the most recent to the oldest$")
    public void thePageShowDiscussionsThatAreSortedFromTheMostRecentToTheOldest() {
        messageModuleEndUserSteps.thePageShowDiscussionsThatAreSortedFromTheMostRecentToTheOldest();
    }

    @When("^Visiting one profile$")
    public void visitingOneProfile() {
        messageModuleEndUserSteps.visitingOneProfile();
    }

    @Then("^The page dont allow send an empty message$")
    public void thePageDontAllowSendAnEmptyMessage() {
        messageModuleEndUserSteps.thePageDontAllowSendAnEmptyMessage();
    }

    @Then("^The messages have unread-dot are not read$")
    public void theMessagesHaveUnreadDotAreNotRead() {
        messageModuleEndUserSteps.theMessagesHaveUnreadDotAreNotRead();
    }

    @Then("^The page shows \\+ten if more than ten messges$")
    public void thePageShowsTenIfMoreThanTenMessges() {
        messageModuleEndUserSteps.thePageShowsTenIfMoreThanTenMessges();
    }

    @Then("^The page check this account have more than ten not read messages$")
    public void thePageCheckThisAccountHaveMoreThanTenNotReadMessages() {
        messageModuleEndUserSteps.thePageCheckThisAccountHaveMoreThanTenNotReadMessages();
    }

    @When("^Click on first gif is \"([^\"]*)\"$")
    public void clickOnFirstGifIs(String value) {
        messageModuleEndUserSteps.clickOnFirstGifIs(value);
    }

    @Then("^The send button is disable$")
    public void theSendButtonIsDisable() {
        messageModuleEndUserSteps.theSendButtonIsDisable();
    }

    @Then("^The search gif textfield show text is hello$")
    public void theSearchGifTextfieldShowTextIsHello() {
        messageModuleEndUserSteps.theSearchGifTextfieldShowTextIsHello();
    }

    @Then("^The conversation have last row is hello$")
    public void theConversationHaveLastRowIsHello() {
        messageModuleEndUserSteps.theConversationHaveLastRowIsHello();
    }

    @Then("^Checking unread message list$")
    public void checkingUnreadMessageList() {
        messageModuleEndUserSteps.checkingUnreadMessageList();
    }

    @Then("^The page show all messages$")
    public void thePageShowAllMessages() {
        messageModuleEndUserSteps.thePageShowAllMessages();
    }

    @Then("^Number of unread messages have to correct$")
    public void numberOfUnreadMessagesHaveToCorrect() {
        messageModuleEndUserSteps.numberOfUnreadMessagesHaveToCorrect();
    }

    @When("^Click on the person have above name \"([^\"]*)\" in message list$")
    public void clickOnThePersonHaveAboveNameInMessageList(String name) {
        messageModuleEndUserSteps.clickOnThePersonHaveAboveNameInMessageList(name);
    }

    @Then("^The page show pop up request pay the fee$")
    public void thePageShowPopUpRequestPayTheFee() {
        messageModuleEndUserSteps.thePageShowPopUpRequestPayTheFee();
    }

    @Then("^The page the red button supprimer appears to the right of each discusses$")
    public void thePageTheRedButtonSupprimerAppearsToTheRightOfEachDiscusses() {
        messageModuleEndUserSteps.thePageTheRedButtonSupprimerAppearsToTheRightOfEachDiscusses();
    }

    @Then("^The page show green notification$")
    public void thePageShowGreenNotification() {
        messageModuleEndUserSteps.thePageShowGreenNotification();
    }

    @And("^This discustion dont show in message$")
    public void thisDiscustionDontShowInMessage() {
        messageModuleEndUserSteps.thisDiscustionDontShowInMessage();
    }


    @When("^Click on first delete in conversation is \"([^\"]*)\"$")
    public void clickOnFirstDeleteInConversationIs(String value) {
        messageModuleEndUserSteps.clickOnFirstDeleteInConversationIs(value);
    }

    @When("^Insert above deleted name into \"([^\"]*)\" Field \\(upd\\)$")
    public void insertAboveDeletedNameIntoFieldUpd(String value) {
        messageModuleEndUserSteps.insertAboveDeletedNameIntoFieldUpd(value);
    }

    @And("^Click on the profile that deleted discussion$")
    public void clickOnTheProfileThatDeletedDiscussion() {
        messageModuleEndUserSteps.clickOnTheProfileThatDeletedDiscussion();
    }

    @And("^This discussion dont have any discuss line$")
    public void thisDiscussionDontHaveAnyDiscussLine() {
        messageModuleEndUserSteps.thisDiscussionDontHaveAnyDiscussLine();
    }

    @Then("^The page still show discussion of Yassine_yes with \"([^\"]*)\"$")
    public void thePageStillShowDiscussionOfYassine_yesWith(String field) {
        messageModuleEndUserSteps.thePageStillShowDiscussionOfYassine_yesWith(field);
    }

    @When("^Click on the message with \"([^\"]*)\"$")
    public void clickOnTheMessageWith(String name) {
        messageModuleEndUserSteps.clickOnTheMessageWith(name);
    }

    @Then("^The page show message with last content is \"([^\"]*)\" with \"([^\"]*)\"$")
    public void thePageShowMessageWithLastContentIsWith(String content, String name) {
        messageModuleEndUserSteps.thePageShowMessageWithLastContentIsWith(content, name);
    }


    @And("^There is no duplicate log chat$")
    public void thereIsNoDuplicateLogChat() {
        messageModuleEndUserSteps.thereIsNoDuplicateLogChat();
    }

    @When("^CLick to next log chat and click back to log chat I was going to text$")
    public void clickToNextLogChatAndClickBackToLogChatIWasGoingToText() {
        messageModuleEndUserSteps.clickToNextLogChatAndClickBackToLogChatIWasGoingToText();
    }

    @When("^Click on last thumbnail in conversation$")
    public void clickOnLastThumbnailInConversation() { messageModuleEndUserSteps.clickOnLastThumbnailInConversation();
    }

    @Then("^The last message must be gif$")
    public void theLastMessageMustBeGif() { messageModuleEndUserSteps.theLastMessageMustBeGif();
    }

    @When("^Test$")
    public void test() {
        messageModuleEndUserSteps.test();
    }

    @Then("^Should show cup icon in conversation$")
    public void shouldShowCupIconInConversation() {
        messageModuleEndUserSteps.shouldShowCupIconInConversation();
    }

    @Then("^The page show virtual date information pop up$")
    public void thePageShowVirtualDateInformationPopUp() {
        messageModuleEndUserSteps.thePageShowVirtualDateInformationPopUp();
    }

    @Then("^The page show accept/refuse popup$")
    public void thePageShowAcceptRefusePopup() { messageModuleEndUserSteps.thePageShowAcceptRefusePopup();
    }

    @Then("^The message page show object at first thread \"([^\"]*)\"$")
    public void theMessagePageShowObjectAtFirstThread(String object) {
        messageModuleEndUserSteps.theMessagePageShowObjectAtFirstThread( object);
    }

//    @Then("^The page change to virtual date mode at accepter \"([^\"]*)\", \"([^\"]*)\"$")
//    public void thePageChangeToVirtualDateModeAtAccepter(String username, String password){
//        messageModuleEndUserSteps.thePageChangeToVirtualDateModeAtAccepter( username, password);
//    }
//
//    @And("^The page change to virtual date mode at sender \"([^\"]*)\", \"([^\"]*)\"$")
//    public void thePageChangeToVirtualDateModeAtSender(String username, String password) {
//        messageModuleEndUserSteps.thePageChangeToVirtualDateModeAtSender( username,  password);
//    }

    @Then("^The page change to virtual date mode \"([^\"]*)\", \"([^\"]*)\"$")
    public void thePageChangeToVirtualDateMode(String username, String password) {
        messageModuleEndUserSteps.thePageChangeToVirtualDateMode( username,  password);
    }

    @Then("^Show noti in conversation \"([^\"]*)\"$")
    public void showNotiInConversation(String noti){
        messageModuleEndUserSteps.showNotiInConversation( noti);
    }

    @Then("^Show noti in alert that contains \"([^\"]*)\"$")
    public void showNotiInAlertThatContains(String noti) {
        messageModuleEndUserSteps.showNotiInAlertThatContains( noti);
    }

    @When("^The page redirect to conversation with account name \"([^\"]*)\"$")
    public void thePageRedirectToConversationWithAccountName(String name) {
        messageModuleEndUserSteps.thePageRedirectToConversationWithAccountName( name);
    }

    @When("^Allowing micro access$")
    public void allowingMicroAccess() throws AWTException {
        messageModuleEndUserSteps.allowingMicroAccess();
    }

    @When("^Allowing location access$")
    public void allowingLocationAccess() throws AWTException {
        messageModuleEndUserSteps.allowingLocationAccess();
    }

    @Then("^Warning box with content \"([^\"]*)\" is displayed$")
    public void warningBoxWithContentIsDisplayed(String content){
        messageModuleEndUserSteps.warningBoxWithContentIsDisplayed(content);
    }

    @Then("^Check voice message display in thread chat list$")
    public void checkVoiceMessageDisplayInThreadChatList() {
        messageModuleEndUserSteps.checkVoiceMessageDisplayInThreadChatList();
    }

    @Then("^The page show pop up request post at least a picture$")
    public void thePageShowPopUpRequestPostAtLeastAPicture() {
        messageModuleEndUserSteps.thePageShowPopUpRequestPostAtLeastAPicture();
    }

    @When("^Send a voice message to \"([^\"]*)\"$")
    public void sendAVoiceMessageTo(String userName) {
        messageModuleEndUserSteps.sendAVoiceMessageTo(userName);
    }

    @Then("^Check time in counter and sent voice message length$")
    public void checkTimeInCounterAndSentVoiceMessageLength() {
        messageModuleEndUserSteps.checkTimeInCounterAndSentVoiceMessageLength();
    }

    @And("^Sending time and realtime$")
    public void sendingTimeAndRealtime() {
        messageModuleEndUserSteps.sendingTimeAndRealtime();
    }

    @When("^Choose cancel record$")
    public void chooseCancelRecord() {
        messageModuleEndUserSteps.chooseCancelRecord();
    }

    @When("^Record random seconds$")
    public void recordRandomSeconds() {
        messageModuleEndUserSteps.recordRandomSeconds();
    }

    @When("^Find element by Xpath and Scroll to user \"([^\"]*)\" and click$")
    public void findElementByXpathAndScrollToUserAndClick(String button) {
        messageModuleEndUserSteps.findElementByXpathAndScrollToUserAndClick(button);
    }

    @When("^Report a voice message should see popup message$")
    public void reportAVoiceMessageShouldSeePopupMessage() {
        messageModuleEndUserSteps.reportAVoiceMessageShouldSeePopupMessage();
    }

    @When("^Search account \"([^\"]*)\" and go to thread chat detail$")
    public void searchAccountAndGoToThreadChatDetail(String username) {
        messageModuleEndUserSteps.searchAccountAndGoToThreadChatDetail(username);
    }

    @When("^Check record end when go to other thread and comeback$")
    public void checkRecordEndWhenGoToOtherThreadAndComeback() {
        messageModuleEndUserSteps.checkRecordEndWhenGoToOtherThreadAndComeback();
    }

    @When("^Check record end when open new browser tab$")
    public void checkRecordEndWhenOpenNewBrowserTab() throws AWTException {
        messageModuleEndUserSteps.checkRecordEndWhenOpenNewBrowserTab();
    }

    @When("^Check record end when run in background$")
    public void checkRecordEndWhenRunInBackground() throws AWTException {
        messageModuleEndUserSteps.checkRecordEndWhenRunInBackground();
    }

    @When("^Click see unread message and check number of message with blue counter$")
    public void clickSeeUnreadMessageAndCheckNumberOfMessageWithBlueCounter() {
        messageModuleEndUserSteps.clickSeeUnreadMessageAndCheckNumberOfMessageWithBlueCounter();
    }

    @Then("^Reply last voice message and check send success$")
    public void replyLastVoiceMessageAndCheckSendSuccess() throws AWTException {
        messageModuleEndUserSteps.replyLastVoiceMessageAndCheckSendSuccess();
    }

    @Then("^Reply last gif message and check send success$")
    public void replyLastGifMessageAndCheckSendSuccess() throws AWTException {
        messageModuleEndUserSteps.replyLastGifMessageAndCheckSendSuccess();
    }

    @When("^Allowing micro access after close location perrmisson$")
    public void allowingMicroAccessAfterCloseLocationPerrmisson() throws AWTException {
        messageModuleEndUserSteps.allowingMicroAccessAfterCloseLocationPerrmisson();
    }

    @Then("^This message have feeling icon$")
    public void thisMessageHaveFeelingIcon() {
        messageModuleEndUserSteps.thisMessageHaveFeelingIcon();
    }

    @Then("^This message dont have feeling icon$")
    public void thisMessageDontHaveFeelingIcon() {
        messageModuleEndUserSteps.thisMessageDontHaveFeelingIcon();
    }

    @And("^The last message is \"([^\"]*)\"$")
    public void theLastMessageIs(String text)  {
        messageModuleEndUserSteps.theLastMessageIs( text);
    }

    @Then("^The reply icon is hide$")
    public void theReplyIconIsHide() {
        messageModuleEndUserSteps.theReplyIconIsHide();
    }

    @And("^The text and the time that has been replied must be correct$")
    public void theTextAndTheTimeThatHasBeenRepliedMustBeCorrect() {
        messageModuleEndUserSteps.theTextAndTheTimeThatHasBeenRepliedMustBeCorrect();
    }

    @Then("^The text reply message is sent$")
    public void theTextReplyMessageIsSent() {
        messageModuleEndUserSteps.theReplyMessageIsSent();
    }

    @When("^Click on received message$")
    public void clickOnReceivedMessage() {
        messageModuleEndUserSteps.clickOnReceivedMessage();
    }

    @Then("^The reply gif message is sent$")
    public void theReplyGifMessageIsSent() {
        messageModuleEndUserSteps.theReplyGifMessageIsSent();
    }

    @Then("^The reply voice message is sent$")
    public void theReplyVoiceMessageIsSent() {
        messageModuleEndUserSteps.theReplyVoiceMessageIsSent();
    }

    @Then("^The reply photo message is sent$")
    public void theReplyPhotoMessageIsSent() {
        messageModuleEndUserSteps.theReplyPhotoMessageIsSent();
    }

    @When("^The last message just sent is image$")
    public void theLastMessageJustSentIsImage() { messageModuleEndUserSteps.theLastMessageJustSentIsImage();
    }

    @When("^The image and the time that has been replied must be correct$")
    public void theImageAndTheTimeThatHasBeenRepliedMustBeCorrect() {
        messageModuleEndUserSteps.theImageAndTheTimeThatHasBeenRepliedMustBeCorrect();
    }

    @When("^The message is replied that is text$")
    public void theMessageIsRepliedThatIsText() {
        messageModuleEndUserSteps.theMessageIsRepliedThatIsText();
    }

    @When("^The message is replied that is image$")
    public void theMessageIsRepliedThatIsImage() {
        messageModuleEndUserSteps.theMessageIsRepliedThatIsImage();
    }

    @And("^The time send message is correct$")
    public void theTimeSendMessageIsCorrect() { messageModuleEndUserSteps.theTimeSendMessageIsCorrect();
    }
}

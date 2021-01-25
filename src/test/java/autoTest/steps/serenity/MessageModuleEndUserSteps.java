package autoTest.steps.serenity;

import autoTest.pages.MessageModule;

import java.awt.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class MessageModuleEndUserSteps {
    MessageModule messageModule;

    public void IfInspirationalTextInChatFieldCanChange() throws AWTException {
        assertThat(messageModule.IfInspirationalTextInChatFieldCanChange(), is(equalTo(true)));

    }

    public void sendInspirationalTextInChatField() {
        assertThat(messageModule.sendInspirationalTextInChatField(), is(equalTo(true)));
    }

    public void shouldSeeMessageContainInsiprationTextOfWoman() {
        assertThat(messageModule.shouldSeeMessageContainInsiprationTextOfWoman(), is(equalTo(true)));
    }

    public void uploadEphemeralPicture() throws AWTException {
        messageModule.uploadEphemeralPicture();
    }

    public void ReportAEphemeralPictureModalClose() {
        assertThat(messageModule.ReportAEphemeralPictureModalClose(), is(equalTo(true)));
    }

    public void seeTheFirstEphemeralPictureAndClickClose() {
        messageModule.seeTheFirstEphemeralPictureAndClickClose();
    }

    public void shouldSeeTheSecondEphemeralPicture() {
        assertThat(messageModule.shouldSeeTheSecondEphemeralPicture(), is(equalTo(true)));
    }

    public void checkIfStatusOfUnreadMessagePictureIsRight() {
        assertThat(messageModule.checkIfStatusOfUnreadMessagePictureIsRight(), is(equalTo(true)));
    }

    public void checkIfStatusOfReadMessagePictureIsRight() {
        assertThat(messageModule.checkIfStatusOfReadMessagePictureIsRight(), is(equalTo(true)));
    }

    public void showingConversation() {
        messageModule.showingConversation();
    }

    public void scrollSpecialElement(String element) throws AWTException {
        messageModule.scrollSpecialElement(element);
    }

    public void thePageShowDiscussionsThatAreSortedFromTheMostRecentToTheOldest() {
        messageModule.thePageShowDiscussionsThatAreSortedFromTheMostRecentToTheOldest();
    }

    public void visitingOneProfile() {
        messageModule.visitingOneProfile();
    }

    public void clickOnFirstGifIs(String value) {
        messageModule.clickOnFirstGifIs(value);
    }

    public void clickOnFirstDeleteInConversationIs(String value) {
        messageModule.clickOnFirstDeleteInConversationIs(value);
    }

    public void thePageDontAllowSendAnEmptyMessage() {
        messageModule.thePageDontAllowSendAnEmptyMessage();
    }

    public void theMessagesHaveUnreadDotAreNotRead() {
        messageModule.theMessagesHaveUnreadDotAreNotRead();
    }

    public void thePageShowsTenIfMoreThanTenMessges() {
        messageModule.thePageShowsTenIfMoreThanTenMessges();
    }

    public void thePageCheckThisAccountHaveMoreThanTenNotReadMessages() {
        messageModule.thePageCheckThisAccountHaveMoreThanTenNotReadMessages();
    }


    public void theSendButtonIsDisable() {
        messageModule.theSendButtonIsDisable();
    }

    public void theSearchGifTextfieldShowTextIsHello() {
        messageModule.theSearchGifTextfieldShowTextIsHello();
    }

    public void theConversationHaveLastRowIsHello() {
        messageModule.theConversationHaveLastRowIsHello();
    }

    public void checkingUnreadMessageList() {
        messageModule.checkingUnreadMessageList();
    }

    public void thePageShowAllMessages() {
        messageModule.thePageShowAllMessages();
    }

    public void numberOfUnreadMessagesHaveToCorrect() {
        messageModule.numberOfUnreadMessagesHaveToCorrect();
    }

    public void clickOnThePersonHaveAboveNameInMessageList(String name) {
        messageModule.clickOnThePersonHaveAboveNameInMessageList(name);
    }

    public void thePageShowPopUpRequestPayTheFee() {
        messageModule.thePageShowPopUpRequestPayTheFee();
    }

    public void thePageTheRedButtonSupprimerAppearsToTheRightOfEachDiscusses() {
        messageModule.thePageTheRedButtonSupprimerAppearsToTheRightOfEachDiscusses();
    }

    public void thePageShowGreenNotification() {
        messageModule.thePageShowGreenNotification();
    }

    public void thisDiscustionDontShowInMessage() {
        messageModule.thisDiscustionDontShowInMessage();
    }

    public void insertAboveDeletedNameIntoFieldUpd(String value) {
        messageModule.insertAboveDeletedNameIntoFieldUpd(value);
    }

    public void clickOnTheProfileThatDeletedDiscussion() {
        messageModule.clickOnTheProfileThatDeletedDiscussion();
    }

    public void thisDiscussionDontHaveAnyDiscussLine() {
        messageModule.thisDiscussionDontHaveAnyDiscussLine();
    }

    public void thePageStillShowDiscussionOfYassine_yesWith(String field) {
        messageModule.thePageStillShowDiscussionOfYassine_yesWith(field);
    }

    public void clickOnTheMessageWith(String name) {
        messageModule.clickOnTheMessageWith(name);
    }

    public void thePageShowMessageWithLastContentIsWith(String content, String name) {
        messageModule.thePageShowMessageWithLastContentIsWith(content, name);
    }

    public void thereIsNoDuplicateLogChat() {
        assertThat(messageModule.thereIsNoDuplicateLogChat(), is(equalTo(true)));
    }

    public void clickToNextLogChatAndClickBackToLogChatIWasGoingToText() {
        messageModule.clickToNextLogChatAndClickBackToLogChatIWasGoingToText();
    }

    public void clickOnLastThumbnailInConversation(){messageModule.clickOnLastThumbnailInConversation();}

    public void theLastMessageMustBeGif(){ messageModule.theLastMessageMustBeGif();}

    public void test() { messageModule.test(); }

    public void shouldShowCupIconInConversation(){ messageModule.shouldShowCupIconInConversation();
    }

    public void thePageShowVirtualDateInformationPopUp(){ messageModule.thePageShowVirtualDateInformationPopUp();}

    public void thePageShowAcceptRefusePopup(){ messageModule.thePageShowAcceptRefusePopup();}

    public void theMessagePageShowObjectAtFirstThread(String object){messageModule.theMessagePageShowObjectAtFirstThread(object);
    }

//    public void thePageChangeToVirtualDateModeAtAccepter(String username, String password){
//        messageModule.thePageChangeToVirtualDateModeAtAccepter( username,  password);
//    }
//
//    public void thePageChangeToVirtualDateModeAtSender(String username, String password){
//        messageModule.thePageChangeToVirtualDateModeAtSender( username,  password);
//    }

    public void thePageChangeToVirtualDateMode(String username, String password){
        messageModule.thePageChangeToVirtualDateMode( username,  password);
    }

    public void showNotiInConversation(String noti){
        messageModule.showNotiInConversation( noti);
    }

    public void showNotiInAlertThatContains(String noti){
        messageModule.showNotiInAlertThatContains( noti);
    }

    public void thePageRedirectToConversationWithAccountName(String name){
        messageModule.thePageRedirectToConversationWithAccountName( name);
    }
    public void allowingMicroAccess() throws AWTException {
        messageModule.allowingMicroAccess();
    }

    public void allowingLocationAccess() throws AWTException {
        messageModule.allowingLocationAccess();
    }

    public void warningBoxWithContentIsDisplayed(String content) {
        messageModule.warningBoxWithContentIsDisplayed(content);
    }

    public void checkVoiceMessageDisplayInThreadChatList() {
        messageModule.checkVoiceMessageDisplayInThreadChatList();
    }

    public void thePageShowPopUpRequestPostAtLeastAPicture() {
        messageModule.thePageShowPopUpRequestPostAtLeastAPicture();
    }

    public void sendAVoiceMessageTo(String userName) {
        messageModule.sendAVoiceMessageTo(userName);
    }

    public void checkTimeInCounterAndSentVoiceMessageLength() {
        messageModule.checkTimeInCounterAndSentVoiceMessageLength();
    }

    public void sendingTimeAndRealtime() {
        messageModule.sendingTimeAndRealtime();
    }

    public void chooseCancelRecord() {
        messageModule.chooseCancelRecord();
    }

    public void recordRandomSeconds() {
        messageModule.recordRandomSeconds();
    }

    public void findElementByXpathAndScrollToUserAndClick(String button) {
        messageModule.findElementByXpathAndScrollToUserAndClick(button);
    }

    public void reportAVoiceMessageShouldSeePopupMessage() {
        messageModule.reportAVoiceMessageShouldSeePopupMessage();
    }

    public void searchAccountAndGoToThreadChatDetail(String username) {
        messageModule.searchAccountAndGoToThreadChatDetail(username);
    }

    public void checkRecordEndWhenGoToOtherThreadAndComeback() {
        messageModule.checkRecordEndWhenGoToOtherThreadAndComeback();
    }

    public void checkRecordEndWhenOpenNewBrowserTab() throws AWTException {
        messageModule.checkRecordEndWhenOpenNewBrowserTab();
    }

    public void checkRecordEndWhenRunInBackground() throws AWTException {
        messageModule.checkRecordEndWhenRunInBackground();
    }

    public void clickSeeUnreadMessageAndCheckNumberOfMessageWithBlueCounter() {
        messageModule.clickSeeUnreadMessageAndCheckNumberOfMessageWithBlueCounter();
    }

    public void replyLastGifMessageAndCheckSendSuccess() throws AWTException {
        messageModule.replyLastGifMessageAndCheckSendSuccess();
    }

    public void replyLastVoiceMessageAndCheckSendSuccess() throws AWTException{
        messageModule.replyLastVoiceMessageAndCheckSendSuccess();
    }

    public void allowingMicroAccessAfterCloseLocationPerrmisson() throws AWTException {
        messageModule.allowingMicroAccessAfterCloseLocationPerrmisson();
    }

    public void thisMessageHaveFeelingIcon(){
        messageModule.thisMessageHaveFeelingIcon();
    }

    public void thisMessageDontHaveFeelingIcon(){
        messageModule.thisMessageDontHaveFeelingIcon();
    }

    public void theLastMessageIs(String text){
        messageModule.theLastMessageIs( text);
    }

    public void theReplyIconIsHide(){
        messageModule.theReplyIconIsHide();
    }

    public void theTextAndTheTimeThatHasBeenRepliedMustBeCorrect(){
        messageModule.theTextAndTheTimeThatHasBeenRepliedMustBeCorrect();
    }

    public void theReplyMessageIsSent(){
        messageModule.theReplyMessageIsSent();
    }

    public void clickOnReceivedMessage(){
        messageModule.clickOnReceivedMessage();
    }

    public void theReplyGifMessageIsSent(){
        messageModule.theReplyGifMessageIsSent();
    }

    public void theReplyPhotoMessageIsSent(){
        messageModule.theReplyPhotoMessageIsSent();
    }

    public void theReplyVoiceMessageIsSent(){
        messageModule.theReplyVoiceMessageIsSent();
    }

    public void theLastMessageJustSentIsImage(){ messageModule.theLastMessageJustSentIsImage();}

    public void theImageAndTheTimeThatHasBeenRepliedMustBeCorrect(){
        messageModule.theImageAndTheTimeThatHasBeenRepliedMustBeCorrect();
    }

    public void theMessageIsRepliedThatIsText(){
        messageModule.theMessageIsRepliedThatIsText();
    }

    public void theMessageIsRepliedThatIsImage(){
        messageModule.theMessageIsRepliedThatIsImage();
    }

    public void theTimeSendMessageIsCorrect(){ messageModule.theTimeSendMessageIsCorrect();}

}

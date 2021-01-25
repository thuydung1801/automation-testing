package autoTest.steps.serenity;

import autoTest.pages.FeatureForNonSubscriber;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class FeatureForNonSubscriberEndUserSteps {

    FeatureForNonSubscriber featureForNonSubscriber;

    public void shouldSeePaymentPage() {
        assertThat(featureForNonSubscriber.shouldSeePaymentPage(), is(equalTo(true)));
    }

    public void leaveAllFieldsInPaymentPageEmpty() {
        assertThat(featureForNonSubscriber.leaveAllFieldsInPaymentPageEmpty(), is(equalTo(true)));
    }

    public void fieldInvalidNumberOnPaymentPage() {
        assertThat(featureForNonSubscriber.fieldInvalidNumberOnPaymentPage(), is(equalTo(true)));
    }

    public void fillAlphabetOmPaymentPage() {
        assertThat(featureForNonSubscriber.fillAlphabetOmPaymentPage(), is(equalTo(true)));
    }

    public void fillSpecialCharactersOnPaymentPage() {
        assertThat(featureForNonSubscriber.fillSpecialCharactersOnPaymentPage(), is(equalTo(true)));
    }

    public void checkThatTheSixMonthOptionIsPreSelected() {
        assertThat(featureForNonSubscriber.checkThatTheSixMonthOptionIsPreSelected(), is(equalTo(true)));
    }

    public void clickContactRequestOrDiscussButton() {
        featureForNonSubscriber.clickContactRequestOrDiscussButton();
    }

    public void shouldSeeBlurMessage() {
        assertThat(featureForNonSubscriber.shouldSeeBlurMessage(), is(equalTo(true)));
    }

    public void canReadServiceMessages() {
        assertThat(featureForNonSubscriber.canReadServiceMessages(), is(equalTo(true)));
    }

    public void clickOnMessageUnread() {
        featureForNonSubscriber.clickOnMessageUnread();
    }

    public void shouldSeePayExpressInPaymentModal() {
        assertThat(featureForNonSubscriber.shouldSeePayExpressInPaymentModal(), is(equalTo(true)));
    }

    public void shouldSeeEnoughUnreadMessage() {
        assertThat(featureForNonSubscriber.shouldSeeEnoughUnreadMessage(), is(equalTo(true)));
    }

    public void iTryToClick(String button) {
        featureForNonSubscriber.iTryToClick(button);
    }

    public void shouldSeeModalPopupWithMessage(String text) {
        featureForNonSubscriber.shouldSeeModalPopupWithMessage(text);
    }

    public void iTryToSeeOtherMembersPictureFullPage() {
        featureForNonSubscriber.iTryToSeeOtherMembersPictureFullPage();
    }

    public void iTryToSmileMoreThanProfile() {
        featureForNonSubscriber.iTryToSmileMoreThanProfile();
    }
}
